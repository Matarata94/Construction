package ir.matarata.construction;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;

public class ContactusActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);
        toolbar = (Toolbar) findViewById(R.id.contactus_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Typeface myfont = Typeface.createFromAsset(getAssets(), "BFARNAZ.TTF");
        android.support.v7.widget.AppCompatTextView tv_ins = (android.support.v7.widget.AppCompatTextView) findViewById(R.id.contactus_toolbartitle);
        tv_ins.setText("ارتباط با ما");
        tv_ins.setGravity(Gravity.CENTER);
        tv_ins.setTextSize(25);
        tv_ins.setTypeface(myfont);
    }
}
