package fragmentorcp.views.treeviewer.provider;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import fragmentorcppresenter.models.repository.ArtefactCategory;
import fragmentorcppresenter.models.repository.RelationsCategory;

/**
 * The Class ContentProvider for the TreeViewer.
 *
 * @author Dimitrios Dentsas
 */
public class ContentProvider implements ITreeContentProvider {

	/** The model. */
	private TodoMockModel model;

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	@Override
	public void dispose() {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.model = (TodoMockModel) newInput;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getElements(java.lang.Object)
	 */
	@Override
	public Object[] getElements(Object inputElement) {
		return model.getCategories().toArray();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
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

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 */
	@Override
	public Object getParent(Object element) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 */
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
