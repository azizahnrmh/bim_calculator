// MainActivity.java
package com.ubl.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etAge, etHeight, etWeight;
    private RadioGroup rgGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAge = findViewById(R.id.etAge);
        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
        rgGender = findViewById(R.id.rgGender);
        Button btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String ageStr = etAge.getText().toString();
        String heightStr = etHeight.getText().toString();
        String weightStr = etWeight.getText().toString();

        if (ageStr.isEmpty() || heightStr.isEmpty() || weightStr.isEmpty() || rgGender.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        int age = Integer.parseInt(ageStr);
        float height = Float.parseFloat(heightStr) / 100; // convert cm to meters
        float weight = Float.parseFloat(weightStr);
        float bmi = weight / (height * height);

        String gender = ((RadioButton) findViewById(rgGender.getCheckedRadioButtonId())).getText().toString();

        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("BMI_RESULT", bmi);
        intent.putExtra("AGE", age);
        intent.putExtra("GENDER", gender);
        startActivity(intent);
    }
}
