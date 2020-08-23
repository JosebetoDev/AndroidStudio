package mx.com.tesoem.isc.intersemestral.basedatossqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void LanzarRegistro(View v){
        Intent intent = new Intent(this,RegistraActivity.class);
        startActivity(intent);
    }
}