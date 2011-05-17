package fragmentorcppresenter.models;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeansObservables;

import fragmentorcppresenter.ifaces.IRepositoryViewContainer;

public class RepositoryViewBean extends ModelAbstraction {
	
	private IRepositoryViewContainer viewContainer;
	
	public RepositoryViewBean(IRepositoryViewContainer container) {
		super();
		this.viewContainer = container;
		//this.bindValues();
	}
	
	public RepositoryViewBean() {
	}
	
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

	@SuppressWarnings("unused")
	private void bindValues() {
		
		DataBindingContext bindingContext = new DataBindingContext();
		bindingContext.bindValue(this.viewContainer.getServiceURIObservable(), BeansObservables.observeValue(this,
		"text"), null, null);
	}
	
}
