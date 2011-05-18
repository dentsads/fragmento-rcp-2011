package fragmentorcppresenter.models;

public class SearchWizardBean extends ModelAbstraction {
	private boolean finished = false;
	private boolean canceled = false;
	
	
	public boolean isFinishedOpenOptions() {
		return finished;
	}

	public void setFinishedOpenOptions(boolean finished) {
		propertyChangeSupport.firePropertyChange("finished", this.finished,
				this.finished = finished);
	}
	
	public boolean isCanceled() {
		return canceled;
	}

	public void setCanceled(boolean canceled) {
		propertyChangeSupport.firePropertyChange("canceled", this.canceled,
				this.canceled = canceled);
	}
}
