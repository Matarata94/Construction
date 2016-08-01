package ir.matarata.construction;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.github.pavlospt.CircleView;
import com.rey.material.widget.Switch;

public class SettingActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView tvtheme,tvfontsize,tvfontsizedata,tvdecimal,tvdecimaldata,tvdefaultkeyboard,tvsavesdcard;
    private Button btnsave;
    private CircleView cvtheme;
    private Switch swdefaultkeyboard,swsavesdcard;
    private Typeface bfarnaz,iransans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Initiate();

    }

    private void Initiate(){
        toolbar = (Toolbar) findViewById(R.id.setting_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        bfarnaz = Typeface.createFromAsset(getAssets(), "BFARNAZ.TTF");
        TextView tv_ins = (TextView) findViewById(R.id.contactus_toolbartitle);
        tv_ins.setTypeface(bfarnaz);
        tvtheme = (TextView) findViewById(R.id.setting_tvtheme);
        tvfontsize = (TextView) findViewById(R.id.setting_tv_fontsize);
        tvfontsizedata = (TextView) findViewById(R.id.setting_tv_fontsize_data);
        tvdecimal = (TextView) findViewById(R.id.setting_tv_decimal);
        tvdecimaldata = (TextView) findViewById(R.id.setting_tv_decimal_data);
        tvdefaultkeyboard = (TextView) findViewById(R.id.setting_tv_defaultkeyboard);
        tvsavesdcard = (TextView) findViewById(R.id.setting_tv_savesdcard);
        btnsave = (Button) findViewById(R.id.setting_btn_save);
        cvtheme = (CircleView) findViewById(R.id.setting_cv_theme);
        swdefaultkeyboard = (Switch) findViewById(R.id.setting_switch_defaultkeyboard);
        swsavesdcard = (Switch) findViewById(R.id.setting_switch_savesdcard);
        iransans = Typeface.createFromAsset(getAssets(), "iransansweb_medium.ttf");
        tvtheme.setTypeface(iransans);
        tvfontsize.setTypeface(iransans);
        tvfontsizedata.setTypeface(iransans);
        tvdecimal.setTypeface(iransans);
        tvdecimaldata.setTypeface(iransans);
        tvdefaultkeyboard.setTypeface(iransans);
        tvsavesdcard.setTypeface(iransans);
        btnsave.setTypeface(iransans);
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
