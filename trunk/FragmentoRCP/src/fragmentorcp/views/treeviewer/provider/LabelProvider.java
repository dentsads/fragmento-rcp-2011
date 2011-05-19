package fragmentorcp.views.treeviewer.provider;

import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import fragmentorcppresenter.models.repository.Artefact;
import fragmentorcppresenter.models.repository.ArtefactCategory;
import fragmentorcppresenter.models.repository.Relation;
import fragmentorcppresenter.models.repository.RelationsCategory;

public class LabelProvider extends StyledCellLabelProvider {
	
	final String FOREGROUND_COLOR = "red_foreground_color";
	ColorRegistry colorRegistry = JFaceResources.getColorRegistry();
	
	@Override
	public void update(ViewerCell cell) {
		Object element = cell.getElement();
		StyledString text = new StyledString();
		colorRegistry.put(FOREGROUND_COLOR, new RGB(255, 69, 0));
		
		if (element instanceof ArtefactCategory<?>) {
			ArtefactCategory<?> category = (ArtefactCategory<?>) element;			
			text.append(category.getName());
			cell.setImage(PlatformUI.getWorkbench().getSharedImages()
					.getImage(ISharedImages.IMG_OBJ_FOLDER));
			text.append(" ( " +category.getChildren().size() + " ) ", StyledString.COUNTER_STYLER);
			//text.append(" ( " + "c" + " ) ", StyledString.DECORATIONS_STYLER);			
		} else if (element instanceof Artefact) {
			Artefact artefact = (Artefact) element;
			if (artefact.isCheckedOut());
			text.append(" (" + "c" + ") ", StyledString.createColorRegistryStyler(FOREGROUND_COLOR, null));
			text.append("(ID " + String.valueOf(artefact.getArtefactID()) + ") ");
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
			text.append("(ID " + String.valueOf(relation.getRelationID()) + ") ");
			text.append(relation.getRelationDescription());
			cell.setImage(PlatformUI.getWorkbench().getSharedImages()
					.getImage(ISharedImages.IMG_OBJ_FILE));
		}
		cell.setText(text.toString());
		cell.setStyleRanges(text.getStyleRanges());
		super.update(cell);
	}
}
