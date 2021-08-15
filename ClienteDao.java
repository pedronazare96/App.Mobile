package com.alura.agenda.ui.activity.dao;

import androidx.annotation.Nullable;

import com.alura.agenda.ui.activity.Cliente;

import java.util.ArrayList;
import java.util.List;


public class ClienteDao {

    private final static List<Cliente> clientes = new ArrayList<>();
    private static int contadorDeIds = 1;

    public void salva(Cliente cliente) {
        cliente.setId(contadorDeIds);
        clientes.add(cliente);
        atualizaIds();
    }

    private void atualizaIds() {
        contadorDeIds++;
    }

    public void edita(Cliente cliente) {
        Cliente clienteEncontrado = buscaClientePeloId(cliente);
        if (clienteEncontrado != null) {
            int posicaoDoCliente = clientes.indexOf(clienteEncontrado);
            clientes.set(posicaoDoCliente, cliente);
        }
    }

    @Nullable
    private Cliente buscaClientePeloId(Cliente cliente) {
        for (Cliente a : 
                clientes) {
            if (a.getId() == cliente.getId()) {
                return a;
            }
        }
        return null;
    }

    public List<Cliente> todos() {
        return new ArrayList<>(clientes);
    }

    public void remove(Cliente cliente) {
        Cliente clienteDevolvido = buscaClientePeloId(cliente);
        if(clienteDevolvido != null ) {
            clientes.remove(clienteDevolvido);
        }
    }
}
