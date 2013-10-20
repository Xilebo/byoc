package model.map;

import java.util.ArrayList;


/**
 * Map of the game 
 * 
 * @author till
 *
 */
public class Map3D {
	// TODO the whole class needs some more and improved error handling	
	
	/**
	 * the order of the coordinates is Z Y X for performance reasons (see toString)
	 */
	private ArrayList<ArrayList<ArrayList<MapBlock>>> mapBlocks;
	
	public Map3D (MapCoordinates lastField) {
		this.mapBlocks = createEmptyZYX(lastField);
	}
	
	private ArrayList<ArrayList<ArrayList<MapBlock>>> createEmptyZYX(MapCoordinates lastField) {
		ArrayList<ArrayList<ArrayList<MapBlock>>> tmp3d 
			= new ArrayList<ArrayList<ArrayList<MapBlock>>>();
		
		for (int z = 0; z <= lastField.z; z++) {
			tmp3d.add(createEmptyYX(lastField));
		}
		
		return tmp3d;
	}
	
	private ArrayList<ArrayList<MapBlock>> createEmptyYX(MapCoordinates lastField) {
		ArrayList<ArrayList<MapBlock>> tmp2d = new ArrayList<ArrayList<MapBlock>>();
		
		for (int y = 0; y <= lastField.y; y++) {
			tmp2d.add(createEmptyX(lastField));
		}
		
		return tmp2d;
	}
	
	private ArrayList<MapBlock> createEmptyX(MapCoordinates lastField) {
		ArrayList<MapBlock> tmp1d = new ArrayList<MapBlock>();
		
		for (int x = 0; x <= lastField.x; x++) {
			tmp1d.add(new MapBlock());
		}
		
		return tmp1d;
	}
	
	public MapBlock getBlockAt(MapCoordinates position) {
		return this.mapBlocks.get(position.z).get(position.y).get(position.x);
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

	private String lineToString(int iCoordZ, int iCoordY) {
		// TODO improve error handling 
		if (mapBlocks.isEmpty()) return "the map is empty";
		if (mapBlocks.size() <= iCoordZ) return "Layer does not exist";
		if (mapBlocks.get(iCoordZ).size() <= iCoordY) return "Y Coordinate out of Bounds";

		String sResult = "";
		int maxX = mapBlocks.get(iCoordZ).get(iCoordY).size();
		MapCoordinates position = new MapCoordinates();
		for (int iCoordX = 0; iCoordX < maxX; iCoordX++) {
			position.z = iCoordZ;
			position.y = iCoordY;
			position.x = iCoordX;
			sResult += blockToString(position);
		}
		return sResult;
	}

	public String blockToString(MapCoordinates position) {
		return mapBlocks.get(position.z).get(position.y).get(position.x).toString();
	}

}
