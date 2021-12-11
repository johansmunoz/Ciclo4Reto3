package usa.sesion3.tiendafestejosv3.Vista;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import usa.sesion3.tiendafestejosv3.R;

public class Fragment_Servicios extends Fragment {

    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        v = inflater.inflate(R.layout.fragment__servicios, container, false);

        //--------------------------IMAGENES PORTAFOLIO------------------------------

        /**Resources res1 = getResources();
        Drawable drawable1 = res1.getDrawable(R.drawable.cumpleanos, v.getContext().getTheme());

        ImageView imgicono1 = (ImageView) v.findViewById(R.id.imagen_servicios);
        imgicono1.setImageDrawable(drawable1);
//-----------------------------------------------------------------------------------
        Resources res2 = getResources();
        Drawable drawable2 = res2.getDrawable(R.drawable.despedidasolteros, v.getContext().getTheme());

        ImageView imgicono2 = (ImageView) v.findViewById(R.id.imagen2);
        imgicono2.setImageDrawable(drawable2);
        //-----------------------------------------------------------------------------
        Resources res3 = getResources();
        Drawable drawable3 = res3.getDrawable(R.drawable.fiestas15anos, v.getContext().getTheme());

        ImageView imgicono3 = (ImageView) v.findViewById(R.id.imagen3);
        imgicono3.setImageDrawable(drawable3);
        //--------------------------------------------------------------------------------
        Resources res4 = getResources();
        Drawable drawable4 = res4.getDrawable(R.drawable.matrimonios, v.getContext().getTheme());

        ImageView imgicono4 = (ImageView) v.findViewById(R.id.imagen4);
        imgicono4.setImageDrawable(drawable4);*/

        //-------------------------IMAGENES PORTAFOLIO----------------------

        return v;
    }
}