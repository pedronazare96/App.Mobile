package com.alura.agenda.ui.activity;

import static com.alura.agenda.ui.activity.constanteActivities.CHAVE_CLIENTE;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.alura.agenda.R;
import com.alura.agenda.ui.activity.dao.ClienteDao;

public class FormularioClienteActivity extends AppCompatActivity {

    private static final String TITULO_APPBAR_NOVO_CLIENTE = "Novo Cliente";
    private static final String TITULO_APPBAR_EDITAR_CLIENTE= "Edita Cliente";
    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoModelo;
    private EditText campoData;
    private EditText campoOrcamento;
    private final ClienteDao dao= new ClienteDao();
    private Cliente cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_cliente);
        inicializacaoDosCampos();
        carregaCliente();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater()
                .inflate(R.menu.acivity_formulario_cliente_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.acitivity_formulario_cliente_menu_salvar){
            finalizaFormulario();
        }
        return super.onOptionsItemSelected(item);
    }

    private void carregaCliente() {
        Intent dados =getIntent();
        if(dados.hasExtra(CHAVE_CLIENTE)) {
            setTitle(TITULO_APPBAR_EDITAR_CLIENTE);
            cliente = (Cliente) dados.getSerializableExtra(CHAVE_CLIENTE);
            preenchaCampo();
        }else{
            setTitle(TITULO_APPBAR_NOVO_CLIENTE);
            cliente = new Cliente();
        }
    }

    private void preenchaCampo() {
        campoNome.setText(cliente.getNome());
        campoTelefone.setText(cliente.getTelefone());
        campoData.setText(cliente.getData());
        campoModelo.setText(cliente.getModelo());
        campoOrcamento.setText(cliente.getOrcamento());
    }

    private void finalizaFormulario() {
        preencheCliente();
        if(cliente.temIdValido()){
            dao.edita(cliente);
        }else {
            dao.salva(cliente);
        }

        finish();
    }
    private void inicializacaoDosCampos() {
        campoNome = findViewById(R.id.activity_formulario_cliente_nome);
        campoTelefone = findViewById(R.id.activity_formulario_cliente_telefone);
        campoData = findViewById(R.id.activity_formulario_cliente_data);
        campoModelo = findViewById(R.id.activity_formulario_cliente_modelo);
        campoOrcamento = findViewById(R.id.activity_formulario_cliente_orçamento);
    }


    private void preencheCliente() {
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String data = campoData.getText().toString();
        String modelo = campoModelo.getText().toString();
        String orcamento = campoOrcamento.getText().toString();

        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        cliente.setData(data);
        cliente.setModelo(modelo);
        cliente.setOrcamento(orcamento);
    }
}
