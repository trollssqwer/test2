package com.example.test2;
import  com.example.test2.model.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ProductItem extends AppCompatActivity {
    private TextView ProductNamex , ProductPrice ,ProductDescrption;
    private ImageView ProductImage;
    List<mathang> list = new List<mathang>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(@Nullable Object o) {
            return false;
        }

        @NonNull
        @Override
        public Iterator<mathang> iterator() {
            return null;
        }

        @NonNull
        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @NonNull
        @Override
        public <T> T[] toArray(@NonNull T[] a) {
            return null;
        }

        @Override
        public boolean add(mathang mathang) {
            return false;
        }

        @Override
        public boolean remove(@Nullable Object o) {
            return false;
        }

        @Override
        public boolean containsAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(@NonNull Collection<? extends mathang> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, @NonNull Collection<? extends mathang> c) {
            return false;
        }

        @Override
        public boolean removeAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public mathang get(int index) {
            return null;
        }

        @Override
        public mathang set(int index, mathang element) {
            return null;
        }

        @Override
        public void add(int index, mathang element) {

        }

        @Override
        public mathang remove(int index) {
            return null;
        }

        @Override
        public int indexOf(@Nullable Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(@Nullable Object o) {
            return 0;
        }

        @NonNull
        @Override
        public ListIterator<mathang> listIterator() {
            return null;
        }

        @NonNull
        @Override
        public ListIterator<mathang> listIterator(int index) {
            return null;
        }

        @NonNull
        @Override
        public List<mathang> subList(int fromIndex, int toIndex) {
            return null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //test brach
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        ProductImage = (ImageView) findViewById(R.id.product_image);
        ProductNamex = (TextView) findViewById(R.id.product_name);
        ProductPrice = (TextView) findViewById(R.id.product_price);
        ProductDescrption = (TextView) findViewById(R.id.product_description);

        ProductImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductItem.this,Cart.class);
                startActivity(intent);
            }
        });
        ProductNamex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductItem.this,Cart.class);
                startActivity(intent);
            }
        });
        mathang a=new mathang(1,"Cốc",10000,"Capuchino");
        mathang b=new mathang(2, "Chai", 1000, "Trà sữa");

        list.add(a);
        list.add(b);
    }
}