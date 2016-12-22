package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.IsReadyToPayRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet;
import com.google.android.gms.wallet.Wallet.zza;

@SuppressLint({"MissingRemoteException"})
public class zzsd implements Payments {

    /* renamed from: com.google.android.gms.internal.zzsd.7 */
    class C11367 extends zza<BooleanResult> {
        final /* synthetic */ zzsd zzbqw;

        C11367(zzsd com_google_android_gms_internal_zzsd, GoogleApiClient googleApiClient) {
            this.zzbqw = com_google_android_gms_internal_zzsd;
            super(googleApiClient);
        }

        protected BooleanResult zzA(Status status) {
            return new BooleanResult(status, false);
        }

        protected void zza(zzse com_google_android_gms_internal_zzse) {
            com_google_android_gms_internal_zzse.zza(IsReadyToPayRequest.zzIj().zzIk(), (zzb) this);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzA(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzsd.1 */
    class C13261 extends Wallet.zzb {
        final /* synthetic */ int val$requestCode;
        final /* synthetic */ zzsd zzbqw;

        C13261(zzsd com_google_android_gms_internal_zzsd, GoogleApiClient googleApiClient, int i) {
            this.zzbqw = com_google_android_gms_internal_zzsd;
            this.val$requestCode = i;
            super(googleApiClient);
        }

        protected void zza(zzse com_google_android_gms_internal_zzse) {
            com_google_android_gms_internal_zzse.zzln(this.val$requestCode);
            zza(Status.zzagC);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzsd.2 */
    class C13272 extends Wallet.zzb {
        final /* synthetic */ int val$requestCode;
        final /* synthetic */ zzsd zzbqw;
        final /* synthetic */ MaskedWalletRequest zzbqx;

        C13272(zzsd com_google_android_gms_internal_zzsd, GoogleApiClient googleApiClient, MaskedWalletRequest maskedWalletRequest, int i) {
            this.zzbqw = com_google_android_gms_internal_zzsd;
            this.zzbqx = maskedWalletRequest;
            this.val$requestCode = i;
            super(googleApiClient);
        }

        protected void zza(zzse com_google_android_gms_internal_zzse) {
            com_google_android_gms_internal_zzse.zza(this.zzbqx, this.val$requestCode);
            zza(Status.zzagC);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzsd.3 */
    class C13283 extends Wallet.zzb {
        final /* synthetic */ int val$requestCode;
        final /* synthetic */ zzsd zzbqw;
        final /* synthetic */ FullWalletRequest zzbqy;

        C13283(zzsd com_google_android_gms_internal_zzsd, GoogleApiClient googleApiClient, FullWalletRequest fullWalletRequest, int i) {
            this.zzbqw = com_google_android_gms_internal_zzsd;
            this.zzbqy = fullWalletRequest;
            this.val$requestCode = i;
            super(googleApiClient);
        }

        protected void zza(zzse com_google_android_gms_internal_zzse) {
            com_google_android_gms_internal_zzse.zza(this.zzbqy, this.val$requestCode);
            zza(Status.zzagC);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzsd.4 */
    class C13294 extends Wallet.zzb {
        final /* synthetic */ int val$requestCode;
        final /* synthetic */ String zzbqA;
        final /* synthetic */ zzsd zzbqw;
        final /* synthetic */ String zzbqz;

        C13294(zzsd com_google_android_gms_internal_zzsd, GoogleApiClient googleApiClient, String str, String str2, int i) {
            this.zzbqw = com_google_android_gms_internal_zzsd;
            this.zzbqz = str;
            this.zzbqA = str2;
            this.val$requestCode = i;
            super(googleApiClient);
        }

        protected void zza(zzse com_google_android_gms_internal_zzse) {
            com_google_android_gms_internal_zzse.zzf(this.zzbqz, this.zzbqA, this.val$requestCode);
            zza(Status.zzagC);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzsd.5 */
    class C13305 extends Wallet.zzb {
        final /* synthetic */ NotifyTransactionStatusRequest zzbqB;
        final /* synthetic */ zzsd zzbqw;

        C13305(zzsd com_google_android_gms_internal_zzsd, GoogleApiClient googleApiClient, NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
            this.zzbqw = com_google_android_gms_internal_zzsd;
            this.zzbqB = notifyTransactionStatusRequest;
            super(googleApiClient);
        }

        protected void zza(zzse com_google_android_gms_internal_zzse) {
            com_google_android_gms_internal_zzse.zza(this.zzbqB);
            zza(Status.zzagC);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzsd.6 */
    class C13316 extends Wallet.zzb {
        final /* synthetic */ int val$requestCode;
        final /* synthetic */ zzsd zzbqw;

        C13316(zzsd com_google_android_gms_internal_zzsd, GoogleApiClient googleApiClient, int i) {
            this.zzbqw = com_google_android_gms_internal_zzsd;
            this.val$requestCode = i;
            super(googleApiClient);
        }

        protected void zza(zzse com_google_android_gms_internal_zzse) {
            com_google_android_gms_internal_zzse.zzlo(this.val$requestCode);
            zza(Status.zzagC);
        }
    }

    public void changeMaskedWallet(GoogleApiClient googleApiClient, String googleTransactionId, String merchantTransactionId, int requestCode) {
        googleApiClient.zza(new C13294(this, googleApiClient, googleTransactionId, merchantTransactionId, requestCode));
    }

    public void checkForPreAuthorization(GoogleApiClient googleApiClient, int requestCode) {
        googleApiClient.zza(new C13261(this, googleApiClient, requestCode));
    }

    public void isNewUser(GoogleApiClient googleApiClient, int requestCode) {
        googleApiClient.zza(new C13316(this, googleApiClient, requestCode));
    }

    public PendingResult<BooleanResult> isReadyToPay(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new C11367(this, googleApiClient));
    }

    public void loadFullWallet(GoogleApiClient googleApiClient, FullWalletRequest request, int requestCode) {
        googleApiClient.zza(new C13283(this, googleApiClient, request, requestCode));
    }

    public void loadMaskedWallet(GoogleApiClient googleApiClient, MaskedWalletRequest request, int requestCode) {
        googleApiClient.zza(new C13272(this, googleApiClient, request, requestCode));
    }

    public void notifyTransactionStatus(GoogleApiClient googleApiClient, NotifyTransactionStatusRequest request) {
        googleApiClient.zza(new C13305(this, googleApiClient, request));
    }
}
