package ir.matarata.construction;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class DialogAboutus extends Activity {

    private TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_aboutus);
        setFinishOnTouchOutside(true);

        tv1 = (TextView) findViewById(R.id.aboutus_tv1);
        tv2 = (TextView) findViewById(R.id.aboutus_tv2);
        Typeface font1 = Typeface.createFromAsset(getAssets(),"iransansweb_medium.ttf");
        Typeface font2 = Typeface.createFromAsset(getAssets(),"iraniansans.ttf");
        tv1.setTypeface(font1);
        tv2.setTypeface(font2);

    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
