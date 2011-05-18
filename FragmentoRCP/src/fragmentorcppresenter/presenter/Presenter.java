package fragmentorcppresenter.presenter;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import fragmentorcppresenter.ifaces.IGuiModelPropertyChange;
import fragmentorcppresenter.models.ModelAbstraction;
import fragmentorcppresenter.models.OptionsWizardBean;
import fragmentorcppresenter.models.RepositoryViewBean;
import fragmentorcppresenter.models.SearchWizardBean;

public class Presenter extends PresenterAbstraction<IGuiModelPropertyChange>{
	
	private ModelAbstraction optionsWizardBean;
	private ModelAbstraction repostoryViewBean;
	private ModelAbstraction searchWizardBean;
	
	public Presenter() {	
	}
	
	public ModelAbstraction getOptionsWizardBean() {
		return optionsWizardBean;
	}

	public ModelAbstraction getRepostoryViewBean() {
		return repostoryViewBean;
	}
	
	public ModelAbstraction getSearchWizardBean() {
		return searchWizardBean;
	}
	
	public void setNewOptionsWizardBean() {
		this.optionsWizardBean = new OptionsWizardBean();
		this.addModel(this.optionsWizardBean);
	}

	public void setNewRepostoryViewBean() {
		this.repostoryViewBean = new RepositoryViewBean();
		this.addModel(this.repostoryViewBean);
	}
	
	public void setNewSearchWizardBean() {
		this.searchWizardBean = new SearchWizardBean();
		this.addModel(this.searchWizardBean);
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
