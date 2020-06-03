package com.example.test2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.test2.Interface.ItemClickListner;
import com.example.test2.R;
import org.w3c.dom.Text;
import com.example.test2.model.mathang;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{

    public ItemClickListner listner;
    public List<mathang> listA;

    public ProductViewHolder(View itemView)
    {
        super(itemView);
        listA = new List<mathang>() {
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
        mathang a=new mathang(1,"Cốc",10000,"Capuchino");
        mathang b=new mathang(2, "Chai", 1000, "Trà sữa");

        listA.add(a);
        listA.add(b);


    }

    public void setItemClickListner(ItemClickListner listner)
    {
        this.listner = listner;
    }

    @Override
    public void onClick(View view)
    {
        listner.onClick(view, getAdapterPosition(), false);
    }
}
