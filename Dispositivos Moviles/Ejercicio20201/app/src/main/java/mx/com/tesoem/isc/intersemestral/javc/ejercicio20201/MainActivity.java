package mx.com.tesoem.isc.intersemestral.javc.ejercicio20201;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText vNombre, vEdad, vTelefono, vCorreo;
    TextView eNombre,eEdad,eTelefono,eCorreo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vNombre = findViewById(R.id.txtNombre);
        vEdad = findViewById(R.id.txtEdad);
        vTelefono = findViewById(R.id.txtTelefono);
        vCorreo = findViewById(R.id.txtCorreo);

        eNombre = findViewById(R.id.lblNombre);
        eEdad = findViewById(R.id.lblEdad);
        eTelefono = findViewById(R.id.lblTelefono);
        eCorreo = findViewById(R.id.lblCorreo);

    }

    public void MProcesa(View v){
        int edad;
        eNombre.setText(vNombre.getText());
        edad = Integer.parseInt(vEdad.getText().toString());
        eEdad.setText(String.valueOf(edad));
        eTelefono.setText(vTelefono.getText());
        eCorreo.setText(vCorreo.getText());
    }
}