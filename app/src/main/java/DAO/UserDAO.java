package DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.appmobile.activities.dbHelper.ConexaoSQLite;

import java.util.ArrayList;
import java.util.List;

import modelo.Usuario;

public class UserDAO {
    private final ConexaoSQLite conexaoSQLite;
    public UserDAO(ConexaoSQLite conexaoSQLite) {
        this.conexaoSQLite = conexaoSQLite;
    }

    public Long salvarUserDAO(Usuario usuario) {
        SQLiteDatabase db = conexaoSQLite.getReadableDatabase(); // leitura do banco de dados
        try {
            ContentValues values = new ContentValues();
            values.put("Id", usuario.getId());
            values.put("Nome", usuario.getNomeUser());
            values.put("Fone", usuario.getFone());
            values.put("Setor", usuario.getSetor());
            values.put("Senha", usuario.getSenha());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            {
                if (db != null) {
                    db.close();
                }
            }
            return null;
        }

    }

    public List<Usuario> getListaUserDAO() {
        List<Usuario> ListaUsuario = new ArrayList<>();
        SQLiteDatabase db = null;
        Cursor cursor;

        String query = "SELECT * FROM usuario";
        try {
            db = conexaoSQLite.getReadableDatabase();
            cursor = db.rawQuery(query, null);
            if(cursor.moveToFirst()) {

                Usuario usuario = null;
                do {
                    usuario = new Usuario();
                    usuario.setId(cursor.getLong(0));
                    usuario.setNomeUser(cursor.getString(1));
                    usuario.setFone(cursor.getLong(2));
                    usuario.setSetor(cursor.getString(3));
                    usuario.setSenha(cursor.getLong(4));

                    ListaUsuario.add(usuario);

                } while (cursor.moveToNext());
            }

        } catch (Exception e) {
            Log.d("ERRO LISTA USUARIOS", "ERRO AO RETORNAR USUÁRIOS");
            return null;
        }  finally {
            if (db != null) {
                db.close();
            }
            return ListaUsuario;
        }
    }
    public void excluirUserDAO(long IdUsuario, SQLiteDatabase db) {
        SQLiteDatabase dbs = null;
        try {
            db = this.conexaoSQLite.getWritableDatabase();
            db.delete(
                    "cadastro",
                    "id =?",
                    new String[]{String.valueOf(IdUsuario)}
            );


        } catch (Exception e) {

        }
    }
}


