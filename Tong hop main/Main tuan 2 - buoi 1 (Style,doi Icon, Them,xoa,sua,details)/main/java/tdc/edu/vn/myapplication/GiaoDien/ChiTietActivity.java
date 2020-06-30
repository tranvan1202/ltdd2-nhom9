package tdc.edu.vn.myapplication.GiaoDien;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import tdc.edu.vn.myapplication.R;

public class ChiTietActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);
       String ma = getIntent().getExtras().getString("ma");
       setControl();
    }

    private void setControl() {
    }
}
