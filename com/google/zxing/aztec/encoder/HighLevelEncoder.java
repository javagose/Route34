package com.google.zxing.aztec.encoder;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.zxing.common.BitArray;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class HighLevelEncoder {
    private static final int[][] CHAR_MAP;
    static final int[][] LATCH_TABLE;
    static final int MODE_DIGIT = 2;
    static final int MODE_LOWER = 1;
    static final int MODE_MIXED = 3;
    static final String[] MODE_NAMES;
    static final int MODE_PUNCT = 4;
    static final int MODE_UPPER = 0;
    static final int[][] SHIFT_TABLE;
    private final byte[] text;

    /* renamed from: com.google.zxing.aztec.encoder.HighLevelEncoder.1 */
    class C05951 implements Comparator<State> {
        C05951() {
        }

        public int compare(State a, State b) {
            return a.getBitCount() - b.getBitCount();
        }
    }

    static {
        int c;
        int i;
        MODE_NAMES = new String[]{"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};
        LATCH_TABLE = new int[][]{new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};
        CHAR_MAP = (int[][]) Array.newInstance(Integer.TYPE, new int[]{5, Barcode.QR_CODE});
        CHAR_MAP[0][32] = MODE_LOWER;
        for (c = 65; c <= 90; c += MODE_LOWER) {
            CHAR_MAP[0][c] = (c - 65) + MODE_DIGIT;
        }
        CHAR_MAP[MODE_LOWER][32] = MODE_LOWER;
        for (c = 97; c <= 122; c += MODE_LOWER) {
            CHAR_MAP[MODE_LOWER][c] = (c - 97) + MODE_DIGIT;
        }
        CHAR_MAP[MODE_DIGIT][32] = MODE_LOWER;
        for (c = 48; c <= 57; c += MODE_LOWER) {
            CHAR_MAP[MODE_DIGIT][c] = (c - 48) + MODE_DIGIT;
        }
        CHAR_MAP[MODE_DIGIT][44] = 12;
        CHAR_MAP[MODE_DIGIT][46] = 13;
        int[] mixedTable = new int[]{0, 32, MODE_LOWER, MODE_DIGIT, MODE_MIXED, MODE_PUNCT, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, MetadataChangeSet.CUSTOM_PROPERTY_SIZE_LIMIT_BYTES, TransportMediator.KEYCODE_MEDIA_PLAY, TransportMediator.KEYCODE_MEDIA_PAUSE};
        for (i = 0; i < mixedTable.length; i += MODE_LOWER) {
            CHAR_MAP[MODE_MIXED][mixedTable[i]] = i;
        }
        int[] punctTable = new int[]{0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (i = 0; i < punctTable.length; i += MODE_LOWER) {
            if (punctTable[i] > 0) {
                CHAR_MAP[MODE_PUNCT][punctTable[i]] = i;
            }
        }
        SHIFT_TABLE = (int[][]) Array.newInstance(Integer.TYPE, new int[]{6, 6});
        int[][] iArr = SHIFT_TABLE;
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2 += MODE_LOWER) {
            Arrays.fill(iArr[i2], -1);
        }
        SHIFT_TABLE[0][MODE_PUNCT] = 0;
        SHIFT_TABLE[MODE_LOWER][MODE_PUNCT] = 0;
        SHIFT_TABLE[MODE_LOWER][0] = 28;
        SHIFT_TABLE[MODE_MIXED][MODE_PUNCT] = 0;
        SHIFT_TABLE[MODE_DIGIT][MODE_PUNCT] = 0;
        SHIFT_TABLE[MODE_DIGIT][0] = 15;
    }

    public HighLevelEncoder(byte[] text) {
        this.text = text;
    }

    public BitArray encode() {
        Collection<State> states = Collections.singletonList(State.INITIAL_STATE);
        int index = 0;
        while (index < this.text.length) {
            int nextChar;
            int pairCode;
            if (index + MODE_LOWER < this.text.length) {
                nextChar = this.text[index + MODE_LOWER];
            } else {
                nextChar = 0;
            }
            switch (this.text[index]) {
                case ConnectionsStatusCodes.STATUS_ERROR /*13*/:
                    if (nextChar == 10) {
                        pairCode = MODE_DIGIT;
                    } else {
                        pairCode = 0;
                    }
                    break;
                case Place.TYPE_GYM /*44*/:
                    if (nextChar == 32) {
                        pairCode = MODE_PUNCT;
                    } else {
                        pairCode = 0;
                    }
                    break;
                case Place.TYPE_HARDWARE_STORE /*46*/:
                    if (nextChar == 32) {
                        pairCode = MODE_MIXED;
                    } else {
                        pairCode = 0;
                    }
                    break;
                case Place.TYPE_LOCKSMITH /*58*/:
                    if (nextChar == 32) {
                        pairCode = 5;
                    } else {
                        pairCode = 0;
                    }
                    break;
                default:
                    pairCode = 0;
                    break;
            }
            if (pairCode > 0) {
                states = updateStateListForPair(states, index, pairCode);
                index += MODE_LOWER;
            } else {
                states = updateStateListForChar(states, index);
            }
            index += MODE_LOWER;
        }
        return ((State) Collections.min(states, new C05951())).toBitArray(this.text);
    }

    private Collection<State> updateStateListForChar(Iterable<State> states, int index) {
        Collection<State> result = new LinkedList();
        for (State state : states) {
            updateStateForChar(state, index, result);
        }
        return simplifyStates(result);
    }

    private void updateStateForChar(State state, int index, Collection<State> result) {
        char ch = (char) (this.text[index] & MotionEventCompat.ACTION_MASK);
        boolean charInCurrentTable = CHAR_MAP[state.getMode()][ch] > 0;
        State stateNoBinary = null;
        int mode = 0;
        while (mode <= MODE_PUNCT) {
            int charInMode = CHAR_MAP[mode][ch];
            if (charInMode > 0) {
                if (stateNoBinary == null) {
                    stateNoBinary = state.endBinaryShift(index);
                }
                if (!charInCurrentTable || mode == state.getMode() || mode == MODE_DIGIT) {
                    result.add(stateNoBinary.latchAndAppend(mode, charInMode));
                }
                if (!charInCurrentTable && SHIFT_TABLE[state.getMode()][mode] >= 0) {
                    result.add(stateNoBinary.shiftAndAppend(mode, charInMode));
                }
            }
            mode += MODE_LOWER;
        }
        if (state.getBinaryShiftByteCount() > 0 || CHAR_MAP[state.getMode()][ch] == 0) {
            result.add(state.addBinaryShiftChar(index));
        }
    }

    private static Collection<State> updateStateListForPair(Iterable<State> states, int index, int pairCode) {
        Collection<State> result = new LinkedList();
        for (State state : states) {
            updateStateForPair(state, index, pairCode, result);
        }
        return simplifyStates(result);
    }

    private static void updateStateForPair(State state, int index, int pairCode, Collection<State> result) {
        State stateNoBinary = state.endBinaryShift(index);
        result.add(stateNoBinary.latchAndAppend(MODE_PUNCT, pairCode));
        if (state.getMode() != MODE_PUNCT) {
            result.add(stateNoBinary.shiftAndAppend(MODE_PUNCT, pairCode));
        }
        if (pairCode == MODE_MIXED || pairCode == MODE_PUNCT) {
            result.add(stateNoBinary.latchAndAppend(MODE_DIGIT, 16 - pairCode).latchAndAppend(MODE_DIGIT, MODE_LOWER));
        }
        if (state.getBinaryShiftByteCount() > 0) {
            result.add(state.addBinaryShiftChar(index).addBinaryShiftChar(index + MODE_LOWER));
        }
    }

    private static Collection<State> simplifyStates(Iterable<State> states) {
        List<State> result = new LinkedList();
        for (State newState : states) {
            boolean add = true;
            Iterator<State> iterator = result.iterator();
            while (iterator.hasNext()) {
                State oldState = (State) iterator.next();
                if (oldState.isBetterThanOrEqualTo(newState)) {
                    add = false;
                    break;
                } else if (newState.isBetterThanOrEqualTo(oldState)) {
                    iterator.remove();
                }
            }
            if (add) {
                result.add(newState);
            }
        }
        return result;
    }
}
