package gioco;

import java.util.Random;

public class Moneta extends Elemento {
	public Moneta(TavoloDaGioco griglia) {
		super(griglia);
	}

	@Override
	public String getSimbolo() {
		return "$";
	}

	@Override
	public boolean collisione(Elemento elemento) {
		if (elemento instanceof Giocatore) {
			Giocatore giocatore = (Giocatore) elemento;
			giocatore.incrementaPatrimonio();
			rimuoviElemento();
			return true;
		}
		return false;
	}

	public static void crea(TavoloDaGioco griglia) {
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			int x, y;
			do {
				x = r.nextInt(10);
				y = r.nextInt(10);
			} while (griglia.occupata(x, y));
			new Moneta(griglia).setPosizione(x, y);
		}
	}

//	@Override
//	public int getId() {
//		return 0;
//	}

}
