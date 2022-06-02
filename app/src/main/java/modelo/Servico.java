package modelo;

public class Servico {

    private Long id;
    private String descricao;
    private String local;
    private String encarregado;
    private String setor;
    private String atendente;
    private Long data;

    public Servico() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getEncarregado() {
        return encarregado;
    }

    public void setEncarregado(String encarregado) {
        this.encarregado = encarregado;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getAtendente() {
        return atendente;
    }

    public void setAtendente(String atendente) {
        this.atendente = atendente;
    }

    public Long getData() {
        return data;
    }

    public void setData(Long data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", local='" + local + '\'' +
                ", encarregado='" + encarregado + '\'' +
                ", setor='" + setor + '\'' +
                ", atendente='" + atendente + '\'' +
                '}';
    }
}
