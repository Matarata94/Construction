package ir.matarata.construction;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import net.steamcrafted.loadtoast.LoadToast;

public class ActivityContactus extends AppCompatActivity {

    private Toolbar toolbar;
    private MaterialEditText nameet,emailet,criticset;
    private CheckBox criticscb,suggestscb;
    private LoadToast lt;
    private AppCompatButton sendbtn;
    private String contentOfEmailType="",contentOfEmail="";
    private DatabaseHandler db;
    private String dbHexColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);

        toolbar = (Toolbar) findViewById(R.id.contactus_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        db = new DatabaseHandler(this);
        db.open();
        dbHexColor = db.QuerySetting(1,1);
        db.close();
        Typeface myfont = Typeface.createFromAsset(getAssets(), "BFARNAZ.TTF");
        TextView tv_ins = (TextView) findViewById(R.id.contactus_toolbartitle);
        tv_ins.setTypeface(myfont);
        nameet = (MaterialEditText) findViewById(R.id.contactus_name);
        emailet = (MaterialEditText) findViewById(R.id.contactus_email);
        criticset = (MaterialEditText) findViewById(R.id.contactus_critics);
        criticscb = (CheckBox) findViewById(R.id.contactus_criticscb);
        suggestscb = (CheckBox) findViewById(R.id.contactus_suggestscb);
        sendbtn = (AppCompatButton) findViewById(R.id.contactus_send);
        toolbar.setBackgroundColor(Color.parseColor(dbHexColor));
        sendbtn.setBackgroundColor(Color.parseColor(dbHexColor));
        lt = new LoadToast(this);

        criticscb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){
                    if(suggestscb.isChecked()){
                        criticset.setHint("پیشنهادات و انتقادات");
                        criticset.setFloatingLabelText("پیشنهادات و انتقادات");
                    }else{
                        criticset.setHint("پیشنهادات");
                        criticset.setFloatingLabelText("پیشنهادات");
                    }
                }else{
                    if(suggestscb.isChecked()){
                        criticset.setHint("انتقادات");
                        criticset.setFloatingLabelText("انتقادات");
                    }else{
                        criticset.setHint("هیچ گزینه ای انتخاب نشده است!");
                        criticset.setFloatingLabelText("هیچ گزینه ای انتخاب نشده است!");
                    }
                }
            }
        });
        suggestscb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){
                    if(criticscb.isChecked()){
                        criticset.setHint("پیشنهادات و انتقادات");
                        criticset.setFloatingLabelText("پیشنهادات و انتقادات");
                    }else{
                        criticset.setHint("انتقادات");
                        criticset.setFloatingLabelText("انتقادات");
                    }
                }else{
                    if(criticscb.isChecked()){
                        criticset.setHint("پیشنهادات");
                        criticset.setFloatingLabelText("پیشنهادات");
                    }else{
                        criticset.setHint("هیچ گزینه ای انتخاب نشده است!");
                        criticset.setFloatingLabelText("هیچ گزینه ای انتخاب نشده است!");
                    }
                }
            }
        });
        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nameet.getText().toString().equals("") | emailet.getText().toString().equals("") | criticset.getText().toString().equals("")){
                    Toast.makeText(ActivityContactus.this, "لطفا تمام فیلدها را پر نمایید!", Toast.LENGTH_LONG).show();
                }else if(nameet.getText().toString().length() < 3){
                    Toast.makeText(ActivityContactus.this, "نام باید حداقل 3 حرف باشد!", Toast.LENGTH_LONG).show();
                }else{
                    contentOfEmailType = criticset.getHint().toString();
                    contentOfEmail = criticset.getText().toString() + "\n\n" + nameet.getText().toString() + " , " + emailet.getText().toString();
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"mostafafahimi73@gmail.com"});
                    i.putExtra(Intent.EXTRA_SUBJECT, contentOfEmailType);
                    i.putExtra(Intent.EXTRA_TEXT   , contentOfEmail);
                    try {
                        startActivity(Intent.createChooser(i, "ارسال ایمیل..."));
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(ActivityContactus.this, "هیچ نرم افزاری برای ارسال ایمیل یافت نشد!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

}
