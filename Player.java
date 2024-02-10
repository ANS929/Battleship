public class Player {

	// attributes
	private Board board;
	private String name;
	private int score;

	// constructor
	public Player(String name, Board board) {
		this.name = name;
		this.board = board;
		this.score = 0;
	}

	// getters
	public Board getBoard() {
		return board;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	// setter
	public void setScore(int score) {
		this.score = score;
	}

	// method for what happens during a turn
	public boolean takeTurn(int row, int column) {
		row = row - 1;
		column = column - 1;
		Square square = this.board.getBoard()[row][column];

		// check if the square has already been shot at
		if (square.getHasShot()) {
			System.out.println("You already shot here. You lose your turn.");
			return false;
		}

		// mark the selected square as shot
		square.setHasShot(true);

		// check if the selected square has a battleship
		if (square.getHasShip()) {
			Battleship battleship = square.getBattleship();

			// if a ship is hit but not sunk, decrease its health
			if (!battleship.isSunk()) {
				battleship.decreaseHealth();

				// if a ship is sunk, increase the score of the player who sank it
				if (battleship.isSunk()) {
					System.out.println("You sank a ship!");
					score++;

					// if all ships are sunk, end the game
					if (checkIfAllShipsSunk()) {
						System.out.println("Congratulations! You sank the final ship. Game Over!");
						System.out.println(board.toString());
						return true;
					}

					// if a ship is hit but not sunk
				} else {
					System.out.println("Hit!");
				}

				// if a ship has already been sunk
			} else {
				System.out.println("This ship has already been sunk");
				return false;
			}

			// if a ship is not hit
		} else {
			System.out.println("Miss!");
		}

		return false;
	}

	// method to check if all ships are sunk
	private boolean checkIfAllShipsSunk() {
		for (int i = 0; i < board.getBoard().length; i++) {
			for (int j = 0; j < board.getBoard()[0].length; j++) {
				if (board.getBoard()[i][j].getHasShip() && !board.getBoard()[i][j].getBattleship().isSunk()) {
					return false;
				}
			}
		}
		return true;
	}
}
