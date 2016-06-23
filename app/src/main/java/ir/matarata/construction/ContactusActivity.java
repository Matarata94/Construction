package ir.matarata.construction;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.gc.materialdesign.views.ButtonRectangle;
import com.rengwuxian.materialedittext.MaterialEditText;

import net.steamcrafted.loadtoast.LoadToast;

public class ContactusActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private MaterialEditText nameet,emailet,criticset;
    private CheckBox criticscb,suggestscb;
    private LoadToast lt;
    private ButtonRectangle sendbtn;

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
        nameet = (MaterialEditText) findViewById(R.id.contactus_name);
        emailet = (MaterialEditText) findViewById(R.id.contactus_email);
        criticset = (MaterialEditText) findViewById(R.id.contactus_critics);
        criticscb = (CheckBox) findViewById(R.id.contactus_criticscb);
        suggestscb = (CheckBox) findViewById(R.id.contactus_suggestscb);
        sendbtn = (ButtonRectangle) findViewById(R.id.contactus_send);
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
                //lt = new LoadToast(ContactusActivity.this).setText("در حال ارسال ...").setTranslationY(100).show();
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"mostafafahimi73@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
                i.putExtra(Intent.EXTRA_TEXT   , "body of email");
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(ContactusActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
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
