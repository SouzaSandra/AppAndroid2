package com.example.appmobile.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Picture;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.appmobile.R;
import com.example.appmobile.activities.dbHelper.ConexaoSQLite;

import modelo.Login;

public class ActivityLogin extends AppCompatActivity {
      ImageView IvFoto;

    private EditText user_Nome;
    private EditText user_Senha;
    private Button btnAcessar;

    private Login login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
        }
        IvFoto = (ImageView)findViewById(R.id.IvFoto);
        findViewById(R.id.btnFoto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tirarFoto();
            }
        });


        ConexaoSQLite conexaoSQLite = new ConexaoSQLite(this);

        user_Nome = (EditText) findViewById(R.id.user_Nome);
        user_Senha = (EditText) findViewById(R.id.user_Senha);
        btnAcessar = (Button) findViewById(R.id.btnAcessar);

        this.btnAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ActivityLogin.this, ActivityCadastro.class);
                startActivity(intent);
            }
        });
        }
     private Login getLoginUser() {
        this.login = new Login();

        if (this.user_Nome.getText().toString().isEmpty() == false) ;
        {
            this.login.setUsuarios(this.user_Nome.getText().toString());
        }
        if (this.user_Senha.getText().toString().isEmpty() == false);{
            Long senha_Acesso = Long.parseLong(this.user_Senha.getText().toString());

            this.login.setSenha_Acesso(senha_Acesso);
        }
        return login;
    }
    public void tirarFoto(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 1);

     }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imagem = (Bitmap) extras.get("data");
            IvFoto.setImageBitmap(imagem);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}