
package com.example.exoplayerassignment.apiDataClass;

import com.google.gson.annotations.SerializedName;

import java.util.List;



public class VideoFile {

    @SerializedName("code")
    private String mCode;
    @SerializedName("msg")
    private List<Msg> mMsg;
    @SerializedName("s")
    private String mS;

    public String getCode() {
        return mCode;
    }

    public void setCode(String code) {
        mCode = code;
    }

    public List<Msg> getMsg() {
        return mMsg;
    }

    public void setMsg(List<Msg> msg) {
        mMsg = msg;
    }

    public String getS() {
        return mS;
    }

    public void setS(String s) {
        mS = s;
    }

}
