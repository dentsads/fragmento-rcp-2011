package fragmentorcp.wizards.pages;

import java.beans.PropertyChangeEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import fragmentorcp.Activator;
import fragmentorcppresenter.ifaces.GuiModelPropertyChange_IWizardPage;
import fragmentorcppresenter.models.repository.Relation;
import fragmentorcppresenter.presenter.Presenter;

import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;


public class CreateNewItemPage extends GuiModelPropertyChange_IWizardPage {
	
	private Presenter presenter;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Combo text_3;
	private Combo text_4;
	private Text text_5;
	private Button btnBrowseForLocal;
	private Button btnBrowse;
	String fileFilterPath ;
	private Combo combo;
	private Button btnNewButton;
	private Combo combo_1;
	private Button btnCreateRelation;
	
	private boolean updateRelation= false;
	private Relation relation;
	/**
	 * @wbp.parser.constructor
	 */
	public CreateNewItemPage(String pageName) {
		super(pageName);
		
		setTitle("Create new Item");
        setDescription("Please enter your personal information");
        
        this.setPageComplete(false);
        TrayDialog.setDialogHelpAvailable(false);
        
        this.presenter = Activator.getDefault().getPresenter();
        this.presenter.addView(this);
        this.presenter.setNewCreateNewItemBean();
        this.presenter.setModelProperty("finished", false);
        this.presenter.setModelProperty("canceled", false);
	}	
	
	public CreateNewItemPage(String pageName, Relation relation) {
		super(pageName);
		this.updateRelation = true;
		this.relation = relation;
		
		setTitle("Update relation");
        setDescription("Please enter update information");
        
        this.setPageComplete(true);
        TrayDialog.setDialogHelpAvailable(false);
        
        this.presenter = Activator.getDefault().getPresenter();
        this.presenter.addView(this);
        this.presenter.setNewCreateNewItemBean();
        this.presenter.setModelProperty("finished", false);
        this.presenter.setModelProperty("canceled", false);
	}	
	
