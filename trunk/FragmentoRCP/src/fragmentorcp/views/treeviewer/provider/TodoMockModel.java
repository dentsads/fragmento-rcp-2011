package fragmentorcp.views.treeviewer.provider;

import java.util.ArrayList;
import java.util.List;

import fragmentorcppresenter.models.repository.Artefact;
import fragmentorcppresenter.models.repository.ArtefactCategory;
import fragmentorcppresenter.models.repository.ArtefactTypes;
import fragmentorcppresenter.models.repository.IPlaceHolder;
import fragmentorcppresenter.models.repository.Relation;
import fragmentorcppresenter.models.repository.RelationTypes;
import fragmentorcppresenter.models.repository.RelationsCategory;

public class TodoMockModel {
	
	public List<IPlaceHolder> getCategories() {
		List<IPlaceHolder> categories = new ArrayList<IPlaceHolder>();
		
		ArtefactCategory<ArtefactCategory<Artefact>> artefactsCategory = new ArtefactCategory<ArtefactCategory<Artefact>>();
		artefactsCategory.setName("Artefacts");
		categories.add(artefactsCategory);
		
		ArtefactCategory<Artefact> subArtefactsCategory = new ArtefactCategory<Artefact>();
		
		subArtefactsCategory.setName("Annotation");
		artefactsCategory.getChildren().add(subArtefactsCategory);
		
		
		
		Artefact artefact = new Artefact();
		artefact.setArtefactID(1);
		artefact.setArtefactDescription("blub studi");
		artefact.setArtefactType(ArtefactTypes.ANNOTATION);
		artefact.setCheckedOut(false);
		subArtefactsCategory.getChildren().add(artefact);
		
		subArtefactsCategory = new ArtefactCategory<Artefact>();
		subArtefactsCategory.setName("WSDL");
		artefactsCategory.getChildren().add(subArtefactsCategory);
		
		artefact = new Artefact();
		artefact.setArtefactID(2);
		artefact.setArtefactDescription("foo bar");
		artefact.setArtefactType(ArtefactTypes.WSDL);
		artefact.setCheckedOut(false);
		subArtefactsCategory.getChildren().add(artefact);
		
		RelationsCategory<RelationsCategory<Relation>> relationsCategory = new RelationsCategory<RelationsCategory<Relation>>();
		relationsCategory.setName("Relations");
		categories.add(relationsCategory);
		
		RelationsCategory<Relation> subRelationsCategory = new RelationsCategory<Relation>();
		
		subRelationsCategory.setName("Container");
		relationsCategory.getChildren().add(subRelationsCategory);
		
		Relation relation = new Relation();
		relation.setRelationID(3);
		relation.setRelationDescription("ssl slsls");
		relation.setFromID(1);
		relation.setToID(2);
		relation.setRelationType(RelationTypes.CONTAINER);
		subRelationsCategory.getChildren().add(relation);;
		
		return categories;
	}
}
