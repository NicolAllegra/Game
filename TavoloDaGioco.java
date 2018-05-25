package gioco;

public class TavoloDaGioco {
	private Elemento[][] griglia = new Elemento[10][10];

	public void aggiungi(Elemento giocatore, int x, int y) {
		griglia[y][x] = giocatore;
	}

	public boolean occupata(int x, int y) {
		return griglia[y][x] != null;
	}

	public void mostra() {
		for(int i=0; i<10*4+1; i++){
			System.out.print("-");
		}
		System.out.println("");
		
		for(int i=0; i<10; i++){
			System.out.print("|");
			for(int j=0; j<10; j++){
				if(griglia[i][j]==null){
					System.out.print("   |");
				}
				else{
					System.out.print(" "+griglia[i][j].getSimbolo()+" |");
				}
			}
			System.out.println("");
			
			for(int j=0; j<10*4+1; j++){
				System.out.print("-");
			}
			System.out.println("");
		}
	}

	public void rimuovi(int x, int y) {
		griglia[y][x] = null;
	}

	public Elemento getElemento(int x, int y) {
		return griglia[y][x];
	}

}
