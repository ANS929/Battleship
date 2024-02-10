public class Square {

	// attributes
	private int row;
	private int column;
	private boolean hasShip;
	private Battleship battleship;
	private boolean hasShot;

	// constructor
	public Square(int row, int column) {
		this.row = row;
		this.column = column;
		this.hasShip = false;
		this.battleship = null;
		this.hasShot = false;
	}

	// getters
	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public Battleship getBattleship() {
		return battleship;
	}

	public boolean getHasShot() {
		return hasShot;
	}

	public boolean getHasShip() {
		return hasShip;
	}

	// setters
	public void setHasShip(boolean hasShip) {
		this.hasShip = hasShip;
	}

	public void setBattleship(Battleship battleship) {
		this.battleship = battleship;
	}

	public void setHasShot(boolean hasShot) {
		this.hasShot = hasShot;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	// String representation of Square objects
	@Override
	public String toString() {
		if (!hasShot) {
			return String.format("%3s", "-"); // use of "-" for a square that has not been shot at
		} else if (hasShip) {
			return String.format("%3s", "x"); // use of "x" for a square that has a ship in it
		} else {
			return String.format("%3s", "o"); // use of "o" for a square that has been shot at,
												// but does not have a ship in it
		}
	}
}