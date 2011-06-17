package fragmentorcppresenter.models;

/**
 * The Class CreateNewItemBean is the model for the createNewItem Page.
 * 
 * @author Dimitrios Dentsas
 */
public class CreateNewItemBean extends ModelAbstraction {

	/** The local browse button selected. */
	private boolean localBrowseButtonSelected;

	/** The finished. */
	private boolean finished = false;

	/** The canceled. */
	private boolean canceled = false;

	/** The combo. */
	private String combo;

	/** The description. */
	private String description;

	/** The text_1. */
	private String text_1;

	/** The text_2. */
	private String text_2;

	/** The button enable. */
	private boolean buttonEnable;

	/** The button pushed. */
	private boolean buttonPushed;

	/** The combo_1. */
	private String combo_1;

	/** The from id. */
	private String fromId;

	/** The to id. */
	private String toId;

	/** The description2. */
	private String description2;

	/** The button enable2. */
	private boolean buttonEnable2;

	/** The button pushed2. */
	private boolean buttonPushed2;

	/** The update relation. */
	private boolean updateRelation;

	/**
	 * Sets the local browse button selected.
	 * 
	 * @param localBrowseButtonSelected
	 *            the new local browse button selected
	 */
	public void setLocalBrowseButtonSelected(boolean localBrowseButtonSelected) {
		propertyChangeSupport.firePropertyChange("localBrowseButtonSelected",
				this.localBrowseButtonSelected,
				this.localBrowseButtonSelected = localBrowseButtonSelected);

		/*
		 * logical expression for enabling or disabling the create item button.
		 * All needed fields must not be empty
		 */
		this.setButtonEnable(this.combo != null
				&& !this.combo.equals("")
				&& this.description != null
				&& !this.description.equals("")
				&& ((localBrowseButtonSelected && this.text_1 != null && !this.text_1
						.equals("")) || (!localBrowseButtonSelected
						&& this.text_2 != null && !this.text_2.equals(""))));
	}

	/**
	 * Checks if local browse button is selected.
	 * 
	 * @return true, if is local browse button selected
	 */
	public boolean isLocalBrowseButtonSelected() {
		return localBrowseButtonSelected;
	}

	/**
	 * Checks if wizard page is finished.
	 * 
	 * @return true, if is finished
	 */
	public boolean isFinished() {
		return finished;
	}

	/**
	 * Sets the wizard page finished.
	 * 
	 * @param finished
	 *            the new boolean value
	 */
	public void setFinished(boolean finished) {
		propertyChangeSupport.firePropertyChange("finished", this.finished,
				this.finished = finished);
	}

	/**
	 * Sets the combo.
	 * 
	 * @param combo
	 *            the new combo
	 */
	public void setCombo(String combo) {
		propertyChangeSupport.firePropertyChange("combo", this.combo,
				this.combo = combo);

		this.setButtonEnable(this.combo != null
				&& !this.combo.equals("")
				&& this.description != null
				&& !this.description.equals("")
				&& ((localBrowseButtonSelected && this.text_1 != null && !this.text_1
						.equals("")) || (!localBrowseButtonSelected
						&& this.text_2 != null && !this.text_2.equals(""))));
	}

	/**
	 * Gets the combo.
	 * 
	 * @return the combo
	 */
	public String getCombo() {
		return combo;
	}

	/**
	 * Sets the description.
	 * 
	 * @param description
	 *            the new description
	 */
	public void setDescription(String description) {
		propertyChangeSupport.firePropertyChange("description",
				this.description, this.description = description);

		this.setButtonEnable(this.combo != null
				&& !this.combo.equals("")
				&& this.description != null
				&& !this.description.equals("")
				&& ((localBrowseButtonSelected && this.text_1 != null && !this.text_1
						.equals("")) || (!localBrowseButtonSelected
						&& this.text_2 != null && !this.text_2.equals(""))));
	}

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Gets the text_1.
	 * 
	 * @return the text_1
	 */
	public String getText_1() {
		return text_1;
	}

	/**
	 * Sets the text_1.
	 * 
	 * @param text_1
	 *            the new text_1
	 */
	public void setText_1(String text_1) {
		propertyChangeSupport.firePropertyChange("text_1", this.text_1,
				this.text_1 = text_1);

		this.setButtonEnable(this.combo != null
				&& !this.combo.equals("")
				&& this.description != null
				&& !this.description.equals("")
				&& ((localBrowseButtonSelected && this.text_1 != null && !this.text_1
						.equals("")) || (!localBrowseButtonSelected
						&& this.text_2 != null && !this.text_2.equals(""))));
	}

	/**
	 * Gets the text_2.
	 * 
	 * @return the text_2
	 */
	public String getText_2() {
		return text_2;
	}

	/**
	 * Sets the text_2.
	 * 
	 * @param text_2
	 *            the new text_2
	 */
	public void setText_2(String text_2) {
		propertyChangeSupport.firePropertyChange("text_2", this.text_2,
				this.text_2 = text_2);

		this.setButtonEnable(this.combo != null
				&& !this.combo.equals("")
				&& this.description != null
				&& !this.description.equals("")
				&& ((localBrowseButtonSelected && this.text_1 != null && !this.text_1
						.equals("")) || (!localBrowseButtonSelected
						&& this.text_2 != null && !this.text_2.equals(""))));
	}

