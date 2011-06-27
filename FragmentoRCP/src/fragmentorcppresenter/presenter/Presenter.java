package fragmentorcppresenter.presenter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

import fragmentorcp.views.treeviewer.provider.TreeViewerOperator;
import fragmentorcppresenter.ifaces.IGuiModelPropertyChange;
import fragmentorcppresenter.models.CreateNewItemBean;
import fragmentorcppresenter.models.ModelAbstraction;
import fragmentorcppresenter.models.OptionsWizardBean;
import fragmentorcppresenter.models.RepositoryViewBean;
import fragmentorcppresenter.models.SearchWizardBean;

/**
 * The Class Presenter.
 *
 * @author Dimitrios Dentsas
 */
public class Presenter extends PresenterAbstraction<IGuiModelPropertyChange>{
	
	/** The options wizard bean. */
	private ModelAbstraction optionsWizardBean;
	
	/** The repostory view bean. */
	private ModelAbstraction repostoryViewBean;
	
	/** The search wizard bean. */
	private ModelAbstraction searchWizardBean;
	
	/** The create new item bean. */
	private ModelAbstraction createNewItemBean;
	
	/** The operator. */
	private TreeViewerOperator operator;
	
	/**
	 * Instantiates a new presenter.
	 */
	public Presenter() {	
	}
	
	/**
	 * Gets the options wizard bean.
	 *
	 * @return the options wizard bean
	 */
	public ModelAbstraction getOptionsWizardBean() {
		return optionsWizardBean;
	}

	/**
	 * Gets the repostory view bean.
	 *
	 * @return the repostory view bean
	 */
	public ModelAbstraction getRepostoryViewBean() {
		return repostoryViewBean;
	}
	
	/**
	 * Gets the search wizard bean.
	 *
	 * @return the search wizard bean
	 */
	public ModelAbstraction getSearchWizardBean() {
		return searchWizardBean;
	}
	
	/**
	 * Gets the creates the new item bean.
	 *
	 * @return the creates the new item bean
	 */
	public ModelAbstraction getCreateNewItemBean() {
		return createNewItemBean;
	}
	
	/**
	 * Sets the new options wizard bean.
	 */
	public void setNewOptionsWizardBean() {
		this.optionsWizardBean = new OptionsWizardBean();
		this.addModel(this.optionsWizardBean);
	}

	/**
	 * Sets the new repostory view bean.
	 */
	public void setNewRepostoryViewBean() {
		this.repostoryViewBean = new RepositoryViewBean();
		this.addModel(this.repostoryViewBean);
	}
	
	/**
	 * Sets the new search wizard bean.
	 */
	public void setNewSearchWizardBean() {
		this.searchWizardBean = new SearchWizardBean();
		this.addModel(this.searchWizardBean);
	}
	
	/**
	 * Sets the new create new item bean.
	 */
	public void setNewCreateNewItemBean() {
		this.createNewItemBean = new CreateNewItemBean();
		this.addModel(this.createNewItemBean);
	}
	
	/**
	 * Sets the operator.
	 *
	 * @param operator the new operator
	 */
	public void setOperator(TreeViewerOperator operator) {
		this.operator = operator;
	}

	/**
	 * Gets the operator.
	 *
	 * @return the operator
	 */
	public TreeViewerOperator getOperator() {
		return operator;
	}

	/**
	 * Checks if is valid url.
	 *
	 * @param url the url
	 * @return true, if is valid url
	 */
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
	
	/**
	 * Checks if is serialized.
	 *
	 * @param filename the filename
	 * @return true, if is serialized
	 */
	public boolean isSerialized(String filename) {
		boolean sercheck = false;
		 @SuppressWarnings("unused")
		FileInputStream fis = null;
		   try
		   {
		     fis = new FileInputStream(filename);
		     sercheck = true;
		   }
		   catch(IOException ex)
		   {
		     //ex.printStackTrace();
		   }
		   
		   return sercheck && this.isValidUrl(this.returnServiceUriFile());
	}
	
	/**
	 * Return service uri file.
	 *
	 * @return the string
	 */
	public String returnServiceUriFile() {
			File fileToOpen = new File("serviceUriFile.txt");
			try {
				return FileUtils.readFileToString(fileToOpen);
			} catch (IOException e1) {
			}
			
			return null;
	}
}
