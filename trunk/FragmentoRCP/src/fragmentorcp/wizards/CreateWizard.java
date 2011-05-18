package fragmentorcp.wizards;

import java.util.List;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;

import fragmentorcp.Activator;
import fragmentorcppresenter.presenter.Presenter;

public class CreateWizard extends Wizard {
	
	Presenter presenter = Activator.getDefault().getPresenter();
	
	List<IWizardPage> pages;
	
	 public void addPages() {
		 for (int i = 0; i < pages.size(); i++) {
			addPage(pages.get(i));
		}
	 }
	
	public CreateWizard() {
	} 
	 
	public CreateWizard(List<IWizardPage> pages) {
		this.pages = pages;
	}
	
	@Override
	public boolean performFinish() {
		presenter.setModelProperty("finished", true);
		return true;
	}
	
	@Override
	public boolean performCancel() {
		presenter.setModelProperty("canceled", true);
		return true;
	}

}
