import java.util.Random;

public class Board {
	private int numRows;
	private int numColumns;
	private Square[][] board;

	// constructor
	public Board(int rows, int columns) {
		this.numRows = rows;
		this.numColumns = columns;

		this.board = new Square[rows][columns];
	}

	// generates an empty game board by initializing each square
	public void generateBoard() {
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumns; j++) {

				this.board[i][j] = new Square(i, j);

			}
		}
	}

	// string representation of game board
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumns; j++) {
				result.append(board[i][j].toString()).append(" ");
			}
			result.append("\n");
		}

		return result.toString();
	}

	// method to generate small battleships
	public void generateSmallBattleships() {

		Random r = new Random();
		int i = 0;

		while (i < SmallBattleship.getShipsAllowed()) {
			int row = r.nextInt(9);
			int column = r.nextInt(9);
			boolean isHorizontal = r.nextBoolean();

			// horizontal placement of ships:
			// checks that placement is within bounds and the square has no ships
			if (isHorizontal && column < 9 && this.board[row][column].getHasShip() == false) {

				// mark the square as having a ship
				this.board[row][column].setHasShip(true);

				// create a small battleship to represent the ship placed on the current square
				Battleship battleship = new SmallBattleship();

				// associate the small battleship with the current square on the game board
				this.board[row][column].setBattleship(battleship);

				// vertical placement of ships:
				// checks that placement is within bounds and the square has no ships
			} else if (!isHorizontal && row < 9 && this.board[row][column].getHasShip() == false) {

				// mark the square as having a ship
				this.board[row][column].setHasShip(true);

				// create a small battleship to represent the ship placed on the current square
				Battleship battleship = new SmallBattleship();

				// associate the small battleship with the current square on the game board
				this.board[row][column].setBattleship(battleship);
			}

			i++;
		}
	}

	// method to generate medium battleships
	public void generateMediumBattleships() {

		Random r = new Random();
		int i = 0;

		while (i < MediumBattleship.getShipsAllowed()) {
			int row = r.nextInt(9);
			int column = r.nextInt(9);
			boolean isHorizontal = r.nextBoolean();

			// horizontal placement of ships:
			// checks that the placement is within bounds and the square has no ships
			// and the square to the right has no ships
			if (isHorizontal && column < 9 && this.board[row][column].getHasShip() == false
					&& this.board[row][column + 1].getHasShip() == false) {

				// mark the squares as having ships
				this.board[row][column].setHasShip(true);
				this.board[row][column + 1].setHasShip(true);

				// create a medium battleship to represent the ship placed
				// on the current squares
				Battleship battleship = new MediumBattleship();

				// associate the medium battleship with the current squares on the game board
				this.board[row][column].setBattleship(battleship);
				this.board[row][column + 1].setBattleship(battleship);

				// vertical placement of ships:
				// checks that the placement is within bounds and the square has no ships
				// and the square below has no ships
			} else if (!isHorizontal && row < 9 && this.board[row][column].getHasShip() == false
					&& this.board[row + 1][column].getHasShip() == false) {

				// mark the squares as having ships
				this.board[row][column].setHasShip(true);
				this.board[row + 1][column].setHasShip(true);

				// create a medium battleship to represent the ship placed
				// on the current squares
				Battleship battleship = new MediumBattleship();

				// associate the medium battleship with the current squares on the game board
				this.board[row][column].setBattleship(battleship);
				this.board[row + 1][column].setBattleship(battleship);
			}

			i++;
		}
	}

	// method to generate large battleships
	public void generateLargeBattleships() {

		Random r = new Random();
		int i = 0;

		while (i < LargeBattleship.getShipsAllowed()) {
			int row = r.nextInt(9);
			int column = r.nextInt(9);
			boolean isHorizontal = r.nextBoolean();

			// horizontal placement of ships:
			// checks that placement is within bounds and the square has no ships
			// and the two squares to the right have no ships
			if (isHorizontal && column < 9 && this.board[row][column].getHasShip() == false

					&& this.board[row][column + 1].getHasShip() == false
					&& this.board[row][column + 2].getHasShip() == false) {

				// mark the squares as having ships
				this.board[row][column].setHasShip(true);
				this.board[row][column + 1].setHasShip(true);
				this.board[row][column + 2].setHasShip(true);

				// create a large battleship to represent the ship placed on the current squares
				Battleship battleship = new LargeBattleship();

				// associate the large battleship with the current squares on the game board
				this.board[row][column].setBattleship(battleship);
				this.board[row][column + 1].setBattleship(battleship);
				this.board[row][column + 2].setBattleship(battleship);

				// vertical placement of ships:
				// checks that placement is within bounds and the square has no ships
				// and the two squares below have no ships
			} else if (!isHorizontal && row < 9 && this.board[row][column].getHasShip() == false

					&& this.board[row + 1][column].getHasShip() == false
					&& this.board[row + 2][column].getHasShip() == false) {

				// mark the squares as having ships
				this.board[row][column].setHasShip(true);
				this.board[row + 1][column].setHasShip(true);
				this.board[row + 2][column].setHasShip(true);

				// create a large battleship to represent the ship placed on the current squares
				Battleship battleship = new LargeBattleship();

				// associate the large battleship with the current squares on the game board
				this.board[row][column].setBattleship(battleship);
				this.board[row + 1][column].setBattleship(battleship);
				this.board[row + 2][column].setBattleship(battleship);
			}

			i++;
		}
	}

	public Square[][] getBoard() {
		return this.board;
	}
}