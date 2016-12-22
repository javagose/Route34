package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;

@zzhb
public final class zzfk<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final zzez zzCK;

    /* renamed from: com.google.android.gms.internal.zzfk.10 */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ zzfk zzCQ;
        final /* synthetic */ ErrorCode zzCR;

        AnonymousClass10(zzfk com_google_android_gms_internal_zzfk, ErrorCode errorCode) {
            this.zzCQ = com_google_android_gms_internal_zzfk;
            this.zzCR = errorCode;
        }

        public void run() {
            try {
                this.zzCQ.zzCK.onAdFailedToLoad(zzfl.zza(this.zzCR));
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzfk.1 */
    class C04161 implements Runnable {
        final /* synthetic */ zzfk zzCQ;

        C04161(zzfk com_google_android_gms_internal_zzfk) {
            this.zzCQ = com_google_android_gms_internal_zzfk;
        }

        public void run() {
            try {
                this.zzCQ.zzCK.onAdClicked();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClicked.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzfk.2 */
    class C04172 implements Runnable {
        final /* synthetic */ zzfk zzCQ;

        C04172(zzfk com_google_android_gms_internal_zzfk) {
            this.zzCQ = com_google_android_gms_internal_zzfk;
        }

        public void run() {
            try {
                this.zzCQ.zzCK.onAdOpened();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdOpened.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzfk.3 */
    class C04183 implements Runnable {
        final /* synthetic */ zzfk zzCQ;

        C04183(zzfk com_google_android_gms_internal_zzfk) {
            this.zzCQ = com_google_android_gms_internal_zzfk;
        }

        public void run() {
            try {
                this.zzCQ.zzCK.onAdLoaded();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLoaded.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzfk.4 */
    class C04194 implements Runnable {
        final /* synthetic */ zzfk zzCQ;

        C04194(zzfk com_google_android_gms_internal_zzfk) {
            this.zzCQ = com_google_android_gms_internal_zzfk;
        }

        public void run() {
            try {
                this.zzCQ.zzCK.onAdClosed();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClosed.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzfk.5 */
    class C04205 implements Runnable {
        final /* synthetic */ zzfk zzCQ;
        final /* synthetic */ ErrorCode zzCR;

        C04205(zzfk com_google_android_gms_internal_zzfk, ErrorCode errorCode) {
            this.zzCQ = com_google_android_gms_internal_zzfk;
            this.zzCR = errorCode;
        }

        public void run() {
            try {
                this.zzCQ.zzCK.onAdFailedToLoad(zzfl.zza(this.zzCR));
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzfk.6 */
    class C04216 implements Runnable {
        final /* synthetic */ zzfk zzCQ;

        C04216(zzfk com_google_android_gms_internal_zzfk) {
            this.zzCQ = com_google_android_gms_internal_zzfk;
        }

        public void run() {
            try {
                this.zzCQ.zzCK.onAdLeftApplication();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLeftApplication.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzfk.7 */
    class C04227 implements Runnable {
        final /* synthetic */ zzfk zzCQ;

        C04227(zzfk com_google_android_gms_internal_zzfk) {
            this.zzCQ = com_google_android_gms_internal_zzfk;
        }

        public void run() {
            try {
                this.zzCQ.zzCK.onAdOpened();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdOpened.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzfk.8 */
    class C04238 implements Runnable {
        final /* synthetic */ zzfk zzCQ;

        C04238(zzfk com_google_android_gms_internal_zzfk) {
            this.zzCQ = com_google_android_gms_internal_zzfk;
        }

        public void run() {
            try {
                this.zzCQ.zzCK.onAdLoaded();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLoaded.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzfk.9 */
    class C04249 implements Runnable {
        final /* synthetic */ zzfk zzCQ;

        C04249(zzfk com_google_android_gms_internal_zzfk) {
            this.zzCQ = com_google_android_gms_internal_zzfk;
        }

        public void run() {
            try {
                this.zzCQ.zzCK.onAdClosed();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClosed.", e);
            }
        }
    }

    public zzfk(zzez com_google_android_gms_internal_zzez) {
        this.zzCK = com_google_android_gms_internal_zzez;
    }

    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzaI("Adapter called onClick.");
        if (zzn.zzcS().zzhJ()) {
            try {
                this.zzCK.onAdClicked();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClicked.", e);
                return;
            }
        }
        zzb.zzaK("onClick must be called on the main UI thread.");
        zza.zzMS.post(new C04161(this));
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzaI("Adapter called onDismissScreen.");
        if (zzn.zzcS().zzhJ()) {
            try {
                this.zzCK.onAdClosed();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClosed.", e);
                return;
            }
        }
        zzb.zzaK("onDismissScreen must be called on the main UI thread.");
        zza.zzMS.post(new C04194(this));
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzb.zzaI("Adapter called onDismissScreen.");
        if (zzn.zzcS().zzhJ()) {
            try {
                this.zzCK.onAdClosed();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClosed.", e);
                return;
            }
        }
        zzb.zzaK("onDismissScreen must be called on the main UI thread.");
        zza.zzMS.post(new C04249(this));
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, ErrorCode errorCode) {
        zzb.zzaI("Adapter called onFailedToReceiveAd with error. " + errorCode);
        if (zzn.zzcS().zzhJ()) {
            try {
                this.zzCK.onAdFailedToLoad(zzfl.zza(errorCode));
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        zzb.zzaK("onFailedToReceiveAd must be called on the main UI thread.");
        zza.zzMS.post(new C04205(this, errorCode));
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, ErrorCode errorCode) {
        zzb.zzaI("Adapter called onFailedToReceiveAd with error " + errorCode + ".");
        if (zzn.zzcS().zzhJ()) {
            try {
                this.zzCK.onAdFailedToLoad(zzfl.zza(errorCode));
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        zzb.zzaK("onFailedToReceiveAd must be called on the main UI thread.");
        zza.zzMS.post(new AnonymousClass10(this, errorCode));
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzaI("Adapter called onLeaveApplication.");
        if (zzn.zzcS().zzhJ()) {
            try {
                this.zzCK.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        zzb.zzaK("onLeaveApplication must be called on the main UI thread.");
        zza.zzMS.post(new C04216(this));
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzb.zzaI("Adapter called onLeaveApplication.");
        if (zzn.zzcS().zzhJ()) {
            try {
                this.zzCK.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        zzb.zzaK("onLeaveApplication must be called on the main UI thread.");
        zza.zzMS.post(new Runnable() {
            final /* synthetic */ zzfk zzCQ;

            {
                this.zzCQ = r1;
            }

            public void run() {
                try {
                    this.zzCQ.zzCK.onAdLeftApplication();
                } catch (Throwable e) {
                    zzb.zzd("Could not call onAdLeftApplication.", e);
                }
            }
        });
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzaI("Adapter called onPresentScreen.");
        if (zzn.zzcS().zzhJ()) {
            try {
                this.zzCK.onAdOpened();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdOpened.", e);
                return;
            }
        }
        zzb.zzaK("onPresentScreen must be called on the main UI thread.");
        zza.zzMS.post(new C04227(this));
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzb.zzaI("Adapter called onPresentScreen.");
        if (zzn.zzcS().zzhJ()) {
            try {
                this.zzCK.onAdOpened();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdOpened.", e);
                return;
            }
        }
        zzb.zzaK("onPresentScreen must be called on the main UI thread.");
        zza.zzMS.post(new C04172(this));
    }

    public void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzaI("Adapter called onReceivedAd.");
        if (zzn.zzcS().zzhJ()) {
            try {
                this.zzCK.onAdLoaded();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLoaded.", e);
                return;
            }
        }
        zzb.zzaK("onReceivedAd must be called on the main UI thread.");
        zza.zzMS.post(new C04238(this));
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzb.zzaI("Adapter called onReceivedAd.");
        if (zzn.zzcS().zzhJ()) {
            try {
                this.zzCK.onAdLoaded();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLoaded.", e);
                return;
            }
        }
        zzb.zzaK("onReceivedAd must be called on the main UI thread.");
        zza.zzMS.post(new C04183(this));
    }
}
