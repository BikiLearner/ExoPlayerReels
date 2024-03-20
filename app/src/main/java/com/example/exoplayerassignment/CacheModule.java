package com.example.exoplayerassignment;

//bytes to be downloaded

import java.io.File;

public class CacheModule {
    String DOWNLOAD_CONTENT_DIRECTORY = "downloads";
    public void initCache(){
        File downloadContentDirectory =
                File(getExternalFilesDir(null),DOWNLOAD_CONTENT_DIRECTORY);
        var downloadCache =
                SimpleCache(downloadContentDirectory, NoOpCacheEvictor(), StandaloneDatabaseProvider(this))
    }

}
