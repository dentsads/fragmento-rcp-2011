package fragmentorcppresenter.ifaces;

import java.beans.PropertyChangeEvent;

import org.eclipse.jface.wizard.Wizard;

/**
 * The Class GuiModelPropertyChange_IWizard serves as an extension for Wizard
 * objects. It implements the IGuiModelPropertyChange interface.
 * 
 * @author Dimitrios Dentsas
 */
public abstract class GuiModelPropertyChange_IWizard extends Wizard implements
		IGuiModelPropertyChange {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fragmentorcppresenter.ifaces.IGuiModelPropertyChange#modelPropertyChange
	 * (java.beans.PropertyChangeEvent)
	 */
	public abstract void modelPropertyChange(final PropertyChangeEvent event);

}
