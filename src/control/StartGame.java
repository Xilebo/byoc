package control;

import model.map.Map3D;
import model.map.MapBlock;
import model.map.MapCoordinates;

/**
 * @author till
 *
 */
public class StartGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO insert menu here
		// for now we just start doing stuff
		MapCoordinates position = new MapCoordinates();
		int iRangeX = 5;
		int iRangeY = 5;
		int iRangeZ = 5;
		
		MapCoordinates lastField = new MapCoordinates(iRangeX - 1, iRangeY - 1, iRangeZ - 1);
		Map3D map = new Map3D(lastField);
		
		for (int iPosX = 0; iPosX < iRangeX; iPosX++) {
			for (int iPosY = 0; iPosY < iRangeY; iPosY++) {
				MapBlock block;
				
				position.x = iPosX;
				position.y = iPosY;
				
				position.z = 0;
				block = map.getBlockAt(position);
				block.setMaterial("earth");
				block.setPassable(false);
				
				position.z = 1;
				block = map.getBlockAt(position);
				block.setSolidGround(true);
			}
		}
		
		System.out.println(map.toString());

	}

}
