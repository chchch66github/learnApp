package com.example.cart;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cart.bean.Phone;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView lv_cart_item;
    ArrayList<Phone> phones = new ArrayList();
    Phone iphone6 = new Phone(R.drawable.iphone6,"iphone6",8000.0);
    Phone meizu = new Phone(R.drawable.meizu,"meizu",4200.0);
    Phone oppo = new Phone(R.drawable.oppo,"oppo",3600.0);
    Phone huawei = new Phone(R.drawable.huawei,"huawei",2200.0);
    Phone vivo = new Phone(R.drawable.vivo,"vivo",3100.0);
    Phone xiaomi = new Phone(R.drawable.xiaomi,"xiaomi",3000.0);

//    String[] strings = {"a","b","c"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        lv_cart_item = (ListView) findViewById(R.id.lv_cart_item);
        phones.add(iphone6);
        phones.add(meizu);
        phones.add(oppo);
        phones.add(huawei);
        phones.add(vivo);
        phones.add(xiaomi);
        BaseAdapter adapter_cart_item = new CartItemAdapter(getApplicationContext());
        lv_cart_item.setAdapter(adapter_cart_item);



    }


    class CartItemAdapter extends BaseAdapter {

        private Context mContext;
        public CartItemAdapter(Context mContext){
            super();
            this.mContext = mContext;

        }

        @Override
        public int getCount() {
            return phones.size();
//            return strings.length;
        }

        @Override
        public Object getItem(int i) {
            return phones.get(i);
//            return strings[i];
        }


        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            View view = inflater.inflate(R.layout.list_item_cart,null);
            ImageView iv_item_img = (ImageView) view.findViewById(R.id.iv_item_img);
            TextView tv_item_name = (TextView) view.findViewById(R.id.tv_item_name);
            TextView tv_item_number = (TextView) view.findViewById(R.id.tv_item_number);
            TextView tv_item_price = (TextView) view.findViewById(R.id.tv_item_price);
            TextView tv_item_total = (TextView) view.findViewById(R.id.tv_item_total);

            iv_item_img.setImageResource(phones.get(i).ImgSrc);
            tv_item_name.setText(phones.get(i).Name);

            tv_item_price.setText(phones.get(i).Price.toString());




            return view;
//            TextView textView = new TextView(mContext);
//            textView.setText(strings[i]);
//            return textView;

        }
    }
}
