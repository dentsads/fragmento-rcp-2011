package fragmentorcppresenter.models;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeansObservables;

import fragmentorcppresenter.ifaces.IOptionsWizardContainer;


public class OptionsWizardBean extends ModelAbstraction{
	
	private IOptionsWizardContainer viewContainer;
	
	public OptionsWizardBean(IOptionsWizardContainer container) {
		super();
		this.viewContainer = container;
		//this.bindValues();
	}
	
	public OptionsWizardBean() {
	}

	private String txtserviceUri;
	private boolean btnApply;
	private boolean btnRetrieveAllAvailable;
	
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
	
	@SuppressWarnings("unused")
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