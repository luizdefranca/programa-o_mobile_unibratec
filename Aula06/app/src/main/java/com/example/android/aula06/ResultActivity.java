package com.example.android.aula06;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView mtxtName;
    TextView mtxtSocial;
    TextView mtxtEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        String nome = getIntent().getStringExtra("nome");
        String social = getIntent().getStringExtra("social");
        String email = getIntent().getStringExtra("email");

        mtxtName    = (TextView) findViewById(R.id.txtName);
        mtxtSocial = (TextView) findViewById(R.id.txtSocial);
        mtxtEmail = (TextView) findViewById(R.id.txtEmail);

        mtxtName.setText(nome);
        mtxtSocial.setText(social);
        mtxtEmail.setText(email);
    }
}
