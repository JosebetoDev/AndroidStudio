package mx.com.tesoem.isc.intersemestral.basedatossqlite.BaseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class DatosConexion {
    private SQLiteDatabase basedatos;
    private DatosHelper datosHelper;
    private Context context;

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
}
