package fragmentorcppresenter.models.repository;

/**
 * The Class Lock manages the Fragmento artefact lock paradigm.
 *
 * @author Dimitrios Dentsas
 */
public class Lock {
	
	/** The lock id. */
	private int lockID;
	
	/** The art id. */
	private int artID;
	
	/**
	 * Sets the lock id.
	 *
	 * @param lockID the new lock id
	 */
	public void setLockID(int lockID) {
		this.lockID = lockID;
	}
	
	/**
	 * Gets the lock id.
	 *
	 * @return the lock id
	 */
	public int getLockID() {
		return lockID;
	}
	
	/**
	 * Sets the art id.
	 *
	 * @param artID the new art id
	 */
	public void setArtID(int artID) {
		this.artID = artID;
	}
	
	/**
	 * Gets the art id.
	 *
	 * @return the art id
	 */
	public int getArtID() {
		return artID;
	}
}
