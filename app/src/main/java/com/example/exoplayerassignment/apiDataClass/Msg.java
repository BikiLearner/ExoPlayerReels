
package com.example.exoplayerassignment.apiDataClass;

import com.google.gson.annotations.SerializedName;


public class Msg {

    @SerializedName("city")
    private String mCity;
    @SerializedName("count")
    private Count mCount;
    @SerializedName("country")
    private String mCountry;
    @SerializedName("created")
    private String mCreated;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("fb_id")
    private String mFbId;
    @SerializedName("gif")
    private String mGif;
    @SerializedName("id")
    private Long mId;
    @SerializedName("is_block")
    private Long mIsBlock;
    @SerializedName("liked")
    private Long mLiked;
    @SerializedName("score")
    private Long mScore;
    @SerializedName("sound")
    private Sound mSound;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("thum")
    private String mThum;
    @SerializedName("tp")
    private Long mTp;
    @SerializedName("uid")
    private String mUid;
    @SerializedName("user_info")
    private UserInfo mUserInfo;
    @SerializedName("video")
    private String mVideo;
    @SerializedName("__v")
    private Long m_V;
    @SerializedName("_id")
    private String m_id;

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public Count getCount() {
        return mCount;
    }

    public void setCount(Count count) {
        mCount = count;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public String getCreated() {
        return mCreated;
    }

    public void setCreated(String created) {
        mCreated = created;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getFbId() {
        return mFbId;
    }

    public void setFbId(String fbId) {
        mFbId = fbId;
    }

    public String getGif() {
        return mGif;
    }

    public void setGif(String gif) {
        mGif = gif;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Long getIsBlock() {
        return mIsBlock;
    }

    public void setIsBlock(Long isBlock) {
        mIsBlock = isBlock;
    }

    public Long getLiked() {
        return mLiked;
    }

    public void setLiked(Long liked) {
        mLiked = liked;
    }

    public Long getScore() {
        return mScore;
    }

    public void setScore(Long score) {
        mScore = score;
    }

    public Sound getSound() {
        return mSound;
    }

    public void setSound(Sound sound) {
        mSound = sound;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public String getThum() {
        return mThum;
    }

    public void setThum(String thum) {
        mThum = thum;
    }

    public Long getTp() {
        return mTp;
    }

    public void setTp(Long tp) {
        mTp = tp;
    }

    public String getUid() {
        return mUid;
    }

    public void setUid(String uid) {
        mUid = uid;
    }

    public UserInfo getUserInfo() {
        return mUserInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        mUserInfo = userInfo;
    }

    public String getVideo() {
        return mVideo;
    }

    public void setVideo(String video) {
        mVideo = video;
    }

    public Long get_V() {
        return m_V;
    }

    public void set_V(Long _V) {
        m_V = _V;
    }

    public String get_id() {
        return m_id;
    }

    public void set_id(String _id) {
        m_id = _id;
    }

}
