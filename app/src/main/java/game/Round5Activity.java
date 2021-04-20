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
import android.widget.Toast;

import com.example.songuesser.R;
import com.example.songuesser.main_menu.RegisterActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Round5Activity extends AppCompatActivity {

    Button play, pause, stop, v1, v2, v3, v4;
    MediaPlayer player;
    String username;
    String guesses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //ascudne bara de notificari
        getSupportActionBar().hide(); // ascunde bara de titlu
        setContentView(R.layout.activity_round5);
        play = findViewById(R.id.play_btn_5);
        pause = findViewById(R.id.pause_btn_5);
        stop = findViewById(R.id.stop_btn_5);
        v1 = findViewById(R.id.r5v1);
        v2 = findViewById(R.id.r5v2);
        v3 = findViewById(R.id.r5v3);
        v4 = findViewById(R.id.r5v4);

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

                        int final_guesses = Integer.parseInt(guesses) + 1;
                        put_score_in_leaderboard_database(username, final_guesses);

                        startActivity(new Intent(Round5Activity.this, PlayActivity.class));
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

                        int final_guesses = Integer.parseInt(guesses);
                        put_score_in_leaderboard_database(username, final_guesses);

                        startActivity(new Intent(Round5Activity.this, PlayActivity.class));
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

                        int final_guesses = Integer.parseInt(guesses);
                        put_score_in_leaderboard_database(username, final_guesses);

                        startActivity(new Intent(Round5Activity.this, PlayActivity.class));
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

                        int final_guesses = Integer.parseInt(guesses);
                        put_score_in_leaderboard_database(username, final_guesses);

                        startActivity(new Intent(Round5Activity.this, PlayActivity.class));
                        finish();
                    }
                }, 3000);

            }
        });

    }

    private void put_score_in_leaderboard_database(String username, int guesses){
        final boolean[] flag = {false};
        FirebaseDatabase.getInstance().getReference("Leaderboard").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    LeaderboardInformation ui = snapshot.getValue(LeaderboardInformation.class);
                    String db_username = ui.getUsername();
                    int db_score = ui.getScore();

                    if (db_username.equals(username) && db_score < guesses) {
                            snapshot.getRef().removeValue();
                    }
                    if (db_username.equals(username) && db_score >= guesses) {
                        flag[0] = true;
                    }

                }
            }
            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

        if (!flag[0]) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("Username", username);
            map.put("Score", guesses);

            FirebaseDatabase.getInstance().getReference().child("Leaderboard").push().updateChildren(map);
        }
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
            player = MediaPlayer.create(this, R.raw.headlong);
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