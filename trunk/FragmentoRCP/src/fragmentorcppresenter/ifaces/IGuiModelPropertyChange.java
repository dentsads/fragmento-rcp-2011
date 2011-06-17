package fragmentorcppresenter.ifaces;

import java.beans.PropertyChangeEvent;

/**
 * The Interface IGuiModelPropertyChange provides the method
 * modelPropertyChange, which is always called when new events are propagated
 * through the PresenterAbstraction object.
 * 
 * @author Dimitrios Dentsas
 */
public interface IGuiModelPropertyChange {

	/**
	 * Model property change is called with the most recent event fired and
	 * propagated through the Presenter object.
	 * 
	 * @param event
	 *            the event
	 */
	public void modelPropertyChange(final PropertyChangeEvent event);
}
