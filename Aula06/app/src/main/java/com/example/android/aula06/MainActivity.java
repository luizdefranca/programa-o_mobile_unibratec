package com.example.android.aula06;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_SOCIAL = 1;

    int msocialSelected = Constants.FACEBOOK;

    EditText mEdtName;
    Button mBtnSocial;
    CheckBox mCheckReceive;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializa os elementos da View
        mEdtName = (EditText) findViewById(R.id.edtName);
        mBtnSocial = (Button) findViewById(R.id.txtSocial);
        mCheckReceive = (CheckBox) findViewById(R.id.chkReceiveEmail);

        //Inicializa o tratador para o click
        TratadorClick tratadorClick = new TratadorClick();

        //Seta um onClickListener para o botao btnSocial passando o tratadoClick
        mBtnSocial.setOnClickListener(tratadorClick);

        //Seta um onClickListener para o botao btnSend passando o tratadoClick
        findViewById(R.id.btnSend).setOnClickListener(tratadorClick);

        //Recupera o estado da activity
        if(savedInstanceState != null){
            msocialSelected = savedInstanceState.getInt(Constants.SOCIAL, Constants.FACEBOOK);
            ajustaButton(msocialSelected);

        }

    }

    class TratadorClick implements View.OnClickListener{

        //deve ser colocado aqui o código por botao
        @Override
        public void onClick(View v) {

            if(v.getId() == R.id.txtSocial) {
                Intent it = new Intent(MainActivity.this, SocialActivity.class);
                it.putExtra(Constants.SOCIAL,msocialSelected);
                startActivityForResult(it, REQUEST_SOCIAL);
            } else if(v.getId() == R.id.btnSend){
                Intent it = new Intent(MainActivity.this, ResultActivity.class);
                it.putExtra("nome", mEdtName.getText().toString());
                it.putExtra("social", mBtnSocial.getText().toString());
                it.putExtra("email", mCheckReceive.getText().toString());
                startActivity(it);
            }

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        /*Deve-se checar o requestCode para ver de qual tela esta retonando e
        Deve-se checar o resultCode para ver qual foi o tipo de resposta */
        if(requestCode == REQUEST_SOCIAL && resultCode == RESULT_OK){

            //Pega o valor repassado pela Intent
            msocialSelected = data.getIntExtra(Constants.SOCIAL, Constants.FACEBOOK);
            //muda o texto do button btnSocial
            ajustaButton(msocialSelected);


        }
    }

    private void ajustaButton(int msocialSelected) {
        //Cria um array de Strings com o Recursos que esta em values/strings.xml
        String[] socialsArray = getResources().getStringArray(R.array.socials);
        //Seta o texto do Button btnSocial
        mBtnSocial.setText(socialsArray[msocialSelected]);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //Salva o estado da Activity
        outState.putInt(Constants.SOCIAL, msocialSelected);
    }
}
