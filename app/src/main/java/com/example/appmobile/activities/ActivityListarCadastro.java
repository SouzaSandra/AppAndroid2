package com.example.appmobile.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.appmobile.R;
import com.example.appmobile.activities.dbHelper.ConexaoSQLite;
import com.example.appmobile.adapters.adapterListarCadastro;
import com.example.appmobile.adapters.adapterListarUsuario;

import java.util.ArrayList;
import java.util.List;

import controller.CadastroController;
import controller.UsuarioController;
import modelo.Cadastro;
import modelo.Usuario;

public class ActivityListarCadastro extends AppCompatActivity {

    private ListView lsvCadastro;
    private List<Cadastro> cadastroList;
    private adapterListarCadastro adaptersListarCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_cadastro);

        CadastroController cadastroController = new CadastroController(ConexaoSQLite.getInstanciaConexao(ActivityListarCadastro.this));
        cadastroController.getListaCadastroCtrl();

        this.cadastroList = new ArrayList(); //busca informações do banco para a lista
        this.lsvCadastro = (ListView)findViewById(R.id.lsvCadastro);
        this.adaptersListarCadastro = new adapterListarCadastro(ActivityListarCadastro.this, cadastroList);
        this.lsvCadastro.setAdapter((this.adaptersListarCadastro));

        this.lsvCadastro.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {

                //Cadastro cadastroSelecionado = (Cadastro) adapterListarCadastro.getItem(posicao);

                AlertDialog.Builder janelaEscolha = new AlertDialog.Builder(ActivityListarCadastro.this);

                janelaEscolha.setTitle("Opções");
                janelaEscolha.setMessage("Selecione a opção desejada!");

                janelaEscolha.setNeutralButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                        dialogInterface.cancel();
                                            }
                });
                 janelaEscolha.setNegativeButton("Excluir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.cancel();
                    }
                });
                janelaEscolha.setPositiveButton("Editar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                              //  boolean excluir = cadastroController.excluirCadastroController.getId() ;
                                dialogInterface.cancel();

                             //   if (excluir == true) {
                              //      Toast.makeText(ActivityListarCadastro.this, "CADASTRO EXCLUÍDO COM SUCESSO!", Toast.LENGTH_LONG).show();
                            //    }else {

                                    Toast.makeText( ActivityListarCadastro.this, "ERRO AO EXCLUIR CADASTRO", Toast.LENGTH_LONG).show();
                                }

                         //   }
                        });
                        janelaEscolha.create().show();

            }
        });//recupera a informação selecionada


        ConexaoSQLite conexaoSQLite = ConexaoSQLite.getInstanciaConexao(this);
    }

}