package fragmentorcp.commands;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.services.ISourceProviderService;

import fragmentorcp.sourceprovider.CommandState;


public class enableToolbarHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		ISourceProviderService sourceProviderService = (ISourceProviderService) HandlerUtil
		.getActiveWorkbenchWindow(event).getService(
				ISourceProviderService.class);
		
		// Now get my service
        CommandState commandStateService = (CommandState) sourceProviderService
			.getSourceProvider(CommandState.MY_STATE);
		commandStateService.toogleEnabled();
		
		return null;
	}

}
