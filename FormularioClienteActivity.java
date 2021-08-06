package com.alura.agenda.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.alura.agenda.R;
import com.alura.agenda.ui.activity.dao.ClienteDao;

public class FormularioClienteActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Novo Cliente";
    private EditText campoOrçamento;
    private EditText campoModelo;
    private EditText campoData;
    private EditText campoTelefone;
    private EditText campoNome;
    final ClienteDao dao= new ClienteDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_cliente);
        setTitle(TITULO_APPBAR);
        inicializacaoDosCampos();
        configuraBotaoSalvar(dao);
    }





    private void inicializacaoDosCampos() {
        campoNome = findViewById(R.id.activity_formulario_cliente_nome);
        campoTelefone = findViewById(R.id.activity_formulario_cliente_telefone);
        campoData = findViewById(R.id.activity_formulario_cliente_data);
        campoModelo = findViewById(R.id.activity_formulario_cliente_modelo);
        campoOrçamento = findViewById(R.id.activity_formulario_cliente_orçamento);
    }

    private void configuraBotaoSalvar(ClienteDao dao) {
        Button botaoSalvar = findViewById(R.id.activity_botao_salvar);
        botaoSalvar.setOnClickListener(view -> {

             String nome = campoNome.getText().toString();
             String telefone = campoTelefone.getText().toString();
             String data = campoData.getText().toString();
             String modelo = campoModelo.getText().toString();
             String orçamento = campoOrçamento.getText().toString();

             Cliente clienteCriado = new Cliente(nome,telefone,data,modelo,orçamento);
             dao.salva(clienteCriado);

            finish();
        });
    }
}