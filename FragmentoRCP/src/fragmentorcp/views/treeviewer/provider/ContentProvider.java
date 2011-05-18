package fragmentorcp.views.treeviewer.provider;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import fragmentorcppresenter.models.repository.ArtefactCategory;
import fragmentorcppresenter.models.repository.RelationsCategory;

public class ContentProvider implements ITreeContentProvider {
	
	private TodoMockModel model;
	
	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.model = (TodoMockModel) newInput;
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return model.getCategories().toArray();
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof ArtefactCategory<?>) {
			ArtefactCategory<?> category = (ArtefactCategory<?>) parentElement;
			return category.getChildren().toArray();
		} else if (parentElement instanceof RelationsCategory<?>) {
			RelationsCategory<?> category = (RelationsCategory<?>) parentElement;
			return category.getChildren().toArray();
		}
		return null;
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof ArtefactCategory<?>) {
			return true;
		} else if (element instanceof RelationsCategory<?>) {
			return true;
		}
		return false;
	}

}
