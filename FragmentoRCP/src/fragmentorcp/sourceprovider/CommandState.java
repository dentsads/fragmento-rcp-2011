package fragmentorcp.sourceprovider;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.ISources;

public class CommandState extends AbstractSourceProvider {
	
	public final static String MY_STATE = "FragmentoRCP.active";
	public final static String ENABLED = "ENABLED";
	public final static String DISENABLED = "DISENABLED";
	private boolean enabled = true;
	
	public CommandState() {
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map getCurrentState() {
		Map map = new HashMap(1);
		String value = enabled ? ENABLED : DISENABLED;
		map.put(MY_STATE, value);
		return map;
	}

	@Override
	public String[] getProvidedSourceNames() {
		return new String[] { MY_STATE };
	}

	public void toogleEnabled() {
		enabled = !enabled ;
		String value = enabled ? ENABLED : DISENABLED;
		fireSourceChanged(ISources.WORKBENCH, MY_STATE, value);
	}
}
