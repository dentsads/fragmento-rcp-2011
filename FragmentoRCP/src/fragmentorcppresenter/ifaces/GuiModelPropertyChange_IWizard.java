package fragmentorcppresenter.ifaces;

import java.beans.PropertyChangeEvent;

import org.eclipse.jface.wizard.Wizard;

public abstract class GuiModelPropertyChange_IWizard extends Wizard implements IGuiModelPropertyChange{
	public abstract void modelPropertyChange(final PropertyChangeEvent event);
	
}
