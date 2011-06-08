package fragmentorcp.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import fragmentorcp.Activator;
import fragmentorcppresenter.presenter.Presenter;

public class toolbarRemainingCommandHandler extends AbstractHandler {
	
	private Presenter presenter = Activator.getDefault().getPresenter();
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		String wizardParameter = event.getParameter("FragmentoRCP.WizardParameter");
		
		if (wizardParameter.equalsIgnoreCase("TOOLBAR_EXPAND_ALL")) {
			this.presenter.setModelProperty("expandAll", true);
		} else if (wizardParameter.equalsIgnoreCase("TOOLBAR_COLLAPSE_ALL")) {
			this.presenter.setModelProperty("collapseAll", true);
		} else if (wizardParameter.equalsIgnoreCase("TOOLBAR_DELETE")) {
			this.presenter.setModelProperty("deleteSelected", true);
		} else if (wizardParameter.equalsIgnoreCase("CHECKOUT")) {
			this.presenter.setModelProperty("checkoutSelected", true);
		} else if (wizardParameter.equalsIgnoreCase("CHECKIN")) {
			this.presenter.setModelProperty("checkinSelected", true);
		} else if (wizardParameter.equalsIgnoreCase("TOOLBAR_REFRESH")) {
			this.presenter.setModelProperty("refresh", true);
		} else if (wizardParameter.equalsIgnoreCase("DELETE_FROM_REPO")) {
			this.presenter.setModelProperty("deleteFromRepoSelected", true);
		}
		
		return null;
	}

}
