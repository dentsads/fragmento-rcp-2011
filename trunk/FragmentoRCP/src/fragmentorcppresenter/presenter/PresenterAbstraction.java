package fragmentorcppresenter.presenter;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Method;
import java.util.concurrent.CopyOnWriteArrayList;

import fragmentorcppresenter.ifaces.IGuiModelPropertyChange;
import fragmentorcppresenter.models.ModelAbstraction;

public abstract class PresenterAbstraction<T extends IGuiModelPropertyChange> implements PropertyChangeListener {
	
    private CopyOnWriteArrayList<T> registeredViews;
    private CopyOnWriteArrayList<ModelAbstraction> registeredModels;
    
    public PresenterAbstraction() { 	
    	registeredViews = new CopyOnWriteArrayList<T>();
    	registeredModels = new CopyOnWriteArrayList<ModelAbstraction>();
    }
    
    public void addModel(ModelAbstraction model) {
        registeredModels.add(model);
        model.addPropertyChangeListener(this);
//        System.out.println(model.getClass().getSimpleName() + " added");
    }

    public void removeModel(ModelAbstraction model) {
        registeredModels.remove(model);
        model.removePropertyChangeListener(this);
//        System.out.println(model.getClass().getSimpleName() + " removed");
    }

    public void addView(T view) {
        registeredViews.add(view);
//        System.out.println(view.getClass().getSimpleName() + " added");
    }

    public void removeView(T view) {
        registeredViews.remove(view);
//        System.out.println(view.getClass().getSimpleName() + " removed");
    }
    
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		for (T view: registeredViews) {
            view.modelPropertyChange(event);
        }

	}
	
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
