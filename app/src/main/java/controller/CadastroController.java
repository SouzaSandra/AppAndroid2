package controller;

import com.example.appmobile.activities.dbHelper.ConexaoSQLite;

import java.util.List;

import DAO.CadastroDAO;
import modelo.Cadastro;


public class CadastroController {
    private CadastroDAO cadastroDAO;

    public CadastroController(ConexaoSQLite cConexaoSQLite) {
        cadastroDAO = new CadastroDAO(cConexaoSQLite);
    }

    public Long salvarCadastroCtrl(Cadastro sCadastro) {
        return cadastroDAO.salvarCadastroDAO(sCadastro);
    }

    public List<Cadastro>getListaCadastroCtrl(){
        return  this.cadastroDAO.getListaCadastroDAO();
    }

    public boolean excluirCadastroController(long IdCadastro) {
        return true; //cadastroDAO.excluirCadastroDAO(IdCadastro);

    }
    }

