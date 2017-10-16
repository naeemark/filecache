package com.android.filecache;

public class CacheTransactionException extends Exception {
    private static final long serialVersionUID = 1L;

    public CacheTransactionException() {
    }

    CacheTransactionException(String alert) {
        super(alert);
    }
}