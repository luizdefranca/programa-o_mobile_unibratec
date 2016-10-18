package com.example.android.aula05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static com.example.android.aula05.Tela01Activity.TELA_01;

public class Tela02Activity extends AppCompatActivity {
    TextView mTxtNome;
    public static final String TELA_02 = "Tela 02";
    CheckBox mChkHabilitado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela02);
        mTxtNome = (TextView) findViewById(R.id.txtNome);
        mChkHabilitado = (CheckBox) findViewById(R.id.chkHabilitado);
        final Intent it = getIntent();
        final String nome = it.getStringExtra("nome");
        mTxtNome.setText(nome);
        Log.d(TELA_02, "onCreate");

        findViewById(R.id.btnConfirmar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.putExtra("checked", mChkHabilitado.isChecked());
                setResult(RESULT_OK, it);
                finish();
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TELA_02, "onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TELA_02,"onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TELA_02, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TELA_02, "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TELA_02, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TELA_02, "onStop");
    }
}
