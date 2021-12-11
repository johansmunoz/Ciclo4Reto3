package usa.sesion3.tiendafestejosv3.TablasBD;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.widget.TextView;

import androidx.annotation.NonNull;

import usa.sesion3.tiendafestejosv3.R;

public class MotorBdServicios extends SQLiteOpenHelper {
    private SQLiteDatabase sqLiteDatabase;

    /**
     * Constructor obligatorio para usar SQLiteOpenHelper en donde se indica nombre BD y versión
     * @param context
     */
    public MotorBdServicios(Context context) {
        super(context, "Tienda_festejos", null, 1);//tener en cuenta cambio de nombre de la BD
        sqLiteDatabase = this.getWritableDatabase();
    }

    /**
     * Funcion para crear la tabla con sus columnas y tipo de dato que almacenaran
     * @param db
     */
    @Override
    public void onCreate(@NonNull SQLiteDatabase db) {
        db.execSQL("CREATE TABLE servicios(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME VARCHAR," +
                "IMAGE BLOB)");//para almacenar imagenes
    }

    /**
     * función obligatoria heredada del SQLiteOpenHelper para actualizar la tabla
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS servicios");
    }

    /**
     * función personalizada para poder insertar la imagen y demas datos que componen la tabla
     * @param name
     * @param image
     */
    public void insertServicios(String name, byte[] image){
        String sql = "INSERT INTO servicios VALUES(null, ?, ?)";
        SQLiteStatement statement = sqLiteDatabase.compileStatement(sql);

        statement.clearBindings();

        statement.bindString(1, name);
        statement.bindBlob(2, image);

        statement.executeInsert();
    }

    /**
     * funcion para obtener todos los servicios ofrecidos por la tienda festejos
     * @return
     */
    public Cursor getServicios(){
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM servicios", null);
        return cursor;
    }

    /**
     * funcion para obtener determinado servicio de acuerdo al id especificado
     * @param id
     * @return
     */
    public Cursor getServiciosById(String id){
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM servicios WHERE ID = "+id, null);
        return cursor;
    }

    /**
     * Función para eliminar el srvicio seleccionado
     * @param id
     */
    public void deleteservicio(String id){
        String[] args = new String[]{id};
        sqLiteDatabase.delete("servicios","ID=?",args);
    }

    /**
     * funcion para actualizar determinado servicio
     * @param id
     * @param name
     * @param image
     */
    public void updateServicio(String id, String name, byte[] image){
        String sql = "UPDATE servicios " +
                "SET NAME = ?," +
                "IMAGE = ?";
        SQLiteStatement statement = sqLiteDatabase.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, name);
        statement.bindBlob(2, image);

        statement.executeUpdateDelete();
    }

}
