package com.example.david.guessthenumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends AppCompatActivity {

    private EditText number;
    private Button newgame,ok;
    private TextView result;
    private int TheNumber;
    private int Probes=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        number=(EditText)findViewById(R.id.txtNumber);
        newgame=(Button)findViewById(R.id.BTNewGame);
        ok=(Button)findViewById(R.id.BTOK);
        result=(TextView)findViewById(R.id.txtResult);
        TheNumber=GenerateNumber();

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int guess = Integer.parseInt(number.getText().toString());
                if (guess == TheNumber)
                {
                    result.setText("Gratulálok! Kitaláltad a számot!");
                }
                else
                {
                    Probes--;
                }
                if(Probes==0)
                {
                    ok.setEnabled(false);
                    result.setText("Nincs lehetőséged tovább találgatni!");
                }
            }
        });
    }

    private int GenerateNumber()
    {
        return (int)Math.random()*10+1;
    }
}
