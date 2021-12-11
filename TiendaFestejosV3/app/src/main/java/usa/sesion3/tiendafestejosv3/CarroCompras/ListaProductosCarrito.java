/**package usa.sesion3.tiendafestejosv3.CarroCompras;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import usa.sesion3.tiendafestejosv3.R;
import usa.sesion3.tiendafestejosv3.TablasBD.MotorBdServicios;
import usa.sesion3.tiendafestejosv3.Vista.Servicios;
import usa.sesion3.tiendafestejosv3.Vista.ServiciosAdapter;

public class ListaProductosCarrito  extends AppCompatActivity {
    private MotorBdCarrito motorBdCarrito;
    private ArrayList<ProductosCarrito> listaProductosCarrito;
    private GridView gridView2;

    public ArrayList<ProductosCarrito> llenarLista2(Cursor cursor){
        ArrayList<ProductosCarrito> list = new ArrayList<>();
        if(cursor.getCount() == 0){
            return list;
        }else{
            StringBuffer buffer = new StringBuffer();
            while (cursor.moveToNext()){
                ProductosCarrito productosCarrito = new ProductosCarrito(
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getBlob(3)
                );
                list.add(productosCarrito);
            }
            return list;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_carrito);
        motorBdCarrito = new MotorBdCarrito(getApplicationContext());
        gridView2 = (GridView) findViewById(R.id.gridView2);

        Cursor cursor = motorBdCarrito.getlistaProductos();
        listaProductosCarrito = llenarLista2(cursor);
        CarritoAdapter carritoAdapter = new CarritoAdapter(getApplicationContext(),listaProductosCarrito);
        gridView2.setAdapter(carritoAdapter);

    }
}*/

