package com.journeyapps.barcodescanner.camera;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;

public final class AutoFocusManager {
    private static final long AUTO_FOCUS_INTERVAL_MS = 2000;
    private static final Collection<String> FOCUS_MODES_CALLING_AF;
    private static final String TAG;
    private int MESSAGE_FOCUS;
    private final AutoFocusCallback autoFocusCallback;
    private final Camera camera;
    private final Callback focusHandlerCallback;
    private boolean focusing;
    private Handler handler;
    private boolean stopped;
    private final boolean useAutoFocus;

    /* renamed from: com.journeyapps.barcodescanner.camera.AutoFocusManager.1 */
    class C06201 implements Callback {
        C06201() {
        }

        public boolean handleMessage(Message msg) {
            if (msg.what != AutoFocusManager.this.MESSAGE_FOCUS) {
                return false;
            }
            AutoFocusManager.this.focus();
            return true;
        }
    }

    /* renamed from: com.journeyapps.barcodescanner.camera.AutoFocusManager.2 */
    class C06222 implements AutoFocusCallback {

        /* renamed from: com.journeyapps.barcodescanner.camera.AutoFocusManager.2.1 */
        class C06211 implements Runnable {
            C06211() {
            }

            public void run() {
                AutoFocusManager.this.focusing = false;
                AutoFocusManager.this.autoFocusAgainLater();
            }
        }

        C06222() {
        }

        public void onAutoFocus(boolean success, Camera theCamera) {
            AutoFocusManager.this.handler.post(new C06211());
        }
    }

    static {
        TAG = AutoFocusManager.class.getSimpleName();
        FOCUS_MODES_CALLING_AF = new ArrayList(2);
        FOCUS_MODES_CALLING_AF.add("auto");
        FOCUS_MODES_CALLING_AF.add("macro");
    }

    public AutoFocusManager(Camera camera, CameraSettings settings) {
        boolean z = true;
        this.MESSAGE_FOCUS = 1;
        this.focusHandlerCallback = new C06201();
        this.autoFocusCallback = new C06222();
        this.handler = new Handler(this.focusHandlerCallback);
        this.camera = camera;
        String currentFocusMode = camera.getParameters().getFocusMode();
        if (!(settings.isAutoFocusEnabled() && FOCUS_MODES_CALLING_AF.contains(currentFocusMode))) {
            z = false;
        }
        this.useAutoFocus = z;
        Log.i(TAG, "Current focus mode '" + currentFocusMode + "'; use auto focus? " + this.useAutoFocus);
        start();
    }

    private synchronized void autoFocusAgainLater() {
        if (!(this.stopped || this.handler.hasMessages(this.MESSAGE_FOCUS))) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(this.MESSAGE_FOCUS), AUTO_FOCUS_INTERVAL_MS);
        }
    }

    public void start() {
        this.stopped = false;
        focus();
    }

    private void focus() {
        if (this.useAutoFocus && !this.stopped && !this.focusing) {
            try {
                this.camera.autoFocus(this.autoFocusCallback);
                this.focusing = true;
            } catch (RuntimeException re) {
                Log.w(TAG, "Unexpected exception while focusing", re);
                autoFocusAgainLater();
            }
        }
    }

    private void cancelOutstandingTask() {
        this.handler.removeMessages(this.MESSAGE_FOCUS);
    }

    public void stop() {
        this.stopped = true;
        this.focusing = false;
        cancelOutstandingTask();
        if (this.useAutoFocus) {
            try {
                this.camera.cancelAutoFocus();
            } catch (RuntimeException re) {
                Log.w(TAG, "Unexpected exception while cancelling focusing", re);
            }
        }
    }
}
