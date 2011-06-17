package fragmentorcppresenter.models;

/**
 * The Class OptionsWizardBean is the model for the options page.
 * 
 * @author Dimitrios Dentsas
 */
public class OptionsWizardBean extends ModelAbstraction {

	/**
	 * Instantiates a new options wizard bean.
	 */
	public OptionsWizardBean() {
	}

	/** The service endpoint uri. */
	private String txtserviceUri;

	/** The button apply boolean. */
	private boolean btnApply;

	/** The button retrieve all available. */
	private boolean btnRetrieveAllAvailable;

	/** The finished boolean. */
	private boolean finished = false;

	/** The canceled boolean. */
	private boolean canceled = false;

	/** The button retrieve now. */
	private boolean btnRetrieveNow;

	/**
	 * Sets the service endpoint uri.
	 * 
	 * @param txtserviceUri
	 *            the service endpoint uri
	 */
	public void setTxtserviceUri(String txtserviceUri) {
		propertyChangeSupport.firePropertyChange("txtserviceUri",
				this.txtserviceUri, this.txtserviceUri = txtserviceUri);

		this.setBtnApply(this.txtserviceUri != null
				&& !this.txtserviceUri.trim().equals(""));
	}

	/**
	 * Gets the service endpoint uri.
	 * 
	 * @return the service endpoint uri
	 */
	public String getTxtserviceUri() {
		return txtserviceUri;
	}

	/**
	 * Checks if btnapply was clicked.
	 * 
	 * @return true, if is btn apply
	 */
	public boolean isBtnApply() {
		return btnApply;
	}

	/**
	 * Sets the btnapply boolean value.
	 * 
	 * @param btnApply
	 *            the new boolean value
	 */
	public void setBtnApply(boolean btnApply) {
		propertyChangeSupport.firePropertyChange("btnApply", this.btnApply,
				this.btnApply = btnApply);
	}

	/**
	 * Sets the btn retrieve all available.
	 * 
	 * @param btnRetrieveAllAvailable
	 *            the new btn retrieve all available
	 */
	public void setBtnRetrieveAllAvailable(boolean btnRetrieveAllAvailable) {
		propertyChangeSupport.firePropertyChange("btnRetrieveAllAvailable",
				this.btnRetrieveAllAvailable,
				this.btnRetrieveAllAvailable = btnRetrieveAllAvailable);
	}

	/**
	 * Checks if btnRretrieveAllAvailable was clicked.
	 * 
	 * @return true, if btnRetrieveAllAvailable was clicked
	 */
	public boolean isBtnRetrieveAllAvailable() {
		return btnRetrieveAllAvailable;
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

	/**
	 * Sets the btn retrieve now.
	 * 
	 * @param btnRetrieveNow
	 *            the new btn retrieve now
	 */
	public void setBtnRetrieveNow(boolean btnRetrieveNow) {
		propertyChangeSupport.firePropertyChange("btnRetrieveNow",
				this.btnRetrieveNow, this.btnRetrieveNow = btnRetrieveNow);
	}

	/**
	 * Checks if is btn retrieve now.
	 * 
	 * @return true, if is btn retrieve now
	 */
	public boolean isBtnRetrieveNow() {
		return btnRetrieveNow;
	}

}