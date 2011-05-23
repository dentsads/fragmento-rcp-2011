package fragmentorcp.views;

import java.beans.PropertyChangeEvent;

import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;

import fragmentorcp.Activator;
import fragmentorcp.views.treeviewer.provider.ContentProvider;
import fragmentorcp.views.treeviewer.provider.LabelProvider;
import fragmentorcp.views.treeviewer.provider.TodoMockModel;
import fragmentorcp.views.treeviewer.provider.TreeViewerOperator;
import fragmentorcppresenter.ifaces.GuiModelPropertyChange_IViewPart;
import fragmentorcppresenter.presenter.Presenter;

public class RepositoryView extends GuiModelPropertyChange_IViewPart {
	
	public static final String ID = "FragmentoRCP.RepositoryView";
	private TreeViewer viewer;	
	private Presenter presenter;
	private TreeViewerOperator operator;
	TodoMockModel mock = new TodoMockModel();
	
	public RepositoryView() {
		
		this.presenter = Activator.getDefault().getPresenter();
        this.presenter.addView(this);
        this.presenter.setNewRepostoryViewBean();
	}

	@Override
	public void createPartControl(Composite parent) {
		mock = new TodoMockModel();
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL);
		//drillDownAdapter = new DrillDownAdapter(viewer);
		viewer.setContentProvider(new ContentProvider());
		viewer.setLabelProvider(new LabelProvider());
		// Expand the tree 
		viewer.setAutoExpandLevel(2);
		// Provide the input to the ContentProvider
		
		viewer.setInput(mock);
		mock.init();
		viewer.refresh();
		this.operator = new TreeViewerOperator(viewer,mock);
		
		this.operator.makeActions();
		hookContextMenu();
		this.operator.hookDoubleClickAction();
	}
	
	
	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				operator.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu("treePopupMenu",menuMgr, viewer);
	}

	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	@Override
	public void modelPropertyChange(PropertyChangeEvent event) {
		if (event.getPropertyName().equals("expandAll")) {
			if ((Boolean)event.getNewValue()) {
				viewer.expandAll();
				this.presenter.setModelProperty("collapseAll", false);
			}			
		} else if (event.getPropertyName().equals("collapseAll")) {
			if ((Boolean)event.getNewValue()) {
				viewer.collapseAll();
				this.presenter.setModelProperty("expandAll", false);
			}
		} else if (event.getPropertyName().equals("viewerRefresh")) {
			if ((Boolean)event.getNewValue()) {
				viewer.refresh();
				this.presenter.setModelProperty("viewerRefresh", false);
			}
		} else if (event.getPropertyName().equals("deleteSelected")) {
			if ((Boolean)event.getNewValue()) {
				operator.deleteSelected();
				this.presenter.setModelProperty("deleteSelected", false);
			}
		}
	}
	
}
