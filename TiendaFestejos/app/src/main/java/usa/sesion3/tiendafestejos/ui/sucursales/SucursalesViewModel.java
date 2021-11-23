package usa.sesion3.tiendafestejos.ui.sucursales;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SucursalesViewModel extends ViewModel{
    private MutableLiveData<String> mText;

    public SucursalesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Este es el espacio para las sucursales");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
