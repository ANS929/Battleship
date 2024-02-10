class LargeBattleship extends Battleship {
	private static int shipsAllowed = 1; // maximum number of large ships

	public LargeBattleship() {
		super(3); // large battleship has a size of 3 squares
	}

	// getter
	public static int getShipsAllowed() {
		return shipsAllowed;
	}
}