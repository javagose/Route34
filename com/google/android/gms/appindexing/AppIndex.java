package com.google.android.gms.appindexing;

import com.google.android.gms.appdatasearch.zza;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.internal.zzkk;

public final class AppIndex {
    public static final Api<NoOptions> API;
    public static final Api<NoOptions> APP_INDEX_API;
    public static final AppIndexApi AppIndexApi;

    static {
        API = zza.zzTA;
        APP_INDEX_API = zza.zzTA;
        AppIndexApi = new zzkk();
    }

    private AppIndex() {
    }
}
