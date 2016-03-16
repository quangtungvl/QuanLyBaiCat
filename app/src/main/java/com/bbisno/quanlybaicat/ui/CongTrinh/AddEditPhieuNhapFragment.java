package com.bbisno.quanlybaicat.ui.CongTrinh;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bbisno.quanlybaicat.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddEditPhieuNhapFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddEditPhieuNhapFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddEditPhieuNhapFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match


    public AddEditPhieuNhapFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_edit_phieu_nhap, container, false);
    }


}
