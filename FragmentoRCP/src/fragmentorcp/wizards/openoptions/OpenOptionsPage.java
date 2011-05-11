package fragmentorcp.wizards.openoptions;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.fieldassist.ControlDecorationSupport;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.swt.WidgetProperties;
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
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;


import fragmentorcp.models.OptionsWizardBean;

public class OpenOptionsPage extends WizardPage implements Listener {
	private Text txtserviceUri;
	private ControlDecoration controlDecoration;
	private Button btnApply;
	
	private OptionsWizardBean bean = new OptionsWizardBean();
	
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
         
         controlDecoration = new ControlDecoration(txtserviceUri, SWT.LEFT | SWT.TOP);
         controlDecoration.setImage(FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR).getImage());
         //controlDecoration.setImage(SWTResourceManager.getImage(OpenOptionsPage.class, "/org/eclipse/jface/fieldassist/images/error_ovr.gif"));
         controlDecoration.setDescriptionText("Service endpoint not found");
         
         btnApply = new Button(grpEdd, SWT.NONE);
         btnApply.addSelectionListener(new SelectionAdapter() {
         	@Override
         	public void widgetSelected(SelectionEvent e) {
         		controlDecoration.show();
         	}
         });
         //btnApply.addListener(SWT.Selection, this);
         btnApply.setBounds(464, 28, 84, 27);
         btnApply.setText("Apply");
         
         Button btnRetrieveAllAvailable = new Button(grpEdd, SWT.CHECK);
         btnRetrieveAllAvailable.setSelection(true);
         btnRetrieveAllAvailable.setBounds(44, 72, 359, 22);
         btnRetrieveAllAvailable.setText("Retrieve all available repository items for initialization");
         //setErrorMessage("basdfsdf");
         //setMessage("sdfweeeeee");
         
         bindValues();      
	}

	@Override
	public void handleEvent(Event event) {		  
	}
	
	private void bindValues() {
		
		DataBindingContext bindingContext = new DataBindingContext();
		IObservableValue widgetValue = WidgetProperties.text(SWT.Modify)
				.observe(txtserviceUri);
		IObservableValue modelValue = BeanProperties.value(OptionsWizardBean.class,
				"txtserviceUri").observe(bean);
		bindingContext.bindValue(widgetValue, modelValue);		
				
	}
}
