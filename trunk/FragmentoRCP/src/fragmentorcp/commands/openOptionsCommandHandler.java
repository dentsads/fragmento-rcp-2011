package fragmentorcp.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.services.ISourceProviderService;

import fragmentorcp.sourceprovider.CommandState;
import fragmentorcp.wizards.CreateWizard;
import fragmentorcp.wizards.createitem.CreateNewItem;
import fragmentorcp.wizards.openoptions.OpenOptionsPage;
import fragmentorcp.wizards.openoptions.OpenOptionsPage2;

public class openOptionsCommandHandler extends AbstractHandler {
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
//		ISourceProviderService sourceProviderService = (ISourceProviderService) HandlerUtil
//		.getActiveWorkbenchWindow(event).getService(
//				ISourceProviderService.class);
//        // Now get my service
//        CommandState commandStateService = (CommandState) sourceProviderService
//			.getSourceProvider(CommandState.MY_STATE);
//        commandStateService.toogleEnabled();
		
		String wizardParameter = event.getParameter("FragmentoRCP.WizardParameter");
		List<IWizardPage> pages = new ArrayList<IWizardPage>();
		
		if (wizardParameter.equalsIgnoreCase("TOOLBAR_OPTIONS")) {
			pages.add(new OpenOptionsPage("1"));
			//pages.add(new OpenOptionsPage2("2"));
		} else if (wizardParameter.equalsIgnoreCase("TOOLBAR_CREATE_NEW_ITEM")) {
			pages.add(new CreateNewItem("1"));
		} else if (wizardParameter.equalsIgnoreCase("TOOLBAR_SEARCH")) {
			pages.add(new OpenOptionsPage("1"));
			pages.add(new OpenOptionsPage2("2"));
		}

		CreateWizard wizard = new CreateWizard(pages);
        WizardDialog dialog = new WizardDialog(HandlerUtil.getActiveWorkbenchWindow(event).getShell(), wizard);
        dialog.create();
        dialog.open();
            
		return null;
	}

}