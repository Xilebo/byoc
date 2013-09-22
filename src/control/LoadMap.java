package control;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.map.Map;
import model.map.MapCoordinates;

/**
 * @author till
 *
 */
public class LoadMap {
	
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

		try {
			fileReader = new FileReader(csvFile);
			bufferedFileReader = new BufferedReader(fileReader);
			line = bufferedFileReader.readLine();
			while (line != null) {
				splitLine.clear();
				splitLine.copyInto(line.trim().split(sLineSplitter));
				rawMap.add(splitLine);
				line = bufferedFileReader.readLine();
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			close(fileReader);
			close(bufferedFileReader);
		}
		return parseRawMap(rawMap);
	}
	
	private static Map parseRawMap (Vector<Vector<String>> rawMap) {
		Map parsedMap = null;
		MapCoordinates tmpCoord = null;
		tmpCoord = new MapCoordinates(0, 0, 0);
		parsedMap = new Map(tmpCoord);
		
		// TODO parse
		
		return parsedMap;
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
