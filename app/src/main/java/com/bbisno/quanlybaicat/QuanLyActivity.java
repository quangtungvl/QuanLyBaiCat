package com.bbisno.quanlybaicat;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.bbisno.quanlybaicat.ui.ChuXe.AddEditChuXeFragment;
import com.bbisno.quanlybaicat.ui.CongTrinh.AddEditCongTrinhFragment;
import com.bbisno.quanlybaicat.ui.CongTrinh.AddEditPhieuNhapFragment;
import com.bbisno.quanlybaicat.ui.CongTrinh.AddEditPhieuXuatFragment;
import com.bbisno.quanlybaicat.ui.SaLan.AddEditSalanFragment;
import com.bbisno.quanlybaicat.ui.Xe.AddEditXeFragment;
import com.bbisno.quanlybaicat.ui.ChuXe.ChuXeFragment;
import com.bbisno.quanlybaicat.ui.CongTrinh.CongTrinhFragment;
import com.bbisno.quanlybaicat.ui.CongTrinh.PhieuNhapFragment;
import com.bbisno.quanlybaicat.ui.CongTrinh.PhieuXuatFragment;
import com.bbisno.quanlybaicat.ui.SaLan.SalanFragment;
import com.bbisno.quanlybaicat.ui.Xe.XeFragment;
import com.bbisno.quanlybaicat.ultils.Constant;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class QuanLyActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        ChuXeFragment.OnFragmentInteractionListener, CongTrinhFragment.OnFragmentInteractionListener,
        XeFragment.OnFragmentInteractionListener, SalanFragment.OnFragmentInteractionListener,
        PhieuNhapFragment.OnFragmentInteractionListener, PhieuXuatFragment.OnFragmentInteractionListener,AddEditXeFragment.OnFragmentInteractionListener {

    private int currentFragment = 0;
    private static final int CHUXEFRAGMENT = 0;
    private static final int XEFRAGMENT = 1;
    private static final int TAIXEFRAGMENT = 2;
    private static final int SALANFRAGMENT = 3;
    private static final int CTFRAGMENT = 4;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoat_dong);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_chuxe) {
            // Handle the camera action
            openFragments(new ChuXeFragment());

        } else if (id == R.id.nav_xe) {
            openFragments(new XeFragment());


        } else if (id == R.id.nav_salan) {
            openFragments(new SalanFragment());

        } else if (id == R.id.nav_congtrinh) {
            openFragments(new CongTrinhFragment());

        } else if (id == R.id.nav_phieuxuat) {
            openFragments(new PhieuXuatFragment());

        } else if (id == R.id.nav_phieunhap) {
            openFragments(new PhieuNhapFragment());

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setTitleToolbar(String titlebar) {
        getSupportActionBar().setTitle(titlebar);
    }

    private void openFragments(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment).commit();


    }

    private void openFragmentsAddEdit(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment).addToBackStack(null).commit();


    }

    @Override
    public void onFragmentInteraction(String openAddEdit) {
        if (openAddEdit.equalsIgnoreCase("ChuXe")) {
            openFragmentsAddEdit(new AddEditChuXeFragment());

        } else if (openAddEdit.equalsIgnoreCase("CongTrinh")) {
            openFragmentsAddEdit(new AddEditCongTrinhFragment());

        } else if (openAddEdit.equalsIgnoreCase(Constant.ADDXE)) {
            openFragmentsAddEdit(new AddEditXeFragment());

        } else if (openAddEdit.equalsIgnoreCase("Salan")) {
            openFragmentsAddEdit(new AddEditSalanFragment());

        } else if (openAddEdit.equalsIgnoreCase("PhieuXuat")) {
            openFragmentsAddEdit(new AddEditPhieuXuatFragment());

        } else if (openAddEdit.equalsIgnoreCase("PhieuNhap")) {
            openFragmentsAddEdit(new AddEditPhieuNhapFragment());

        }

    }

    @Override
    public void onFragmentInteraction(String openAddEdit, String data) {
        if (openAddEdit.equalsIgnoreCase(Constant.EDITXE)) {
            openFragmentsAddEdit(new AddEditXeFragment().newInstance(openAddEdit,data));

        }

    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();

    }
}


