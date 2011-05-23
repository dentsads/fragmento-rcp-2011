package fragmentorcp.views.treeviewer.provider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
//import org.eclipse.ui.part.DrillDownAdapter;

import fragmentService.FragmentoAxis;
import fragmentorcppresenter.models.repository.Artefact;
import fragmentorcppresenter.models.repository.ArtefactCategory;
import fragmentorcppresenter.models.repository.ArtefactTypes;
import fragmentorcppresenter.models.repository.IPlaceHolder;
import fragmentorcppresenter.models.repository.Relation;

public class TreeViewerOperator {
	 
	private TreeViewer viewer;
	private Action action1;
	private Action action2;
	//private DrillDownAdapter drillDownAdapter;
	private Action doubleClickAction;
	@SuppressWarnings("unused")
	private Action action_openEditor;
	
	FragmentoAxis fragmento = new FragmentoAxis();
	TodoMockModel mock;
	
	
	public TreeViewerOperator(TreeViewer viewer, TodoMockModel mock) {
		this.viewer = viewer;
		this.mock = mock;
	}
	
	public void fillContextMenu(IMenuManager manager) {
//		manager.add(action1);
//		manager.add(action2);
//		manager.add(new Separator());
//		drillDownAdapter.addNavigationActions(manager);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	public void makeActions() {
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
					FileUtils.writeStringToFile(fileToOpen, fragmento.checkoutArtifact(
					fragmento.browseArtifact_byDescription(obj.toString()).getArtefactDescriptors().getArtefact()[0].getArtefactId()).getArtefact().
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

	public void hookDoubleClickAction() {
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
	
	private void showMessage(String title, String message) {
		MessageDialog.openInformation(
			viewer.getControl().getShell(),
			title,
			message);	
	}
	
	private void showErrorMessage(String message) {
		MessageDialog.openError(
				viewer.getControl().getShell(),
				"Error",
				message);
	}
	
	public void deleteSelected() {
		   if (viewer.getSelection().isEmpty()) {
		       showErrorMessage("Please selected an item to complete operation.");
		   } else {
		       IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
		       Object selectedDomainObject = selection.getFirstElement();
		       if (selectedDomainObject instanceof Artefact) {		    	   
		           Artefact item = (Artefact)selectedDomainObject;
		           removeArtefact(item.getArtefactID(),item.getArtefactType());
		       } else if (selectedDomainObject instanceof Relation){
		    	   Relation item = (Relation)selectedDomainObject;
		    	   showMessage("Attention", "This functionality is coming soon.");
		       } else {;
				showErrorMessage("Please select an item instead of a category!");
			}
		   }
	}
	
	public void addArtefact(int id, String desc,ArtefactTypes type, String content, boolean checkedOut) {
		Artefact artefact = new Artefact();
		artefact.setArtefactID(id);
		artefact.setArtefactDescription(desc);
		artefact.setArtefactType(type);
		artefact.setCheckedOut(checkedOut);
		artefact.setArtefactContent(content);		
		TodoMockModel input = (TodoMockModel)viewer.getInput();
		ArrayList<IPlaceHolder> categories = (ArrayList<IPlaceHolder>) input.getCategories();
		ArtefactCategory<ArtefactCategory<Artefact>> artefactsCategory = (ArtefactCategory<ArtefactCategory<Artefact>>)categories.get(0);
		Object[] subArray = artefactsCategory.getChildren().toArray();
		for (int i = 0; i < subArray.length; i++) {
			@SuppressWarnings("unchecked")
			ArtefactCategory<Artefact> sub = (ArtefactCategory<Artefact>)subArray[i]; 
			if (sub.getName() == type.toString()) {
				sub.getChildren().add(artefact);
			}
		}
	}
	
	public void removeArtefact(int id, ArtefactTypes type) {
		TodoMockModel input = (TodoMockModel)viewer.getInput();
		ArrayList<IPlaceHolder> categories = (ArrayList<IPlaceHolder>) input.getCategories();
		ArtefactCategory<ArtefactCategory<Artefact>> artefactsCategory = (ArtefactCategory<ArtefactCategory<Artefact>>)categories.get(0);
		
		Object[] subArray = artefactsCategory.getChildren().toArray();
		for (int i = 0; i < subArray.length; i++) {
			@SuppressWarnings("unchecked")
			ArtefactCategory<Artefact> sub = (ArtefactCategory<Artefact>)subArray[i]; 
			if (sub.getName() == type.toString()) {
				
				Object[] subArt = sub.getChildren().toArray();
				for (int j = 0; j < subArt.length; j++) {
					Artefact sub2 = (Artefact)subArt[j];
					if (sub2.getArtefactID() == id) {
						sub.getChildren().remove(sub2);
						viewer.refresh();
					}
				}
			}
		}
	}
}
