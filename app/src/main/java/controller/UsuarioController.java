package controller;

import com.example.appmobile.activities.dbHelper.ConexaoSQLite;

import java.util.List;

import DAO.ServicoDAO;
import DAO.UserDAO;
import modelo.Cadastro;
import modelo.Servico;
import modelo.Usuario;

public class UsuarioController {

    private UserDAO userDAO;

    public UsuarioController(ConexaoSQLite uConexaoSQLite) {
        userDAO = new UserDAO(uConexaoSQLite);
    }

    public long salvarUsuarioCtrl(Usuario sUsuario) {
        return userDAO.salvarUserDAO(sUsuario);

    }

    public List<Usuario> getListaUsuarioCtrl() {
        return this.userDAO.getListaUserDAO();
    }


    public boolean excluirCadastroController(long IdUsuario) {
        return true; //this.userDAO.excluirUserDAO(IdUsuario);
    }
}