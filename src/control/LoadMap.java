package control;

import java.io.BufferedReader;
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
	public static Map loadCsv(String sPath) {
		Map resultMap = null;
		BufferedReader mapFileReader = null;
		FileReader fr = null;
		MapCoordinates tmpCoord = null;
		String line;
		Vector<String> splitLine = new Vector<String>();
		Vector<Vector<String>> rawMap = new Vector<Vector<String>>();
//		JFileChooser chooser = new JFileChooser();
		
		tmpCoord = new MapCoordinates(0, 0, 0);
		resultMap = new Map(tmpCoord);
		
//		FileNameExtensionFilter filter = new FileNameExtensionFilter(
//			"CSV File", "csv");
//	    chooser.setFileFilter(filter);
//		int returnVal = chooser.showOpenDialog(null);
		
//		if(returnVal == JFileChooser.APPROVE_OPTION) {
			try {
//				fr = new FileReader(chooser.getSelectedFile());
				fr = new FileReader(sPath);
				mapFileReader = new BufferedReader(fr);
				line = mapFileReader.readLine();
				while (line != null) {
					splitLine.clear();
					splitLine.copyInto(line.split(","));
					rawMap.add(splitLine);
					line = mapFileReader.readLine();
				}
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				if (fr != null) {
					try {
						fr.close();
					} catch (Exception e) {
						System.out.println(e);
					}
				}
				if (mapFileReader != null) {
					try {
						mapFileReader.close();
					} catch (Exception e) {
						System.out.println(e);
					}
				}
			}
//	    }
		return resultMap;
	}
}