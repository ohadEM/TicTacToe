import java.util.Scanner;

public class Main {
	
	private static int row;
	private static int column;

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		TTT game = new TTT();
		
		System.out.println("Tic Tac Toe!");
		
		do {
			
			System.out.println("Current board layout:");
			game.printBoard();
			
			do {
				System.out.println("Player " + game.getCurrentPlayerMark() + 
						", enter an empty row and column to place your mark!");
				
				row = scan.nextInt() - 1;
				column = scan.nextInt() - 1;
				
			} while (!game.placeMark(row, column));
			
			
		} while (game.checkForWin() || game.isBoardFull());
		
		if (game.checkForWin()) {
			
			System.out.println("Current board layout:");
			
			game.printBoard();
			game.changePlayer();
			System.out.println(game.getCurrentPlayerMark() + " Wins!");
			
		} else {

			System.out.println("Tie Game!");
		}
		
		scan.close();
	}

}
