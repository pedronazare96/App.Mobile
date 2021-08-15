package com.alura.agenda.ui.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alura.agenda.ui.activity.dao.ClienteDao;


public class ListaClienteView {

    private final ListaClienteAdapter adapter;
    private final ClienteDao dao;
    private final Context context;

    public ListaClienteView(Context context) {
        this.context = context;
        this.adapter = new ListaClienteAdapter(this.context);
        this.dao = new ClienteDao();
}

    public void confirmaRemocao(final MenuItem item) {
        new AlertDialog
                .Builder(context)
                .setTitle("Removendo cliente")
                .setMessage("Tem certeza que quer remover o cliente?")
                .setPositiveButton("Sim", (dialogInterface, i) -> {
                    AdapterView.AdapterContextMenuInfo menuInfo =
                            (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                    Cliente clienteEscolhido = (Cliente) adapter.getItem(menuInfo.position);
                    remove(clienteEscolhido);
                })
                .setNegativeButton("Não", null)
                .show();
    }

    public void atualizaClientes() {
        adapter.atualiza(dao.todos());
    }

    private void remove(Cliente cliente) {
        dao.remove(cliente);
        adapter.remove(cliente);
    }

    public void configureAdapter(ListView listaDeClientes) {
        listaDeClientes.setAdapter(adapter);
    }
}
