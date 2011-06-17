package fragmentorcp.wizards;

import java.util.List;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;

import fragmentorcp.Activator;
import fragmentorcppresenter.presenter.Presenter;

/**
 * The Class CreateWizard handles wizard creation.
 * 
 * @author Dimitrios Dentsas
 */
public class CreateWizard extends Wizard {

	/** The presenter. */
	Presenter presenter = Activator.getDefault().getPresenter();

	/** The wizard pages list. */
	List<IWizardPage> pages;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	public void addPages() {
		for (int i = 0; i < pages.size(); i++) {
			addPage(pages.get(i));
		}
	}

	/**
	 * Instantiates a new creates the wizard.
	 */
	public CreateWizard() {
	}

	/**
	 * Instantiates a new creates the wizard.
	 * 
	 * @param pages
	 *            the wizard pages
	 */
	public CreateWizard(List<IWizardPage> pages) {
		this.pages = pages;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		presenter.setModelProperty("finished", true);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performCancel()
	 */
	@Override
	public boolean performCancel() {
		presenter.setModelProperty("canceled", true);
		return true;
	}

}
