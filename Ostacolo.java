package gioco;

public interface Ostacolo {
	String getSimbolo();
	static void creaOstacolo(TavoloDaGioco griglia) {
		Foresta.creaOstacolo(griglia);
	}

}
