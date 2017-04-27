package com.zykj.yixiu.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.zykj.yixiu.R;
import com.zykj.yixiu.utils.DingDan;

import java.util.List;

/**
 * Created by zykj on 2017/4/27.
 */

public class LVAdapter extends BaseAdapter {
    Context context;
    List<DingDan> list;

    public LVAdapter(Context context, List<DingDan> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHolder myHolder = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.activity_administration, null);
            myHolder = new MyHolder();
            convertView.setTag(myHolder);
        } else {
            convertView.getTag();
            myHolder.tv_dizhi = (TextView) convertView.findViewById(R.id.tv_dizhi);
            myHolder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            myHolder.tv_number = (TextView) convertView.findViewById(R.id.tv_number);
            myHolder.bt_bianji = (Button) convertView.findViewById(R.id.bt_bianji);
            myHolder.bt_shanchu = (Button) convertView.findViewById(R.id.bt_shanchu);

        }
        myHolder.tv_name.setText(list.get(position).getName());
        myHolder.tv_number.setText(list.get(position).getNumber());
        myHolder.tv_dizhi.setText(list.get(position).getDizhi());
        return convertView;
    }
}

class MyHolder {
    TextView tv_name, tv_number, tv_dizhi;
    Button bt_bianji, bt_shanchu;
}
