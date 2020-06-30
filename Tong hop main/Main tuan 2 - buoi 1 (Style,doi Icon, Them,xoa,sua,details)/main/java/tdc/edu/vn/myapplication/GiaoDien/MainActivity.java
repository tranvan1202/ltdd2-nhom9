package tdc.edu.vn.myapplication.GiaoDien;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import tdc.edu.vn.myapplication.Adapter.CustomApdapterSV;
import tdc.edu.vn.myapplication.DataBase.DBSinhVien;
import tdc.edu.vn.myapplication.Model.SinhVien;
import tdc.edu.vn.myapplication.R;

public class MainActivity extends AppCompatActivity {
    Button btnNgonNgu, btnThem;
    EditText txtMaSV, txtHoTen, txtDiaChi;
    ListView lvDanhSachSV;
    boolean ngonngu=true;

    CustomApdapterSV apdapter ;
    ArrayList<SinhVien> data_SV = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setConTrol();
        setEvent();
    }

    private void setEvent() {

        HienThiDL();

        btnNgonNgu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ngonngu)
                    btnNgonNgu.setBackgroundResource(R.drawable.vietnam);
                else
                    btnNgonNgu.setBackgroundResource(R.drawable.anh);
                ngonngu =!ngonngu;
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               ThemDL();
               HienThiDL();
            }
        });


    }

    private  void HienThiDL()
    {
        DBSinhVien dbSinhVien = new DBSinhVien(this);
        data_SV = dbSinhVien.LayDL();
        apdapter = new CustomApdapterSV(this,R.layout.listview_item,data_SV);
        lvDanhSachSV.setAdapter(apdapter);
    }

    private  void ThemDL()
    {
        DBSinhVien dbSinhVien = new DBSinhVien(this);

        SinhVien sinhVien = new SinhVien();
        sinhVien.setMaSV(txtMaSV.getText().toString());
        sinhVien.setTenSV(txtHoTen.getText().toString());
        sinhVien.setDiaChi(txtDiaChi.getText().toString());
        dbSinhVien.Them(sinhVien);


    }

    private void setConTrol() {
        btnNgonNgu = findViewById(R.id.btnNgonNgu);
        btnThem = findViewById(R.id.btnThem);
        txtMaSV = findViewById(R.id.txtMa);
        txtHoTen = findViewById(R.id.txtHoTen);
        txtDiaChi = findViewById(R.id.txtDiaChi);
        lvDanhSachSV = findViewById(R.id.lvDanhSach);


    }
}
