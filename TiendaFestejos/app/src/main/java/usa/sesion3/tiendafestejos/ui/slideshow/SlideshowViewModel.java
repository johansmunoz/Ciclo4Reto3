package usa.sesion3.tiendafestejos.ui.slideshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SlideshowViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SlideshowViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Este sera el espacio para ver los servicios");
    }

    public LiveData<String> getText() {
        return mText;
    }
}