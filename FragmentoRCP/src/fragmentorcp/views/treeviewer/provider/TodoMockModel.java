package fragmentorcp.views.treeviewer.provider;

import java.util.ArrayList;
import java.util.List;
import fragmentorcppresenter.models.repository.IPlaceHolder;

/**
 * The Class TodoMockModel is badly named but kept for stability purposes It
 * provides the global TreeViewer category list.
 * 
 * @author Dimitrios Dentsas
 */
public class TodoMockModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new todo mock model.
	 */
	public TodoMockModel() {
	}

	/** The categories. */
	List<IPlaceHolder> categories = new ArrayList<IPlaceHolder>();

	/**
	 * Gets the categories.
	 * 
	 * @return the categories
	 */
	public List<IPlaceHolder> getCategories() {

		return categories;
	}
	
	/**
	 * Sets the categories.
	 */
	public void setCategories(List<IPlaceHolder> categories) {

		this.categories = categories;
	}
}
