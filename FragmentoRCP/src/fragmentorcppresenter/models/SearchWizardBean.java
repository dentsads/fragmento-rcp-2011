package fragmentorcppresenter.models;

import java.util.Calendar;

public class SearchWizardBean extends ModelAbstraction {
	private boolean finished = false;
	private boolean canceled = false;
	private String text;
	private String text_1;
	private String combo_1;
	private Calendar dateTime;
	private Calendar dateTime_1;
	private String combo_2;
	private Calendar dateTime_2;
	private Calendar dateTime_3;
	private boolean btnSearch;
	
	
	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		propertyChangeSupport.firePropertyChange("finished", this.finished,
				this.finished = finished);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		propertyChangeSupport.firePropertyChange("text", this.text,
				this.text = text);
	}

	public String getText_1() {
		return text_1;
	}

	public void setText_1(String text_1) {
		propertyChangeSupport.firePropertyChange("text_1", this.text_1,
				this.text_1 = text_1);
	}

	public String getCombo_1() {
		return combo_1;
	}

	public void setCombo_1(String combo_1) {
		propertyChangeSupport.firePropertyChange("combo_1", this.combo_1,
				this.combo_1 = combo_1);
	}

	public Calendar getDateTime() {
		return dateTime;
	}

	public void setDateTime(Calendar dateTime) {
		propertyChangeSupport.firePropertyChange("dateTime", this.dateTime,
				this.dateTime = dateTime);
	}

	public Calendar getDateTime_1() {
		return dateTime_1;
	}

	public void setDateTime_1(Calendar dateTime_1) {
		propertyChangeSupport.firePropertyChange("dateTime_1", this.dateTime_1,
				this.dateTime_1 = dateTime_1);
	}

	public String getCombo_2() {
		return combo_2;
	}

	public void setCombo_2(String combo_2) {
		propertyChangeSupport.firePropertyChange("combo_2", this.combo_2,
				this.combo_2 = combo_2);
	}

	public Calendar getDateTime_2() {
		return dateTime_2;
	}

	public void setDateTime_2(Calendar dateTime_2) {
		propertyChangeSupport.firePropertyChange("dateTime_2", this.dateTime_2,
				this.dateTime_2 = dateTime_2);
	}

	public Calendar getDateTime_3() {
		return dateTime_3;
	}

	public void setDateTime_3(Calendar dateTime_3) {
		propertyChangeSupport.firePropertyChange("dateTime_3", this.dateTime_3,
				this.dateTime_3 = dateTime_3);
	}

	public boolean isBtnSearch() {
		return btnSearch;
	}

	public void setBtnSearch(boolean btnSearch) {
		propertyChangeSupport.firePropertyChange("btnSearch", this.btnSearch,
				this.btnSearch = btnSearch);
	}

	public boolean isFinishedOpenOptions() {
		return finished;
	}

	public void setFinishedOpenOptions(boolean finished) {
		propertyChangeSupport.firePropertyChange("finished", this.finished,
				this.finished = finished);
	}
	
	public boolean isCanceled() {
		return canceled;
	}

	public void setCanceled(boolean canceled) {
		propertyChangeSupport.firePropertyChange("canceled", this.canceled,
				this.canceled = canceled);
	}
}
