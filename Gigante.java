package gioco;

public class Gigante extends Giocatore {
	public Gigante(TavoloDaGioco griglia, int id, int xOrig, int yOrig) {
		super(griglia, id, xOrig, yOrig, 2, 9, false);
	}

	@Override
	public String getSimbolo() {
		return "G";
	}

}
