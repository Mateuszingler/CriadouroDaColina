package br.edu.pdm.criadourodacolina.model;

import java.io.Serializable;


public class Passaro implements Serializable{

    private Long id;
    private String nome;
    private String especie;
    private int idImagemResource;
    private int idAudioResource;

    public  Passaro(Long id, String nome, String especie, int idImagemResource, int idAudioResource){
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.idImagemResource = idImagemResource;
        this.idAudioResource = idAudioResource;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getIdImagemResource() {
        return idImagemResource;
    }

    public void setIdImagemResource(int idImagemResource) {
        this.idImagemResource = idImagemResource;
    }

    public int getIdAudioResource() {
        return idAudioResource;
    }

    public void setIdAudioResource(int idAudioResource) {
        this.idAudioResource = idAudioResource;
    }

}
