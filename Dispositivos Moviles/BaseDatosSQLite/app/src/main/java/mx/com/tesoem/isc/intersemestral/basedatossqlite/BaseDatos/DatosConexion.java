package mx.com.tesoem.isc.intersemestral.basedatossqlite.BaseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import mx.com.tesoem.isc.intersemestral.basedatossqlite.DTO.DatosDTO;


public class DatosConexion {
    private SQLiteDatabase basedatos;
    private DatosHelper datosHelper;
    private Context context;

    List<DatosDTO> listadatos = new ArrayList<>();

    public DatosConexion(Context context) {
        this.context = context;
    }

    public DatosConexion Open(){
        datosHelper = new DatosHelper(context);
        basedatos = datosHelper.getWritableDatabase();
        return this;
    }
    public void Close(){
        datosHelper.close();
    }
    public boolean Insert(ContentValues contentValues){
        boolean estado = true;
        int restadoConsulta = (int) basedatos.insert(DatosHelper.tabladatos.TABLA,null,contentValues);
        if(restadoConsulta < 0){
            estado = false;
        }
        return estado;
    }
    public boolean ListarTodos(){
        boolean estado = true;
        DatosDTO datos;
        Cursor cursor = basedatos.rawQuery("select * from "+ DatosHelper.tabladatos.TABLA,null);
        if(cursor.getCount() >0){
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                datos = new DatosDTO();
                datos.setId(cursor.getInt(0));
                datos.setNombre(cursor.getString(1));
                datos.setSexo(cursor.getString(2));
                datos.setSexo(cursor.getString(3));
                listadatos.add(datos);
                cursor.moveToNext();
            }
        }else{
            estado = false;
        }
        return estado;
    }
    public List<DatosDTO> getListadatos(){
        return listadatos;
    }
    public boolean actualizar(ContentValues contentValues,String[] condiciones){
        boolean estado = true;
        int resultado = basedatos.update(DatosHelper.tabladatos.TABLA,contentValues,
                DatosHelper.tabladatos.COLUMNA_ID + "=?",condiciones);
        if(!(resultado == 1)){
            estado =false;
        }
        return estado;
    }
    public boolean eliminar(String[] condiciones){
        boolean estado = true;
        int resultado = basedatos.delete(DatosHelper.tabladatos.TABLA, DatosHelper.tabladatos.COLUMNA_ID + "=?",condiciones);
        if(!(resultado == 1)) estado = false;
        return estado;
    }
}
