package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzr;
import java.util.LinkedList;
import java.util.List;

@zzhb
class zzdw {
    private final List<zza> zzpH;

    /* renamed from: com.google.android.gms.internal.zzdw.7 */
    class C03987 implements Runnable {
        final /* synthetic */ zzdw zzAc;
        final /* synthetic */ zza zzAo;
        final /* synthetic */ zzdx zzAp;

        C03987(zzdw com_google_android_gms_internal_zzdw, zza com_google_android_gms_internal_zzdw_zza, zzdx com_google_android_gms_internal_zzdx) {
            this.zzAc = com_google_android_gms_internal_zzdw;
            this.zzAo = com_google_android_gms_internal_zzdw_zza;
            this.zzAp = com_google_android_gms_internal_zzdx;
        }

        public void run() {
            try {
                this.zzAo.zzb(this.zzAp);
            } catch (Throwable e) {
                zzb.zzd("Could not propagate interstitial ad event.", e);
            }
        }
    }

    interface zza {
        void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException;
    }

    /* renamed from: com.google.android.gms.internal.zzdw.1 */
    class C10491 extends com.google.android.gms.ads.internal.client.zzq.zza {
        final /* synthetic */ zzdw zzAc;

        /* renamed from: com.google.android.gms.internal.zzdw.1.1 */
        class C08411 implements zza {
            final /* synthetic */ C10491 zzAd;

            C08411(C10491 c10491) {
                this.zzAd = c10491;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzpK != null) {
                    com_google_android_gms_internal_zzdx.zzpK.onAdClosed();
                }
                zzr.zzbN().zzee();
            }
        }

        /* renamed from: com.google.android.gms.internal.zzdw.1.2 */
        class C08422 implements zza {
            final /* synthetic */ C10491 zzAd;
            final /* synthetic */ int zzAe;

