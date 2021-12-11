package usa.sesion3.tiendafestejosv3.Vista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import usa.sesion3.tiendafestejosv3.R;

public class Adaptador_Productos extends BaseAdapter implements View.OnClickListener {

    ArrayList<Entidad_Productos> itemLista;
    Context context;


    public Adaptador_Productos(ArrayList<Entidad_Productos> itemLista, Context context) {
        this.itemLista = itemLista;
        this.context = context;
    }

    @Override
    public int getCount() {

        return itemLista.size(); //devuelve el numero de items de la lista
    }

    @Override
    public Object getItem(int posicion) {
        return itemLista.get(posicion);//devuelve el item en donde vamos a trabajar (posiciones: 0,1,2,n)
    }

    @Override
    public long getItemId(int posicion) {
        return 0;
    }

    /**
     * Este es el metodo mas importante porque es donde se estableccen los valores por cada elemento
     * vidusal del item, de formar similar a lo que se hacia con los fragments
     *
     * @param posicion
     * @param v
     * @param viewGroup
     * @return
     */
    @Override
    public View getView(int posicion, View v, ViewGroup viewGroup) {

        Entidad_Productos datosItem = (Entidad_Productos) getItem(posicion);

        v = LayoutInflater.from(context).inflate(R.layout.item, null);
        //---------------------------------------------------------------
        ImageView imagen = (ImageView) v.findViewById(R.id.imagen_productos1);

        TextView titulo = (TextView) v.findViewById(R.id.titulo);
        TextView descripcion = (TextView) v.findViewById(R.id.descripcion_productos1);

        Button boton1 = (Button) v.findViewById(R.id.boton_productos1);
        boton1.setOnClickListener(this);
        CheckBox favoritos = (CheckBox) v.findViewById(R.id.favoritos_productos1);

        //---------------------------------------------------------------

        /**
         * Pasar los datos desde la entidad a cada elemento visual del item
         */

        imagen.setImageResource(datosItem.getImagen_productos1());
        titulo.setText(datosItem.getTitulo());
        descripcion.setText(datosItem.getDescripcion());


        /**
         * Esuchar sobre el item seleccionado
         */

        /**v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Item: " + boton1.getText(), Toast.LENGTH_LONG).show();
                //Toast.makeText(context, "carrito" + R.id.boton_productos1, Toast.LENGTH_LONG).show();
            }
        });*/


        return v;
    }

    @Override
    public void onClick(View v) {

        Toast.makeText(context, "Item: Producto agregado al carrito", Toast.LENGTH_LONG).show();    }
}
