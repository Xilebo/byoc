package model.map;

import java.util.ArrayList;


/**
 * 2D Map 
 * 
 * @author Till Hülsemann
 *
 */
public class Map2D {
	// TODO the whole class needs some more and improved error handling	
	
	/**
	 * the order of the coordinates is Y X for performance reasons (see toString)
	 */
	private ArrayList<ArrayList<MapBlock>> mapBlocks;
	
	public Map2D (MapCoordinates lastField) {
		this.mapBlocks = createEmptyYX(lastField);
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
		return this.mapBlocks.get(position.y).get(position.x);
	}

	@Override
	public String toString() {
		// TODO improve error handling 
		if (mapBlocks.isEmpty()) return "the map is empty";
		
		String sResult = "";
		int maxY = mapBlocks.size();
		for (int iCoordY = 0; iCoordY < maxY; iCoordY++) {
			sResult += lineToString(iCoordY) + "\n";
		}
		return sResult;
	}

	private String lineToString(int iCoordY) {
		// TODO improve error handling 
		if (mapBlocks.isEmpty()) return "the map is empty";
		if (mapBlocks.size() <= iCoordY) return "Y Coordinate out of Bounds";

		String sResult = "";
		int maxX = mapBlocks.get(iCoordY).size();
		MapCoordinates position = new MapCoordinates();
		for (int iCoordX = 0; iCoordX < maxX; iCoordX++) {
			position.y = iCoordY;
			position.x = iCoordX;
			sResult += blockToString(position);
		}
		return sResult;
	}

	public String blockToString(MapCoordinates position) {
		return mapBlocks.get(position.y).get(position.x).toString();
	}

}
