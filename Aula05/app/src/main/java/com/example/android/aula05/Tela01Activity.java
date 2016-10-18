package com.example.android.aula05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Tela01Activity extends AppCompatActivity {

    public static final String RESULTADO = "Resultado";
    public static final String TELA_01 = "Tela 01";
    EditText mEdtNome;
    TextView mTxtResultado;
    private String resultado="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TELA_01, "onCreate");
        setContentView(R.layout.activity_tela01);
        mTxtResultado = (TextView) findViewById(R.id.txtResultado);
        mEdtNome = (EditText) findViewById(R.id.edtNome);

        //Method for Button OK
        findViewById(R.id.btnOk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado =mEdtNome.getText().toString();
                showResultado(resultado);
                mEdtNome.getText().clear();

            }
        });

        //Method for Button Passar
        findViewById(R.id.btnTela02).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Tela01Activity.this, Tela02Activity.class);
                //resultado =mEdtNome.getText().toString();
                it.putExtra("nome", resultado);
                startActivity(it);
            }
        });

        //Method for Button Resultado
        findViewById(R.id.btnResult).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Tela01Activity.this, Tela02Activity.class);
                it.putExtra("nome", resultado);
                startActivityForResult(it,0); // 0 zero é o requestCode informar que o resultado esta vindo do onActivityResult
            }
        });

        //Rescue savedInstanceState
        if(savedInstanceState != null){
            resultado = savedInstanceState.getString(RESULTADO);
            showResultado(resultado);
        }
    }

    private void showResultado(String resultado) {
        mTxtResultado.setText(resultado);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(RESULTADO, resultado);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0 && resultCode == RESULT_OK){
            resultado = data.getBooleanExtra("checked", false)? "Verdadeiro": "False";
            showResultado(resultado);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TELA_01, "onResume");
        showResultado("");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TELA_01,"onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TELA_01, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TELA_01, "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TELA_01, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TELA_01, "onStop");
    }
}
