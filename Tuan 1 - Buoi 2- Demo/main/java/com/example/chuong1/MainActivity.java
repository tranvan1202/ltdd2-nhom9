package com.example.chuong1;



import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnExit, btnSwap;
    boolean checkAc = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }

    private void setEvent() {
        btnSwap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkAc)
                {
                    checkAc = true;
                    btnSwap.setSelected(true);
                }
                else {
                    checkAc = false;
                    btnSwap.setSelected(false);
                }
            }
        });
    }

    private void setControl() {
        btnExit = findViewById(R.id.btnExit);
        btnSwap = findViewById(R.id.btnswap);
    }
}