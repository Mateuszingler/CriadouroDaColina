package br.edu.pdm.criadourodacolina.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.edu.pdm.criadourodacolina.R;



public class TipoPassaro implements Serializable {

    private Long idTipoPassaro;
    private String tipo;
    private List<Passaro> listaPassaros;

    public TipoPassaro(Long idTipoPassaro, String tipo, List<Passaro> listaPassaros){
        this.idTipoPassaro = idTipoPassaro;
        this.tipo = tipo;
        this.listaPassaros = listaPassaros;
    }

    public Long getIdTipoPassaro() {
        return idTipoPassaro;
    }

    public void setIdTipoPassaro(Long idTipoPassaro) {
        this.idTipoPassaro = idTipoPassaro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Passaro> getListaPassaros() {
        return listaPassaros;
    }

    public void setListaPassaros(List<Passaro> listaPassaros) {
        this.listaPassaros = listaPassaros;
    }

    @Override
    public String toString() {
        return tipo;
    }
}

