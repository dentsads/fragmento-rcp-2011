package fragmentorcppresenter.ifaces;

import org.eclipse.jface.wizard.WizardPage;

/**
 * The Class GuiModelPropertyChange_IWizardPage serves as an extension for
 * WizardPage objects. It implements the IGuiModelPropertyChange interface.
 * 
 * @author Dimitrios Dentsas
 */
public abstract class GuiModelPropertyChange_IWizardPage extends WizardPage
		implements IGuiModelPropertyChange {

	/**
	 * Instantiates a new gui model property change_ i wizard page.
	 * 
	 * @param pageName
	 *            the page name
	 */
	protected GuiModelPropertyChange_IWizardPage(String pageName) {
		super(pageName);
	}

}
