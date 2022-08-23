package com.example.concatnamedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2,e3;
    Button b1,b2;
    RadioGroup r1,r2;
    RadioButton rb1,rb2;
    CheckBox c1,c2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        e3 = (EditText) findViewById(R.id.e3);

        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);

        r1 = (RadioGroup) findViewById(R.id.rg);
        r2 = (RadioGroup) findViewById(R.id.rg1);

        c1 = (CheckBox) findViewById(R.id.c1);
        c2 = (CheckBox) findViewById(R.id.c2);


        //change format

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();

                String s3 = s1 + s2;
                e3.setText(s3);

                int select1 = r1.getCheckedRadioButtonId();
                rb1 = (RadioButton) findViewById(select1);

                if(rb1.getText().toString().equals("Monospace"))
                {
                    e3.setTypeface(Typeface.MONOSPACE);
                }
                else if(rb1.getText().toString().equals("Sans_serif"))
                {
                    e3.setTypeface(Typeface.SANS_SERIF);
                }
                else if(rb1.getText().toString().equals("Serif"))
                {
                    e3.setTypeface(Typeface.SERIF);
                }


                //color

                int select2 = r2.getCheckedRadioButtonId();
                rb2 = (RadioButton) findViewById(select2);

                if(rb2.getText().toString().equals("Red"))
                {
                    e3.setTextColor(getResources().getColor(R.color.red));
                }
                else if(rb2.getText().toString().equals("Blue"))
                {
                    e3.setTextColor(getResources().getColor(R.color.purple_700));
                }
                else if(rb2.getText().toString().equals("Green"))
                {
                    e3.setTextColor(getResources().getColor(R.color.teal_700));
                }

                //checked bold

                if(c1.isChecked())  //bold
                {
                    if(c2.isChecked())
                    {
                        e3.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD_ITALIC));
                    }
                    else
                    {
                        e3.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                    }
                }

                else if(c2.isChecked())
                {
                    if(c1.isChecked())
                    {
                        e3.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD_ITALIC));
                    }
                    else
                    {
                        e3.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
                    }
                }

                else
                {
                    e3.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                }

            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("");
                e2.setText("");
                e3.setText("");
                finish();
            }
        });

    }
}