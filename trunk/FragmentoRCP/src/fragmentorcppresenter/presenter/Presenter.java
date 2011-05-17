package fragmentorcppresenter.presenter;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import fragmentorcppresenter.ifaces.IGuiModelPropertyChange;
import fragmentorcppresenter.models.ModelAbstraction;
import fragmentorcppresenter.models.OptionsWizardBean;
import fragmentorcppresenter.models.RepositoryViewBean;

public class Presenter extends PresenterAbstraction<IGuiModelPropertyChange>{
	
	private ModelAbstraction model;
	
	public Presenter() {
		
		this.model = new OptionsWizardBean();
		this.addModel(model);
		this.model = new RepositoryViewBean();
		this.addModel(model);
		
	}
	
	
	public boolean isValidUrl(String url) {
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestMethod("HEAD");		
			int responseCode = connection.getResponseCode();
			if (responseCode != 200 || !connection.getContentType().contains("xml")) {
			   return false;
			} else {	
				return true;	
			}
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		return false;
		
	}
}
