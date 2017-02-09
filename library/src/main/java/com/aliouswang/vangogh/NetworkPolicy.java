package com.aliouswang.vangogh;

/**
 * Created by aliouswang on 17/2/9.
 */

public enum NetworkPolicy {

    /** Skips checking the disk cache and forces loading through the network. */
    NO_CACHE(1 << 0),
    /** Skips storing the result into the disk cache.*/
    NO_STORE(1 << 1),
    /** Forces the request through the disk cache only, skipping network.*/
    OFFLINE(1 << 2);

    final int index;

    private NetworkPolicy(int index) {
        this.index = index;
    }

    public static boolean shouldReadFromDiskCache(int networkPolicy) {
        return (networkPolicy & NetworkPolicy.NO_CACHE.ordinal()) == 0;
    }

    public static boolean shouldWriteToDiskCache(int networkPolicy) {
        return (networkPolicy & NetworkPolicy.NO_STORE.ordinal()) == 0;
    }

    public static boolean isOfflineOnly(int networkPolicy) {
        return (networkPolicy & NetworkPolicy.OFFLINE.ordinal()) != 0;
    }


}
