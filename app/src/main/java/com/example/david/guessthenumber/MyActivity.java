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
    private Button newgame,ok,set,exit,about;
    private TextView result;
    private int TheNumber;
    private int Probes=3;
    public int area=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        number=(EditText)findViewById(R.id.txtNumber);
        newgame=(Button)findViewById(R.id.BTNewGame);
        ok=(Button)findViewById(R.id.BTOK);
        set=(Button)findViewById(R.id.BTSet);
        exit=(Button)findViewById(R.id.BTExit);
        about=(Button)findViewById(R.id.BTAbout);
        result=(TextView)findViewById(R.id.txtResult);
        TheNumber=GenerateNumber();

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int guess = Integer.parseInt(number.getText().toString());
                if (guess == TheNumber)
                {
                    ok.setEnabled(false);
                    result.setText("Gratulálok! Kitaláltad a számot!");
                }
                else
                {
                    Probes--;
                    if(guess<TheNumber)
                    {
                        result.setText("A szám nagyobb a tippednél!");
                    }
                    if(guess>TheNumber)
                    {
                        result.setText("A szám kisebb a tippednél!");
                    }

                }
                if(Probes==0)
                {
                    ok.setEnabled(false);
                    result.setText("Nincs lehetőséged tovább találgatni!");
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
                Probes=3;
            }
        });
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a=Integer.parseInt(txtarea.getText().toString());
                area=a;
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
