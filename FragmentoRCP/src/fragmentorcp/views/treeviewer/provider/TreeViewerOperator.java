package fragmentorcp.views.treeviewer.provider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
//import org.eclipse.ui.part.DrillDownAdapter;

import eu.compas_ict.www.fragmentservice.FragmentServiceStub;
import eu.compas_ict.www.fragmentservice.FragmentServiceStub.ArtefactDescriptorType;
import eu.compas_ict.www.fragmentservice.FragmentServiceStub.BrowseArtefactsResponseMessage;
import eu.compas_ict.www.fragmentservice.FragmentServiceStub.BrowseRelationsResponseMessage;
import eu.compas_ict.www.fragmentservice.FragmentServiceStub.CreateArtefactResponseMessage;
import eu.compas_ict.www.fragmentservice.FragmentServiceStub.CreateRelationResponseMessage;
import eu.compas_ict.www.fragmentservice.FragmentServiceStub.Lock_type0;
import eu.compas_ict.www.fragmentservice.FragmentServiceStub.Relation_type2;
import eu.compas_ict.www.fragmentservice.FragmentServiceStub.UpdateRelationResponseMessage;
import fragmentService.FragmentoAxis;
import fragmentorcppresenter.models.repository.Artefact;
import fragmentorcppresenter.models.repository.ArtefactCategory;
import fragmentorcppresenter.models.repository.ArtefactTypes;
import fragmentorcppresenter.models.repository.IPlaceHolder;
import fragmentorcppresenter.models.repository.Relation;
import fragmentorcppresenter.models.repository.RelationTypes;
import fragmentorcppresenter.models.repository.RelationsCategory;

/**
 * The Class TreeViewerOperator provides an aggregation of essential custom
 * lookup methods and operations for the TreeViewer.
 * 
 * @author Dimitrios Dentsas
 */
public class TreeViewerOperator {

	/** The viewer. */
	private TreeViewer viewer;

	/** The action1. */
	private Action action1;

	/** The action2. */
	private Action action2;
	// private DrillDownAdapter drillDownAdapter;
	// private Action doubleClickAction;
	/** The action_open editor. */
	private Action action_openEditor;

	/** The Artefact list. */
	private ArrayList<String> ArtefactList = new ArrayList<String>();

	/** The keep relations. */
	private boolean keepRelations = false;

	/** The checkout path. */
	private String checkoutPath = System.getProperty("java.io.tmpdir");

	/** The Fragmento Axis Class. */
	FragmentoAxis fragmento = new FragmentoAxis();

	/** The mock. */
	TodoMockModel mock;

	/**
	 * Instantiates a new tree viewer operator.
	 * 
	 * @param viewer
	 *            the viewer
	 * @param mock
	 *            the mock
	 */
	public TreeViewerOperator(TreeViewer viewer, TodoMockModel mock) {
		this.viewer = viewer;
		this.mock = mock;
	}

	/**
	 * Fill context menu.
	 * 
	 * @param manager
	 *            the manager
	 */
	public void fillContextMenu(IMenuManager manager) {
		// manager.add(action1);
		// manager.add(action2);
		// manager.add(new Separator());
		// drillDownAdapter.addNavigationActions(manager);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	/**
	 * Make actions.
	 */
	public void makeActions() {
		action1 = new Action() {
			public void run() {
				showMessage("Action 1 executed");
			}
		};
		action1.setText("Action 1");
		action1.setToolTipText("Action 1 tooltip");
		action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));

