package gioco;
import java.util.Random;

public class Foresta extends Elemento implements Ostacolo{
	public Foresta(TavoloDaGioco griglia) {
		super(griglia);
	
	}

	@Override
	public String getSimbolo() {
		return "%";
	}

	@Override
	public boolean collisione(Elemento elemento) {
		if(!(elemento instanceof Mago))
				return false;
		return true;
	}
	
	public static void creaOstacolo(TavoloDaGioco griglia) {
		Random r = new Random();
		for (int i = 0; i < 3; i++) {
			int x, y;
			do {
				x = r.nextInt(10);
				y = r.nextInt(10);
			} while (griglia.occupata(x, y));
			new Foresta(griglia).setPosizione(x, y);
		}
	}

//	@Override
//	public int getId() {
//		return 0;
//	}

}
