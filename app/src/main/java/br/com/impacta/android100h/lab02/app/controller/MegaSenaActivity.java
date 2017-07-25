package br.com.impacta.android100h.lab02.app.controller;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.impacta.android100h.R;
import br.com.impacta.android100h.lab01.app.controller.ImpactaActivity;
import br.com.impacta.android100h.lab01.design.pattern.OnSeekBarChangeAdapter;
import br.com.impacta.android100h.lab02.domain.model.MegaSena;

public class MegaSenaActivity extends ImpactaActivity {
    private TextView tvSORTEIOS;
    private SeekBar sbSORTEIOS;
    private ListView lvSORTEIOS;

    private ArrayList<String> jogos;

    private void atualizarListView(Bundle bundle){
        if (bundle != null){
            jogos = bundle.getStringArrayList(MegaSena.Bundle.JOGOS);

            if (jogos != null){
                lvSORTEIOS.setAdapter(new ArrayAdapter<>(getApplicationContext(), R.layout.lab02_jogo, jogos));
            }

            tvSORTEIOS.setText(bundle.getCharSequence(MegaSena.Bundle.JOGO));

        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lab02_megasena);
        lvSORTEIOS = getViewById(android.R.id.list);
        sbSORTEIOS = getViewById(R.id.lab02_sb_sorteios);
        tvSORTEIOS = getViewById(R.id.lab02_tv_sorteios);

        setOnClickAction(R.id.lab02_bt_sortear, new OnButtonClickAction());
        sbSORTEIOS.setOnSeekBarChangeListener(new OnSeekBarChangeAction());
        lvSORTEIOS.setOnItemLongClickListener(new OnItemLongClickAction());

        atualizarListView(savedInstanceState);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putStringArrayList(MegaSena.Bundle.JOGOS, jogos);
        outState.putCharSequence(MegaSena.Bundle.JOGO, tvSORTEIOS.getText());
    }

    private class OnSeekBarChangeAction extends OnSeekBarChangeAdapter{
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            super.onProgressChanged(seekBar, progress, fromUser);
            if (fromUser){
                tvSORTEIOS.setText(String.valueOf(progress));
            }

        }
    }

    private class OnButtonClickAction implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            int p = sbSORTEIOS.getProgress();
            jogos = MegaSena.sortear(p);

            lvSORTEIOS.setAdapter(new ArrayAdapter<>(getApplicationContext(), R.layout.lab02_jogo, jogos));
        }
    }

    private class OnItemLongClickAction implements AdapterView.OnItemLongClickListener{

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

            final CharSequence jogo = parent.getItemAtPosition(position).toString();

            copyToClipboard(MegaSena.Bundle.JOGO, jogo);
            return true;
        }
    }

}
