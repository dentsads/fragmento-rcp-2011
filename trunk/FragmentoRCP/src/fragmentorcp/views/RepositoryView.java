package fragmentorcp.views;

import java.beans.PropertyChangeEvent;
import java.io.File;
import java.io.IOException;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;

import fragmentService.FragmentoAxis;
import fragmentorcp.Activator;
import fragmentorcp.views.treeviewer.provider.ContentProvider;
import fragmentorcp.views.treeviewer.provider.LabelProvider;
import fragmentorcp.views.treeviewer.provider.TodoMockModel;
import fragmentorcppresenter.ifaces.GuiModelPropertyChange_IViewPart;
import fragmentorcppresenter.presenter.Presenter;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.ui.ide.IDE;

import org.eclipse.swt.SWT;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.apache.commons.io.FileUtils;

public class RepositoryView extends GuiModelPropertyChange_IViewPart {
	
	public static final String ID = "FragmentoRCP.RepositoryView";
	private TreeViewer viewer;
	
	private Presenter presenter;
	private Action action1;
	private Action action2;
	private DrillDownAdapter drillDownAdapter;
	private Action doubleClickAction;
	@SuppressWarnings("unused")
	private Action action_openEditor;
	
	FragmentoAxis test = new FragmentoAxis();
	
	public RepositoryView() {
		
		this.presenter = Activator.getDefault().getPresenter();
        this.presenter.addView(this);
        this.presenter.setNewRepostoryViewBean();
	}

	@Override
	public void createPartControl(Composite parent) {
						
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL);
		drillDownAdapter = new DrillDownAdapter(viewer);
		viewer.setContentProvider(new ContentProvider());
		viewer.setLabelProvider(new LabelProvider());
		// Expand the tree 
		viewer.setAutoExpandLevel(2);
		// Provide the input to the ContentProvider
		viewer.setInput(new TodoMockModel());
		
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
	}
	
	
	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}


	private void fillContextMenu(IMenuManager manager) {
		manager.add(action1);
		manager.add(action2);
		manager.add(new Separator());
		drillDownAdapter.addNavigationActions(manager);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	private void makeActions() {
		action1 = new Action() {
			public void run() {
				showMessage("Action 1 executed");
			}
		};
		action1.setText("Action 1");
		action1.setToolTipText("Action 1 tooltip");
		action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		
		action2 = new Action() {
			public void run() {
				showMessage("Action 2 executed");
			}
		};
		action2.setText("Action 2");
		action2.setToolTipText("Action 2 tooltip");
		action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		doubleClickAction = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();
				showMessage("Double-click detected on "+obj.toString());
			}
		};
		
		action_openEditor = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();

				File fileToOpen = new File("externalfile.xml");
				
				try {
					FileUtils.writeStringToFile(fileToOpen, test.checkoutArtifact(
					test.browseArtifact_byDescription(obj.toString()).getArtefactDescriptors().getArtefact()[0].getArtefactId()).getArtefact().
							getExtraElement().toString());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (fileToOpen.exists() && fileToOpen.isFile()) {
				    IFileStore fileStore = EFS.getLocalFileSystem().getStore(fileToOpen.toURI());
				    IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				 
				    try {
				        IDE.openEditorOnFileStore( page, fileStore );				       
				    } catch ( PartInitException e ) {
				        //Put your exception handler here if you wish to
				    }
				} else {
				    //Do something if the file does not exist
				}
				
			}
		};
		
	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
				//action_openEditor.run();
			}
		});
	}
	private void showMessage(String message) {
		MessageDialog.openInformation(
			viewer.getControl().getShell(),
			"Fragmento View 1",
			message);
		
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
		}
	}
	
}
