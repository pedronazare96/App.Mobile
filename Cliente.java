package com.alura.agenda.ui.activity;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Cliente implements Serializable {

    private  int id= 0;
    private  String nome;
    private  String telefone;
    private  String data;
    private  String modelo;
    private  String orcamento;

    public Cliente(String nome, String telefone, String data, String modelo, String orcamento){
        this.nome = nome;
        this.telefone = telefone;
        this.data = data;
        this.modelo = modelo;
        this.orcamento = orcamento;
    }

    public Cliente() {

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setOrcamento(String orcamento) {
        this.orcamento = orcamento;
    }


    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getData() {
        return data;
    }

    public String getModelo() {
        return modelo;
    }

    public String getOrcamento() {
        return orcamento;
    }

    @NonNull
    @Override
    public String toString() { return nome+" "+ telefone;}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean temIdValido() {
        return id > 0;
    }
}
