package org.tensorflow.lite.examples.posenet;

import android.content.Context;
import android.media.MediaPlayer;

import java.io.Serializable;

public class MyPlayer implements Serializable {
    MediaPlayer player;

    public MyPlayer(Context context) {
        player = MediaPlayer.create(context, R.raw.song);
    }
    public void start() {
        player.setLooping(true);
        player.setVolume(100, 100);
        player.start();
    }
    public void stop() {
        player.setLooping(false);
        player.stop();
    }
}
