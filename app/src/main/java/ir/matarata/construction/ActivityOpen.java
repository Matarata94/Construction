package ir.matarata.construction;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;

public class ActivityOpen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);

        new CountDownTimer(1500, 1000) {
            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {

                Intent in = new Intent(ActivityOpen.this,ActivityMain.class);
                startActivity(in);
                finish();
            }
        }.start();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        System.exit(0);
    }
    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
    @Override
    protected void onPause() {
        super.onPause();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}