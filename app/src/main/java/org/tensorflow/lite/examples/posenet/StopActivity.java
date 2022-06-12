package org.tensorflow.lite.examples.posenet;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Camera;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import org.tensorflow.lite.examples.posenet.lib.Posenet;

public class StopActivity extends AppCompatActivity {
    MediaPlayer player;
    MyPlayer myPlayer;
    Bundle bundle;
    int i = 0, resume = 0;
    @Override
    protected void onStart() {
        super.onStart();
        String res = getIntent().getStringExtra("key");
        i++;
        //Toast.makeText(getApplicationContext(), "I = " + i, Toast.LENGTH_SHORT).show();
        if(player != null ) {
            player.stop();
        }
//        if(res != null && res.equalsIgnoreCase("ok")) {
//            Toast.makeText(getApplicationContext(), "Stopping!!!!!!", Toast.LENGTH_LONG).show();
//            player.stop();
//        }
        //Toast.makeText(getApplicationContext(), "Res = " + res, Toast.LENGTH_SHORT).show();
    }
    protected void onResume() {
        super.onResume();
        String res = getIntent().getStringExtra("key");
        i++;
        resume++;
        //Toast.makeText(getApplicationContext(), "I = " + i + " resume = " + resume, Toast.LENGTH_SHORT).show();
        if(player != null ) {
            player.stop();
        }
//        if(res != null && res.equalsIgnoreCase("ok")) {
//            Toast.makeText(getApplicationContext(), "Stopping!!!!!!", Toast.LENGTH_LONG).show();
//            player.stop();
//        }
        //Toast.makeText(getApplicationContext(), "Res = " + res, Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop);
        Context context = getApplicationContext();
        player = MediaPlayer.create(context, R.raw.song);
        i++;
        //Toast.makeText(getApplicationContext(), "I on create= " + i, Toast.LENGTH_SHORT).show();
        if(player != null) {
            player.stop();
        }
        player.setLooping(true);
        player.setVolume(100, 100);
        player.start();

        findViewById(R.id.stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera = new Intent(getApplicationContext(), CameraActivity.class);
                startActivityForResult(camera, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        String res = data.getStringExtra("res");
//        if(requestCode == 1 && res.equalsIgnoreCase("ok") && resultCode == 2) {
//            //Toast.makeText(getApplicationContext(), "Stopping!!!!!!", Toast.LENGTH_LONG).show();
//            player.stop();
//        } else {
//            //Toast.makeText(getApplicationContext(), "Stopping!!!!!!", Toast.LENGTH_LONG).show();
//            startActivityForResult(new Intent(getApplicationContext(), CameraActivity.class), 1);
//        }
        Toast.makeText(getApplicationContext(), "Successfully completed the tasks", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
//    public void tem() {
//        String res = getIntent().getStringExtra("key");
//        if(res == null) {
//            res = "no";
//        }
//        startActivityForResult(new Intent(getApplicationContext(), Posenet.class), 1);
//        Intent i = new Intent(getApplicationContext(), StopActivity.class );
//        i.putExtra("res", "ok");
//        startActivity(i);
//    }
}