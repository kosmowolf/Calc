package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // Создать объект Button
    Button button_c; //c
    Button button_multiple; //*
    Button button_divide; // /
    Button button_less; // <
    Button button_7; // 7
    Button button_8; //8
    Button button_9; //9
    Button button_minus; // -
    Button button_4; // 4
    Button button_5; // 5
    Button button_6; // 6
    Button button_plus; // +
    Button button_1; // 1
    Button button_2; // 2
    Button button_3; // 3
    Button button_0; // 0
    Button button_point; // .
    Button button_equal; // =
    EditText result;

    // Признак, что поле редактирования текста очищено
    boolean is_clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Создаем экземпляр объекта

        Button button_c = (Button) findViewById(R.id.button_c);
        Button button_multiple = (Button) findViewById(R.id.button_multiple);
        Button button_divide = (Button) findViewById(R.id.button_divide);
        Button button_less = (Button) findViewById(R.id.button_less);
        Button button_7 = (Button) findViewById(R.id.button_7);
        Button button_8 = (Button) findViewById(R.id.button_8);
        Button button_9 = (Button) findViewById(R.id.button_9);
        Button button_minus = (Button) findViewById(R.id.button_minus);
        Button button_4 = (Button) findViewById(R.id.button_4);
        Button button_5 = (Button) findViewById(R.id.button_5);
        Button button_6 = (Button) findViewById(R.id.button_6);
        Button button_plus = (Button) findViewById(R.id.button_plus);
        Button button_1 = (Button) findViewById(R.id.button_1);
        Button button_2 = (Button) findViewById(R.id.button_2);
        Button button_3 = (Button) findViewById(R.id.button_3);
        Button button_0 = (Button) findViewById(R.id.button_0);
        Button button_point = (Button) findViewById(R.id.button_point);
        Button button_equal = (Button) findViewById(R.id.button_equal);
        EditText result = (EditText) findViewById(R.id.editText);
        System.out.println(result.length());

        // Устанавливаем объект нажатия на кнопку

        button_c.setOnClickListener(this);
        button_multiple.setOnClickListener(this);
        button_divide.setOnClickListener(this);
        button_less.setOnClickListener(this);
        button_7.setOnClickListener(this);
        button_8.setOnClickListener(this);
        button_9.setOnClickListener(this);
        button_minus.setOnClickListener(this);
        button_4.setOnClickListener(this);
        button_5.setOnClickListener(this);
        button_6.setOnClickListener(this);
        button_plus.setOnClickListener(this);
        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        button_0.setOnClickListener(this);
        button_point.setOnClickListener(this);
        button_equal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String str = result.getText().toString();
        switch (v.getId()) {
            case R.id.button_0:
            case R.id.button_1:
            case R.id.button_2:
            case R.id.button_3:
            case R.id.button_4:
            case R.id.button_5:
            case R.id.button_6:
            case R.id.button_7:
            case R.id.button_8:
            case R.id.button_9:
                if (result.length() == 0) {

                    str = "";
                    result.setText("");

                }

                result.setText(str + ((Button) v).getText());
                break;


            case R.id.button_point:
                if (result.length() == 0) {
                    return;
                } else {
                    Log.d("homework_3", "aaa");
                    result.setText(str + ((Button) v).getText());
                    break;
                }
            case R.id.button_less:
                if (is_clear) {
                    is_clear = false;
                    str = "";
                    result.setText("");
                } else if (str != null && !str.equals("")) {
                    result.setText(str.substring(0, str.length() - 1));
                }
                break;

            case R.id.button_plus:
            case R.id.button_minus:
            case R.id.button_multiple:
            case R.id.button_divide:
                if (result.length() == 0) {
                    str = "";
                    result.setText("");
                }
                result.setText(str + " " + ((Button) v).getText() + " ");
                break;

            case R.id.button_c:
                is_clear = false;
                result.setText("");
            case R.id.button_equal:
                Log.d("homework_3", "=");
                getResult();
                break;
        }

    }

    private void getResult() {
        String exp = result.getText().toString();
        if (exp == null || exp.equals("")) {
            return;
        }
        if (!exp.contains(" ")) {
            return;
        }
        if (is_clear) {
            is_clear = false;
            return;
        }
        is_clear = true;
        double Result = 0;
        // public int indexof (INT CH): возвращает индекс первого появления в строке
        String s1 = exp.substring(0, exp.indexOf(" "));// Find the first number
        Log.d("homework_3", s1);
        String op = exp.substring(exp.indexOf(" ") + 1, exp.indexOf(" ") + 2);// Найти оператор
        Log.d("homework_3", op);
        String s2 = exp.substring(exp.indexOf(" ") + 3);// найти 2 номер
        Log.d("homework_3", s2);
        if (!s1.equals(" ") && !s2.equals(" ")) {
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);
            if (op.equals("+")) {
                Result = d1 + d2;
                String o = String.valueOf(Result);
                Log.d("homework_3", o);
                result.setText(o);
                return;
            } else if (op.equals("-")) {
                Result = d1 - d2;
                String o = String.valueOf(Result);
                Log.d("homework_3", o);
                result.setText(o);
                return;
            } else if (op.equals("*")) {
                Result = d1 * d2;
                String o = String.valueOf(Result);
                Log.d("homework_3", o);
                result.setText(o);
                return;
            } else if (op.equals("/")) {
                Result = d1 / d2;
                String o = String.valueOf(Result);
                Log.d("homework_3", o);
                result.setText(o);
                return;
            }

        }
    }


}