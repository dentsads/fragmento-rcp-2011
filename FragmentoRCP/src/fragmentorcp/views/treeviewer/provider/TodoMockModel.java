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
	
	public void init() {
		ArtefactCategory<ArtefactCategory<Artefact>> artefactsCategory = new ArtefactCategory<ArtefactCategory<Artefact>>();
		ArtefactCategory<Artefact> subArtefactsCategory = new ArtefactCategory<Artefact>();
		
		RelationsCategory<RelationsCategory<Relation>> relationsCategory = new RelationsCategory<RelationsCategory<Relation>>();
		RelationsCategory<Relation> subRelationsCategory = new RelationsCategory<Relation>();
		
		Artefact artefact = new Artefact();
		Relation relation = new Relation();
		
		artefactsCategory.setName("Artefacts");
		categories.add(artefactsCategory);
		
		
		subArtefactsCategory.setName(ArtefactTypes.ANNOTATION.toString());
		artefactsCategory.getChildren().add(subArtefactsCategory);
		
		artefact.setArtefactID(1);
		artefact.setArtefactDescription("blub studi");
		artefact.setArtefactType(ArtefactTypes.ANNOTATION);
		artefact.setCheckedOut(false);
		subArtefactsCategory.getChildren().add(artefact);
		
		subArtefactsCategory = new ArtefactCategory<Artefact>();
		subArtefactsCategory.setName(ArtefactTypes.WSDL.toString());
		artefactsCategory.getChildren().add(subArtefactsCategory);
		
		artefact = new Artefact();
		artefact.setArtefactID(2);
		artefact.setArtefactDescription("foo bar");
		artefact.setArtefactType(ArtefactTypes.WSDL);
		artefact.setCheckedOut(false);
		subArtefactsCategory.getChildren().add(artefact);
		
		
		
		relationsCategory.setName("Relations");
		categories.add(relationsCategory);
		
		subRelationsCategory.setName(RelationTypes.CONTAINER.toString());
		relationsCategory.getChildren().add(subRelationsCategory);
		
		relation.setRelationID(3);
		relation.setRelationDescription("ssl slsls");
		relation.setFromID(1);
		relation.setToID(2);
		relation.setRelationType(RelationTypes.CONTAINER);
		subRelationsCategory.getChildren().add(relation);
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
