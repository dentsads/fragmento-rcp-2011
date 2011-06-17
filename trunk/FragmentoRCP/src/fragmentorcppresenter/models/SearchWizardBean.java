package fragmentorcppresenter.models;

import java.util.Calendar;

/**
 * The Class SearchWizardBean is the model for the search wizard page.
 * 
 * @author Dimitrios Dentsas
 */
public class SearchWizardBean extends ModelAbstraction {

	/** The finished. */
	private boolean finished = false;

	/** The canceled. */
	private boolean canceled = false;

	/** The text. */
	private String text;

	/** The text_1. */
	private String text_1;

	/** The combo_1. */
	private String combo_1;

	/** The date time. */
	private Calendar dateTime;

	/** The date time_1. */
	private Calendar dateTime_1;

	/** The combo_2. */
	private String combo_2;

	/** The date time_2. */
	private Calendar dateTime_2;

	/** The date time_3. */
	private Calendar dateTime_3;

	/** The btn search. */
	private boolean btnSearch;

	/** The btn search_1. */
	private boolean btnSearch_1;

	/**
	 * Checks if is finished.
	 * 
	 * @return true, if is finished
	 */
	public boolean isFinished() {
		return finished;
	}

	/**
	 * Sets the finished.
	 * 
	 * @param finished
	 *            the new finished
	 */
	public void setFinished(boolean finished) {
		propertyChangeSupport.firePropertyChange("finished", this.finished,
				this.finished = finished);
	}

	/**
	 * Gets the text.
	 * 
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text.
	 * 
	 * @param text
	 *            the new text
	 */
	public void setText(String text) {
		propertyChangeSupport.firePropertyChange("text", this.text,
				this.text = text);
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
	}

	/**
	 * Gets the date time.
	 * 
	 * @return the date time
	 */
	public Calendar getDateTime() {
		return dateTime;
	}

	/**
	 * Sets the date time.
	 * 
	 * @param dateTime
	 *            the new date time
	 */
	public void setDateTime(Calendar dateTime) {
		propertyChangeSupport.firePropertyChange("dateTime", this.dateTime,
				this.dateTime = dateTime);
	}

	/**
	 * Gets the date time_1.
	 * 
	 * @return the date time_1
	 */
	public Calendar getDateTime_1() {
		return dateTime_1;
	}

	/**
	 * Sets the date time_1.
	 * 
	 * @param dateTime_1
	 *            the new date time_1
	 */
	public void setDateTime_1(Calendar dateTime_1) {
		propertyChangeSupport.firePropertyChange("dateTime_1", this.dateTime_1,
				this.dateTime_1 = dateTime_1);
	}

	/**
	 * Gets the combo_2.
	 * 
	 * @return the combo_2
	 */
	public String getCombo_2() {
		return combo_2;
	}

	/**
	 * Sets the combo_2.
	 * 
	 * @param combo_2
	 *            the new combo_2
	 */
	public void setCombo_2(String combo_2) {
		propertyChangeSupport.firePropertyChange("combo_2", this.combo_2,
				this.combo_2 = combo_2);
	}

	/**
	 * Gets the date time_2.
	 * 
	 * @return the date time_2
	 */
	public Calendar getDateTime_2() {
		return dateTime_2;
	}

	/**
	 * Sets the date time_2.
	 * 
	 * @param dateTime_2
	 *            the new date time_2
	 */
	public void setDateTime_2(Calendar dateTime_2) {
		propertyChangeSupport.firePropertyChange("dateTime_2", this.dateTime_2,
				this.dateTime_2 = dateTime_2);
	}

	/**
	 * Gets the date time_3.
	 * 
	 * @return the date time_3
	 */
	public Calendar getDateTime_3() {
		return dateTime_3;
	}

	/**
	 * Sets the date time_3.
	 * 
	 * @param dateTime_3
	 *            the new date time_3
	 */
	public void setDateTime_3(Calendar dateTime_3) {
		propertyChangeSupport.firePropertyChange("dateTime_3", this.dateTime_3,
				this.dateTime_3 = dateTime_3);
	}

	/**
	 * Checks if is btn search.
	 * 
	 * @return true, if is btn search
	 */
	public boolean isBtnSearch() {
		return btnSearch;
	}

	/**
	 * Sets the btn search.
	 * 
	 * @param btnSearch
	 *            the new btn search
	 */
	public void setBtnSearch(boolean btnSearch) {
		propertyChangeSupport.firePropertyChange("btnSearch", this.btnSearch,
				this.btnSearch = btnSearch);
	}

	/**
	 * Sets the btn search_1.
	 * 
	 * @param btnSearch_1
	 *            the new btn search_1
	 */
	public void setBtnSearch_1(boolean btnSearch_1) {
		propertyChangeSupport.firePropertyChange("btnSearch_1",
				this.btnSearch_1, this.btnSearch_1 = btnSearch_1);
	}

	/**
	 * Checks if is btn search_1.
	 * 
	 * @return true, if is btn search_1
	 */
	public boolean isBtnSearch_1() {
		return btnSearch_1;
	}

	/**
	 * Checks if is finished open options.
	 * 
	 * @return true, if is finished open options
	 */
	public boolean isFinishedOpenOptions() {
		return finished;
	}

	/**
	 * Sets the finished open options.
	 * 
	 * @param finished
	 *            the new finished open options
	 */
	public void setFinishedOpenOptions(boolean finished) {
		propertyChangeSupport.firePropertyChange("finished", this.finished,
				this.finished = finished);
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
