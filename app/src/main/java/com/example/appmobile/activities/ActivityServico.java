package com.example.appmobile.activities;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appmobile.R;
import com.example.appmobile.activities.dbHelper.ConexaoSQLite;

import DAO.ServicoDAO;
import controller.ServicoController;
import modelo.Servico;

public class ActivityServico extends AppCompatActivity {

    private ConexaoSQLite helper;
    private EditText edt_Ordem;
    private EditText edtDescricao;
    private EditText edtLocal;
    private EditText edtSetor;
    private EditText edtAtendente;
    private EditText edtEncarregado;
    private EditText edtData;

    private Button btnSalvarServico;
    private Servico servico;
    private ServicoDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servico);

        edt_Ordem = (EditText) findViewById(R.id.edt_Ordem);
        edtDescricao = (EditText) findViewById(R.id.edtDescrição);
        edtLocal = (EditText) findViewById(R.id.edtLocal);
        edtAtendente = (EditText) findViewById(R.id.edAtendente);
        edtEncarregado = (EditText) findViewById(R.id.edtEncarregado);
        edtData = (EditText) findViewById(R.id.edtData);

        helper = new ConexaoSQLite(this);



        btnSalvarServico = (Button) findViewById(R.id.btnSalvarServico);
        btnSalvarServico.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityServico.this, ActivityListarServicos.class);
                startActivity(intent);
            }


//                SQLiteDatabase db = helper.getReadableDatabase();
//                String[]projection ={
//                        BaseColumns._ID,
//                       // nome.COLUMN_NAME_TITLE,
//                      //  FeedEntry.COLUMN_NAME_SUBTITLE
//                };


        });
    }
    public void salvarServico(View view) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nome", edt_Ordem.getText().toString());
        values.put("descrição", edtDescricao.getText().toString());
        values.put("local", edtLocal.getText().toString());
        values.put("atendente", edtAtendente.getText().toString());
        values.put("encarregado", edtEncarregado.getText().toString());
        values.put("data", edtData.getText().toString());

        long resultado = db.insert("salvarServico", null, values);
        if (resultado != -1) {
            Toast.makeText(ActivityServico.this, "Serviço Cadastrado", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(ActivityServico.this, "Serviço não Cadastrado", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onDestroy() {
        helper.close();
        super.onDestroy();
    }
}



                
              /*  Servico servicoCadastrar = getSalvarServico();
                if (servicoCadastrar != null) {

                    ServicoController servicoController = new ServicoController(ConexaoSQLite.getInstanciaConexao(ActivityServico.this));
                    servicoController.salvarServicoCtrl(servicoCadastrar);

                    long idServico = servicoController.salvarServicoCtrl(servicoCadastrar);
                    if (idServico > 0) {


    private Servico getServicoSolicitado() {
        Servico servico = new Servico();

        if (edt_Ordem.getText().toString().isEmpty() == false) {
            Long id = Long.parseLong(edt_Ordem.getText().toString());
            servico.setId(id);
        }
        if (edtDescricao.getText().toString().isEmpty() == false) {
            servico.setDescricao(edtDescricao.getText().toString());

        }
        if (edtLocal.getText().toString().isEmpty() == false) {
            servico.setLocal(edtLocal.getText().toString());

        }
        if (edtSetor.getText().toString().isEmpty() == false) {
            servico.setSetor(edtSetor.getText().toString());

        }
        if (edtAtendente.getText().toString().isEmpty() == false) {
            servico.setAtendente(edtAtendente.getText().toString());

        }
        if (edtEncarregado.getText().toString().isEmpty() == false) {
            servico.setEncarregado(edtEncarregado.getText().toString());
        }
        if (edtData.getText().toString().isEmpty() == false) {
            Long data = Long.parseLong(edtData.getText().toString());
            servico.setData(data);
        }
        return servico;

    }
*/
   





