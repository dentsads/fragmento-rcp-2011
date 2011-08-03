package fragmentorcp.wizards.pages;

import java.beans.PropertyChangeEvent;

//import org.eclipse.core.databinding.observable.value.IObservableValue;
//import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import fragmentorcp.Activator;
import fragmentorcppresenter.ifaces.GuiModelPropertyChange_IWizardPage;
import fragmentorcppresenter.ifaces.IOptionsWizardContainer;
import fragmentorcppresenter.presenter.Presenter;

/**
 * The Class OpenOptionsPage.
 * 
 * @author Dimitrios Dentsas
 */
public class OpenOptionsPage extends GuiModelPropertyChange_IWizardPage
		implements IOptionsWizardContainer {

	/** The txtservice uri. */
	private Text txtserviceUri;

	/** The control decoration. */
	private ControlDecoration controlDecoration;

	/** The btn apply. */
	private Button btnApply;
	// private IObservableValue txtserviceUriObservable;
	// private IObservableValue btnApplyObservable;
	// private IObservableValue btnRetrieveAllAvailableObservable;
	// private Button btnRetrieveAllAvailable;
	/** The grp retrieval options. */
	private Group grpRetrievalOptions;

	/** The btn retrieve now. */
	private Button btnRetrieveNow;

	/** The presenter. */
	private Presenter presenter;

	/** The btn keep relations for. */
	private Button btnKeepRelationsFor;

	/** The text. */
	private Text text;

	/** The label. */
	private Label label;

	/** The lbl new label. */
	private Label lblNewLabel;

	/** The btn new button. */
	private Button btnNewButton;
	private Label label_1;
	private Label lblChooseDirectoryFor;
	private Text text_1;
	private Button button;

	/**
	 * Instantiates a new open options page.
	 * 
	 * @param pageName
	 *            the page name
	 */
	public OpenOptionsPage(String pageName) {
		super(pageName);
		setTitle("Fragmento Service Options");
		setDescription("Please specify the repository service URI");

		TrayDialog.setDialogHelpAvailable(false);

		this.presenter = Activator.getDefault().getPresenter();
		this.presenter.addView(this);
		this.presenter.setNewOptionsWizardBean();

		this.setPageComplete(this.presenter.getOperator().getMock()
				.getCategories().isEmpty() ? false : true);

		this.presenter.setModelProperty("finished", false);
		this.presenter.setModelProperty("canceled", false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets
	 * .Composite)
	 */
	@Override
	public void createControl(final Composite parent) {
		String uri = presenter.getOperator().getFragmento().getServiceURI() == "" ? "http://localhost:8080/Repository/services/FragmentService?wsdl"
				: presenter.getOperator().getFragmento().getServiceURI();
		boolean initiallyEnabled = this.presenter.getOperator().getMock()
				.getCategories().isEmpty() ? false : true;

		Composite composite = new Composite(parent, SWT.NONE);
		setControl(composite);
		composite.setLayout(null);

		Group grpEdd = new Group(composite, SWT.NONE);
		grpEdd.setText("Service URI");
		grpEdd.setBounds(10, 10, 558, 149);

		Label lblUri = new Label(grpEdd, SWT.NONE);
		lblUri.setAlignment(SWT.CENTER);
		lblUri.setBounds(1, 32, 30, 25);
		lblUri.setText("URI:");
		txtserviceUri = new Text(grpEdd, SWT.BORDER);

		txtserviceUri.setText(uri);
		txtserviceUri.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				controlDecoration.show();
				controlDecoration.setDescriptionText("http(s):// ... .wsdl");
				controlDecoration.setImage(FieldDecorationRegistry
						.getDefault()
						.getFieldDecoration(
								FieldDecorationRegistry.DEC_CONTENT_PROPOSAL)
						.getImage());
			}
		});

		txtserviceUri.setBounds(43, 28, 404, 25);
		// this.txtserviceUriObservable =
		// SWTObservables.observeText(this.txtserviceUri,SWT.Modify);

		controlDecoration = new ControlDecoration(txtserviceUri, SWT.LEFT
				| SWT.TOP);
		controlDecoration.setImage(FieldDecorationRegistry.getDefault()
				.getFieldDecoration(FieldDecorationRegistry.DEC_ERROR)
				.getImage());
		controlDecoration.setDescriptionText("Service endpoint not found");
		controlDecoration.hide();

		btnApply = new Button(grpEdd, SWT.NONE);
		btnApply.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				presenter.setModelProperty("btnApply", (boolean) true);
			}
		});

		btnApply.setBounds(464, 28, 84, 27);
		btnApply.setText("Apply");
		// this.btnRetrieveAllAvailableObservable =
		// SWTObservables.observeSelection(this.btnRetrieveAllAvailable);

		btnRetrieveNow = new Button(grpEdd, SWT.NONE);
		btnRetrieveNow.setBounds(40, 94, 148, 27);
		btnRetrieveNow.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				presenter.setModelProperty("btnRetrieveNow", true);
			}
		});
		btnRetrieveNow.setText("Retrieve Repository");
		btnRetrieveNow.setEnabled(false);

		grpRetrievalOptions = new Group(composite, SWT.NONE);
		grpRetrievalOptions.setText("Options (for current repository)");
		grpRetrievalOptions.setBounds(10, 178, 558, 282);
		grpRetrievalOptions.setEnabled(initiallyEnabled);
		// this.btnApplyObservable =
		// SWTObservables.observeEnabled(this.btnApply);

		// btnRetrieveAllAvailable = new Button(grpRetrievalOptions, SWT.CHECK);
		// btnRetrieveAllAvailable.setBounds(43, 26, 359, 22);
		// btnRetrieveAllAvailable.addSelectionListener(new SelectionAdapter() {
		// @Override
		// public void widgetSelected(SelectionEvent e) {
		// if (btnRetrieveAllAvailable.getSelection()) {
		// presenter.setModelProperty("btnRetrieveAllAvailable",(boolean)true);
		// } else {
		// presenter.setModelProperty("btnRetrieveAllAvailable",(boolean)false);
		// }
		// }
		// });
		// btnRetrieveAllAvailable.setEnabled(initiallyEnabled);
		// btnRetrieveAllAvailable.setSelection(true);
		// btnRetrieveAllAvailable.setText("Retrieve all available repository items for initialization");

		btnKeepRelationsFor = new Button(grpRetrievalOptions, SWT.CHECK);
		btnKeepRelationsFor.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				presenter.setModelProperty("keepRelations",
						((Button) e.widget).getSelection());
			}
		});
		btnKeepRelationsFor.setText("keep relations for checked in artefacts");
		btnKeepRelationsFor.setEnabled(initiallyEnabled);
		btnKeepRelationsFor.setBounds(43, 54, 359, 22);
		btnKeepRelationsFor.setSelection(this.presenter.getOperator()
				.isKeepRelations());

		text = new Text(grpRetrievalOptions, SWT.BORDER);
		text.setEnabled(initiallyEnabled);
		text.setEditable(false);
		text.setBounds(43, 127, 336, 25);
		text.setText(this.presenter.getOperator().getCheckoutPath());

		lblNewLabel = new Label(grpRetrievalOptions, SWT.NONE);
		lblNewLabel.setEnabled(initiallyEnabled);
		lblNewLabel.setBounds(43, 97, 304, 15);
		lblNewLabel.setText("Choose directory for checking out artefacts");

		label = new Label(grpRetrievalOptions, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(43, 82, 400, 2);
		label.setEnabled(initiallyEnabled);

		btnNewButton = new Button(grpRetrievalOptions, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				DirectoryDialog dialog = new DirectoryDialog(parent.getShell());
				dialog.setFilterPath("");
				text.setText(dialog.open());
				presenter.setModelProperty("checkoutPath", text.getText());
			}
		});
		btnNewButton.setEnabled(initiallyEnabled);
		btnNewButton.setBounds(400, 125, 84, 27);
		btnNewButton.setText("Browse");
		
		label_1 = new Label(grpRetrievalOptions, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setEnabled(initiallyEnabled);
		label_1.setBounds(43, 169, 400, 2);
		
		lblChooseDirectoryFor = new Label(grpRetrievalOptions, SWT.NONE);
		lblChooseDirectoryFor.setText("Choose directory for exporting items");
		lblChooseDirectoryFor.setEnabled(initiallyEnabled);
		lblChooseDirectoryFor.setBounds(43, 184, 304, 15);
		
		text_1 = new Text(grpRetrievalOptions, SWT.BORDER);
		text_1.setText(this.presenter.getOperator().getExportPath());
		text_1.setEnabled(initiallyEnabled);
		text_1.setEditable(false);
		text_1.setBounds(43, 211, 336, 25);
		
		button = new Button(grpRetrievalOptions, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DirectoryDialog dialog = new DirectoryDialog(parent.getShell());
				dialog.setFilterPath("");
				text_1.setText(dialog.open());
				presenter.setModelProperty("exportPath", text_1.getText());
			}
		});
		button.setText("Browse");
		button.setEnabled(initiallyEnabled);
		button.setBounds(400, 211, 84, 27);

		// this.getWizard().performFinish();
	}

	// @Override
	// public IObservableValue getTxtserviceUriObservable() {
	// return txtserviceUriObservable;
	// }
	//
	// @Override
	// public IObservableValue getBtnApplyObservable() {
	// return btnApplyObservable;
	// }
	//
	// @Override
	// public IObservableValue getBtnRetrieveAllAvailableObservable() {
	// return btnRetrieveAllAvailableObservable;
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fragmentorcppresenter.ifaces.IGuiModelPropertyChange#modelPropertyChange
	 * (java.beans.PropertyChangeEvent)
	 */
	@Override
	public void modelPropertyChange(PropertyChangeEvent event) {
		if (event.getPropertyName().equals("btnApply")) {
			presenter.setModelProperty("btnApply", (boolean) false);
			// String newStringValue = event.getNewValue().toString();
			if (!presenter.isValidUrl(txtserviceUri.getText())) {
				controlDecoration.show();
				controlDecoration.setImage(FieldDecorationRegistry.getDefault()
						.getFieldDecoration(FieldDecorationRegistry.DEC_ERROR)
						.getImage());
				controlDecoration
						.setDescriptionText("Service endpoint not found");
				this.setMessage(null);
				// setPageComplete(false);
				// grpRetrievalOptions.setEnabled(false);
				// btnRetrieveAllAvailable.setEnabled(false);
				btnRetrieveNow.setEnabled(false);

			} else {
				presenter.getOperator().getFragmento()
						.setServiceURI(txtserviceUri.getText());
				controlDecoration.show();
				controlDecoration.setImage(FieldDecorationRegistry
						.getDefault()
						.getFieldDecoration(
								FieldDecorationRegistry.DEC_INFORMATION)
						.getImage());
				controlDecoration.setDescriptionText("Service endpoint found");
				this.setMessage("Service endpoint found, now please select further options below");
				// grpRetrievalOptions.setEnabled(true);
				// btnRetrieveAllAvailable.setEnabled(true);
				btnRetrieveNow.setEnabled(true);
				// text.setEnabled(true);

				presenter.setModelProperty("btnRetrieveAllAvailable",
						(boolean) true);

			}
		} else if (event.getPropertyName().equals("btnRetrieveAllAvailable")) {

		} else if (event.getPropertyName().equals("btnRetrieveNow")) {
			if ((Boolean) event.getNewValue()) {
				grpRetrievalOptions.setEnabled(true);
				// btnRetrieveAllAvailable.setEnabled(true);
				text.setEnabled(true);
				lblNewLabel.setEnabled(true);
				label.setEnabled(true);
				btnNewButton.setEnabled(true);
				btnKeepRelationsFor.setEnabled(true);
				setPageComplete(true);

			}
		} else if (event.getPropertyName().equals("finished")
				|| event.getPropertyName().equals("canceled")) {
			if ((Boolean) event.getNewValue()) {
				this.presenter.removeModel(this.presenter
						.getOptionsWizardBean());
				this.presenter.removeView(this);
				dispose();
			}
		}

	}
}
