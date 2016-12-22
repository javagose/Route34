package com.dahmani.javagose.cameratest;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.dahmani.javagose.cameratest.app.AppConfig;
import com.dahmani.javagose.cameratest.app.AppController;
import com.dahmani.javagose.cameratest.helper.SQLiteHandler;
import com.dahmani.javagose.cameratest.helper.SessionManager;
import com.google.android.gms.common.Scopes;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import java.util.HashMap;
import java.util.Map;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity implements OnNavigationItemSelectedListener {
    private static final String TAG;
    private Button btnLinkToRegister;
    private Button btnLogin;
    private SQLiteHandler db;
    private ZXingScannerView mScannerView;
    private ProgressDialog pDialog;
    private SessionManager session;
    private String uid;

    /* renamed from: com.dahmani.javagose.cameratest.LoginActivity.1 */
    class C02271 implements OnClickListener {
        C02271() {
        }

        public void onClick(View view) {
            IntentIntegrator integrator = new IntentIntegrator(LoginActivity.this);
            integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
            integrator.setPrompt("Scan the code to login");
            integrator.setCameraId(0);
            integrator.setBeepEnabled(true);
            integrator.setBarcodeImageEnabled(true);
            integrator.initiateScan();
        }
    }

    /* renamed from: com.dahmani.javagose.cameratest.LoginActivity.2 */
    class C02282 implements OnClickListener {
        C02282() {
        }

        public void onClick(View view) {
            LoginActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.google.com")));
            LoginActivity.this.finish();
        }
    }

    /* renamed from: com.dahmani.javagose.cameratest.LoginActivity.3 */
    class C07263 implements Listener<String> {
        C07263() {
        }

        public void onResponse(String response) {
            Log.d(LoginActivity.TAG, "Login Response: " + response.toString());
            LoginActivity.this.hideDialog();
            try {
                JSONObject jObj = new JSONObject(response);
                if (jObj.getBoolean(MediaRouteProviderProtocol.SERVICE_DATA_ERROR)) {
                    Toast.makeText(LoginActivity.this.getApplicationContext(), jObj.getString("error_msg"), 1).show();
                    return;
                }
                LoginActivity.this.session.setLogin(true);
                String uid = jObj.getString("uid");
                JSONObject user = jObj.getJSONObject("user");
                LoginActivity.this.db.addUser(user.getString("name"), user.getString(Scopes.EMAIL), uid, user.getString("created_at"));
                LoginActivity.this.startActivity(new Intent(LoginActivity.this, MainActivity.class));
                LoginActivity.this.finish();
            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(LoginActivity.this.getApplicationContext(), "Json error: " + e.getMessage(), 1).show();
            }
        }
    }

    /* renamed from: com.dahmani.javagose.cameratest.LoginActivity.4 */
    class C07274 implements ErrorListener {
        C07274() {
        }

        public void onErrorResponse(VolleyError error) {
            Log.e(LoginActivity.TAG, "Login Error: " + error.getMessage());
            Toast.makeText(LoginActivity.this.getApplicationContext(), error.getMessage(), 1).show();
            LoginActivity.this.hideDialog();
        }
    }

    /* renamed from: com.dahmani.javagose.cameratest.LoginActivity.5 */
    class C09935 extends StringRequest {
        final /* synthetic */ String val$uid;

        C09935(int x0, String x1, Listener x2, ErrorListener x3, String str) {
            this.val$uid = str;
            super(x0, x1, x2, x3);
        }

        protected Map<String, String> getParams() {
            Map<String, String> params = new HashMap();
            params.put("uid", this.val$uid);
            return params;
        }
    }

    static {
        TAG = LoginActivity.class.getSimpleName();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0232R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(C0232R.id.logintoolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(C0232R.id.login_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, C0232R.string.navigation_drawer_open, C0232R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        ((NavigationView) findViewById(C0232R.id.login_nav_view)).setNavigationItemSelectedListener(this);
        this.btnLogin = (Button) findViewById(C0232R.id.btnLogin);
        this.btnLinkToRegister = (Button) findViewById(C0232R.id.btnLinkToRegisterScreen);
        this.pDialog = new ProgressDialog(this);
        this.pDialog.setCancelable(false);
        this.db = new SQLiteHandler(getApplicationContext());
        this.session = new SessionManager(getApplicationContext());
        if (this.session.isLoggedIn()) {
            this.btnLogin.setOnClickListener(new C02271());
            this.btnLinkToRegister.setOnClickListener(new C02282());
        } else {
            this.btnLogin.setOnClickListener(new C02271());
            this.btnLinkToRegister.setOnClickListener(new C02282());
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result == null) {
            super.onActivityResult(requestCode, resultCode, data);
        } else if (result.getContents() != null) {
            this.uid = result.getContents();
            checkLogin(this.uid);
        }
    }

    private void checkLogin(String uid) {
        this.pDialog.setMessage("Logging in ...");
        showDialog();
        StringRequest strReq = new C09935(1, AppConfig.URL_LOGIN, new C07263(), new C07274(), uid);
        AppController.getInstance().addToRequestQueue(strReq, "req_login");
    }

    private void showDialog() {
        if (!this.pDialog.isShowing()) {
            this.pDialog.show();
        }
    }

    private void hideDialog() {
        if (this.pDialog.isShowing()) {
            this.pDialog.dismiss();
        }
    }

    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(C0232R.id.login_drawer_layout);
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
        ((DrawerLayout) findViewById(C0232R.id.login_drawer_layout)).closeDrawer((int) MediaRouterJellybean.ALL_ROUTE_TYPES);
        return true;
    }
}
