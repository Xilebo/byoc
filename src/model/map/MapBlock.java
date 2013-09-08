package model.map;

import java.util.Vector;

/**
 * a single block in a map
 * This class contains information about floor material and form as well as a
 * list of items and creatures and whatnot present in this place. 
 * 
 * @author till
 *
 */
public class MapBlock {

	private String sMaterial = "air";
	private boolean passable = true;
	private boolean solidGround = false;
	private Vector<Object> content = new Vector<Object>();
	
	public boolean isPassable() {
		return passable;
	}

	public void setPassable(boolean passable) {
		this.passable = passable;
	}

	public boolean isSolidGround() {
		return solidGround;
	}

	public void setSolidGround(boolean solidGround) {
		this.solidGround = solidGround;
	}

	public String getMaterial() {
		return sMaterial;
	}
	
	public void setMaterial(String material) {
		// TODO check if given material is valid 
		this.sMaterial = material;
	}
	
	public Vector<Object> getContent() {
		return new Vector<Object>(content);
	}
	
	public void addContent(Object content) {
		this.content.add(content);
	}
	
	public boolean removeContent(Object content) {
		return this.content.remove(content);
	}

	@Override
	public String toString() {
		String sResult;
		if (!this.passable) {
			sResult = "#";
		} else if (solidGround) {
			sResult = "+";
		} else {
			sResult = ".";
		}
		return sResult;
	}
	
}
