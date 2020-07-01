package tdc.edu.vn.myapplication.GiaoDien;

//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import tdc.edu.vn.myapplication.Adapter.CustomApdapterKH;
import tdc.edu.vn.myapplication.DataBase.DBKhachHang;
import tdc.edu.vn.myapplication.Model.KhachHang;
import tdc.edu.vn.myapplication.R;

public class MainActivity extends AppCompatActivity {
    Button btnNgonNgu, btnThem;
    EditText txtMaKH, txtHoTen, txtDiaChi, txtSoDT;
    ListView lvDanhSachKH;
    boolean ngonngu=true;

    CustomApdapterKH apdapter ;
    ArrayList<KhachHang> data_KH = new ArrayList<>();

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
        DBKhachHang dbKhachHang = new DBKhachHang(this);
        data_KH = dbKhachHang.LayDL();
        apdapter = new CustomApdapterKH(this,R.layout.listview_item,data_KH);
        lvDanhSachKH.setAdapter(apdapter);
    }

    private  void ThemDL()
    {
        DBKhachHang dbKhachHang = new DBKhachHang(this);

        KhachHang khachHang = new KhachHang();
        khachHang.setMaKH(txtMaKH.getText().toString());
        khachHang.setTenKH(txtHoTen.getText().toString());
        khachHang.setDiaChi(txtDiaChi.getText().toString());
        khachHang.setSoDT(txtSoDT.getText().toString());
        dbKhachHang.Them(khachHang);


    }

    private void setConTrol() {
        btnNgonNgu = findViewById(R.id.btnNgonNgu);
        btnThem = findViewById(R.id.btnThem);
        txtMaKH = findViewById(R.id.txtMa);
        txtHoTen = findViewById(R.id.txtHoTen);
        txtDiaChi = findViewById(R.id.txtDiaChi);
        txtSoDT = findViewById(R.id.txtSoDT);
        lvDanhSachKH = findViewById(R.id.lvDanhSach);


    }
}
