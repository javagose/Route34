package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.location.internal.ParcelableGeofence;

public interface Geofence {
    public static final int GEOFENCE_TRANSITION_DWELL = 4;
    public static final int GEOFENCE_TRANSITION_ENTER = 1;
    public static final int GEOFENCE_TRANSITION_EXIT = 2;
    public static final long NEVER_EXPIRE = -1;

    public static final class Builder {
        private String zzEY;
        private int zzaNC;
        private long zzaND;
        private short zzaNE;
        private double zzaNF;
        private double zzaNG;
        private float zzaNH;
        private int zzaNI;
        private int zzaNJ;

        public Builder() {
            this.zzEY = null;
            this.zzaNC = 0;
            this.zzaND = Long.MIN_VALUE;
            this.zzaNE = (short) -1;
            this.zzaNI = 0;
            this.zzaNJ = -1;
        }

        public Geofence build() {
            if (this.zzEY == null) {
                throw new IllegalArgumentException("Request ID not set.");
            } else if (this.zzaNC == 0) {
                throw new IllegalArgumentException("Transitions types not set.");
            } else if ((this.zzaNC & Geofence.GEOFENCE_TRANSITION_DWELL) != 0 && this.zzaNJ < 0) {
                throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
            } else if (this.zzaND == Long.MIN_VALUE) {
                throw new IllegalArgumentException("Expiration not set.");
            } else if (this.zzaNE == (short) -1) {
                throw new IllegalArgumentException("Geofence region not set.");
            } else if (this.zzaNI >= 0) {
                return new ParcelableGeofence(this.zzEY, this.zzaNC, (short) 1, this.zzaNF, this.zzaNG, this.zzaNH, this.zzaND, this.zzaNI, this.zzaNJ);
            } else {
                throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
            }
        }

        public Builder setCircularRegion(double latitude, double longitude, float radius) {
            this.zzaNE = (short) 1;
            this.zzaNF = latitude;
            this.zzaNG = longitude;
            this.zzaNH = radius;
            return this;
        }

        public Builder setExpirationDuration(long durationMillis) {
            if (durationMillis < 0) {
                this.zzaND = Geofence.NEVER_EXPIRE;
            } else {
                this.zzaND = SystemClock.elapsedRealtime() + durationMillis;
            }
            return this;
        }

        public Builder setLoiteringDelay(int loiteringDelayMs) {
            this.zzaNJ = loiteringDelayMs;
            return this;
        }

        public Builder setNotificationResponsiveness(int notificationResponsivenessMs) {
            this.zzaNI = notificationResponsivenessMs;
            return this;
        }

        public Builder setRequestId(String requestId) {
            this.zzEY = requestId;
            return this;
        }

        public Builder setTransitionTypes(int transitionTypes) {
            this.zzaNC = transitionTypes;
            return this;
        }
    }

    String getRequestId();
}
