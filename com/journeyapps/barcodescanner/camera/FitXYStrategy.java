package com.journeyapps.barcodescanner.camera;

import android.graphics.Rect;
import com.android.volley.DefaultRetryPolicy;
import com.journeyapps.barcodescanner.Size;

public class FitXYStrategy extends PreviewScalingStrategy {
    private static final String TAG;

    static {
        TAG = FitXYStrategy.class.getSimpleName();
    }

    private static float absRatio(float ratio) {
        if (ratio < DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
            return DefaultRetryPolicy.DEFAULT_BACKOFF_MULT / ratio;
        }
        return ratio;
    }

    protected float getScore(Size size, Size desired) {
        if (size.width <= 0 || size.height <= 0) {
            return 0.0f;
        }
        float scaleX = absRatio((((float) size.width) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) desired.width));
        float scaleScore = (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT / scaleX) / absRatio((((float) size.height) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) desired.height));
        float distortion = absRatio(((((float) size.width) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) size.height)) / ((((float) desired.width) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) desired.height)));
        return scaleScore * (((DefaultRetryPolicy.DEFAULT_BACKOFF_MULT / distortion) / distortion) / distortion);
    }

    public Rect scalePreview(Size previewSize, Size viewfinderSize) {
        return new Rect(0, 0, viewfinderSize.width, viewfinderSize.height);
    }
}
