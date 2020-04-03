package com.example.imagenrandom;

import android.media.SoundPool;

public class aleatorio {
    int Imagen,Sonido;

    String aleatorio;
    public aleatorio(int Imagen,String aleatorio,int sound){
        this.Imagen = Imagen;
        this.aleatorio = aleatorio;
        this.Sonido = sound;
    }
    public int getSonido(){
        return Sonido;
    }

    public int getImagen() {
        return Imagen;
    }

    public String getAleatorio() {
        return aleatorio;
    }
}