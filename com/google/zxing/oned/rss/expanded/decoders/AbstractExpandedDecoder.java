package com.google.zxing.oned.rss.expanded.decoders;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

public abstract class AbstractExpandedDecoder {
    private final GeneralAppIdDecoder generalDecoder;
    private final BitArray information;

    public abstract String parseInformation() throws NotFoundException, FormatException;

    AbstractExpandedDecoder(BitArray information) {
        this.information = information;
        this.generalDecoder = new GeneralAppIdDecoder(information);
    }

    protected final BitArray getInformation() {
        return this.information;
    }

    protected final GeneralAppIdDecoder getGeneralDecoder() {
        return this.generalDecoder;
    }

    public static AbstractExpandedDecoder createDecoder(BitArray information) {
        if (information.get(1)) {
            return new AI01AndOtherAIs(information);
        }
        if (!information.get(2)) {
            return new AnyAIDecoder(information);
        }
        switch (GeneralAppIdDecoder.extractNumericValueFromBitArray(information, 1, 4)) {
            case Barcode.PHONE /*4*/:
                return new AI013103decoder(information);
            case Barcode.PRODUCT /*5*/:
                return new AI01320xDecoder(information);
            default:
                switch (GeneralAppIdDecoder.extractNumericValueFromBitArray(information, 1, 5)) {
                    case Barcode.DRIVER_LICENSE /*12*/:
                        return new AI01392xDecoder(information);
                    case ConnectionsStatusCodes.STATUS_ERROR /*13*/:
                        return new AI01393xDecoder(information);
                    default:
                        switch (GeneralAppIdDecoder.extractNumericValueFromBitArray(information, 1, 7)) {
                            case Place.TYPE_LIQUOR_STORE /*56*/:
                                return new AI013x0x1xDecoder(information, "310", "11");
                            case Place.TYPE_LOCAL_GOVERNMENT_OFFICE /*57*/:
                                return new AI013x0x1xDecoder(information, "320", "11");
                            case Place.TYPE_LOCKSMITH /*58*/:
                                return new AI013x0x1xDecoder(information, "310", "13");
                            case Place.TYPE_LODGING /*59*/:
                                return new AI013x0x1xDecoder(information, "320", "13");
                            case Place.TYPE_MEAL_DELIVERY /*60*/:
                                return new AI013x0x1xDecoder(information, "310", "15");
                            case Place.TYPE_MEAL_TAKEAWAY /*61*/:
                                return new AI013x0x1xDecoder(information, "320", "15");
                            case Place.TYPE_MOSQUE /*62*/:
                                return new AI013x0x1xDecoder(information, "310", "17");
                            case Place.TYPE_MOVIE_RENTAL /*63*/:
                                return new AI013x0x1xDecoder(information, "320", "17");
                            default:
                                throw new IllegalStateException("unknown decoder: " + information);
                        }
                }
        }
    }
}
