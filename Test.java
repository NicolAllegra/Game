package gioco;

import java.util.Scanner;

public class Test {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println(
				"Benvenuto nel gioco, si sfideranno due giocatori!\nScegli il tuo giocatore sapendo che l'elfo è molto veloce, il mago ha la possibilta di saltare ostacali,il guerriero e il gigante sono forti");
		System.out.println(
				"La foresta (%) e la roccia (&) sono ostacoli\nCon le pozioni (£) si vince immediatamente la sfida, con le gemme(*) si può evitare la sfida");
		System.out.println("Raccogli più monete che puoi e rubale al tuo avversario vincendo le sfide");
		Partita partita = new Partita();
		partita.inizio();
		partita.gioca();

		scanner.close();
	}

}
