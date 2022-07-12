package DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.appmobile.activities.dbHelper.ConexaoSQLite;

import java.util.ArrayList;
import java.util.List;

import modelo.Servico;

public class ServicoDAO {
    private final ConexaoSQLite conexaoSQLite;

    public ServicoDAO(ConexaoSQLite conexaoSQLite) {
        this.conexaoSQLite = conexaoSQLite;
    }

    public Long inserirSevicoDAO(Servico sServico) {
        SQLiteDatabase db = conexaoSQLite.getReadableDatabase(); // leitura do banco de dados
        try {
            ContentValues values = new ContentValues();
            values.put("Id", sServico.getId());
            values.put("Descrição", sServico.getDescricao());
            values.put("Local", sServico.getSetor());
            values.put("Setor", sServico.getSetor());
            values.put("Atendente", sServico.getAtendente());
            values.put("Encarregado", sServico.getEncarregado());
            values.put("Data", sServico.getData());
            return  db.insert("servico", null, values);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                db.close();
            }
            return null;
        }

    }

    public List<Servico> ListaServicoDAO() {
        List<Servico> Listaservico = new ArrayList<>();
        SQLiteDatabase db = null;
        Cursor cursor;

        String query = "SELECT * FROM servico";
        try {
            db = conexaoSQLite.getReadableDatabase();
            cursor = db.rawQuery(query, null);
            if (cursor.moveToFirst()) {

                Servico servico = null;
                do {
                    servico = new Servico();
                    servico.setId(cursor.getLong(0));
                    servico.setDescricao(cursor.getString(1));
                    servico.setLocal(cursor.getString(2));
                    servico.setSetor(cursor.getString(3));
                    servico.setAtendente(cursor.getString(4));
                    servico.setEncarregado(cursor.getString(5));
                    servico.setData(cursor.getLong(6));

                    Listaservico.add(servico);

                } while (cursor.moveToNext());
            }

        } catch (Exception e) {
            Log.d("ERRO LISTA PRODUTOS", "ERRO AO RETORNAR SERVIÇO");
        }
        return Listaservico;
    }

    public void excluirServicoDAO(long IdServico, SQLiteDatabase db) {
        SQLiteDatabase dbs = null;
        try {
            db = this.conexaoSQLite.getWritableDatabase();
            db.delete("servico", "id =?", new String[]{String.valueOf(IdServico)});
        } catch (Exception e) {
            Log.d("ERRO LISTA SERVICO", "ERRO AO EXCLUIR SERVIÇO");
        }
    }
}