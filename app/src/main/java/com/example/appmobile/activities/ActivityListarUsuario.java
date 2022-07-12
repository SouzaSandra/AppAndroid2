package com.example.appmobile.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.appmobile.R;
import com.example.appmobile.activities.dbHelper.ConexaoSQLite;
import com.example.appmobile.adapters.adapterListaServico;
import com.example.appmobile.adapters.adapterListarUsuario;

import java.util.ArrayList;
import java.util.List;

import DAO.UserDAO;
import controller.UsuarioController;
import modelo.Cadastro;
import modelo.Servico;
import modelo.Usuario;

public class ActivityListarUsuario extends AppCompatActivity {

    private ListView lsvUsuario;
    private List<Usuario> usuarioList;
    private List<Usuario> usuarioFiltro = new ArrayList<>();
    private UserDAO dao;
    private Button ListarUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_usuario);
        lsvUsuario = (ListView) findViewById(R.id.lsvUser);
//        dao = new UserDAO(this);
        lsvUsuario = new ListView(this);
        usuarioList = dao.ListaUserDAO();
        usuarioFiltro.addAll(usuarioList);

        ArrayAdapter<Usuario> adaptador = new ArrayAdapter<Usuario>(this, android.R.layout.simple_list_item_1, usuarioList);
        lsvUsuario.setAdapter(adaptador);
    }
//    this.btnListarUsuario.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//
//            Intent intent = new Intent(ActivityListarUsuario.this, ListarUsuario.class);
//            startActivity(intent);
//        }
//
//
//    UsuarioController usuarioController = new UsuarioController((ConexaoSQLite.getInstanciaConexao(ActivityListarUsuario.this)));
//        usuarioController.getListaUsuarioCtrl();
//
//    {
//
//
//        this.usuarioList = new ArrayList(); //busca informações do banco para a lista
//        this.adapterListarUsuario = new adapterListarUsuario(ActivityListarUsuario.this, usuarioList);
//        this.lsvUsuario.setAdapter((this.adapterListarUsuario));

//        this.lsvUsuario.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
//
//                Usuario usuarioSelecionado = (Usuario) adapterListarUsuario.getItem(posicao);
//                AlertDialog.Builder janelaEscolha = new AlertDialog.Builder(ActivityListarUsuario.this);
//
//                janelaEscolha.setTitle("Opções");
//                janelaEscolha.setMessage("Selecione a opção desejada!");
//
//                janelaEscolha.setNeutralButton("Cancelar", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int id) {
//                        dialogInterface.cancel();
//                    }
//                });
//                janelaEscolha.setNegativeButton("Excluir", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        dialogInterface.cancel();
//                    }
//                });
//                janelaEscolha.setPositiveButton("Editar", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        boolean excluir = true;//usuarioController.excluirUsuarioController.getId() ;
//                        dialogInterface.cancel();
//
//                        if (excluir == true) {
//                            Toast.makeText(ActivityListarUsuario.this, "CADASTRO EXCLUÍDO COM SUCESSO!", Toast.LENGTH_LONG).show();
//                        } else {
//
//                            Toast.makeText(ActivityListarUsuario.this, "ERRO AO EXCLUIR CADASTRO", Toast.LENGTH_LONG).show();
//                        }
//
//                    }
//                });
//                janelaEscolha.create().show();
//
//            }
//        });//recupera a informação selecionada
//
//        ConexaoSQLite conexaoSQLite = ConexaoSQLite.getInstanciaConexao(this);


//    }
}
