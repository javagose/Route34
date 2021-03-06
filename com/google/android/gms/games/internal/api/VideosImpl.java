package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.video.VideoConfiguration;
import com.google.android.gms.games.video.Videos;
import com.google.android.gms.games.video.Videos.ListVideosResult;
import com.google.android.gms.games.video.Videos.VideoAvailableResult;
import com.google.android.gms.games.video.Videos.VideoCapabilitiesResult;

public final class VideosImpl implements Videos {

    /* renamed from: com.google.android.gms.games.internal.api.VideosImpl.1 */
    class C11211 extends BaseGamesApiMethodImpl<Status> {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String zzaHU;
        final /* synthetic */ VideoConfiguration zzaHV;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((BaseGamesApiMethodImpl) this, this.zzaFQ, this.zzaHU, this.zzaHV);
        }

        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    private static abstract class AvailableImpl extends BaseGamesApiMethodImpl<VideoAvailableResult> {

        /* renamed from: com.google.android.gms.games.internal.api.VideosImpl.AvailableImpl.1 */
        class C10461 implements VideoAvailableResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ AvailableImpl zzaHW;

            C10461(AvailableImpl availableImpl, Status status) {
                this.zzaHW = availableImpl;
                this.zzZR = status;
            }

            public Status getStatus() {
                return this.zzZR;
            }
        }

        public VideoAvailableResult zzaO(Status status) {
            return new C10461(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaO(status);
        }
    }

    private static abstract class CapabilitiesImpl extends BaseGamesApiMethodImpl<VideoCapabilitiesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.VideosImpl.CapabilitiesImpl.1 */
        class C10471 implements VideoCapabilitiesResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ CapabilitiesImpl zzaHX;

            C10471(CapabilitiesImpl capabilitiesImpl, Status status) {
                this.zzaHX = capabilitiesImpl;
                this.zzZR = status;
            }

            public Status getStatus() {
                return this.zzZR;
            }
        }

        public VideoCapabilitiesResult zzaP(Status status) {
            return new C10471(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaP(status);
        }
    }

    private static abstract class ListImpl extends BaseGamesApiMethodImpl<ListVideosResult> {

        /* renamed from: com.google.android.gms.games.internal.api.VideosImpl.ListImpl.1 */
        class C10481 implements ListVideosResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ ListImpl zzaHY;

            C10481(ListImpl listImpl, Status status) {
                this.zzaHY = listImpl;
                this.zzZR = status;
            }

            public Status getStatus() {
                return this.zzZR;
            }
        }

        public ListVideosResult zzaQ(Status status) {
            return new C10481(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaQ(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.VideosImpl.2 */
    class C12842 extends CapabilitiesImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzg(this);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.VideosImpl.3 */
    class C12853 extends AvailableImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzh(this);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.VideosImpl.4 */
    class C12864 extends ListImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzi(this);
        }
    }
}
