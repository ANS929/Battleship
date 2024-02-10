import java.util.Scanner;

// main class for executing the battleship game
public class Game {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// initialize board and generate battleships of different sizes
		Board board = new Board(10, 10);
		board.generateBoard();
		board.generateSmallBattleships();
		board.generateMediumBattleships();
		board.generateLargeBattleships();

		// input player names
		System.out.println("Enter a name for Player 1: ");
		String p1Name = scanner.nextLine();
		System.out.println("Enter a name for Player 2: ");
		String p2Name = scanner.nextLine();

		// initialize players
		Player player1 = new Player(p1Name, board);
		Player player2 = new Player(p2Name, board);

		Player currentPlayer = player1;

		// game loop
		while (true) {
			System.out.println(currentPlayer.getName() + "'s turn");
			System.out.println(board.toString());

			int row;
			int column;

			// take player input for row and column
			do {
				System.out.println("Enter a row: ");
				row = scanner.nextInt();
				System.out.println("Enter a column: ");
				column = scanner.nextInt();
				break;

			} while (true);

			// take turn and check for game end
			if (currentPlayer.takeTurn(row, column)) {
				System.out.println(currentPlayer.getName() + " wins!");
				break;
			}
			// print both player's scores
			System.out.println("Score: ");
			System.out.println(player1.getName() + ": " + player1.getScore());
			System.out.println(player2.getName() + ": " + player2.getScore());

			// switch to other player
			if (currentPlayer == player1) {
				currentPlayer = player2;
			} else {
				currentPlayer = player1;
			}

		}
		scanner.close();
	}
}