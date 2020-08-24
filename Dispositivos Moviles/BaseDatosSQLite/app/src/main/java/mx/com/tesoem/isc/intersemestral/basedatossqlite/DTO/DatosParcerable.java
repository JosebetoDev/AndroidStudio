package mx.com.tesoem.isc.intersemestral.basedatossqlite.DTO;

import android.os.Parcel;
import android.os.Parcelable;

public class DatosParcerable implements Parcelable{
    int id;
    String nombre,edad,sexo;

    public DatosParcerable(int id, String nombre, String edad, String sexo) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    protected DatosParcerable(Parcel in) {
        id = in.readInt();
        nombre = in.readString();
        edad = in.readString();
        sexo = in.readString();
    }

    public static final Creator<DatosParcerable> CREATOR = new Creator<DatosParcerable>() {
        @Override
        public DatosParcerable createFromParcel(Parcel in) {
            return new DatosParcerable(in);
        }

        @Override
        public DatosParcerable[] newArray(int size) {
            return new DatosParcerable[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nombre);
        dest.writeString(edad);
        dest.writeString(sexo);
    }
}
