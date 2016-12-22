package com.dahmani.javagose.cameratest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.zxing.client.android.C0599R;

public class NavigationDarwerTest extends AppCompatActivity implements OnNavigationItemSelectedListener {

    /* renamed from: com.dahmani.javagose.cameratest.NavigationDarwerTest.1 */
    class C02291 implements OnClickListener {
        C02291() {
        }

        public void onClick(View view) {
            Snackbar.make(view, (CharSequence) "Replace with your own action", 0).setAction((CharSequence) "Action", null).show();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0232R.layout.activity_photo_info);
        Toolbar toolbar = (Toolbar) findViewById(C0232R.id.photo_info_drawer_layout);
        setSupportActionBar(toolbar);
        ((FloatingActionButton) findViewById(C0232R.id.photo_info_nav_view)).setOnClickListener(new C02291());
        DrawerLayout drawer = (DrawerLayout) findViewById(C0232R.id.main_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, C0232R.string.navigation_drawer_open, C0232R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        ((NavigationView) findViewById(C0232R.id.main_nav_view)).setNavigationItemSelectedListener(this);
    }

    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(C0232R.id.main_drawer_layout);
        if (drawer.isDrawerOpen((int) MediaRouterJellybean.ALL_ROUTE_TYPES)) {
            drawer.closeDrawer((int) MediaRouterJellybean.ALL_ROUTE_TYPES);
        } else {
            super.onBackPressed();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0232R.menu.navigation_darwer, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == C0232R.id.nav_vos_rec) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (!(id == C0232R.id.spinner_item_text || id == C0599R.id.zxing_barcode_surface || id == C0599R.id.zxing_viewfinder_view || id == C0599R.id.zxing_status_view || id == C0599R.id.zxing_barcode_scanner || id != C0232R.id.nav_cree_rec)) {
        }
        ((DrawerLayout) findViewById(C0232R.id.main_drawer_layout)).closeDrawer((int) MediaRouterJellybean.ALL_ROUTE_TYPES);
        return true;
    }
}
