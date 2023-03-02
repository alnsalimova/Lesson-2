package ru.mirea.salimovaar.buttonclicker;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox checkBox;
    TextView textView;
    int count = 0;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBox = findViewById(R.id.button);
        textView = findViewById(R.id.Text);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count ++;
                if (count % 2 != 0) {
                    textView.setText("Ваш купон: jvsdgvyf345hgg45chg");
                } else {
                    textView.setText("Без галочки не будет скидки");
                }
            }
        });
    }
}