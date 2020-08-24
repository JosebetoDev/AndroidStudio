package mx.com.tesoem.isc.intersemestral.basedatossqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import mx.com.tesoem.isc.intersemestral.basedatossqlite.BaseDatos.DatosConexion;
import mx.com.tesoem.isc.intersemestral.basedatossqlite.BaseDatos.DatosHelper;
import mx.com.tesoem.isc.intersemestral.basedatossqlite.DTO.DatosParcerable;

import static mx.com.tesoem.isc.intersemestral.basedatossqlite.BaseDatos.DatosHelper.*;


public class DetallesActivity extends AppCompatActivity {

    EditText id,nombre,edad,sexo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);
        id = findViewById(R.id.txtID);
        nombre = findViewById(R.id.txtNombre);
        edad = findViewById(R.id.txtEdad);
        sexo = findViewById(R.id.txtSexo);

        DatosParcerable datosParcerable = getIntent().getParcelableExtra("datosParcerable");
        id.setText(String.valueOf(datosParcerable.getId()));
        nombre.setText(datosParcerable.getNombre());
        edad.setText(datosParcerable.getEdad());
        sexo.setText(datosParcerable.getSexo());

        getSupportActionBar().setTitle(datosParcerable.getNombre());
    }
    public void Actualizar(View v){
        ContentValues contentValues = new ContentValues();
        DatosConexion conexion = new DatosConexion(this);

        //contentValues.put(tabladatos.COLUMNA_ID,id.getText().toString());
        contentValues.put(tabladatos.COLUMNA_NOMBRE,nombre.getText().toString());
        contentValues.put(tabladatos.COLUMNA_EDAD,edad.getText().toString());
        contentValues.put(tabladatos.COLUMNA_SEXO,sexo.getText().toString());

        String[] condicion = new String[]{id.getText().toString()};

        conexion.Open();
        if(conexion.actualizar(contentValues,condicion)){
            Toast.makeText(this,"Actualizacion realizada",Toast.LENGTH_LONG).show();
            setResult(RESULT_OK);
            finish();
        }else{
            Toast.makeText(this,"",Toast.LENGTH_LONG).show();
        }
        conexion.Close();
    }
    public void Eliminar(View v){
        DatosConexion datosConexion = new DatosConexion(this);
        String[] condicion = new String[]{id.getText().toString()};
        datosConexion.Open();
        if(datosConexion.eliminar(condicion)){
            Toast.makeText(this,"Se elimino",Toast.LENGTH_LONG).show();
            setResult(RESULT_OK);
            finish();
        }else{
            Toast.makeText(this,"Error al eliminar",Toast.LENGTH_LONG).show();
        }
        datosConexion.Close();
    }
}