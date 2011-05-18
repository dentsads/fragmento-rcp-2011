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
		
		ArtefactCategory<ArtefactCategory<Artefact>> category = new ArtefactCategory<ArtefactCategory<Artefact>>();
		category.setName("Artefacts");
		categories.add(category);
		
		ArtefactCategory<Artefact> subcategory = new ArtefactCategory<Artefact>();
		
		subcategory.setName("Annotation");
		category.getChildren().add(subcategory);
		
		
		
		Artefact artefact = new Artefact();
		artefact.setArtefactID(1);
		artefact.setArtefactDescription("blub studi");
		artefact.setArtefactType(ArtefactTypes.ANNOTATION);
		artefact.setCheckedOut(false);
		subcategory.getChildren().add(artefact);
		
		subcategory = new ArtefactCategory<Artefact>();
		subcategory.setName("WSDL");
		category.getChildren().add(subcategory);
		
		artefact = new Artefact();
		artefact.setArtefactID(2);
		artefact.setArtefactDescription("foo bar");
		artefact.setArtefactType(ArtefactTypes.WSDL);
		artefact.setCheckedOut(false);
		subcategory.getChildren().add(artefact);
		
		RelationsCategory<RelationsCategory<Relation>> category2 = new RelationsCategory<RelationsCategory<Relation>>();
		category2.setName("Relation");
		categories.add(category2);
		
		RelationsCategory<Relation> subcategory2 = new RelationsCategory<Relation>();
		
		subcategory2.setName("Container");
		category2.getChildren().add(subcategory2);
		
		Relation relation = new Relation();
		relation.setRelationID(3);
		relation.setRelationDescription("ssl slsls");
		relation.setFromID(1);
		relation.setToID(2);
		relation.setRelationType(RelationTypes.CONTAINER);
		subcategory2.getChildren().add(relation);;
		
		return categories;
		
//		List<Category<Category<ArtefactRelationPlaceHolder>>> superCategories = new ArrayList<Category<Category<ArtefactRelationPlaceHolder>>>();
//		
//		Category<Category<ArtefactRelationPlaceHolder>> categories = new Category<Category<ArtefactRelationPlaceHolder>>();
//		
//		Category<Artefact> category = new Category<Artefact>();
//		
//		category.setName("Annotation");
//		categories.getChildren().add(category);
//		
//		Artefact artefact = new Artefact();
//		artefact.setArtefactID(1);
//		artefact.setArtefactDescription("blub studi");
//		artefact.setArtefactType(ArtefactTypes.ANNOTATION);
//		artefact.setCheckedOut(false);
//		category.getChildren().add(artefact);
//		
//		artefact = new Artefact();
//		artefact.setArtefactID(2);
//		artefact.setArtefactDescription("foo bar");
//		artefact.setArtefactType(ArtefactTypes.ANNOTATION);
//		artefact.setCheckedOut(false);
//		category.getChildren().add(artefact);
//		
//		
//		category = new Category<Artefact>();
//		
//		category.setName("WSDL");
//		categories.getChildren().addAll((Collection<? extends Category<ArtefactRelationPlaceHolder>>) category);
//		
//		artefact = new Artefact();
//		artefact.setArtefactID(3);
//		artefact.setArtefactDescription("blub studi sdfsd");
//		artefact.setArtefactType(ArtefactTypes.WSDL);
//		artefact.setCheckedOut(false);
//		category.getChildren().add(artefact);
//		
//		artefact = new Artefact();
//		artefact.setArtefactID(4);
//		artefact.setArtefactDescription("foo bar sdfsd");
//		artefact.setArtefactType(ArtefactTypes.WSDL);
//		artefact.setCheckedOut(false);
//		category.getChildren().add(artefact);
//		
//		
//		/*
//		 * Artefacts
//		 */
//		categories.setName("Artefacts");
//		superCategories.add(categories);
//		
//		
//		
//		
//		
//		/*
//		 * Relations
//		 */
//		categories = new Category<Category<ArtefactRelationPlaceHolder>>();
//		categories.setName("Relations");
//		superCategories.add(categories);
//		
//		Category<Relation> category2 = new Category<Relation>();
//		category.setName("Container");
//		categories.getChildren().addAll((Collection<? extends Category<ArtefactRelationPlaceHolder>>) category2);
//		
//		Relation relation = new Relation();
//		relation.setRelationID(5);
//		relation.setRelationDescription("sslsk relation sd");
//		relation.setFromID(1);
//		relation.setToID(2);
//		relation.setRelationType(RelationTypes.CONTAINER);
//		category2.getChildren().add(relation);
//		
//		return superCategories;
	}
}
