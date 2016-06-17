package ir.matarata.construction;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class AboutusDialog extends Activity {

    private TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.aboutus_dialog);
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
