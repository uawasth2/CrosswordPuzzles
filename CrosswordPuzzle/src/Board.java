
public class Board {
	private Box[][] gameboard;
	private String[] hints;
	
	public Board() {
		gameboard = new Box[11][11];
		for (int i = 0; i < gameboard.length; i++) {
			for (int j = 0; j < gameboard.length; j++) {
				gameboard[i][j] = new Box();
			}
		}
		gameboard[0][2].changeAnswer('p'); gameboard[0][4].changeAnswer('f'); gameboard[0][7].changeAnswer('v');
		gameboard[2][2].changeAnswer('p'); gameboard[2][4].changeAnswer('u'); gameboard[2][7].changeAnswer('g');
		gameboard[4][2].changeAnswer('o'); gameboard[4][4].changeAnswer('t');	gameboard[4][7].changeAnswer('t'); 
		gameboard[1][0].changeAnswer('f');gameboard[1][1].changeAnswer('l');gameboard[1][2].changeAnswer('o');
		gameboard[1][3].changeAnswer('u');gameboard[1][4].changeAnswer('r');gameboard[1][7].changeAnswer('e');
		gameboard[1][8].changeAnswer('g');gameboard[1][9].changeAnswer('g');gameboard[1][10].changeAnswer('s');
		gameboard[3][2].changeAnswer('c');
		gameboard[3][3].changeAnswer('h');
		gameboard[3][4].changeAnswer('i');
		gameboard[3][5].changeAnswer('c');
		gameboard[3][6].changeAnswer('k');
		gameboard[3][7].changeAnswer('e');
		gameboard[3][8].changeAnswer('n');
		gameboard[5][0].changeAnswer('p');
		gameboard[5][1].changeAnswer('o');
		gameboard[5][2].changeAnswer('r');
		gameboard[5][3].changeAnswer('k');
		gameboard[5][6].changeAnswer('p');
		gameboard[5][7].changeAnswer('a');
		gameboard[5][8].changeAnswer('s');
		gameboard[5][9].changeAnswer('t');
		gameboard[5][10].changeAnswer('a');
		gameboard[6][0].changeAnswer('i');
		gameboard[6][2].changeAnswer('n');
		gameboard[6][4].changeAnswer('s');
		gameboard[6][7].changeAnswer('b');

		gameboard[7][0].changeAnswer('z');
		gameboard[7][4].changeAnswer('t');
		gameboard[7][7].changeAnswer('l');
		
		gameboard[8][0].changeAnswer('z');
		gameboard[8][2].changeAnswer('c');
		gameboard[8][3].changeAnswer('h');
		gameboard[8][4].changeAnswer('e');
		gameboard[8][5].changeAnswer('e');
		gameboard[8][6].changeAnswer('s');
		gameboard[8][7].changeAnswer('e');
		
		gameboard[9][0].changeAnswer('a');
		gameboard[9][4].changeAnswer('a');
		gameboard[9][7].changeAnswer('s');

		gameboard[10][1].changeAnswer('m');
		gameboard[10][2].changeAnswer('i');
		gameboard[10][3].changeAnswer('l');
		gameboard[10][4].changeAnswer('k');
		
		hints = initHints();
	}

	public void printBoard() {
		for (int i = 0; i < gameboard.length; i++) {
			for (int j = 0; j < gameboard.length; j++) {
				if (gameboard[i][j].isUsed() == false) {
					System.out.print(" # ");
				} else {
					System.out.print(" " + gameboard[i][j].input + " ");
				}
			}
			System.out.println();
		}
	}
	
	public String[] initHints() {
		return new String[] {"Across","(1,0) Used for baking","(1,7) Protein in a shell","(3,2) poultry",
				"(5,0) from a pig","(5,6) great with sauce","(8,2) american or swiss","(10,1) liquid dairy",
				"Down","(0,2) movie snack","(0,4) best when ripe","(0,7) green is good","(5,0) cheesy pie","(6,4) t-bone"};
	}
	
	public void printHints() {
		for (int i = 0; i < hints.length; i++) {
			System.out.println(hints[i]);
		}
	}
	
	public void inputAnswer(int a, int b, char c) {
		gameboard[a][b].input = c;
	}
	
	public boolean inputAcross(int a, int b, String input) {
		if (a > gameboard.length || b > gameboard.length) {
			return false;
		}
		char[] charInput = input.toCharArray();
		int index = 0;
		for (int i = b; i < charInput.length + b; i++) {
			if (i >= gameboard.length || gameboard[a][i].isUsed() == false) {
				break;
			}
			gameboard[a][i].input = charInput[index];
			index++;
		}
		return true;
	}
	
	public boolean inputDown(int a, int b, String input) {
		if (a > gameboard.length || b > gameboard.length) {
			return false;
		}
		char[] charInput = input.toCharArray();
		int index = 0;
		for (int i = a; i < charInput.length + a; i++) {
			if (i > gameboard.length || gameboard[i][b].isUsed() == false) {
				break;
			}
			gameboard[i][b].input = charInput[index];
			index++;
		}
		return true;
	}
	public boolean isGameOver() {
		boolean ended = true;
		for (int i = 0; i < gameboard.length; i++) {
			for (int j = 0; j < gameboard.length; j++) {
				if (gameboard[i][j].isUsed()) {
					if (gameboard[i][j].getAnswer() != gameboard[i][j].input) {
						ended = false;
					}
				}
			}
		}
		return ended;
	}
}
