package fragmentorcppresenter.models.repository;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Artefact.
 *
 * @author Dimitrios Dentsas
 */
public class Artefact implements IPlaceHolder {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The artefact id. */
	private int artefactID;
	
	/** The artefact type. */
	private ArtefactTypes artefactType;
	
	/** The artefact description. */
	private String artefactDescription;
	
	/** is checked out. */
	private boolean checkedOut;
	
	/** The children. */
	private List<ArtefactHistoryBundle> children = new ArrayList<ArtefactHistoryBundle>();
	
	/**
	 * Gets the artefact id.
	 *
	 * @return the artefact id
	 */
	public int getArtefactID() {
		return artefactID;
	}
	
	/**
	 * Sets the artefact id.
	 *
	 * @param artefactID the new artefact id
	 */
	public void setArtefactID(int artefactID) {
		this.artefactID = artefactID;
	}
	
	/**
	 * Gets the artefact type.
	 *
	 * @return the artefact type
	 */
	public ArtefactTypes getArtefactType() {
		return artefactType;
	}
	
	/**
	 * Sets the artefact type.
	 *
	 * @param artefactType the new artefact type
	 */
	public void setArtefactType(ArtefactTypes artefactType) {
		this.artefactType = artefactType;
	}
	
	/**
	 * Gets the artefact description.
	 *
	 * @return the artefact description
	 */
	public String getArtefactDescription() {
		return artefactDescription;
	}
	
	/**
	 * Sets the artefact description.
	 *
	 * @param artefactDescription the new artefact description
	 */
	public void setArtefactDescription(String artefactDescription) {
		this.artefactDescription = artefactDescription;
	}
	
	/**
	 * Checks if is checked out.
	 *
	 * @return true, if is checked out
	 */
	public boolean isCheckedOut() {
		return checkedOut;
	}
	
	/**
	 * Sets the checked out.
	 *
	 * @param checkedOut the new checked out
	 */
	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}

	/**
	 * Sets the children.
	 *
	 * @param children the new children
	 */
	public void setChildren(List<ArtefactHistoryBundle> children) {
		this.children = children;
	}

	/**
	 * Gets the children.
	 *
	 * @return the children
	 */
	public List<ArtefactHistoryBundle> getChildren() {
		return children;
	}
	
	
}
