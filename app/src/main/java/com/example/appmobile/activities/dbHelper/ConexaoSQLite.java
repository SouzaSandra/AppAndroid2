package com.example.appmobile.activities.dbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class

ConexaoSQLite extends SQLiteOpenHelper {

    private static ConexaoSQLite INSTANCIA_CONEXAO;
    private  static  final  int VERSAO_DB = 1;
    private static final String NOME_DB = "service_cap_app";

    public ConexaoSQLite( Context context) {
        super(context, NOME_DB, null, VERSAO_DB);
    }

    public  static ConexaoSQLite getInstanciaConexao(Context context){
        if (INSTANCIA_CONEXAO == null){
            INSTANCIA_CONEXAO = new ConexaoSQLite(context);
        }
        return INSTANCIA_CONEXAO;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlTabelaServico = "CREATE TABLE IF NOT EXISTS servico"+
                "("+
                "id INTEGER PRIMARY KEY,"+
                "local TEXT,"+
                "encarregado TEXT,"+
                " responsável TEXT,"+
                "descricaoTEXT,"+
                "setorTEXT,"+
                "atendente TEXT"+
                ")";
        String sqlTabelaCadastro = "CREATE TABLE IF NOT EXISTS cadastro"+
                "("+
                "nome PRIMARY KEY,"+
                "endereco TEXT,"+
                "bairro TEXT,"+
                " telefone INT,"+
                "atendente TEXT,"+
                "data INT"+
                ")";
        String sqlTabelaUsuario = "CREATE TABLE IF NOT EXISTS usuario"+
                "("+
                "id PRIMARY KEY,"+
                "nome TEXT,"+
                " fone INT,"+
                " setor TEXT,"+
                "senha INT"+
                ")";

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
