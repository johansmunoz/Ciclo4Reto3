package usa.sesion3.tiendafestejosv3.Vista;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import usa.sesion3.tiendafestejosv3.R;


public class Fragment_Productos extends Fragment {

    View v;


    /**@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        v = inflater.inflate(R.layout.fragment__productos, container, false);
        //--------------------------IMAGENES PORTAFOLIO------------------------------

        Resources res1 = getResources();
        Drawable drawable1 = res1.getDrawable(R.drawable.pinata1, v.getContext().getTheme());

        ImageView imgicono1 = (ImageView) v.findViewById(R.id.imagen1);
        imgicono1.setImageDrawable(drawable1);
//-----------------------------------------------------------------------------------
        Resources res2 = getResources();
        Drawable drawable2 = res2.getDrawable(R.drawable.pinata2, v.getContext().getTheme());

        ImageView imgicono2 = (ImageView) v.findViewById(R.id.imagen2);
        imgicono2.setImageDrawable(drawable2);
        //-----------------------------------------------------------------------------
        Resources res3 = getResources();
        Drawable drawable3 = res3.getDrawable(R.drawable.pinata3, v.getContext().getTheme());

        ImageView imgicono3 = (ImageView) v.findViewById(R.id.imagen3);
        imgicono3.setImageDrawable(drawable3);
        //--------------------------------------------------------------------------------
        Resources res4 = getResources();
        Drawable drawable4 = res4.getDrawable(R.drawable.pinata4, v.getContext().getTheme());

        ImageView imgicono4 = (ImageView) v.findViewById(R.id.imagen4);
        imgicono4.setImageDrawable(drawable4);

        //-------------------------IMAGENES PORTAFOLIO----------------------

        return v;
    }*/
    /**
     * Atributos para el manejo de las listas
     */
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment__productos, container, false);

        ListView listView2 = (ListView)rootView.findViewById(R.id.list_view);
        Adaptador_Productos adaptador_productos = new Adaptador_Productos(GetItemLista(), getContext());

        listView2.setAdapter(adaptador_productos);

        return rootView;
    }

    /**
     * FUNCION PARA LA IMPORTACION DE LA LISTA
     * @return
     */
    private ArrayList<Entidad_Productos> GetItemLista(){
        ArrayList<Entidad_Productos> lista = new ArrayList<>();
        lista.add(new Entidad_Productos(R.drawable.pinata1, "Whats App", "W App"));
        lista.add(new Entidad_Productos(R.drawable.batman, "Batman", "Batman"));
        lista.add(new Entidad_Productos(R.drawable.pinata3, "Escudo Capitan Ámerica", "Escudo Capitán américa"));
        return lista;
    }
}