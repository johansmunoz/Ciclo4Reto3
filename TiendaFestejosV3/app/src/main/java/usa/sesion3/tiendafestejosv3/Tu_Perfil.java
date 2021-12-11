package usa.sesion3.tiendafestejosv3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import usa.sesion3.tiendafestejosv3.Vista.AdmServicios;

public class Tu_Perfil extends AppCompatActivity {

    EditText usuario, password;
    Button iniciarSesion;

    Intent datosPasarPantalla;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tu_perfil);

        usuario = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.password);

        iniciarSesion = (Button) findViewById(R.id.botoniniciosesion);
        iniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                datosPasarPantalla = new Intent(getApplicationContext(), AdmServicios.class);
                datosPasarPantalla.putExtra("usuario", usuario.getText().toString());
                datosPasarPantalla.putExtra("clave", Integer.parseInt(password.getText().toString()));

                startActivity(datosPasarPantalla);

            }
        });
    }
}
