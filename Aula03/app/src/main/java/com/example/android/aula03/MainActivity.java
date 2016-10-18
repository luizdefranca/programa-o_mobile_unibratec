package com.example.android.aula03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String RESULTADO = "resultado";
    EditText mEdtGas;
    EditText mEdtAlcool;
    TextView mTxtResultado;

    public static final int NADA = 0;
    public static final int GAS = 1;
    public static final int ALCOOL =2;

    private int mResultado;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEdtGas = (EditText) findViewById(R.id.edtGasolina);
        mEdtAlcool = (EditText) findViewById(R.id.edtAlcool);
        mTxtResultado = (TextView) findViewById(R.id.txtViewResultado);

        if(savedInstanceState != null){
            mResultado = savedInstanceState.getInt(RESULTADO);
            atualizarTexto(mResultado);
        }
        findViewById(R.id.btnResultado).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double valorGasolina;
                double valorAlcool;
                String resultado = "";
                try {
                    valorGasolina = Double.parseDouble(mEdtGas.getText().toString());
                    valorAlcool = Double.parseDouble(mEdtAlcool.getText().toString());
                    if(valorAlcool > valorGasolina * 0.7){

                        mResultado = ALCOOL;
                    }else{

                        mResultado = GAS;
                    }
                    atualizarTexto(mResultado);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, R.string.invalidNumber, Toast.LENGTH_SHORT).show();

                }



            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(RESULTADO, mResultado);

    }

    private void atualizarTexto(int resultado){
        String textoResultado;
        switch (resultado){
            case 1: textoResultado = getString(R.string.alcool);
                break;
            case 2: textoResultado = getString(R.string.gasolina);
                break;
            default: textoResultado = "";
        }
        mTxtResultado.setText(textoResultado);
    }
}
