package fragmentorcppresenter.models.repository;

public class Artefact implements IPlaceHolder {
	private int artefactID;
	private ArtefactTypes artefactType;
	private String artefactDescription;
	private boolean checkedOut;
	
	public int getArtefactID() {
		return artefactID;
	}
	public void setArtefactID(int artefactID) {
		this.artefactID = artefactID;
	}
	public ArtefactTypes getArtefactType() {
		return artefactType;
	}
	public void setArtefactType(ArtefactTypes artefactType) {
		this.artefactType = artefactType;
	}
	public String getArtefactDescription() {
		return artefactDescription;
	}
	public void setArtefactDescription(String artefactDescription) {
		this.artefactDescription = artefactDescription;
	}
	public boolean isCheckedOut() {
		return checkedOut;
	}
	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}
	
	
}
