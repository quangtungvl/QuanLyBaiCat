package com.bbisno.quanlybaicat.ui.Xe;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bbisno.quanlybaicat.Models.ChuXe;
import com.bbisno.quanlybaicat.Models.Xe;
import com.bbisno.quanlybaicat.R;
import com.bbisno.quanlybaicat.ultils.Constant;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.ui.FirebaseListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddEditXeFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;

    RadioGroup rdgXe;
    RadioButton rdbXeNha;
    RadioButton rdbXeNgoai;
    EditText edtSoXe;
    EditText edtKhoiluong;
    ListView mLVChuXe;

    private int positionChuXe;
    private boolean blXeNha;


    boolean kq;

    FirebaseListAdapter<ChuXe> mAdapter;
    Firebase mRef = new Firebase(Constant.FIREBASELINK);

    String tenChuXeOld;
    String tenChuXeNew;
    public int j;
    ArrayList<String> arr = new ArrayList<String>();


    public AddEditXeFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static AddEditXeFragment newInstance(String param1, String param2) {
        AddEditXeFragment fragment = new AddEditXeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Tao ket noi Firebase
        mRef = new Firebase(Constant.FIREBASELINK);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            //


        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        getActivity().setTitle(getString(R.string.title_addeditXe));

        View rootView = inflater.inflate(R.layout.fragment_add_edit_xe, container, false);

        initScreen(rootView);

        //if mParam2 != null là edit, lấy dữ liệu xe set vào edittext
        if (mParam2 != null) {
            Firebase mRefXe = new Firebase(Constant.REF_XE).child(mParam2);
            mRefXe.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Xe xe = dataSnapshot.getValue(Xe.class);
                    if (xe.getXeNha()) {
                        rdbXeNha.setChecked(true);
                    } else rdbXeNgoai.setChecked(true);

                    edtSoXe.setText(String.valueOf(xe.getSoXe()));
                    edtKhoiluong.setText(String.valueOf(xe.getKhoiluongXe()));


                    Map<String, Object> chuxe = xe.getChuXe();
                    if (chuxe != null) {
                        for (String cx : chuxe.keySet()) {
                            Log.d("bbisno", "ten chu xe: " + cx);
                            tenChuXeOld = cx.trim();
                        }

                    } else tenChuXeOld = null;
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

        }

        // lấy danh sách chủ xe đổ vào listview, tìm có chủ xe trong listview hay ko
        Firebase mReflistChuXe = mRef.child(Constant.LINK_CHUXE);
        mAdapter = new FirebaseListAdapter<ChuXe>(getActivity(), ChuXe.class, android.R.layout.simple_list_item_single_choice, mReflistChuXe) {
            @Override
            protected void populateView(View view, ChuXe chuXe, int i) {
                ((TextView) view.findViewById(android.R.id.text1)).setText(chuXe.getTenChuXe());
                arr.add(i, chuXe.getTenChuXe());
                if (tenChuXeOld != null) {
                    if (tenChuXeOld.equalsIgnoreCase(chuXe.getTenChuXe().trim())) {
                        positionChuXe = i;
                        Log.d("bbisno", "positionChuXe i:" + positionChuXe);
                        mLVChuXe.clearFocus();
                        mLVChuXe.setItemChecked(positionChuXe, true);
                    }
                }
            }
        };
        //set sự kiện lấy tên chủ xe mới để save data
        mLVChuXe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("bbisno", "position" + arr.get(position).toString() + " - " + position);
                tenChuXeNew = arr.get(position).toString().trim();
                Log.d("bbisno", "character" + tenChuXeNew.length());
            }
        });
        mLVChuXe.setAdapter(mAdapter);


        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    private void initScreen(View rootView) {
        rdgXe = (RadioGroup) rootView.findViewById(R.id.rdgXe);
        rdbXeNha = (RadioButton) rootView.findViewById(R.id.rdbXeNha);
        rdbXeNgoai = (RadioButton) rootView.findViewById(R.id.rdbXeNgoai);
        edtSoXe = (EditText) rootView.findViewById(R.id.editSoXes);
        edtKhoiluong = (EditText) rootView.findViewById(R.id.edtKhoiluong);
        mLVChuXe = (ListView) rootView.findViewById(R.id.mLV_Xe_listChuXe);


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
        } else if (id == R.id.action_del) {
            clearData();
        }
        return super.onOptionsItemSelected(item);
    }

    private void clearData() {
        edtSoXe.setText("");
        edtKhoiluong.setText("");
        mLVChuXe.clearChoices();
        mLVChuXe.requestLayout();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mAdapter.cleanup();
    }

    private void saveData() {

        Firebase mRefXe = mRef.child(Constant.LINK_XE).child(String.valueOf(edtSoXe.getText()) + "/");
        Firebase mRefChuXeNew = mRef.child("chuxe/" + tenChuXeNew);
        Firebase mRefChuXeOld = mRef.child("chuxe/" + tenChuXeOld);

        while (kiemtraData()) {
            //kiểm tra số xe có tồn tại chưa, có thì xóa chủ xe củ
            kiemtraEditXe();


            long soXe = Long.parseLong(String.valueOf(edtSoXe.getText()));
            double khoiluong = Double.parseDouble(String.valueOf(edtKhoiluong.getText()));
            HashMap<String, Object> mapTenChuXe = new HashMap<String, Object>();

            Xe xe = new Xe(blXeNha, soXe, khoiluong);
            mRefXe.setValue(xe);


            //check select chuxe
            if (mLVChuXe.getCheckedItemPosition() >= 0) {
                //add value chuxe vo xe

                mapTenChuXe.put("chuXe/" + tenChuXeNew, true);
                mRefXe.updateChildren(mapTenChuXe);

                Map<String, Object> mapXesohuu = new HashMap<String, Object>();
                mapXesohuu.put("xesohuu/" + soXe, true);
                mRefChuXeNew.updateChildren(mapXesohuu);


            }
            break;
        }


    }

    private void delChuXeOld() {
        Firebase mref = mRef.child("chuxe/" + tenChuXeOld).child("/xesohuu/" + String.valueOf(edtSoXe.getText()));
        mref.removeValue();

    }

    private void kiemtraEditXe() {
        //kiem tra if là edit xe, update chuxe thi remove chuxe cu,add moi
        Firebase iseditxe = mRef.child(Constant.LINK_XE + "/" + edtSoXe.getText().toString());
        iseditxe.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()) {
                    Log.d("bbisno", "kq la" + dataSnapshot.hasChildren());
                    delChuXeOld();
                }
                Log.d("bbisno", "kq la" + dataSnapshot.hasChildren());

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


    }

    private boolean kiemtraData() {
        if (rdgXe.getCheckedRadioButtonId() == R.id.rdbXeNha) {
            blXeNha = true;

        } else {
            blXeNha = false;
        }
        if (rdgXe.getCheckedRadioButtonId() < 0) {
            Toast.makeText(getContext(), "Chưa chọn loại xe", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (edtSoXe.getText().toString().trim().isEmpty()) {
            Toast.makeText(getContext(), "Chưa nhập số xe", Toast.LENGTH_SHORT).show();
            return false;

        } else {
            return true;
        }


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


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String openAddEdit);
    }

}
