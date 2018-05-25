package gioco;

import java.util.Random;

public class Dado {
	private int valore = 0;

	public int getValore() {
		return valore;
	}

	public void setValore(int valore) {
		this.valore = valore;
	}

	public int lanciaDado() {
		Random r = new Random();
		valore = r.nextInt(6) + 1;
		return valore;
	}

	//Lancio del dado in base alla velocità del personaggio
	public int lanciaDado(int valoremassimo) {
		Random r = new Random();
		valore = r.nextInt(valoremassimo) + 1;
		return valore;
	}

	public String toString() {
		return "Risultato del lancio " + valore;
	}

}
