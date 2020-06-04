package com.example.test2.ui.slideshow;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.test2.R;
import com.example.test2.model.hoadon;
import com.example.test2.model.hoadonAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    private ListView lvhoadon;
    List<hoadon> arrhoadon;
    hoadonAdapter adapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        slideshowViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText("");
            }
        });
        lvhoadon =(ListView) root.findViewById(R.id.listviewhoadon);
        arrhoadon = new ArrayList<hoadon>();
        adapter = new hoadonAdapter(getActivity(),R.layout.dong_hoa_don,arrhoadon);
        lvhoadon.setAdapter(adapter);
        //hoadon h1=new hoadon(1,1,1,100000,10000,new Date(2019,1,1),"Hoàng quốc việt");
        //arrhoadon.add(h1);
        new getURL().execute("http://35.198.237.116/api/lichsumuahang/13");
        String s= "[\n" +
                "    {\n" +
                "        \"mahoadon\": 29,\n" +
                "        \"tencuahang\": \"Café Mộc\",\n" +
                "        \"diachi\": \"234, Hoàng Quốc Việt, Cổ Nhuế 1, Bắc Từ Liêm, Hà Nội\",\n" +
                "        \"tongtien\": 11.0,\n" +
                "        \"ngaymua\": \"2020-06-03T23:52:47.000+00:00\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"mahoadon\": 30,\n" +
                "        \"tencuahang\": \"Café Mộc\",\n" +
                "        \"diachi\": \"234, Hoàng Quốc Việt, Cổ Nhuế 1, Bắc Từ Liêm, Hà Nội\",\n" +
                "        \"tongtien\": 11.0,\n" +
                "        \"ngaymua\": \"2020-06-03T23:53:41.000+00:00\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"mahoadon\": 31,\n" +
                "        \"tencuahang\": \"Café Mộc\",\n" +
                "        \"diachi\": \"234, Hoàng Quốc Việt, Cổ Nhuế 1, Bắc Từ Liêm, Hà Nội\",\n" +
                "        \"tongtien\": 11.0,\n" +
                "        \"ngaymua\": \"2020-06-03T23:55:28.000+00:00\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"mahoadon\": 32,\n" +
                "        \"tencuahang\": \"Café Mộc\",\n" +
                "        \"diachi\": \"234, Hoàng Quốc Việt, Cổ Nhuế 1, Bắc Từ Liêm, Hà Nội\",\n" +
                "        \"tongtien\": 11.0,\n" +
                "        \"ngaymua\": \"2020-06-03T23:57:45.000+00:00\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"mahoadon\": 33,\n" +
                "        \"tencuahang\": \"Café Mộc\",\n" +
                "        \"diachi\": \"234, Hoàng Quốc Việt, Cổ Nhuế 1, Bắc Từ Liêm, Hà Nội\",\n" +
                "        \"tongtien\": 11.0,\n" +
                "        \"ngaymua\": \"2020-06-04T00:01:00.000+00:00\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"mahoadon\": 34,\n" +
                "        \"tencuahang\": \"Café Mộc\",\n" +
                "        \"diachi\": \"234, Hoàng Quốc Việt, Cổ Nhuế 1, Bắc Từ Liêm, Hà Nội\",\n" +
                "        \"tongtien\": 11.0,\n" +
                "        \"ngaymua\": \"2020-06-04T00:02:29.000+00:00\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"mahoadon\": 35,\n" +
                "        \"tencuahang\": \"Café Mộc\",\n" +
                "        \"diachi\": \"234, Hoàng Quốc Việt, Cổ Nhuế 1, Bắc Từ Liêm, Hà Nội\",\n" +
                "        \"tongtien\": 11.0,\n" +
                "        \"ngaymua\": \"2020-06-04T00:02:57.000+00:00\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"mahoadon\": 36,\n" +
                "        \"tencuahang\": \"Café Mộc\",\n" +
                "        \"diachi\": \"234, Hoàng Quốc Việt, Cổ Nhuế 1, Bắc Từ Liêm, Hà Nội\",\n" +
                "        \"tongtien\": 50000.0,\n" +
                "        \"ngaymua\": \"2020-06-04T00:05:24.000+00:00\"\n" +
                "    }\n" +
                "]";
        JSONArray jsonArray;
        try {
            jsonArray = new JSONArray(s);
            for(int i=0;i<jsonArray.length();i++)
            {
                hoadon hd=new hoadon();
                JSONObject object=jsonArray.getJSONObject(i);
                hd.setId(object.getInt("mahoadon"));
                hd.setDiachi(object.getString("diachi"));
                hd.setSotiennhan(object.getDouble("tongtien"));
                hd.setSotientralai(0);
                hd.setNgaymua(object.getString("ngaymua"));
                arrhoadon.add(hd);
            }
            adapter.notifyDataSetChanged();
        } catch (JSONException | ParseException e) {
            e.printStackTrace();
        }


        return root;
    }
    class getURL extends AsyncTask<String,Void,String>
    {
        OkHttpClient client=new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15,TimeUnit.SECONDS)
                .readTimeout(15,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
        @Override
        protected String doInBackground(String... strings) {
            Request.Builder builder = new Request.Builder();
            builder.url(strings[0]);
            Request request=builder.build();
            try {
                Response response= client.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            if(!s.equals(""))
            {
                try {
                    JSONArray jsonArray=new JSONArray(s);
                    for(int i=0;i<jsonArray.length();i++)
                    {
                        hoadon hd=new hoadon();
                        JSONObject object=jsonArray.getJSONObject(i);
                        hd.setId(object.getInt("mahoadon"));
                        hd.setDiachi(object.getString("diachi"));
                        hd.setSotiennhan(object.getDouble("tongtien"));
                        hd.setSotientralai(0);
                        hd.setNgaymua(object.getString("ngaymua"));
                        arrhoadon.add(hd);
                    }
                    adapter.notifyDataSetChanged();
                } catch (JSONException | ParseException e) {
                    e.printStackTrace();
                }

            }

            super.onPostExecute(s);
        }
    }

}