package com.example.equation_0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.sqrt;


public class MainActivity extends AppCompatActivity {

    EditText a, b, c;
    TextView ans;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        ans = findViewById(R.id.answer_ID);
        btn = findViewById(R.id.ok_ID);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double a_val = Double.parseDouble(a.getText().toString());
                    double b_val = Double.parseDouble(b.getText().toString());
                    double c_val = Double.parseDouble(c.getText().toString());
                    ans.setText(equation(a_val, b_val, c_val));
                } catch (Exception e) {
                    ans.setText(e.getMessage());
                    Log.println(Log.ERROR, "User Input", e.getMessage());
                }
            }
        });
    }

    public String equation (double a, double b, double c){
        double D=b*b-4*a*c, x1, x2;
        if (a==0){
            if (b != 0){
                x1 = -c/b;
                x1 = ((int)(x1 * 100000))/100000.;
                return "x = " + x1;
            }
            else if (c != 0) return "x ∈ ø";
            else return "x ∈ R";
        }else if (D < 0){
            return "x ∈ C";
        } else {
            x1 = (-b+sqrt(D))/(2*a);
            x2 = (-b-sqrt(D))/(2*a);
            x1 = ((int)(x1 * 100000))/100000.;
            x2 = ((int)(x2 * 100000))/100000.;
            return "x1 = " + x1 + "\nx2 = " + x2;
        }
    }

}
