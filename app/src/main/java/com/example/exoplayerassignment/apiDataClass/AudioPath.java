
package com.example.exoplayerassignment.apiDataClass;

import com.google.gson.annotations.SerializedName;


public class AudioPath {

    @SerializedName("acc")
    private String mAcc;
    @SerializedName("mp3")
    private String mMp3;

    public String getAcc() {
        return mAcc;
    }

    public void setAcc(String acc) {
        mAcc = acc;
    }

    public String getMp3() {
        return mMp3;
    }

    public void setMp3(String mp3) {
        mMp3 = mp3;
    }

}
