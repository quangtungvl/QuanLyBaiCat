package com.bbisno.quanlybaicat.ui.ChuXe;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.bbisno.quanlybaicat.Models.ChuXe;
import com.bbisno.quanlybaicat.QuanLyActivity;
import com.bbisno.quanlybaicat.R;
import com.bbisno.quanlybaicat.ultils.Constant;
import com.firebase.client.Firebase;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddEditChuXeFragment extends Fragment {
    EditText edtTen, edtSoDT;
    Spinner mSpListXe;
    ListView mLVListXeSoHuu;


    public AddEditChuXeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        getActivity().setTitle("Thêm Chủ Xe");


        View view = inflater.inflate(R.layout.fragment_add_edit_chu_xe, container, false);

        edtTen = (EditText) view.findViewById(R.id.edt_ChuXe_Ten);
        edtSoDT = (EditText) view.findViewById(R.id.edt_ChuXe_soDT);
        mSpListXe = (Spinner) view.findViewById(R.id.mSp_ChuXe_listxe);
        mLVListXeSoHuu = (ListView) view.findViewById(R.id.mLV_ChuXe_listxeshohuu);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_frag_detail, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_done) {
            saveData();

        }
        return super.onOptionsItemSelected(item);
    }

    private void saveData() {

        if (edtTen.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "Chưa nhập tên", Toast.LENGTH_SHORT).show();
        } else if (edtSoDT.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "Chưa nhập số ĐT", Toast.LENGTH_SHORT).show();
        } else {
            String tenChuXe = edtTen.getText().toString();
            long soDTChuXe = Long.parseLong(edtSoDT.getText().toString());

            ChuXe chuXe = new ChuXe(tenChuXe,soDTChuXe);

            Firebase mRefChuXe = new Firebase(Constant.FIREBASELINK+"chuxe/");
            Firebase mRefChuXelink = mRefChuXe.child(tenChuXe);
            mRefChuXelink.setValue(chuXe);
        }


    }

}
