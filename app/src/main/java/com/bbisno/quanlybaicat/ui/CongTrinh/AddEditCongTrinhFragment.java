package com.bbisno.quanlybaicat.ui.CongTrinh;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.bbisno.quanlybaicat.Models.CongTrinh;
import com.bbisno.quanlybaicat.R;
import com.bbisno.quanlybaicat.ultils.Constant;
import com.bbisno.quanlybaicat.ultils.Untils;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * Use the {@link AddEditCongTrinhFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddEditCongTrinhFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    //
    private Firebase mRef;
    //
    private EditText edtTenCT;
    private EditText edtDChiCT;
    private EditText edtGiaXeVC;
    private EditText edtCongTaiVC;
    private EditText edtGhiChu;



    public AddEditCongTrinhFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddEditCongTrinhFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddEditCongTrinhFragment newInstance(String param1, String param2) {
        AddEditCongTrinhFragment fragment = new AddEditCongTrinhFragment();
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
        mRef = new Firebase(Constant.REF_CONGTRINH);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_edit_cong_trinh, container, false);
        setHasOptionsMenu(true);
        getActivity().setTitle(getString(R.string.title_addeditcongtrinh));

        edtTenCT = (EditText) rootView.findViewById(R.id.edt_ADCongTrinh_ten);
        edtDChiCT = (EditText) rootView.findViewById(R.id.edt_ADCongTrinh_dchi);
        edtGiaXeVC = (EditText) rootView.findViewById(R.id.edt_ADCongTrinh_giaxevc);
        edtCongTaiVC = (EditText) rootView.findViewById(R.id.edt_ADCongTrinh_congtxvc);
        edtGhiChu = (EditText) rootView.findViewById(R.id.edt_ADCongTrinh_ghichu);

        //if là edit công trình thì get dữ liệu đổ vào edittext
        if (mParam2 != null) {
            Firebase mRefTenCTget = mRef.child(mParam2);
            mRefTenCTget.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    CongTrinh congTrinh = dataSnapshot.getValue(CongTrinh.class);
                    edtTenCT.setText(congTrinh.getTenCongTrinh());
                    edtDChiCT.setText(congTrinh.getDchiCTrinh());
                    edtGiaXeVC.setText(String.valueOf(congTrinh.getGiaXeVanChuyen()));
                    edtCongTaiVC.setText(String.valueOf(congTrinh.getCongTaiXeLai()));
                    edtGhiChu.setText(congTrinh.getGhiChu());
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

        } else {

        }

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_frag_detail, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_done:
                saveData();
                break;
            case R.id.action_del:
                clearData();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void clearData() {
        edtTenCT.setText("");
        edtDChiCT.setText("");
        edtGiaXeVC.setText("");
        edtCongTaiVC.setText("");
        edtGhiChu.setText("");
    }

    private void saveData() {
        while (kiemtraData()){
            String tenCTchuanhoa = Untils.chuanhoaString(edtTenCT.getText().toString());
            Log.d("bbisno",tenCTchuanhoa);
            Firebase mRefCongTrinh = mRef.child(tenCTchuanhoa);
            //
            String tenCT = edtTenCT.getText().toString();
            String dchiCT =edtDChiCT.getText().toString();
            long giaxe = Long.valueOf(edtGiaXeVC.getText().toString());
            long congtx=Long.valueOf(edtCongTaiVC.getText().toString());
            String ghichuCT=edtGhiChu.getText().toString();

            CongTrinh congTrinh = new CongTrinh(tenCT,dchiCT,giaxe,congtx,ghichuCT);
            mRefCongTrinh.setValue(congTrinh);

            //
            Toast.makeText(getActivity(),"Lưu Công Trình: "+edtTenCT.getText().toString()+" thành công",Toast.LENGTH_SHORT).show();
            getActivity().getSupportFragmentManager().popBackStack();
            break;
        }
    }

    private boolean kiemtraData() {
        if(edtTenCT.getText().toString().trim().isEmpty()){
            Toast.makeText(getActivity(),"Chưa nhập tên Công Trình",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(edtDChiCT.getText().toString().trim().isEmpty()){
            Toast.makeText(getActivity(),"Chưa nhập Địa chỉ Công Trình",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(edtGiaXeVC.getText().toString().trim().isEmpty()){
            Toast.makeText(getActivity(),"Chưa nhập Giá xe vận chuyển",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(edtCongTaiVC.getText().toString().trim().isEmpty()){
            Toast.makeText(getActivity(),"Chưa nhập Công tài xế vận chuyển",Toast.LENGTH_SHORT).show();
            return false;
        }

        else return true;
    }


}
