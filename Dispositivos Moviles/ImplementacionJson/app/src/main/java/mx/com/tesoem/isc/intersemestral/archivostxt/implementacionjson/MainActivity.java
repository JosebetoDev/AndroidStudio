package mx.com.tesoem.isc.intersemestral.archivostxt.implementacionjson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    EditText txtNombre,txtEdad,txtSexo,txtJson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre = findViewById(R.id.txtNombre);
        txtEdad = findViewById(R.id.txtEdad);
        txtSexo = findViewById(R.id.txtSexo);
        txtJson = findViewById(R.id.txtJson);
    }
    public void CJsonn(View v){
        Datos dato = new Datos();
        Gson gson = new Gson();

        dato.setNombre(txtNombre.getText().toString());
        dato.setEdad(txtEdad.getText().toString());
        dato.setSexo(txtSexo.getText().toString());

        txtJson.setText(gson.toJson(dato));
    }
    public void CClase(View v){
        Gson gson = new Gson();
        Datos dato = gson.fromJson(txtJson.getText().toString(),Datos.class);
        txtNombre.setText(dato.getNombre());
        txtEdad.setText(dato.getEdad());
        txtSexo.setText(dato.getSexo());
    }
}