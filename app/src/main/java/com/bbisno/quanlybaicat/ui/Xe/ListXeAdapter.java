package com.bbisno.quanlybaicat.ui.Xe;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bbisno.quanlybaicat.Models.Xe;
import com.bbisno.quanlybaicat.R;
import com.bbisno.quanlybaicat.helper.ItemTouchHelperAdapter;
import com.bbisno.quanlybaicat.ultils.Constant;
import com.bbisno.quanlybaicat.ultils.Untils;
import com.firebase.client.Firebase;
import com.firebase.client.Query;
import com.firebase.ui.FirebaseRecyclerAdapter;

import java.util.Collections;
import java.util.Map;

/**
 * Created by MyPC on 11/03/2016.
 */
public class ListXeAdapter extends FirebaseRecyclerAdapter<Xe, ListXeAdapter.XeViewHolder> implements ItemTouchHelperAdapter {
    public static mOnItemClickListener mListener;
    private Context mContext;

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
//        if (fromPosition < toPosition) {
//            for (int i = fromPosition; i < toPosition; i++) {
//                Collections.swap(mItems, i, i + 1);
//            }
//        } else {
//            for (int i = fromPosition; i > toPosition; i--) {
//                Collections.swap(mItems, i, i - 1);
//            }
//        }
//        notifyItemMoved(fromPosition, toPosition);
        return false;
    }

    @Override
    public void onItemDismiss(final int position) {


        final Xe xe = getItem(position);

        //Tạo Dialog hỏi có muốn xóa hay ko
        final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("Có chắc là muốn xóa: " + xe.getSoXe());
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Có chủ xe thì del xesohuu
                String tenChuXe = null;
                Map<String, Object> chuxe = xe.getChuXe();
                if (chuxe != null) {
                    for (String cx : chuxe.keySet()) {
                        Log.d("bbisno", "ten chu xe: " + cx);
                        tenChuXe = cx.trim();
                        String pathXeSoHuu = (Constant.REF_CHUXE + tenChuXe + "/" + Constant.XESOHUU + String.valueOf(xe.getSoXe()));
                        //Gọi hàm xóa
                        Untils.delXeSoHuu(pathXeSoHuu);
                    }

                }


                Firebase mRefXoa = getRef(position);
                mRefXoa.removeValue();
                notifyDataSetChanged();

                notifyItemRemoved(position);

                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Ko muốn xóa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
        notify();


    }

    //Tao Interface Listener cho RecyclerView
    public interface mOnItemClickListener {
        public void onItemClick(View itemView, int position);
    }

    // Define the method that allows the parent activity or fragment to define the listener
    public void setmOnItemClickListener(mOnItemClickListener listener) {
        this.mListener = listener;
    }


    public ListXeAdapter(Context context, Class<Xe> modelClass, int modelLayout, Class<XeViewHolder> viewHolderClass, Query ref) {
        super(modelClass, modelLayout, viewHolderClass, ref);
        this.mContext = context;
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
