package com.example.exoplayerassignment;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.exoplayerassignment.apiDataClass.Msg;
import com.example.exoplayerassignment.apiDataClass.VideoFile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private final String BASEURL="https://fatema.takatakind.com/app_api/";
    private ViewPager2 viewPager2;
    private ArrayList<ExoplayerItem> exoplayerItems=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        viewPager2=findViewById(R.id.viewPager2);

        getResponse();
    }

    private void setUpViewPager(List<Msg> videoFile){
        viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        ScrollVideoAdapter scrollVideoAdapter=new ScrollVideoAdapter(this,videoFile,viewPager2,exoplayerItem->{
            exoplayerItems.add(exoplayerItem);
        });
        viewPager2.setOffscreenPageLimit(1);
        viewPager2.setAdapter(scrollVideoAdapter);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                int previousIndex = IntStream.range(0, exoplayerItems.size())
                        .filter(i -> exoplayerItems.get(i).getExoPlayer().isPlaying())
                        .findFirst()
                        .orElse(-1);

                if(previousIndex!=-1){
                    Log.e("inNewIndex", "Previous : "+previousIndex);
                    ExoPlayer p=exoplayerItems.get(previousIndex).getExoPlayer();
                    p.pause();
                    p.setPlayWhenReady(false);
                }
                int newIndex = IntStream.range(0, exoplayerItems.size())
                        .filter(i -> exoplayerItems.get(i).getPosition() == position)
                        .findFirst()
                        .orElse(-1);
                if(newIndex!=-1){
                    Log.e("inNewIndex",newIndex+"");
                    ExoPlayer p=exoplayerItems.get(newIndex).getExoPlayer();
                    p.setPlayWhenReady(true);
                    p.play();
                }
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();

        int index=IntStream.range(0,exoplayerItems.size())
                .filter(i->exoplayerItems.get(i).getPosition()==viewPager2.getCurrentItem())
                .findFirst()
                .orElse(-1);
        if(index!=-1){
            ExoPlayer p=exoplayerItems.get(index).getExoPlayer();
            p.pause();
            p.setPlayWhenReady(false);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        int index=IntStream.range(0,exoplayerItems.size())
                .filter(i->exoplayerItems.get(i).getPosition()==viewPager2.getCurrentItem())
                .findFirst()
                .orElse(-1);
        if(index!=-1){
            ExoPlayer p=exoplayerItems.get(index).getExoPlayer();
            p.setPlayWhenReady(true);
            p.play();

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!exoplayerItems.isEmpty()){
            for(ExoplayerItem playerItem:exoplayerItems){
                ExoPlayer p= playerItem.getExoPlayer();
                p.stop();
                p.clearMediaItems();
            }
        }
    }

    private void getResponse() {
        Retrofit retrofitBuilder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASEURL)
                .build();

        ApiCallInterface apiCallInterface = retrofitBuilder.create(ApiCallInterface.class);
        Call<VideoFile> retroData = apiCallInterface.getApiRequest();

        retroData.enqueue(new Callback<VideoFile>() {
            @Override
            public void onResponse(@NonNull Call<VideoFile> call, @NonNull Response<VideoFile> response) {
                if (response.isSuccessful()) {
                    VideoFile data = response.body();
                    assert data != null;
                    setUpViewPager(data.getMsg());
                    Log.e("AllTheDatas",data.getMsg().get(0).getVideo());
                }
            }

            @Override
            public void onFailure(Call<VideoFile> call, Throwable t) {
                Log.e("RetrofitFail",t.getMessage());
            }
        });
    }

}