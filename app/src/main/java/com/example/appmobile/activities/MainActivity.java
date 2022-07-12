package com.example.appmobile.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.appmobile.R;
import com.example.appmobile.activities.dbHelper.ConexaoSQLite;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

import modelo.Cadastro;


public class MainActivity extends Activity {

       static final int REQUEST_IMAGE_CAPTURE = 1;
    private void dispatchTakePictureIntent(){
        Intent TakePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (TakePictureIntent.resolveActivity(getPackageManager())!= null){
            startActivityForResult(TakePictureIntent, REQUEST_IMAGE_CAPTURE);

        }

    }

    private FusedLocationProviderClient fusedLocationProviderCliente;
    private Button btnCadastrarServicos;
    private Button btnListarServicos;
    private Button btnCadastrarUsuario;


    @Override
    protected void onActivityResult(int requestCode,int resultcode, Intent data){
        super.onActivityResult(requestCode, resultcode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultcode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBipmap = (Bitmap) extras.get("data");
        }
    }

    ConexaoSQLite conexaoSQLite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fusedLocationProviderCliente = LocationServices.getFusedLocationProviderClient(this);


        conexaoSQLite = new ConexaoSQLite(this);

        this.btnCadastrarServicos = (Button) findViewById(R.id.btnCadastrarServicos);
        this.btnListarServicos = (Button) findViewById(R.id.btnListarServicos);
        this.btnCadastrarUsuario = (Button) findViewById(R.id.btnCadastrarUsuario);

        this.btnCadastrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, ActivityUsuario.class);
                startActivity(intent);
            }
        });
        this.btnCadastrarServicos.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityServico.class);
                startActivity(intent);
            }

        });
        this.btnListarServicos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityListarServicos.class);
                startActivity(intent);

            }

        });


    }

    public void mapa(View view){
        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
        startActivity(intent);
    }
}











