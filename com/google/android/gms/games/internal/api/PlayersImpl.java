package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadProfileSettingsResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class PlayersImpl implements Players {

    private static abstract class LoadPlayersImpl extends BaseGamesApiMethodImpl<LoadPlayersResult> {

        /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.LoadPlayersImpl.1 */
        class C10241 implements LoadPlayersResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ LoadPlayersImpl zzaGR;

            C10241(LoadPlayersImpl loadPlayersImpl, Status status) {
                this.zzaGR = loadPlayersImpl;
                this.zzZR = status;
            }

            public PlayerBuffer getPlayers() {
                return new PlayerBuffer(DataHolder.zzbI(14));
            }

            public Status getStatus() {
                return this.zzZR;
            }

            public void release() {
            }
        }

        private LoadPlayersImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadPlayersResult zzas(Status status) {
            return new C10241(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzas(status);
        }
    }

    private static abstract class LoadProfileSettingsResultImpl extends BaseGamesApiMethodImpl<LoadProfileSettingsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.LoadProfileSettingsResultImpl.1 */
        class C10251 implements LoadProfileSettingsResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ LoadProfileSettingsResultImpl zzaGS;

            C10251(LoadProfileSettingsResultImpl loadProfileSettingsResultImpl, Status status) {
                this.zzaGS = loadProfileSettingsResultImpl;
                this.zzZR = status;
            }

            public Status getStatus() {
                return this.zzZR;
            }
        }

        protected LoadProfileSettingsResult zzat(Status status) {
            return new C10251(this, status);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzat(status);
        }
    }

    private static abstract class LoadXpForGameCategoriesResultImpl extends BaseGamesApiMethodImpl<LoadXpForGameCategoriesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.LoadXpForGameCategoriesResultImpl.1 */
        class C10261 implements LoadXpForGameCategoriesResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ LoadXpForGameCategoriesResultImpl zzaGT;

            C10261(LoadXpForGameCategoriesResultImpl loadXpForGameCategoriesResultImpl, Status status) {
                this.zzaGT = loadXpForGameCategoriesResultImpl;
                this.zzZR = status;
            }

            public Status getStatus() {
                return this.zzZR;
            }
        }

        public LoadXpForGameCategoriesResult zzau(Status status) {
            return new C10261(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzau(status);
        }
    }

    private static abstract class LoadXpStreamResultImpl extends BaseGamesApiMethodImpl<LoadXpStreamResult> {

        /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.LoadXpStreamResultImpl.1 */
        class C10271 implements LoadXpStreamResult {
            final /* synthetic */ Status zzZR;
            final /* synthetic */ LoadXpStreamResultImpl zzaGU;

            C10271(LoadXpStreamResultImpl loadXpStreamResultImpl, Status status) {
                this.zzaGU = loadXpStreamResultImpl;
                this.zzZR = status;
            }

            public Status getStatus() {
                return this.zzZR;
            }
        }

        public LoadXpStreamResult zzav(Status status) {
            return new C10271(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzav(status);
        }
    }

    private static abstract class UpdateProfileSettingsResultImpl extends BaseGamesApiMethodImpl<Status> {
        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.10 */
    class AnonymousClass10 extends LoadPlayersImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ int zzaGL;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "nearby", this.zzaFQ, this.zzaGL, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.11 */
    class AnonymousClass11 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ int zzaGL;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "played_with", this.zzaFQ, this.zzaGL, false, this.zzaFO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.12 */
    class AnonymousClass12 extends LoadPlayersImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ int zzaGL;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "played_with", this.zzaFQ, this.zzaGL, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.13 */
    class AnonymousClass13 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ int zzaGL;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzaGL, false, this.zzaFO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.14 */
    class AnonymousClass14 extends LoadPlayersImpl {
        final /* synthetic */ int zzaGL;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzaGL, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.15 */
    class AnonymousClass15 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ int zzaGL;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzaGL, false, this.zzaFO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.16 */
    class AnonymousClass16 extends LoadPlayersImpl {
        final /* synthetic */ int zzaGL;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzaGL, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.17 */
    class AnonymousClass17 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ int zzaGL;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd(this, this.zzaGL, false, this.zzaFO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.18 */
    class AnonymousClass18 extends LoadPlayersImpl {
        final /* synthetic */ int zzaGL;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd(this, this.zzaGL, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.19 */
    class AnonymousClass19 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ int zzaGL;
        final /* synthetic */ String zzaGh;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, this.zzaGh, this.zzaGL, false, this.zzaFO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.1 */
    class C12451 extends LoadPlayersImpl {
        final /* synthetic */ PlayersImpl zzaGK;
        final /* synthetic */ String zzacQ;

        C12451(PlayersImpl playersImpl, GoogleApiClient x0, String str) {
            this.zzaGK = playersImpl;
            this.zzacQ = str;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzacQ, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.20 */
    class AnonymousClass20 extends LoadPlayersImpl {
        final /* synthetic */ int zzaGL;
        final /* synthetic */ String zzaGh;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, this.zzaGh, this.zzaGL, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.21 */
    class AnonymousClass21 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ String zzaGC;
        final /* synthetic */ int zzaGL;
        final /* synthetic */ String zzaGM;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzaGM, this.zzaGC, this.zzaGL, false, this.zzaFO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.22 */
    class AnonymousClass22 extends LoadPlayersImpl {
        final /* synthetic */ String zzaGC;
        final /* synthetic */ int zzaGL;
        final /* synthetic */ String zzaGM;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzaGM, this.zzaGC, this.zzaGL, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.23 */
    class AnonymousClass23 extends LoadXpForGameCategoriesResultImpl {
        final /* synthetic */ String zzaGN;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzl(this, this.zzaGN);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.24 */
    class AnonymousClass24 extends LoadXpStreamResultImpl {
        final /* synthetic */ String zzaGN;
        final /* synthetic */ int zzaGO;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzaGN, this.zzaGO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.25 */
    class AnonymousClass25 extends LoadXpStreamResultImpl {
        final /* synthetic */ String zzaGN;
        final /* synthetic */ int zzaGO;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb) this, this.zzaGN, this.zzaGO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.26 */
    class AnonymousClass26 extends LoadProfileSettingsResultImpl {
        final /* synthetic */ boolean zzaFO;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzg((zzb) this, this.zzaFO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.27 */
    class AnonymousClass27 extends UpdateProfileSettingsResultImpl {
        final /* synthetic */ boolean zzaGP;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzh((zzb) this, this.zzaGP);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.2 */
    class C12462 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ PlayersImpl zzaGK;
        final /* synthetic */ String zzacQ;

        C12462(PlayersImpl playersImpl, GoogleApiClient x0, String str, boolean z) {
            this.zzaGK = playersImpl;
            this.zzacQ = str;
            this.zzaFO = z;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzacQ, this.zzaFO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.3 */
    class C12473 extends LoadPlayersImpl {
        final /* synthetic */ String[] zzaGQ;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaGQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.4 */
    class C12484 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ PlayersImpl zzaGK;
        final /* synthetic */ int zzaGL;

        C12484(PlayersImpl playersImpl, GoogleApiClient x0, int i, boolean z) {
            this.zzaGK = playersImpl;
            this.zzaGL = i;
            this.zzaFO = z;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaGL, false, this.zzaFO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.5 */
    class C12495 extends LoadPlayersImpl {
        final /* synthetic */ PlayersImpl zzaGK;
        final /* synthetic */ int zzaGL;

        C12495(PlayersImpl playersImpl, GoogleApiClient x0, int i) {
            this.zzaGK = playersImpl;
            this.zzaGL = i;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaGL, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.6 */
    class C12506 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ PlayersImpl zzaGK;
        final /* synthetic */ int zzaGL;

        C12506(PlayersImpl playersImpl, GoogleApiClient x0, int i, boolean z) {
            this.zzaGK = playersImpl;
            this.zzaGL = i;
            this.zzaFO = z;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "played_with", this.zzaGL, false, this.zzaFO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.7 */
    class C12517 extends LoadPlayersImpl {
        final /* synthetic */ PlayersImpl zzaGK;
        final /* synthetic */ int zzaGL;

        C12517(PlayersImpl playersImpl, GoogleApiClient x0, int i) {
            this.zzaGK = playersImpl;
            this.zzaGL = i;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "played_with", this.zzaGL, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.8 */
    class C12528 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ PlayersImpl zzaGK;

        C12528(PlayersImpl playersImpl, GoogleApiClient x0, boolean z) {
            this.zzaGK = playersImpl;
            this.zzaFO = z;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaFO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.9 */
    class C12539 extends LoadPlayersImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ int zzaGL;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "nearby", this.zzaFQ, this.zzaGL, false, false);
        }
    }

    public Intent getCompareProfileIntent(GoogleApiClient apiClient, Player player) {
        return Games.zzh(apiClient).zza(new PlayerEntity(player));
    }

    public Player getCurrentPlayer(GoogleApiClient apiClient) {
        return Games.zzh(apiClient).zzwx();
    }

    public String getCurrentPlayerId(GoogleApiClient apiClient) {
        return Games.zzh(apiClient).zzah(true);
    }

    public Intent getPlayerSearchIntent(GoogleApiClient apiClient) {
        return Games.zzh(apiClient).zzwH();
    }

    public PendingResult<LoadPlayersResult> loadConnectedPlayers(GoogleApiClient apiClient, boolean forceReload) {
        return apiClient.zza(new C12528(this, apiClient, forceReload));
    }

    public PendingResult<LoadPlayersResult> loadInvitablePlayers(GoogleApiClient apiClient, int pageSize, boolean forceReload) {
        return apiClient.zza(new C12484(this, apiClient, pageSize, forceReload));
    }

    public PendingResult<LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient apiClient, int pageSize) {
        return apiClient.zza(new C12495(this, apiClient, pageSize));
    }

    public PendingResult<LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient apiClient, int pageSize) {
        return apiClient.zza(new C12517(this, apiClient, pageSize));
    }

    public PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient apiClient, String playerId) {
        return apiClient.zza(new C12451(this, apiClient, playerId));
    }

    public PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient apiClient, String playerId, boolean forceReload) {
        return apiClient.zza(new C12462(this, apiClient, playerId, forceReload));
    }

    public PendingResult<LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient apiClient, int pageSize, boolean forceReload) {
        return apiClient.zza(new C12506(this, apiClient, pageSize, forceReload));
    }
}
