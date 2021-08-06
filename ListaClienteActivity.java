package com.alura.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alura.agenda.R;
import com.alura.agenda.ui.activity.dao.ClienteDao;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListaClienteActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Lista de clientes";
    private final ClienteDao dao = new ClienteDao();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cliente);

        ClienteDao dao = new ClienteDao();

        setTitle(TITULO_APPBAR);

        configuraFabNovoCliente();

    }

    private void configuraFabNovoCliente() {
        FloatingActionButton botaoNovoCliente = findViewById(R.id.activity_lista_cliente_fab_novo_cliente);
        botaoNovoCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreFormularioClienteAcitivity();
            }
        });
    }

    private void abreFormularioClienteAcitivity() {
        startActivity(new Intent(this, FormularioClienteActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();


        configuraLista();
    }

    private void configuraLista() {
        ListView listaDeClientes = findViewById(R.id.acitivity_lista_clientes_listview);
        listaDeClientes.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.todos()));
    }
}

