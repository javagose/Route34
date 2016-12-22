package com.google.android.gms.auth.api.credentials.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.games.GamesStatusCodes;

public final class zzd implements CredentialsApi {

    private static class zza extends zza {
        private zzb<Status> zzWz;

        zza(zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status) {
            this.zzWz = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status;
        }

        public void zzg(Status status) {
            this.zzWz.zzs(status);
        }
    }

    /* renamed from: com.google.android.gms.auth.api.credentials.internal.zzd.1 */
    class C11091 extends zze<CredentialRequestResult> {
        final /* synthetic */ CredentialRequest zzWv;
        final /* synthetic */ zzd zzWw;

        /* renamed from: com.google.android.gms.auth.api.credentials.internal.zzd.1.1 */
        class C10851 extends zza {
            final /* synthetic */ C11091 zzWx;

            C10851(C11091 c11091) {
                this.zzWx = c11091;
            }

            public void zza(Status status, Credential credential) {
                this.zzWx.zza(new zzc(status, credential));
            }

            public void zzg(Status status) {
                this.zzWx.zza(zzc.zzh(status));
            }
        }

        C11091(zzd com_google_android_gms_auth_api_credentials_internal_zzd, GoogleApiClient googleApiClient, CredentialRequest credentialRequest) {
            this.zzWw = com_google_android_gms_auth_api_credentials_internal_zzd;
            this.zzWv = credentialRequest;
            super(googleApiClient);
        }

        protected void zza(Context context, zzj com_google_android_gms_auth_api_credentials_internal_zzj) throws RemoteException {
            com_google_android_gms_auth_api_credentials_internal_zzj.zza(new C10851(this), this.zzWv);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzi(status);
        }

        protected CredentialRequestResult zzi(Status status) {
            return zzc.zzh(status);
        }
    }

    /* renamed from: com.google.android.gms.auth.api.credentials.internal.zzd.2 */
    class C11102 extends zze<Status> {
        final /* synthetic */ zzd zzWw;
        final /* synthetic */ Credential zzWy;

        C11102(zzd com_google_android_gms_auth_api_credentials_internal_zzd, GoogleApiClient googleApiClient, Credential credential) {
            this.zzWw = com_google_android_gms_auth_api_credentials_internal_zzd;
            this.zzWy = credential;
            super(googleApiClient);
        }

        protected void zza(Context context, zzj com_google_android_gms_auth_api_credentials_internal_zzj) throws RemoteException {
            com_google_android_gms_auth_api_credentials_internal_zzj.zza(new zza(this), new SaveRequest(this.zzWy));
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    /* renamed from: com.google.android.gms.auth.api.credentials.internal.zzd.3 */
    class C11113 extends zze<Status> {
        final /* synthetic */ zzd zzWw;
        final /* synthetic */ Credential zzWy;

        C11113(zzd com_google_android_gms_auth_api_credentials_internal_zzd, GoogleApiClient googleApiClient, Credential credential) {
            this.zzWw = com_google_android_gms_auth_api_credentials_internal_zzd;
            this.zzWy = credential;
            super(googleApiClient);
        }

        protected void zza(Context context, zzj com_google_android_gms_auth_api_credentials_internal_zzj) throws RemoteException {
            com_google_android_gms_auth_api_credentials_internal_zzj.zza(new zza(this), new DeleteRequest(this.zzWy));
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    /* renamed from: com.google.android.gms.auth.api.credentials.internal.zzd.4 */
    class C11124 extends zze<Status> {
        final /* synthetic */ zzd zzWw;

        C11124(zzd com_google_android_gms_auth_api_credentials_internal_zzd, GoogleApiClient googleApiClient) {
            this.zzWw = com_google_android_gms_auth_api_credentials_internal_zzd;
            super(googleApiClient);
        }

        protected void zza(Context context, zzj com_google_android_gms_auth_api_credentials_internal_zzj) throws RemoteException {
            com_google_android_gms_auth_api_credentials_internal_zzj.zza(new zza(this));
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    private PasswordSpecification zza(GoogleApiClient googleApiClient) {
        AuthCredentialsOptions zzmD = ((zzf) googleApiClient.zza(Auth.zzVu)).zzmD();
        return (zzmD == null || zzmD.zzmr() == null) ? PasswordSpecification.zzWl : zzmD.zzmr();
    }

    public PendingResult<Status> delete(GoogleApiClient client, Credential credential) {
        return client.zzb(new C11113(this, client, credential));
    }

    public PendingResult<Status> disableAutoSignIn(GoogleApiClient client) {
        return client.zzb(new C11124(this, client));
    }

    public PendingIntent getHintPickerIntent(GoogleApiClient client, HintRequest request) {
        zzx.zzb((Object) client, (Object) "client must not be null");
        zzx.zzb((Object) request, (Object) "request must not be null");
        zzx.zzb(client.zza(Auth.CREDENTIALS_API), (Object) "Auth.CREDENTIALS_API must be added to GoogleApiClient to use this API");
        return PendingIntent.getActivity(client.getContext(), GamesStatusCodes.STATUS_REQUEST_UPDATE_PARTIAL_SUCCESS, zzb.zza(client.getContext(), request, zza(client)), DriveFile.MODE_READ_ONLY);
    }

    public PendingResult<CredentialRequestResult> request(GoogleApiClient client, CredentialRequest request) {
        return client.zza(new C11091(this, client, request));
    }

    public PendingResult<Status> save(GoogleApiClient client, Credential credential) {
        return client.zzb(new C11102(this, client, credential));
    }
}
