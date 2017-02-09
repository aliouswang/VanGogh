package com.aliouswang.vangogh;

import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/**
 * Image downloading, transformation, and caching manager.
 *
 * Created by aliouswang on 17/2/9.
 */

public class Vangogh {

    public interface Listener {
        /**
         * Invoked when an image has failed to load. This is useful for reporting image failures to
         * a remote analytics service, for example.
         */
        void onImageLoadFailed(Vangogh vangogh, Uri uri, Exception exception);
    }

    public interface RequestTransformer {
        Request transformRequest(Request request);

        RequestTransformer IDENTITY = new RequestTransformer() {
            @Override
            public Request transformRequest(Request request) {
                return request;
            }
        };
    }


    public enum Priority {
        LOW,
        NORMAL,
        HIGH
    }

    static final String TAG = "vangogh";
    static final Handler HANDLER = new Handler(Looper.getMainLooper()) {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Dispatcher.HUNTER_BATCH_COMPLETE: {

                }
                case Dispatcher.REQUEST_GCED: {

                }
                case Dispatcher.REQUEST_BATCH_RESUME: {

                }
            }
        }

    };

    public enum LoadedFrom {
        MEMORY(Color.GREEN),
        DISK(Color.BLUE),
        NETWORK(Color.RED);

        final int debugColor;

        private LoadedFrom(int debugColor) {
            this.debugColor = debugColor;
        }
    }

}
