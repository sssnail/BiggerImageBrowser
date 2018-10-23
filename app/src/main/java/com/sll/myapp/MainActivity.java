package com.sll.myapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.sll.showbiggerimage.ShowImageUtil;
import com.sll.showbiggerimage.TransitionActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView lv_listview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
       lv_listview = (ListView) findViewById(R.id.lv_listview);
       lv_listview.setAdapter(new MyAdapter(this));
    }

    public class MyAdapter extends BaseAdapter
    {
        private LayoutInflater mInflater = null;

        private MyAdapter(Context context)
        {
            this.mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return getData().size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if(convertView == null){
                holder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.item_image, null);
                holder.img = (ImageView)convertView.findViewById(R.id.iv_image);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder)convertView.getTag();
            }
            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ShowImageUtil.show(MainActivity.this,v,v.getTransitionName(), ((BitmapDrawable)((ImageView)v).getDrawable()).getBitmap());
                }
            });
            return convertView;
        }
    }

    private class ViewHolder{
        ImageView img;
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;
        for (int i = 0; i < 10; i++) {
            map = new HashMap<String, Object>();
            map.put("img", R.drawable.bg);
            lists.add(map);
        }
        return lists;
    }


    private Bitmap loadBitmapFromView(View v) {
        int w = v.getWidth();
        int h = v.getHeight();
        Bitmap bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bmp);
        c.drawColor(Color.WHITE);
        /** 如果不设置canvas画布为白色，则生成透明 */
        v.layout(0, 0, w, h);
        v.draw(c);

        return bmp;
    }
}
