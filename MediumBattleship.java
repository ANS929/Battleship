class MediumBattleship extends Battleship {
	private static int shipsAllowed = 2; // maximum number of medium ships

	public MediumBattleship() {
		super(2); // medium battleship has a size of 2 squares
	}

	// getter
	public static int getShipsAllowed() {
		return shipsAllowed;
	}
}