package fragmentorcppresenter.presenter;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Method;
import java.util.concurrent.CopyOnWriteArrayList;

import fragmentorcppresenter.ifaces.IGuiModelPropertyChange;
import fragmentorcppresenter.models.ModelAbstraction;

/**
 * The Class PresenterAbstraction.
 *
 * @param <T> the generic type
 * @author Dimitrios Dentsas
 */
public abstract class PresenterAbstraction<T extends IGuiModelPropertyChange> implements PropertyChangeListener {
	
    /** The registered views. */
    private CopyOnWriteArrayList<T> registeredViews;
    
    /** The registered models. */
    private CopyOnWriteArrayList<ModelAbstraction> registeredModels;
    
    /**
     * Instantiates registered view and model lists.
     */
    public PresenterAbstraction() { 	
    	registeredViews = new CopyOnWriteArrayList<T>();
    	registeredModels = new CopyOnWriteArrayList<ModelAbstraction>();
    }
    
    /**
     * Adds the model to the registeredModels list.
     *
     * @param model the model
     */
    public void addModel(ModelAbstraction model) {
        registeredModels.add(model);
        model.addPropertyChangeListener(this);
//        System.out.println(model.getClass().getSimpleName() + " added");
    }

    /**
     * Removes the model from registeredModels list.
     *
     * @param model the model
     */
    public void removeModel(ModelAbstraction model) {
        registeredModels.remove(model);
        model.removePropertyChangeListener(this);
//        System.out.println(model.getClass().getSimpleName() + " removed");
    }

    /**
     * Adds the view to the registeredViews list.
     *
     * @param view the view
     */
    public void addView(T view) {
        registeredViews.add(view);
//        System.out.println(view.getClass().getSimpleName() + " added");
    }

    /**
     * Removes the view from the registeredViews list.
     *
     * @param view the view
     */
    public void removeView(T view) {
        registeredViews.remove(view);
//        System.out.println(view.getClass().getSimpleName() + " removed");
    }
    
	/* (non-Javadoc)
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		for (T view: registeredViews) {
            view.modelPropertyChange(event);
        }

	}
	
	/**
	 * Sets the model property.
	 *
	 * @param propertyName the property name
	 * @param newValue the new value
	 */
	public void setModelProperty(String propertyName, Object newValue) {
        for (ModelAbstraction model: registeredModels) {
            try {
            	Method[] names = model.getClass().getMethods();
            	for (int i = 0; i < names.length; i++) {
					if (names[i].getName().equals("set"+propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1))) {
						names[i].invoke(model, newValue);
						break;
					}
				}        
            } catch (Exception ex) {
            	ex.printStackTrace();
            }
        }
    }
	
	
}
