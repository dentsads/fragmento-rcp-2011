package fragmentorcppresenter.models;

// TODO: Auto-generated Javadoc
/**
 * The Class RepositoryViewBean  is the model for the repository view.
 * 
 * @author Dimitrios Dentsas
 */
public class RepositoryViewBean extends ModelAbstraction {

	/** The collapse all. */
	private boolean collapseAll;

	/** The expand all. */
	private boolean expandAll;

	/** The viewer refresh. */
	private boolean viewerRefresh;

	/** The delete selected. */
	private boolean deleteSelected;

	/** The delete from repo selected. */
	private boolean deleteFromRepoSelected;

	/** The checkout selected. */
	private boolean checkoutSelected;

	/** The checkin selected. */
	private boolean checkinSelected;

	/** The refresh. */
	private boolean refresh;

	/** The release lock. */
	private boolean releaseLock;

	/** The checkout path. */
	private String checkoutPath;

	/** The keep relations. */
	private boolean keepRelations;
	
	/** The get bundle. */
	private boolean getBundle;
	
	/** The is serialized. */
	private boolean isSerialized;
	
	/**
	 * Instantiates a new repository view bean.
	 */
	public RepositoryViewBean() {

	}

	/**
	 * Sets the collapse all.
	 * 
	 * @param collapseAll
	 *            the new collapse all
	 */
	public void setCollapseAll(boolean collapseAll) {
		propertyChangeSupport.firePropertyChange("collapseAll",
				this.collapseAll, this.collapseAll = collapseAll);
	}

	/**
	 * Checks if is collapse all.
	 * 
	 * @return true, if is collapse all
	 */
	public boolean isCollapseAll() {
		return collapseAll;
	}

	/**
	 * Sets the expand all.
	 * 
	 * @param expandAll
	 *            the new expand all
	 */
	public void setExpandAll(boolean expandAll) {
		propertyChangeSupport.firePropertyChange("expandAll", this.expandAll,
				this.expandAll = expandAll);
	}

	/**
	 * Checks if is expand all.
	 * 
	 * @return true, if is expand all
	 */
	public boolean isExpandAll() {
		return expandAll;
	}

	/**
	 * Sets the viewer refresh.
	 * 
	 * @param viewerRefresh
	 *            the new viewer refresh
	 */
	public void setViewerRefresh(boolean viewerRefresh) {
		propertyChangeSupport.firePropertyChange("viewerRefresh",
				this.viewerRefresh, this.viewerRefresh = viewerRefresh);
	}

	/**
	 * Checks if is viewer refresh.
	 * 
	 * @return true, if is viewer refresh
	 */
	public boolean isViewerRefresh() {
		return viewerRefresh;
	}

	/**
	 * Sets the delete selected.
	 * 
	 * @param deleteSelected
	 *            the new delete selected
	 */
	public void setDeleteSelected(boolean deleteSelected) {
		propertyChangeSupport.firePropertyChange("deleteSelected",
				this.deleteSelected, this.deleteSelected = deleteSelected);
	}

	/**
	 * Checks if is delete selected.
	 * 
	 * @return true, if is delete selected
	 */
	public boolean isDeleteSelected() {
		return deleteSelected;
	}

	/**
	 * Sets the delete from repo selected.
	 * 
	 * @param deleteFromRepoSelected
	 *            the new delete from repo selected
	 */
	public void setDeleteFromRepoSelected(boolean deleteFromRepoSelected) {
		propertyChangeSupport.firePropertyChange("deleteFromRepoSelected",
				this.deleteFromRepoSelected,
				this.deleteFromRepoSelected = deleteFromRepoSelected);
	}

	/**
	 * Checks if is delete from repo selected.
	 * 
	 * @return true, if is delete from repo selected
	 */
	public boolean isDeleteFromRepoSelected() {
		return deleteFromRepoSelected;
	}

	/**
	 * Sets the checkout selected.
	 * 
	 * @param checkoutSelected
	 *            the new checkout selected
	 */
	public void setCheckoutSelected(boolean checkoutSelected) {
		propertyChangeSupport
				.firePropertyChange("checkoutSelected", this.checkoutSelected,
						this.checkoutSelected = checkoutSelected);
	}

	/**
	 * Checks if is checkout selected.
	 * 
	 * @return true, if is checkout selected
	 */
	public boolean isCheckoutSelected() {
		return checkoutSelected;
	}

	/**
	 * Sets the checkin selected.
	 * 
	 * @param checkinSelected
	 *            the new checkin selected
	 */
	public void setCheckinSelected(boolean checkinSelected) {
		propertyChangeSupport.firePropertyChange("checkinSelected",
				this.checkinSelected, this.checkinSelected = checkinSelected);
	}

	/**
	 * Checks if is checkin selected.
	 * 
	 * @return true, if is checkin selected
	 */
	public boolean isCheckinSelected() {
		return checkinSelected;
	}

	/**
	 * Sets the refresh.
	 * 
	 * @param refresh
	 *            the new refresh
	 */
	public void setRefresh(boolean refresh) {
		propertyChangeSupport.firePropertyChange("refresh", this.refresh,
				this.refresh = refresh);
	}

	/**
	 * Checks if is refresh.
	 * 
	 * @return true, if is refresh
	 */
	public boolean isRefresh() {
		return refresh;
	}

	/**
	 * Sets the release lock.
	 * 
	 * @param releaseLock
	 *            the new release lock
	 */
	public void setReleaseLock(boolean releaseLock) {
		propertyChangeSupport.firePropertyChange("releaseLock",
				this.releaseLock, this.releaseLock = releaseLock);
	}

	/**
	 * Checks if is release lock.
	 * 
	 * @return true, if is release lock
	 */
	public boolean isReleaseLock() {
		return releaseLock;
	}

	/**
	 * Sets the checkout path.
	 * 
	 * @param checkoutPath
	 *            the new checkout path
	 */
	public void setCheckoutPath(String checkoutPath) {
		propertyChangeSupport.firePropertyChange("checkoutPath",
				this.checkoutPath, this.checkoutPath = checkoutPath);
	}

	/**
	 * Gets the checkout path.
	 * 
	 * @return the checkout path
	 */
	public String getCheckoutPath() {
		return checkoutPath;
	}

	/**
	 * Sets the keep relations.
	 * 
	 * @param keepRelations
	 *            the new keep relations
	 */
	public void setKeepRelations(boolean keepRelations) {
		propertyChangeSupport.firePropertyChange("keepRelations",
				this.keepRelations, this.keepRelations = keepRelations);
	}

	/**
	 * Checks if is keep relations.
	 * 
	 * @return true, if is keep relations
	 */
	public boolean isKeepRelations() {
		return keepRelations;
	}

	/**
	 * Sets the gets the bundle.
	 *
	 * @param getBundle the new gets the bundle
	 */
	public void setGetBundle(boolean getBundle) {
		propertyChangeSupport.firePropertyChange("getBundle",
				this.getBundle, this.getBundle = getBundle);
	}

	/**
	 * Checks if is gets the bundle.
	 *
	 * @return true, if is gets the bundle
	 */
	public boolean isGetBundle() {
		return getBundle;
	}

	/**
	 * Sets the serialized.
	 *
	 * @param isSerialized the new serialized
	 */
	public void setIsSerialized(boolean isSerialized) {
		propertyChangeSupport.firePropertyChange("isSerialized",
				this.isSerialized, this.isSerialized = isSerialized);
	}

	/**
	 * Checks if is serialized.
	 *
	 * @return true, if is serialized
	 */
	public boolean isSerialized() {
		return isSerialized;
	}

}
