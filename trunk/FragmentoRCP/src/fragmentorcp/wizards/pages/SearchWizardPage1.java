package fragmentorcp.wizards.pages;

import java.beans.PropertyChangeEvent;

import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.DateTime;

import fragmentorcp.Activator;
import fragmentorcppresenter.ifaces.GuiModelPropertyChange_IWizardPage;
import fragmentorcppresenter.presenter.Presenter;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

public class SearchWizardPage1 extends GuiModelPropertyChange_IWizardPage  {
	private Text text;
	private Text text_1;
	private Combo combo;
	private Group grpSearchInThe;
	private Label lblSearchForContained;
	private Group grpSearchInThe_1;
	private Label label;
	private Group grpSearchForType;
	private Label lblSearchForType;
	private Combo combo_1;
	private Group grpSearchByDate;
	private Label lblStartDayOf;
	private Label lblNewLabel;
	private DateTime dateTime;
	private DateTime dateTime_1;
	private Group group;
	private Label label_1;
	private Label label_2;
	private DateTime dateTime_2;
	private DateTime dateTime_3;
	private Label label_3;
	private Combo combo_2;
	private Combo combo_3;
	private Label label_4;
	private Label label_5;
	private Group group_1;
	private Label label_6;
	private Combo combo_4;
	private Group grpSearchBySource;
	private Label lblSearchForSource;
	private Text text_2;
	private Group grpSearchByTarget;
	private Label lblSearchForTarget;
	private Text text_3;
	private Group group_4;
	private Label label_9;
	private Label label_10;
	private DateTime dateTime_4;
	private DateTime dateTime_5;
	private Group group_5;
	private Label label_11;
	private Label label_12;
	private DateTime dateTime_6;
	private DateTime dateTime_7;
	private Label label_13;
	private Combo combo_5;
	
	private Presenter presenter;
	private Button btnSearch;
	
	public SearchWizardPage1(String pageName) {
		super(pageName);
		
		setTitle("Fragmento Search");
        setDescription("Please specify the needed search parameters");
        
        this.setPageComplete(false);
        TrayDialog.setDialogHelpAvailable(false);
        
        this.presenter = Activator.getDefault().getPresenter();
        this.presenter.addView(this);
        this.presenter.setNewSearchWizardBean();
	}

	@Override
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
        setControl(composite);
        composite.setLayout(null);
        
        TabFolder tabFolder = new TabFolder(composite, SWT.NONE);
        tabFolder.setBounds(0, 0, 582, 772);
        
        TabItem tbtmNewItem = new TabItem(tabFolder, SWT.NONE);
        tbtmNewItem.setText("Artefacts Search");
        
        Composite composite_1 = new Composite(tabFolder, SWT.NONE);
        tbtmNewItem.setControl(composite_1);
        composite_1.setLayout(null);
        
        ////////////////////ARTEFACTS SEARCH////////////////////////
        
        combo = new Combo(composite_1, SWT.NONE | SWT.READ_ONLY);
        combo.setItems(new String[] {"Search in the Description", "Search in the Content", "Search by Type", "Search by Date", "Search by Date and Type"});
        combo.setBounds(232, 32, 194, 27);       
             
