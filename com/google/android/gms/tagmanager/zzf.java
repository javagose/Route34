package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzf extends zzak {
    private static final String ID;
    private final Context mContext;

    static {
        ID = zzad.APP_ID.toString();
    }

    public zzf(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public boolean zzFW() {
        return true;
    }

    public zza zzP(Map<String, zza> map) {
        return zzdf.zzR(this.mContext.getPackageName());
    }
}
