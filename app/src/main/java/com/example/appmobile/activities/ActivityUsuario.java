package com.example.appmobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appmobile.R;
import com.example.appmobile.activities.dbHelper.ConexaoSQLite;

import controller.UsuarioController;
import modelo.Usuario;

public class ActivityUsuario extends AppCompatActivity {

    private EditText edt_id;
    private EditText nomeUsuario;
    private EditText foneUsuario;
    private EditText setorUsuario;
    private EditText senhaUsuario;

    private Button btnCadastrarUsuario;
    private Button btnListarUsuario;

    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        ConexaoSQLite.getInstanciaConexao(this);

        edt_id = (EditText) findViewById(R.id.edt_id);
        nomeUsuario = (EditText) findViewById(R.id.nomeUsuario);
        foneUsuario = (EditText) findViewById(R.id.foneUsuario);
        setorUsuario = (EditText) findViewById(R.id.setorUsuario);
        senhaUsuario = (EditText) findViewById(R.id.senha_Usuario);
        btnCadastrarUsuario = (Button) findViewById(R.id.btnCadastrarUsuario);
        btnListarUsuario = (Button) findViewById(R.id.btnListarUsuario);

        this.btnListarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityUsuario.this, ActivityListarUsuario.class);
                startActivity(intent);
            }
        });

        this.btnCadastrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario usuarioCadastrar = getDadosUsuario();
                if (usuarioCadastrar != null) {
                    UsuarioController usuarioController = new UsuarioController(ConexaoSQLite.getInstanciaConexao(ActivityUsuario.this));
                    usuarioController.salvarUsuarioCtrl(usuarioCadastrar);

                    long edt_id = usuarioController.salvarUsuarioCtrl(usuarioCadastrar);
                    if (edt_id > 0) {
                    } else {
                        Toast.makeText(ActivityUsuario.this, "Usuário não Cadastrado", Toast.LENGTH_LONG).show();
                    }
                } else {


                    Toast.makeText(ActivityUsuario.this, "Informe todos os campos", Toast.LENGTH_LONG).show();
                }

                Intent intent = new Intent(ActivityUsuario.this, ActivityLogin.class);

                startActivity(intent);
            }


        });

    }

    private Usuario getDadosUsuario() {

        this.usuario = new Usuario();

        if (this.edt_id.getText().toString().isEmpty() == false) {
            Long id = Long.parseLong(this.edt_id.getText().toString());
            this.usuario.setId(id);
        }else {
            return null;
        }
        if (this.nomeUsuario.getText().toString().isEmpty() == false) {
            this.usuario.setNomeUser(this.nomeUsuario.getText().toString());
        }else {
            return null;
        }
        if (this.foneUsuario.getText().toString().isEmpty() == false) {
            Long fone = Long.parseLong(this.foneUsuario.getText().toString());
            this.usuario.setFone(fone);
        }else {
            return null;
        }

        if (this.setorUsuario.getText().toString().isEmpty() == false);{
         this.usuario.setSetor(this.setorUsuario.getText().toString());

        }

        if (this.senhaUsuario.getText().toString().isEmpty() == false);{
            Long senha = Long.parseLong(this.senhaUsuario.getText().toString());
            this.usuario.setSenha(senha);

        }
        return usuario;
    }

    }







