package fragmentorcppresenter.models.repository;

public class Lock {
	private int lockID;
	private int artID;
	
	public void setLockID(int lockID) {
		this.lockID = lockID;
	}
	public int getLockID() {
		return lockID;
	}
	public void setArtID(int artID) {
		this.artID = artID;
	}
	public int getArtID() {
		return artID;
	}
}
