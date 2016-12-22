package com.google.android.gms.auth.api.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzr;
import com.google.android.gms.common.internal.zzx;
import java.util.HashSet;

public class zzc implements GoogleSignInApi {

    private abstract class zza<R extends Result> extends com.google.android.gms.common.api.internal.zza.zza<R, zzd> {
        final /* synthetic */ zzc zzXs;

        public zza(zzc com_google_android_gms_auth_api_signin_internal_zzc, GoogleApiClient googleApiClient) {
            this.zzXs = com_google_android_gms_auth_api_signin_internal_zzc;
            super(Auth.zzVx, googleApiClient);
        }
    }

    /* renamed from: com.google.android.gms.auth.api.signin.internal.zzc.1 */
    class C11131 extends zza<GoogleSignInResult> {
        final /* synthetic */ GoogleSignInOptions zzXr;
        final /* synthetic */ zzc zzXs;

        /* renamed from: com.google.android.gms.auth.api.signin.internal.zzc.1.1 */
        class C10861 extends zza {
            final /* synthetic */ zzq zzXt;
            final /* synthetic */ C11131 zzXu;

            C10861(C11131 c11131, zzq com_google_android_gms_auth_api_signin_internal_zzq) {
                this.zzXu = c11131;
                this.zzXt = com_google_android_gms_auth_api_signin_internal_zzq;
            }

            public void zza(GoogleSignInAccount googleSignInAccount, Status status) throws RemoteException {
                if (googleSignInAccount != null) {
                    this.zzXt.zzb(googleSignInAccount, this.zzXu.zzXr);
                }
                this.zzXu.zza(new GoogleSignInResult(googleSignInAccount, status));
            }
        }

        C11131(zzc com_google_android_gms_auth_api_signin_internal_zzc, GoogleApiClient googleApiClient, GoogleSignInOptions googleSignInOptions) {
            this.zzXs = com_google_android_gms_auth_api_signin_internal_zzc;
            this.zzXr = googleSignInOptions;
            super(com_google_android_gms_auth_api_signin_internal_zzc, googleApiClient);
        }

        protected void zza(zzd com_google_android_gms_auth_api_signin_internal_zzd) throws RemoteException {
            ((zzh) com_google_android_gms_auth_api_signin_internal_zzd.zzqJ()).zza(new C10861(this, zzq.zzaf(com_google_android_gms_auth_api_signin_internal_zzd.getContext())), this.zzXr);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzn(status);
        }

        protected GoogleSignInResult zzn(Status status) {
            return new GoogleSignInResult(null, status);
        }
    }

    /* renamed from: com.google.android.gms.auth.api.signin.internal.zzc.2 */
    class C11142 extends zza<Status> {
        final /* synthetic */ zzc zzXs;

        /* renamed from: com.google.android.gms.auth.api.signin.internal.zzc.2.1 */
        class C10871 extends zza {
            final /* synthetic */ C11142 zzXv;

            C10871(C11142 c11142) {
                this.zzXv = c11142;
            }

            public void zzl(Status status) throws RemoteException {
                this.zzXv.zza((Result) status);
            }
        }

        C11142(zzc com_google_android_gms_auth_api_signin_internal_zzc, GoogleApiClient googleApiClient) {
            this.zzXs = com_google_android_gms_auth_api_signin_internal_zzc;
            super(com_google_android_gms_auth_api_signin_internal_zzc, googleApiClient);
        }

