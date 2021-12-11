package usa.sesion3.tiendafestejosv3.Vista;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import usa.sesion3.tiendafestejosv3.R;
import usa.sesion3.tiendafestejosv3.TablasBD.MotorBdServicios;

public class ListaServicios extends AppCompatActivity {
    private MotorBdServicios motorBdServicios;
    private ArrayList<Servicios> listaServicios;
    private GridView gridView;



    public ArrayList<Servicios> llenarLista(Cursor cursor){
        ArrayList<Servicios> list = new ArrayList<>();
        if(cursor.getCount() == 0){
            return list;
        }else{
            StringBuffer buffer = new StringBuffer();
            while (cursor.moveToNext()){
                Servicios servicios = new Servicios(
                        cursor.getString(1),
                        cursor.getBlob(2)
                );
                list.add(servicios);
            }
            return list;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_servicios);
        motorBdServicios = new MotorBdServicios(getApplicationContext());
        gridView = (GridView) findViewById(R.id.gridView);

        Cursor cursor = motorBdServicios.getServicios();
        listaServicios = llenarLista(cursor);
        ServiciosAdapter serviciosAdapter = new ServiciosAdapter(getApplicationContext(),listaServicios);
        gridView.setAdapter(serviciosAdapter);

    }
}
