package mx.com.tesoem.isc.intersemestral.comunicacionactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ParametroActivity extends AppCompatActivity {

    TextView lblSaludo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametro);
        lblSaludo = findViewById(R.id.lblsaludo);
        Bundle parametro = getIntent().getExtras();
        lblSaludo.setText("Bienvenido"+ parametro.getString("Nombre"));
    }
}