package fragmentorcp.wizards.openoptions;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;


import fragmentorcppresenter.ifaces.IOptionsWizardContainer;
import fragmentorcppresenter.models.datatest;

public class OpenOptionsPage extends WizardPage implements IOptionsWizardContainer{
	private Text txtserviceUri;
	private ControlDecoration controlDecoration;
	private Button btnApply;
	private IObservableValue txtserviceUriObservable;
	private IObservableValue btnApplyObservable;
	private IObservableValue btnRetrieveAllAvailableObservable;
	private datatest test;
	private Button btnRetrieveAllAvailable;
	
	public OpenOptionsPage(String pageName) {
		super(pageName);
		
		setTitle("Fragmento Service Options");
        setDescription("Please specify the repository service URI");
        
        this.setPageComplete(false);
        TrayDialog.setDialogHelpAvailable(false);
	}

	@Override
	public void createControl(Composite parent) {
		
		Composite composite = new Composite(parent, SWT.NONE);
         setControl(composite);
         composite.setLayout(null);
         
         Group grpEdd = new Group(composite, SWT.NONE);
         grpEdd.setText("Service URI");
         grpEdd.setBounds(10, 10, 558, 115);
         
         Label lblUri = new Label(grpEdd, SWT.NONE);
         lblUri.setAlignment(SWT.CENTER);
         lblUri.setBounds(1, 28, 30, 25);
         lblUri.setText("URI:");
         
         txtserviceUri = new Text(grpEdd, SWT.BORDER);
         txtserviceUri.addFocusListener(new FocusAdapter() {
         	@Override
         	public void focusGained(FocusEvent e) {
         		controlDecoration.show();
         		controlDecoration.setDescriptionText("http(s):// ... .wsdl");
         		controlDecoration.setImage(FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_CONTENT_PROPOSAL).getImage());
         	}
         });
                  
         txtserviceUri.setBounds(43, 28, 404, 25);
         this.txtserviceUriObservable = SWTObservables.observeText(this.txtserviceUri,SWT.Modify);     
         
         controlDecoration = new ControlDecoration(txtserviceUri, SWT.LEFT | SWT.TOP);
         controlDecoration.setImage(FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR).getImage());
         controlDecoration.setDescriptionText("Service endpoint not found");
         controlDecoration.hide();
         
         btnApply = new Button(grpEdd, SWT.NONE);
         btnApply.addSelectionListener(new SelectionAdapter() {
         	@Override
         	public void widgetSelected(SelectionEvent e) {       		         		
         		if (!test.isValidUrl()) {
         			controlDecoration.show();
         			controlDecoration.setImage(FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR).getImage());
         	        controlDecoration.setDescriptionText("Service endpoint not found");
         	       setPageComplete(false);
				} else {
					controlDecoration.show();
         			controlDecoration.setImage(FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION).getImage());
         	        controlDecoration.setDescriptionText("Service endpoint found");
         	        setPageComplete(true);
				}
         		
         	}
         });
         
         btnApply.setBounds(464, 28, 84, 27);
         btnApply.setText("Apply");
         this.btnApplyObservable = SWTObservables.observeEnabled(this.btnApply);
             
         btnRetrieveAllAvailable = new Button(grpEdd, SWT.CHECK);
         btnRetrieveAllAvailable.setSelection(true);
         btnRetrieveAllAvailable.setBounds(44, 72, 359, 22);
         btnRetrieveAllAvailable.setText("Retrieve all available repository items for initialization");
         this.btnRetrieveAllAvailableObservable = SWTObservables.observeSelection(this.btnRetrieveAllAvailable);
         
         test = new datatest(this);  
	}


	public IObservableValue getTxtserviceUriObservable() {
		return txtserviceUriObservable;
	}

	public IObservableValue getBtnApplyObservable() {
		return btnApplyObservable;
	}
	
	public IObservableValue getBtnRetrieveAllAvailableObservable() {
		return btnRetrieveAllAvailableObservable;
	}
}
