
package com.example.exoplayerassignment.apiDataClass;

import com.google.gson.annotations.SerializedName;



public class Count {

    @SerializedName("like_count")
    private Long mLikeCount;
    @SerializedName("video_comment_count")
    private Long mVideoCommentCount;
    @SerializedName("view")
    private Long mView;
    @SerializedName("_id")
    private String m_id;

    public Long getLikeCount() {
        return mLikeCount;
    }

    public void setLikeCount(Long likeCount) {
        mLikeCount = likeCount;
    }

    public Long getVideoCommentCount() {
        return mVideoCommentCount;
    }

    public void setVideoCommentCount(Long videoCommentCount) {
        mVideoCommentCount = videoCommentCount;
    }

    public Long getView() {
        return mView;
    }

    public void setView(Long view) {
        mView = view;
    }

    public String get_id() {
        return m_id;
    }

    public void set_id(String _id) {
        m_id = _id;
    }

}
