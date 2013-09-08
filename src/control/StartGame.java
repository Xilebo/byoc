package control;

import model.map.Map;
import model.map.MapBlock;

public class StartGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO insert menu here
		// for now we just start doing stuff
		int iRangeX = 5;
		int iRangeY = 5;
		int iRangeZ = 5;
		
		Map map = new Map(iRangeZ, iRangeY, iRangeX);
		
		for (int iPosX = 0; iPosX < iRangeX; iPosX++) {
			for (int iPosY = 0; iPosY < iRangeY; iPosY++) {
				MapBlock block;
				block = map.getBlockAt(0, iPosY, iPosX);
				block.setMaterial("earth");
				block.setPassable(false);
				
				block = map.getBlockAt(1, iPosY, iPosX);
				block.setSolidGround(true);
			}
		}
		
		System.out.println(map.toString());

	}

}
