package ir.matarata.construction;

import android.graphics.Typeface;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.TextView;

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
        TextView tv_ins = (TextView) findViewById(R.id.contactus_toolbartitle);
        tv_ins.setTypeface(myfont);
        //onclick listener for up home button

    }
}
