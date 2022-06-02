package controller;

import com.example.appmobile.activities.dbHelper.ConexaoSQLite;

import java.util.List;

import DAO.ServicoDAO;
import modelo.Cadastro;
import modelo.Servico;

public class ServicoController {

    private ServicoDAO servicoDAO;

    public ServicoController(ConexaoSQLite sConexaoSQLite) {
        servicoDAO = new ServicoDAO(sConexaoSQLite);
    }

    public Long salvarServicoCtrl(Servico sServico) {
        return servicoDAO.salvarSevicoDAO(sServico);
    }

    public List<Servico> getListaServicoCtrl() {
        return servicoDAO.getListaServicoDAO();
    }


    public boolean excluirServicoController(long IdServico) {
        return true; //this.servicoDAO.excluirServicoDAO(IdServico);
    }


}
