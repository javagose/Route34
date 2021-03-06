package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzx;

public class zzld implements ProxyApi {

    /* renamed from: com.google.android.gms.internal.zzld.1 */
    class C11231 extends zzlc {
        final /* synthetic */ ProxyRequest zzWH;
        final /* synthetic */ zzld zzWI;

        /* renamed from: com.google.android.gms.internal.zzld.1.1 */
        class C11021 extends zzky {
            final /* synthetic */ C11231 zzWJ;

            C11021(C11231 c11231) {
                this.zzWJ = c11231;
            }

            public void zza(ProxyResponse proxyResponse) {
                this.zzWJ.zza(new zzle(proxyResponse));
            }
        }

        C11231(zzld com_google_android_gms_internal_zzld, GoogleApiClient googleApiClient, ProxyRequest proxyRequest) {
            this.zzWI = com_google_android_gms_internal_zzld;
            this.zzWH = proxyRequest;
            super(googleApiClient);
        }

        protected void zza(Context context, zzlb com_google_android_gms_internal_zzlb) throws RemoteException {
            com_google_android_gms_internal_zzlb.zza(new C11021(this), this.zzWH);
        }
    }

    public PendingResult<ProxyResult> performProxyRequest(GoogleApiClient client, ProxyRequest request) {
        zzx.zzz(client);
        zzx.zzz(request);
        return client.zzb(new C11231(this, client, request));
    }
}
