package ir.matarata.construction;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.wang.avi.AVLoadingIndicatorView;

public class DialogExit extends Activity {

    private TextView questiontv;
    private Button exitsavebtn,exitnosavebtn,cancelbtn,autonamebtn;
    private RelativeLayout wholerl;
    private MaterialEditText filenameet;
    private RippleView fourthripple,fifthripple;
    private AVLoadingIndicatorView doneprogress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.exit_dialog);
        setFinishOnTouchOutside(true);

        questiontv = (TextView) findViewById(R.id.exitdialog_questiontv);
        exitsavebtn = (Button) findViewById(R.id.exitdialog_exitsavebtn);
        exitnosavebtn = (Button) findViewById(R.id.exitdialog_exitnosavebtn);
        cancelbtn = (Button) findViewById(R.id.exitdialog_cancelbtn);
        autonamebtn = (Button) findViewById(R.id.exitdialog_autonamebtn);
        wholerl = (RelativeLayout) findViewById(R.id.exitdialog_wholerl);
        filenameet = (MaterialEditText) findViewById(R.id.exitdialog_filenameet);
        fourthripple = (RippleView) findViewById(R.id.exitdialog_fourthripple);
        fifthripple = (RippleView) findViewById(R.id.exitdialog_fifthripple);
        doneprogress = (AVLoadingIndicatorView) findViewById(R.id.exitdialog_doneprogress);

        Typeface font = Typeface.createFromAsset(getAssets(),"iraniansans.ttf");
        questiontv.setTypeface(font);
        exitsavebtn.setTypeface(font);
        exitnosavebtn.setTypeface(font);
        cancelbtn.setTypeface(font);
        filenameet.setTypeface(font);
        autonamebtn.setTypeface(font);

        exitsavebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer(300, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }
                    public void onFinish() {
                        if(!filenameet.isShown()){
                            exitsavebtn.setBackgroundColor(Color.parseColor("#b2dfdb"));
                            ViewGroup.LayoutParams params = wholerl.getLayoutParams();
                            params.height = dpToPx(260);
                            params.width = dpToPx(320);
                            wholerl.setLayoutParams(params);
                            filenameet.setVisibility(View.VISIBLE);
                            filenameet.startAnimation(AnimationUtils.loadAnimation(DialogExit.this, R.anim.exitdialog_fadein));
                            fourthripple.setVisibility(View.VISIBLE);
                            fourthripple.startAnimation(AnimationUtils.loadAnimation(DialogExit.this, R.anim.exitdialog_fadein));
                            doneprogress.setVisibility(View.VISIBLE);
                            doneprogress.startAnimation(AnimationUtils.loadAnimation(DialogExit.this, R.anim.exitdialog_fadein));
                        }
                    }
                }.start();
            }
        });
        exitnosavebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer(300, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }
                    public void onFinish() {
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        System.exit(0);
                    }
                }.start();
            }
        });
        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer(300, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }
                    public void onFinish() {
                        finish();
                    }
                }.start();
            }
        });
        filenameet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().equals("password")){
                    doneprogress.setVisibility(View.GONE);
                    fifthripple.setVisibility(View.VISIBLE);
                    filenameet.setFloatingLabelText("نام فایل صحیح است");
                }else {
                    doneprogress.setVisibility(View.VISIBLE);
                    fifthripple.setVisibility(View.GONE);
                    filenameet.setFloatingLabelText("نام فایل تکراری است");
                }
            }
        });

    }

    private int dpToPx(int value){
        Resources r = this.getResources();
        int px = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                value,
                r.getDisplayMetrics()
        );
        return px;
    }

    @Override
    public void onBackPressed() {
        finish();
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

}
