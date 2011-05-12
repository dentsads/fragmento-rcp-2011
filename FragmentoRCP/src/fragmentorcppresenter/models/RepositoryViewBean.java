package fragmentorcppresenter.models;

import fragmentorcppresenter.ifaces.IRepositoryViewContainer;

public class RepositoryViewBean {
	
	private IRepositoryViewContainer viewcontainer;
	
	public RepositoryViewBean(IRepositoryViewContainer container) {
		this.viewcontainer = container;
		
	}
}
