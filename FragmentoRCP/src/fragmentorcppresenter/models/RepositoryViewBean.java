package fragmentorcppresenter.models;

public class RepositoryViewBean extends ModelAbstraction {

	private boolean collapseAll;
	private boolean expandAll;
	private boolean viewerRefresh;
	private boolean deleteSelected;
	
	public RepositoryViewBean() {
		
	}
	
	public void setCollapseAll(boolean collapseAll) {
		propertyChangeSupport.firePropertyChange("collapseAll", this.collapseAll,
				this.collapseAll = collapseAll);
	}

	public boolean isCollapseAll() {
		return collapseAll;
	}

	public void setExpandAll(boolean expandAll) {
		propertyChangeSupport.firePropertyChange("expandAll", this.expandAll,
				this.expandAll = expandAll);
	}

	public boolean isExpandAll() {
		return expandAll;
	}

	public void setViewerRefresh(boolean viewerRefresh) {
		propertyChangeSupport.firePropertyChange("viewerRefresh", this.viewerRefresh,
				this.viewerRefresh = viewerRefresh);
	}

	public boolean isViewerRefresh() {
		return viewerRefresh;
	}

	public void setDeleteSelected(boolean deleteSelected) {
		propertyChangeSupport.firePropertyChange("deleteSelected", this.deleteSelected,
				this.deleteSelected = deleteSelected);
	}

	public boolean isDeleteSelected() {
		return deleteSelected;
	}
	
}
