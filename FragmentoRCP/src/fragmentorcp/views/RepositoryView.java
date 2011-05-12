package fragmentorcp.views;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import fragmentorcppresenter.ifaces.IRepositoryViewContainer;


public class RepositoryView extends ViewPart implements IRepositoryViewContainer {
	
	private String serviceURI;
	private IObservableValue serviceURIObservable;
	
	public RepositoryView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	public String getServiceURI() {
		return serviceURI;
	}

	public void setServiceURI(String serviceURI) {
		this.serviceURI = serviceURI;
	}

	public IObservableValue getServiceURIObservable() {
		return serviceURIObservable;
	}

}
