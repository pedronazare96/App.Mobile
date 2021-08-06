package com.alura.agenda.ui.activity.dao;

import com.alura.agenda.ui.activity.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteDao {

    private final static List<Cliente> clientes= new ArrayList<>();
    public void salva(Cliente cliente) {
        clientes.add(cliente);
    }

    public ArrayList<Cliente> todos() { return new ArrayList<>(clientes); }
}
