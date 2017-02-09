package com.aliouswang.vangogh;

import android.net.Uri;

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



}
