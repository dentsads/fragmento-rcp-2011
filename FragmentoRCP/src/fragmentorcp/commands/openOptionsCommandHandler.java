package fragmentorcp.commands;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.services.ISourceProviderService;

import fragmentorcp.Activator;
import fragmentorcp.sourceprovider.CommandState;
import fragmentorcp.wizards.CreateWizard;
import fragmentorcp.wizards.pages.CreateNewItemPage;
import fragmentorcp.wizards.pages.OpenOptionsPage;
import fragmentorcp.wizards.pages.SearchWizardPage1;
import fragmentorcppresenter.ifaces.IGuiModelPropertyChange;
import fragmentorcppresenter.models.repository.Artefact;
import fragmentorcppresenter.models.repository.Relation;
import fragmentorcppresenter.presenter.Presenter;

public class openOptionsCommandHandler extends AbstractHandler implements IGuiModelPropertyChange {
	private ExecutionEvent event;
	ISourceProviderService sourceProviderService;
	private Presenter presenter;
	
	public openOptionsCommandHandler() {
		this.presenter = Activator.getDefault().getPresenter();
        this.presenter.addView(this);
	}
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		this.event= event;
		String wizardParameter = event.getParameter("FragmentoRCP.WizardParameter");
		List<IWizardPage> pages = new ArrayList<IWizardPage>();
		
		this.sourceProviderService = (ISourceProviderService) HandlerUtil
		.getActiveWorkbenchWindow(event).getService(
				ISourceProviderService.class);
		
		if (wizardParameter.equalsIgnoreCase("TOOLBAR_OPTIONS")) {
			pages.add(new OpenOptionsPage("Repository options"));
			//pages.add(new OpenOptionsPage2("2"));
		} else if (wizardParameter.equalsIgnoreCase("TOOLBAR_CREATE_NEW_ITEM")) {
			pages.add(new CreateNewItemPage("1"));
		} else if (wizardParameter.equalsIgnoreCase("UPDATE_RELATION")) {
			
			if (this.presenter.getOperator().getViewer().getSelection().isEmpty()) {
			       this.presenter.getOperator().showErrorMessage("Please selected an item to complete operation.");
			   } else {
			       IStructuredSelection selection = (IStructuredSelection) this.presenter.getOperator().getViewer().getSelection();
			       Object selectedDomainObject = selection.getFirstElement();
			       if (selectedDomainObject instanceof Relation){
			    	   Relation item = (Relation)selectedDomainObject;
			    	   pages.add(new CreateNewItemPage("2", item));
			       } else {
			    	   this.presenter.getOperator().showErrorMessage("Please select a relation to complete operation.");
			       }
			   } 
			
		} else if (wizardParameter.equalsIgnoreCase("TOOLBAR_SEARCH")) {
			pages.add(new SearchWizardPage1("1"));
		}

		CreateWizard wizard = new CreateWizard(pages);
        WizardDialog dialog = new WizardDialog(HandlerUtil.getActiveWorkbenchWindow(event).getShell(), wizard);
        dialog.create();
        dialog.open();
        
		return null;
	}

	@Override
	public void modelPropertyChange(PropertyChangeEvent event) {
		if (event.getPropertyName().equals("btnRetrieveNow")) {
			if ((Boolean)event.getNewValue()) {
				CommandState commandStateService = (CommandState) sourceProviderService
				.getSourceProvider(CommandState.MY_STATE);

					commandStateService.enable();
						
				this.presenter.setModelProperty("btnRetrieveNow", false);
			}			
		}		
	}
}
