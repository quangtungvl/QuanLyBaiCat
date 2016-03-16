package com.bbisno.quanlybaicat.ui.TaiXe;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bbisno.quanlybaicat.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddEditTaiXeFragment extends Fragment {


    public AddEditTaiXeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        getActivity().setTitle("Thêm Sửa Tài Xế");
        return inflater.inflate(R.layout.fragment_add_edit_tai_xe, container, false);
    }

}
