package com.example.test2;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.test2.model.mathang;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import com.example.test2.model.cart;

import static com.example.test2.InformationProduct.listCart;
import static com.example.test2.ui.home.HomeFragment.listURL;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private ArrayList<cart> listHang;
    private OnProductClickLisner Mlisner;
    public interface OnProductClickLisner{
        void OnItemClick(int position);
    }

    public void setOnPruductClickLisner(OnProductClickLisner lisner){
        Mlisner =lisner;

    }

    public  static class CartViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgProduct;
        private TextView nameProduct;
        private TextView desProduct;
        private TextView priceProduct;
        public CartViewHolder(View itemView, final OnProductClickLisner lisner){
            super(itemView);
            imgProduct = itemView.findViewById(R.id.image_cart);
            nameProduct = itemView.findViewById(R.id.name_cart);
            desProduct = itemView.findViewById(R.id.price_cart);
            priceProduct = itemView.findViewById(R.id.count_cart);
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

    public CartAdapter(ArrayList<cart> list){
        listHang = list;
    }
    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_cartview,parent,false);
        CartViewHolder pvh = new CartViewHolder(v,Mlisner);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        cart currentProdcut = listHang.get(position);
        //holder.imgProduct.setImageResource(R.drawable.ic_launcher_background);
        new DownLoadImageTask(holder.imgProduct).execute(listCart.get(position).getAnhHang().toString());
        holder.priceProduct.setText(String.valueOf(currentProdcut.getGiaHang()));
        holder.nameProduct.setText(currentProdcut.getTenHang());
        holder.desProduct.setText(String.valueOf(currentProdcut.getSoluong()));
    }

    @Override
    public int getItemCount() {
        return listHang.size();
    }



    private class DownLoadImageTask extends AsyncTask<String,Void, Bitmap> {
        ImageView imageView;

        public DownLoadImageTask(ImageView imageView){
            this.imageView = imageView;
        }

        /*
            doInBackground(Params... params)
                Override this method to perform a computation on a background thread.
         */
        protected Bitmap doInBackground(String...urls){
            String urlOfImage = urls[0];
            Bitmap logo = null;
            try{
                InputStream is = new URL(urlOfImage).openStream();
                /*
                    decodeStream(InputStream is)
                        Decode an input stream into a bitmap.
                 */
                logo = BitmapFactory.decodeStream(is);
            }catch(Exception e){ // Catch the download exception
                e.printStackTrace();
            }
            return logo;
        }

        /*
            onPostExecute(Result result)
                Runs on the UI thread after doInBackground(Params...).
         */
        protected void onPostExecute(Bitmap result){
            imageView.setImageBitmap(result);
        }
    }

}