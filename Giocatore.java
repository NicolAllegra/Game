package gioco;

public class Giocatore extends Elemento {
	private static Giocatore giocatoreCorrente = null;

	Dado dado = new Dado();
	// inizio
	private int id;
	private int patrimonio = 0;
	private int xOrig;
	private int yOrig;
	// serie 3
	private int numero_gemme = 0;
	private int numero_pozioni = 0;
	// serie 4
	private int velocità;
	private int forza;
	private boolean magia;

	// Costruttore per giocatore X e Y
	public Giocatore(TavoloDaGioco griglia, int id, int xOrig, int yOrig) {
		super(griglia);
		this.id = id;
		this.xOrig = xOrig;
		this.yOrig = yOrig;

		setPosizione(xOrig, yOrig);
	}

	// costruttore per altri giocatori
	public Giocatore(TavoloDaGioco griglia, int id, int xOrig, int yOrig, int velocità, int forza, boolean magia) {
		super(griglia);
		this.id = id;
		this.xOrig = xOrig;
		this.yOrig = yOrig;
		this.setVelocità(velocità);
		this.setForza(forza);
		this.setMagia(magia);

		setPosizione(xOrig, yOrig);
	}

	public static void setGiocatoreCorrente(int i) {
		Giocatore.giocatoreCorrente = Partita.giocatori[i];
	}

	public static Giocatore getGiocatoreCorrente() {
		return giocatoreCorrente;
	}

	public int getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(int patrimonio) {
		this.patrimonio = patrimonio;
	}

	public int getNumero_gemme() {
		return numero_gemme;
	}

	public void setNumero_gemme(int numero_gemme) {
		this.numero_gemme = numero_gemme;
	}

	public int getNumero_pozioni() {
		return numero_pozioni;
	}

	public void setNumero_pozioni(int numero_pozioni) {
		this.numero_pozioni = numero_pozioni;
	}

	public int getVelocità() {
		return velocità;
	}

	public void setVelocità(int velocità) {
		this.velocità = velocità;
	}

	public int getForza() {
		return forza;
	}

	public void setForza(int forza) {
		this.forza = forza;
	}

	public boolean isMagia() {
		return magia;
	}

	public void setMagia(boolean magia) {
		this.magia = magia;
	}

	@Override
	public String toString() {
		String s1 = this.getSimbolo() + ": ";
		String s2 = "Numero delle monete:" + getPatrimonio();
		String s3 = " Numero di gemme:" + getNumero_gemme();
		String s4 = " Numero di pozioni:" + getNumero_pozioni();
		return s1 + s2 + s3 + s4;
	}

	public void muovi() {
		Giocatore giocatore = Giocatore.getGiocatoreCorrente();
		System.out.println(giocatore.getSimbolo());
		int num_mosse = dado.lanciaDado(giocatore.getVelocità());
		System.out.println(" " + dado);
		for (int i = num_mosse; i > 0; i--) {
			System.out.println("Hai ancora a disposizione " + i + " mosse");
			RappresentazioneTestuale.menuMosse();
			int direzione = Test.scanner.nextInt();
			Test.scanner.nextLine();

			switch (direzione) {
			case 8:
				// Nord
				muoviNord();
				break;
			case 2:
				// Sud
				muoviSud();
				break;
			case 4:
				// Ovest
				muoviOvest();
				break;
			case 6:
				// Est
				muoviEst();
				break;
			default:
				System.out.println("Non valido!");
				break;
			}

		}
		Giocatore.setGiocatoreCorrente((Partita.turno++) % 2);
	}

	private void muoviEst() {
		int x = getX();
		if (x == 9)
			x = 0;
		else
			x++;
		gestisciMovimento(x, getY(), 'e');
	}

	private void muoviOvest() {
		int x = getX();
		if (x == 0)
			x = 9;
		else
			x--;
		gestisciMovimento(x, getY(), 'o');
	}

	private void muoviSud() {
		int y = getY();
		if (y == 9)
			y = 0;
		else
			y++;

		gestisciMovimento(getX(), y, 's');
	}

	private void muoviNord() {
		int x = getX();
		int y = getY();
		if (y == 0)
			y = 9;
		else
			y--;

		gestisciMovimento(x, y, 'n');
	}

