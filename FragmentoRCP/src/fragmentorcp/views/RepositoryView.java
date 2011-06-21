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
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.ToolTip;
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

/**
 * The Class RepositoryView is the main plugin view which handles the toolbar
 * item and the JFace TreeViewer.
 * 
 * @author Dimitrios Dentsas
 */
public class RepositoryView extends GuiModelPropertyChange_IViewPart {

	/** The Constant ID. */
	public static final String ID = "FragmentoRCP.RepositoryView";

	/** The viewer. */
	private TreeViewer viewer;

	/** The presenter. */
	private Presenter presenter;
	// private TreeViewerOperator operator;
	/** The mock. */
	TodoMockModel mock = new TodoMockModel();

	/**
	 * Instantiates a new repository view.
	 */
	public RepositoryView() {

		this.presenter = Activator.getDefault().getPresenter();
		this.presenter.addView(this);
		this.presenter.setNewRepostoryViewBean();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets
	 * .Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		mock = new TodoMockModel();
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		// drillDownAdapter = new DrillDownAdapter(viewer);
		viewer.setContentProvider(new ContentProvider());
		ColumnViewerToolTipSupport.enableFor(viewer, ToolTip.NO_RECREATE);
		viewer.setLabelProvider(new LabelProvider());
		// Expand the tree
		viewer.setAutoExpandLevel(3);
		// Provide the input to the ContentProvider

		viewer.setInput(mock);
		this.presenter.setOperator(new TreeViewerOperator(viewer, mock));

		this.presenter.getOperator().makeActions();
		hookContextMenu();
		this.presenter.getOperator().hookDoubleClickAction();
		getSite().setSelectionProvider(viewer);
	}

	/**
	 * Hook context menu.
	 */
	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				presenter.getOperator().fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu("treePopupMenu", menuMgr, viewer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fragmentorcppresenter.ifaces.GuiModelPropertyChange_IViewPart#
	 * modelPropertyChange(java.beans.PropertyChangeEvent)
	 */
	@Override
	public void modelPropertyChange(PropertyChangeEvent event) {
		if (event.getPropertyName().equals("expandAll")) {
			if ((Boolean) event.getNewValue()) {
				viewer.expandToLevel(3);
				this.presenter.setModelProperty("collapseAll", false);
			}
		} else if (event.getPropertyName().equals("btnRetrieveNow")) {
			if ((Boolean) event.getNewValue()) {
				mock.getCategories().clear();
				presenter.getOperator().init();

				viewer.refresh();
				viewer.expandToLevel(3);
				this.presenter.setModelProperty("btnRetrieveNow", false);
			}
		} else if (event.getPropertyName().equals("collapseAll")) {
			if ((Boolean) event.getNewValue()) {
				viewer.collapseAll();
				this.presenter.setModelProperty("expandAll", false);
			}
		} else if (event.getPropertyName().equals("viewerRefresh")) {
			if ((Boolean) event.getNewValue()) {
				viewer.refresh();
				this.presenter.setModelProperty("viewerRefresh", false);
			}
		} else if (event.getPropertyName().equals("deleteSelected")) {
			if ((Boolean) event.getNewValue()) {
				this.presenter.getOperator().deleteSelected(false);
				this.presenter.setModelProperty("deleteSelected", false);
			}
		} else if (event.getPropertyName().equals("checkoutSelected")) {
			if ((Boolean) event.getNewValue()) {
				this.presenter.getOperator().checkoutSelected();
				this.presenter.setModelProperty("checkoutSelected", false);
			}
		} else if (event.getPropertyName().equals("checkinSelected")) {
			if ((Boolean) event.getNewValue()) {
				IEditorPart editorPart = getSite().getWorkbenchWindow()
						.getActivePage().getActiveEditor();

				if (editorPart != null) {
					FileStoreEditorInput input = (FileStoreEditorInput) editorPart
							.getEditorInput();

					java.net.URI uri = input.getURI();
					IFileStore location = EFS.getLocalFileSystem()
							.getStore(uri);
					try {
						File file = location.toLocalFile(EFS.NONE, null);
						String content = FileUtils.readFileToString(file);
						this.presenter.getOperator().checkinSelected(content);
						this.presenter.setModelProperty("refresh", true);
						// System.out.println(content);
					} catch (CoreException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {
					this.presenter
							.getOperator()
							.showErrorMessage(
									"No active file opened on workbench in order to check in!");
				}

				this.presenter.setModelProperty("checkinSelected", false);
			}
		} else if (event.getPropertyName().equals("refresh")) {
			if ((Boolean) event.getNewValue()) {
				mock.getCategories().clear();
				presenter.getOperator().init();
				viewer.expandToLevel(3);
				viewer.refresh();
				this.presenter.setModelProperty("refresh", false);
			}
		} else if (event.getPropertyName().equals("deleteFromRepoSelected")) {
			if ((Boolean) event.getNewValue()) {
				this.presenter.getOperator().deleteSelected(true);
				viewer.refresh();
				this.presenter
						.setModelProperty("deleteFromRepoSelected", false);
			}
		} else if (event.getPropertyName().equals("releaseLock")) {
			if ((Boolean) event.getNewValue()) {
				this.presenter.getOperator().releaseLockSelected();
				viewer.refresh();
				this.presenter.setModelProperty("releaseLock", false);
			}
		} else if (event.getPropertyName().equals("checkoutPath")) {
			this.presenter.getOperator().setCheckoutPath(
					(String) event.getNewValue());
		} else if (event.getPropertyName().equals("keepRelations")) {
			this.presenter.getOperator().setKeepRelations(
					(Boolean) event.getNewValue());
		} else if (event.getPropertyName().equals("getBundle")) {
			if ((Boolean) event.getNewValue()) {
				this.presenter.getOperator().retrieveArtefactBundle();
				viewer.refresh();
				this.presenter.setModelProperty("getBundle", false);
			};
		}
	}

}
