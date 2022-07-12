package com.example.appmobile.activities.dbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class ConexaoSQLite extends SQLiteOpenHelper {

    private static ConexaoSQLite INSTANCIA_CONEXAO;
    private static final int VERSAO_DB = 2;
    private static final String NOME_DB = "ServiceCap";

    public ConexaoSQLite(Context context) {
        super(context, NOME_DB, null, VERSAO_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE servico (id INTEGER PRIMARY KEY AUTOINCREMENT," + "local TEXT, encarregado TEXT, responsavel TEXT," +
                "descricao TEXT, setor TEXT, atendente TEXT);");


        db.execSQL("CREATE TABLE cadastro ( id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT," + "endereco TEXT, bairro TEXT," +
                " telefone TEXT, atendente TEXT);");

        db.execSQL("CREATE TABLE usuario ( id INTEGER PRIMARY KEY AUTOINCREMENT," + " nome TEXT, telefone TEXT," +
                " setor TEXT, senha TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+"servico");
        db.execSQL("DROP TABLE IF EXISTS "+"cadastro");
        db.execSQL("DROP TABLE IF EXISTS "+"usuario");

        onCreate(db);
    }

    public final class servico {
        private servico() {
        }

        public class entradaServicos implements BaseColumns {
            public static final String TABLE_NAME = " entradaServico";
            public static final String COLUMN_NAME_TITLE = "SERVICO";
        }

        }
}
