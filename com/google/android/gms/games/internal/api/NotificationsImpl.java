package com.google.android.gms.games.internal.api;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class NotificationsImpl implements Notifications {

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.1 */
    class C11181 extends BaseGamesApiMethodImpl<GameMuteStatusChangeResult> {
        final /* synthetic */ String zzaGC;

        /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.1.1 */
        class C10191 implements GameMuteStatusChangeResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ C11181 zzaGD;

            C10191(C11181 c11181, Status status) {
                this.zzaGD = c11181;
                this.zzZR = status;
            }

            public Status getStatus() {
                return this.zzZR;
            }
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb) this, this.zzaGC, true);
        }

        public GameMuteStatusChangeResult zzao(Status status) {
            return new C10191(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzao(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.2 */
    class C11192 extends BaseGamesApiMethodImpl<GameMuteStatusChangeResult> {
        final /* synthetic */ String zzaGC;

        /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.2.1 */
        class C10201 implements GameMuteStatusChangeResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ C11192 zzaGE;

            C10201(C11192 c11192, Status status) {
                this.zzaGE = c11192;
                this.zzZR = status;
            }

            public Status getStatus() {
                return this.zzZR;
            }
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb) this, this.zzaGC, false);
        }

        public GameMuteStatusChangeResult zzao(Status status) {
            return new C10201(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzao(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.3 */
    class C11203 extends BaseGamesApiMethodImpl<GameMuteStatusLoadResult> {
        final /* synthetic */ String zzaGC;

        /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.3.1 */
        class C10211 implements GameMuteStatusLoadResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ C11203 zzaGF;

            C10211(C11203 c11203, Status status) {
                this.zzaGF = c11203;
                this.zzZR = status;
            }

            public Status getStatus() {
                return this.zzZR;
            }
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzo(this, this.zzaGC);
        }

        public GameMuteStatusLoadResult zzap(Status status) {
            return new C10211(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzap(status);
        }
    }

    private static abstract class ContactSettingLoadImpl extends BaseGamesApiMethodImpl<ContactSettingLoadResult> {

        /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.ContactSettingLoadImpl.1 */
        class C10221 implements ContactSettingLoadResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ ContactSettingLoadImpl zzaGI;

            C10221(ContactSettingLoadImpl contactSettingLoadImpl, Status status) {
                this.zzaGI = contactSettingLoadImpl;
                this.zzZR = status;
            }

            public Status getStatus() {
                return this.zzZR;
            }
        }

        public ContactSettingLoadResult zzaq(Status status) {
            return new C10221(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaq(status);
        }
    }

    private static abstract class ContactSettingUpdateImpl extends BaseGamesApiMethodImpl<Status> {
        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    private static abstract class InboxCountImpl extends BaseGamesApiMethodImpl<InboxCountResult> {

        /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.InboxCountImpl.1 */
        class C10231 implements InboxCountResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ InboxCountImpl zzaGJ;

            C10231(InboxCountImpl inboxCountImpl, Status status) {
                this.zzaGJ = inboxCountImpl;
                this.zzZR = status;
            }

            public Status getStatus() {
                return this.zzZR;
            }
        }

        public InboxCountResult zzar(Status status) {
            return new C10231(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzar(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.4 */
    class C12424 extends ContactSettingLoadImpl {
        final /* synthetic */ boolean zzaFO;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzi((zzb) this, this.zzaFO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.5 */
    class C12435 extends ContactSettingUpdateImpl {
        final /* synthetic */ boolean zzaGG;
        final /* synthetic */ Bundle zzaGH;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaGG, this.zzaGH);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.6 */
    class C12446 extends InboxCountImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzk(this);
        }
    }

    public void clear(GoogleApiClient apiClient, int notificationTypes) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzgt(notificationTypes);
        }
    }

    public void clearAll(GoogleApiClient apiClient) {
        clear(apiClient, 31);
    }
}
