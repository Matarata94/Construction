package ir.matarata.construction;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.color.ColorChooserDialog;
import com.andexert.library.RippleView;
import com.github.pavlospt.CircleView;
import com.rey.material.widget.Switch;

import biz.kasual.materialnumberpicker.MaterialNumberPicker;

public class ActivitySetting extends AppCompatActivity implements ColorChooserDialog.ColorCallback{

    private Toolbar toolbar;
    private RippleView firstripple,secondripple,thirdripple,fourthripple,fifthripple,sixthripple;
    private TextView tvtheme,tvdefaultsetting,tvdecimal,tvdecimaldata,tvdefaultkeyboard,tvsavesdcard;
    private Button btnsave;
    private CircleView cvtheme;
    private Switch swdefaultkeyboard,swsavesdcard;
    private Typeface bfarnaz,iransans;
    private ColorChooserDialog colorChooserDialog;
    private String hexColor="",dbHexColor,swkeyboardValue="",dbSwKeayboardValue,swSaveSDcardValue="",dbSwSaveSDcard;
    private int decimalNumber=0,dbDecimalNumber;
    private DatabaseHandler db;
    private MaterialNumberPicker numberPicker;
    private String settingChanged="no";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        db = new DatabaseHandler(this);
        db.open();
        dbHexColor = db.QuerySetting(1,1);
        dbDecimalNumber = Integer.parseInt(db.QuerySetting(2,1));
        dbSwKeayboardValue = db.QuerySetting(3,1);
        dbSwSaveSDcard = db.QuerySetting(4,1);
        db.close();
        Initiate();

