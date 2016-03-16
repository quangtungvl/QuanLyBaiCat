package com.bbisno.quanlybaicat.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bbisno.quanlybaicat.Models.ChuXe;
import com.bbisno.quanlybaicat.R;

import java.util.ArrayList;

/**
 * Created by voleq_000 on 10/12/2015.
 */
public class ChuXeAdapter extends RecyclerView.Adapter<ChuXeAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ChuXe> listCX;

    public ChuXeAdapter(Context context, ArrayList<ChuXe> list) {
        this.context = context;
        this.listCX = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_item_chuxe, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvTen.setText(listCX.get(position).getTenChuXe());
//        holder.tvSoDT.setText(listCX.get(position).getSoDTChuXe());
        String s = String.valueOf(listCX.get(position).getSoDTChuXe());
        holder.tvSoDT.setText(s);

    }

    @Override
    public int getItemCount() {
        return listCX.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTen, tvSoDT;

        public ViewHolder(View v) {
            super(v);
            tvTen = (TextView) v.findViewById(R.id.row_ChuXe_ten);
            tvSoDT = (TextView) v.findViewById(R.id.row_ChuXe_soDT);
        }
    }
}
