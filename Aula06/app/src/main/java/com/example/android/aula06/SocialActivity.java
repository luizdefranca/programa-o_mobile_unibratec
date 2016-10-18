package com.example.android.aula06;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class SocialActivity extends AppCompatActivity {

    RadioGroup mRgSocial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);

        int[] socialAvailable = new int[]{
                R.id.rbFacebook,
                R.id.rbTwitter,
                R.id.rbGooglePlus
        };

        int social = getIntent().getIntExtra(Constants.SOCIAL, Constants.FACEBOOK);

        //Inicializa componentes da View
        mRgSocial = (RadioGroup) findViewById(R.id.rdgSocial);
        mRgSocial.check(socialAvailable[social]);



        findViewById(R.id.btnSelect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selected = mRgSocial.getCheckedRadioButtonId();
                int social;

                switch (selected){
                    case R.id.rbFacebook:       social = Constants.FACEBOOK; break;
                    case R.id.rbTwitter:        social = Constants.TWITTER; break;
                    case R.id.rbGooglePlus:     social = Constants.G_PLUS; break;
                    default:                    social = Constants.FACEBOOK;
                }

                Intent intentResult = new Intent();
                intentResult.putExtra(Constants.SOCIAL, social);
                setResult(RESULT_OK, intentResult);
                finish();
            }
        });

    }
}
