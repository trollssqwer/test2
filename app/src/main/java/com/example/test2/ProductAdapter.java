package com.example.test2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.example.test2.model.mathang;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private ArrayList<mathang> listHang;
    private OnProductClickLisner Mlisner;
    public interface OnProductClickLisner{
        void OnItemClick(int position);
    }

    public void setOnPruductClickLisner(OnProductClickLisner lisner){
        Mlisner =lisner;

    }

    public  static class ProductViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgProduct;
        private TextView nameProduct;
        private TextView desProduct;
        private TextView priceProduct;
        public ProductViewHolder(View itemView, final OnProductClickLisner lisner){
            super(itemView);
            imgProduct = itemView.findViewById(R.id.product_image);
            nameProduct = itemView.findViewById(R.id.product_name);
            desProduct = itemView.findViewById(R.id.product_description);
            priceProduct = itemView.findViewById(R.id.product_price);
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

    public ProductAdapter(ArrayList<mathang> list){
        listHang = list;
    }
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item,parent,false);
        ProductViewHolder pvh = new ProductViewHolder(v,Mlisner);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        mathang currentProdcut = listHang.get(position);
        String id="R.drawble"+String.valueOf(currentProdcut.getId());

        holder.imgProduct.setImageResource(R.drawable.mh1);
        holder.priceProduct.setText(String.valueOf(currentProdcut.getGia()));
        holder.nameProduct.setText(currentProdcut.getTenhang());
        holder.desProduct.setText(currentProdcut.getTenhang());
    }

    @Override
    public int getItemCount() {
        return listHang.size();
    }


}
