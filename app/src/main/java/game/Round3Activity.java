package game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.songuesser.R;

public class Round3Activity extends AppCompatActivity {

    Button play, pause, stop, v1, v2, v3, v4;
    MediaPlayer player;
    String username;
    String guesses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //ascudne bara de notificari
        getSupportActionBar().hide(); // ascunde bara de titlu
        setContentView(R.layout.activity_round3);
        play = findViewById(R.id.play_btn_3);
        pause = findViewById(R.id.pause_btn_3);
        stop = findViewById(R.id.stop_btn_3);
        v1 = findViewById(R.id.r3v1);
        v2 = findViewById(R.id.r3v2);
        v3 = findViewById(R.id.r3v3);
        v4 = findViewById(R.id.r3v4);

        username = getIntent().getStringExtra("username");
        guesses = getIntent().getStringExtra("guesses");

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(v);
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause(v);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop(v);
            }
        });

        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1.setBackgroundColor(Color.GREEN);
                v2.setBackgroundColor(Color.RED);
                v3.setBackgroundColor(Color.RED);
                v4.setBackgroundColor(Color.RED);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        Intent intent = new Intent(Round3Activity.this, Round4Activity.class);
                        intent.putExtra("username", username);
                        intent.putExtra("guesses", String.valueOf(Integer.parseInt(guesses) + 1));
                        startActivity(intent);
                        finish();
                    }
                }, 3000);

            }
        });

        v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1.setBackgroundColor(Color.GREEN);
                v2.setBackgroundColor(Color.RED);
                v3.setBackgroundColor(Color.RED);
                v4.setBackgroundColor(Color.RED);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        Intent intent = new Intent(Round3Activity.this, Round4Activity.class);
                        intent.putExtra("username", username);
                        intent.putExtra("guesses", guesses);
                        startActivity(intent);
                        finish();
                    }
                }, 3000);

            }
        });

        v3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1.setBackgroundColor(Color.GREEN);
                v2.setBackgroundColor(Color.RED);
                v3.setBackgroundColor(Color.RED);
                v4.setBackgroundColor(Color.RED);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        Intent intent = new Intent(Round3Activity.this, Round4Activity.class);
                        intent.putExtra("username", username);
                        intent.putExtra("guesses", guesses);
                        startActivity(intent);
                        finish();
                    }
                }, 3000);

            }
        });

        v4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1.setBackgroundColor(Color.GREEN);
                v2.setBackgroundColor(Color.RED);
                v3.setBackgroundColor(Color.RED);
                v4.setBackgroundColor(Color.RED);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        Intent intent = new Intent(Round3Activity.this, Round4Activity.class);
                        intent.putExtra("username", username);
                        intent.putExtra("guesses", guesses);
                        startActivity(intent);
                        finish();
                    }
                }, 3000);

            }
        });

    }

    @Override
    public void onResume(){
        super.onResume();
        View decorView = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            // Set the content to appear under the system bars so that the
                            // content doesn't resize when the system bars hide and show.
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            // Hide the nav bar and status bar
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN);
        }}

    @Override
    protected void onStart()
    {
        super.onStart();
        View decorView = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            // Set the content to appear under the system bars so that the
                            // content doesn't resize when the system bars hide and show.
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            // Hide the nav bar and status bar
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN);
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {

        View decorView = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            // Set the content to appear under the system bars so that the
                            // content doesn't resize when the system bars hide and show.
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            // Hide the nav bar and status bar
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN);

        }
    }

    public void play(View v){
        if(player == null){
            Context context;
            player = MediaPlayer.create(this, R.raw.demon_fire);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        player.start();
    }

    public void pause(View v){
        if(player != null){
            player.pause();
        }
    }

    public void stop(View v){
        stopPlayer();
    }

    private void stopPlayer(){
        if(player != null) {
            player.release();
            player = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }
}