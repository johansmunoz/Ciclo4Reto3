/**package usa.sesion3.tiendafestejosv3.CarroCompras;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;

import usa.sesion3.tiendafestejosv3.R;

public class AdmCarrito extends AppCompatActivity {
    private Button boton_productos1;
    private TextView titulo, descripcion_productos1;
    private ImageView imagen_productos1;

    private final static String CHANNEL_ID = "NOTIFICACION";
    private final static int NOTIFICACION_ID =0;
    private final static int REQUEST_CODE_GALLERY = 999;

    private LinearLayout linearLayout;

    /**
     * Funcion que esta convirtiendo la imagen de bitmap a imagen  luego a byte. También comprime
     * la imagen para tener
     * @param imageView
     * @return

    public byte[] imageViewToByte(ImageView imageView){
        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] byteArray =stream.toByteArray();
        return byteArray;
    }

    public void showById(Cursor cursor){
        if(cursor.getCount() == 0){
            Toast.makeText(getApplicationContext(),"Servicio no encontrado",Toast.LENGTH_SHORT).show();
        }else{
            StringBuffer buffer = new StringBuffer();
            while (cursor.moveToNext()){
                titulo.setText(cursor.getString(1));
                descripcion_productos1.setText(cursor.getString(2));
                byte[] image = cursor.getBlob(3);
                Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0,image.length);
                imagen_productos1.setImageBitmap(bitmap);
            }
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment__productos);

        boton_productos1 = (Button) findViewById(R.id.boton_productos1);

    }
}*/
