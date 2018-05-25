package gioco;

import java.util.Random;

public abstract class Elemento {
	private TavoloDaGioco griglia;
	private int x;
	private int y;

	public Elemento(TavoloDaGioco griglia) {
		this.griglia = griglia;
	}

	public abstract String getSimbolo();

	//public abstract int getId();

	public abstract boolean collisione(Elemento elemento);

	public void rimuoviElemento() {
		griglia.rimuovi(x, y);
		griglia = null;
		x = 0;
		y = 0;
	}

	protected void setPosizione(int x, int y) {
		this.x = x;
		this.y = y;
		griglia.aggiungi(this, x, y);
	}

	protected void modificaPosizione(int x, int y) {
		griglia.rimuovi(this.x, this.y);
		setPosizione(x, y);
	}

	protected void posizioneRandom() {
		Random r = new Random();
		do {
			x = r.nextInt(10);
			y = r.nextInt(10);
		} while (griglia.occupata(x, y));
		modificaPosizione(x, y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	protected TavoloDaGioco getGriglia() {
		return griglia;
	}

}
