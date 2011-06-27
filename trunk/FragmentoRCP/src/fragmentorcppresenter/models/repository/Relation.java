package fragmentorcppresenter.models.repository;

/**
 * The Class Relation.
 *
 * @author Dimitrios Dentsas
 */
public class Relation implements IPlaceHolder{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The relation id. */
	private int relationID;
	
	/** The relation type. */
	private RelationTypes relationType;
	
	/** The relation description. */
	private String relationDescription;
	
	/** The from id. */
	private int fromID;
	
	/** The to id. */
	private int toID;
	
	/**
	 * Gets the relation id.
	 *
	 * @return the relation id
	 */
	public int getRelationID() {
		return relationID;
	}
	
	/**
	 * Sets the relation id.
	 *
	 * @param relationID the new relation id
	 */
	public void setRelationID(int relationID) {
		this.relationID = relationID;
	}
	
	/**
	 * Gets the relation type.
	 *
	 * @return the relation type
	 */
	public RelationTypes getRelationType() {
		return relationType;
	}
	
	/**
	 * Sets the relation type.
	 *
	 * @param relationType the new relation type
	 */
	public void setRelationType(RelationTypes relationType) {
		this.relationType = relationType;
	}
	
	/**
	 * Gets the relation description.
	 *
	 * @return the relation description
	 */
	public String getRelationDescription() {
		return relationDescription;
	}
	
	/**
	 * Sets the relation description.
	 *
	 * @param relationDescription the new relation description
	 */
	public void setRelationDescription(String relationDescription) {
		this.relationDescription = relationDescription;
	}
	
	/**
	 * Gets the from id.
	 *
	 * @return the from id
	 */
	public int getFromID() {
		return fromID;
	}
	
	/**
	 * Sets the from id.
	 *
	 * @param fromID the new from id
	 */
	public void setFromID(int fromID) {
		this.fromID = fromID;
	}
	
	/**
	 * Gets the to id.
	 *
	 * @return the to id
	 */
	public int getToID() {
		return toID;
	}
	
	/**
	 * Sets the to id.
	 *
	 * @param toID the new to id
	 */
	public void setToID(int toID) {
		this.toID = toID;
	}
	
	
}
