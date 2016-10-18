package br.edu.unibratec.aula04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondScreen extends AppCompatActivity {
    TextView mtxtName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        //Set mtxtName as the TextView txtName

        mtxtName = (TextView) findViewById(R.id.txtNome);
        // Get the name on Intent
        String name = getIntent().getStringExtra("name");

        //Set the property of mtxtName as name
        mtxtName.setText(name);

    }
}
