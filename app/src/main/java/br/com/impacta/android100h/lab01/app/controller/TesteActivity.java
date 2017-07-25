package br.com.impacta.android100h.lab01.app.controller;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import br.com.impacta.android100h.R;


public class TesteActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.teste_layout);

    }
}
