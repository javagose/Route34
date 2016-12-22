package com.dahmani.javagose.cameratest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.dahmani.javagose.cameratest.helper.SQLiteHandler;
import com.dahmani.javagose.cameratest.helper.SessionManager;
import me.dm7.barcodescanner.zxing.BuildConfig;

public class MainActivity extends AppCompatActivity implements OnNavigationItemSelectedListener {
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    private SQLiteHandler db;
    private SessionManager session;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0232R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(C0232R.id.main_toolbar);
        setSupportActionBar(toolbar);
        this.db = new SQLiteHandler(getApplicationContext());
        this.session = new SessionManager(getApplicationContext());
        String userName = BuildConfig.FLAVOR;
        if (this.session.isLoggedIn()) {
            userName = this.db.getUserNmae();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(C0232R.id.main_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, C0232R.string.navigation_drawer_open, C0232R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        ((NavigationView) findViewById(C0232R.id.main_nav_view)).setNavigationItemSelectedListener(this);
    }

    public void onClickBtn(View v) {
        startActivityForResult(new Intent("android.media.action.IMAGE_CAPTURE"), CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE && resultCode == -1) {
            Intent intent = new Intent(this, PhotoInfoActivity.class);
            intent.putExtras(data.getExtras());
            startActivity(intent);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0232R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == C0232R.id.action_settings) {
            return true;
        }
        if (id == C0232R.id.action_lougout && this.session.isLoggedIn()) {
            this.session.setLogin(false);
            startActivity(new Intent(this, LoginActivity.class));
            this.db.deleteUsers();
        }
        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(C0232R.id.main_drawer_layout);
        if (drawer.isDrawerOpen((int) MediaRouterJellybean.ALL_ROUTE_TYPES)) {
            drawer.closeDrawer((int) MediaRouterJellybean.ALL_ROUTE_TYPES);
        } else {
            super.onBackPressed();
        }
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == C0232R.id.nav_cree_rec) {
            startActivity(new Intent(this, MainActivity.class));
        } else if (id == C0232R.id.nav_login) {
            startActivity(new Intent(this, LoginActivity.class));
        } else if (id == C0232R.id.nav_logout) {
            this.session.setLogin(false);
            startActivity(new Intent(this, LoginActivity.class));
            this.db.deleteUsers();
        } else if (id == C0232R.id.nav_vos_rec) {
            startActivity(new Intent(this, LoginActivity.class));
        } else if (id == C0232R.id.nav_site) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://google.fr")));
        }
        ((DrawerLayout) findViewById(C0232R.id.main_drawer_layout)).closeDrawer((int) MediaRouterJellybean.ALL_ROUTE_TYPES);
        return true;
    }
}
