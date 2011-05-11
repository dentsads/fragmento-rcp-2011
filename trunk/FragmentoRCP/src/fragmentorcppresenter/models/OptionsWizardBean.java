package fragmentorcppresenter.models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;

import fragmentorcppresenter.ifaces.IOptionsWizardContainer;


public class OptionsWizardBean  {
	
	private IOptionsWizardContainer viewContainer;
	
	public OptionsWizardBean(IOptionsWizardContainer container) {
		this.viewContainer = container;
		this.bindValues();
	}

	private String txtserviceUri;
	private boolean btnApply;
	private boolean btnRetrieveAllAvailable;
	
	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
			this);
	
	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}
	
	public void setTxtserviceUri(String txtserviceUri) {
		propertyChangeSupport.firePropertyChange("txtserviceUri", this.txtserviceUri,
				this.txtserviceUri = txtserviceUri);
		
		this.setBtnApply(this.txtserviceUri != null
				&& !this.txtserviceUri.trim().equals(""));
	}
	public String getTxtserviceUri() {
		return txtserviceUri;
	}
	
	public boolean isBtnApply() {
		return btnApply;
	}

	public void setBtnApply(boolean btnApply) {
		propertyChangeSupport.firePropertyChange("btnApply", this.btnApply,
				this.btnApply = btnApply);
	}

	public void setBtnRetrieveAllAvailable(boolean btnRetrieveAllAvailable) {		
		propertyChangeSupport.firePropertyChange("btnRetrieveAllAvailable", this.btnRetrieveAllAvailable,
				this.btnRetrieveAllAvailable = btnRetrieveAllAvailable);
	}

	public boolean isBtnRetrieveAllAvailable() {
		return btnRetrieveAllAvailable;
	}

	private void bindValues() {
		
		DataBindingContext bindingContext = new DataBindingContext();
		bindingContext.bindValue(this.viewContainer.getTxtserviceUriObservable(), BeansObservables.observeValue(this,
		"txtserviceUri"), null, null);
		bindingContext.bindValue(this.viewContainer.getBtnApplyObservable(), BeansObservables
		.observeValue(this, "btnApply"), null, null);
		bindingContext.bindValue(this.viewContainer.getBtnRetrieveAllAvailableObservable(), BeansObservables
				.observeValue(this, "btnRetrieveAllAvailable"), null, null);
	}

}