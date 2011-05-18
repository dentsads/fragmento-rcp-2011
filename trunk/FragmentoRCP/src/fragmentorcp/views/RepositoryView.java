package fragmentorcp.views;

import java.beans.PropertyChangeEvent;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;

import fragmentorcp.Activator;
import fragmentorcp.views.treeviewer.provider.ContentProvider;
import fragmentorcp.views.treeviewer.provider.LabelProvider;
import fragmentorcp.views.treeviewer.provider.TodoMockModel;
import fragmentorcppresenter.ifaces.GuiModelPropertyChange_IViewPart;
import fragmentorcppresenter.presenter.Presenter;

import org.eclipse.swt.SWT;


public class RepositoryView extends GuiModelPropertyChange_IViewPart {
	
	public static final String ID = "FragmentoRCP.RepositoryView";
	private TreeViewer viewer;
	
	private Presenter presenter;
	
	public RepositoryView() {
		
		this.presenter = Activator.getDefault().getPresenter();
        this.presenter.addView(this);
        this.presenter.setNewRepostoryViewBean();
	}

	@Override
	public void createPartControl(Composite parent) {
						
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL);
		viewer.setContentProvider(new ContentProvider());
		viewer.setLabelProvider(new LabelProvider());
		// Expand the tree 
		viewer.setAutoExpandLevel(2);
		// Provide the input to the ContentProvider
		viewer.setInput(new TodoMockModel());
		viewer.expandAll();
	}
	

	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	@Override
	public void modelPropertyChange(PropertyChangeEvent event) {		
	}
	
}
