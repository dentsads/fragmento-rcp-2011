package fragmentorcp.wizards;

import java.util.List;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;

public class CreateWizard extends Wizard {
	
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
		return false;
	}

}
