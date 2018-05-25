package gioco;

public class RappresentazioneTestuale {
	static void menu() {

		System.out.println(" 1.Mostra griglia \n 2.Muovi \n 3.Mostra info giocatori \n 0.Esci ");

	}

	public static void menuMosse() {
		System.out.println("Dove ti vuoi muovere? nord(8),sud(2),est(6),ovest(4)");
	}
	public static void scegliGiocatore(){
		System.out.println("Quale personaggio vuoi essere?\n0.Elfo\n1.Gigante\n2.Mago\n3.Guerriero");
		
	}
	public static void usoPozione(){
		System.out.println("E' stata usata la pozione!");
	}
	public static char usoGemma(){
		System.out.println("Possiedi una gemma,vuoi usarla? s/n");
		return Test.scanner.nextLine().charAt(0);
	}

}
