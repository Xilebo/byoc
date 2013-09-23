package control;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.map.Map;
import model.map.MapBlock;
import model.map.MapCoordinates;

/**
 * @author till
 *
 */
public class LoadMap {
	
	private static int iSizeX = 1;
	private static int iSizeY = 1;
	private static int iSizeZ = 1;
	
	public static String separator = ",";
	
	public static Map loadCsv() {
		Map resultMap = null;
		File csvFile;
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"CSV File", "csv");
	    chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			csvFile = chooser.getSelectedFile();
			resultMap = loadCsv(csvFile);
		}
		
		return resultMap;
	}
	
	public static Map loadCsv(String pathname) {
		Map resultMap = null;
		File csvFile = new File(pathname);
		
		if (csvFile.isFile()) {
			resultMap = loadCsv(csvFile);
		}

		return resultMap;
	}
	
	public static Map loadCsv(File csvFile) {
		BufferedReader bufferedFileReader = null;
		FileReader fileReader = null;
		String line;
		Vector<String> splitLine = new Vector<String>();
		Vector<Vector<String>> rawMap = new Vector<Vector<String>>();
		
		String sLineSplitter = "[ \t\"]*" + separator + "[ \t\"]*";
		iSizeX = 0;
		iSizeY = 0;
		iSizeZ = 1;

		//TODO maps should be 3d...
		
		try {
			fileReader = new FileReader(csvFile);
			bufferedFileReader = new BufferedReader(fileReader);
			line = bufferedFileReader.readLine();
			while (line != null) {
				splitLine.clear();
				splitLine.copyInto(line.trim().split(sLineSplitter));
				rawMap.add(splitLine);
				if (splitLine.size() > iSizeX) iSizeX = splitLine.size();
				iSizeY++;
				line = bufferedFileReader.readLine();
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			close(fileReader);
			close(bufferedFileReader);
		}
		return parseRawMap2d(rawMap);
	}
	
	private static Map parseRawMap2d (Vector<Vector<String>> rawMap) {
		if (rawMap == null) return null;
		
		String rawContent;
		MapBlock currentBlock;
		Map parsedMap = null;
		MapCoordinates tmpCoord = null;
		tmpCoord = new MapCoordinates(iSizeX - 1, iSizeY - 1, iSizeZ - 1);
		parsedMap = new Map(tmpCoord);
		
		tmpCoord.z = 0;
		for (tmpCoord.x = 0; tmpCoord.x < iSizeX; tmpCoord.x++) {
			for (tmpCoord.y = 0; tmpCoord.y < iSizeY; tmpCoord.y++) {
				//TODO check if coordinates are in bounds for both maps
				rawContent = rawMap.get(tmpCoord.y).get(tmpCoord.x);
				currentBlock = parsedMap.getBlockAt(tmpCoord);
				parse(rawContent, currentBlock);
			}
		}
		
		return parsedMap;
	}
	
	private static void parse(String rawContent, MapBlock block) {
		block.setSolidGround(true); //TODO currently there is no code for non-solid ground
		if (rawContent.startsWith("X_")) {
			rawContent = rawContent.substring(2);
			block.setPassable(false);
		} else {
			block.setPassable(true);
		}
		block.setMaterial(rawContent);
	}

	private static void close(Closeable toClose) {
		if (toClose != null) {
			try {
				toClose.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
