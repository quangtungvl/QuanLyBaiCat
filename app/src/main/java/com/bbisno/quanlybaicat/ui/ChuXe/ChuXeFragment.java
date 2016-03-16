package com.bbisno.quanlybaicat.ui.ChuXe;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.bbisno.quanlybaicat.Adapters.ChuXeAdapter;
import com.bbisno.quanlybaicat.Models.ChuXe;
import com.bbisno.quanlybaicat.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ChuXeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ChuXeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChuXeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView mRecyclerViewChuXe;
    private RecyclerView.LayoutManager mLayoutManager;
    private ChuXeAdapter mAdapter;
    private ArrayList<ChuXe> listChuXe = new ArrayList<ChuXe>();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ChuXeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChuXeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChuXeFragment newInstance(String param1, String param2) {
        ChuXeFragment fragment = new ChuXeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //Override Menu lại cho fragment
        setHasOptionsMenu(true);
        getActivity().setTitle("Quản Lý Chủ Xe");


        View view = inflater.inflate(R.layout.fragment_chu_xe, container, false);



//        mLayoutManager = new LinearLayoutManager(getContext());
//        mRecyclerViewChuXe.setHasFixedSize(true);
//        mRecyclerViewChuXe.setLayoutManager(mLayoutManager);



        return view;
    }


    // TODO: Rename method, update argument and hook method into UI event


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_add_edit, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_add) {
            mListener.onFragmentInteraction("ChuXe");

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String openAddEdit);
    }


}
