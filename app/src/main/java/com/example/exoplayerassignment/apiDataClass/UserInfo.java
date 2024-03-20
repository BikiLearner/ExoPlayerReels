
package com.example.exoplayerassignment.apiDataClass;

import com.google.gson.annotations.SerializedName;



public class UserInfo {

    @SerializedName("fb_id")
    private String mFbId;
    @SerializedName("first_name")
    private String mFirstName;
    @SerializedName("gender")
    private String mGender;
    @SerializedName("last_name")
    private String mLastName;
    @SerializedName("profile_pic")
    private String mProfilePic;
    @SerializedName("username")
    private String mUsername;
    @SerializedName("verified")
    private String mVerified;
    @SerializedName("_id")
    private String m_id;

    public String getFbId() {
        return mFbId;
    }

    public void setFbId(String fbId) {
        mFbId = fbId;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getGender() {
        return mGender;
    }

    public void setGender(String gender) {
        mGender = gender;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getProfilePic() {
        return mProfilePic;
    }

    public void setProfilePic(String profilePic) {
        mProfilePic = profilePic;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getVerified() {
        return mVerified;
    }

    public void setVerified(String verified) {
        mVerified = verified;
    }

    public String get_id() {
        return m_id;
    }

    public void set_id(String _id) {
        m_id = _id;
    }

}
