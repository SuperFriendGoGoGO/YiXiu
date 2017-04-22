package com.zykj.yixiu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;

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
        return null;
    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class Myholder extends RecyclerView.ViewHolder{
        public Myholder(View itemView) {
            super(itemView);
        }
    }
}
