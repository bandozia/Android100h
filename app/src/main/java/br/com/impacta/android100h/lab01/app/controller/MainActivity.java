package br.com.impacta.android100h.lab01.app.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.impacta.android100h.R;
import br.com.impacta.android100h.lab02.app.controller.MegaSenaActivity;
import br.com.impacta.android100h.lab03.app.controller.GorjetaActivity;
import br.com.impacta.android100h.lab04.app.controller.IntentActivity;
import br.com.impacta.android100h.lab05.app.controller.CPFActivity;


public class MainActivity extends ImpactaActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lab01_main);

        setOnClickActivityAction(R.id.lab01_bt_megasena, MegaSenaActivity.class);
        setOnClickActivityAction(R.id.lab01_bt_gorjeta, GorjetaActivity.class);
        setOnClickActivityAction(R.id.lab01_bt_intent, IntentActivity.class);
        setOnClickActivityAction(R.id.lab01_bt_cpf, CPFActivity.class);
        setToastOnClickAction(R.id.lab01_bt_cep);
        setToastOnClickAction(R.id.lab01_bt_game01);
        setToastOnClickAction(R.id.lab01_bt_gps);
        setToastOnClickAction(R.id.lab01_bt_sqlite);
        setToastOnClickAction(R.id.lab01_bt_game02);
        setToastOnClickAction(R.id.lab01_bt_service);
        setToastOnClickAction(R.id.lab01_bt_bluetooth);
        setToastOnClickAction(R.id.lab01_bt_sms);
        setToastOnClickAction(R.id.lab01_bt_camera);

        setToastOnClickAction(R.id.lab01_bt_game03);
        setToastOnClickAction(R.id.lab01_bt_share_preferences);

        Log.i("ANDOZIA","-> on create(Main Activity)");

    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i("ANDOZIA","-> on start(Main Activity)");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ANDOZIA","-> on resumes(Main Activity)");
        Intent intent = getIntent();
        String nome = intent.getStringExtra("nome");
        Log.i("ANDOZIA","-> on resumes(Main Activity[EXTRA]: " + nome + ")");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i("ANDOZIA","-> on restart(Main Activity)");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i("ANDOZIA","-> on pause(Main Activity)");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i("ANDOZIA","-> on stop(Main Activity)");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i("ANDOZIA","-> on destroy(Main Activity)");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.i("ANDOZIA","-> on save instance(Main Activity)");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.i("ANDOZIA","-> on restore instance(Main Activity)");
    }
}
