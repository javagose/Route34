package com.google.zxing.datamatrix.encoder;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import com.dahmani.javagose.cameratest.C0232R;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.vision.barcode.Barcode;
import me.dm7.barcodescanner.zxing.BuildConfig;

public final class ErrorCorrection {
    private static final int[] ALOG;
    private static final int[][] FACTORS;
    private static final int[] FACTOR_SETS;
    private static final int[] LOG;
    private static final int MODULO_VALUE = 301;

    static {
        FACTOR_SETS = new int[]{5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
        FACTORS = new int[][]{new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, 134, 240, 92, 254}, new int[]{28, 24, 185, 166, 223, 248, 116, MotionEventCompat.ACTION_MASK, 110, 61}, new int[]{175, 138, 205, 12, 194, 168, 39, 245, 60, 97, 120}, new int[]{41, 153, 158, 91, 61, 42, 142, 213, 97, 178, 100, 242}, new int[]{156, 97, 192, 252, 95, 9, 157, 119, 138, 45, 18, 186, 83, 185}, new int[]{83, 195, 100, 39, 188, 75, 66, 61, 241, 213, C0232R.styleable.Theme_switchStyle, 129, 94, 254, 225, 48, 90, 188}, new int[]{15, 195, 244, 9, 233, 71, 168, 2, 188, 160, 153, 145, 253, 79, C0232R.styleable.Theme_spinnerStyle, 82, 27, 174, 186, 172}, new int[]{52, 190, 88, 205, C0232R.styleable.Theme_switchStyle, 39, 176, 21, 155, 197, 251, 223, 155, 21, 5, 172, 254, MetadataChangeSet.CUSTOM_PROPERTY_SIZE_LIMIT_BYTES, 12, 181, BuildConfig.VERSION_CODE, 96, 50, 193}, new int[]{211, 231, 43, 97, 71, 96, Quests.SELECT_RECENTLY_FAILED, 174, 37, 151, 170, 53, 75, 34, 249, 121, 17, 138, 110, 213, 141, 136, 120, 151, 233, 168, 93, MotionEventCompat.ACTION_MASK}, new int[]{245, TransportMediator.KEYCODE_MEDIA_PAUSE, 242, 218, TransportMediator.KEYCODE_MEDIA_RECORD, Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 162, 181, LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY, 120, 84, 179, 220, 251, 80, 182, 229, 18, 2, 4, 68, 33, Quests.SELECT_COMPLETED_UNCLAIMED, 137, 95, 119, 115, 44, 175, BuildConfig.VERSION_CODE, 59, 25, 225, 98, 81, 112}, new int[]{77, 193, 137, 31, 19, 38, 22, 153, 247, LocationRequest.PRIORITY_NO_POWER, 122, 2, 245, 133, 242, 8, 175, 95, 100, 9, 167, LocationRequest.PRIORITY_NO_POWER, 214, 111, 57, 121, 21, 1, 253, 57, 54, Quests.SELECT_COMPLETED_UNCLAIMED, 248, 202, 69, 50, 150, 177, 226, 5, 9, 5}, new int[]{245, 132, 172, 223, 96, 32, 117, 22, 238, 133, 238, 231, 205, 188, 237, 87, 191, C0232R.styleable.Theme_ratingBarStyle, 16, 147, 118, 23, 37, 90, 170, 205, 131, 88, 120, 100, 66, 138, 186, 240, 82, 44, 176, 87, 187, 147, 160, 175, 69, 213, 92, 253, 225, 19}, new int[]{175, 9, 223, 238, 12, 17, 220, 208, 100, 29, 175, 170, 230, 192, 215, 235, 150, 159, 36, 223, 38, Callback.DEFAULT_DRAG_ANIMATION_DURATION, 132, 54, 228, 146, 218, 234, 117, 203, 29, 232, 144, 238, 22, 150, 201, 117, 62, 207, 164, 13, 137, 245, TransportMediator.KEYCODE_MEDIA_PAUSE, 67, 247, 28, 155, 43, 203, C0232R.styleable.Theme_seekBarStyle, 233, 53, 143, 46}, new int[]{242, 93, 169, 50, 144, 210, 39, 118, 202, 188, 201, 189, 143, C0232R.styleable.Theme_spinnerStyle, 196, 37, 185, 112, 134, 230, 245, 63, 197, 190, Callback.DEFAULT_SWIPE_ANIMATION_DURATION, C0232R.styleable.Theme_ratingBarStyle, 185, 221, 175, 64, 114, 71, 161, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, TransportMediator.KEYCODE_MEDIA_RECORD, 188, 17, 163, 31, 176, 170, 4, C0232R.styleable.Theme_seekBarStyle, 232, 7, 94, 166, 224, MetadataChangeSet.CUSTOM_PROPERTY_SIZE_LIMIT_BYTES, 86, 47, 11, 204}, new int[]{220, 228, 173, 89, 251, 149, 159, 56, 89, 33, 147, 244, 154, 36, 73, TransportMediator.KEYCODE_MEDIA_PAUSE, 213, 136, 248, 180, 234, 197, 158, 177, 68, 122, 93, 213, 15, 160, 227, 236, 66, 139, 153, 185, 202, 167, 179, 25, 220, 232, 96, 210, 231, 136, 223, 239, 181, 241, 59, 52, 172, 25, 49, 232, 211, 189, 64, 54, C0232R.styleable.Theme_spinnerStyle, 153, 132, 63, 96, Quests.SELECT_RECENTLY_FAILED, 82, 186}};
        LOG = new int[Barcode.QR_CODE];
        ALOG = new int[MotionEventCompat.ACTION_MASK];
        int p = 1;
        for (int i = 0; i < MotionEventCompat.ACTION_MASK; i++) {
            ALOG[i] = p;
            LOG[p] = i;
            p *= 2;
            if (p >= Barcode.QR_CODE) {
                p ^= MODULO_VALUE;
            }
        }
    }

