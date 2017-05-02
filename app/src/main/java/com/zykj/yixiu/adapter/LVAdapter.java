package com.zykj.yixiu.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zykj.yixiu.R;
import com.zykj.yixiu.utils.Address;
import com.zykj.yixiu.utils.Y;

import org.xutils.http.RequestParams;

import java.util.List;

/**
 * Created by zykj on 2017/4/27.
 */

public class LVAdapter extends BaseAdapter {
    Context context;
    List<Address> list;

    public LVAdapter(Context context, List<Address> list) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
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
        //设置数据
       final Address a=list.get(position);
        myHolder.tv_name.setText(a.getName());
        myHolder.tv_number.setText(a.getPhone());
        myHolder.tv_dizhi.setText(a.getAddress());
        //选择默认事件
        myHolder.iv_moren.setTag(a.getAddress_id());//把ID 捆绑到itemAddressBtShanchu 控件上
        myHolder.iv_moren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestParams params = new RequestParams("http://221.207.184.124:7071/yxg/defAddress");
                params.addBodyParameter("user_id",a.getUser_id()+"");
                params.addBodyParameter("address_id",a.getAddress_id()+"");
                Y.post(params, new Y.MyCommonCall<String>() {
                    @Override
                    public void onSuccess(String result) {
                        if(Y.getRespCode(result)) {
                            for (int i = 0; i < list.size(); i++) {
                                if (i == position) {  //需要勾选的位置
                                    list.get(i).setIsdefault(1);
                                } else {  //取消勾选
                                    list.get(i).setIsdefault(0);
                                }
                            }
                            notifyDataSetChanged();//刷新列表
                        }
                    }
                });




            }
        });



        //删除
        myHolder.bt_shanchu.setTag(a.getAddress_id());//把ID 捆绑到itemAddressBtShanchu 控件上
        myHolder.bt_shanchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestParams params = new RequestParams("http://221.207.184.124:7071/yxg/defAddress");
                params.addBodyParameter("user_id",a.getUser_id()+"");
                params.addBodyParameter("address_id",a.getAddress_id()+"");
            Y.post(params, new Y.MyCommonCall<String>() {
                @Override
                public void onSuccess(String result) {
                    if(Y.getRespCode(result)){
                        Y.t("删除成功");
                        list.remove(position);// 删除数据源得到数据
                        notifyDataSetChanged();  //刷新列表
                    }
                }
            });


            }
        });

        return convertView;
    }

}

class MyHolder {
    TextView tv_name, tv_number, tv_dizhi;
    Button bt_bianji, bt_shanchu;
    ImageView iv_moren;
}
