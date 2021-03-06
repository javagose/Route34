package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.android.volley.DefaultRetryPolicy;

class ValueAnimatorCompatImplEclairMr1 extends Impl {
    private static final int DEFAULT_DURATION = 200;
    private static final int HANDLER_DELAY = 10;
    private static final Handler sHandler;
    private float mAnimatedFraction;
    private int mDuration;
    private final float[] mFloatValues;
    private final int[] mIntValues;
    private Interpolator mInterpolator;
    private boolean mIsRunning;
    private AnimatorListenerProxy mListener;
    private final Runnable mRunnable;
    private long mStartTime;
    private AnimatorUpdateListenerProxy mUpdateListener;

    /* renamed from: android.support.design.widget.ValueAnimatorCompatImplEclairMr1.1 */
    class C00141 implements Runnable {
        C00141() {
        }

        public void run() {
            ValueAnimatorCompatImplEclairMr1.this.update();
        }
    }

    ValueAnimatorCompatImplEclairMr1() {
        this.mIntValues = new int[2];
        this.mFloatValues = new float[2];
        this.mDuration = DEFAULT_DURATION;
        this.mRunnable = new C00141();
    }

    static {
        sHandler = new Handler(Looper.getMainLooper());
    }

    public void start() {
        if (!this.mIsRunning) {
            if (this.mInterpolator == null) {
                this.mInterpolator = new AccelerateDecelerateInterpolator();
            }
            this.mStartTime = SystemClock.uptimeMillis();
            this.mIsRunning = true;
            if (this.mListener != null) {
                this.mListener.onAnimationStart();
            }
            sHandler.postDelayed(this.mRunnable, 10);
        }
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public void setListener(AnimatorListenerProxy listener) {
        this.mListener = listener;
    }

    public void setUpdateListener(AnimatorUpdateListenerProxy updateListener) {
        this.mUpdateListener = updateListener;
    }

    public void setIntValues(int from, int to) {
        this.mIntValues[0] = from;
        this.mIntValues[1] = to;
    }

    public int getAnimatedIntValue() {
        return AnimationUtils.lerp(this.mIntValues[0], this.mIntValues[1], getAnimatedFraction());
    }

    public void setFloatValues(float from, float to) {
        this.mFloatValues[0] = from;
        this.mFloatValues[1] = to;
    }

    public float getAnimatedFloatValue() {
        return AnimationUtils.lerp(this.mFloatValues[0], this.mFloatValues[1], getAnimatedFraction());
    }

    public void setDuration(int duration) {
        this.mDuration = duration;
    }

    public void cancel() {
        this.mIsRunning = false;
        sHandler.removeCallbacks(this.mRunnable);
        if (this.mListener != null) {
            this.mListener.onAnimationCancel();
        }
    }

    public float getAnimatedFraction() {
        return this.mAnimatedFraction;
    }

    public void end() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            sHandler.removeCallbacks(this.mRunnable);
            this.mAnimatedFraction = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
            if (this.mUpdateListener != null) {
                this.mUpdateListener.onAnimationUpdate();
            }
            if (this.mListener != null) {
                this.mListener.onAnimationEnd();
            }
        }
    }

    public long getDuration() {
        return (long) this.mDuration;
    }

    private void update() {
        if (this.mIsRunning) {
            float linearFraction = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / ((float) this.mDuration);
            if (this.mInterpolator != null) {
                linearFraction = this.mInterpolator.getInterpolation(linearFraction);
            }
            this.mAnimatedFraction = linearFraction;
            if (this.mUpdateListener != null) {
                this.mUpdateListener.onAnimationUpdate();
            }
            if (SystemClock.uptimeMillis() >= this.mStartTime + ((long) this.mDuration)) {
                this.mIsRunning = false;
                if (this.mListener != null) {
                    this.mListener.onAnimationEnd();
                }
            }
        }
        if (this.mIsRunning) {
            sHandler.postDelayed(this.mRunnable, 10);
        }
    }
}
