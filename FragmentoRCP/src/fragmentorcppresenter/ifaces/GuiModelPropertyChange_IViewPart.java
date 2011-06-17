package fragmentorcppresenter.ifaces;

import org.eclipse.ui.part.ViewPart;

import java.beans.PropertyChangeEvent;

/**
 * The Class GuiModelPropertyChange_IViewPart serves as an extension for
 * ViewPart objects. It implements the IGuiModelPropertyChange interface
 * 
 * @author Dimitrios Dentsas
 */
public abstract class GuiModelPropertyChange_IViewPart extends ViewPart
		implements IGuiModelPropertyChange {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fragmentorcppresenter.ifaces.IGuiModelPropertyChange#modelPropertyChange
	 * (java.beans.PropertyChangeEvent)
	 */
	public abstract void modelPropertyChange(final PropertyChangeEvent event);
}
