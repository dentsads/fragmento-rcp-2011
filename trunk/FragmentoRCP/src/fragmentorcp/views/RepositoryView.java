package fragmentorcp.views;

import java.beans.PropertyChangeEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ide.FileStoreEditorInput;

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
		this.operator = new TreeViewerOperator(viewer,mock);
		
		operator.init();
		viewer.refresh();
		
		viewer.expandAll();
		this.operator.makeActions();
		hookContextMenu();
		this.operator.hookDoubleClickAction();
		getSite().setSelectionProvider(viewer);
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
		} else if (event.getPropertyName().equals("checkoutSelected")) {
			if ((Boolean)event.getNewValue()) {
				operator.checkoutSelected();
				this.presenter.setModelProperty("checkoutSelected", false);
			}
		} else if (event.getPropertyName().equals("checkinSelected")) {
			if ((Boolean)event.getNewValue()) {
				IEditorPart  editorPart =
					getSite().getWorkbenchWindow().getActivePage().getActiveEditor();
				 FileStoreEditorInput input = (FileStoreEditorInput)editorPart.getEditorInput();
				 
				 java.net.URI uri = input.getURI(); 
				 IFileStore location = EFS.getLocalFileSystem().getStore(uri); 
				 try {
					File file = location.toLocalFile(EFS.NONE, null);
					String content = FileUtils.readFileToString(file);
					operator.checkinSelected(content,true);
					this.presenter.setModelProperty("refresh", true);
					//System.out.println(content);
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				this.presenter.setModelProperty("checkinSelected", false);
			}
		} else if (event.getPropertyName().equals("refresh")) {
			if ((Boolean)event.getNewValue()) {
				mock.getCategories().clear();
				operator.init();
				viewer.expandAll();
				viewer.refresh();
				this.presenter.setModelProperty("refresh", false);
			}
		}
	}
	
}
