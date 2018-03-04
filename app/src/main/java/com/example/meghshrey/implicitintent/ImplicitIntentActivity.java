package com.example.meghshrey.implicitintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;



public class ImplicitIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);
        Button launch_btn = (Button) findViewById(R.id.launch_btn) ;
        launch_btn.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                EditText url_txt = (EditText) findViewById(R.id.url_text);
                String strURL = url_txt.getText().toString();
                if (strURL.indexOf("http://www") < 0) {
                    strURL = "http://www." + strURL;
                }

                Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse(strURL));
                startActivity(implicit);
            }
        });

        Button ring_btn = (Button) findViewById(R.id.ring_btn);
        ring_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText number_text = (EditText) findViewById(R.id.number_text);
                Intent implicit = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number_text.getText().toString()));
                startActivity(implicit);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu)
    {
        return true;
    }
}




