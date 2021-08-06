package com.alura.agenda.ui.activity;

import androidx.annotation.NonNull;

public class Cliente {
    private final String nome;
    private final String telefone;
    private final String data;
    private final String modelo;
    private final String orçamento;

    public Cliente(String nome, String telefone, String data, String modelo, String orçamento) {
        this.nome = nome;
        this.telefone = telefone;
        this.data = data;
        this.modelo = modelo;
        this.orçamento = orçamento;
    }
    @NonNull
    @Override
    public String toString() { return nome; }
}
