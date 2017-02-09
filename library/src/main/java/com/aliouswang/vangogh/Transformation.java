package com.aliouswang.vangogh;

import android.graphics.Bitmap;

/**
 * Created by aliouswang on 17/2/9.
 */

public interface Transformation {

    Bitmap transform(Bitmap source);

    String key();

}
