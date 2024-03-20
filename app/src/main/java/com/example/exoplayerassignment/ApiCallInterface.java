package com.example.exoplayerassignment;

import com.example.exoplayerassignment.apiDataClass.VideoFile;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCallInterface {
    @GET(value = "index.php?p=showAllVideos")
    Call<VideoFile> getApiRequest();
}
