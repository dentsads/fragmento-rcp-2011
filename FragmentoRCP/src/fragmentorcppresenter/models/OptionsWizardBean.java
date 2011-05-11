package fragmentorcppresenter.models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeansObservables;

import fragmentorcppresenter.ifaces.IViewContainer;


public class OptionsWizardBean  {
	
	private IViewContainer viewContainer;
	
	public OptionsWizardBean(IViewContainer container) {
		this.viewContainer = container;
		this.bindValues();
	}

	private String txtserviceUri;
	private boolean btnApply;
	
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

	private void bindValues() {
		
		DataBindingContext bindingContext = new DataBindingContext();
//		IObservableValue widgetValue = WidgetProperties.text(SWT.Modify)
//				.observe(txtserviceUri);
//		IObservableValue modelValue = BeanProperties.value(OptionsWizardBean.class,
//				"txtserviceUri").observe(bean);
//		bindingContext.bindValue(widgetValue, modelValue);
		bindingContext.bindValue(this.viewContainer.getTxtserviceUriObservable(), BeansObservables.observeValue(this,
		"txtserviceUri"), null, null);
		bindingContext.bindValue(this.viewContainer.getBtnApplyObservable(), BeansObservables
		.observeValue(this, "btnApply"), null, null);
				
	}

}