package com.dahmani.javagose.cameratest;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.dahmani.javagose.cameratest.app.AppConfig;
import com.dahmani.javagose.cameratest.app.AppController;
import com.dahmani.javagose.cameratest.helper.SQLiteHandler;
import com.dahmani.javagose.cameratest.helper.SessionManager;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationServices;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import me.dm7.barcodescanner.zxing.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

public class PhotoInfoActivity extends AppCompatActivity implements ConnectionCallbacks, OnConnectionFailedListener, OnNavigationItemSelectedListener {
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 1000;
    private static final String TAG;
    private double altitude;
    private String catVlaue;
    private Spinner categorieSpinner;
    private Spinner categories;
    private SQLiteHandler db;
    private Spinner degrees;
    private double latitude;
    private double longitude;
    private TextView mAddress;
    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;
    private ProgressDialog pDialog;
    private ImageView photo;
    private SessionManager session;
    private String stringImage;
    private Spinner urgenceSpinner;
    private String urgenceValue;

    /* renamed from: com.dahmani.javagose.cameratest.PhotoInfoActivity.4 */
    class C02304 implements OnClickListener {
        C02304() {
        }

        public void onClick(DialogInterface dialog, int which) {
            PhotoInfoActivity.this.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        }
    }

    /* renamed from: com.dahmani.javagose.cameratest.PhotoInfoActivity.5 */
    class C02315 implements OnClickListener {
        C02315() {
        }

        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
        }
    }

    /* renamed from: com.dahmani.javagose.cameratest.PhotoInfoActivity.1 */
    class C07281 implements Listener<String> {
        C07281() {
        }

        public void onResponse(String response) {
            Log.d(PhotoInfoActivity.TAG, "add reclamation Response: " + response.toString());
            PhotoInfoActivity.this.hideDialog();
            try {
                JSONObject jObj = new JSONObject(response);
                if (jObj.getBoolean(MediaRouteProviderProtocol.SERVICE_DATA_ERROR)) {
                    Toast.makeText(PhotoInfoActivity.this.getApplicationContext(), jObj.getString("error_msg"), 1).show();
                    return;
                }
                Toast.makeText(PhotoInfoActivity.this.getApplicationContext(), "Reclamation successfully added!", 1).show();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.dahmani.javagose.cameratest.PhotoInfoActivity.2 */
    class C07292 implements ErrorListener {
        C07292() {
        }

        public void onErrorResponse(VolleyError error) {
            Log.e(PhotoInfoActivity.TAG, "uploading Error: boujamaa " + error.getMessage());
            Toast.makeText(PhotoInfoActivity.this.getApplicationContext(), error.getMessage(), 1).show();
            PhotoInfoActivity.this.hideDialog();
        }
    }

    /* renamed from: com.dahmani.javagose.cameratest.PhotoInfoActivity.3 */
    class C09943 extends StringRequest {
        final /* synthetic */ double val$altitude;
        final /* synthetic */ String val$categorie;
        final /* synthetic */ String val$commentaire;
        final /* synthetic */ String val$image;
        final /* synthetic */ double val$latitude;
        final /* synthetic */ double val$longitude;
        final /* synthetic */ String val$urgence;
        final /* synthetic */ String val$uuid;

        C09943(int x0, String x1, Listener x2, ErrorListener x3, String str, String str2, String str3, String str4, double d, double d2, double d3, String str5) {
            this.val$uuid = str;
            this.val$categorie = str2;
            this.val$urgence = str3;
            this.val$image = str4;
            this.val$latitude = d;
            this.val$longitude = d2;
            this.val$altitude = d3;
            this.val$commentaire = str5;
            super(x0, x1, x2, x3);
        }

        protected Map<String, String> getParams() {
            Map<String, String> params = new HashMap();
            params.put("uuid", this.val$uuid);
            Log.e(PhotoInfoActivity.TAG, "User uid " + PhotoInfoActivity.this.db.getUserUid());
            params.put("categorie", this.val$categorie);
            params.put("urgence", this.val$urgence);
            params.put("image", this.val$image);
            params.put("latitude", String.valueOf(this.val$latitude));
            params.put("longitude", String.valueOf(this.val$longitude));
            params.put("altitude", String.valueOf(this.val$altitude));
            params.put("commentaire", this.val$commentaire);
            return params;
        }
    }

    static {
        TAG = PhotoInfoActivity.class.getSimpleName();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0232R.layout.activity_photo_info);
        Toolbar toolbar = (Toolbar) findViewById(C0232R.id.photo_info_toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(C0232R.id.photo_info_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, C0232R.string.navigation_drawer_open, C0232R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        ((NavigationView) findViewById(C0232R.id.photo_info_nav_view)).setNavigationItemSelectedListener(this);
        this.mAddress = (TextView) findViewById(C0232R.id.address);
        this.photo = (ImageView) findViewById(C0232R.id.imageView);
        Bitmap image = (Bitmap) getIntent().getExtras().get("data");
        this.photo.setImageBitmap(image);
        this.stringImage = getStringImage(image);
        this.categorieSpinner = (Spinner) findViewById(C0232R.id.categorieSpinner);
        this.urgenceSpinner = (Spinner) findViewById(C0232R.id.degrees);
        if (checkPlayServices()) {
            buildGoogleApiClient();
        }
        populateCategories();
        populateDegree();
        this.pDialog = new ProgressDialog(this);
        this.pDialog.setCancelable(false);
        this.session = new SessionManager(getApplicationContext());
        this.db = new SQLiteHandler(getApplicationContext());
        String userName = BuildConfig.FLAVOR;
        if (this.session.isLoggedIn()) {
            userName = this.db.getUserNmae();
        }
        ((TextView) findViewById(C0232R.id.main_toolbar_title)).setText("Hello" + userName);
    }

    public void onClickBtn(View view) {
        if (!this.session.isLoggedIn()) {
            startActivity(new Intent(this, LoginActivity.class));
        }
        displayLocation();
        this.catVlaue = (String) this.categorieSpinner.getSelectedItem();
        this.urgenceValue = (String) this.urgenceSpinner.getSelectedItem();
        this.mAddress.setText(this.catVlaue + " || " + this.urgenceValue);
        addReclamation(this.db.getUserUid(), this.catVlaue, this.urgenceValue, this.stringImage, this.latitude, this.longitude, this.altitude, "comment");
    }

    private void addReclamation(String uuid, String categorie, String urgence, String image, double latitude, double longitude, double altitude, String commentaire) {
        this.pDialog.setMessage("Uploading...");
        showDialog();
        AppController.getInstance().addToRequestQueue(new C09943(1, AppConfig.URL_ADDRECLAMATION, new C07281(), new C07292(), uuid, categorie, urgence, image, latitude, longitude, altitude, commentaire), "add_reclamation");
    }

    private void displayLocation() {
        this.mLastLocation = LocationServices.FusedLocationApi.getLastLocation(this.mGoogleApiClient);
        if (this.mLastLocation != null) {
            this.latitude = this.mLastLocation.getLatitude();
            this.longitude = this.mLastLocation.getLongitude();
            this.altitude = this.mLastLocation.getAltitude();
            this.mAddress.setText(this.latitude + ", " + this.longitude + ", " + this.altitude);
            return;
        }
        this.mAddress.setText("(Couldn't get the location. Make sure location is enabled on the device)");
    }

    protected synchronized void buildGoogleApiClient() {
        this.mGoogleApiClient = new Builder(this).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(LocationServices.API).build();
    }

    private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (resultCode == 0) {
            return true;
        }
        if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
            GooglePlayServicesUtil.getErrorDialog(resultCode, this, PLAY_SERVICES_RESOLUTION_REQUEST).show();
        } else {
            showSettingsAlert();
        }
        return false;
    }

    public void populateCategories() {
        this.categories = (Spinner) findViewById(C0232R.id.categorieSpinner);
        ArrayAdapter<CharSequence> categoriesAdapter = ArrayAdapter.createFromResource(this, C0232R.array.categories, 17367048);
        categoriesAdapter.setDropDownViewResource(17367046);
        this.categories.setAdapter(categoriesAdapter);
    }

    public void populateDegree() {
        this.degrees = (Spinner) findViewById(C0232R.id.degrees);
        ArrayAdapter<CharSequence> degreeAdapter = new ArrayAdapter(this, C0232R.layout.spinner_custom, C0232R.id.spinner_item_text, getResources().getStringArray(C0232R.array.degrees));
        degreeAdapter.setDropDownViewResource(17367046);
        this.degrees.setAdapter(degreeAdapter);
    }

    public void showSettingsAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("SETTINGS");
        alertDialog.setMessage("Enable Location Provider! Go to settings menu?");
        alertDialog.setPositiveButton("Settings", new C02304());
        alertDialog.setNegativeButton("Cancel", new C02315());
        alertDialog.show();
    }

    protected void onStart() {
        super.onStart();
        if (this.mGoogleApiClient != null) {
            this.mGoogleApiClient.connect();
        }
    }

    protected void onResume() {
        super.onResume();
        checkPlayServices();
    }

    public void onConnectionFailed(ConnectionResult result) {
        Log.i(TAG, "Connection failed: ConnectionResult.getErrorCode() = " + result.getErrorCode());
    }

    public void onConnected(Bundle arg0) {
        displayLocation();
    }

    public void onConnectionSuspended(int arg0) {
        this.mGoogleApiClient.connect();
    }

    public String getStringImage(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(CompressFormat.JPEG, 100, baos);
        return Base64.encodeToString(baos.toByteArray(), 0);
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
        DrawerLayout drawer = (DrawerLayout) findViewById(C0232R.id.photo_info_drawer_layout);
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
        ((DrawerLayout) findViewById(C0232R.id.photo_info_drawer_layout)).closeDrawer((int) MediaRouterJellybean.ALL_ROUTE_TYPES);
        return true;
    }
}