	private void gestisciMovimento(int x, int y, char movimento) {
		if (!getGriglia().occupata(x, y))
			modificaPosizione(x, y);
		else {
			Elemento elemento = getGriglia().getElemento(x, y);
			if (elemento.collisione(this))
				modificaPosizione(x, y);
			// controllo se il giocatore è un mago e se incontra un ostacolo
			if ((this.magia) && (elemento instanceof Ostacolo)) {

				switch (movimento) {
				// se si vuole andare a nord e c'è ostacolo
				case 'n':
					if (elemento.getY() == 0)
						this.gestisciMovimento(this.getX(), 9, 'n');
					else
						this.gestisciMovimento(this.getX(), (elemento.getY() - 1), 'n');
					break;
				// se si vuole andare a sud e c'è ostacolo
				case 's':
					if (elemento.getY() == 9)
						this.gestisciMovimento(this.getX(), 0, 'n');
					else
						this.gestisciMovimento(this.getX(), (elemento.getY() - 1), 's');
					break;
				// se si vuole andare a ovest e c'è ostacolo
				case 'o':
					if (elemento.getX() == 0)
						this.gestisciMovimento(9, this.getY(), 'o');
					else
						this.gestisciMovimento((elemento.getX() - 1), this.getY(), 'o');
					break;
				// se si vuole andare a est
				case 'e':
					if (elemento.getX() == 9)
						this.gestisciMovimento(0, this.getY(), 'o');
					else
						this.gestisciMovimento((elemento.getX() - 1), this.getY(), 'e');
					break;
				default:
				}
			} else {
				modificaPosizione(x, y);
			}
		}
	}

	@Override
	public boolean collisione(Elemento elemento) {
		if (!(elemento instanceof Giocatore)) {
			return false;
		}

		Giocatore giocatore = (Giocatore) elemento;
		// l'oggetto this è quello a cui sto andando addosso mentre l'altro è il
		// giocatore corrente
		int lancioThis, lancioCorr;

		do {
			lancioThis = dado.lanciaDado(this.getForza());
			System.out.println("Giocatore:" + this.getSimbolo() + " " + dado);
			lancioCorr = dado.lanciaDado(giocatore.getForza());
			System.out.println("Giocatore:" + giocatore.getSimbolo() + " " + dado);
		} while (lancioThis == lancioCorr);

		// Se giocatore vince -> giocatore perdente all'inizio, giocatore
		// vincente avanza

		if (lancioCorr < lancioThis) {
			// giocatore corrente perde
			giocatore.muoviPosizioneOriginale();
			giocatore.decrementaPatrimonio();
			this.incrementaPatrimonio();
			return false;
		} else if (lancioCorr > lancioThis) {
			// giocatore avversario perde
			muoviPosizioneOriginale();
			this.decrementaPatrimonio();
			giocatore.incrementaPatrimonio();
			return true;
		}
		if (giocatore.numero_pozioni > 0) {
			giocatore.decrementaPozioni();
			this.decrementaPatrimonio();
			this.muoviPosizioneOriginale();
			RappresentazioneTestuale.usoPozione();
			return true;
		}
		if (this.numero_gemme > 0) {
			char scelta = RappresentazioneTestuale.usoGemma();

			do {
				switch (scelta) {
				case 's':
					this.decrementaGemme();
					this.posizioneRandom();

					return true;
				case 'n':
					break;

				}
			} while ((scelta != 's') || (scelta != 'n'));
		}
		return true;
	}

	private void muoviPosizioneOriginale() {
		modificaPosizione(xOrig, yOrig);
	}

	public void incrementaPatrimonio() {
		setPatrimonio(getPatrimonio() + 1);
	}

	public void decrementaPatrimonio() {
		setPatrimonio(getPatrimonio() - 1);
	}

	public void incrementapozioni() {
		this.numero_pozioni++;
	}

	public void decrementaPozioni() {
		this.numero_pozioni--;
	}

	public void incrementagemme() {
		this.numero_gemme++;
	}

	public void decrementaGemme() {
		this.numero_gemme--;
	}

	@Override
	public String getSimbolo() {
		if (id == 0)
			return "X";
		if (id == 1)
			return "Y";
		return "";
	}

}
