package com.example.david.guessthenumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends AppCompatActivity {

    private EditText number;
    private EditText txtarea;
    private Button newgame,ok,set,exit;
    private TextView result;
    private int TheNumber;
    public int area=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        number=(EditText)findViewById(R.id.txtNumber);
        txtarea=(EditText)findViewById(R.id.txtArea);
        newgame=(Button)findViewById(R.id.BTNewGame);
        ok=(Button)findViewById(R.id.BTOK);
        set=(Button)findViewById(R.id.BTSet);
        exit=(Button)findViewById(R.id.BTExit);
        result=(TextView)findViewById(R.id.txtResult);
        TheNumber=GenerateNumber();

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int guess = Integer.parseInt(number.getText().toString());
                if (guess == TheNumber)
                {
                    ok.setEnabled(false);
                    result.setText("Congrats!");
                }
                else {
                    if (guess < TheNumber) {
                        result.setText("The number is GREATER than your tip!");
                    }
                    if (guess > TheNumber) {
                        result.setText("The number is SMALLER than your tip!");
                    }
                }
            }
        });

        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number.setText("");
                result.setText("");
                TheNumber = GenerateNumber();
                ok.setEnabled(true);
            }
        });
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                area=Integer.parseInt(txtarea.getText().toString());
                ok.setEnabled(false);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }

    private int GenerateNumber()
    {
        return (int)(Math.random()*area+1);
    }
}
