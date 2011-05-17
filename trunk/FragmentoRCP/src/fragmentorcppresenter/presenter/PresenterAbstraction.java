package fragmentorcppresenter.presenter;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Method;
import java.util.ArrayList;

import fragmentorcppresenter.ifaces.IGuiModelPropertyChange;
import fragmentorcppresenter.models.ModelAbstraction;

/*
 * T= {IViewPart, IEditorPart, Dialog, IWizard, IWizardPage}
 */
public abstract class PresenterAbstraction<T extends IGuiModelPropertyChange> implements PropertyChangeListener {
	
	private ArrayList<T> registeredViews;
    private ArrayList<ModelAbstraction> registeredModels;
	
    public PresenterAbstraction() {
    	registeredViews = new ArrayList<T>();
        registeredModels = new ArrayList<ModelAbstraction>();
    }
    
    public void addModel(ModelAbstraction model) {
        registeredModels.add(model);
        model.addPropertyChangeListener(this);
    }

    public void removeModel(ModelAbstraction model) {
        registeredModels.remove(model);
        model.removePropertyChangeListener(this);
    }

    public void addView(T view) {
        registeredViews.add(view);
    }

    public void removeView(T view) {
        registeredViews.remove(view);
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
//                Method method = model.getClass().
//                    getMethod("set"+propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1), new Class[] 
//                                  {newValue.getClass()}
//
//                             );
//                method.invoke(model, newValue);            

            } catch (Exception ex) {
            	ex.printStackTrace();
            }
        }
    }
	
	
}
