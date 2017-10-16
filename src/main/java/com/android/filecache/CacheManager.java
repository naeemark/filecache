package com.android.filecache;

import android.content.Context;
import android.util.Log;

public class CacheManager {

    private static final String TAG = CacheManager.class.getSimpleName();

    private FileManager mFileManager;

    public CacheManager(Context context) {
        mFileManager = new FileManager(context);
    }

    public void save(String data, String fileName) {
        try {
            mFileManager.write(data, fileName);
        } catch (CacheTransactionException e) {
            e.printStackTrace();
        }
    }

    public String fetch(String fileName) {
        String data = null;
        try {
            data = mFileManager.readString(fileName);
            Log.i(TAG, "fetch=>" + data);
        } catch (CacheTransactionException e) {
            e.printStackTrace();
        }
        return data;
    }

    public boolean clear(String fileName) {
        return mFileManager.deleteFile(fileName);
    }

    public boolean clearCache() {
        return mFileManager.deleteCacheDirContent();
    }

    public boolean hasCache() {
        return mFileManager.hasCacheContent();
    }

}
