class SmallBattleship extends Battleship {
	private static int shipsAllowed = 3; // maximum number of small ships

	public SmallBattleship() {
		super(1); // small battleship has a size of 1 square
	}

	// getter
	public static int getShipsAllowed() {
		return shipsAllowed;
	}
}