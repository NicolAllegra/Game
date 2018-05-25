package gioco;

public class Mago extends Giocatore {
	public Mago(TavoloDaGioco griglia, int id, int xOrig, int yOrig) {
		super(griglia, id, xOrig, yOrig, 5, 4, true);
	}

	@Override
	public String getSimbolo() {
		return "M";
	}

}
