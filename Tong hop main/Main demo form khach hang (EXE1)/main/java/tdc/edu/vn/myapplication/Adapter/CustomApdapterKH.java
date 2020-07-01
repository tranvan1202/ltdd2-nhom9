package tdc.edu.vn.myapplication.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

import tdc.edu.vn.myapplication.GiaoDien.ChiTietActivity;
import tdc.edu.vn.myapplication.Model.KhachHang;
import tdc.edu.vn.myapplication.R;

public class CustomApdapterKH extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<KhachHang> data;
    ArrayList<KhachHang> data_DS;

    public CustomApdapterKH(Context context, int resource, ArrayList<KhachHang> data) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.data = data;
        this.data_DS = new ArrayList<KhachHang>();
        this.data_DS.addAll(data);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    private static class Holder {
        ImageView imgHinh;
        ImageView imgDetail;
        TextView tvHoTen;
        TextView tvDiaChi;
        TextView tvSoDT;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        Holder holder = null;
        if (view == null) {
            holder = new Holder();
            view = LayoutInflater.from(context).inflate(resource, null);
            holder.imgHinh = view.findViewById(R.id.imgHinh);
            holder.imgDetail = view.findViewById(R.id.imgDetail);
            holder.tvHoTen = view.findViewById(R.id.tvHoten);
            holder.tvDiaChi = view.findViewById(R.id.tvDiaChi);
            holder.tvSoDT = view.findViewById(R.id.tvSoDT);
            view.setTag(holder);
        } else
            holder = (Holder) view.getTag();

        final KhachHang khachHang = data.get(position);

        holder.tvHoTen.setText(khachHang.getTenKH());
        holder.tvDiaChi.setText(khachHang.getDiaChi());
        holder.tvSoDT.setText(khachHang.getSoDT());
        holder.imgDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent((Activity) context, ChiTietActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("ma", khachHang.getMaKH());
                intent.putExtras(bundle);
                ((Activity) context).startActivity(intent);


            }
        });


        return view;
    }

    //filter
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        data.clear();
        if (charText.length() == 0) {
            data.addAll(data_DS);
        } else {
            for (KhachHang model : data_DS) {
                if (model.getMaKH().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
                    data.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }

}
