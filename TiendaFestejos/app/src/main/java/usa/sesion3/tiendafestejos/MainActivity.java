package usa.sesion3.tiendafestejos;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import usa.sesion3.tiendafestejos.databinding.ActivityMainBinding;

/**
 * Definicion de la clase principal desde la cual se iniciara toda la aplicación
 * se usa el extends para heredar la clase
 */
public class MainActivity extends AppCompatActivity {
    /**
     * Declaraciones
     */
    private AppBarConfiguration mAppBarConfiguration;//Permite acceder a configuraciones de la action bar
    /**
     * declaraciones
     */
    private ActivityMainBinding binding;//Relaciona el archivo xml

    /**
     *Metodo que es llamado cuando la actividad es inicializada
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            /**
             *
             * @param view
             */
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    /**
     *Metodo que sirve para especificar el menu de opciones de una actividad
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     *Metodo que sirve para cada vez que un item (en este caso del menu), es seleccionado
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        switch (id){
            case R.id.productos:
                Toast.makeText(this, "Aquí podrán verse todos los productos de la tienda",
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.servicios:
                Toast.makeText(this, "Aquí podrán verse todos los servicios de la tienda",
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.sucursales:
                Toast.makeText(this, "Aquí podrán verse todas las sucursales de la tienda",
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.action_settings:
                Toast.makeText(this, "Aquí podrán verse y cambiar las configuraciones de la " +
                                "aplicacion y el perfil de usuario",
                        Toast.LENGTH_LONG).show();
                Intent pantaConfig = new Intent(getApplicationContext(), Configuracion.class);
                startActivity(pantaConfig);
                break;
            default:
                System.out.println("Error");

        }
        return super.onOptionsItemSelected(item);
    }

    /**
     *Metodo que sirve cada vez que el usuario realiza una acción sobre el action bar
     * @return
     */
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}