package gioco;

import java.util.Random;

public class Gemma extends Elemento {
	public Gemma(TavoloDaGioco griglia) {
		super(griglia);
	}

	@Override
	public String getSimbolo() {
		return "*";
	}

	public static void crea(TavoloDaGioco griglia) {
		Random r = new Random();
		for (int i = 0; i < 4; i++) {
			int x, y;
			do {
				x = r.nextInt(10);
				y = r.nextInt(10);
			} while (griglia.occupata(x, y));
			new Gemma(griglia).setPosizione(x, y);
		}
	}

	@Override
	public boolean collisione(Elemento elemento) {
		if (elemento instanceof Giocatore) {
			Giocatore giocatore = (Giocatore) elemento;
			giocatore.incrementagemme();
			rimuoviElemento();
			return true;
		}
		return false;
	}

//	@Override
//	public int getId() {
//		return 0;
//	}
}
