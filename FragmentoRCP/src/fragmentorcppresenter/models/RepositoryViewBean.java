package fragmentorcppresenter.models;

public class RepositoryViewBean extends ModelAbstraction {

	private boolean collapseAll;
	private boolean expandAll;

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
	
}
