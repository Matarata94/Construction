package ir.matarata.construction;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private SectionDetailsFragment secdet;
    private database db;
    private String mainColor;

    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    public static FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new database(this);
        db.databasecreate();
        db.open();
        mainColor = db.QuerySetting(1,1);
        db.close();
        secdet = new SectionDetailsFragment();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(Color.parseColor(mainColor));
        Typeface myfont = Typeface.createFromAsset(getAssets(), "BFARNAZ.TTF");
        android.support.v7.widget.AppCompatTextView tv_ins = (android.support.v7.widget.AppCompatTextView) findViewById(R.id.toolbar_title);
        tv_ins.setText("همراه سازه");
        tv_ins.setGravity(Gravity.CENTER);
        tv_ins.setTextSize(25);
        tv_ins.setTypeface(myfont);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.shitstuff);

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();
                switch (menuItem.getItemId()){
                    case R.id.nav_item_new:
                        new MaterialDialog.Builder(MainActivity.this)
                                .content(R.string.mainActivity_resetdata_dialog_content)
                                .positiveText("تایید")
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                                        xfragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();
                                    }
                                })
                                .negativeText("انصراف")
                                .show();
                        break;
                    case R.id.nav_item_contactus:
                        Intent in =new Intent(MainActivity.this,ContactusActivity.class);
                        startActivity(in);
                        break;
                    case R.id.nav_item_setting:
                        Intent in2 =new Intent(MainActivity.this,SettingActivity.class);
                        startActivity(in2);
                        break;
                }
                return false;
            }

        });

        android.support.v7.widget.Toolbar toolbar2 = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar2, R.string.app_name, R.string.app_name);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        int positionOfMenuItem = 0; //or any other postion
        MenuItem item = menu.getItem(positionOfMenuItem);
        SpannableString s = new SpannableString("اشتراک گذاری برنامه");
        s.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), 0, s.length(), 0);
        item.setTitle(s);

        int positionOfMenuItem2 = 1; //or any other postion
        MenuItem item2 = menu.getItem(positionOfMenuItem2);
        SpannableString s2 = new SpannableString("امتیازدهی به برنامه");
        s2.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), 0, s2.length(), 0);
        item2.setTitle(s2);

        int positionOfMenuItem3 = 2; //or any other postion
        MenuItem item3 = menu.getItem(positionOfMenuItem3);
        SpannableString s3 = new SpannableString("درباره ما");
        s3.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), 0, s3.length(), 0);
        item3.setTitle(s3);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_shareapp) {
            try {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                String sAux = "\nلطفا نرم افزار زیر را دانلود کنید\n\n";
                sAux = sAux + "https://cafebazaar.ir/app/com.matarata.englishquiz/?l=fa \n\n";
                i.putExtra(Intent.EXTRA_TEXT, sAux);
                startActivity(Intent.createChooser(i, "choose one"));
            }
            catch(Exception e)
            { //e.toString();
            }
        }else if (id == R.id.action_rateapp) {
            Intent intent = new Intent(Intent.ACTION_EDIT);
            intent.setData(Uri.parse("bazaar://details?id=" + "com.matarata.englishquiz"));
            intent.setPackage("com.farsitel.bazaar");
            startActivity(intent);
        }else if (id == R.id.action_aboutus) {
            Intent i = new Intent(MainActivity.this,AboutusDialog.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(Gravity.LEFT);
        }/*else if(SectionDetailsFragment.keyboard_fragment!=null) {
            if(SectionDetailsFragment.keyboard_fragment.isVisible()) {
                getSupportFragmentManager().beginTransaction().remove(SectionDetailsFragment.keyboard_fragment).commit();
                SectionDetailsFragment.keyboard_fragment = null;
            }else{
                Intent exitintent = new Intent(getApplicationContext(),ExitDialog.class);
                startActivity(exitintent);
            }
        }*/else{
            Intent exitintent = new Intent(getApplicationContext(),ExitDialog.class);
            startActivity(exitintent);
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.exit(0);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}