        firstripple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorChooserDialog = new ColorChooserDialog.Builder(ActivitySetting.this, R.string.color_choose_dialog)
                        .titleSub(R.string.color_choose_dialog_subtitle)  // title of dialog when viewing shades of a color
                        .accentMode(false)  // when true, will display accent palette instead of primary palette
                        .doneButton(R.string.color_choose_dialog_donebtn)  // changes label of the done button
                        .cancelButton(R.string.color_choose_dialog_cancelbtn)  // changes label of the cancel button
                        .backButton(R.string.color_choose_dialog_backbtn)  // changes label of the back button
                        .allowUserColorInput(false)
                        .dynamicButtonColor(true)  // defaults to true, false will disable changing action buttons' color to currently selected color
                        .show();
            }
        });
        secondripple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.open();
                db.UpdateSetting(db.QuerySetting(1,2),1,"color_code");
                db.UpdateSetting(db.QuerySetting(2,2),1,"decimal");
                db.UpdateSetting(db.QuerySetting(3,2),1,"keyboard_type");
                db.UpdateSetting(db.QuerySetting(4,2),1,"save_sdcard");
                db.close();
                new MaterialDialog.Builder(ActivitySetting.this)
                        .content(R.string.setting_savebtn_dialog_content)
                        .positiveText("تایید")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                System.exit(0);
                                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("ir.matarata.construction");
                                if (launchIntent != null) {
                                    startActivity(launchIntent);//null pointer check in case package name was not found
                                }
                            }
                        })
                        .negativeText("انصراف")
                        .show();
            }
        });
        thirdripple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPicker = new MaterialNumberPicker.Builder(ActivitySetting.this)
                        .minValue(1)
                        .maxValue(5)
                        .defaultValue(dbDecimalNumber)
                        .backgroundColor(Color.WHITE)
                        .separatorColor(Color.TRANSPARENT)
                        .textColor(Color.BLACK)
                        .textSize(20)
                        .enableFocusability(false)
                        .wrapSelectorWheel(true)
                        .build();
                new AlertDialog.Builder(ActivitySetting.this)
                        .setTitle("انتخاب تعداد اعشار")
                        .setView(numberPicker)
                        .setPositiveButton(getString(android.R.string.ok), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                tvdecimaldata.setText(String.valueOf(numberPicker.getValue()));
                                decimalNumber = numberPicker.getValue();
                                settingChanged = "yes";
                            }
                        })
                        .show();
            }
        });
        sixthripple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(settingChanged.equals("yes")){
                    db.open();
                    if(hexColor != ""){
                        db.UpdateSetting(hexColor,1,"color_code");
                    }
                    if(decimalNumber != 0){
                        db.UpdateSetting(String.valueOf(numberPicker.getValue()),1,"decimal");
                    }
                    if(!swkeyboardValue.equals("")){
                        db.UpdateSetting(swkeyboardValue,1,"keyboard_type");
                    }
                    if(!swSaveSDcardValue.equals("")){
                        db.UpdateSetting(swSaveSDcardValue,1,"save_sdcard");
                    }
                    db.close();
                    new MaterialDialog.Builder(ActivitySetting.this)
                            .content(R.string.setting_savebtn_dialog_content)
                            .positiveText("تایید")
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    System.exit(0);
                                    Intent launchIntent = getPackageManager().getLaunchIntentForPackage("ir.matarata.construction");
                                    if (launchIntent != null) {
                                        startActivity(launchIntent);//null pointer check in case package name was not found
                                    }
                                }
                            })
                            .negativeText("انصراف")
                            .show();
                }else if(settingChanged.equals("no")){
                    Toast.makeText(ActivitySetting.this, "تغییری صورت نگرفته است!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        swdefaultkeyboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(swdefaultkeyboard.isChecked() && dbSwKeayboardValue.equals("app_keyboard")){
                    swkeyboardValue = "device_keyboard";
                    settingChanged = "yes";
                }else if(!swdefaultkeyboard.isChecked() && dbSwKeayboardValue.equals("app_keyboard")){
                    swkeyboardValue = "";
                }else if(!swdefaultkeyboard.isChecked() && dbSwKeayboardValue.equals("device_keyboard")){
                    swkeyboardValue = "app_keyboard";
                    settingChanged = "yes";
                }else if(swdefaultkeyboard.isChecked() && dbSwKeayboardValue.equals("device_keyboard")){
                    swkeyboardValue = "";
                }
            }
        });
        swsavesdcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!swsavesdcard.isChecked() && dbSwSaveSDcard.equals("yes")){
                    swSaveSDcardValue = "no";
                    settingChanged = "yes";
                }else if(swsavesdcard.isChecked() && dbSwSaveSDcard.equals("yes")){
                    swSaveSDcardValue = "";
                }else if(swsavesdcard.isChecked() && dbSwSaveSDcard.equals("no")){
                    swSaveSDcardValue = "yes";
                    settingChanged = "yes";
                }else if(!swsavesdcard.isChecked() && dbSwSaveSDcard.equals("no")){
                    swSaveSDcardValue = "";
                }
            }
        });


    }

    @Override
    public void onColorSelection(@NonNull ColorChooserDialog dialog, @ColorInt int color) {
        hexColor = String.format("#%06X", (0xFFFFFF & color));
        settingChanged = "yes";
    }

    private void Initiate(){
        toolbar = (Toolbar) findViewById(R.id.setting_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        bfarnaz = Typeface.createFromAsset(getAssets(), "BFARNAZ.TTF");
        TextView tv_ins = (TextView) findViewById(R.id.contactus_toolbartitle);
        tv_ins.setTypeface(bfarnaz);
        firstripple = (RippleView) findViewById(R.id.setting_firstripple);
        secondripple = (RippleView) findViewById(R.id.setting_secondripple);
        thirdripple = (RippleView) findViewById(R.id.setting_thirdripple);
        fourthripple = (RippleView) findViewById(R.id.setting_fourthripple);
        fifthripple = (RippleView) findViewById(R.id.setting_fifthripple);
        sixthripple = (RippleView) findViewById(R.id.setting_sixthripple);
        tvtheme = (TextView) findViewById(R.id.setting_tvtheme);
        tvdefaultsetting = (TextView) findViewById(R.id.setting_tv_defaultsetting);
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
        tvdefaultsetting.setTypeface(iransans);
        tvdecimal.setTypeface(iransans);
        tvdecimaldata.setTypeface(iransans);
        tvdefaultkeyboard.setTypeface(iransans);
        tvsavesdcard.setTypeface(iransans);
        btnsave.setTypeface(iransans);
        toolbar.setBackgroundColor(Color.parseColor(dbHexColor));
        cvtheme.setFillColor(Color.parseColor(dbHexColor));
        btnsave.setBackgroundColor(Color.parseColor(dbHexColor));
        tvdecimaldata.setText(String.valueOf(dbDecimalNumber));
        if(dbSwSaveSDcard.equals("yes")){
            swsavesdcard.setChecked(true);
        }
        if(dbSwKeayboardValue.equals("app_keyboard")){
            swdefaultkeyboard.setChecked(false);
        }else if(dbSwKeayboardValue.equals("device_keyboard")){
            swdefaultkeyboard.setChecked(true);
        }
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
