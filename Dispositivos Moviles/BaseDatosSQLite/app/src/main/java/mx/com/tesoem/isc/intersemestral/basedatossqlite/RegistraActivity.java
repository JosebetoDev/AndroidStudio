package mx.com.tesoem.isc.intersemestral.basedatossqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import mx.com.tesoem.isc.intersemestral.basedatossqlite.BaseDatos.DatosConexion;

public class RegistraActivity extends AppCompatActivity {

    EditText txtNombre,txtEdad,txtSexo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registra);
        txtNombre = findViewById(R.id.txtNombreElemento);
        txtEdad = findViewById(R.id.txtEdad);
        txtSexo = findViewById(R.id.txtSexo);
    }

    public void Registro(View v){
        ContentValues contentValues = new ContentValues();
        DatosConexion datosConexion = new DatosConexion(this);
        datosConexion.Open();
        contentValues.put("nombre",txtNombre.getText().toString());
        contentValues.put("edad",txtEdad.getText().toString());
        contentValues.put("sexo",txtSexo.getText().toString());

        if(datosConexion.Insert(contentValues)){
            Toast.makeText(this,"Se registro correctamente",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"No se pudo registrar...",Toast.LENGTH_LONG).show();
        }
        datosConexion.Close();
    }
}