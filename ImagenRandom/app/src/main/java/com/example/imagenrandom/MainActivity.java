package com.example.imagenrandom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {
    ImageView imagen;
    TextView letrero;
    Vibrator vibrator;
    Button btn;
    int sr,temporal;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //asociando atributos, id, layout
        imagen = (ImageView) findViewById(R.id.imageView);
        letrero = (TextView) findViewById(R.id.texto);
        btn = (Button) findViewById(R.id.button);

        mostrarRand();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temporal = sr;
                mostrarRand();
            }
        });
    }

    //mostrar valores de aleatorio
    public void mostrarRand() {
        //randoms();
        stopPlying();
        sr = ThreadLocalRandom.current().nextInt(0,7);
        while(temporal == sr){
            sr = ThreadLocalRandom.current().nextInt(0,7);
        }
        AudioMP();
        Vibrar1();
        imagen.setImageResource(randArray[sr].getImagen());
        letrero.setText(randArray[sr].getAleatorio());
    }

    aleatorio i1 = new aleatorio(R.drawable.uno, "img 1",R.raw.uno);
    aleatorio i2 = new aleatorio(R.drawable.dos, "img 2",R.raw.dos);
    aleatorio i3 = new aleatorio(R.drawable.tres, "img 3",R.raw.tres);
    aleatorio i4 = new aleatorio(R.drawable.cuatro, "img 4",R.raw.cuatro);
    aleatorio i5 = new aleatorio(R.drawable.cinco, "img 5",R.raw.cinco);
    aleatorio i6 = new aleatorio(R.drawable.seis, "img 6",R.raw.seis);
    aleatorio i7 = new aleatorio(R.drawable.siete, "img 7",R.raw.siete);

    //llenando array
    aleatorio[] randArray = new aleatorio[]{
            i1, i2, i3, i4, i5, i6, i7
    };
    //metodo para permutar aleatoriamente una lista, utilizando como fuente el vector randArray
    public void randoms(){
        //  Collections.shuffle(Arrays.asList(randArray));
    }

    public void AudioMP(){
        stopPlying();
        mp = MediaPlayer.create(this,randArray[sr].getSonido());
        mp.start();
        //sound_long
    }
    public void Vibrar1(){
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long tiempo = 500;
        vibrator.vibrate(tiempo);
    }
    private void stopPlying(){
        if(mp != null){
            mp.stop();
            mp.release();
            mp = null;
        }
    }
}