        combo.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
               if (combo.getText().equals(combo.getItems()[0])) {
            	   comboItemEnabler(0,0); 
            	   btnSearch.setEnabled(true);
               } else if (combo.getText().equals(combo.getItems()[1])) {
            	   comboItemEnabler(1,0);
            	   btnSearch.setEnabled(true);
               } else if (combo.getText().equals(combo.getItems()[2])) {
            	   comboItemEnabler(2,0);
            	   btnSearch.setEnabled(true);
               } else if (combo.getText().equals(combo.getItems()[3])) {
            	   comboItemEnabler(3,0);
            	   btnSearch.setEnabled(true);
               } else if (combo.getText().equals(combo.getItems()[4])) {
            	   comboItemEnabler(4,0);
            	   btnSearch.setEnabled(true);
               } else if (combo.getText().equals(combo.getItems()[5])) {
            	   comboItemEnabler(5,0);
            	   btnSearch.setEnabled(true);
               }
            }
           });
        
        Label lblPleaseSpecifyThe = new Label(composite_1, SWT.NONE);
        lblPleaseSpecifyThe.setBounds(22, 38, 204, 15);
        lblPleaseSpecifyThe.setText("Please specify the search type:");
        
        Label lblSep = new Label(composite_1, SWT.SEPARATOR | SWT.HORIZONTAL);
        lblSep.setText("sep1");
        lblSep.setBounds(22, 76, 520, 2);
        
        grpSearchInThe = new Group(composite_1, SWT.NONE);
        grpSearchInThe.setEnabled(false);
        grpSearchInThe.setText("Search in the Description");
        grpSearchInThe.setBounds(22, 97, 520, 81);
        
        lblSearchForContained = new Label(grpSearchInThe, SWT.NONE);
        lblSearchForContained.setEnabled(false);
        lblSearchForContained.setBounds(10, 34, 184, 15);
        lblSearchForContained.setText("Search for contained String:");
        
        text = new Text(grpSearchInThe, SWT.BORDER);
        text.addModifyListener(new ModifyListener() {
        	public void modifyText(ModifyEvent e) {
        		presenter.setModelProperty("text", text.getText());
        	}
        });
        text.setEnabled(false);
        text.setBounds(200, 30, 310, 25);
        
        grpSearchInThe_1 = new Group(composite_1, SWT.NONE);
        grpSearchInThe_1.setEnabled(false);
        grpSearchInThe_1.setText("Search in the Content");
        grpSearchInThe_1.setBounds(22, 190, 520, 81);
        
        label = new Label(grpSearchInThe_1, SWT.NONE);
        label.setEnabled(false);
        label.setText("Search for contained String:");
        label.setBounds(10, 34, 184, 15);
        
        text_1 = new Text(grpSearchInThe_1, SWT.BORDER);
        text_1.addModifyListener(new ModifyListener() {
        	public void modifyText(ModifyEvent e) {
        		presenter.setModelProperty("text_1", text_1.getText());
        	}
        });
        text_1.setEnabled(false);
        text_1.setBounds(200, 30, 310, 25);
        
        grpSearchForType = new Group(composite_1, SWT.NONE);
        grpSearchForType.setEnabled(false);
        grpSearchForType.setText("Search by Type");
        grpSearchForType.setBounds(22, 286, 520, 81);
        
        lblSearchForType = new Label(grpSearchForType, SWT.NONE);
        lblSearchForType.setEnabled(false);
        lblSearchForType.setText("Search for Type:");
        lblSearchForType.setBounds(10, 34, 184, 15);
        
        combo_1 = new Combo(grpSearchForType, SWT.NONE | SWT.READ_ONLY);
        combo_1.addSelectionListener(new SelectionAdapter() {
        	@Override
        	public void widgetSelected(SelectionEvent e) {
        		presenter.setModelProperty("combo_1", combo_1.getText());
        	}
        });
        combo_1.setEnabled(false);
        combo_1.setItems(new String[] {"Annotation", "Container", "Deployment Descriptor", "Fragment", "Modeller Data", "Process", "Transformation Rule", "WSDL"});
        combo_1.setBounds(200, 27, 187, 27);
        
        grpSearchByDate = new Group(composite_1, SWT.NONE);
        grpSearchByDate.setEnabled(false);
        grpSearchByDate.setText("Search by Date");
        grpSearchByDate.setBounds(22, 383, 520, 110);
        
        lblStartDayOf = new Label(grpSearchByDate, SWT.NONE);
        lblStartDayOf.setEnabled(false);
        lblStartDayOf.setText("Start Date of Creation:");
        lblStartDayOf.setBounds(10, 34, 184, 15);
        
        lblNewLabel = new Label(grpSearchByDate, SWT.NONE);
        lblNewLabel.setEnabled(false);
        lblNewLabel.setBounds(10, 70, 184, 15);
        lblNewLabel.setText("End Date of Creation:");
        
        dateTime = new DateTime(grpSearchByDate, SWT.BORDER);
        dateTime.setEnabled(false);
        dateTime.setBounds(200, 27, 108, 29);
        dateTime_1 = new DateTime(grpSearchByDate, SWT.BORDER);
        dateTime_1.setEnabled(false);
        dateTime_1.setBounds(200, 62, 108, 29);
        
        group = new Group(composite_1, SWT.NONE);
        group.setEnabled(false);
        group.setText("Search by Date and Type");
        group.setBounds(22, 507, 520, 173);
        
        label_1 = new Label(group, SWT.NONE);
        label_1.setEnabled(false);
        label_1.setText("Start Date of Creation:");
        label_1.setBounds(10, 82, 184, 15);
        
        label_2 = new Label(group, SWT.NONE);
        label_2.setEnabled(false);
        label_2.setText("End Date of Creation:");
        label_2.setBounds(10, 118, 184, 15);
        
        dateTime_2 = new DateTime(group, SWT.BORDER);
        dateTime_2.setEnabled(false);
        dateTime_2.setBounds(200, 75, 108, 29);
        
        dateTime_3 = new DateTime(group, SWT.BORDER);
        dateTime_3.setEnabled(false);
        dateTime_3.setBounds(200, 110, 108, 29);
        
        label_3 = new Label(group, SWT.NONE);
        label_3.setEnabled(false);
        label_3.setText("Search for Type:");
        label_3.setBounds(10, 41, 184, 15);
        
        combo_2 = new Combo(group, SWT.NONE | SWT.READ_ONLY);
        combo_2.setEnabled(false);
        combo_2.setItems(new String[] {"Annotation", "Container", "Deployment Descriptor", "Fragment", "Modeller Data", "Process", "Transformation Rule", "WSDL"});
        combo_2.setBounds(200, 34, 187, 27);
        
        btnSearch = new Button(composite_1, SWT.NONE);
        btnSearch.addSelectionListener(new SelectionAdapter() {
        	@Override
        	public void widgetSelected(SelectionEvent e) {
        		presenter.setModelProperty("btnSearch", true);
        	}
        });
        btnSearch.setBounds(458, 691, 84, 27);
        btnSearch.setText("Search");
        btnSearch.setEnabled(false);
        
        Label lblNewLabel_1 = new Label(composite_1, SWT.NONE);
        lblNewLabel_1.setBounds(203, 691, 249, 15);
        lblNewLabel_1.setText("New Label");
        
        //////////////////// RELATIONS SEARCH////////////////////////
        
        TabItem tbtmRelationSearch = new TabItem(tabFolder, SWT.NONE);
        tbtmRelationSearch.setText("Relations Search");
        
        Composite composite_2 = new Composite(tabFolder, SWT.NONE);
        tbtmRelationSearch.setControl(composite_2);
        composite_2.setLayout(null);
        
        combo_3 = new Combo(composite_2, SWT.READ_ONLY);
        combo_3.setItems(new String[] {"Search by Type", "Search by Source Id", "Search by Target Id", "Search by Date", "Search by Date and Type"});
        combo_3.setBounds(232, 32, 194, 27);
        
        combo_3.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
               if (combo_3.getText().equals(combo_3.getItems()[0])) {
            	   comboItemEnabler(0,1);
               } else if (combo_3.getText().equals(combo_3.getItems()[1])) {
            	   comboItemEnabler(1,1);
               } else if (combo_3.getText().equals(combo_3.getItems()[2])) {
            	   comboItemEnabler(2,1);
               } else if (combo_3.getText().equals(combo_3.getItems()[3])) {
            	   comboItemEnabler(3,1);
               } else if (combo_3.getText().equals(combo_3.getItems()[4])) {
            	   comboItemEnabler(4,1);
               } else if (combo_3.getText().equals(combo_3.getItems()[5])) {
            	   comboItemEnabler(5,1);
               }
            }
           });
        
        label_4 = new Label(composite_2, SWT.NONE);
        label_4.setText("Please specify the search type:");
        label_4.setBounds(22, 38, 204, 15);
        
        label_5 = new Label(composite_2, SWT.SEPARATOR | SWT.HORIZONTAL);
        label_5.setText("sep1");
        label_5.setBounds(22, 76, 520, 2);
        
        group_1 = new Group(composite_2, SWT.NONE);
        group_1.setText("Search by Type");
        group_1.setEnabled(false);
        group_1.setBounds(22, 97, 520, 81);
        
        label_6 = new Label(group_1, SWT.NONE);
        label_6.setText("Search for Type:");
        label_6.setEnabled(false);
        label_6.setBounds(10, 34, 184, 15);
        
        combo_4 = new Combo(group_1, SWT.READ_ONLY);
        combo_4.setItems(new String[] {"annotation", "container", "wsdl", "deployment", "modeller", "transformation"});
        combo_4.setEnabled(false);
        combo_4.setBounds(200, 27, 187, 27);
        
        grpSearchBySource = new Group(composite_2, SWT.NONE);
        grpSearchBySource.setText("Search by Source Id");
        grpSearchBySource.setEnabled(false);
        grpSearchBySource.setBounds(22, 191, 520, 81);
        
        lblSearchForSource = new Label(grpSearchBySource, SWT.NONE);
        lblSearchForSource.setText("Search for Source Id:");
        lblSearchForSource.setEnabled(false);
        lblSearchForSource.setBounds(10, 34, 184, 15);
        
        text_2 = new Text(grpSearchBySource, SWT.BORDER);
        text_2.setEnabled(false);
        text_2.setBounds(200, 30, 310, 25);
        
        grpSearchByTarget = new Group(composite_2, SWT.NONE);
        grpSearchByTarget.setText("Search by Target Id");
        grpSearchByTarget.setEnabled(false);
        grpSearchByTarget.setBounds(22, 285, 520, 81);
        
        lblSearchForTarget = new Label(grpSearchByTarget, SWT.NONE);
        lblSearchForTarget.setText("Search for Target Id:");
        lblSearchForTarget.setEnabled(false);
        lblSearchForTarget.setBounds(10, 34, 184, 15);
        
        text_3 = new Text(grpSearchByTarget, SWT.BORDER);
        text_3.setEnabled(false);
        text_3.setBounds(200, 30, 310, 25);
        
        group_4 = new Group(composite_2, SWT.NONE);
        group_4.setText("Search by Date");
        group_4.setEnabled(false);
        group_4.setBounds(22, 375, 520, 110);
        
        label_9 = new Label(group_4, SWT.NONE);
        label_9.setText("Start Date of Creation:");
        label_9.setEnabled(false);
        label_9.setBounds(10, 34, 184, 15);
        
        label_10 = new Label(group_4, SWT.NONE);
        label_10.setText("End Date of Creation:");
        label_10.setEnabled(false);
        label_10.setBounds(10, 70, 184, 15);
        
        dateTime_4 = new DateTime(group_4, SWT.BORDER);
        dateTime_4.setEnabled(false);
        dateTime_4.setBounds(200, 27, 108, 29);
        
        dateTime_5 = new DateTime(group_4, SWT.BORDER);
        dateTime_5.setEnabled(false);
        dateTime_5.setBounds(200, 62, 108, 29);
        
        group_5 = new Group(composite_2, SWT.NONE);
        group_5.setText("Search by Date and Type");
        group_5.setEnabled(false);
        group_5.setBounds(22, 499, 520, 173);
        
        label_11 = new Label(group_5, SWT.NONE);
        label_11.setText("Start Date of Creation:");
        label_11.setEnabled(false);
        label_11.setBounds(10, 82, 184, 15);
        
        label_12 = new Label(group_5, SWT.NONE);
        label_12.setText("End Date of Creation:");
        label_12.setEnabled(false);
        label_12.setBounds(10, 118, 184, 15);
        
        dateTime_6 = new DateTime(group_5, SWT.BORDER);
        dateTime_6.setEnabled(false);
        dateTime_6.setBounds(200, 75, 108, 29);
        
        dateTime_7 = new DateTime(group_5, SWT.BORDER);
        dateTime_7.setEnabled(false);
        dateTime_7.setBounds(200, 110, 108, 29);
        
        label_13 = new Label(group_5, SWT.NONE);
        label_13.setText("Search for Type:");
        label_13.setEnabled(false);
        label_13.setBounds(10, 41, 184, 15);
        
        combo_5 = new Combo(group_5, SWT.READ_ONLY);
        combo_5.setItems(new String[] {"Annotation", "Container", "Deployment Descriptor", "Fragment", "Modeller Data", "Process", "Transformation Rule", "WSDL"});
        combo_5.setEnabled(false);
        combo_5.setBounds(200, 34, 187, 27);
        
        Button btnSearch_1 = new Button(composite_2, SWT.NONE);
        btnSearch_1.setBounds(458, 687, 84, 27);
        btnSearch_1.setText("Search");
        
        Label lblNewLabel_2 = new Label(composite_2, SWT.NONE);
        lblNewLabel_2.setBounds(246, 699, 206, 15);
        lblNewLabel_2.setText("New Label");

	}
	
	private void comboItemEnabler(int item, int category) {
		boolean itembool0 = false;
		boolean itembool1 = false;
		boolean itembool2 = false;
		boolean itembool3 = false;
		boolean itembool4 = false;
		
		switch (item) {
		case 0:
			itembool0 = true;
			itembool1 = false;
			itembool2 = false;
			itembool3 = false;
			itembool4 = false;
			break;
		case 1:
			itembool0 = false;
			itembool1 = true;
			itembool2 = false;
			itembool3 = false;
			itembool4 = false;
			break;
			
		case 2:
			itembool0 = false;
			itembool1 = false;
			itembool2 = true;
			itembool3 = false;
			itembool4 = false;
			break;
		case 3:
			itembool0 = false;
			itembool1 = false;
			itembool2 = false;
			itembool3 = true;
			itembool4 = false;
			break;
		case 4:
			itembool0 = false;
			itembool1 = false;
			itembool2 = false;
			itembool3 = false;
			itembool4 = true;
			break;
		default:
			break;
		}
		if (category == 0) {
		
		   grpSearchInThe.setEnabled(itembool0);
	 	   lblSearchForContained.setEnabled(itembool0);
	 	   text.setEnabled(itembool0);
	 	   
	 	  grpSearchInThe_1.setEnabled(itembool1);
		   label.setEnabled(itembool1);
		   text_1.setEnabled(itembool1);
		   
		   grpSearchForType.setEnabled(itembool2);
		   lblSearchForType.setEnabled(itembool2);
		   combo_1.setEnabled(itembool2);
		   
		   grpSearchByDate.setEnabled(itembool3);
		   lblStartDayOf.setEnabled(itembool3);
		   lblNewLabel.setEnabled(itembool3);
		   dateTime.setEnabled(itembool3);
		   dateTime_1.setEnabled(itembool3);
		   
		   group.setEnabled(itembool4);
		   label_1.setEnabled(itembool4);
		   label_2.setEnabled(itembool4);
		   dateTime_2.setEnabled(itembool4);
		   dateTime_3.setEnabled(itembool4);
		   label_3.setEnabled(itembool4);
		   combo_2.setEnabled(itembool4);
		}
	   ///RELATIONS///
	   
		if (category == 1) {		
		   group_1.setEnabled(itembool0);
		   label_6.setEnabled(itembool0);
		   combo_4.setEnabled(itembool0);
		   
		   grpSearchBySource.setEnabled(itembool1);
		   lblSearchForSource.setEnabled(itembool1);
		   text_2.setEnabled(itembool1);
		   
		   grpSearchByTarget.setEnabled(itembool2);
		   lblSearchForTarget.setEnabled(itembool2);
		   text_3.setEnabled(itembool2);
		   
		   group_4.setEnabled(itembool3);
		   label_9.setEnabled(itembool3);
		   label_10.setEnabled(itembool3);
		   dateTime_4.setEnabled(itembool3);
		   dateTime_5.setEnabled(itembool3);
		   
		   group_5.setEnabled(itembool4);
		   label_11.setEnabled(itembool4);
		   label_12.setEnabled(itembool4);
		   dateTime_6.setEnabled(itembool4);
		   dateTime_7.setEnabled(itembool4);
		   label_13.setEnabled(itembool4);
		   combo_5.setEnabled(itembool4);	   
		}
	}

	@Override
	public void modelPropertyChange(PropertyChangeEvent event) {
		if (event.getPropertyName().equals("finished") || event.getPropertyName().equals("canceled")) {	
			this.presenter.removeModel(this.presenter.getSearchWizardBean());
			this.presenter.removeView(this);			
			dispose();	
		} else if (event.getPropertyName().equals("btnSearch")) {
			if ((Boolean)event.getNewValue()) {
				if (combo.getText().equals(combo.getItems()[0])) {
					 this.presenter.getOperator().browseArtefactDescription(text.getText());
	               } else if (combo.getText().equals(combo.getItems()[1])) {
	               } else if (combo.getText().equals(combo.getItems()[2])) {
	            	   this.presenter.getOperator().browseArtefactType(combo_1.getText());	   
	               } else if (combo.getText().equals(combo.getItems()[3])) {         	   
	               } else if (combo.getText().equals(combo.getItems()[4])) {
	               } else if (combo.getText().equals(combo.getItems()[5])) {
	               }
				this.setPageComplete(true);
				this.presenter.setModelProperty("btnSearch", false);
			}
		} 
		
	}
}
