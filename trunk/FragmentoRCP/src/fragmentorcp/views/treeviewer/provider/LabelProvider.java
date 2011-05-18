package fragmentorcp.views.treeviewer.provider;

import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import fragmentorcppresenter.models.repository.Artefact;
import fragmentorcppresenter.models.repository.ArtefactCategory;
import fragmentorcppresenter.models.repository.Relation;
import fragmentorcppresenter.models.repository.RelationsCategory;

public class LabelProvider extends StyledCellLabelProvider {
	@Override
	public void update(ViewerCell cell) {
		Object element = cell.getElement();
		StyledString text = new StyledString();

		if (element instanceof ArtefactCategory<?>) {
			ArtefactCategory<?> category = (ArtefactCategory<?>) element;
			text.append(category.getName());
			cell.setImage(PlatformUI.getWorkbench().getSharedImages()
					.getImage(ISharedImages.IMG_OBJ_FOLDER));
			text.append(" ( " +category.getChildren().size() + " ) ", StyledString.COUNTER_STYLER);
		} else if (element instanceof Artefact) {
			Artefact artefact = (Artefact) element;
			text.append(artefact.getArtefactDescription());
			cell.setImage(PlatformUI.getWorkbench().getSharedImages()
					.getImage(ISharedImages.IMG_OBJ_FILE));
		} else if (element instanceof RelationsCategory<?>) {
			RelationsCategory<?> category = (RelationsCategory<?>) element;
			text.append(category.getName());
			cell.setImage(PlatformUI.getWorkbench().getSharedImages()
					.getImage(ISharedImages.IMG_OBJ_FOLDER));
			text.append(" ( " +category.getChildren().size() + " ) ", StyledString.COUNTER_STYLER);
		} else if (element instanceof Relation) {
			Relation relation = (Relation) element;
			text.append(relation.getRelationDescription());
			cell.setImage(PlatformUI.getWorkbench().getSharedImages()
					.getImage(ISharedImages.IMG_OBJ_FILE));
		}
		cell.setText(text.toString());
		cell.setStyleRanges(text.getStyleRanges());
		super.update(cell);
	}
}
