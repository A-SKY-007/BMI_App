package com.example.bmiapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText editheightF, editheightI, editweight;
        Button button;
        TextView result;
        LinearLayout linearLayout;

        editheightF = findViewById(R.id.edtheightF);
        editheightI = findViewById(R.id.edtheightI);
        editweight = findViewById(R.id.edtweight);
        button = findViewById(R.id.btn);
        result=findViewById(R.id.result);
        linearLayout=findViewById(R.id.main);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double height = Integer.parseInt(editheightF.getText().toString());
                double heightI =Integer.parseInt( editheightI.getText().toString());
                double weight = Integer.parseInt(editweight.getText().toString());
                double HeightM=0.0254*((height*12)+heightI);
                double BMID=weight/(HeightM*HeightM);
                float BMI= (float) BMID;
                result.setText("Your BMI is :"+BMI);

                if(BMI<18.5){
                    linearLayout.setBackgroundColor(getResources().getColor(R.color.Under));
                }
                else if(BMI>=18.5 && BMI<=24.9){
                    linearLayout.setBackgroundColor(getResources().getColor(R.color.Normal));
                }
                else {
                    linearLayout.setBackgroundColor(getResources().getColor(R.color.Over));
                }
            }
        });
    }

}