	@Override
	public void createControl(final Composite parent) {
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
         
         combo = new Combo(grpType, SWT.READ_ONLY);
         combo.addSelectionListener(new SelectionAdapter() {
         	@Override
         	public void widgetSelected(SelectionEvent e) {
         		presenter.setModelProperty("combo",combo.getSelection().toString());
         	}
         });
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
         text.addModifyListener(new ModifyListener() {
         	public void modifyText(ModifyEvent e) {
         		presenter.setModelProperty("description",text.getText());
         	}
         });
         text.setBounds(97, 44, 375, 25);
         
         Group grpContent = new Group(composite_1, SWT.NONE);
         grpContent.setText("Content");
         grpContent.setBounds(22, 213, 519, 215);
         
         btnBrowseForLocal = new Button(grpContent, SWT.CHECK);
         btnBrowseForLocal.addSelectionListener(new SelectionAdapter() {
         	@Override
         	public void widgetSelected(SelectionEvent e) {
         		if (btnBrowseForLocal.getSelection()) {
          			presenter.setModelProperty("localBrowseButtonSelected",true);
				} else {
					presenter.setModelProperty("localBrowseButtonSelected",false);
				}
         	}
         });
         btnBrowseForLocal.setBounds(22, 20, 227, 22);
         btnBrowseForLocal.setText("Browse for local artefact file");
         
         text_1 = new Text(grpContent, SWT.BORDER | SWT.READ_ONLY);
         text_1.addModifyListener(new ModifyListener() {
         	public void modifyText(ModifyEvent e) {
         		presenter.setModelProperty("text_1",text_1.getText());
         	}
         });
         text_1.setEnabled(false);
         text_1.setBounds(22, 59, 376, 25);
         
         btnBrowse = new Button(grpContent, SWT.NONE);
         btnBrowse.addSelectionListener(new SelectionAdapter() {
         	@Override
         	public void widgetSelected(SelectionEvent e) {
         		FileDialog fileDialog = new FileDialog(parent.getShell(), SWT.MULTI);

                fileDialog.setFilterPath(fileFilterPath);
                
                fileDialog.setFilterExtensions(new String[]{"*.xml", "*.wsdl", "*.bpel*", "*.*"});
                fileDialog.setFilterNames(new String[]{ "XML", "WSDL", "BPEL", "Any"});
                
                String firstFile = fileDialog.open();

                if(firstFile != null) {
                  fileFilterPath = fileDialog.getFilterPath();
                  String[] selectedFiles = fileDialog.getFileNames();
                  StringBuffer sb = new StringBuffer(fileDialog.getFilterPath() + "/");
                  for(int i=0; i<selectedFiles.length; i++) {
                    sb.append(selectedFiles[i]);
                  }
                  text_1.setText(sb.toString());
                }
         	}
         });
         btnBrowse.setEnabled(false);
         btnBrowse.setBounds(404, 57, 84, 27);
         btnBrowse.setText("Browse ...");
         
         text_2 = new Text(grpContent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL | SWT.MULTI);
         text_2.addModifyListener(new ModifyListener() {
         	public void modifyText(ModifyEvent e) {
         		presenter.setModelProperty("text_2",text_2.getText());
         	}
         });
         text_2.setBounds(22, 90, 466, 115);
         
         btnNewButton = new Button(composite_1, SWT.NONE);
         btnNewButton.addSelectionListener(new SelectionAdapter() {
         	@Override
         	public void widgetSelected(SelectionEvent e) {
         		presenter.setModelProperty("buttonPushed", true);
         	}
         });
         btnNewButton.setEnabled(false);
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
         
         combo_1 = new Combo(group, SWT.READ_ONLY);
         combo_1.addSelectionListener(new SelectionAdapter() {
         	@Override
         	public void widgetSelected(SelectionEvent e) {
         		presenter.setModelProperty("combo_1",combo_1.getSelection().toString());
         	}
         });
         combo_1.setItems(new String[] {"annotation", "container", "deployment", "modeller", "transformation", "wsdl"});
         combo_1.setBounds(100, 25, 194, 27);
         if (updateRelation) {
			combo_1.setText(this.presenter.getOperator().relationAdapter(this.relation.getRelationType()));
		}
         
         
         Group grpSourcetarget = new Group(composite_2, SWT.NONE);
         grpSourcetarget.setText("Source/Target");
         grpSourcetarget.setBounds(22, 90, 519, 111);
         
         Label lblSourceId = new Label(grpSourcetarget, SWT.NONE);
         lblSourceId.setBounds(31, 48, 63, 15);
         lblSourceId.setText("Source Id");
         
         Label lblTargetId = new Label(grpSourcetarget, SWT.NONE);
         lblTargetId.setBounds(284, 48, 63, 15);
         lblTargetId.setText("Target Id");
         
         text_3 = new Combo(grpSourcetarget, SWT.READ_ONLY);
         text_3.setItems((String[])this.presenter.getOperator().getArtefactList().toArray(new String[0]));
         text_3.setVisibleItemCount(10);
         text_3.addSelectionListener(new SelectionAdapter() {
         	@Override
         	public void widgetSelected(SelectionEvent e) {
         		presenter.setModelProperty("fromId",text_3.getSelection().toString());
         	}
         });
         text_3.setBounds(121, 44, 120, 25);
         if (updateRelation) {
        	 text_3.setText(String.valueOf(this.relation.getFromID()));
 		}
         
         
         text_4 = new Combo(grpSourcetarget, SWT.READ_ONLY);
         text_4.setVisibleItemCount(10);
         text_4.setItems((String[])this.presenter.getOperator().getArtefactList().toArray(new String[0]));
         text_4.addSelectionListener(new SelectionAdapter() {
         	@Override
         	public void widgetSelected(SelectionEvent e) {
         		presenter.setModelProperty("toId",text_4.getSelection().toString());
         	}
         });
         text_4.setBounds(357, 44, 120, 27);
         if (updateRelation) {
        	 text_4.setText(String.valueOf(this.relation.getToID()));
 		}
         
         
         Group group_1 = new Group(composite_2, SWT.NONE);
         group_1.setText("Description");
         group_1.setBounds(22, 207, 519, 117);
         
         Label label_1 = new Label(group_1, SWT.NONE);
         label_1.setText("Description");
         label_1.setBounds(20, 50, 71, 15);
         
         text_5 = new Text(group_1, SWT.BORDER);
         text_5.addModifyListener(new ModifyListener() {
         	public void modifyText(ModifyEvent e) {
         		presenter.setModelProperty("description2",text_5.getText());
         	}
         });
         text_5.setBounds(97, 44, 375, 25);
         if (updateRelation) {
        	 text_5.setText(this.relation.getRelationDescription());
 		}
         
         
         btnCreateRelation = new Button(composite_2, SWT.NONE);
         btnCreateRelation.addSelectionListener(new SelectionAdapter() {
         	@Override
         	public void widgetSelected(SelectionEvent e) {
         		if (updateRelation) {
         			presenter.setModelProperty("updateRelation",true);
				} else {
					presenter.setModelProperty("buttonPushed2",true);
				}			
         	}
         });
         
         if (updateRelation) {
        	 btnCreateRelation.setEnabled(true);
 		} else {
 			btnCreateRelation.setEnabled(false);
		}
         btnCreateRelation.setBounds(350, 346, 150, 27);
         
         if (updateRelation) {
        	 btnCreateRelation.setText("Update Relation");
		} else {
			btnCreateRelation.setText("Create Relation");
		}

         
         TabItem tbtmUpdateRelation = new TabItem(tabFolder, SWT.NONE);;
         tbtmUpdateRelation.setText("Update Relation");
         tbtmUpdateRelation.setControl(composite_2);
         
         if (updateRelation) {
        	 tbtmCreateArtefact.dispose();
        	 tbtmCreateRelation.dispose();
		} else {
			tbtmUpdateRelation.dispose();
		}

	}