	/**
	 * Sets the button enable.
	 * 
	 * @param buttonEnable
	 *            the new button enable
	 */
	public void setButtonEnable(boolean buttonEnable) {
		propertyChangeSupport.firePropertyChange("buttonEnable",
				this.buttonEnable, this.buttonEnable = buttonEnable);
	}

	/**
	 * Checks if is button enable.
	 * 
	 * @return true, if is button enable
	 */
	public boolean isButtonEnable() {
		return buttonEnable;
	}

	/**
	 * Sets the button pushed.
	 * 
	 * @param buttonPushed
	 *            the new button pushed
	 */
	public void setButtonPushed(boolean buttonPushed) {
		propertyChangeSupport.firePropertyChange("buttonPushed",
				this.buttonPushed, this.buttonPushed = buttonPushed);
	}

	/**
	 * Checks if is button pushed.
	 * 
	 * @return true, if is button pushed
	 */
	public boolean isButtonPushed() {
		return buttonPushed;
	}

	/**
	 * Gets the combo_1.
	 * 
	 * @return the combo_1
	 */
	public String getCombo_1() {
		return combo_1;
	}

	/**
	 * Sets the combo_1.
	 * 
	 * @param combo_1
	 *            the new combo_1
	 */
	public void setCombo_1(String combo_1) {
		propertyChangeSupport.firePropertyChange("combo_1", this.combo_1,
				this.combo_1 = combo_1);

		this.setButtonEnable2(this.combo_1 != null && !this.combo_1.equals("")
				&& this.description2 != null && !this.description2.equals("")
				&& this.fromId != null && !this.fromId.equals("")
				&& this.toId != null && !this.toId.equals(""));
	}

	/**
	 * Gets the from id.
	 * 
	 * @return the from id
	 */
	public String getFromId() {
		return fromId;
	}

	/**
	 * Sets the from id.
	 * 
	 * @param fromId
	 *            the new from id
	 */
	public void setFromId(String fromId) {
		propertyChangeSupport.firePropertyChange("fromId", this.fromId,
				this.fromId = fromId);

		this.setButtonEnable2(this.combo_1 != null && !this.combo_1.equals("")
				&& this.description2 != null && !this.description2.equals("")
				&& this.fromId != null && !this.fromId.equals("")
				&& this.toId != null && !this.toId.equals(""));
	}

	/**
	 * Gets the to id.
	 * 
	 * @return the to id
	 */
	public String getToId() {
		return toId;
	}

	/**
	 * Sets the to id.
	 * 
	 * @param toId
	 *            the new to id
	 */
	public void setToId(String toId) {
		propertyChangeSupport.firePropertyChange("toId", this.toId,
				this.toId = toId);

		this.setButtonEnable2(this.combo_1 != null && !this.combo_1.equals("")
				&& this.description2 != null && !this.description2.equals("")
				&& this.fromId != null && !this.fromId.equals("")
				&& this.toId != null && !this.toId.equals(""));
	}

	/**
	 * Gets the description2.
	 * 
	 * @return the description2
	 */
	public String getDescription2() {
		return description2;
	}

	/**
	 * Sets the description2.
	 * 
	 * @param description2
	 *            the new description2
	 */
	public void setDescription2(String description2) {
		propertyChangeSupport.firePropertyChange("description2",
				this.description2, this.description2 = description2);

		this.setButtonEnable2(this.combo_1 != null && !this.combo_1.equals("")
				&& this.description2 != null && !this.description2.equals("")
				&& this.fromId != null && !this.fromId.equals("")
				&& this.toId != null && !this.toId.equals(""));
	}

	/**
	 * Sets the button enable2.
	 * 
	 * @param buttonEnable2
	 *            the new button enable2
	 */
	public void setButtonEnable2(boolean buttonEnable2) {
		propertyChangeSupport.firePropertyChange("buttonEnable2",
				this.buttonEnable2, this.buttonEnable2 = buttonEnable2);
	}

	/**
	 * Checks if is button enable2.
	 * 
	 * @return true, if is button enable2
	 */
	public boolean isButtonEnable2() {
		return buttonEnable2;
	}

	/**
	 * Sets the button pushed2.
	 * 
	 * @param buttonPushed2
	 *            the new button pushed2
	 */
	public void setButtonPushed2(boolean buttonPushed2) {
		propertyChangeSupport.firePropertyChange("buttonPushed2",
				this.buttonPushed2, this.buttonPushed2 = buttonPushed2);
	}

	/**
	 * Checks if is button pushed2.
	 * 
	 * @return true, if is button pushed2
	 */
	public boolean isButtonPushed2() {
		return buttonPushed2;
	}

	/**
	 * Sets the update relation.
	 * 
	 * @param updateRelation
	 *            the new update relation
	 */
	public void setUpdateRelation(boolean updateRelation) {
		propertyChangeSupport.firePropertyChange("updateRelation",
				this.updateRelation, this.updateRelation = updateRelation);
	}

	/**
	 * Checks if is update relation.
	 * 
	 * @return true, if is update relation
	 */
	public boolean isUpdateRelation() {
		return updateRelation;
	}

	/**
	 * Checks if is canceled.
	 * 
	 * @return true, if is canceled
	 */
	public boolean isCanceled() {
		return canceled;
	}

	/**
	 * Sets the canceled.
	 * 
	 * @param canceled
	 *            the new canceled
	 */
	public void setCanceled(boolean canceled) {
		propertyChangeSupport.firePropertyChange("canceled", this.canceled,
				this.canceled = canceled);
	}
}
