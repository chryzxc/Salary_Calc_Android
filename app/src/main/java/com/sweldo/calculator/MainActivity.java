package com.sweldo.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextView salary;
    TextInputEditText perDay,t_r_hrs,t_r_ot,t_rd_ot,t_h_ot,t_nd;
    CheckBox regularCheck,traineeCheck,bonusCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        salary = (TextView) findViewById(R.id.salary);

        perDay = (TextInputEditText) findViewById(R.id.perDay);
        t_r_hrs = (TextInputEditText) findViewById(R.id.t_r_hrs);
        t_r_ot = (TextInputEditText) findViewById(R.id.t_r_ot);
        t_rd_ot = (TextInputEditText) findViewById(R.id.t_rd_ot);
        t_h_ot = (TextInputEditText) findViewById(R.id.t_h_ot);
        t_nd = (TextInputEditText) findViewById(R.id.t_nd);

        regularCheck = (CheckBox) findViewById(R.id.regularCheck);
        traineeCheck = (CheckBox) findViewById(R.id.traineeCheck);
        bonusCheck = (CheckBox) findViewById(R.id.bonusCheck);

        regularCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b){
                    t_r_hrs.setText("96");
                    t_r_hrs.setClickable(false);
                    t_r_hrs.setEnabled(false);
                    traineeCheck.setChecked(false);

                }else{
                    t_r_hrs.setText("");
                    t_r_hrs.setClickable(true);
                    t_r_hrs.setEnabled(true);
                }
                computeSalary();

            }
        });

        traineeCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    regularCheck.setChecked(false);
                    t_r_hrs.setText("");
                }
                computeSalary();

            }
        });

        bonusCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                computeSalary();
            }
        });
        perDay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                computeSalary();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });




        t_r_hrs.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                computeSalary();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        t_r_ot.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                computeSalary();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        t_rd_ot.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                computeSalary();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        t_h_ot.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                computeSalary();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        t_nd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                computeSalary();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    public void computeSalary(){
        float regHours = 0;
        float regOt = 0;
        float rdOt = 0;
        float hOt = 0;
        float nd = 0;

        if (!perDay.getText().toString().isEmpty()){
            float perHour;

            if (bonusCheck.isChecked()){
                 perHour = (Float.parseFloat(perDay.getText().toString()) + 50) / 8;

            }else{
                 perHour = Float.parseFloat(perDay.getText().toString()) / 8;

            }




            if (!t_r_hrs.getText().toString().isEmpty()){

                regHours = perHour * Float.parseFloat(t_r_hrs.getText().toString());
            }

            if (!t_r_ot.getText().toString().isEmpty()){

                float val = (float) (Float.parseFloat(perDay.getText().toString()) * 0.25);
                float regHoursOt = (float) ((Float.parseFloat(perDay.getText().toString()) + val) / 8);

                regOt = regHoursOt * Float.parseFloat(t_r_ot.getText().toString());


            }

            if (!t_rd_ot.getText().toString().isEmpty()){
                float val = (float) (Float.parseFloat(perDay.getText().toString()) * 0.30);
                float rdHoursOt = (float) ((Float.parseFloat(perDay.getText().toString())+ val) / 8);

                rdOt = rdHoursOt * Float.parseFloat(t_rd_ot.getText().toString());
            }

            if (!t_h_ot.getText().toString().isEmpty()){


                hOt = perHour * Float.parseFloat(t_h_ot.getText().toString()) * 2;
            }

            if (!t_nd.getText().toString().isEmpty()){


                nd = Float.parseFloat(t_nd.getText().toString()) * 3;
            }


            salary.setText("₱"+String.valueOf(regHours + regOt +rdOt+hOt+nd));

        }else{

            Toast.makeText(MainActivity.this, "Butangi hn salary per day", Toast.LENGTH_SHORT).show();
        }




    }
}