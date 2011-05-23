package fragmentorcp.wizards.pages;

import java.beans.PropertyChangeEvent;

import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import fragmentorcp.Activator;
import fragmentorcppresenter.ifaces.GuiModelPropertyChange_IWizardPage;
import fragmentorcppresenter.presenter.Presenter;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;


public class CreateNewItemPage extends GuiModelPropertyChange_IWizardPage {
	
	private Presenter presenter;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	
	public CreateNewItemPage(String pageName) {
		super(pageName);
		
		setTitle("Create new Item");
        setDescription("Please enter your personal information");
        
        this.setPageComplete(false);
        TrayDialog.setDialogHelpAvailable(false);
        
        this.presenter = Activator.getDefault().getPresenter();
        this.presenter.addView(this);
        this.presenter.setNewCreateNewItemBean();
	}


	@Override
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
         setControl(composite);
         composite.setLayout(null);
         
         TabFolder tabFolder = new TabFolder(composite, SWT.NONE);
         tabFolder.setBounds(0, 0, 582, 519);
         
         TabItem tbtmCreateArtefact = new TabItem(tabFolder, SWT.NONE);
         tbtmCreateArtefact.setText("Create Artefact");
         
         Composite composite_1 = new Composite(tabFolder, SWT.NONE);
         tbtmCreateArtefact.setControl(composite_1);
         
         Group grpType = new Group(composite_1, SWT.NONE);
         grpType.setText("Type");
         grpType.setBounds(22, 10, 519, 74);
         
         Label lblType = new Label(grpType, SWT.NONE);
         lblType.setBounds(20, 30, 63, 15);
         lblType.setText("Type");
         
         Combo combo = new Combo(grpType, SWT.READ_ONLY);
         combo.setItems(new String[] {"Annotation", "Container", "Deployment Descriptor", "Fragment", "Modeller Data", "Process", "Transformation Rule", "WSDL"});
         combo.setEnabled(true);
         combo.setBounds(100, 25, 187, 27);
         
         Group grpDescription = new Group(composite_1, SWT.NONE);
         grpDescription.setText("Description");
         grpDescription.setBounds(22, 90, 519, 117);
         
         Label lblDescription = new Label(grpDescription, SWT.NONE);
         lblDescription.setBounds(20, 50, 71, 15);
         lblDescription.setText("Description");
         
         text = new Text(grpDescription, SWT.BORDER);
         text.setBounds(101, 26, 375, 65);
         
         Group grpContent = new Group(composite_1, SWT.NONE);
         grpContent.setText("Content");
         grpContent.setBounds(22, 213, 519, 215);
         
         Button btnBrowseForLocal = new Button(grpContent, SWT.CHECK);
         btnBrowseForLocal.setSelection(true);
         btnBrowseForLocal.setBounds(22, 20, 227, 22);
         btnBrowseForLocal.setText("Browse for local artefact file");
         
         text_1 = new Text(grpContent, SWT.BORDER);
         text_1.setBounds(22, 59, 376, 25);
         
         Button btnBrowse = new Button(grpContent, SWT.NONE);
         btnBrowse.setBounds(404, 57, 84, 27);
         btnBrowse.setText("Browse ...");
         
         text_2 = new Text(grpContent, SWT.BORDER);
         text_2.setBounds(22, 90, 466, 115);
         
         Button btnNewButton = new Button(composite_1, SWT.NONE);
         btnNewButton.setBounds(361, 438, 150, 27);
         btnNewButton.setText("Create Artefact");
         
         TabItem tbtmCreateRelation = new TabItem(tabFolder, SWT.NONE);
         tbtmCreateRelation.setText("Create Relation");
         
         Composite composite_2 = new Composite(tabFolder, SWT.NONE);
         tbtmCreateRelation.setControl(composite_2);
         
         Group group = new Group(composite_2, SWT.NONE);
         group.setText("Type");
         group.setBounds(22, 10, 519, 74);
         
         Label label = new Label(group, SWT.NONE);
         label.setText("Type");
         label.setBounds(20, 30, 63, 15);
         
         Combo combo_2 = new Combo(group, SWT.READ_ONLY);
         combo_2.setItems(new String[] {"Search by Type", "Search by Source Id", "Search by Target Id", "Search by Date", "Search by Date and Type"});
         combo_2.setBounds(100, 25, 194, 27);
         
         Group grpSourcetarget = new Group(composite_2, SWT.NONE);
         grpSourcetarget.setText("Source/Target");
         grpSourcetarget.setBounds(22, 90, 519, 111);
         
         Label lblSourceId = new Label(grpSourcetarget, SWT.NONE);
         lblSourceId.setBounds(20, 29, 63, 15);
         lblSourceId.setText("Source Id");
         
         Label lblTargetId = new Label(grpSourcetarget, SWT.NONE);
         lblTargetId.setBounds(20, 67, 63, 15);
         lblTargetId.setText("Target Id");
         
         text_3 = new Text(grpSourcetarget, SWT.BORDER);
         text_3.setBounds(100, 22, 75, 25);
         
         text_4 = new Text(grpSourcetarget, SWT.BORDER);
         text_4.setBounds(100, 60, 75, 25);
         
         Group group_1 = new Group(composite_2, SWT.NONE);
         group_1.setText("Description");
         group_1.setBounds(22, 207, 519, 117);
         
         Label label_1 = new Label(group_1, SWT.NONE);
         label_1.setText("Description");
         label_1.setBounds(20, 50, 71, 15);
         
         text_5 = new Text(group_1, SWT.BORDER);
         text_5.setBounds(101, 26, 375, 65);
         
         Button btnCreateRelation = new Button(composite_2, SWT.NONE);
         btnCreateRelation.setBounds(350, 346, 150, 27);
         btnCreateRelation.setText("Create Relation");


	}


	@Override
	public void modelPropertyChange(PropertyChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
}
