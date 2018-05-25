package gioco;

public class Partita {
	public static int turno=1;//per vedere a quale giocatore tocca
	public static Giocatore[] giocatori;
	private TavoloDaGioco griglia=new TavoloDaGioco();
	
	public void inizio(){
		giocatori=new Giocatore[2];
			int posx = 0, posy = 0;
			for (int i = 0; i < 2; i++) {
				if (i == 0) {
					posx = 9;
					posy = 0;
				}
				if (i == 1) {
					posx = 0;
					posy = 9;
				}

				RappresentazioneTestuale.scegliGiocatore();
				int scelta = Test.scanner.nextInt();

				switch (scelta) {
				case 0:
					Elfo elfo = new Elfo(griglia, i, posy, posx);
					giocatori[i] = elfo;
					break;
				case 1:
					Gigante gigante = new Gigante(griglia, i, posy, posx);
					giocatori[i] = gigante;
					break;
				case 2:
					Mago mago = new Mago(griglia, i, posy, posx);
					giocatori[i] = mago;
					break;
				case 3:
					Guerriero guerriero = new Guerriero(griglia, i, posy, posx);
					giocatori[i] = guerriero;
					break;
				default:
				}
				
			}
		Moneta.crea(griglia);
		Pozione.crea(griglia);
		Gemma.crea(griglia);
		Ostacolo.creaOstacolo(griglia);
		Giocatore.setGiocatoreCorrente(0);
	
	}
	public void gioca(){
		int scelta;
		do{
		RappresentazioneTestuale.menu();
		scelta=Test.scanner.nextInt();
		Test.scanner.nextLine();
		switch(scelta){
		case 1:
			griglia.mostra();
			break;
		case 2:
			Giocatore.getGiocatoreCorrente().muovi();
			griglia.mostra();
			break;
		case 3:
			for(int j=0;j<giocatori.length;j++)
			{
				System.out.println(giocatori[j]);
			}
			break;
		}
			
	}while(scelta!=0);

}
}
