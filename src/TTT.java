
public class TTT {
	
	private char[][] board;			//The game board.
	private int rows;
	private int columns;
	private char currentPlayerMark;	//Hold either an 'x' or 'o'.
	
	
	public TTT() {
		rows = 3;
		columns = 3;

		
	}

	public void initializeBoard() {
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				
				board[i][j] = '-';
			}
		}
	}
	
	public void printBoard() {
		
		System.out.println("-------------");
		
		for (int i = 0; i < rows; i++) {
			System.out.println("| ");
			
			for (int j = 0; j < columns; j++) {
				System.out.println(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}
	
	public boolean isBoardFull() {
		
	}
	
	public boolean checkForWin() {
		
		return checkColumnsForWin() || checkRowsForWin() || checkDiagonalsForWin();
	}
	
	private boolean checkRowsForWin() {
		
		boolean isWon = true;
		
		for (int i = 0; i < board.length; i++) {
			isWon = checkRowCol(board[i][1], board[i][2], board[i][3]);
		}
		
	}
	
	private boolean checkColumnsForWin() {
		
	}
	
	private boolean checkDiagonalsForWin() {
		
	}
	
	private boolean checkRowCol(char c1, char c2, char c3) {
		
	}
	
	
}