            C08422(C10491 c10491, int i) {
                this.zzAd = c10491;
                this.zzAe = i;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzpK != null) {
                    com_google_android_gms_internal_zzdx.zzpK.onAdFailedToLoad(this.zzAe);
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzdw.1.3 */
        class C08433 implements zza {
            final /* synthetic */ C10491 zzAd;

            C08433(C10491 c10491) {
                this.zzAd = c10491;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzpK != null) {
                    com_google_android_gms_internal_zzdx.zzpK.onAdLeftApplication();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzdw.1.4 */
        class C08444 implements zza {
            final /* synthetic */ C10491 zzAd;

            C08444(C10491 c10491) {
                this.zzAd = c10491;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzpK != null) {
                    com_google_android_gms_internal_zzdx.zzpK.onAdLoaded();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzdw.1.5 */
        class C08455 implements zza {
            final /* synthetic */ C10491 zzAd;

            C08455(C10491 c10491) {
                this.zzAd = c10491;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzpK != null) {
                    com_google_android_gms_internal_zzdx.zzpK.onAdOpened();
                }
            }
        }

        C10491(zzdw com_google_android_gms_internal_zzdw) {
            this.zzAc = com_google_android_gms_internal_zzdw;
        }

        public void onAdClosed() throws RemoteException {
            this.zzAc.zzpH.add(new C08411(this));
        }

        public void onAdFailedToLoad(int errorCode) throws RemoteException {
            this.zzAc.zzpH.add(new C08422(this, errorCode));
            zzin.m22v("Pooled interstitial failed to load.");
        }

        public void onAdLeftApplication() throws RemoteException {
            this.zzAc.zzpH.add(new C08433(this));
        }

        public void onAdLoaded() throws RemoteException {
            this.zzAc.zzpH.add(new C08444(this));
            zzin.m22v("Pooled interstitial loaded.");
        }

        public void onAdOpened() throws RemoteException {
            this.zzAc.zzpH.add(new C08455(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdw.2 */
    class C10502 extends com.google.android.gms.ads.internal.client.zzw.zza {
        final /* synthetic */ zzdw zzAc;

        /* renamed from: com.google.android.gms.internal.zzdw.2.1 */
        class C08461 implements zza {
            final /* synthetic */ String val$name;
            final /* synthetic */ String zzAf;
            final /* synthetic */ C10502 zzAg;

            C08461(C10502 c10502, String str, String str2) {
                this.zzAg = c10502;
                this.val$name = str;
                this.zzAf = str2;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzAq != null) {
                    com_google_android_gms_internal_zzdx.zzAq.onAppEvent(this.val$name, this.zzAf);
                }
            }
        }

        C10502(zzdw com_google_android_gms_internal_zzdw) {
            this.zzAc = com_google_android_gms_internal_zzdw;
        }

        public void onAppEvent(String name, String info) throws RemoteException {
            this.zzAc.zzpH.add(new C08461(this, name, info));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdw.3 */
    class C10513 extends com.google.android.gms.internal.zzgd.zza {
        final /* synthetic */ zzdw zzAc;

        /* renamed from: com.google.android.gms.internal.zzdw.3.1 */
        class C08471 implements zza {
            final /* synthetic */ zzgc zzAh;
            final /* synthetic */ C10513 zzAi;

            C08471(C10513 c10513, zzgc com_google_android_gms_internal_zzgc) {
                this.zzAi = c10513;
                this.zzAh = com_google_android_gms_internal_zzgc;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzAr != null) {
                    com_google_android_gms_internal_zzdx.zzAr.zza(this.zzAh);
                }
            }
        }

        C10513(zzdw com_google_android_gms_internal_zzdw) {
            this.zzAc = com_google_android_gms_internal_zzdw;
        }

        public void zza(zzgc com_google_android_gms_internal_zzgc) throws RemoteException {
            this.zzAc.zzpH.add(new C08471(this, com_google_android_gms_internal_zzgc));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdw.4 */
    class C10524 extends com.google.android.gms.internal.zzcf.zza {
        final /* synthetic */ zzdw zzAc;

        /* renamed from: com.google.android.gms.internal.zzdw.4.1 */
        class C08481 implements zza {
            final /* synthetic */ zzce zzAj;
            final /* synthetic */ C10524 zzAk;

            C08481(C10524 c10524, zzce com_google_android_gms_internal_zzce) {
                this.zzAk = c10524;
                this.zzAj = com_google_android_gms_internal_zzce;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzAs != null) {
                    com_google_android_gms_internal_zzdx.zzAs.zza(this.zzAj);
                }
            }
        }

        C10524(zzdw com_google_android_gms_internal_zzdw) {
            this.zzAc = com_google_android_gms_internal_zzdw;
        }

        public void zza(zzce com_google_android_gms_internal_zzce) throws RemoteException {
            this.zzAc.zzpH.add(new C08481(this, com_google_android_gms_internal_zzce));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdw.5 */
    class C10535 extends com.google.android.gms.ads.internal.client.zzp.zza {
        final /* synthetic */ zzdw zzAc;

        /* renamed from: com.google.android.gms.internal.zzdw.5.1 */
        class C08491 implements zza {
            final /* synthetic */ C10535 zzAl;

            C08491(C10535 c10535) {
                this.zzAl = c10535;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzAt != null) {
                    com_google_android_gms_internal_zzdx.zzAt.onAdClicked();
                }
            }
        }

        C10535(zzdw com_google_android_gms_internal_zzdw) {
            this.zzAc = com_google_android_gms_internal_zzdw;
        }

        public void onAdClicked() throws RemoteException {
            this.zzAc.zzpH.add(new C08491(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdw.6 */
    class C10546 extends com.google.android.gms.ads.internal.reward.client.zzd.zza {
        final /* synthetic */ zzdw zzAc;

        /* renamed from: com.google.android.gms.internal.zzdw.6.1 */
        class C08501 implements zza {
            final /* synthetic */ C10546 zzAm;

            C08501(C10546 c10546) {
                this.zzAm = c10546;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzAu != null) {
                    com_google_android_gms_internal_zzdx.zzAu.onRewardedVideoAdLoaded();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzdw.6.2 */
        class C08512 implements zza {
            final /* synthetic */ C10546 zzAm;

            C08512(C10546 c10546) {
                this.zzAm = c10546;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzAu != null) {
                    com_google_android_gms_internal_zzdx.zzAu.onRewardedVideoAdOpened();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzdw.6.3 */
        class C08523 implements zza {
            final /* synthetic */ C10546 zzAm;

            C08523(C10546 c10546) {
                this.zzAm = c10546;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzAu != null) {
                    com_google_android_gms_internal_zzdx.zzAu.onRewardedVideoStarted();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzdw.6.4 */
        class C08534 implements zza {
            final /* synthetic */ C10546 zzAm;

            C08534(C10546 c10546) {
                this.zzAm = c10546;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzAu != null) {
                    com_google_android_gms_internal_zzdx.zzAu.onRewardedVideoAdClosed();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzdw.6.5 */
        class C08545 implements zza {
            final /* synthetic */ C10546 zzAm;
            final /* synthetic */ com.google.android.gms.ads.internal.reward.client.zza zzAn;

            C08545(C10546 c10546, com.google.android.gms.ads.internal.reward.client.zza com_google_android_gms_ads_internal_reward_client_zza) {
                this.zzAm = c10546;
                this.zzAn = com_google_android_gms_ads_internal_reward_client_zza;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzAu != null) {
                    com_google_android_gms_internal_zzdx.zzAu.zza(this.zzAn);
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzdw.6.6 */
        class C08556 implements zza {
            final /* synthetic */ C10546 zzAm;

            C08556(C10546 c10546) {
                this.zzAm = c10546;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzAu != null) {
                    com_google_android_gms_internal_zzdx.zzAu.onRewardedVideoAdLeftApplication();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzdw.6.7 */
        class C08567 implements zza {
            final /* synthetic */ int zzAe;
            final /* synthetic */ C10546 zzAm;

            C08567(C10546 c10546, int i) {
                this.zzAm = c10546;
                this.zzAe = i;
            }

            public void zzb(zzdx com_google_android_gms_internal_zzdx) throws RemoteException {
                if (com_google_android_gms_internal_zzdx.zzAu != null) {
                    com_google_android_gms_internal_zzdx.zzAu.onRewardedVideoAdFailedToLoad(this.zzAe);
                }
            }
        }

        C10546(zzdw com_google_android_gms_internal_zzdw) {
            this.zzAc = com_google_android_gms_internal_zzdw;
        }

        public void onRewardedVideoAdClosed() throws RemoteException {
            this.zzAc.zzpH.add(new C08534(this));
        }

        public void onRewardedVideoAdFailedToLoad(int errorCode) throws RemoteException {
            this.zzAc.zzpH.add(new C08567(this, errorCode));
        }

        public void onRewardedVideoAdLeftApplication() throws RemoteException {
            this.zzAc.zzpH.add(new C08556(this));
        }

        public void onRewardedVideoAdLoaded() throws RemoteException {
            this.zzAc.zzpH.add(new C08501(this));
        }

        public void onRewardedVideoAdOpened() throws RemoteException {
            this.zzAc.zzpH.add(new C08512(this));
        }

        public void onRewardedVideoStarted() throws RemoteException {
            this.zzAc.zzpH.add(new C08523(this));
        }

        public void zza(com.google.android.gms.ads.internal.reward.client.zza com_google_android_gms_ads_internal_reward_client_zza) throws RemoteException {
            this.zzAc.zzpH.add(new C08545(this, com_google_android_gms_ads_internal_reward_client_zza));
        }
    }

    zzdw() {
        this.zzpH = new LinkedList();
    }

    void zza(zzdx com_google_android_gms_internal_zzdx) {
        Handler handler = zzir.zzMc;
        for (zza c03987 : this.zzpH) {
            handler.post(new C03987(this, c03987, com_google_android_gms_internal_zzdx));
        }
    }

    void zzc(zzk com_google_android_gms_ads_internal_zzk) {
        com_google_android_gms_ads_internal_zzk.zza(new C10491(this));
        com_google_android_gms_ads_internal_zzk.zza(new C10502(this));
        com_google_android_gms_ads_internal_zzk.zza(new C10513(this));
        com_google_android_gms_ads_internal_zzk.zza(new C10524(this));
        com_google_android_gms_ads_internal_zzk.zza(new C10535(this));
        com_google_android_gms_ads_internal_zzk.zza(new C10546(this));
    }
}
