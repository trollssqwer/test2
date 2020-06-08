package com.example.test2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.example.test2.model.mathang;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import com.example.test2.ui.home.HomeFragment;

import static com.example.test2.ui.home.HomeFragment.listURL;

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
//
        new DownLoadImageTask(holder.imgProduct).execute(listURL.get(position).toString());
        holder.priceProduct.setText(String.valueOf(currentProdcut.getGia()));
        holder.nameProduct.setText(currentProdcut.getTenhang());
        holder.desProduct.setText(currentProdcut.getDonvitinh());
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
