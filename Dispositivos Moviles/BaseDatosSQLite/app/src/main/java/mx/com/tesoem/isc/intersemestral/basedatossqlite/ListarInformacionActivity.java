package mx.com.tesoem.isc.intersemestral.basedatossqlite;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import mx.com.tesoem.isc.intersemestral.basedatossqlite.BaseDatos.DatosConexion;
import mx.com.tesoem.isc.intersemestral.basedatossqlite.DTO.DatosDTO;
import mx.com.tesoem.isc.intersemestral.basedatossqlite.DTO.DatosParcerable;

public class ListarInformacionActivity extends AppCompatActivity {

    GridView gvDatos;
    AdaptadorBase adaptadorBase;
    private final int detalles=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_informacion);
        gvDatos = findViewById(R.id.gvDatos);
        cargarDatos();
        gvDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DatosDTO datos = (DatosDTO)adaptadorBase.getItem(position);
                DatosParcerable datosParcerable = new DatosParcerable(datos.getId(),datos.getNombre(),datos.getEdad(),datos.getSexo());
                Intent intent = new Intent(ListarInformacionActivity.this,DetallesActivity.class);
                intent.putExtra("datosParcerable",datosParcerable);
                startActivityForResult(intent,detalles);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        cargarDatos();
    }

    private void cargarDatos(){
        DatosConexion datosConexion = new DatosConexion(this);
        List<DatosDTO> listaDatosDTO = new ArrayList<>();

        datosConexion.Open();
        if(datosConexion.ListarTodos()){
            listaDatosDTO = datosConexion.getListadatos();
            adaptadorBase = new AdaptadorBase(listaDatosDTO,this);
            gvDatos.setAdapter(adaptadorBase);
        }
        datosConexion.Close();
    }
}