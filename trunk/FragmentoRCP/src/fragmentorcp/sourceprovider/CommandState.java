package fragmentorcp.sourceprovider;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.ISources;

import fragmentorcp.Activator;
import fragmentorcppresenter.presenter.Presenter;

/**
 * The Class CommandState takes the current predefined visibility state of the
 * view toolbar, manages it and provides methods for changing it.
 * 
 * @author Dimitrios Dentsas
 */
public class CommandState extends AbstractSourceProvider {

	/** The Constant MY_STATE. */
	public final static String MY_STATE = "FragmentoRCP.active";

	/** The Constant ENABLED. */
	public final static String ENABLED = "ENABLED";

	/** The Constant DISENABLED. */
	public final static String DISENABLED = "DISENABLED";

	/** The enabled. */
	private boolean enabled;
	
	/** The presenter. */
	private Presenter presenter;
	
	/**
	 * Instantiates a new command state.
	 */
	public CommandState() {
		this.presenter = Activator.getDefault().getPresenter();
		enabled = this.presenter.isSerialized("serial.ser") ? true : false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.ISourceProvider#dispose()
	 */
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.ISourceProvider#getCurrentState()
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map getCurrentState() {
		Map map = new HashMap(1);
		String value = enabled ? ENABLED : DISENABLED;
		map.put(MY_STATE, value);
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.ISourceProvider#getProvidedSourceNames()
	 */
	@Override
	public String[] getProvidedSourceNames() {
		return new String[] { MY_STATE };
	}

	/**
	 * Toggles the state from enabled to disabled and vice versa.
	 */
	public void toogleEnabled() {
		enabled = !enabled;
		String value = enabled ? ENABLED : DISENABLED;
		fireSourceChanged(ISources.WORKBENCH, MY_STATE, value);
	}

	/**
	 * Enable.
	 */
	public void enable() {
		fireSourceChanged(ISources.WORKBENCH, MY_STATE, ENABLED);
	}
	
}