    private ErrorCorrection() {
    }

    public static String encodeECC200(String codewords, SymbolInfo symbolInfo) {
        if (codewords.length() != symbolInfo.getDataCapacity()) {
            throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
        }
        StringBuilder sb = new StringBuilder(symbolInfo.getDataCapacity() + symbolInfo.getErrorCodewords());
        sb.append(codewords);
        int blockCount = symbolInfo.getInterleavedBlockCount();
        if (blockCount == 1) {
            sb.append(createECCBlock(codewords, symbolInfo.getErrorCodewords()));
        } else {
            sb.setLength(sb.capacity());
            int[] dataSizes = new int[blockCount];
            int[] errorSizes = new int[blockCount];
            int[] startPos = new int[blockCount];
            for (int i = 0; i < blockCount; i++) {
                dataSizes[i] = symbolInfo.getDataLengthForInterleavedBlock(i + 1);
                errorSizes[i] = symbolInfo.getErrorLengthForInterleavedBlock(i + 1);
                startPos[i] = 0;
                if (i > 0) {
                    startPos[i] = startPos[i - 1] + dataSizes[i];
                }
            }
            for (int block = 0; block < blockCount; block++) {
                StringBuilder temp = new StringBuilder(dataSizes[block]);
                for (int d = block; d < symbolInfo.getDataCapacity(); d += blockCount) {
                    temp.append(codewords.charAt(d));
                }
                String ecc = createECCBlock(temp.toString(), errorSizes[block]);
                int pos = 0;
                int e = block;
                while (e < errorSizes[block] * blockCount) {
                    int pos2 = pos + 1;
                    sb.setCharAt(symbolInfo.getDataCapacity() + e, ecc.charAt(pos));
                    e += blockCount;
                    pos = pos2;
                }
            }
        }
        return sb.toString();
    }

    private static String createECCBlock(CharSequence codewords, int numECWords) {
        return createECCBlock(codewords, 0, codewords.length(), numECWords);
    }

    private static String createECCBlock(CharSequence codewords, int start, int len, int numECWords) {
        int i;
        int table = -1;
        for (i = 0; i < FACTOR_SETS.length; i++) {
            if (FACTOR_SETS[i] == numECWords) {
                table = i;
                break;
            }
        }
        if (table < 0) {
            throw new IllegalArgumentException("Illegal number of error correction codewords specified: " + numECWords);
        }
        int[] poly = FACTORS[table];
        char[] ecc = new char[numECWords];
        for (i = 0; i < numECWords; i++) {
            ecc[i] = '\u0000';
        }
        for (i = start; i < start + len; i++) {
            int m = ecc[numECWords - 1] ^ codewords.charAt(i);
            int k = numECWords - 1;
            while (k > 0) {
                if (m == 0 || poly[k] == 0) {
                    ecc[k] = ecc[k - 1];
                } else {
                    ecc[k] = (char) (ecc[k - 1] ^ ALOG[(LOG[m] + LOG[poly[k]]) % MotionEventCompat.ACTION_MASK]);
                }
                k--;
            }
            if (m == 0 || poly[0] == 0) {
                ecc[0] = '\u0000';
            } else {
                ecc[0] = (char) ALOG[(LOG[m] + LOG[poly[0]]) % MotionEventCompat.ACTION_MASK];
            }
        }
        char[] eccReversed = new char[numECWords];
        for (i = 0; i < numECWords; i++) {
            eccReversed[i] = ecc[(numECWords - i) - 1];
        }
        return String.valueOf(eccReversed);
    }
}
