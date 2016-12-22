package com.google.zxing.qrcode.decoder;

import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public enum Mode {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HANZI(new int[]{8, 10, 12}, 13);
    
    private final int bits;
    private final int[] characterCountBitsForVersions;

    private Mode(int[] characterCountBitsForVersions, int bits) {
        this.characterCountBitsForVersions = characterCountBitsForVersions;
        this.bits = bits;
    }

    public static Mode forBits(int bits) {
        switch (bits) {
            case Barcode.ALL_FORMATS /*0*/:
                return TERMINATOR;
            case CompletionEvent.STATUS_FAILURE /*1*/:
                return NUMERIC;
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                return ALPHANUMERIC;
            case CompletionEvent.STATUS_CANCELED /*3*/:
                return STRUCTURED_APPEND;
            case Barcode.PHONE /*4*/:
                return BYTE;
            case Barcode.PRODUCT /*5*/:
                return FNC1_FIRST_POSITION;
            case Barcode.TEXT /*7*/:
                return ECI;
            case Barcode.URL /*8*/:
                return KANJI;
            case Barcode.WIFI /*9*/:
                return FNC1_SECOND_POSITION;
            case ConnectionsStatusCodes.STATUS_ERROR /*13*/:
                return HANZI;
            default:
                throw new IllegalArgumentException();
        }
    }

    public int getCharacterCountBits(Version version) {
        int offset;
        int number = version.getVersionNumber();
        if (number <= 9) {
            offset = 0;
        } else if (number <= 26) {
            offset = 1;
        } else {
            offset = 2;
        }
        return this.characterCountBitsForVersions[offset];
    }

    public int getBits() {
        return this.bits;
    }
}
