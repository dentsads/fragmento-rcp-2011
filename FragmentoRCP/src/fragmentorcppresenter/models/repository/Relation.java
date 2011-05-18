package fragmentorcppresenter.models.repository;

public class Relation {
	private int relationID;
	private RelationTypes relationType;
	private String relationDescription;
	private int fromID;
	private int toID;
	
	public int getRelationID() {
		return relationID;
	}
	public void setRelationID(int relationID) {
		this.relationID = relationID;
	}
	public RelationTypes getRelationType() {
		return relationType;
	}
	public void setRelationType(RelationTypes relationType) {
		this.relationType = relationType;
	}
	public String getRelationDescription() {
		return relationDescription;
	}
	public void setRelationDescription(String relationDescription) {
		this.relationDescription = relationDescription;
	}
	public int getFromID() {
		return fromID;
	}
	public void setFromID(int fromID) {
		this.fromID = fromID;
	}
	public int getToID() {
		return toID;
	}
	public void setToID(int toID) {
		this.toID = toID;
	}
	
	
}
