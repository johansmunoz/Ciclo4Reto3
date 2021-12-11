/**package usa.sesion3.tiendafestejosv3.CarroCompras;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class MotorBdCarrito extends SQLiteOpenHelper {
    private SQLiteDatabase sqLiteDatabase;


    public MotorBdCarrito(Context context) {
        super(context, "Tienda_festejos", null, 1);//tener en cuenta cambio de nombre de la BD
        sqLiteDatabase = this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE carrito_compras(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "TITULO VARCHAR," +
                "DESCRIPCION VARCHAR," +
                "IMAGE BLOB)");//para almacenar imagenes

    }

    /**
     * función obligatoria heredada del SQLiteOpenHelper para actualizar la tabla
     * @param db
     * @param oldVersion
     * @param newVersion

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS servicios");

    }

    /**
     * unción personalizada para poder insertar la imagen y demas datos que componen la tabla
     * @param titulo
     * @param descripcion
     * @param image

    public void insertProductos(String titulo, String descripcion, byte[] image){
        String sql = "INSERT INTO servicios VALUES(null, ?, ?, ?)";
        SQLiteStatement statement = sqLiteDatabase.compileStatement(sql);

        statement.clearBindings();

        statement.bindString(1, titulo);
        statement.bindString(2, descripcion);
        statement.bindBlob(3, image);

        statement.executeInsert();
    }
    /**
     * funcion para obtener todos los servicios ofrecidos por la tienda festejos
     * @return

    public Cursor getlistaProductos(){
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM carrito_compras", null);
        return cursor;
    }
    /**
     * funcion para actualizar determinado servicio
     * @param id
     * @param titulo
     * @param descripcion
     * @param image

    public void updateCarrito(String id, String titulo, String descripcion, byte[] image){
        String sql = "UPDATE carrito_compras " +
                "SET TITULO = ?," +
                "DESCRIPCION = ?," +
                "IMAGE = ?";
        SQLiteStatement statement = sqLiteDatabase.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, titulo);
        statement.bindString(2, descripcion);
        statement.bindBlob(3, image);

        statement.executeUpdateDelete();
    }

}*/
