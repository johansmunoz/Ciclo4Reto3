package usa.sesion3.tiendafestejosv3.Vista;

import android.app.ProgressDialog;
import android.content.AsyncQueryHandler;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import usa.sesion3.tiendafestejosv3.Controlador.MainActivity;
import usa.sesion3.tiendafestejosv3.R;

public class Splash extends AppCompatActivity implements Runnable{

    ImageView ic_launcher;
    Thread h1;
    Thread h2;
    TextView texto1;
    ProgressBar barraProgreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);



        texto1 = (TextView) findViewById(R.id.textView8);
        barraProgreso=(ProgressBar)findViewById(R.id.progressBar);

        Hilo1 h2= new Hilo1();
        h2.execute();


        //------------------------------------------------------------------------
        ic_launcher = (ImageView) findViewById(R.id.ic_launcher);
        ic_launcher.setImageResource(R.drawable.ic_launcher);

        h1 = new Thread(this);
        h1.start();
    }   //-------------------------------------------------------------------------

//--------------------------------------------------------------------------------------------------
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
    //--------------------------------------------------------------------------------------------------


    public class Hilo1 extends AsyncTask<String, Integer, String>{

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                for (int i=1;i<=100;i++) {
                    Thread.sleep(15);
                    publishProgress(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... i) {
            texto1.setText(i[0].toString());
            barraProgreso.incrementProgressBy(i[0]);


        }

        @Override
        protected void onPostExecute(String s) {

            super.onPostExecute(s);
        }
    }
}
