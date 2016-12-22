package com.journeyapps.barcodescanner.camera;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import com.google.zxing.client.android.C0599R;
import com.journeyapps.barcodescanner.Size;
import com.journeyapps.barcodescanner.Util;

public class CameraInstance {
    private static final String TAG;
    private CameraManager cameraManager;
    private CameraSettings cameraSettings;
    private CameraThread cameraThread;
    private Runnable closer;
    private Runnable configure;
    private DisplayConfiguration displayConfiguration;
    private boolean open;
    private Runnable opener;
    private Runnable previewStarter;
    private Handler readyHandler;
    private CameraSurface surface;

    /* renamed from: com.journeyapps.barcodescanner.camera.CameraInstance.1 */
    class C06231 implements Runnable {
        final /* synthetic */ boolean val$on;

        C06231(boolean z) {
            this.val$on = z;
        }

        public void run() {
            CameraInstance.this.cameraManager.setTorch(this.val$on);
        }
    }

    /* renamed from: com.journeyapps.barcodescanner.camera.CameraInstance.2 */
    class C06242 implements Runnable {
        final /* synthetic */ PreviewCallback val$callback;

        C06242(PreviewCallback previewCallback) {
            this.val$callback = previewCallback;
        }

        public void run() {
            CameraInstance.this.cameraManager.requestPreviewFrame(this.val$callback);
        }
    }

    /* renamed from: com.journeyapps.barcodescanner.camera.CameraInstance.3 */
    class C06253 implements Runnable {
        C06253() {
        }

        public void run() {
            try {
                Log.d(CameraInstance.TAG, "Opening camera");
                CameraInstance.this.cameraManager.open();
            } catch (Exception e) {
                CameraInstance.this.notifyError(e);
                Log.e(CameraInstance.TAG, "Failed to open camera", e);
            }
        }
    }

    /* renamed from: com.journeyapps.barcodescanner.camera.CameraInstance.4 */
    class C06264 implements Runnable {
        C06264() {
        }

        public void run() {
            try {
                Log.d(CameraInstance.TAG, "Configuring camera");
                CameraInstance.this.cameraManager.configure();
                if (CameraInstance.this.readyHandler != null) {
                    CameraInstance.this.readyHandler.obtainMessage(C0599R.id.zxing_prewiew_size_ready, CameraInstance.this.getPreviewSize()).sendToTarget();
                }
            } catch (Exception e) {
                CameraInstance.this.notifyError(e);
                Log.e(CameraInstance.TAG, "Failed to configure camera", e);
            }
        }
    }

    /* renamed from: com.journeyapps.barcodescanner.camera.CameraInstance.5 */
    class C06275 implements Runnable {
        C06275() {
        }

        public void run() {
            try {
                Log.d(CameraInstance.TAG, "Starting preview");
                CameraInstance.this.cameraManager.setPreviewDisplay(CameraInstance.this.surface);
                CameraInstance.this.cameraManager.startPreview();
            } catch (Exception e) {
                CameraInstance.this.notifyError(e);
                Log.e(CameraInstance.TAG, "Failed to start preview", e);
            }
        }
    }

    /* renamed from: com.journeyapps.barcodescanner.camera.CameraInstance.6 */
    class C06286 implements Runnable {
        C06286() {
        }

        public void run() {
            try {
                Log.d(CameraInstance.TAG, "Closing camera");
                CameraInstance.this.cameraManager.stopPreview();
                CameraInstance.this.cameraManager.close();
            } catch (Exception e) {
                Log.e(CameraInstance.TAG, "Failed to close camera", e);
            }
            CameraInstance.this.cameraThread.decrementInstances();
        }
    }

    static {
        TAG = CameraInstance.class.getSimpleName();
    }

    public CameraInstance(Context context) {
        this.open = false;
        this.cameraSettings = new CameraSettings();
        this.opener = new C06253();
        this.configure = new C06264();
        this.previewStarter = new C06275();
        this.closer = new C06286();
        Util.validateMainThread();
        this.cameraThread = CameraThread.getInstance();
        this.cameraManager = new CameraManager(context);
        this.cameraManager.setCameraSettings(this.cameraSettings);
    }

    public void setDisplayConfiguration(DisplayConfiguration configuration) {
        this.displayConfiguration = configuration;
        this.cameraManager.setDisplayConfiguration(configuration);
    }

    public DisplayConfiguration getDisplayConfiguration() {
        return this.displayConfiguration;
    }

    public void setReadyHandler(Handler readyHandler) {
        this.readyHandler = readyHandler;
    }

    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        setSurface(new CameraSurface(surfaceHolder));
    }

    public void setSurface(CameraSurface surface) {
        this.surface = surface;
    }

    public CameraSettings getCameraSettings() {
        return this.cameraSettings;
    }

    public void setCameraSettings(CameraSettings cameraSettings) {
        if (!this.open) {
            this.cameraSettings = cameraSettings;
            this.cameraManager.setCameraSettings(cameraSettings);
        }
    }

    private Size getPreviewSize() {
        return this.cameraManager.getPreviewSize();
    }

    public int getCameraRotation() {
        return this.cameraManager.getCameraRotation();
    }

    public void open() {
        Util.validateMainThread();
        this.open = true;
        this.cameraThread.incrementAndEnqueue(this.opener);
    }

    public void configureCamera() {
        Util.validateMainThread();
        validateOpen();
        this.cameraThread.enqueue(this.configure);
    }

    public void startPreview() {
        Util.validateMainThread();
        validateOpen();
        this.cameraThread.enqueue(this.previewStarter);
    }

    public void setTorch(boolean on) {
        Util.validateMainThread();
        if (this.open) {
            this.cameraThread.enqueue(new C06231(on));
        }
    }

    public void close() {
        Util.validateMainThread();
        if (this.open) {
            this.cameraThread.enqueue(this.closer);
        }
        this.open = false;
    }

    public boolean isOpen() {
        return this.open;
    }

    public void requestPreview(PreviewCallback callback) {
        validateOpen();
        this.cameraThread.enqueue(new C06242(callback));
    }

    private void validateOpen() {
        if (!this.open) {
            throw new IllegalStateException("CameraInstance is not open");
        }
    }

    private void notifyError(Exception error) {
        if (this.readyHandler != null) {
            this.readyHandler.obtainMessage(C0599R.id.zxing_camera_error, error).sendToTarget();
        }
    }
}
