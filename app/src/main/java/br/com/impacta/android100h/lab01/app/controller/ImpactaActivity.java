package br.com.impacta.android100h.lab01.app.controller;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.com.impacta.android100h.R;


public class ImpactaActivity extends AppCompatActivity {

    public interface Keys{
        String CLIPBOARD = "impacta.clip";
    }

    protected <T extends View> T getViewById(int id){
        return (T) findViewById(id);
    }

    protected void setOnClickAction(final View view, View.OnClickListener action){
        if (view != null){
            view.setOnClickListener(action);
        }
    }

    protected void setToastOnClickAction(final int id){
        final Button button = getViewById(id);
        final Resources r = getResources();
        final CharSequence text;

        text = r.getString(R.string.lab01_toast_clicado, button.getText());

        setOnClickAction(button,new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast t;
                t = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG);
                t.show();
            }
        });
    }

    protected void setOnClickAction(final int id, View.OnClickListener action){
        View view = getViewById(id);
        setOnClickAction(view,action);
    }

    protected void setOnClickActivityAction(final int id, final Class<?> _class){
        setOnClickAction(id, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),_class);
                startActivity(intent);
            }
        });
    }

    protected void copyToClipboard(CharSequence key, CharSequence value, int idMessage){
        ClipboardManager clipboardManager;
        ClipData clipData;
        Toast toast;

        clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        clipData = ClipData.newPlainText(key,value);
        toast = Toast.makeText(getApplicationContext(), idMessage, Toast.LENGTH_LONG);

        clipboardManager.setPrimaryClip(clipData);
        toast.show();
    }

    protected void copyToClipboard(CharSequence key, CharSequence value){
        copyToClipboard(key,value,R.string.clipboard);
    }

    protected void copyToClipboard(CharSequence value){
        copyToClipboard(Keys.CLIPBOARD, value);
    }

    protected void setText(int id, CharSequence value){
        ((TextView)getViewById(id)).setText(value);
    }

    protected void setOnLongClickAction(final View view, View.OnLongClickListener action){
        if (view != null){
            view.setOnLongClickListener(action);
        }
    }

    protected void setOnLongClickAction(int id, View.OnLongClickListener action){
        ((View)getViewById(id)).setOnLongClickListener(action);
    }

}
