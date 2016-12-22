package com.journeyapps.barcodescanner.camera;

import android.graphics.Rect;
import android.util.Log;
import com.android.volley.DefaultRetryPolicy;
import com.journeyapps.barcodescanner.Size;

public class CenterCropStrategy extends PreviewScalingStrategy {
    private static final String TAG;

    static {
        TAG = CenterCropStrategy.class.getSimpleName();
    }

    protected float getScore(Size size, Size desired) {
        if (size.width <= 0 || size.height <= 0) {
            return 0.0f;
        }
        float scaleScore;
        Size scaled = size.scaleCrop(desired);
        float scaleRatio = (((float) scaled.width) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) size.width);
        if (scaleRatio > DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
            scaleScore = (float) Math.pow((double) (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT / scaleRatio), 1.1d);
        } else {
            scaleScore = scaleRatio;
        }
        float cropRatio = ((((float) scaled.width) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) desired.width)) + ((((float) scaled.height) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) desired.height));
        return scaleScore * ((DefaultRetryPolicy.DEFAULT_BACKOFF_MULT / cropRatio) / cropRatio);
    }

    public Rect scalePreview(Size previewSize, Size viewfinderSize) {
        Size scaledPreview = previewSize.scaleCrop(viewfinderSize);
        Log.i(TAG, "Preview: " + previewSize + "; Scaled: " + scaledPreview + "; Want: " + viewfinderSize);
        int dx = (scaledPreview.width - viewfinderSize.width) / 2;
        int dy = (scaledPreview.height - viewfinderSize.height) / 2;
        return new Rect(-dx, -dy, scaledPreview.width - dx, scaledPreview.height - dy);
    }
}
