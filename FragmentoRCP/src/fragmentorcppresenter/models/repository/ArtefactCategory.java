package fragmentorcppresenter.models.repository;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class ArtefactCategory.
 *
 * @param <T> the generic type
 * @author Dimitrios Dentsas
 */
public class ArtefactCategory<T> implements IPlaceHolder{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The category name (e.g. WSDL, Fragment...) . */
	private String name;
	
	/** The sort. */
	private int sort;
	
	/** The children. */
	private List<T> children = new ArrayList<T>();
	
	/**
	 * Gets the category name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the category name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the sort.
	 *
	 * @return the sort
	 */
	public int getSort() {
		return sort;
	}
	
	/**
	 * Sets the sort.
	 *
	 * @param sort the new sort
	 */
	public void setSort(int sort) {
		this.sort = sort;
	}
	
	/**
	 * Gets the children.
	 *
	 * @return the children
	 */
	public List<T> getChildren (){
		return children;
	}

}
