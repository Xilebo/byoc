package model.map;

/**
 * @author till
 * 
 * contains public integers for x, y and z
 *
 */
public class MapCoordinates {
	public int x;
	public int y;
	public int z;
	
	/**
	 * @author till
	 *
	 * initiates all coordinates with 0
	 */
	public MapCoordinates() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}
	
	public MapCoordinates(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
