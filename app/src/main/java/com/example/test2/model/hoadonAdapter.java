package com.example.test2.model;

import android.content.Context;
import android.net.wifi.p2p.WifiP2pManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.test2.R;
import com.example.test2.ViewHolder;
import com.example.test2.ui.slideshow.SlideshowFragment;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.List;

public class hoadonAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<hoadon> hoadonList;

    public hoadonAdapter(Context context, int layout, List<hoadon> hoadonList) {
        this.context = context;
        this.layout = layout;
        this.hoadonList = hoadonList;
    }

    @Override
    public int getCount() {
        return hoadonList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private class ViewHolderHoadon{
        TextView txtDiaChi, txtNgaymua,txtSotien;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderHoadon holder;
        if(convertView==null)
        {
            holder=new ViewHolderHoadon();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(layout,null);
            holder.txtDiaChi=(TextView) convertView.findViewById(R.id.txt_diachi);
            holder.txtNgaymua=(TextView) convertView.findViewById(R.id.txt_ngaymua);
            holder.txtSotien=(TextView) convertView.findViewById(R.id.txt_sotien);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolderHoadon) convertView.getTag();
        }
        hoadon hd= hoadonList.get(position);
        holder.txtDiaChi.setText("Địa chỉ mua:"+hd.getDiachi());
        String date="";
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        date=formatter.format(hd.getNgaymua());
        holder.txtNgaymua.setText("Ngày mua:"+date);
        holder.txtSotien.setText("Tổng tiền:"+String.valueOf(hd.getSotiennhan()-hd.getSotientralai()));
        return convertView;
    }
}

