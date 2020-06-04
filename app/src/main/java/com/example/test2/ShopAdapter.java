package com.example.test2;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.test2.model.mathang;
import com.example.test2.model.cuahang;
import java.util.ArrayList;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopViewHolder> {
    private ArrayList<cuahang> listCuaHang;
    private OnShopClickLisner Mlisner;
    public interface OnShopClickLisner{
        void OnItemClick(int position);
    }

    public void setOnPruductClickLisner(OnShopClickLisner lisner){
        Mlisner =lisner;

    }

    public  static class ShopViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgProduct;
        private TextView nameProduct;
        private TextView desProduct;
        private TextView priceProduct;
        public ShopViewHolder(View itemView, final OnShopClickLisner lisner){
            super(itemView);
            imgProduct = itemView.findViewById(R.id.shop_image);
            nameProduct = itemView.findViewById(R.id.shop_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(lisner != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            lisner.OnItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public ShopAdapter(ArrayList<cuahang> list){
        listCuaHang = list;
    }
    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_item,parent,false);
        ShopViewHolder pvh = new ShopViewHolder(v,Mlisner);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ShopViewHolder holder, int position) {
        cuahang currentShop = listCuaHang.get(position);
        if(position%2 == 0){
            holder.imgProduct.setImageResource(R.drawable.s1);
        }
        else {
            holder.imgProduct.setImageResource(R.drawable.s2);
        }
        holder.nameProduct.setText(currentShop.getDiachicuahang());

    }

    @Override
    public int getItemCount() {
        return listCuaHang.size();
    }


}