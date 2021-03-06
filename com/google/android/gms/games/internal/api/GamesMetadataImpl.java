package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class GamesMetadataImpl implements GamesMetadata {

    private static abstract class LoadGameInstancesImpl extends BaseGamesApiMethodImpl<LoadGameInstancesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.LoadGameInstancesImpl.1 */
        class C10111 implements LoadGameInstancesResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ LoadGameInstancesImpl zzaGi;

            C10111(LoadGameInstancesImpl loadGameInstancesImpl, Status status) {
                this.zzaGi = loadGameInstancesImpl;
                this.zzZR = status;
            }

            public Status getStatus() {
                return this.zzZR;
            }

            public void release() {
            }
        }

        public LoadGameInstancesResult zzag(Status status) {
            return new C10111(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzag(status);
        }
    }

    private static abstract class LoadGameSearchSuggestionsImpl extends BaseGamesApiMethodImpl<LoadGameSearchSuggestionsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.LoadGameSearchSuggestionsImpl.1 */
        class C10121 implements LoadGameSearchSuggestionsResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ LoadGameSearchSuggestionsImpl zzaGj;

            C10121(LoadGameSearchSuggestionsImpl loadGameSearchSuggestionsImpl, Status status) {
                this.zzaGj = loadGameSearchSuggestionsImpl;
                this.zzZR = status;
            }

            public Status getStatus() {
                return this.zzZR;
            }

            public void release() {
            }
        }

        public LoadGameSearchSuggestionsResult zzah(Status status) {
            return new C10121(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzah(status);
        }
    }

    private static abstract class LoadGamesImpl extends BaseGamesApiMethodImpl<LoadGamesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.LoadGamesImpl.1 */
        class C10131 implements LoadGamesResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ LoadGamesImpl zzaGk;

            C10131(LoadGamesImpl loadGamesImpl, Status status) {
                this.zzaGk = loadGamesImpl;
                this.zzZR = status;
            }

            public GameBuffer getGames() {
                return new GameBuffer(DataHolder.zzbI(14));
            }

            public Status getStatus() {
                return this.zzZR;
            }

            public void release() {
            }
        }

        private LoadGamesImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadGamesResult zzai(Status status) {
            return new C10131(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzai(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.1 */
    class C12271 extends LoadGamesImpl {
        final /* synthetic */ GamesMetadataImpl zzaGg;

        C12271(GamesMetadataImpl gamesMetadataImpl, GoogleApiClient x0) {
            this.zzaGg = gamesMetadataImpl;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zze(this);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.2 */
    class C12282 extends LoadGameInstancesImpl {
        final /* synthetic */ String zzaFQ;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzj(this, this.zzaFQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.3 */
    class C12293 extends LoadGameSearchSuggestionsImpl {
        final /* synthetic */ String zzaGh;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzk(this, this.zzaGh);
        }
    }

    public Game getCurrentGame(GoogleApiClient apiClient) {
        return Games.zzh(apiClient).zzwy();
    }

    public PendingResult<LoadGamesResult> loadGame(GoogleApiClient apiClient) {
        return apiClient.zza(new C12271(this, apiClient));
    }
}
