package tdc.edu.vn.test2;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setEvent();
    }

    private void setEvent() {
        setContentView(R.layout.activity_main);
        final ImageView imMatTroi = findViewById(R.id.imageView);
        imMatTroi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.phonglon);
                imMatTroi.startAnimation(animation);
            }
        });
    }
}
