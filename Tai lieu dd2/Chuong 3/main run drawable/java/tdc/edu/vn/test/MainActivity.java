package tdc.edu.vn.test;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    boolean running = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setEvent();

    }

    private void setEvent() {
        ImageView cat = (ImageView) findViewById(R.id.imgCat);
        final AnimationDrawable runningCat = (AnimationDrawable) cat.getDrawable();
        cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(running) {
                    runningCat.start();
                }else {
                    runningCat.stop();
                }
                running = !running;
            }
        });
    }
}
