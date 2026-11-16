package com.websarva.wings.android.ex0302;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnCalc = findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etValue1 = findViewById(R.id.etValue1);
                EditText etValue2 = findViewById(R.id.etValue2);
                Spinner spOperator = findViewById(R.id.spOperator);
                String value1 = etValue1.getText().toString();
                String value2 = etValue2.getText().toString();
                String operator = spOperator.getSelectedItem().toString();
                String expression;

                if (value1.isEmpty() || value2.isEmpty()) {
                    expression = "計算エラー";
                } else {
                    int ret = 0;
                    int num1 = Integer.parseInt(value1);
                    int num2 = Integer.parseInt(value2);

                    switch (operator) {
                        case "+":
                            ret = num1 + num2;
                            break;
                        case "-":
                            ret = num1 - num2;
                            break;
                        case "*":
                            ret = num1 * num2;
                            break;
                        case "/":
                            ret = num1 / num2;
                            break;
                    }
                    expression = value1 + operator + value2 + "=" + ret;
                }

                TextView tvResult = findViewById(R.id.tvResult);
                tvResult.setText(expression);
            }
        });
    }
}
