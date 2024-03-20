package com.example.exoplayerassignment;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.OptIn;
import androidx.media3.common.MediaItem;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.database.DatabaseProvider;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DefaultDataSource;
import androidx.media3.datasource.DefaultHttpDataSource;
import androidx.media3.datasource.cache.CacheDataSource;
import androidx.media3.datasource.cache.SimpleCache;
import androidx.media3.exoplayer.DefaultLoadControl;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.LoadControl;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;
import androidx.media3.ui.PlayerView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.exoplayerassignment.apiDataClass.Msg;

import java.io.File;
import java.util.List;

public class ScrollVideoAdapter extends RecyclerView.Adapter<ScrollVideoAdapter.ViewHolder> {

    private final List<Msg> videoLinks;
    private final ViewPager2 viewPager2;
    private OnVideoPrepareCallBack onVideoPrepareCallBack;
    private final Context context;

    public ScrollVideoAdapter(Context context, List<Msg> videoLinks,
                              ViewPager2 viewPager2,
                              OnVideoPrepareCallBack onVideoPrepareCallBack){
        this.onVideoPrepareCallBack=onVideoPrepareCallBack;
        this.viewPager2=viewPager2;
        this.context=context;
        this.videoLinks=videoLinks;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.scroll_video_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String videoUrl = videoLinks.get(position).getVideo();

        holder.setVideoPath(videoUrl);

    }

    @Override
    public int getItemCount() {
        return videoLinks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public PlayerView playerView;
        private final ProgressBar progressBar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            progressBar=itemView.findViewById(R.id.progressBar);
            playerView=itemView.findViewById(R.id.videoPlayerView);
        }
        @OptIn(markerClass = UnstableApi.class)
        public void setVideoPath(String videoUrl){
            ExoPlayer exoPlayer = new ExoPlayer.Builder(context).build();
            exoPlayer.addListener(new Player.Listener() {
                @Override
                public void onPlayerError(@NonNull PlaybackException error) {
                    Player.Listener.super.onPlayerError(error);
                    Toast.makeText(context,"Cannot Play this video"+error.getErrorCodeName(),Toast.LENGTH_LONG).show();
                }

                @Override
                public void onPlaybackStateChanged(int playbackState) {
                    if(playbackState==Player.STATE_BUFFERING){
                        progressBar.setVisibility(View.VISIBLE);
                    }else if(playbackState==Player.STATE_READY){
                        progressBar.setVisibility(View.GONE);
                    }
                }
            });


// Set load control to ExoPlayer

            playerView.setPlayer(exoPlayer);
            exoPlayer.seekTo(0);
            exoPlayer.setRepeatMode(Player.REPEAT_MODE_ONE);

            DataSource.Factory datasourceFactory=new DefaultDataSource.Factory(context);

            MediaSource mediaSource = new ProgressiveMediaSource.Factory(datasourceFactory)
                    .createMediaSource(MediaItem.fromUri(Uri.parse(videoUrl)));
            exoPlayer.setMediaSource(mediaSource);
            exoPlayer.prepare();

            if(getAbsoluteAdapterPosition()==0){
                exoPlayer.setPlayWhenReady(true);
                exoPlayer.play();
            }
            onVideoPrepareCallBack.onVideoPrepared(new ExoplayerItem(exoPlayer,getAbsoluteAdapterPosition()));

        }
    }
    interface OnVideoPrepareCallBack{
        void onVideoPrepared(ExoplayerItem exoplayerItem);
    }

}
