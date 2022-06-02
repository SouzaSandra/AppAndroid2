package modelo;

public class Usuario {

    private Long id;
    private String nomeUser;
    private Long fone;
    private String setor;
    private Long senha;

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeUser() {
        return nomeUser;
    }

    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }

    public long getFone() {
        return fone;
    }

    public void setFone(Long fone) {
        this.fone = fone;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Long getSenha() {
        return senha;
    }

    public void setSenha(Long senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nomeUser='" + nomeUser + '\'' +
                ", fone=" + fone +
                ", setor='" + setor + '\'' +
                ", senha=" + senha +
                '}';
    }
}

