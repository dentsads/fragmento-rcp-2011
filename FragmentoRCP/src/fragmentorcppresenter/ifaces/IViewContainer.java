package fragmentorcppresenter.ifaces;

import org.eclipse.core.databinding.observable.value.IObservableValue;

public interface IViewContainer {
	IObservableValue getTxtserviceUriObservable();

	IObservableValue getBtnApplyObservable();
}
