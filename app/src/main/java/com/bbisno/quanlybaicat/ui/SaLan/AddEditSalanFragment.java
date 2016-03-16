package com.bbisno.quanlybaicat.ui.SaLan;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bbisno.quanlybaicat.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddEditSalanFragment extends Fragment {


    public AddEditSalanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        getActivity().setTitle("Thêm Sửa Salan");
        return inflater.inflate(R.layout.fragment_add_edit_salan, container, false);
    }

}
