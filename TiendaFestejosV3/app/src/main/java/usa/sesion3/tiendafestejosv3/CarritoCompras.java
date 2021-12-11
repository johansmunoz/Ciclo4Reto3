package usa.sesion3.tiendafestejosv3;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import usa.sesion3.tiendafestejosv3.TablasBD.MotorBaseDatos;

public class CarritoCompras extends AppCompatActivity {

    Cursor cursor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carritocompras);

        MotorBaseDatos conectar=new MotorBaseDatos(this, "Tienda_festejos", null, 1);

        //Metodo para escribir datos
        SQLiteDatabase db_escribir = conectar.getWritableDatabase();
/**
 * Llamamos e metodo onUpgrade para sobreesscribir la estructura de la tabla agregando sin
 * problemas nuevas columnas y tipos de datos
 */
        conectar.onUpgrade(db_escribir,1,2);

        db_escribir.execSQL("INSERT INTO carrito VALUES (4,'producto nuevo', 'hola')");

        //Metodo para leer datos
        SQLiteDatabase db_leer = conectar.getReadableDatabase();
        TextView lista = (TextView) findViewById(R.id.lista_compras);
        cursor = db_leer.rawQuery("SELECT * FROM carrito", null);
        while(cursor.moveToNext()){
            lista.append(cursor.getString(0)+":"+cursor.getString(1)+
                    cursor.getString(2)+'\n');
        }
    }
}
