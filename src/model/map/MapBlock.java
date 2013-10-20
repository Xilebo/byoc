package model.map;

import java.util.List;
import java.util.Vector;

/**
 * a single block in a map
 * This class contains information about floor material and form as well as a
 * list of items and creatures and whatnot present in this place. 
 * 
 * @author Till Hülsemann
 *
 */
public class MapBlock {

	private String sMaterial = "air";
	private boolean passable = true;
	private boolean solidGround = false;
	private Vector<Object> content = new Vector<Object>();
	
	/**
	 * Returns if the block is passable.
	 * @return a boolean value, true if the block is passable
	 */
	public boolean isPassable() {
		return passable;
	}

	/**
	 * change if the block is passable
	 * @param passable - a boolean value that determines if the block is passable
	 */
	public void setPassable(boolean passable) {
		this.passable = passable;
	}

	/**
	 * Return if not-flying critters/objects can be in this block without
	 * falling. Should be irrelevant if passable is false 
	 * @return a boolean value, false if things can fall through
	 */
	public boolean isSolidGround() {
		return solidGround;
	}

	/**
	 * Set if not-flying critters/objects can be in this block without
	 * falling. Should be irrelevant if passable is false 
	 * @param solidGround - a boolean value that determines if you should be able
	 * to stand in this block
	 */
	public void setSolidGround(boolean solidGround) {
		this.solidGround = solidGround;
	}

	/**
	 * Return the material of this block.
	 * @return a string describing the material of the block
	 */
	public String getMaterial() {
		return sMaterial;
	}
	
	/**
	 * Set the material of the block.
	 * @param material - a string describing the material of the block
	 */
	public void setMaterial(String material) {
		// TODO check if given material is valid 
		this.sMaterial = material;
	}
	
	/**
	 * Get everything which is currently in this block.
	 * @return a list of every object in this block
	 * this block 
	 */
	public List<Object> getContent() {
		return new Vector<Object>(content);
	}
	
	/**
	 * Place something in this block.
	 * The object is just added to the block. MapBlock does not prevent objects
	 * from being in two places at the same time. 
	 * @param content - an object to be added to the block
	 */
	public void addContent(Object content) {
		this.content.add(content);
	}
	
	/**
	 * Remove an object from this block.
	 * The object is not destroyed. It is just not present in this block
	 * anymore.
	 * @param content - the object to be removed
	 * @return true if the block contained the specified object
	 */
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
