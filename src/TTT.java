
/**
 * @author ohady
 *
 */
public class TTT {

	private int rows;
	private int columns;
	private char[][] board; // The game board.
	private char currentPlayerMark; // Hold either an 'x' or 'o'.

	public TTT() {
		rows = 3;
		columns = 3;
		board = new char[rows][columns];
		currentPlayerMark = 'X';

		initializeBoard();
	}

	public char getCurrentPlayerMark() {
		return currentPlayerMark;
	}

	public void initializeBoard() {
		//char c = '0';
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				
				// c = (3*i) + j)
				board[i][j] = '-'; //instead put c to number places.
			}
		}
	}
	

	/**
	 * Print the board.
	 */
	public void printBoard() {

		System.out.println("-------------");

		for (int i = 0; i < rows; i++) {
			System.out.print("| ");

			for (int j = 0; j < columns; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}
	
	public boolean isBoardFull() {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '-') {

					return false;
				}
			}
		}

		return true;
	}

	/**
	 * @return if there is a possible row\column\diagonal with the same value.
	 */
	public boolean checkForWin() {

		return checkColumnsForWin() || checkRowsForWin() || checkDiagonalsForWin();
	}

	/**
	 * @return if there is exist a row with the same value.
	 */
	private boolean checkRowsForWin() {

		boolean isWon = false;

		for (int i = 0; (i < board.length) && (isWon != true); i++) {
			isWon = checkRowCol(board[i][0], board[i][1], board[i][2]);
		}

		return isWon;
	}

	/**
	 * @return if there is exist a column with the same value.
	 */
	private boolean checkColumnsForWin() {

		boolean isWon = false;

		for (int i = 0; (i < board.length) && (isWon != true); i++) {
			isWon = checkRowCol(board[0][i], board[1][i], board[2][i]);
		}

		return isWon;
	}

	/**
	 * @return if there is exist a diagonal with the same value.
	 */
	private boolean checkDiagonalsForWin() {

		return checkRowCol(board[0][0], board[1][1], board[2][2]) || checkRowCol(board[0][2], board[1][1], board[2][0]);
	}

	/**
	 * Check if the 3 inputs are same value and not '-'.
	 * 
	 * @param c1 First location.
	 * @param c2 Second location.
	 * @param c3 Third location.
	 * @return true if all the 3 inputs are same value and not '-'.
	 */
	private boolean checkRowCol(char c1, char c2, char c3) {

		if (c1 == '-') {
			return false;
		}

		return (c1 == c2) && (c2 == c3);
	}

	public void changePlayer() {

		if (currentPlayerMark == 'X') {

			currentPlayerMark = 'O';

		} else {

			currentPlayerMark = 'X';
		}
	}

	/**
	 * Place the correct letter onto the specified row 
	 * and column in the board variable.
	 * 
	 * @param row The row in the board.
	 * @param col The column in the board.
	 * @return
	 */
	public boolean placeMark(int row, int col) {
		
		// Out of bounds.
		if ((row < 0) && (row >= rows) && (col < 0) && (col >= columns)) {
			return false;
		}

		// Not available place.
		if (board[row][col] != '-') {
			return false;
		}

		board[row][col] = currentPlayerMark;

		return true;
	}
}
