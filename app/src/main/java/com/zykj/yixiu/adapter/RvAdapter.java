package com.zykj.yixiu.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zykj on 2017/4/19.
 */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.Myholder> {
    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
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
