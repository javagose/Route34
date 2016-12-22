package com.google.zxing.oned.rss.expanded.decoders;

import com.google.android.gms.search.SearchAuth.StatusCodes;
import com.google.zxing.common.BitArray;

final class AI01320xDecoder extends AI013x0xDecoder {
    AI01320xDecoder(BitArray information) {
        super(information);
    }

    protected void addWeightCode(StringBuilder buf, int weight) {
        if (weight < StatusCodes.AUTH_DISABLED) {
            buf.append("(3202)");
        } else {
            buf.append("(3203)");
        }
    }

    protected int checkWeight(int weight) {
        return weight < StatusCodes.AUTH_DISABLED ? weight : weight - 10000;
    }
}
