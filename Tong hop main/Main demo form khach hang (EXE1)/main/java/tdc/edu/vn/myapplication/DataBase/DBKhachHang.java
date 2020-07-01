package tdc.edu.vn.myapplication.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import tdc.edu.vn.myapplication.Model.KhachHang;

public class DBKhachHang {
    DBHelper dbHelper;

    public DBKhachHang(Context context) {
       dbHelper= new DBHelper(context);
    }

    public void Them(KhachHang khachHang)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("makh", khachHang.getMaKH());
        values.put("hoten", khachHang.getTenKH());
        values.put("diachi", khachHang.getDiaChi());
        values.put("sodt", khachHang.getSoDT());
        db.insert("KhachHang",null,values);
    }

    public  void Sua(KhachHang khachHang)
    {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("makh", khachHang.getMaKH());
        values.put("hoten", khachHang.getTenKH());
        values.put("diachi", khachHang.getDiaChi());
        values.put("sodt", khachHang.getSoDT());
        db.update("KhachHang",values,"makh ='"+ khachHang.getMaKH() +"'",null);
    }


    public  void Xoa(KhachHang khachHang)
    {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql ="Delete from KhachHang where makh= '"+ khachHang.getMaKH()+"'";
        db.execSQL(sql);

    }

    public ArrayList<KhachHang> LayDL()
    {
        ArrayList<KhachHang> data = new ArrayList<>();
        String sql="select * from KhachHang";
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);

        try {
            cursor.moveToFirst();
            do {
                KhachHang khachHang = new KhachHang();
                khachHang.setMaKH(cursor.getString(0));
                khachHang.setTenKH(cursor.getString(1));
                khachHang.setDiaChi(cursor.getString(2));
                khachHang.setSoDT(cursor.getString(3));
                data.add(khachHang);
            }
            while (cursor.moveToNext());
        }
        catch (Exception ex)
        {

        }


        return  data;
    }
}
