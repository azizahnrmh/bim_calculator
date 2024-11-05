package com.ubl.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView tvBMIResult = findViewById(R.id.tvBMIResult);
        TextView tvBMICategory = findViewById(R.id.tvBMICategory);
        TextView tvGender = findViewById(R.id.tvGender);
        TextView tvAge = findViewById(R.id.tvAge);
        Button buttonBack = findViewById(R.id.button_back); // Ambil tombol "Back"

        // Get data from Intent
        float bmi = getIntent().getFloatExtra("BMI_RESULT", 0);
        int age = getIntent().getIntExtra("AGE", 0);
        String gender = getIntent().getStringExtra("GENDER");

        // Set values
        tvBMIResult.setText(String.format("Your BMI: %.2f", bmi));
        tvGender.setText(String.format("Gender: %s", gender));
        tvAge.setText(String.format("Age: %d", age));

        // Determine BMI Category
        String bmiCategory;
        if (bmi < 18.5) {
            bmiCategory = "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            bmiCategory = "Normal weight";
        } else if (bmi >= 25 && bmi <= 29.9) {
            bmiCategory = "Overweight";
        } else {
            bmiCategory = "Obesity";
        }

        tvBMICategory.setText(String.format("BMI Category: %s", bmiCategory));

        // Set OnClickListener untuk tombol "Back"
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Menyelesaikan ResultActivity dan kembali ke MainActivity
            }
        });
    }
}
