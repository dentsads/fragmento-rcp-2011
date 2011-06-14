package fragmentorcppresenter.models;

public class CreateNewItemBean extends ModelAbstraction {
	private boolean localBrowseButtonSelected;
	private boolean finished = false;
	private boolean canceled = false;
	private String combo;
	private String description;
	private String text_1;
	private String text_2;
	private boolean buttonEnable;
	private boolean buttonPushed;

	private String combo_1;
	private String fromId;
	private String toId;
	private String description2;
	private boolean buttonEnable2;
	private boolean buttonPushed2;
	private boolean updateRelation;
	
	public void setLocalBrowseButtonSelected(boolean localBrowseButtonSelected) {
		propertyChangeSupport.firePropertyChange("localBrowseButtonSelected", this.localBrowseButtonSelected,
				this.localBrowseButtonSelected = localBrowseButtonSelected);
		
		this.setButtonEnable(this.combo != null && !this.combo.equals("") && this.description != null && !this.description.equals("")
				&& ((localBrowseButtonSelected && this.text_1 != null && !this.text_1.equals(""))||(!localBrowseButtonSelected &&
						this.text_2 != null && !this.text_2.equals(""))));
	}

	public boolean isLocalBrowseButtonSelected() {
		return localBrowseButtonSelected;
	}
	
	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		propertyChangeSupport.firePropertyChange("finished", this.finished,
				this.finished = finished);
	}
	
	public void setCombo(String combo) {
		propertyChangeSupport.firePropertyChange("combo", this.combo,
				this.combo = combo);
		
		this.setButtonEnable(this.combo != null && !this.combo.equals("") && this.description != null && !this.description.equals("")
				&& ((localBrowseButtonSelected && this.text_1 != null && !this.text_1.equals(""))||(!localBrowseButtonSelected &&
						this.text_2 != null && !this.text_2.equals(""))));
	}

	public String getCombo() {
		return combo;
	}

	public void setDescription(String description) {
		propertyChangeSupport.firePropertyChange("description", this.description,
				this.description = description);
		
		this.setButtonEnable(this.combo != null && !this.combo.equals("") && this.description != null && !this.description.equals("")
				&& ((localBrowseButtonSelected && this.text_1 != null && !this.text_1.equals(""))||(!localBrowseButtonSelected &&
						this.text_2 != null && !this.text_2.equals(""))));
	}

	public String getDescription() {
		return description;
	}

	public String getText_1() {
		return text_1;
	}

	public void setText_1(String text_1) {
		propertyChangeSupport.firePropertyChange("text_1", this.text_1,
				this.text_1 = text_1);
		
		this.setButtonEnable(this.combo != null && !this.combo.equals("") && this.description != null && !this.description.equals("")
				&& ((localBrowseButtonSelected && this.text_1 != null && !this.text_1.equals(""))||(!localBrowseButtonSelected &&
						this.text_2 != null && !this.text_2.equals(""))));
	}

	public String getText_2() {
		return text_2;
	}

	public void setText_2(String text_2) {
		propertyChangeSupport.firePropertyChange("text_2", this.text_2,
				this.text_2 = text_2);
		
		this.setButtonEnable(this.combo != null && !this.combo.equals("") && this.description != null && !this.description.equals("")
				&& ((localBrowseButtonSelected && this.text_1 != null && !this.text_1.equals(""))||(!localBrowseButtonSelected &&
						this.text_2 != null && !this.text_2.equals(""))));
	}

	public void setButtonEnable(boolean buttonEnable) {
		propertyChangeSupport.firePropertyChange("buttonEnable", this.buttonEnable,
				this.buttonEnable = buttonEnable);
	}

	public boolean isButtonEnable() {
		return buttonEnable;
	}

	public void setButtonPushed(boolean buttonPushed) {
		propertyChangeSupport.firePropertyChange("buttonPushed", this.buttonPushed,
				this.buttonPushed = buttonPushed);
	}

	public boolean isButtonPushed() {
		return buttonPushed;
	}

	public String getCombo_1() {
		return combo_1;
	}

	public void setCombo_1(String combo_1) {
		propertyChangeSupport.firePropertyChange("combo_1", this.combo_1,
				this.combo_1 = combo_1);
		
		this.setButtonEnable2(this.combo_1 != null && !this.combo_1.equals("") && this.description2 != null && !this.description2.equals("")
				&& this.fromId != null && !this.fromId.equals("") && this.toId != null && !this.toId.equals(""));
	}

	public String getFromId() {
		return fromId;
	}

	public void setFromId(String fromId) {
		propertyChangeSupport.firePropertyChange("fromId", this.fromId,
				this.fromId = fromId);
		
		this.setButtonEnable2(this.combo_1 != null && !this.combo_1.equals("") && this.description2 != null && !this.description2.equals("")
				&& this.fromId != null && !this.fromId.equals("") && this.toId != null && !this.toId.equals(""));
	}

	public String getToId() {
		return toId;
	}

	public void setToId(String toId) {
		propertyChangeSupport.firePropertyChange("toId", this.toId,
				this.toId = toId);
		
		this.setButtonEnable2(this.combo_1 != null && !this.combo_1.equals("") && this.description2 != null && !this.description2.equals("")
				&& this.fromId != null && !this.fromId.equals("") && this.toId != null && !this.toId.equals(""));
	}

	public String getDescription2() {
		return description2;
	}

	public void setDescription2(String description2) {
		propertyChangeSupport.firePropertyChange("description2", this.description2,
				this.description2 = description2);
		
		this.setButtonEnable2(this.combo_1 != null && !this.combo_1.equals("") && this.description2 != null && !this.description2.equals("")
				&& this.fromId != null && !this.fromId.equals("") && this.toId != null && !this.toId.equals(""));
	}

	public void setButtonEnable2(boolean buttonEnable2) {
		propertyChangeSupport.firePropertyChange("buttonEnable2", this.buttonEnable2,
				this.buttonEnable2 = buttonEnable2);
	}

	public boolean isButtonEnable2() {
		return buttonEnable2;
	}

	public void setButtonPushed2(boolean buttonPushed2) {
		propertyChangeSupport.firePropertyChange("buttonPushed2", this.buttonPushed2,
				this.buttonPushed2 = buttonPushed2);
	}

	public boolean isButtonPushed2() {
		return buttonPushed2;
	}	

	public void setUpdateRelation(boolean updateRelation) {
		propertyChangeSupport.firePropertyChange("updateRelation", this.updateRelation,
				this.updateRelation = updateRelation);
	}

	public boolean isUpdateRelation() {
		return updateRelation;
	}

	public boolean isCanceled() {
		return canceled;
	}

	public void setCanceled(boolean canceled) {
		propertyChangeSupport.firePropertyChange("canceled", this.canceled,
				this.canceled = canceled);
	}
}
