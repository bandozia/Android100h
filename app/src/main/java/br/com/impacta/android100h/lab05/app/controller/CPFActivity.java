package br.com.impacta.android100h.lab05.app.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.impacta.android100h.R;
import br.com.impacta.android100h.lab01.app.controller.ImpactaActivity;
import br.com.impacta.android100h.lab05.domain.Documento;
import br.com.impacta.android100h.lab05.domain.model.CPF;

public class CPFActivity extends ImpactaActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab05_cpf);
    }

    public void validar(View v){
        EditText valor;
        Documento documento;

        try{
            valor = getViewById(R.id.lab05_et_cpf);
            documento = new CPF(valor.getText());

            documento.validar();
            Toast.makeText(this, Documento.VALIDO, Toast.LENGTH_LONG).show();
        }catch (Exception cause){
            Toast.makeText(this,cause.getMessage(), Toast.LENGTH_LONG).show();
        }

    }
}
