package com.example.cart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.cart.bean.Phone;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by haocheng on 17/11/24.
 */

public class StoreActivity extends AppCompatActivity{

    GridView gv_item_store;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        gv_item_store = (GridView) findViewById(R.id.gv_item_store);
    }

    class GridAdapter extends BaseAdapter {
        ArrayList<Phone> phones = MainActivity.phones;

        @Override
        public int getCount() {
            return phones.size();
        }

        @Override
        public Object getItem(int i) {
            return phones.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
            View view = inflater.inflate(R.layout.grid_item_store,null);
            TextView tv_item_name = (TextView) view.findViewById(R.id.tv_item_name);
            ImageButton btn_item_img = (ImageButton) view.findViewById(R.id.btn_item_img);
            TextView tv_item_price = (TextView) view.findViewById(R.id.tv_item_price);
            tv_item_name.setText(phones.get(i).Name);
            btn_item_img.setImageResource(phones.get(i).ImgSrc);
            tv_item_price.setText(phones.get(i).Price.toString());
            return view;
        }
    }
}
