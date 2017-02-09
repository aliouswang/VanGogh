package com.aliouswang.vangogh;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by aliouswang on 17/2/9.
 */

public class BitmapHunter implements Runnable{

    private static final Object DECODE_LOCK = new Object();

    private static final ThreadLocal<StringBuilder> NAME_BUILDER = new ThreadLocal<StringBuilder>() {
        @Override
        protected StringBuilder initialValue() {
            return new StringBuilder(Utils.THREAD_PREFIX);
        }
    };

    private static final AtomicInteger SEQUENCE_GENERATOR = new AtomicInteger();


    @Override
    public void run() {

    }
}
