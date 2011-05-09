package fragmentorcp.wizards.openoptions;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Listener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Button;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;

public class OpenOptionsPage extends WizardPage implements Listener {
	private Text txtserviceUri;
	private ControlDecoration controlDecoration;
	private Button btnApply;
	
	public OpenOptionsPage(String pageName) {
		super(pageName);
		
		setTitle("Fragmento Service Options");
        setDescription("Please specify the repository service URI");
        
        this.setPageComplete(false);
       // controlDecoration.hide();
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
         
	}
	
	@Override
	public void handleEvent(Event event) {		  
	}
}
