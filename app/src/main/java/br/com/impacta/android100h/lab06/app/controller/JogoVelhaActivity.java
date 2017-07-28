package br.com.impacta.android100h.lab06.app.controller;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.TextView;

import br.com.impacta.android100h.R;
import br.com.impacta.android100h.lab01.app.controller.ImpactaActivity;
import br.com.impacta.android100h.lab06.domain.model.JogoVelha;

/**
 * Created by no3603 on 27/07/2017.
 */

public class JogoVelhaActivity extends ImpactaActivity {

    private Resources r;
    private FragmentManager fm;

    private Fragment placarView;
    private Fragment tabuleiroView;

    private JogoVelha model;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab06_jogo_velha);

        r = getResources();
        fm = getSupportFragmentManager();

        placarView = fm.findFragmentById(R.id.lab06_placarFragment);
        model = new JogoVelha();
    }

    private void adcionarTabuleiro(){
        tabuleiroView = new TabuleiroFragment();
        fm.beginTransaction().replace(R.id.lab06_tabuleiroFragment,tabuleiroView).disallowAddToBackStack().commit();
    }
    //132

    private void atualizarPartidas(){
        View v = placarView.getView();

        if (v == null)
            return;

        CharSequence message;
        TextView tvO = (TextView) v.findViewById(R.id.lab06_placarO);
        TextView tvX = (TextView) v.findViewById(R.id.lab06_placarX);

        tvO.setText(r.getString(R.string.lab06_jogosO, model.getJogadorO().getPartidasGanhas()));

        //132
    }

}
