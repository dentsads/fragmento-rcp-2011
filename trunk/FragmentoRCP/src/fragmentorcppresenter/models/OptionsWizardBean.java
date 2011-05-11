package fragmentorcppresenter.models;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class OptionsWizardBean implements PropertyChangeListener {
	public OptionsWizardBean() {
	}

	private String txtserviceUri;
	
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

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
