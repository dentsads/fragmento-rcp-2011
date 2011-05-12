package fragmentorcppresenter.models;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.ui.PlatformUI;

import fragmentorcp.views.RepositoryView;
import fragmentorcppresenter.ifaces.IOptionsWizardContainer;

public class datatest extends OptionsWizardBean {
	private String serviceURI;
	
	public void setServiceURI(String serviceURI) {
		this.serviceURI = serviceURI;
	}

	public String getServiceURI() {
		return serviceURI;
	}

	public datatest(IOptionsWizardContainer container) {
		super(container);
	}
	
	public boolean isValidUrl() {
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(this.getTxtserviceUri()).openConnection();
			connection.setRequestMethod("HEAD");
			int responseCode = connection.getResponseCode();
			if (responseCode != 200) {
			   return false;
			} else {
				this.setServiceURI(this.getTxtserviceUri());			
				return true;	
			}
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		return false;
		
	}

}
