package fragmentorcppresenter.models;

public class RepositoryViewBean extends ModelAbstraction {
	
	private String text;
	private boolean btnTest;
	
	public boolean isbBtnTest() {
		return btnTest;
	}

	public void setBtnTest(boolean buttonClicked) {
		propertyChangeSupport.firePropertyChange("btnTest", this.btnTest,
				this.btnTest = buttonClicked);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {	
		propertyChangeSupport.firePropertyChange("text", this.text,
				this.text = text);
	}
	
}
