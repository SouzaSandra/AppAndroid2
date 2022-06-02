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
import com.example.appmobile.adapters.adapterListaServico;
import com.example.appmobile.adapters.adapterListarCadastro;
import com.example.appmobile.adapters.adapterListarUsuario;

import java.util.ArrayList;
import java.util.List;

import controller.ServicoController;
import controller.UsuarioController;
import modelo.Cadastro;
import modelo.Servico;
import modelo.Usuario;

public class ActivityListarServicos extends AppCompatActivity {

    private ListView lsvServico;
    private List<Servico> servicoList;
    private adapterListaServico adaptersListaServico;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_servicos);

        ServicoController servicoController = new ServicoController(ConexaoSQLite.getInstanciaConexao(ActivityListarServicos.this));
        servicoController.getListaServicoCtrl();

        this.servicoList = new ArrayList(); //busca informações do banco para a lista
        this.lsvServico = (ListView)findViewById(R.id.lsvServico);
        this.adaptersListaServico = new adapterListaServico(ActivityListarServicos.this, servicoList);
        this.lsvServico.setAdapter((this.adaptersListaServico));

        this.lsvServico.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {


               //Servico servicoSelecionado = (Servico) adapterListaServico.getItem(posicao);
                AlertDialog.Builder janelaEscolha = new AlertDialog.Builder(ActivityListarServicos.this);

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
                        boolean excluir = true;//ServicoController.excluirServicoController.getId() ;
                        dialogInterface.cancel();

                        if (excluir == true) {
                            Toast.makeText(ActivityListarServicos.this, "CADASTRO EXCLUÍDO COM SUCESSO!", Toast.LENGTH_LONG).show();
                        }else {

                            Toast.makeText( ActivityListarServicos.this, "ERRO AO EXCLUIR CADASTRO", Toast.LENGTH_LONG).show();
                        }

                    }
                });
                janelaEscolha.create().show();
            }
        });//recupera a informação selecionada

                ConexaoSQLite conexaoSQLite = ConexaoSQLite.getInstanciaConexao(this);
    }
}


