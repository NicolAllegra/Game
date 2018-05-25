package gioco;

public class Elfo extends Giocatore {
	public Elfo(TavoloDaGioco griglia, int id, int xOrig, int yOrig) {
		super(griglia, id, xOrig, yOrig, 9, 3, false);
	}

	@Override
	public String getSimbolo() {
		return "E";
	}

}
