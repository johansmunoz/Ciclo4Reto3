package usa.sesion3.tiendafestejosv3.Controlador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import usa.sesion3.tiendafestejosv3.CarritoCompras;
import usa.sesion3.tiendafestejosv3.Configuracion;
import usa.sesion3.tiendafestejosv3.Vista.AdmServicios;
import usa.sesion3.tiendafestejosv3.Vista.Fragment_Favoritos;
import usa.sesion3.tiendafestejosv3.Vista.Fragment_Inicio;
import usa.sesion3.tiendafestejosv3.Vista.Fragment_Productos;
import usa.sesion3.tiendafestejosv3.Vista.Fragment_Servicios;
import usa.sesion3.tiendafestejosv3.Vista.Fragment_sucursales;
import usa.sesion3.tiendafestejosv3.R;
import usa.sesion3.tiendafestejosv3.Tu_Perfil;
import usa.sesion3.tiendafestejosv3.Vista.ListaServicios;

/**
 * Definicion de la clase principal desde la cual se iniciara toda la aplicacion
 * se usa el extends para heredar una clase padre
 */
public class MainActivity extends AppCompatActivity {
    /**
     * Definicón de variables/atributos principales usados en este caso para cambiar entre pantallas
     */
    Fragment subpantalla1, subpantalla2, subpantalla3,subpantalla4,subpantalla5;//Parte encargada de
    //definir las diferentes pantallas de los fragments
    FragmentTransaction intercambio;
    Button boton1, boton2;
    String TAG="Main Activity: Actividad 1";

    /**
     * Metodo llamado cuando la actividad es iniciada
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verToolBar();//Como se oculto la action var, se creo metodo para llamarlo en el main activity

        Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();
        Log.v(TAG, "onCreate");

        /**
         * Se declaran los siguientes atributos para poder relacionar los diferentes fragments
         * que haran parte de la aplicacion
         */
        subpantalla1 = new Fragment_Inicio();
        subpantalla2 = new Fragment_Productos();
        subpantalla3 = new Fragment_Servicios();
        subpantalla4 = new Fragment_sucursales();
        subpantalla5 = new Fragment_Favoritos();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedor_fragments, subpantalla1).commit();

        boton1 = (Button)findViewById(R.id.boton1);
        boton1.setOnClickListener(new View.OnClickListener() {
            /**
             * Metodo para acceder a los productos
             * @param view
             */
            @Override
            public void onClick(View view) {
                intercambio=getSupportFragmentManager().beginTransaction();
                intercambio.replace(R.id.contenedor_fragments, subpantalla2).commit();
            }
        });
        boton2=(Button) findViewById(R.id.boton2);
        boton2.setOnClickListener(new View.OnClickListener() {
            /**
             * metodo par acceder a los servicios
             * @param v
             */
            @Override
            public void onClick(View v) {
                /**intercambio=getSupportFragmentManager().beginTransaction();
                intercambio.replace(R.id.contenedor_fragments, subpantalla3).commit();*/

                Intent intent = new Intent(getApplicationContext(), ListaServicios.class);
                startActivity(intent);

            }
        });

        }

    /**
     * Ya que la toolbar fue ocultada se creo layaout y su respectiva funcion para poder crear y ver
     * la toolbar en la actividad principal.
     */
    private void verToolBar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    /**
     * Menu para acceder a los diferentes Fragments, y otras actividades como perfil, configuración, etc.
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuopciones, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Instrucción switch para relacionar cada opción del menú con un acceso a cada fragment o actividad
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        switch (id){
            case R.id.productos:
                Toast.makeText(this, "Aquí podrán verse todos los productos de la tienda",
                        Toast.LENGTH_SHORT).show();
                intercambio=getSupportFragmentManager().beginTransaction();
                intercambio.replace(R.id.contenedor_fragments, subpantalla2).commit();
                break;
            case R.id.servicios:
                Toast.makeText(this, "Aquí podrán verse todos los servicios de la tienda",
                        Toast.LENGTH_SHORT).show();
               Intent pantaservi2 = new Intent(getApplicationContext(), ListaServicios.class);
               startActivity(pantaservi2);
                break;
            case R.id.sucursales:
                Toast.makeText(this, "Aquí podrán verse todas las sucursales de la tienda",
                        Toast.LENGTH_SHORT).show();
                intercambio=getSupportFragmentManager().beginTransaction();
                intercambio.replace(R.id.contenedor_fragments, subpantalla4).commit();
                break;
            case R.id.configuracion:
                Toast.makeText(this, "Aquí podrán verse y cambiar las configuraciones de la " +
                                "aplicacion",
                        Toast.LENGTH_SHORT).show();
                Intent pantaConfig = new Intent(getApplicationContext(), Configuracion.class);
                startActivity(pantaConfig);
                intercambio=getSupportFragmentManager().beginTransaction();
                intercambio.replace(R.id.contenedor_fragments, subpantalla5).commit();
                break;

            case R.id.tuperfil:
                Toast.makeText(this, "Aqui podrá iniciar sesión y configurar perfil de usuario",
                        Toast.LENGTH_SHORT).show();
                Intent pantaPerfil = new Intent(getApplicationContext(), Tu_Perfil.class);
                startActivity(pantaPerfil);
                break;

            default:
                System.out.println("Error");

        }
        return super.onOptionsItemSelected(item);
    }
    //**************************************************************************

    /**
     * metodo que indica cuando una actividad inicia y esta activa
     */
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
        Log.v(TAG, "onStart");
    }

    /**
     * metodo que indica si la actividad esta activa
     */
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
        Log.v(TAG, "onResume");
        Log.v(TAG, "----->onResume<------");
    }
    //*********************ESTADO ACTIVO//**************************************

    /**
     * metodo para indicar si la actividad esta visible pero sin actividad
     */
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
        Log.v(TAG, "onPause");
    }
    //**********************ESTADO VISIBLE**************************

    /**
     * metodo para indicar que la actividad esta parada
     */
    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
        Log.v(TAG, "onStop");
    }
    /**
     * metodo para indicar que la actividad estaba parada y volvera a iniciar
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
        Log.v(TAG, "onRestart");
    }
    //***********************ESTADO PARADA******************************

    /**
     * metodo para indicar que la actividad finalizo definitivamente
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
        Log.v(TAG, "onDestroy");
    }

    //*********************ESTADO TERMINADO****************************
}