package fragmentorcppresenter.models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class ModelAbstraction {
	protected PropertyChangeSupport propertyChangeSupport;
	
	public ModelAbstraction() {
		propertyChangeSupport = new PropertyChangeSupport(this);
	}
	
	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}
	
	 public void addPropertyChangeListener(PropertyChangeListener listener) {
	        propertyChangeSupport.addPropertyChangeListener(listener);
	 }

	 public void removePropertyChangeListener(PropertyChangeListener listener) {
	        propertyChangeSupport.removePropertyChangeListener(listener);
	 }
	
	protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
    }
}
