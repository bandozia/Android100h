package br.com.impacta.android100h.lab01.app.controller;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;

import br.com.impacta.android100h.R;


public class SplashActivity extends ImpactaActivity {

    private Handler h;
    private Resources r;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lab01_splash);

        h = new Handler();
        r = getResources();

        Log.i("ANDOZIA","-> on create(Splahs Activity)");
    }

    @Override
    protected void onResume() {
        super.onResume();

        final Intent intent = new Intent(this, MainActivity.class);
        final int d = r.getInteger(R.integer.lab01_handler_delay);

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                intent.putExtra("nome","Jeremias");
                startActivity(intent);
            }
        },d);

        Log.i("ANDOZIA","-> on resume(Splahs Activity)");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i("ANDOZIA","-> on start(Splahs Activity)");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i("ANDOZIA","-> on restart(Splahs Activity)");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i("ANDOZIA","-> on pause(Splahs Activity)");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i("ANDOZIA","-> on stop(Splahs Activity)");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i("ANDOZIA","-> on destroy(Splahs Activity)");
    }
}
