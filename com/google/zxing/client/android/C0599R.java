package com.google.zxing.client.android;

/* renamed from: com.google.zxing.client.android.R */
public final class C0599R {

    /* renamed from: com.google.zxing.client.android.R.attr */
    public static final class attr {
        public static final int zxing_framing_rect_height = 2130772292;
        public static final int zxing_framing_rect_width = 2130772291;
        public static final int zxing_possible_result_points = 2130772295;
        public static final int zxing_preview_scaling_strategy = 2130772294;
        public static final int zxing_result_view = 2130772296;
        public static final int zxing_scanner_layout = 2130772299;
        public static final int zxing_use_texture_view = 2130772293;
        public static final int zxing_viewfinder_laser = 2130772297;
        public static final int zxing_viewfinder_mask = 2130772298;
    }

    /* renamed from: com.google.zxing.client.android.R.color */
    public static final class color {
        public static final int zxing_custom_possible_result_points = 2131558523;
        public static final int zxing_custom_result_view = 2131558524;
        public static final int zxing_custom_viewfinder_laser = 2131558525;
        public static final int zxing_custom_viewfinder_mask = 2131558526;
        public static final int zxing_possible_result_points = 2131558527;
        public static final int zxing_result_view = 2131558528;
        public static final int zxing_status_text = 2131558529;
        public static final int zxing_transparent = 2131558530;
        public static final int zxing_viewfinder_laser = 2131558531;
        public static final int zxing_viewfinder_mask = 2131558532;
    }

    /* renamed from: com.google.zxing.client.android.R.id */
    public static final class id {
        public static final int centerCrop = 2131624040;
        public static final int fitCenter = 2131624041;
        public static final int fitXY = 2131624042;
        public static final int zxing_back_button = 2131623948;
        public static final int zxing_barcode_scanner = 2131624162;
        public static final int zxing_barcode_surface = 2131624159;
        public static final int zxing_camera_error = 2131623949;
        public static final int zxing_decode = 2131623950;
        public static final int zxing_decode_failed = 2131623951;
        public static final int zxing_decode_succeeded = 2131623952;
        public static final int zxing_possible_result_points = 2131623953;
        public static final int zxing_prewiew_size_ready = 2131623954;
        public static final int zxing_status_view = 2131624161;
        public static final int zxing_viewfinder_view = 2131624160;
    }

    /* renamed from: com.google.zxing.client.android.R.layout */
    public static final class layout {
        public static final int zxing_barcode_scanner = 2130968641;
        public static final int zxing_capture = 2130968642;
    }

    /* renamed from: com.google.zxing.client.android.R.raw */
    public static final class raw {
        public static final int zxing_beep = 2131099649;
    }

    /* renamed from: com.google.zxing.client.android.R.string */
    public static final class string {
        public static final int zxing_app_name = 2131165247;
        public static final int zxing_button_ok = 2131165248;
        public static final int zxing_msg_camera_framework_bug = 2131165249;
        public static final int zxing_msg_default_status = 2131165250;
    }

    /* renamed from: com.google.zxing.client.android.R.style */
    public static final class style {
        public static final int zxing_CaptureTheme = 2131427351;
    }

    /* renamed from: com.google.zxing.client.android.R.styleable */
    public static final class styleable {
        public static final int[] zxing_camera_preview;
        public static final int zxing_camera_preview_zxing_framing_rect_height = 1;
        public static final int zxing_camera_preview_zxing_framing_rect_width = 0;
        public static final int zxing_camera_preview_zxing_preview_scaling_strategy = 3;
        public static final int zxing_camera_preview_zxing_use_texture_view = 2;
        public static final int[] zxing_finder;
        public static final int zxing_finder_zxing_possible_result_points = 0;
        public static final int zxing_finder_zxing_result_view = 1;
        public static final int zxing_finder_zxing_viewfinder_laser = 2;
        public static final int zxing_finder_zxing_viewfinder_mask = 3;
        public static final int[] zxing_view;
        public static final int zxing_view_zxing_scanner_layout = 0;

        static {
            zxing_camera_preview = new int[]{C0599R.attr.zxing_framing_rect_width, C0599R.attr.zxing_framing_rect_height, C0599R.attr.zxing_use_texture_view, C0599R.attr.zxing_preview_scaling_strategy};
            zxing_finder = new int[]{C0599R.attr.zxing_possible_result_points, C0599R.attr.zxing_result_view, C0599R.attr.zxing_viewfinder_laser, C0599R.attr.zxing_viewfinder_mask};
            int[] iArr = new int[zxing_finder_zxing_result_view];
            iArr[zxing_finder_zxing_possible_result_points] = C0599R.attr.zxing_scanner_layout;
            zxing_view = iArr;
        }
    }
}
