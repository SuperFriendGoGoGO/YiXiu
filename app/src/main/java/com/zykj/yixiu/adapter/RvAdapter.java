package com.zykj.yixiu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.zykj.yixiu.R;
import com.zykj.yixiu.widget.MyRVitem;

import java.util.List;

/**
 * Created by zykj on 2017/4/19.
 */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.Myholder> {
    private Context context;
  private List <MyRVitem>list;
    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view= View.inflate(context, R.layout.tool_rsview,null);
        Myholder myholder=new Myholder(view);
        return myholder;
    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {
        holder.tv_zhonglei.setText(list.get(position).getTv_zhonglei());
        holder.tv_address.setText(list.get(position).getTv_dizhi());
        holder.tv_time.setText(list.get(position).getTv_time());
        holder.tv_time2.setText(list.get(position).getTv_shijian());


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class Myholder extends RecyclerView.ViewHolder{
        TextView tv_zhonglei,tv_time,tv_time2,tv_address;
        Button bt_chongfa,bt_shanchu,bt_xiangqing;
        public Myholder(View itemView) {
            super(itemView);
            tv_zhonglei= (TextView) itemView.findViewById(R.id.tv_zhonglei);
            tv_time= (TextView) itemView.findViewById(R.id.tv_time);
            tv_time2= (TextView) itemView.findViewById(R.id.tv_time2);
            tv_address= (TextView) itemView.findViewById(R.id.tv_address);
            bt_chongfa= (Button) itemView.findViewById(R.id.bt_chongfa);
            bt_shanchu= (Button) itemView.findViewById(R.id.bt_shanchu);
            bt_xiangqing= (Button) itemView.findViewById(R.id.bt_chakan);

        }
    }
}