	@Override
	public void modelPropertyChange(PropertyChangeEvent event) {
		if (event.getPropertyName().equals("localBrowseButtonSelected")) {
			if ((Boolean)event.getNewValue()) {
				text_1.setEnabled(true);
				btnBrowse.setEnabled(true);
				text_2.setEnabled(false);
			} else {
				text_1.setEnabled(false);
				btnBrowse.setEnabled(false);
				text_2.setEnabled(true);
			}
		} else if (event.getPropertyName().equals("finished") || event.getPropertyName().equals("canceled")) {
			if ((Boolean)event.getNewValue()) {
				this.presenter.removeModel(this.presenter.getCreateNewItemBean());
				this.presenter.removeView(this);			
				dispose();
			}
		} else if (event.getPropertyName().equals("buttonEnable")) {	
			if ((Boolean)event.getNewValue()) {
				this.btnNewButton.setEnabled(true);
			} else {
				this.btnNewButton.setEnabled(false);
			}
		} else if (event.getPropertyName().equals("buttonPushed")) {	
			if ((Boolean)event.getNewValue()) {
				
				if (text_1.isEnabled()) {
					String content="";
					 try {
							File file = new File(text_1.getText());
							content = FileUtils.readFileToString(file);
						}  catch (IOException e) {
							e.printStackTrace();
						} 
					this.presenter.getOperator().createNewArtefact(combo.getText(), text.getText(), content);
				} else {
					this.presenter.getOperator().createNewArtefact(combo.getText(), text.getText(), text_2.getText());
				}
				this.btnNewButton.setEnabled(false);
				this.setPageComplete(true);
				this.presenter.setModelProperty("buttonPushed", false);
			} 
		} else if (event.getPropertyName().equals("buttonEnable2")) {	
			if ((Boolean)event.getNewValue()) {
				this.btnCreateRelation.setEnabled(true);
			} else {
				this.btnCreateRelation.setEnabled(false);
			}
		} else if (event.getPropertyName().equals("buttonPushed2")) {	
			if ((Boolean)event.getNewValue()) {				
					this.presenter.getOperator().createNewRelation(combo_1.getText(),
							text_5.getText(),Integer.parseInt(text_3.getText()), Integer.parseInt(text_4.getText()));
					this.btnCreateRelation.setEnabled(false);
					this.setPageComplete(true);
								
				this.presenter.setModelProperty("buttonPushed2", false);
			} 
		} else if (event.getPropertyName().equals("updateRelation")) {	
			if ((Boolean)event.getNewValue()) {								
					this.presenter.getOperator().updateRelation(this.relation, combo_1.getText(),
							text_5.getText(),Integer.parseInt(text_3.getText()), Integer.parseInt(text_4.getText()));
					this.btnCreateRelation.setEnabled(false);
					this.setPageComplete(true);
				
				this.presenter.setModelProperty("updateRelation", false);
			} 
		} 
		
	}
}
