package fragmentorcppresenter.models;

//import org.eclipse.core.databinding.DataBindingContext;
//import org.eclipse.core.databinding.beans.BeansObservables;

//import fragmentorcppresenter.ifaces.IOptionsWizardContainer;


public class OptionsWizardBean extends ModelAbstraction{
	
//	private IOptionsWizardContainer viewContainer;
//	
//	public OptionsWizardBean(IOptionsWizardContainer container) {
//		super();
//		this.viewContainer = container;
//		this.bindValues();
//	}
	
	public OptionsWizardBean() {
	}

	private String txtserviceUri;
	private boolean btnApply;
	private boolean btnRetrieveAllAvailable;
	private boolean finished = false;
	private boolean canceled = false;
	private boolean btnRetrieveNow;
	
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
	public void setBtnRetrieveNow(boolean btnRetrieveNow) {
		propertyChangeSupport.firePropertyChange("btnRetrieveNow", this.btnRetrieveNow,
				this.btnRetrieveNow = btnRetrieveNow);
	}
	public boolean isBtnRetrieveNow() {
		return btnRetrieveNow;
	}

//	@SuppressWarnings("unused")
//	private void bindValues() {
//		
//		DataBindingContext bindingContext = new DataBindingContext();
//		bindingContext.bindValue(this.viewContainer.getTxtserviceUriObservable(), BeansObservables.observeValue(this,
//		"txtserviceUri"), null, null);
//		bindingContext.bindValue(this.viewContainer.getBtnApplyObservable(), BeansObservables
//		.observeValue(this, "btnApply"), null, null);
//		bindingContext.bindValue(this.viewContainer.getBtnRetrieveAllAvailableObservable(), BeansObservables
//				.observeValue(this, "btnRetrieveAllAvailable"), null, null);
//	}

}