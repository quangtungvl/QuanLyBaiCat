package com.bbisno.quanlybaicat.ui.Xe;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.bbisno.quanlybaicat.Models.Xe;
import com.bbisno.quanlybaicat.QuanLyActivity;
import com.bbisno.quanlybaicat.R;
import com.bbisno.quanlybaicat.ultils.Constant;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.ui.FirebaseRecyclerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class XeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private RecyclerView mRecyclerViewXe;
    private Spinner spinChuXe;
    private ListXeAdapter mAdapter;


    public XeFragment() {
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
    public static XeFragment newInstance(String param1, String param2) {
        XeFragment fragment = new XeFragment();
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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //Override Menu lại cho fragment
        setHasOptionsMenu(true);
        getActivity().setTitle(getString(R.string.title_quanlyxe));
        View rootView = inflater.inflate(R.layout.fragment_xe, container, false);

        initScreen(rootView);

        return rootView;
    }

    private void initScreen(View rootView) {
        mRecyclerViewXe = (RecyclerView) rootView.findViewById(R.id.mRV_xe_list);
        mRecyclerViewXe.setHasFixedSize(true);
        mRecyclerViewXe.setLayoutManager(new LinearLayoutManager(getContext()));

        spinChuXe = (Spinner) rootView.findViewById(R.id.mSp_xe_chuxe);

        Firebase firebaseRef = new Firebase(Constant.FIREBASELINK);
        Firebase mRefXe = firebaseRef.child(getString(R.string.firebase_link_xe));
        Firebase mRefChuXe = firebaseRef.child(getString(R.string.firebase_link_chuxe));

        mAdapter = new ListXeAdapter(Xe.class, R.layout.row_item_xe, ListXeAdapter.XeViewHolder.class, mRefXe) {
            @Override
            protected void populateViewHolder(XeViewHolder xeViewHolder, final Xe xe, final int i) {
                xeViewHolder.tvSoXe.setText(String.valueOf(xe.getSoXe()));

                xeViewHolder.view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("bbisno","item click"+i+" - "+xe.getSoXe());
                        String soxe = String.valueOf(xe.getSoXe());
                        sendDatatoEditXe(soxe);
                    }
                });
            }
        };



        mRecyclerViewXe.setAdapter(mAdapter);

    }

    private void sendDatatoEditXe(String soxe) {
        mListener.onFragmentInteraction(Constant.EDITXE,soxe);
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
            //add xe moi
            mListener.onFragmentInteraction(Constant.ADDXE);

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

    @Override
    public void onDestroy() {
        super.onDestroy();
        mAdapter.cleanup();
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
        void onFragmentInteraction(String openAddEdit,String soXe);
    }




}
