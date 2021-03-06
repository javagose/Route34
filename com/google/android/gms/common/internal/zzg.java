package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.C0233R;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.vision.barcode.Barcode;

public final class zzg {
    public static String zzc(Context context, int i, String str) {
        Resources resources = context.getResources();
        switch (i) {
            case CompletionEvent.STATUS_FAILURE /*1*/:
                if (zzmu.zzb(resources)) {
                    return resources.getString(C0233R.string.common_google_play_services_install_text_tablet, new Object[]{str});
                }
                return resources.getString(C0233R.string.common_google_play_services_install_text_phone, new Object[]{str});
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                return resources.getString(C0233R.string.common_google_play_services_update_text, new Object[]{str});
            case CompletionEvent.STATUS_CANCELED /*3*/:
                return resources.getString(C0233R.string.common_google_play_services_enable_text, new Object[]{str});
            case Barcode.PRODUCT /*5*/:
                return resources.getString(C0233R.string.common_google_play_services_invalid_account_text);
            case Barcode.TEXT /*7*/:
                return resources.getString(C0233R.string.common_google_play_services_network_error_text);
            case Barcode.WIFI /*9*/:
                return resources.getString(C0233R.string.common_google_play_services_unsupported_text, new Object[]{str});
            case Barcode.DATA_MATRIX /*16*/:
                return resources.getString(C0233R.string.common_google_play_services_api_unavailable_text, new Object[]{str});
            case Place.TYPE_CAR_DEALER /*17*/:
                return resources.getString(C0233R.string.common_google_play_services_sign_in_failed_text);
            case Place.TYPE_CAR_RENTAL /*18*/:
                return resources.getString(C0233R.string.common_google_play_services_updating_text, new Object[]{str});
            case Place.TYPE_CAR_WASH /*20*/:
                return resources.getString(C0233R.string.common_google_play_services_restricted_profile_text);
            case Place.TYPE_GENERAL_CONTRACTOR /*42*/:
                return resources.getString(C0233R.string.common_google_play_services_wear_update_text);
            default:
                return resources.getString(C0233R.string.common_google_play_services_unknown_issue, new Object[]{str});
        }
    }

    @Nullable
    public static final String zzg(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case CompletionEvent.STATUS_FAILURE /*1*/:
                return resources.getString(C0233R.string.common_google_play_services_install_title);
            case CompletionEvent.STATUS_CONFLICT /*2*/:
            case Place.TYPE_GENERAL_CONTRACTOR /*42*/:
                return resources.getString(C0233R.string.common_google_play_services_update_title);
            case CompletionEvent.STATUS_CANCELED /*3*/:
                return resources.getString(C0233R.string.common_google_play_services_enable_title);
            case Barcode.PHONE /*4*/:
            case Barcode.SMS /*6*/:
                return null;
            case Barcode.PRODUCT /*5*/:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return resources.getString(C0233R.string.common_google_play_services_invalid_account_title);
            case Barcode.TEXT /*7*/:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return resources.getString(C0233R.string.common_google_play_services_network_error_title);
            case Barcode.URL /*8*/:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case Barcode.WIFI /*9*/:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return resources.getString(C0233R.string.common_google_play_services_unsupported_title);
            case Barcode.GEO /*10*/:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case Barcode.CALENDAR_EVENT /*11*/:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case Barcode.DATA_MATRIX /*16*/:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case Place.TYPE_CAR_DEALER /*17*/:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return resources.getString(C0233R.string.common_google_play_services_sign_in_failed_title);
            case Place.TYPE_CAR_RENTAL /*18*/:
                return resources.getString(C0233R.string.common_google_play_services_updating_title);
            case Place.TYPE_CAR_WASH /*20*/:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return resources.getString(C0233R.string.common_google_play_services_restricted_profile_title);
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i);
                return null;
        }
    }

    public static String zzh(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case CompletionEvent.STATUS_FAILURE /*1*/:
                return resources.getString(C0233R.string.common_google_play_services_install_button);
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                return resources.getString(C0233R.string.common_google_play_services_update_button);
            case CompletionEvent.STATUS_CANCELED /*3*/:
                return resources.getString(C0233R.string.common_google_play_services_enable_button);
            default:
                return resources.getString(17039370);
        }
    }
}
