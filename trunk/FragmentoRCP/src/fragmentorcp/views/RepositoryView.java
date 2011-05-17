package fragmentorcp.views;

import java.beans.PropertyChangeEvent;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;

import fragmentorcp.Activator;
import fragmentorcppresenter.ifaces.GuiModelPropertyChange_IViewPart;
import fragmentorcppresenter.ifaces.IRepositoryViewContainer;
import fragmentorcppresenter.presenter.Presenter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;


public class RepositoryView extends GuiModelPropertyChange_IViewPart implements IRepositoryViewContainer {
	
	public static final String ID = "FragmentoRCP.RepositoryView";
	private IObservableValue serviceURIObservable;
	private Text text;
	private Button btnTest;
	
	private Presenter presenter;
	
	public RepositoryView() {
		
		this.presenter = Activator.getDefault().getPresenter();
        this.presenter.addView(this);
	}

	@Override
	public void createPartControl(Composite parent) {
		
		Composite composite = new Composite(parent, SWT.NONE);
		
		text = new Text(composite, SWT.BORDER);				
		text.setBounds(72, 60, 185, 25);
		this.serviceURIObservable = SWTObservables.observeText(this.text,SWT.Modify);
		btnTest = new Button(composite, SWT.NONE);
		btnTest.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnTest.setBounds(72, 106, 84, 27);
		btnTest.setText("test");
	}
	

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	public IObservableValue getServiceURIObservable() {
		return serviceURIObservable;
	}

	@Override
	public void modelPropertyChange(PropertyChangeEvent event) {
		if (event.getPropertyName().equals("text")) {
			text.setText(event.getNewValue().toString());
		}
		
	}
	
}
