package com.bbisno.quanlybaicat.ui.Xe;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bbisno.quanlybaicat.Models.Xe;
import com.bbisno.quanlybaicat.R;
import com.firebase.client.Query;
import com.firebase.ui.FirebaseRecyclerAdapter;

/**
 * Created by MyPC on 11/03/2016.
 */
public class ListXeAdapter extends FirebaseRecyclerAdapter<Xe, ListXeAdapter.XeViewHolder> {
    public static mOnItemClickListener mListener;

    //Tao Interface Listener cho RecyclerView
    public interface mOnItemClickListener {
        public void onItemClick(View itemView, int position);
    }

    // Define the method that allows the parent activity or fragment to define the listener
    public void setmOnItemClickListener(mOnItemClickListener listener) {
        this.mListener = listener;
    }


    public ListXeAdapter(Class<Xe> modelClass, int modelLayout, Class<XeViewHolder> viewHolderClass, Query ref) {
        super(modelClass, modelLayout, viewHolderClass, ref);
    }


    @Override
    protected void populateViewHolder(XeViewHolder xeViewHolder, Xe xe, int i) {
        xeViewHolder.tvSoXe.setText(String.valueOf(xe.getSoXe()));

    }

    public static class XeViewHolder extends RecyclerView.ViewHolder {
        TextView tvSoXe;

        View view;


        public XeViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            tvSoXe = (TextView) itemView.findViewById(R.id.row_xe_soxe);

            //setup ViewHolder cho click listener



        }
    }
}