		action2 = new Action() {
			public void run() {
				showMessage("Action 2 executed");
			}
		};
		action2.setText("Action 2");
		action2.setToolTipText("Action 2 tooltip");
		action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));

		action_openEditor = new Action() {
			public void run() {

				if (viewer.getSelection().isEmpty()) {
					showErrorMessage("Please select an artefact to complete operation.");
				} else {
					ISelection selection = viewer.getSelection();
					Object obj = ((IStructuredSelection) selection)
							.getFirstElement();

					if (obj instanceof Artefact) {
						openFile(
								((Artefact) obj),
								System.getProperty("java.io.tmpdir"),
								String.valueOf(((Artefact) obj).getArtefactID()));
					} else {
						showErrorMessage("Please select an artefact to complete operation.");
					}

				}

			}
		};

	}

	/**
	 * Hook double click action.
	 */
	public void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				// doubleClickAction.run();
				action_openEditor.run();
			}
		});
	}

	/**
	 * Show message.
	 * 
	 * @param message
	 *            the message
	 */
	private void showMessage(String message) {
		MessageDialog.openInformation(viewer.getControl().getShell(),
				"Fragmento View 1", message);
	}

	/**
	 * Show message.
	 * 
	 * @param title
	 *            the title
	 * @param message
	 *            the message
	 */
	private void showMessage(String title, String message) {
		MessageDialog.openInformation(viewer.getControl().getShell(), title,
				message);
	}

	/**
	 * Show error message.
	 * 
	 * @param message
	 *            the message
	 */
	public void showErrorMessage(String message) {
		MessageDialog.openError(viewer.getControl().getShell(), "Error",
				message);
	}

	/**
	 * Inits the tree with a comprehensive list of all artefacts and relations
	 * in the remote repository.
	 */
	public void init() {
		ArtefactCategory<ArtefactCategory<Artefact>> artefactsCategory = new ArtefactCategory<ArtefactCategory<Artefact>>();
		ArtefactCategory<Artefact> subArtefactsCategory = new ArtefactCategory<Artefact>();

		RelationsCategory<RelationsCategory<Relation>> relationsCategory = new RelationsCategory<RelationsCategory<Relation>>();
		RelationsCategory<Relation> subRelationsCategory = new RelationsCategory<Relation>();

		this.getArtefactList().clear();
		artefactsCategory.setName("Artefacts");
		mock.getCategories().add(artefactsCategory);

		subArtefactsCategory.setName(ArtefactTypes.WSDL.toString());
		artefactsCategory.getChildren().add(subArtefactsCategory);

		loadArtefacts(ArtefactTypes.WSDL);

		subArtefactsCategory = new ArtefactCategory<Artefact>();
		subArtefactsCategory.setName(ArtefactTypes.ANNOTATION.toString());
		artefactsCategory.getChildren().add(subArtefactsCategory);

		loadArtefacts(ArtefactTypes.ANNOTATION);

		subArtefactsCategory = new ArtefactCategory<Artefact>();
		subArtefactsCategory.setName(ArtefactTypes.CONTAINER.toString());
		artefactsCategory.getChildren().add(subArtefactsCategory);

		loadArtefacts(ArtefactTypes.CONTAINER);

		subArtefactsCategory = new ArtefactCategory<Artefact>();
		subArtefactsCategory.setName(ArtefactTypes.DEPLOYMENT_DESCRIPTOR
				.toString());
		artefactsCategory.getChildren().add(subArtefactsCategory);

		loadArtefacts(ArtefactTypes.DEPLOYMENT_DESCRIPTOR);

		subArtefactsCategory = new ArtefactCategory<Artefact>();
		subArtefactsCategory.setName(ArtefactTypes.FRAGMENT.toString());
		artefactsCategory.getChildren().add(subArtefactsCategory);

		loadArtefacts(ArtefactTypes.FRAGMENT);

		subArtefactsCategory = new ArtefactCategory<Artefact>();
		subArtefactsCategory.setName(ArtefactTypes.MODELLER_DATA.toString());
		artefactsCategory.getChildren().add(subArtefactsCategory);

		loadArtefacts(ArtefactTypes.MODELLER_DATA);

		subArtefactsCategory = new ArtefactCategory<Artefact>();
		subArtefactsCategory.setName(ArtefactTypes.PROCESS.toString());
		artefactsCategory.getChildren().add(subArtefactsCategory);

		loadArtefacts(ArtefactTypes.PROCESS);

		subArtefactsCategory = new ArtefactCategory<Artefact>();
		subArtefactsCategory.setName(ArtefactTypes.TRANSFORMATION_RULE
				.toString());
		artefactsCategory.getChildren().add(subArtefactsCategory);

		loadArtefacts(ArtefactTypes.TRANSFORMATION_RULE);

		subArtefactsCategory = new ArtefactCategory<Artefact>();
		subArtefactsCategory.setName(ArtefactTypes.MODELLER_DATA.toString());
		artefactsCategory.getChildren().add(subArtefactsCategory);

		loadArtefacts(ArtefactTypes.MODELLER_DATA);

		// ///////// RELATIONS /////////////

		relationsCategory.setName("Relations");
		mock.getCategories().add(relationsCategory);

		subRelationsCategory.setName(RelationTypes.ANNOTATION.toString());
		relationsCategory.getChildren().add(subRelationsCategory);

		loadRelations(RelationTypes.ANNOTATION);

		subRelationsCategory = new RelationsCategory<Relation>();
		subRelationsCategory.setName(RelationTypes.CONTAINER.toString());
		relationsCategory.getChildren().add(subRelationsCategory);

		loadRelations(RelationTypes.CONTAINER);

		subRelationsCategory = new RelationsCategory<Relation>();
		subRelationsCategory.setName(RelationTypes.DEPLOYMENT.toString());
		relationsCategory.getChildren().add(subRelationsCategory);

		loadRelations(RelationTypes.DEPLOYMENT);

		subRelationsCategory = new RelationsCategory<Relation>();
		subRelationsCategory.setName(RelationTypes.MODELLER_DATA.toString());
		relationsCategory.getChildren().add(subRelationsCategory);

		loadRelations(RelationTypes.MODELLER_DATA);

		subRelationsCategory = new RelationsCategory<Relation>();
		subRelationsCategory.setName(RelationTypes.TRANSFORMATION.toString());
		relationsCategory.getChildren().add(subRelationsCategory);

		loadRelations(RelationTypes.TRANSFORMATION);

		subRelationsCategory = new RelationsCategory<Relation>();
		subRelationsCategory.setName(RelationTypes.WSDL.toString());
		relationsCategory.getChildren().add(subRelationsCategory);

		loadRelations(RelationTypes.WSDL);
	}

	/**
	 * Sets the checkout path.
	 * 
	 * @param checkoutPath
	 *            the new checkout path
	 */
	public void setCheckoutPath(String checkoutPath) {
		this.checkoutPath = checkoutPath;
	}

	/**
	 * Gets the checkout path.
	 * 
	 * @return the checkout path
	 */
	public String getCheckoutPath() {
		return checkoutPath;
	}

	/**
	 * Sets the keep relations.
	 * 
	 * @param keepRelations
	 *            the new keep relations
	 */
	public void setKeepRelations(boolean keepRelations) {
		this.keepRelations = keepRelations;
	}

	/**
	 * Checks if is keep relations.
	 * 
	 * @return true, if is keep relations
	 */
	public boolean isKeepRelations() {
		return keepRelations;
	}

	/**
	 * Gets the mock.
	 * 
	 * @return the mock
	 */
	public TodoMockModel getMock() {
		return mock;
	}

	/**
	 * Gets the fragmento.
	 * 
	 * @return the fragmento
	 */
	public FragmentoAxis getFragmento() {
		return fragmento;
	}

	/**
	 * Gets the viewer.
	 * 
	 * @return the viewer
	 */
	public TreeViewer getViewer() {
		return viewer;
	}

	/**
	 * Browse artefact type.
	 * 
	 * @param type
	 *            the type
	 */
	public void browseArtefactType(String type) {
		if (type == "") {
			this.showMessage("Attention", "Type field must not be empty!");
		} else {
			BrowseArtefactsResponseMessage response = fragmento
					.browseArtifact_byType(type);
			if (response.getArtefactDescriptors().getArtefact() == null) {
				this.showMessage("Attention",
						"No artefacts found for this type.");
			} else {
				this.getMock().getCategories().clear();

				Artefact artefact = new Artefact();
				try {
					ArtefactDescriptorType[] artefacts = response
							.getArtefactDescriptors().getArtefact();

					if (artefacts != null)
						for (int i = 0; i < artefacts.length; i++) {
							artefact = new Artefact();
							artefact.setArtefactType(this
									.artefactInverseAdapter(type));
							artefact.setArtefactID((int) artefacts[i]
									.getArtefactId());
							if (artefacts[i].getDescription().contains("<!--")) {
								artefact.setArtefactDescription((String) artefacts[i]
										.getDescription()
										.subSequence(
												0,
												artefacts[i].getDescription()
														.indexOf("<!--"))
										.toString().trim());
							} else {
								artefact.setArtefactDescription(artefacts[i]
										.getDescription());
							}
							artefact.setCheckedOut(isCheckedOut(artefact
									.getArtefactID()));
							this.getMock().getCategories().add(artefact);
							viewer.refresh();
						}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Browse artefact description.
	 * 
	 * @param description
	 *            the description
	 */
	public void browseArtefactDescription(String description) {
		if (description.equals("")) {
			this.showMessage("Attention",
					"Description field must not be empty!");
		} else {
			BrowseArtefactsResponseMessage response = fragmento
					.browseArtifact_byDescription(description);
			if (response.getArtefactDescriptors().getArtefact() == null) {
				this.showMessage("Attention",
						"No artefacts found for this search pattern.");
			} else {
				this.getMock().getCategories().clear();

				Artefact artefact = new Artefact();
				try {
					ArtefactDescriptorType[] artefacts = response
							.getArtefactDescriptors().getArtefact();

					if (artefacts != null)
						for (int i = 0; i < artefacts.length; i++) {
							artefact = new Artefact();
							artefact.setArtefactType(this
									.artefactInverseAdapter(artefacts[i]
											.getType()));
							artefact.setArtefactID((int) artefacts[i]
									.getArtefactId());
							if (artefacts[i].getDescription().contains("<!--")) {
								artefact.setArtefactDescription((String) artefacts[i]
										.getDescription()
										.subSequence(
												0,
												artefacts[i].getDescription()
														.indexOf("<!--"))
										.toString().trim());
							} else {
								artefact.setArtefactDescription(artefacts[i]
										.getDescription());
							}
							artefact.setCheckedOut(isCheckedOut(artefact
									.getArtefactID()));
							this.getMock().getCategories().add(artefact);
							viewer.refresh();
						}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Browse artefact content.
	 * 
	 * @param content
	 *            the content
	 */
	public void browseArtefactContent(String content) {
		if (content.equals("")) {
			this.showMessage("Attention", "Content field must not be empty!");
		} else {
			BrowseArtefactsResponseMessage response = fragmento
					.browseArtifact_byContent(content);
			if (response.getArtefactDescriptors().getArtefact() == null) {
				this.showMessage("Attention",
						"No artefacts found for this search pattern.");
			} else {
				this.getMock().getCategories().clear();

				Artefact artefact = new Artefact();
				try {
					ArtefactDescriptorType[] artefacts = response
							.getArtefactDescriptors().getArtefact();

					if (artefacts != null)
						for (int i = 0; i < artefacts.length; i++) {
							artefact = new Artefact();
							artefact.setArtefactType(this
									.artefactInverseAdapter(artefacts[i]
											.getType()));
							artefact.setArtefactID((int) artefacts[i]
									.getArtefactId());
							if (artefacts[i].getDescription().contains("<!--")) {
								artefact.setArtefactDescription((String) artefacts[i]
										.getDescription()
										.subSequence(
												0,
												artefacts[i].getDescription()
														.indexOf("<!--"))
										.toString().trim());
							} else {
								artefact.setArtefactDescription(artefacts[i]
										.getDescription());
							}
							artefact.setCheckedOut(isCheckedOut(artefact
									.getArtefactID()));
							this.getMock().getCategories().add(artefact);
							viewer.refresh();
						}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Browse artefact date.
	 * 
	 * @param from
	 *            the from
	 * @param to
	 *            the to
	 */
	public void browseArtefactDate(Calendar from, Calendar to) {
		if (from.after(to)) {
			this.showMessage("Attention",
					"START date cannot come after END date");
		} else {
			BrowseArtefactsResponseMessage response = fragmento
					.browseArtifact_byDate(from, to);
			if (response.getArtefactDescriptors().getArtefact() == null) {
				this.showMessage("Attention",
						"No artefacts found for this search pattern.");
			} else {
				this.getMock().getCategories().clear();

				Artefact artefact = new Artefact();
				try {
					ArtefactDescriptorType[] artefacts = response
							.getArtefactDescriptors().getArtefact();

					if (artefacts != null)
						for (int i = 0; i < artefacts.length; i++) {
							artefact = new Artefact();
							artefact.setArtefactType(this
									.artefactInverseAdapter(artefacts[i]
											.getType()));
							artefact.setArtefactID((int) artefacts[i]
									.getArtefactId());
							if (artefacts[i].getDescription().contains("<!--")) {
								artefact.setArtefactDescription((String) artefacts[i]
										.getDescription()
										.subSequence(
												0,
												artefacts[i].getDescription()
														.indexOf("<!--"))
										.toString().trim());
							} else {
								artefact.setArtefactDescription(artefacts[i]
										.getDescription());
							}
							artefact.setCheckedOut(isCheckedOut(artefact
									.getArtefactID()));
							this.getMock().getCategories().add(artefact);
							viewer.refresh();
						}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Browse artefact date type.
	 * 
	 * @param from
	 *            the from
	 * @param to
	 *            the to
	 * @param type
	 *            the type
	 */
	public void browseArtefactDateType(Calendar from, Calendar to, String type) {
		if (from.after(to)) {
			this.showMessage("Attention",
					"START date cannot come after END date");
		} else if (type.equals("")) {
			this.showMessage("Attention", "Type field must not be empty!");
		} else {
			BrowseArtefactsResponseMessage response = fragmento
					.browseArtifact_byDateType(from, to, type);
			if (response.getArtefactDescriptors().getArtefact() == null) {
				this.showMessage("Attention",
						"No artefacts found for this search pattern.");
			} else {
				this.getMock().getCategories().clear();

				Artefact artefact = new Artefact();
				try {
					ArtefactDescriptorType[] artefacts = response
							.getArtefactDescriptors().getArtefact();

					if (artefacts != null)
						for (int i = 0; i < artefacts.length; i++) {
							artefact = new Artefact();
							artefact.setArtefactType(this
									.artefactInverseAdapter(artefacts[i]
											.getType()));
							artefact.setArtefactID((int) artefacts[i]
									.getArtefactId());
							if (artefacts[i].getDescription().contains("<!--")) {
								artefact.setArtefactDescription((String) artefacts[i]
										.getDescription()
										.subSequence(
												0,
												artefacts[i].getDescription()
														.indexOf("<!--"))
										.toString().trim());
							} else {
								artefact.setArtefactDescription(artefacts[i]
										.getDescription());
							}
							artefact.setCheckedOut(isCheckedOut(artefact
									.getArtefactID()));
							this.getMock().getCategories().add(artefact);
							viewer.refresh();
						}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Browse relation type.
	 * 
	 * @param type
	 *            the type
	 */
	public void browseRelationType(String type) {
		if (type == "") {
			this.showMessage("Attention", "Type field must not be empty!");
		} else {
			BrowseRelationsResponseMessage response = fragmento
					.browseRelation_byType(type);
			if (response.getRelations().getRelation() == null) {
				this.showMessage("Attention",
						"No relations found for this search pattern.");
			} else {
				this.getMock().getCategories().clear();

				Relation relation = new Relation();
				try {
					Relation_type2[] relations = response.getRelations()
							.getRelation();

					if (relations != null)
						for (int i = 0; i < relations.length; i++) {
							relation = new Relation();
							relation.setRelationType(this
									.relationInverseAdapter2(type));
							relation.setRelationID((int) relations[i]
									.getRelationId());
							if (relations[i].getDescription().contains("<!--")) {
								relation.setRelationDescription((String) relations[i]
										.getDescription()
										.subSequence(
												0,
												relations[i].getDescription()
														.indexOf("<!--"))
										.toString().trim());
							} else {
								relation.setRelationDescription(relations[i]
										.getDescription());
							}
							relation.setFromID((int) relations[i].getFrom());
							relation.setToID((int) relations[i].getTo());
							this.getMock().getCategories().add(relation);
							viewer.refresh();
						}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Browse relation source id.
	 * 
	 * @param source
	 *            the source
	 */
	public void browseRelationSourceId(String source) {
		if (source.equals("")) {
			this.showMessage("Attention", "Source Id field must not be empty!");
		} else {
			BrowseRelationsResponseMessage response = fragmento
					.browseRelation_bySourceId(Long.valueOf(source).longValue());
			if (response.getRelations().getRelation() == null) {
				this.showMessage("Attention",
						"No relations found for this search pattern.");
			} else {
				this.getMock().getCategories().clear();

				Relation relation = new Relation();
				try {
					Relation_type2[] relations = response.getRelations()
							.getRelation();

					if (relations != null)
						for (int i = 0; i < relations.length; i++) {
							relation = new Relation();
							relation.setRelationType(this
									.relationInverseAdapter2(relations[i]
											.getType().toString()));
							relation.setRelationID((int) relations[i]
									.getRelationId());
							if (relations[i].getDescription().contains("<!--")) {
								relation.setRelationDescription((String) relations[i]
										.getDescription()
										.subSequence(
												0,
												relations[i].getDescription()
														.indexOf("<!--"))
										.toString().trim());
							} else {
								relation.setRelationDescription(relations[i]
										.getDescription());
							}
							relation.setFromID((int) relations[i].getFrom());
							relation.setToID((int) relations[i].getTo());
							this.getMock().getCategories().add(relation);
							viewer.refresh();
						}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Browse relation target id.
	 * 
	 * @param target
	 *            the target
	 */
	public void browseRelationTargetId(String target) {
		if (target.equals("")) {
			this.showMessage("Attention", "Target Id field must not be empty!");
		} else {
			BrowseRelationsResponseMessage response = fragmento
					.browseRelation_byTargetId(Long.valueOf(target).longValue());
			if (response.getRelations().getRelation() == null) {
				this.showMessage("Attention",
						"No relations found for this search pattern.");
			} else {
				this.getMock().getCategories().clear();

				Relation relation = new Relation();
				try {
					Relation_type2[] relations = response.getRelations()
							.getRelation();

					if (relations != null)
						for (int i = 0; i < relations.length; i++) {
							relation = new Relation();
							relation.setRelationType(this
									.relationInverseAdapter2(relations[i]
											.getType().toString()));
							relation.setRelationID((int) relations[i]
									.getRelationId());
							if (relations[i].getDescription().contains("<!--")) {
								relation.setRelationDescription((String) relations[i]
										.getDescription()
										.subSequence(
												0,
												relations[i].getDescription()
														.indexOf("<!--"))
										.toString().trim());
							} else {
								relation.setRelationDescription(relations[i]
										.getDescription());
							}
							relation.setFromID((int) relations[i].getFrom());
							relation.setToID((int) relations[i].getTo());
							this.getMock().getCategories().add(relation);
							viewer.refresh();
						}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Browse relation date.
	 * 
	 * @param from
	 *            the from date
	 * @param to
	 *            the to date
	 */
	public void browseRelationDate(Calendar from, Calendar to) {
		if (from.after(to)) {
			this.showMessage("Attention",
					"START date cannot come after END date");
		} else {
			BrowseRelationsResponseMessage response = fragmento
					.browseRelation_byDate(from, to);
			if (response.getRelations().getRelation() == null) {
				this.showMessage("Attention",
						"No relations found for this search pattern.");
			} else {
				this.getMock().getCategories().clear();

				Relation relation = new Relation();
				try {
					Relation_type2[] relations = response.getRelations()
							.getRelation();

					if (relations != null)
						for (int i = 0; i < relations.length; i++) {
							relation = new Relation();
							relation.setRelationType(this
									.relationInverseAdapter2(relations[i]
											.getType().toString()));
							relation.setRelationID((int) relations[i]
									.getRelationId());
							if (relations[i].getDescription().contains("<!--")) {
								relation.setRelationDescription((String) relations[i]
										.getDescription()
										.subSequence(
												0,
												relations[i].getDescription()
														.indexOf("<!--"))
										.toString().trim());
							} else {
								relation.setRelationDescription(relations[i]
										.getDescription());
							}
							relation.setFromID((int) relations[i].getFrom());
							relation.setToID((int) relations[i].getTo());
							this.getMock().getCategories().add(relation);
							viewer.refresh();
						}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Browse relation date type.
	 * 
	 * @param from
	 *            the from date
	 * @param to
	 *            the to date
	 * @param type
	 *            the type
	 */
	public void browseRelationDateType(Calendar from, Calendar to, String type) {
		if (from.after(to)) {
			this.showMessage("Attention",
					"START date cannot come after END date");
		} else if (type.equals("")) {
			this.showMessage("Attention", "Type field must not be empty!");
		} else {
			BrowseRelationsResponseMessage response = fragmento
					.browseRelation_byDateType(from, to, type);
			if (response.getRelations().getRelation() == null) {
				this.showMessage("Attention",
						"No relations found for this search pattern.");
			} else {
				this.getMock().getCategories().clear();

				Relation relation = new Relation();
				try {
					Relation_type2[] relations = response.getRelations()
							.getRelation();

					if (relations != null)
						for (int i = 0; i < relations.length; i++) {
							relation = new Relation();
							relation.setRelationType(this
									.relationInverseAdapter2(relations[i]
											.getType().toString()));
							relation.setRelationID((int) relations[i]
									.getRelationId());
							if (relations[i].getDescription().contains("<!--")) {
								relation.setRelationDescription((String) relations[i]
										.getDescription()
										.subSequence(
												0,
												relations[i].getDescription()
														.indexOf("<!--"))
										.toString().trim());
							} else {
								relation.setRelationDescription(relations[i]
										.getDescription());
							}
							relation.setFromID((int) relations[i].getFrom());
							relation.setToID((int) relations[i].getTo());
							this.getMock().getCategories().add(relation);
							viewer.refresh();
						}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Creates the new artefact.
	 * 
	 * @param type
	 *            the type
	 * @param desc
	 *            the description
	 * @param payload
	 *            the payload
	 */
	public void createNewArtefact(String type, String desc, String payload) {

		CreateArtefactResponseMessage artefact = fragmento.createArtifact(type,
				desc, payload);
		if (artefact == null) {
			this.showErrorMessage("Content is no valid format!");
		} else {
			this.addArtefact((int) artefact.getArtefactId(), desc,
					artefactInverseAdapter(type), false);
			viewer.refresh();
		}
	}

	/**
	 * Creates the new relation.
	 * 
	 * @param type
	 *            the type
	 * @param desc
	 *            the description
	 * @param fromId
	 *            the from id
	 * @param toId
	 *            the to id
	 */
	public void createNewRelation(String type, String desc, int fromId, int toId) {
		CreateRelationResponseMessage relation = fragmento.createRelation(desc,
				fromId, toId, this.relationInverseAdapter(type));

		if (relation == null) {
			this.showErrorMessage("Either source ID or target ID doesn't exist anymore!");
		} else {
			this.addRelation((int) relation.getRelationId(), desc,
					relationInverseAdapter2(type), fromId, toId);
			viewer.refresh();
		}
	}

	/**
	 * Open and store file.
	 * 
	 * @param artefact
	 *            the artefact
	 * @param dir
	 *            the directory
	 * @param fileName
	 *            the file name
	 */
	private void openFile(Artefact artefact, String dir, String fileName) {
		String postfix = ".xml";

		switch (artefact.getArtefactType()) {
		case WSDL:
			postfix = ".wsdl";
			break;
		default:
			break;
		}

		File fileToOpen = new File(dir, fileName + postfix);
		try {
			FileUtils.writeStringToFile(fileToOpen,
					fragmento.retrieveArtifact(artefact.getArtefactID())
							.getArtefact().getExtraElement().toString());
		} catch (IOException e1) {
		}

		if (fileToOpen.exists() && fileToOpen.isFile()) {
			IFileStore fileStore = EFS.getLocalFileSystem().getStore(
					fileToOpen.toURI());
			IWorkbenchPage page = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage();

			try {
				IDE.openEditorOnFileStore(page, fileStore);
			} catch (PartInitException e) {
				// Put your exception handler here if you wish to
			}
		} else {
		}
	}

	/**
	 * Load artefacts.
	 * 
	 * @param type
	 *            the type
	 */
	private void loadArtefacts(ArtefactTypes type) {
		BrowseArtefactsResponseMessage response = fragmento
				.browseArtifact_byType(artefactAdapter(type));

		int id;
		String desc;
		boolean checkedOut;
		try {
			ArtefactDescriptorType[] artefacts = response
					.getArtefactDescriptors().getArtefact();

			if (artefacts != null)
				for (int i = 0; i < artefacts.length; i++) {
					id = (int) artefacts[i].getArtefactId();
					if (artefacts[i].getDescription().contains("<!--")) {
						desc = (String) artefacts[i]
								.getDescription()
								.subSequence(
										0,
										artefacts[i].getDescription().indexOf(
												"<!--")).toString().trim();
					} else {
						desc = artefacts[i].getDescription();
					}
					checkedOut = isCheckedOut(id);
					addArtefact(id, desc, type, checkedOut);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Load relations.
	 * 
	 * @param type
	 *            the type
	 */
	private void loadRelations(RelationTypes type) {
		BrowseRelationsResponseMessage response = fragmento
				.browseRelation_byType(relationAdapter(type));

		int id;
		String desc;
		int fromId;
		int toId;
		try {
			Relation_type2[] relations = response.getRelations().getRelation();
			if (relations != null)
				for (int i = 0; i < relations.length; i++) {
					id = (int) relations[i].getRelationId();
					if (relations[i].getDescription().contains("<!--")) {
						desc = (String) relations[i]
								.getDescription()
								.subSequence(
										0,
										relations[i].getDescription().indexOf(
												"<!--")).toString().trim();
					} else {
						desc = relations[i].getDescription();
					}
					fromId = (int) relations[i].getFrom();
					toId = (int) relations[i].getTo();
					addRelation(id, desc, type, fromId, toId);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sets the artefact list.
	 * 
	 * @param artefactList
	 *            the new artefact list
	 */
	public void setArtefactList(ArrayList<String> artefactList) {
		ArtefactList = artefactList;
	}

	/**
	 * Gets the artefact list.
	 * 
	 * @return the artefact list
	 */
	public ArrayList<String> getArtefactList() {
		return ArtefactList;
	}

	/**
	 * Release lock selected.
	 */
	public void releaseLockSelected() {
		if (viewer.getSelection().isEmpty()) {
			showErrorMessage("Please selected an item to complete operation.");
		} else {
			IStructuredSelection selection = (IStructuredSelection) viewer
					.getSelection();
			Object selectedDomainObject = selection.getFirstElement();
			if (selectedDomainObject instanceof Artefact) {
				Artefact item = (Artefact) selectedDomainObject;
				if (item.isCheckedOut()) {
					List<FragmentServiceStub.Lock_type0> lockList = new ArrayList<FragmentServiceStub.Lock_type0>();
					FragmentServiceStub.Lock_type0[] locks = fragmento
							.browseLocks().getLockDescriptors().getLock();
					for (int i = 0; i < locks.length; i++) {
						if (locks[i].getArtefactId() == (long) item
								.getArtefactID()) {
							lockList.add(locks[i]);
						}
					}
					fragmento.releaseLocks((Lock_type0[]) lockList
							.toArray(new Lock_type0[0]));
					item.setCheckedOut(false);
				} else {
					showErrorMessage("Artefact is not checked out!");
				}
			} else {
				showErrorMessage("Please select an artefact!");
			}
		}
	}

	/**
	 * Checks if item is checked out in the remote repository.
	 * 
	 * @param id
	 *            the id
	 * @return true, if is checked out
	 */
	private boolean isCheckedOut(int id) {
		Lock_type0[] locks = fragmento.browseLocks().getLockDescriptors()
				.getLock();

		if (locks != null)
			for (int i = 0; i < locks.length; i++) {
				if (((int) locks[i].getArtefactId()) == id) {
					return true;
				}
			}

		return false;
	}

	/**
	 * Delete selected item.
	 * 
	 * @param fromRepo
	 *            the from repo
	 */
	public void deleteSelected(boolean fromRepo) {
		if (viewer.getSelection().isEmpty()) {
			showErrorMessage("Please selected an item to complete operation.");
		} else {
			IStructuredSelection selection = (IStructuredSelection) viewer
					.getSelection();
			Object selectedDomainObject = selection.getFirstElement();
			if (selectedDomainObject instanceof Artefact) {
				Artefact item = (Artefact) selectedDomainObject;
				removeArtefact(item.getArtefactID(), item.getArtefactType());
			} else if (selectedDomainObject instanceof Relation) {
				Relation item = (Relation) selectedDomainObject;
				if (fromRepo) {
					// if (relationExists(item.getRelationID())) {
					fragmento.deleteRelation((long) item.getRelationID());
					// showMessage("relation exists");
					// } else {
					// showMessage("Relation was already deleted from the repository!");
					// }
				}
				removeRelation(item.getRelationID(), item.getRelationType());
			} else {
				;
				showErrorMessage("Please select an item instead of a category!");
			}
		}
	}

	/**
	 * Checkout selected item.
	 */
	public void checkoutSelected() {
		IStructuredSelection selection = (IStructuredSelection) viewer
				.getSelection();
		Object selectedDomainObject = selection.getFirstElement();
		Artefact item = (Artefact) selectedDomainObject;

		if (isCheckedOut(item.getArtefactID())) {
			if (!item.isCheckedOut()) {
				showErrorMessage("Artefact is already checked out by someone else!");
			} else {
				showErrorMessage("Artefact is already checked out!");
			}
			item.setCheckedOut(true);
			viewer.refresh();
		} else {
			fragmento.checkoutArtifact(item.getArtefactID());
			openFile(item, this.getCheckoutPath(),
					String.valueOf(item.getArtefactID()));
			// openFile(item,System.getProperty("java.io.tmpdir"),String.valueOf(item.getArtefactID()));
			item.setCheckedOut(true);
			viewer.refresh();
		}

	}

	/**
	 * Checkin selected item.
	 * 
	 * @param payload
	 *            the payload
	 */
	public void checkinSelected(String payload) {
		IStructuredSelection selection = (IStructuredSelection) viewer
				.getSelection();
		Object selectedDomainObject = selection.getFirstElement();
		Artefact item = (Artefact) selectedDomainObject;

		if (!isCheckedOut(item.getArtefactID())) {
			if (!item.isCheckedOut()) {
				showErrorMessage("Artefact cannot be checked in, because the repository reference was not checked out!");
			} else {
				showErrorMessage("Artefact cannot be checked in!");
			}
			item.setCheckedOut(false);
			viewer.refresh();
		} else {
			fragmento.checkinArtifact((long) (item.getArtefactID()),
					artefactAdapter(item.getArtefactType()),
					item.getArtefactDescription(), payload,
					this.isKeepRelations());
			openFile(item, this.getCheckoutPath(),
					String.valueOf(item.getArtefactID()));
			// openFile(item,System.getProperty("java.io.tmpdir"),String.valueOf(item.getArtefactID()));
			item.setCheckedOut(false);
			viewer.refresh();
		}

	}

	/**
	 * Artefact adapter for bridging and connecting the different namings in
	 * custom ArtefactTypes enum and predefined Types in the Fragmento
	 * repository.
	 * 
	 * @param type
	 *            the type
	 * @return the string
	 */
	public String artefactAdapter(ArtefactTypes type) {
		String typeString = "";

		switch (type) {
		case ANNOTATION:
			typeString = "Annotation";
			break;
		case CONTAINER:
			typeString = "Container";
			break;
		case DEPLOYMENT_DESCRIPTOR:
			typeString = "Deployment Descriptor";
			break;
		case FRAGMENT:
			typeString = "Fragment";
			break;
		case MODELLER_DATA:
			typeString = "Modeller Data";
			break;
		case PROCESS:
			typeString = "Process";
			break;
		case TRANSFORMATION_RULE:
			typeString = "Transformation Rule";
			break;
		case WSDL:
			typeString = "WSDL";
			break;
		default:
			break;
		}

		return typeString;
	}

	/**
	 * Artefact adapter for bridging and connecting the different namings in
	 * custom ArtefactTypes enum and predefined Types in the Fragmento
	 * repository. (Inversion method of artefactAdapter)
	 * 
	 * @param type
	 *            the type
	 * @return the artefact types
	 */
	public ArtefactTypes artefactInverseAdapter(String type) {
		ArtefactTypes typeString = ArtefactTypes.ANNOTATION;

		if (type == "Annotation") {
			typeString = ArtefactTypes.ANNOTATION;
		} else if (type == "Container") {
			typeString = ArtefactTypes.CONTAINER;
		} else if (type == "Deployment Descriptor") {
			typeString = ArtefactTypes.DEPLOYMENT_DESCRIPTOR;
		} else if (type == "Fragment") {
			typeString = ArtefactTypes.FRAGMENT;
		} else if (type == "Modeller Data") {
			typeString = ArtefactTypes.MODELLER_DATA;
		} else if (type == "Process") {
			typeString = ArtefactTypes.PROCESS;
		} else if (type == "Transformation Rule") {
			typeString = ArtefactTypes.TRANSFORMATION_RULE;
		} else if (type == "WSDL") {
			typeString = ArtefactTypes.WSDL;
		}

		return typeString;
	}

	/**
	 * Relation inverse adapter.
	 * 
	 * @param type
	 *            the type
	 * @return the fragment service stub. relation type schema type
	 */
	public FragmentServiceStub.RelationTypeSchemaType relationInverseAdapter(
			String type) {
		FragmentServiceStub.RelationTypeSchemaType typeString = FragmentServiceStub.RelationTypeSchemaType.annotation;

		if (type == "annotation") {
			typeString = FragmentServiceStub.RelationTypeSchemaType.annotation;
		} else if (type == "container") {
			typeString = FragmentServiceStub.RelationTypeSchemaType.container;
		} else if (type == "deployment") {
			typeString = FragmentServiceStub.RelationTypeSchemaType.deployment;
		} else if (type == "modeller") {
			typeString = FragmentServiceStub.RelationTypeSchemaType.modeller;
		} else if (type == "transformation") {
			typeString = FragmentServiceStub.RelationTypeSchemaType.transformation;
		} else if (type == "wsdl") {
			typeString = FragmentServiceStub.RelationTypeSchemaType.wsdl;
		}

		return typeString;
	}

	/**
	 * Relation inverse adapter2.
	 * 
	 * @param type
	 *            the type
	 * @return the relation types
	 */
	public RelationTypes relationInverseAdapter2(String type) {
		RelationTypes typeString = RelationTypes.ANNOTATION;

		if (type == "annotation") {
			typeString = RelationTypes.ANNOTATION;
		} else if (type == "container") {
			typeString = RelationTypes.CONTAINER;
		} else if (type == "deployment") {
			typeString = RelationTypes.DEPLOYMENT;
		} else if (type == "modeller") {
			typeString = RelationTypes.MODELLER_DATA;
		} else if (type == "transformation") {
			typeString = RelationTypes.TRANSFORMATION;
		} else if (type == "wsdl") {
			typeString = RelationTypes.WSDL;
		}

		return typeString;
	}

	/**
	 * Relation adapter for bridging and connecting the different namings in
	 * custom RelationTypes enum and predefined Types in the Fragmento
	 * repository.
	 * 
	 * @param type
	 *            the type
	 * @return the string
	 */
	public String relationAdapter(RelationTypes type) {
		String typeString = "";

		switch (type) {
		case ANNOTATION:
			typeString = "annotation";
			break;
		case CONTAINER:
			typeString = "container";
			break;
		case DEPLOYMENT:
			typeString = "deployment";
			break;
		case MODELLER_DATA:
			typeString = "modeller";
			break;
		case TRANSFORMATION:
			typeString = "transformation";
			break;
		case WSDL:
			typeString = "wsdl";
			break;
		default:
			break;
		}

		return typeString;
	}

	/**
	 * Adds the artefact to the list.
	 * 
	 * @param id
	 *            the id
	 * @param desc
	 *            the description
	 * @param type
	 *            the type
	 * @param checkedOut
	 *            is checked out
	 */
	public void addArtefact(int id, String desc, ArtefactTypes type,
			boolean checkedOut) {
		Artefact artefact = new Artefact();
		artefact.setArtefactID(id);
		this.getArtefactList().add(String.valueOf(id));
		artefact.setArtefactDescription(desc);
		artefact.setArtefactType(type);
		artefact.setCheckedOut(checkedOut);
		TodoMockModel input = (TodoMockModel) viewer.getInput();
		ArrayList<IPlaceHolder> categories = (ArrayList<IPlaceHolder>) input
				.getCategories();
		@SuppressWarnings("unchecked")
		ArtefactCategory<ArtefactCategory<Artefact>> artefactsCategory = (ArtefactCategory<ArtefactCategory<Artefact>>) categories
				.get(0);
		Object[] subArray = artefactsCategory.getChildren().toArray();
		for (int i = 0; i < subArray.length; i++) {
			@SuppressWarnings("unchecked")
			ArtefactCategory<Artefact> sub = (ArtefactCategory<Artefact>) subArray[i];
			if (sub.getName() == type.toString()) {
				sub.getChildren().add(artefact);
				viewer.refresh();
			}
		}
	}

	/**
	 * Adds the relation to the list.
	 * 
	 * @param id
	 *            the id
	 * @param desc
	 *            the description
	 * @param type
	 *            the type
	 * @param fromId
	 *            the from id
	 * @param toId
	 *            the to id
	 */
	public void addRelation(int id, String desc, RelationTypes type,
			int fromId, int toId) {
		Relation relation = new Relation();
		relation.setRelationID(id);
		relation.setRelationDescription(desc);
		relation.setRelationType(type);
		relation.setFromID(fromId);
		relation.setToID(toId);

		TodoMockModel input = (TodoMockModel) viewer.getInput();
		ArrayList<IPlaceHolder> categories = (ArrayList<IPlaceHolder>) input
				.getCategories();
		@SuppressWarnings("unchecked")
		RelationsCategory<RelationsCategory<Relation>> relationsCategory = (RelationsCategory<RelationsCategory<Relation>>) categories
				.get(1);
		Object[] subArray = relationsCategory.getChildren().toArray();
		for (int i = 0; i < subArray.length; i++) {
			@SuppressWarnings("unchecked")
			RelationsCategory<Relation> sub = (RelationsCategory<Relation>) subArray[i];
			if (sub.getName() == type.toString()) {
				sub.getChildren().add(relation);
				viewer.refresh();
			}
		}
	}

	/**
	 * Removes the artefact from the list.
	 * 
	 * @param id
	 *            the id
	 * @param type
	 *            the type
	 */
	public void removeArtefact(int id, ArtefactTypes type) {
		TodoMockModel input = (TodoMockModel) viewer.getInput();
		ArrayList<IPlaceHolder> categories = (ArrayList<IPlaceHolder>) input
				.getCategories();
		@SuppressWarnings("unchecked")
		ArtefactCategory<ArtefactCategory<Artefact>> artefactsCategory = (ArtefactCategory<ArtefactCategory<Artefact>>) categories
				.get(0);

		Object[] subArray = artefactsCategory.getChildren().toArray();
		for (int i = 0; i < subArray.length; i++) {
			@SuppressWarnings("unchecked")
			ArtefactCategory<Artefact> sub = (ArtefactCategory<Artefact>) subArray[i];
			if (sub.getName() == type.toString()) {

				Object[] subArt = sub.getChildren().toArray();
				for (int j = 0; j < subArt.length; j++) {
					Artefact sub2 = (Artefact) subArt[j];
					if (sub2.getArtefactID() == id) {
						sub.getChildren().remove(sub2);
						viewer.refresh();
					}
				}
			}
		}
	}

	/**
	 * Removes the relation from the list.
	 * 
	 * @param id
	 *            the id
	 * @param type
	 *            the type
	 */
	public void removeRelation(int id, RelationTypes type) {
		TodoMockModel input = (TodoMockModel) viewer.getInput();
		ArrayList<IPlaceHolder> categories = (ArrayList<IPlaceHolder>) input
				.getCategories();
		@SuppressWarnings("unchecked")
		RelationsCategory<RelationsCategory<Relation>> relationsCategory = (RelationsCategory<RelationsCategory<Relation>>) categories
				.get(1);

		Object[] subArray = relationsCategory.getChildren().toArray();
		for (int i = 0; i < subArray.length; i++) {
			@SuppressWarnings("unchecked")
			RelationsCategory<Relation> sub = (RelationsCategory<Relation>) subArray[i];
			if (sub.getName() == type.toString()) {

				Object[] subArt = sub.getChildren().toArray();
				for (int j = 0; j < subArt.length; j++) {
					Relation sub2 = (Relation) subArt[j];
					if (sub2.getRelationID() == id) {
						sub.getChildren().remove(sub2);
						viewer.refresh();
					}
				}
			}
		}
	}

	/**
	 * Update relation.
	 * 
	 * @param relation
	 *            the relation
	 * @param type
	 *            the type
	 * @param desc
	 *            the description
	 * @param fromId
	 *            the from id
	 * @param toId
	 *            the to id
	 */
	public void updateRelation(Relation relation, String type, String desc,
			int fromId, int toId) {

		UpdateRelationResponseMessage update = fragmento.updateRelation(
				(long) relation.getRelationID(), desc, fromId, toId,
				this.relationInverseAdapter(type));

		if (update == null) {
			this.showErrorMessage("Either source ID, target ID or relation doesn't exist anymore in the repository!");
			viewer.refresh();
		} else {

			relation.setFromID(fromId);
			relation.setToID(toId);
			relation.setRelationDescription(desc);
			relation.setRelationType(this.relationInverseAdapter2(type));

			viewer.update(relation, null);
			viewer.refresh();
		}
	}

}
