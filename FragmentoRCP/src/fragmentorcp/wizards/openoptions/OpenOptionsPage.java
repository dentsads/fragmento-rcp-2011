package fragmentorcp.wizards.openoptions;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
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


import fragmentorcppresenter.ifaces.IViewContainer;
import fragmentorcppresenter.models.OptionsWizardBean;

public class OpenOptionsPage extends WizardPage implements IViewContainer{
	private Text txtserviceUri;
	private ControlDecoration controlDecoration;
	private Button btnApply;
	private IObservableValue txtserviceUriObservable;
	private IObservableValue btnApplyObservable;	
	private OptionsWizardBean bean;
	
	public OpenOptionsPage(String pageName) {
		super(pageName);
		
		setTitle("Fragmento Service Options");
        setDescription("Please specify the repository service URI");
        
        this.setPageComplete(false);
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
         		controlDecoration.hide();
         	}
         });
         txtserviceUri.setMessage("http(s)://");
         txtserviceUri.setBounds(43, 28, 404, 25);
         this.txtserviceUriObservable = SWTObservables.observeText(this.txtserviceUri,SWT.Modify);
         
         controlDecoration = new ControlDecoration(txtserviceUri, SWT.LEFT | SWT.TOP);
         controlDecoration.setImage(FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR).getImage());
         controlDecoration.setDescriptionText("Service endpoint not found");
         
         btnApply = new Button(grpEdd, SWT.NONE);
         btnApply.addSelectionListener(new SelectionAdapter() {
         	@Override
         	public void widgetSelected(SelectionEvent e) {
         		controlDecoration.show();
         	}
         });

         btnApply.setBounds(464, 28, 84, 27);
         btnApply.setText("Apply");
         this.btnApplyObservable = SWTObservables.observeSelection(this.btnApply);
         
         Button btnRetrieveAllAvailable = new Button(grpEdd, SWT.CHECK);
         btnRetrieveAllAvailable.setSelection(true);
         btnRetrieveAllAvailable.setBounds(44, 72, 359, 22);
         btnRetrieveAllAvailable.setText("Retrieve all available repository items for initialization");
                 
         bean = new OptionsWizardBean(this);
	}


	public IObservableValue getTxtserviceUriObservable() {
		return txtserviceUriObservable;
	}

	public IObservableValue getBtnApplyObservable() {
		return btnApplyObservable;
	}
}
