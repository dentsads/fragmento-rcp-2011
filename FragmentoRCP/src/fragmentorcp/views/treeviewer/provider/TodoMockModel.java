package fragmentorcp.views.treeviewer.provider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fragmentorcppresenter.models.repository.Artefact;
import fragmentorcppresenter.models.repository.ArtefactCategory;
import fragmentorcppresenter.models.repository.ArtefactTypes;
import fragmentorcppresenter.models.repository.IPlaceHolder;
import fragmentorcppresenter.models.repository.Relation;
import fragmentorcppresenter.models.repository.RelationTypes;
import fragmentorcppresenter.models.repository.RelationsCategory;

public class TodoMockModel {
	
	public TodoMockModel() {
	}
	
	List<IPlaceHolder> categories = new ArrayList<IPlaceHolder>();
	
	public List<IPlaceHolder> getCategories() {
	
		return categories;
	}
	
//	public void createArtefactCategory(ArtefactTypes type) {
//		this.subArtefactsCategory = new ArtefactCategory<Artefact>();
//		subArtefactsCategory.setName(type.toString());
//		
//		int size = this.artefactsCategory.getChildren().size();
//		
//		for (int i = 0; i < size; i++) {
//			if (i==size && this.artefactsCategory.getChildren().get(i).getName() != type.toString()) {
//				this.subArtefactsCategory = new ArtefactCategory<Artefact>();
//				subArtefactsCategory.setName(type.toString());
//				this.artefactsCategory.getChildren().add(subArtefactsCategory);
//			}
//		}
//	}
	
	
}
