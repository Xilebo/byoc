package model.map;

/**
 * contains public integers for x, y and z
 *
 * @author Till Hülsemann
 */
public class MapCoordinates {
	public int x;
	public int y;
	public int z;
	
	/**
	 * initiates all coordinates with 0
	 * 
	 */
	public MapCoordinates() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}
	
	/**
	 * initiates coordinates with given values
	 * 
	 * @param x - the x coordinate
	 * @param y - the y coordinate
	 * @param z - the z coordinate
	 */
	public MapCoordinates(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public String toString() {
		return "[x=" + x + ", y=" + y + ", z=" + z + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		result = prime * result + z;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MapCoordinates other = (MapCoordinates) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		if (z != other.z)
			return false;
		return true;
	}
}
