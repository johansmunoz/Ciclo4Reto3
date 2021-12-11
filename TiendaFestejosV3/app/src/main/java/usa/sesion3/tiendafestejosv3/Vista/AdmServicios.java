package usa.sesion3.tiendafestejosv3.Vista;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.android.material.snackbar.Snackbar;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import usa.sesion3.tiendafestejosv3.R;
import usa.sesion3.tiendafestejosv3.TablasBD.MotorBdServicios;

public class AdmServicios extends AppCompatActivity {

    TextView campo_usuario;
    String usuario;

    private Button btnInsertar, btnConsultar, btnEliminar, btnChoose, btnListaPersonajes;
    private EditText edtName, edtId;
    private ImageView imgSelected;
    private MotorBdServicios motorBdServicios;
    private CasoUsoServicio casoUsoServicio;

    private final static String CHANNEL_ID = "NOTICACION";
    private final static int  NOTIFICATION_ID = 0;
    private final static int REQUEST_CODE_GALLERY = 999;

    private LinearLayout linearLayout;

    /**
     * Funcion que esta convirtiendo la imagen de bitmap a imagen  luego a byte. También comprime
     * la imagen para tener
     * @param imageView
     * @return
     */
    public byte[] imageViewToByte(ImageView imageView){
        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] byteArray =stream.toByteArray();
        return byteArray;
    }

    public void limpiarCampos(){
        edtName.setText("");
        imgSelected.setImageResource(R.mipmap.ic_launcher);
    }

    public void showById(Cursor cursor){
        if(cursor.getCount() == 0){
            Toast.makeText(getApplicationContext(),"Servicio no encontrado",Toast.LENGTH_SHORT).show();
        }else{
            StringBuffer buffer = new StringBuffer();
            while (cursor.moveToNext()){
                edtName.setText(cursor.getString(1));
                byte[] image = cursor.getBlob(2);
                Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0,image.length);
                imgSelected.setImageBitmap(bitmap);
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adm_servicios);

        btnInsertar = (Button) findViewById(R.id.btnInsertar);
        btnConsultar = (Button) findViewById(R.id.btnConsultar);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);
        btnChoose = (Button) findViewById(R.id.btnChoose);
        btnListaPersonajes = (Button) findViewById(R.id.btnListaServicios);

        edtName = (EditText) findViewById(R.id.edtName);
        edtId = (EditText) findViewById(R.id.edtId);

        imgSelected = (ImageView) findViewById(R.id.imgSelected);

        linearLayout = (LinearLayout) findViewById(R.id.Mainlayout);



        motorBdServicios = new MotorBdServicios(getApplicationContext());
        casoUsoServicio = new CasoUsoServicio();

        /**
         * llamado desde AdmServicios a ListaServicios para ver todos lso servicios registrados
         * @param v
         */
        btnListaPersonajes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdmServicios.this, ListaServicios.class);
                startActivity(intent);//-----------------------------------------------------------//
            }
        });
        /**
         * boton para seleccionar imagen desde galería del servicio a incluir
         */
        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(
                        AdmServicios.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY
                );
            }
        });
        /**
         * Funcion para insertar nuevos servicios cuando se hace click en el boton agregar
         */
        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), edtName.getText().toString().trim(), Toast.LENGTH_SHORT).show();
                motorBdServicios.insertServicios(
                        edtName.getText().toString().trim(),
                        imageViewToByte(imgSelected)
                );
                limpiarCampos();
                Toast.makeText(getApplicationContext(), "Servicio Creado", Toast.LENGTH_SHORT).show();

            }
        });
        /**
         * botón para consultar un servicio especificando el id
         */
        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {


                    String id = edtId.getText().toString().trim();
                    if(id.equals("")){
                        Cursor cursor = motorBdServicios.getServicios();
                        String result = casoUsoServicio.cursorToString(cursor);
                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                    }else{
                        Cursor cursor = motorBdServicios.getServiciosById(id);
                        showById(cursor);
                        Toast.makeText(getApplicationContext(),"consulta por ",Toast.LENGTH_LONG).show();
                    }}catch (Exception e){
                    Toast.makeText(getApplicationContext(), e.toString(),Toast.LENGTH_LONG).show();
                }

            }
        });
        /**
         * funcion para eliminar servicio seleccionado
         */
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = edtId.getText().toString().trim();
                if(id.equals("")){
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }else{
                    motorBdServicios.deleteservicio(id);
                    limpiarCampos();
                }
            }
        });

        campo_usuario = (TextView) findViewById(R.id.campo_usuario);

        Bundle datosEntradaPant = getIntent().getExtras();
        usuario = datosEntradaPant.getString("usuario");

        campo_usuario.setText(usuario);

    }

    /**
     * condicional cuando se clickea por primera vez la opcion chosse para cargar una foto de la galeria
     * y activar la solictud de permiso de acceso a la aplicación a la galeria
     * @param requestCode
     * @param permissions
     * @param grantResults
     */

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == REQUEST_CODE_GALLERY){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_GALLERY);

            }else{
                Toast.makeText(getApplicationContext(), "Sin Permisos", Toast.LENGTH_SHORT).show();
            }
            return;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imgSelected.setImageBitmap(bitmap);
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void createDialog(String titulo, String contenido){
        AlertDialog.Builder builder = new AlertDialog.Builder(AdmServicios.this);
        builder.setTitle(titulo);
        builder.setMessage(contenido)
                .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Si Presionado", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "No Presionado", Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }

    public void createNotificationChanel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "Notification";
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
    public void createNotification(String titulo, String contenido){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_launcher_foreground);
        //builder.setLargeIcon(R.drawable.ic_baseline_accessibility_new_24);
        builder.setContentTitle(titulo);
        builder.setContentText(contenido);
        builder.setDefaults(NotificationCompat.PRIORITY_DEFAULT);
        builder.setColor(Color.RED);
        builder.setLights(Color.MAGENTA, 500, 500);
        builder.setVibrate(new long[]{1000,1000,1000,1000,1000,1000,1000,1000,1000});
        builder.setDefaults(Notification.DEFAULT_SOUND);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
        notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());
    }
    private void createMensaje(){
        Snackbar snackbar = Snackbar.make(linearLayout,"Hola Mensaje",Snackbar.LENGTH_LONG);
        snackbar.setAction("LLamarToast", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Toast desde mensaje", Toast.LENGTH_SHORT).show();
            }
        });
        snackbar.show();
    }
}
