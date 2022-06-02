package DAO;

import android.content.ContentValues;
import android.database.ContentObservable;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.appmobile.activities.dbHelper.ConexaoSQLite;

import java.util.ArrayList;
import java.util.List;

import modelo.Cadastro;
import modelo.Servico;

public class CadastroDAO {
    private final ConexaoSQLite conexaoSQLite;

    public CadastroDAO(ConexaoSQLite conexaoSQLite) {
        this.conexaoSQLite = conexaoSQLite;
    }

    public Long salvarCadastroDAO(Cadastro sCadastro) {
        SQLiteDatabase db = conexaoSQLite.getReadableDatabase(); // leitura do banco de dados
        try {
            ContentValues values = new ContentValues();
            values.put("nome", sCadastro.getNomeSolicita());
            values.put("Endereço", sCadastro.getEndereco());
            values.put("contato", sCadastro.getFoneSolicita());
            values.put("Bairro", sCadastro.getBairro());
            values.put("Atendente", sCadastro.getAtendente());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                db.close();
            }
            return null;
        }
    }

    public List<Cadastro> getListaCadastroDAO() {
        List<Cadastro> Listacadastro = new ArrayList<>();
        SQLiteDatabase db = null;
        Cursor cursor;

        String query = "SELECT * FROM cadastro";
        try {
            db = conexaoSQLite.getReadableDatabase();
            cursor = db.rawQuery(query, null);
            if (cursor.moveToFirst()) {

                Cadastro cadastro = null;
                do {
                    cadastro = new Cadastro();
                    cadastro.setNomeSolicita(cursor.getString(0));
                    cadastro.setEndereco(cursor.getString(1));
                    cadastro.setFoneSolicita(cursor.getLong(2));
                    cadastro.setBairro(cursor.getString(3));
                    cadastro.setAtendente(cursor.getString(4));

                    Listacadastro.add(cadastro);

                } while (cursor.moveToNext());
            }

        } catch (Exception e) {
            Log.d("ERRO LISTA CADASTROS", "ERRO AO RETORNAR CADASTROS");
            return null;
        } finally {
            if (db != null) {
                db.close();
            }
            return Listacadastro;
        }
    }
}


