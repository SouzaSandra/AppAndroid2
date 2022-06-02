package modelo;

public class Login {

    private String Usuarios;
    private Long senha_Acesso;

    public Login() {
    }

    public String getUsuarios() {
        return Usuarios;
    }

    public void setUsuarios(String usuarios) {
        Usuarios = usuarios;
    }

    public Long getSenha_Acesso() {
        return senha_Acesso;
    }

    public void setSenha_Acesso(Long senha_Acesso) {
        senha_Acesso = senha_Acesso;
    }

    @Override
    public String toString() {
        return "Login{" +
                "Usuarios='" + Usuarios + '\'' +
                ", senha_Acesso=" + senha_Acesso +
                '}';
    }
}

