package modelo;

import java.util.Date;

public class Cadastro {

    private String nomeSolicita;
    private String endereco;
    private Long foneSolicita;
    private String bairro;
    private String atendente;
    private Date data;


    public Cadastro() {
    }

    public String getNomeSolicita() {
        return nomeSolicita;
    }

    public void setNomeSolicita(String nomeSolicita) {
        this.nomeSolicita = nomeSolicita;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public long getFoneSolicita() {
        return foneSolicita;
    }

    public void setFoneSolicita(long foneSolicita) {
        this.foneSolicita = foneSolicita;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getAtendente() {
        return atendente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Cadastro{" +
                "nomeSolicita='" + nomeSolicita + '\'' +
                ", endereco='" + endereco + '\'' +
                ", foneSolicita=" + foneSolicita +
                ", bairro='" + bairro + '\'' +
                ", atendente='" + atendente + '\'' +
                ", data=" + data +
                '}';
    }

    public void setAtendente(String atendente) {
        this.atendente = atendente;

    }

    }

