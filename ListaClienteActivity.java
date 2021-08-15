package com.alura.agenda.ui.activity;

import static com.alura.agenda.ui.activity.constanteActivities.CHAVE_CLIENTE;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alura.agenda.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListaClienteActivity extends AppCompatActivity {

    private static final String TITULO_APPBAR = "Lista de clientes";
    private final ListaClienteView listaClientesView = new ListaClienteView(this);


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cliente);
        setTitle(TITULO_APPBAR);
        configuraFabNovoCliente();
        configuraLista();


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater()
                .inflate(R.menu.acitivity_lista_cliente_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        int itemId = item.getItemId();
        if (itemId == R.id.activity_lista_cliente_menu_remover) {
            listaClientesView.confirmaRemocao(item);
        }

        return super.onContextItemSelected(item);
    }


    private void configuraFabNovoCliente() {
        FloatingActionButton botaoNovoCliente = findViewById(R.id.activity_lista_cliente_fab_novo_cliente);
        botaoNovoCliente.setOnClickListener(v -> abreFormularioModInsereClientes());
    }

    private void abreFormularioModInsereClientes() {
        startActivity(new Intent(this, FormularioClienteActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        listaClientesView.atualizaClientes();
    }


    private void configuraLista() {
        ListView listaDeClientes = findViewById(R.id.acitivity_lista_clientes_listview);
        listaClientesView.configureAdapter(listaDeClientes);
        configuraListinerDeCliquePorItem(listaDeClientes);
        registerForContextMenu(listaDeClientes);
    }

    private void configuraListinerDeCliquePorItem(ListView listaDeClientes) {
        listaDeClientes.setOnItemClickListener((adapterView, view, position, id) -> {
            Cliente clienteEscolhido = (Cliente) adapterView.getItemAtPosition(position);
            abreFormularioModoEditaAluno(clienteEscolhido);
        });
    }

    private void abreFormularioModoEditaAluno(Cliente cliente) {
        Intent vaiParaFormularioActivity = new Intent(ListaClienteActivity.this,
                FormularioClienteActivity.class);
        vaiParaFormularioActivity.putExtra(CHAVE_CLIENTE, cliente);
        startActivity(vaiParaFormularioActivity);
    }
}
