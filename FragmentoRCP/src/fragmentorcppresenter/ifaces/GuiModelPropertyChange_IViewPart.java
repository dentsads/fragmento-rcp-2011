package fragmentorcppresenter.ifaces;

import org.eclipse.ui.part.ViewPart;

import java.beans.PropertyChangeEvent;

public abstract class GuiModelPropertyChange_IViewPart extends ViewPart implements IGuiModelPropertyChange {
	
	public abstract void modelPropertyChange(final PropertyChangeEvent event);
}
