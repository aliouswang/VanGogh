package com.aliouswang.vangogh;

import android.os.Looper;

/**
 * Created by aliouswang on 17/2/9.
 */

public final class Utils {

    static final String THREAD_PREFIX = "Picasso-";
    static final String THREAD_IDLE_NAME = THREAD_PREFIX + "Idle";
    static final int DEFAULT_READ_TIMEOUT_MILLIS = 20 * 1000; // 20s
    static final int DEFAULT_WRITE_TIMEOUT_MILLIS = 20 * 1000; // 20s
    static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 15 * 1000; // 15s
    private static final String PICASSO_CACHE = "picasso-cache";
    private static final int KEY_PADDING = 50; // Determined by exact science.
    private static final int MIN_DISK_CACHE_SIZE = 5 * 1024 * 1024; // 5MB
    private static final int MAX_DISK_CACHE_SIZE = 50 * 1024 * 1024; // 50MB
    static final int THREAD_LEAK_CLEANING_MS = 1000;
    static final char KEY_SEPARATOR = '\n';

    /** Thread confined to main thread for key creation. */
    static final StringBuilder MAIN_THREAD_KEY_BUILDER = new StringBuilder();

    /** Logging */
    static final String OWNER_MAIN = "Main";
    static final String OWNER_DISPATCHER = "Dispatcher";
    static final String OWNER_HUNTER = "Hunter";
    static final String VERB_CREATED = "created";
    static final String VERB_CHANGED = "changed";
    static final String VERB_IGNORED = "ignored";
    static final String VERB_ENQUEUED = "enqueued";
    static final String VERB_CANCELED = "canceled";
    static final String VERB_BATCHED = "batched";
    static final String VERB_RETRYING = "retrying";
    static final String VERB_EXECUTING = "executing";
    static final String VERB_DECODED = "decoded";
    static final String VERB_TRANSFORMED = "transformed";
    static final String VERB_JOINED = "joined";
    static final String VERB_REMOVED = "removed";
    static final String VERB_DELIVERED = "delivered";
    static final String VERB_REPLAYING = "replaying";
    static final String VERB_COMPLETED = "completed";
    static final String VERB_ERRORED = "errored";
    static final String VERB_PAUSED = "paused";
    static final String VERB_RESUMED = "resumed";

    static <T> T checkNotNull(T value, String message) {
        if (value == null) {
            throw new NullPointerException(message);
        }
        return value;
    }

    static void checkNotMain() {
        if (isMain()) {
            throw new IllegalStateException("Method call should not happen from the main thread.");
        }
    }

    static void checkMain() {
        if (!isMain()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    static boolean isMain() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

}
