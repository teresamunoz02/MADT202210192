package com.example.madt202210192;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String oldNumber = "";
    String op = "+";
    boolean isNewOp = true;
    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.editText);
    }

    public void numberEvent(View view) {
        if(isNewOp)
            et1.setText("");
        isNewOp = false;

        String number = et1.getText().toString();
        switch (view.getId()){
            case R.id.buDot:
                number += ".";
                break;
            case R.id.bu0:
                number += "0";
                break;
            case R.id.bu1:
                number += "1";
                break;
            case R.id.bu2:
                number += "2";
                break;
            case R.id.bu3:
                number += "3";
                break;
            case R.id.bu4:
                number += "4";
                break;
            case R.id.bu5:
                number += "5";
                break;
            case R.id.bu6:
                number += "6";
                break;
            case R.id.bu7:
                number += "7";
                break;
            case R.id.bu8:
                number += "8";
                break;
            case R.id.bu9:
                number += "9";
                break;
        }

        et1.setText(number);
    }

    public void operatorEvent(View view) {
        isNewOp = true;
        oldNumber = et1.getText().toString();
        switch (view.getId()){
            case R.id.buDiv:
                op = "/";
                break;
            case R.id.buMult:
                op = "*";
                break;
            case R.id.buPlus:
                op = "+";
                break;
            case R.id.buMinus:
                op = "-";
                break;

        }
    }

    public void equalEvent(View view) {
        String newNumber = et1.getText().toString();
        double result = 0.0;
        switch (op){
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;

        }
        et1.setText(result+"");
    }

    public void clearEvent(View view) {
        et1.setText("0");
        isNewOp = true;
    }

    public void sqrtEvent(View view) {
        double no = Math.sqrt(Double.parseDouble(et1.getText().toString()));
        et1.setText(no+"");
        isNewOp = true;
    }

    public void backEvent(View view) {
        int cursorPos = et1.getSelectionStart();
        int textLen = et1.getText().length();

        if (cursorPos !=0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) et1.getText();
            selection.replace(cursorPos-1, cursorPos, "");
            et1.setText(selection);
            et1.setSelection(cursorPos-1);
        }
    }
}