        protected void zza(zzd com_google_android_gms_auth_api_signin_internal_zzd) throws RemoteException {
            ((zzh) com_google_android_gms_auth_api_signin_internal_zzd.zzqJ()).zzb(new C10871(this), com_google_android_gms_auth_api_signin_internal_zzd.zznd());
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    /* renamed from: com.google.android.gms.auth.api.signin.internal.zzc.3 */
    class C11153 extends zza<Status> {
        final /* synthetic */ zzc zzXs;

        /* renamed from: com.google.android.gms.auth.api.signin.internal.zzc.3.1 */
        class C10881 extends zza {
            final /* synthetic */ C11153 zzXw;

            C10881(C11153 c11153) {
                this.zzXw = c11153;
            }

            public void zzm(Status status) throws RemoteException {
                this.zzXw.zza((Result) status);
            }
        }

        C11153(zzc com_google_android_gms_auth_api_signin_internal_zzc, GoogleApiClient googleApiClient) {
            this.zzXs = com_google_android_gms_auth_api_signin_internal_zzc;
            super(com_google_android_gms_auth_api_signin_internal_zzc, googleApiClient);
        }

        protected void zza(zzd com_google_android_gms_auth_api_signin_internal_zzd) throws RemoteException {
            ((zzh) com_google_android_gms_auth_api_signin_internal_zzd.zzqJ()).zzc(new C10881(this), com_google_android_gms_auth_api_signin_internal_zzd.zznd());
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    private OptionalPendingResult<GoogleSignInResult> zza(GoogleApiClient googleApiClient, GoogleSignInOptions googleSignInOptions) {
        Log.d("GoogleSignInApiImpl", "trySilentSignIn");
        return new zzr(googleApiClient.zza(new C11131(this, googleApiClient, googleSignInOptions)));
    }

    private boolean zza(Account account, Account account2) {
        return account == null ? account2 == null : account.equals(account2);
    }

    private GoogleSignInOptions zzb(GoogleApiClient googleApiClient) {
        return ((zzd) googleApiClient.zza(Auth.zzVx)).zznd();
    }

    public Intent getSignInIntent(GoogleApiClient client) {
        zzx.zzz(client);
        return ((zzd) client.zza(Auth.zzVx)).zznc();
    }

    public GoogleSignInResult getSignInResultFromIntent(Intent data) {
        if (data == null || (!data.hasExtra("googleSignInStatus") && !data.hasExtra("googleSignInAccount"))) {
            return null;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) data.getParcelableExtra("googleSignInAccount");
        Status status = (Status) data.getParcelableExtra("googleSignInStatus");
        if (googleSignInAccount != null) {
            status = Status.zzagC;
        }
        return new GoogleSignInResult(googleSignInAccount, status);
    }

    public PendingResult<Status> revokeAccess(GoogleApiClient client) {
        zzq.zzaf(client.getContext()).zznr();
        for (GoogleApiClient zzoW : GoogleApiClient.zzoV()) {
            zzoW.zzoW();
        }
        return client.zzb(new C11153(this, client));
    }

    public PendingResult<Status> signOut(GoogleApiClient client) {
        zzq.zzaf(client.getContext()).zznr();
        for (GoogleApiClient zzoW : GoogleApiClient.zzoV()) {
            zzoW.zzoW();
        }
        return client.zzb(new C11142(this, client));
    }

    public OptionalPendingResult<GoogleSignInResult> silentSignIn(GoogleApiClient client) {
        GoogleSignInOptions zzb = zzb(client);
        Result zza = zza(client.getContext(), zzb);
        return zza != null ? PendingResults.zzb(zza, client) : zza(client, zzb);
    }

    public GoogleSignInResult zza(Context context, GoogleSignInOptions googleSignInOptions) {
        Log.d("GoogleSignInApiImpl", "getSavedSignInResultIfEligible");
        zzx.zzz(googleSignInOptions);
        zzq zzaf = zzq.zzaf(context);
        GoogleSignInOptions zznp = zzaf.zznp();
        if (zznp == null || !zza(zznp.getAccount(), googleSignInOptions.getAccount()) || googleSignInOptions.zzmP()) {
            return null;
        }
        if ((googleSignInOptions.zzmO() && (!zznp.zzmO() || !googleSignInOptions.zzmR().equals(zznp.zzmR()))) || !new HashSet(zznp.zzmN()).containsAll(new HashSet(googleSignInOptions.zzmN()))) {
            return null;
        }
        GoogleSignInAccount zzno = zzaf.zzno();
        return (zzno == null || zzno.zzb()) ? null : new GoogleSignInResult(zzno, Status.zzagC);
    }
}
