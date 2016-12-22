package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.fitness.ConfigApi;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.DataTypeReadRequest;
import com.google.android.gms.fitness.request.DisableFitRequest;
import com.google.android.gms.fitness.result.DataTypeResult;

public class zzpb implements ConfigApi {

    private static class zza extends com.google.android.gms.internal.zzoj.zza {
        private final zzb<DataTypeResult> zzamC;

        private zza(zzb<DataTypeResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_fitness_result_DataTypeResult) {
            this.zzamC = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_fitness_result_DataTypeResult;
        }

        public void zza(DataTypeResult dataTypeResult) {
            this.zzamC.zzs(dataTypeResult);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpb.1 */
    class C11271 extends zza<DataTypeResult> {
        final /* synthetic */ DataTypeCreateRequest zzazR;
        final /* synthetic */ zzpb zzazS;

        C11271(zzpb com_google_android_gms_internal_zzpb, GoogleApiClient googleApiClient, DataTypeCreateRequest dataTypeCreateRequest) {
            this.zzazS = com_google_android_gms_internal_zzpb;
            this.zzazR = dataTypeCreateRequest;
            super(googleApiClient);
        }

        protected DataTypeResult zzJ(Status status) {
            return DataTypeResult.zzS(status);
        }

        protected void zza(zzoa com_google_android_gms_internal_zzoa) throws RemoteException {
            ((zzol) com_google_android_gms_internal_zzoa.zzqJ()).zza(new DataTypeCreateRequest(this.zzazR, new zza(null)));
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzJ(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpb.2 */
    class C11282 extends zza<DataTypeResult> {
        final /* synthetic */ zzpb zzazS;
        final /* synthetic */ String zzazT;

        C11282(zzpb com_google_android_gms_internal_zzpb, GoogleApiClient googleApiClient, String str) {
            this.zzazS = com_google_android_gms_internal_zzpb;
            this.zzazT = str;
            super(googleApiClient);
        }

        protected DataTypeResult zzJ(Status status) {
            return DataTypeResult.zzS(status);
        }

        protected void zza(zzoa com_google_android_gms_internal_zzoa) throws RemoteException {
            ((zzol) com_google_android_gms_internal_zzoa.zzqJ()).zza(new DataTypeReadRequest(this.zzazT, new zza(null)));
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzJ(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpb.3 */
    class C12943 extends zzc {
        final /* synthetic */ zzpb zzazS;

        C12943(zzpb com_google_android_gms_internal_zzpb, GoogleApiClient googleApiClient) {
            this.zzazS = com_google_android_gms_internal_zzpb;
            super(googleApiClient);
        }

        protected void zza(zzoa com_google_android_gms_internal_zzoa) throws RemoteException {
            ((zzol) com_google_android_gms_internal_zzoa.zzqJ()).zza(new DisableFitRequest(new zzph(this)));
        }
    }

    public PendingResult<DataTypeResult> createCustomDataType(GoogleApiClient client, DataTypeCreateRequest request) {
        return client.zzb(new C11271(this, client, request));
    }

    public PendingResult<Status> disableFit(GoogleApiClient client) {
        return client.zzb(new C12943(this, client));
    }

    public PendingResult<DataTypeResult> readDataType(GoogleApiClient client, String dataTypeName) {
        return client.zza(new C11282(this, client, dataTypeName));
    }
}
