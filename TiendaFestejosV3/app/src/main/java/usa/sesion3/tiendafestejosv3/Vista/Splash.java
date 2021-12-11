package usa.sesion3.tiendafestejosv3.Vista;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import usa.sesion3.tiendafestejosv3.Controlador.MainActivity;
import usa.sesion3.tiendafestejosv3.R;

public class Splash extends AppCompatActivity implements Runnable{

    ImageView ic_launcher;
    Thread h1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        ic_launcher = (ImageView) findViewById(R.id.ic_launcher);
        ic_launcher.setImageResource(R.drawable.ic_launcher);

        h1 = new Thread(this);
        h1.start();
    }

    @Override
    public void run() {
        try {
            //aqui valida conexion a internet
            //aqui valida conexcion con oracle cloud
            //aqui valida que haya cargue de mapa
            Thread.sleep(5000);
            Intent pasarPantalla = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(pasarPantalla);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
