package com.infnet.infnetPB.DTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class MesaDTO {

    @NotNull
    @Min(1)
    private int qtdAssentosMax;

    @NotBlank
    private String status;

    private String infoAdicional;

    @NotBlank
    private String nomeRestaurante;

    @NotBlank
    private String localizacao;

    // Getters and setters

    public int getQtdAssentosMax() {
        return qtdAssentosMax;
    }

    public void setQtdAssentosMax(int qtdAssentosMax) {
        this.qtdAssentosMax = qtdAssentosMax;
    }

    public String getInfoAdicional() {
        return infoAdicional;
    }

    public void setInfoAdicional(String infoAdicional) {
        this.infoAdicional = infoAdicional;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNomeRestaurante() {
        return nomeRestaurante;
    }

    public void setNomeRestaurante(String nomeRestaurante) {
        this.nomeRestaurante = nomeRestaurante;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}