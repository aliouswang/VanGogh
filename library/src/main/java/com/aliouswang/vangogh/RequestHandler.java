package com.aliouswang.vangogh;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;

import java.io.IOException;
import java.io.InputStream;

import static com.aliouswang.vangogh.Utils.checkNotNull;

/**
 * Created by aliouswang on 17/2/9.
 */

public abstract class RequestHandler {

    public static final class Result {
        private final Vangogh.LoadedFrom loadedFrom;
        private final Bitmap bitmap;
        private final InputStream stream;
        private final int exifOrientation;

        public Result(Bitmap bitmap, Vangogh.LoadedFrom loadedFrom) {
            this(checkNotNull(bitmap, "bitmap == null"), null, loadedFrom, 0);
        }

        public Result(InputStream stream, Vangogh.LoadedFrom loadedFrom) {
            this(null, checkNotNull(stream, "stream == null"), loadedFrom, 0);
        }

        Result(Bitmap bitmap, InputStream stream,
               Vangogh.LoadedFrom loadedFrom, int exifOrientation) {
            if (!(bitmap != null ^ stream != null)) {
                throw new AssertionError();
            }
            this.bitmap = bitmap;
            this.stream = stream;
            this.loadedFrom = loadedFrom;
            this.exifOrientation = exifOrientation;
        }

        public Vangogh.LoadedFrom getLoadedFrom() {
            return loadedFrom;
        }

        public Bitmap getBitmap() {
            return bitmap;
        }

        public InputStream getStream() {
            return stream;
        }

        public int getExifOrientation() {
            return exifOrientation;
        }
    }

    public abstract boolean canHandlerRequest(Request data);

    public abstract Result load(Request request, int networkPolicy) throws IOException;

    int getRetryCount() {
        return 0;
    }

    boolean shouldRetry(boolean airplaneMode, NetworkInfo info) {
        return false;
    }

    boolean supportsReplay() {
        return false;
    }

    static BitmapFactory.Options createBitmapOptions(Request data) {
        final boolean justBounds = data.hasSize();
        final boolean hasConfig = data.config != null;
        BitmapFactory.Options options = null;
        if (justBounds || hasConfig || data.purgeable) {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = justBounds;
            options.inInputShareable = data.purgeable;
            options.inPurgeable = data.purgeable;
            if (hasConfig) {
                options.inPreferredConfig = data.config;
            }
        }
        return options;
    }

    static boolean requiredInSampleSize(BitmapFactory.Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    static void calculateInSampleSize(int reqWidth, int reqHeight, BitmapFactory.Options options,
                                      Request request) {

    }

    static void calculateInSampleSize(int reqWidth, int reqHeight, int width, int height,
                                      BitmapFactory.Options options, Request request) {
        int sampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            final int heightRatio;
            final int widthRatio;
            if (reqHeight == 0) {
                sampleSize = (int) Math.floor((float)width / (float)reqWidth);
            } else if (reqWidth == 0) {
                sampleSize = (int) Math.floor((float)height / (float)reqHeight);
            } else {
                heightRatio = (int) Math.floor((float)height / (float)reqHeight);
                widthRatio = (int) Math.floor((float)width / (float)reqWidth);
                sampleSize = request.centerInside
                        ? Math.max(heightRatio, widthRatio)
                        : Math.min(heightRatio, widthRatio);
            }
        }
        options.inSampleSize = sampleSize;
        options.inJustDecodeBounds = false;
    }
}
