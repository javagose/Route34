package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FaceSettingsParcel implements SafeParcelable {
    public static final zzb CREATOR;
    public int mode;
    public final int versionCode;
    public int zzbnV;
    public int zzbnW;
    public boolean zzbnX;
    public boolean zzbnY;
    public float zzbnZ;

    static {
        CREATOR = new zzb();
    }

    public FaceSettingsParcel() {
        this.versionCode = 2;
    }

    public FaceSettingsParcel(int versionCode, int mode, int landmarkType, int classificationType, boolean prominentFaceOnly, boolean trackingEnabled, float proportionalMinFaceSize) {
        this.versionCode = versionCode;
        this.mode = mode;
        this.zzbnV = landmarkType;
        this.zzbnW = classificationType;
        this.zzbnX = prominentFaceOnly;
        this.zzbnY = trackingEnabled;
        this.zzbnZ = proportionalMinFaceSize;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzb.zza(this, parcel, flags);
    }
}
