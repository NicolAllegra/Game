package gioco;

public class Guerriero extends Giocatore {
	public Guerriero(TavoloDaGioco griglia, int id, int xOrig, int yOrig) {
		super(griglia, id, xOrig, yOrig, 6, 8, false);
	}

	@Override
	public String getSimbolo() {
		return "U";
	}

}
