package model.map;

import java.util.ArrayList;


/**
 * Map of the game 
 * 
 * @author till
 *
 */
public class Map {
	// TODO the whole class needs some more and improved error handling	
	
	/**
	 * the order of the coordinates is Z Y X for performance reasons (see toString)
	 */
	private ArrayList<ArrayList<ArrayList<MapBlock>>> mapBlocks;
	
	public Map (int iRangeX, int iRangeY, int iRangeZ) {
		this.mapBlocks = createEmptyZYX(iRangeX, iRangeY, iRangeZ);
	}
	
	private ArrayList<ArrayList<ArrayList<MapBlock>>> createEmptyZYX(int iRangeZ, int iRangeY, int iRangeX) {
		ArrayList<ArrayList<ArrayList<MapBlock>>> tmp3d 
			= new ArrayList<ArrayList<ArrayList<MapBlock>>>();
		
		for (int z = 1; z <= iRangeZ; z++) {
			tmp3d.add(createEmptyYX(iRangeY, iRangeX));
		}
		
		return tmp3d;
	}
	
	private ArrayList<ArrayList<MapBlock>> createEmptyYX(int iRangeY, int iRangeX) {
		ArrayList<ArrayList<MapBlock>> tmp2d = new ArrayList<ArrayList<MapBlock>>();
		
		for (int y = 1; y <= iRangeY; y++) {
			tmp2d.add(createEmptyX(iRangeX));
		}
		
		return tmp2d;
	}
	
	private ArrayList<MapBlock> createEmptyX(int iRangeX) {
		ArrayList<MapBlock> tmp1d = new ArrayList<MapBlock>();
		
		for (int x = 1; x <= iRangeX; x++) {
			tmp1d.add(new MapBlock());
		}
		
		return tmp1d;
	}
	
	public MapBlock getBlockAt(int posX, int posY, int iPosZ) {
		return this.mapBlocks.get(posX).get(posY).get(iPosZ);
	}

	@Override
	public String toString() {
		String sResult = "";
		int maxZ = mapBlocks.size();
		for (int iCoordZ = 0; iCoordZ < maxZ; iCoordZ++) {
			sResult += layerToString(iCoordZ) + "\n\n";
		}
		return sResult;
	}

	public String layerToString(int iCoordZ) {
		// TODO improve error handling 
		if (mapBlocks.isEmpty()) return "the map is empty";
		if (mapBlocks.size() <= iCoordZ) return "Layer does not exist";
		
		String sResult = "";
		int maxY = mapBlocks.get(iCoordZ).size();
		for (int iCoordY = 0; iCoordY < maxY; iCoordY++) {
			sResult += lineToString(iCoordZ, iCoordY) + "\n";
		}
		return sResult;
	}

	public String lineToString(int iCoordZ, int iCoordY) {
		// TODO improve error handling 
		if (mapBlocks.isEmpty()) return "the map is empty";
		if (mapBlocks.size() <= iCoordZ) return "Layer does not exist";
		if (mapBlocks.get(iCoordZ).size() <= iCoordY) return "Y Coordinate out of Bounds";

		String sResult = "";
		int maxX = mapBlocks.get(iCoordZ).get(iCoordY).size();
		for (int iCoordX = 0; iCoordX < maxX; iCoordX++) {
			sResult += blockToString(iCoordZ, iCoordY, iCoordX);
		}
		return sResult;
	}

	public String blockToString(int iCoordZ, int iCoordY, int iCoordX) {
		return mapBlocks.get(iCoordZ).get(iCoordY).get(iCoordX).toString();
	}

}
