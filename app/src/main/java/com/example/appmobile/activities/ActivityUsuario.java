package com.example.appmobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appmobile.R;
import com.example.appmobile.activities.dbHelper.ConexaoSQLite;

import DAO.CadastroDAO;
import DAO.UserDAO;
import controller.UsuarioController;
import modelo.Usuario;

public class ActivityUsuario extends AppCompatActivity {

    private ConexaoSQLite helper;
    private EditText edt_id;
    private EditText nomeUsuario;
    private EditText foneUsuario;
    private EditText setorUsuario;
    private EditText senhaUsuario;

    private Button btnCadastrarUsuario;
    private Button btnListarUsuario;

    private Usuario usuario;
    private UserDAO dao;
    TextView idUser;
    String nome, senha, setor, tel;
    int id =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        idUser = (TextView) findViewById(R.id.id_user);
        edt_id = (EditText) findViewById(R.id.edt_id);
        nomeUsuario = (EditText) findViewById(R.id.nomeUsuario);
        foneUsuario = (EditText) findViewById(R.id.foneUsuario);
        setorUsuario = (EditText) findViewById(R.id.setorUsuario);
        senhaUsuario = (EditText) findViewById(R.id.senha_Usuario);

        btnCadastrarUsuario = (Button) findViewById(R.id.btnCadastrarUsuario);
        btnListarUsuario = (Button) findViewById(R.id.btnListarUsuario);

        helper = new ConexaoSQLite(this);



        this.btnListarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityUsuario.this, ActivityListarUsuario.class);
                startActivity(intent);
            }


        });
    }
    public void salvarUsuario(View view) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nome", nomeUsuario.getText().toString());
        values.put("telefone", foneUsuario.getText().toString());
        values.put("setor", setorUsuario.getText().toString());
        values.put("senha", senhaUsuario.getText().toString());

        long resultado = db.insert("usuario", null, values);

        if (resultado != -1) {
            Toast.makeText(ActivityUsuario.this, "Salvo", Toast.LENGTH_SHORT).show();
            nomeUsuario.setText("");
            foneUsuario.setText("");
            setorUsuario.setText("");
            senhaUsuario.setText("");
        } else {
            Toast.makeText(ActivityUsuario.this, "Usuário não Cadastrado",
                    Toast.LENGTH_LONG).show();
        }
    }

    public void EncontrarUser(View view) {

        String nome = edt_id.getText().toString();


        if(!edt_id.getText().toString().trim().isEmpty()){

            String selectQuery = "SELECT id,nome, telefone, setor, senha FROM usuario WHERE nome = ?";
            SQLiteDatabase db = helper.getReadableDatabase();

            Cursor resultado = db.rawQuery(selectQuery,new String[]{nome} );

            if(resultado.moveToFirst()){
                id = resultado.getInt(0);
                nome = resultado.getString(1);
                tel = resultado.getString(2);
                setor = resultado.getString(3);
                senha = resultado.getString(4);

            }else Toast.makeText(ActivityUsuario.this, "Nenhum usuário encontrado", Toast.LENGTH_SHORT)
                    .show();

            idUser.setText("ID USER "+id);

        }else {
            idUser.setText("CADASTRAR USUÁRIO");
            Toast.makeText(ActivityUsuario.this, "Campo pesquisar vazio!", Toast.LENGTH_SHORT).show();}
    }

    public void deleteCourse(View view) {
        
        SQLiteDatabase db = helper.getWritableDatabase();

        db.delete("usuario", "id="+id, null);
        Toast.makeText(ActivityUsuario.this, "Usuário Excluído", Toast.LENGTH_SHORT).show();
        idUser.setText("CADASTRAR USUÁRIO");
        id=0;
    }


    public void updateCourse(View view) {



        SQLiteDatabase db = helper.getReadableDatabase();
        ContentValues values = new ContentValues();

        if(id!=0){

            if(!nomeUsuario.getText().toString().trim().isEmpty()){

                nome = nomeUsuario.getText().toString();

            }
            if(!senhaUsuario.getText().toString().trim().isEmpty()){

                senha = nomeUsuario.getText().toString();

            }
            if(!foneUsuario.getText().toString().trim().isEmpty()){

                tel = nomeUsuario.getText().toString();

            }
            if(!setorUsuario.getText().toString().trim().isEmpty()){

                setor = nomeUsuario.getText().toString();

            }


            values.put("nome", nome);
            values.put("telefone", tel);
            values.put("setor", setor);
            values.put("senha", senha);


            db.update("usuario", values, "id=?", new String[]{Integer.toString(id)});
            Toast.makeText(ActivityUsuario.this, "Atualizado", Toast.LENGTH_SHORT).show();
            idUser.setText("CADASTRAR USUÁRIO");
            db.close();

        }else Toast.makeText(ActivityUsuario.this,
                "Nenhum usuário selecionado", Toast.LENGTH_SHORT).show();


    }


    @Override
    protected  void onDestroy(){
                    helper.close();
                    super.onDestroy();
                }
            }







