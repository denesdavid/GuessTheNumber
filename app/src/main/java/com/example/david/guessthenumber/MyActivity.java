package com.example.david.guessthenumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends AppCompatActivity {

    private EditText number;
    private Button newgame,ok;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        number=(EditText)findViewById(R.id.txtNumber);
        newgame=(Button)findViewById(R.id.BTNewGame);
        ok=(Button)findViewById(R.id.BTOK);
        result=(TextView)findViewById(R.id.txtResult);
    }
}
