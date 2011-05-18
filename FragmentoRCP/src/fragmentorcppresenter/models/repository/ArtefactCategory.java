package fragmentorcppresenter.models.repository;

import java.util.ArrayList;
import java.util.List;

public class ArtefactCategory<T> implements IPlaceHolder {
	private String name;
	private int sort;
	private List<T> children = new ArrayList<T>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	
	public List<T> getChildren (){
		return children;
	}

}
