package com.geolocation.geolocation.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class City {
    private Long id;
    private String uf;
    private String regiao;
    private String localidade;
    private String localidadeSemAcentos;
    private String faixaDeCep;
    private long cepInicial;
    private long cepFinal;
    private String situacao;
    private String tipoDeFaixa;
    private double latitude;
    private double longitude;
    private String codGeograficoSubdivisao;
    private String codGeograficoDistrito;
    private String codIbge;
    private String microrregiao;
    private String mesorregiao;
    private String categoria;
    private double altitude;
    private String localizacao;
    private String localizacaoSemAcentos;

    public Long getId() {
        return id;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    public String getUf() { return uf; }
    public void setUf(String uf) { this.uf = uf; }

    public String getCodIbge() { return codIbge; }
    public void setCodIbge(String codIbge) { this.codIbge = codIbge; }

    public String getRegiao() { return regiao; }
    public void setRegiao(String regiao) { this.regiao = regiao; }

}
