package com.demotxt.androidapp5;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String myNameFirst;
    TextView txFirstName;
  EditText etfirts;
  Button btsave;
Button btRetrieve;
SharedPreferences mypref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txFirstName=findViewById(R.id.txFirstName);
        etfirts=findViewById(R.id.etfirst);
        btsave=findViewById(R.id.btsave);
        btRetrieve=findViewById(R.id.btRetrieve);

       mypref =getSharedPreferences("myShareprefrences",MODE_PRIVATE);
        btsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringmyValue=etfirts.getText().toString();
                SharedPreferences.Editor myEditor =mypref.edit();
                myEditor.putString("myNameFirst",stringmyValue);

                myEditor.apply();

                Toast.makeText(MainActivity.this,"Data saved",Toast.LENGTH_LONG).show();
            }
        });
        btRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myNameFirst=mypref.getString("myNameFirst","no_Value");
                txFirstName.setText(myNameFirst);


            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        myNameFirst=mypref.getString("myNameFirst","no_Value");
        txFirstName.setText(myNameFirst);

    }
}

