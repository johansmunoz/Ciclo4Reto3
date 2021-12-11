package usa.sesion3.tiendafestejosv3;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Sesion_Iniciada extends AppCompatActivity{

    TextView texto1, texto2;
    String usuario;
    int clave;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sesion_iniciada);

    texto1 = (TextView) findViewById(R.id.texto1);
    texto2=(TextView) findViewById(R.id.texto2);

    Bundle datosEntradaPant = getIntent().getExtras();
    usuario = datosEntradaPant.getString("usuario");
    clave = datosEntradaPant.getInt("clave");

    texto1.setText(usuario);
    texto2.setText(String.valueOf(clave));

    }
}
