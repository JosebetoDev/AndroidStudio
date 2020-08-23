package mx.com.tesoem.isc.intersemestral.gvbaseadaptador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetallesActivity extends AppCompatActivity {
    TextView lblnombre,lblEdad,lblSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);
        lblnombre = findViewById(R.id.elblNombre);
        lblEdad = findViewById(R.id.lblEdad);
        lblSexo = findViewById(R.id.lblSexo);

        String nombre = getIntent().getExtras().get("Nombre").toString();
        DatosParcelable datosParcelable = getIntent().getParcelableExtra("DatosParcerable");
        lblnombre.setText(datosParcelable.nombre);
        lblEdad.setText(datosParcelable.edad);
        lblSexo.setText(datosParcelable.sexo);
        getSupportActionBar().setTitle(nombre);
    }
}