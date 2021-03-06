package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzak implements Creator<GetChannelOutputStreamResponse> {
    static void zza(GetChannelOutputStreamResponse getChannelOutputStreamResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, getChannelOutputStreamResponse.versionCode);
        zzb.zzc(parcel, 2, getChannelOutputStreamResponse.statusCode);
        zzb.zza(parcel, 3, getChannelOutputStreamResponse.zzbsC, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziq(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlU(i);
    }

    public GetChannelOutputStreamResponse zziq(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    i = zza.zzg(parcel, zzat);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzat, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GetChannelOutputStreamResponse(i2, i, parcelFileDescriptor);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GetChannelOutputStreamResponse[] zzlU(int i) {
        return new GetChannelOutputStreamResponse[i];
    }
}
