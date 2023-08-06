package com.example.temperatureconverterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button convert,reset;
    TextView ans;
    EditText val;
    RadioButton ctf,ftc;
    Double x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        convert=(Button)findViewById(R.id.convertBtn);
        ans=(TextView)findViewById(R.id.output);
        val=(EditText)findViewById(R.id.input);
        ctf=(RadioButton)findViewById(R.id.CtoF);
        ftc=(RadioButton)findViewById(R.id.FtoC);
        reset=(Button)findViewById(R.id.resetBtn);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(val.getText().toString().isEmpty()){
                    ans.setText("Give Temperature");
                }
                else{
                    x=Double.parseDouble(String.valueOf(val.getText()));
                    if(ctf.isChecked()){
                        x=(x*9)/5+32;
                        x=Double.parseDouble(new DecimalFormat("##.###").format(x));
                        ans.setText(String.valueOf(x)+"°F");
                    }
                    else if(ftc.isChecked()){
                        x=(x-32)*5/9;
                        x=Double.parseDouble(new DecimalFormat("##.###").format(x));
                        ans.setText(String.valueOf(x)+"°C");
                    }
                    else{
                        ans.setText("Please select an option");
                    }
                }
            }
        });

        reset.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans.setText("0.0");
                val.setText("");
                ctf.setChecked(false);
                ftc.setChecked(false);

            }
        }));
    }
}