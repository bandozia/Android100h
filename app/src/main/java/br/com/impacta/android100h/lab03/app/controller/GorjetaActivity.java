package br.com.impacta.android100h.lab03.app.controller;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.SeekBar;

import br.com.impacta.android100h.R;
import br.com.impacta.android100h.lab01.app.controller.ImpactaActivity;
import br.com.impacta.android100h.lab01.design.pattern.TextWatcherAdapter;
import br.com.impacta.android100h.lab03.domain.model.Gorjeta;

public class GorjetaActivity extends ImpactaActivity {

    private EditText etCONTA;
    private SeekBar sbDEF;



    private class ValorZeroTextWatcherAction extends TextWatcherAdapter{
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s == null && s.length() == 0){
                etCONTA.setText(Gorjeta.VALOR_0);
                etCONTA.selectAll();
            }
        }
    }

    private class Calcular10PorcentoTextWatcherAction extends TextWatcherAdapter{
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            final Resources r = getResources();
            CharSequence v;
            Integer p;

            p = r.getInteger(R.integer.lab03_percent_1);
            v = Gorjeta.calcularGorjeta(s,p);
            setText(R.id.lab03_et_gorjeta_1, v);

            v = Gorjeta.calcularValor(s,p);
            setText(R.id.lab03_et_valor_1,v);
        }
    }

    private class Calcular15PorcentoTextWatcherAction extends TextWatcherAdapter{
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            final Resources r = getResources();
            CharSequence v;
            Integer p;

            //72
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lab03_gorjeta);
    }
}
