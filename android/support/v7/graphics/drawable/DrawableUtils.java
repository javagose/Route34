package android.support.v7.graphics.drawable;

import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.vision.barcode.Barcode;

public class DrawableUtils {
    public static Mode parseTintMode(int value, Mode defaultMode) {
        switch (value) {
            case CompletionEvent.STATUS_CANCELED /*3*/:
                return Mode.SRC_OVER;
            case Barcode.PRODUCT /*5*/:
                return Mode.SRC_IN;
            case Barcode.WIFI /*9*/:
                return Mode.SRC_ATOP;
            case Place.TYPE_BUS_STATION /*14*/:
                return Mode.MULTIPLY;
            case Place.TYPE_CAFE /*15*/:
                return Mode.SCREEN;
            case Barcode.DATA_MATRIX /*16*/:
                if (VERSION.SDK_INT >= 11) {
                    return Mode.valueOf("ADD");
                }
                return defaultMode;
            default:
                return defaultMode;
        }
    }
}
