package br.edu.unibratec.aula04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ExemploActivity extends AppCompatActivity {

    EditText mEdtName;
    TextView mTxtResponse;
    private String mtypedResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo);

        //Set mEdtName as EditTxtName

        mEdtName = (EditText) findViewById(R.id.editTxtName);

        //Set mTxtResponse as

        mTxtResponse = (TextView) findViewById(R.id.txtViewRespose);
        if(savedInstanceState != null){
            mtypedResponse = savedInstanceState.getString("savedTypedResponse");
            actualizeActivity(mtypedResponse);
        }

        //Set the Action to Button btnOK
        findViewById(R.id.btnOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mtypedResponse = mEdtName.getText().toString();
                actualizeActivity(mtypedResponse);

                mEdtName.getText().clear();

            }
        });

        //Set the Action to Button btnNewScreen
        findViewById(R.id.btnNewScreen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ExemploActivity.this, SecondScreen.class);
                it.putExtra("name", mTxtResponse.getText().toString());
                startActivity(it);

            }
        });

    }

    private void actualizeActivity(String mtypedResponse){
        mTxtResponse.setText(mtypedResponse);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("savedTypedResponse", mtypedResponse);
    }
}
