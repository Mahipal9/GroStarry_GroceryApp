package app.grostarry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.nio.channels.InterruptedByTimeoutException;

public class MainActivity extends AppCompatActivity
{
    private ProgressBar progressBar;
    private int progressStatus = 0;
    private Handler handler = new Handler();
    ImageView loadimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadimg = findViewById(R.id.load_img);






        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        // Start long running operation in a background thread
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {

                    if(progressStatus==40)
                    {
                        loadimg.setImageResource(R.drawable.loading_icona);
                    }
                    else if (progressStatus==75)
                    {
                        loadimg.setImageResource(R.drawable.loading_iconb);
                    }
                    else if(progressStatus==99)
                    {
                        Intent i = new Intent(getApplicationContext(),Home.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK |  Intent.FLAG_ACTIVITY_NO_ANIMATION );
                        startActivity(i);
                    }
                    progressStatus += 1;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressStatus);
                            // textView.setText(progressStatus+"/"+progressBar.getMax());
                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();



    }
}
