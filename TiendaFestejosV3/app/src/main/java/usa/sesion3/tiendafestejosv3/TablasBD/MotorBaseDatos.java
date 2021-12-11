package usa.sesion3.tiendafestejosv3.TablasBD;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 * Clase para el motor de la base de datos, la clase padre que se lee en la extension
 * nos permitirá acceder a los diferentes metodos necesarios para crear una base de datos
 */
public class MotorBaseDatos extends SQLiteOpenHelper {
    /**
     * Constructor
     * @param context
     * @param name
     * @param factory
     * @param version
     */
    public MotorBaseDatos(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * la misma clase padre pide sobreescribir con el método onCreate, donde se ejecutará un comando
     * SQLite para crear las tablas de la base de datos.
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE carrito (id,titulo TEXT, descripcion TEXT)");
        // poner datos en los registros de la tabla
        db.execSQL("INSERT INTO carrito VALUES(1,'Whats app', 'Whats App')");
        db.execSQL("INSERT INTO carrito VALUES(2,'Batman', 'Batman')");
        db.execSQL("INSERT INTO carrito VALUES(3,'Escudo Capitan America', 'Escudo Capitán América')");

    }

    /**
     * Este método se ejecutara cada vez que se cambia la base de datos y cuando se migran dichos datos
     * de una versión a otra.
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //db.execSQL("DROP TABLE carrito");
        //onCreate(db);

    }
}
