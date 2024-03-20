
package com.example.exoplayerassignment.apiDataClass;

import com.google.gson.annotations.SerializedName;


public class Sound {

    @SerializedName("audio_path")
    private AudioPath mAudioPath;
    @SerializedName("created")
    private String mCreated;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("id")
    private Long mId;
    @SerializedName("section")
    private String mSection;
    @SerializedName("sound_name")
    private String mSoundName;
    @SerializedName("thum")
    private String mThum;
    @SerializedName("_id")
    private String m_id;

    public AudioPath getAudioPath() {
        return mAudioPath;
    }

    public void setAudioPath(AudioPath audioPath) {
        mAudioPath = audioPath;
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

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getSection() {
        return mSection;
    }

    public void setSection(String section) {
        mSection = section;
    }

    public String getSoundName() {
        return mSoundName;
    }

    public void setSoundName(String soundName) {
        mSoundName = soundName;
    }

    public String getThum() {
        return mThum;
    }

    public void setThum(String thum) {
        mThum = thum;
    }

    public String get_id() {
        return m_id;
    }

    public void set_id(String _id) {
        m_id = _id;
    }

}
