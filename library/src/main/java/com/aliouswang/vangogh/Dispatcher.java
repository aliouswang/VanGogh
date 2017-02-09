package com.aliouswang.vangogh;

/**
 * Created by aliouswang on 17/2/9.
 */

public class Dispatcher {

    private static final int RETRY_DELAY = 500;
    private static final int AIRPLANE_MODE_ON = 1;
    private static final int AIRPLANE_MODE_OFF = 0;

    static final int REQUEST_SUBMIT = 1;
    static final int REQUEST_CANCEL = 2;
    static final int REQUEST_GCED = 3;
    static final int HUNTER_COMPLETE = 4;
    static final int HUNTER_RETRY = 5;
    static final int HUNTER_DECODE_FAILED = 6;
    static final int HUNTER_DELAY_NEXT_BATCH = 7;
    static final int HUNTER_BATCH_COMPLETE = 8;
    static final int NETWORK_STATE_CHANGE = 9;
    static final int AIRPLANE_MODE_CHANGE = 10;
    static final int TAG_PAUSE = 11;
    static final int TAG_RESUME = 12;
    static final int REQUEST_BATCH_RESUME = 13;

    private static final String DISPATCHER_THREAD_NAME = "Dispatcher";
    private static final int BATCH_DELAY = 200;



}
