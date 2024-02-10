public class Battleship {

	// attributes
	private boolean isSunk;
	private int remainingHealth;
	private int shipSize;

	// constructor
	public Battleship(int shipSize) {
		this.isSunk = false;
		this.remainingHealth = shipSize;
		this.shipSize = shipSize;
	}

	// getters
	public boolean isSunk() {
		if (remainingHealth == 0) {
			return true; // if the remaining health is 0, return true (ship is sunk)
		}

		return isSunk;
	}

	public int getRemainingHealth() {
		return remainingHealth;
	}

	public int getShipSize() {
		return shipSize;
	}

	public void decreaseHealth() {
		remainingHealth--; // when a ship is hit, decrease the remaining health
	}
}
