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
				
//				row = scan.nextInt() - 1;
//				column = scan.nextInt() - 1;
				
				row = scan.nextInt();
				
			} while (!game.placeMark(row));
			
			
		} while (!(game.checkForWin() || game.isBoardFull()));
		
		System.out.println("Current board layout:");
		game.printBoard();
		
		if (game.checkForWin()) {
			
			game.changePlayer();
			System.out.println(game.getCurrentPlayerMark() + " Wins!");
			
		} else {

			System.out.println("Tie Game!");
		}
		
		scan.close();
	}

}
