package ir.matarata.construction;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

public class ActivityMain extends AppCompatActivity {

    private Toolbar toolbar;
    private DatabaseHandler db;
    private String mainColor;

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    public static FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        }
        setContentView(R.layout.activity_main);

        initiate();

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                mNavigationView.setCheckedItem(itemId);
                mDrawerLayout.closeDrawers();
                switch (itemId){
                    case R.id.nav_item_actionChoose:
                        mFragmentTransaction = mFragmentManager.beginTransaction();
                        mFragmentTransaction.replace(R.id.containerView, new FragmentAction()).commit();
                        break;
                    case R.id.nav_item_new:
                        new MaterialDialog.Builder(ActivityMain.this)
                                .content(R.string.mainActivity_resetdata_dialog_content)
                                .positiveText("تایید")
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        mFragmentTransaction = mFragmentManager.beginTransaction();
                                        mFragmentTransaction.replace(R.id.containerView, new FragmentTab()).commit();
                                    }
                                })
                                .negativeText("انصراف")
                                .show();
                        break;
                    case R.id.nav_item_save:
                        break;
                    case R.id.nav_item_open:
                        break;
                    case R.id.nav_item_vip:
                        break;
                    case R.id.nav_item_setting:
                        Intent in =new Intent(ActivityMain.this,ActivitySetting.class);
                        startActivity(in);
                        break;
                    case R.id.nav_item_shareapp:
                        try {
                            Intent i = new Intent(Intent.ACTION_SEND);
                            i.setType("text/plain");
                            i.putExtra(Intent.EXTRA_SUBJECT, "همراه سازه");
                            String sAux = "\nلطفا نرم افزار زیر را دانلود کنید\n\n";
                            sAux = sAux + "https://cafebazaar.ir/app/com.matarata.englishquiz/?l=fa \n\n";
                            i.putExtra(Intent.EXTRA_TEXT, sAux);
                            startActivity(Intent.createChooser(i, "انتخاب کنید"));
                        }
                        catch(Exception e)
                        {
                        }
                        break;
                    case R.id.nav_item_ratingapp:
                        Intent intent = new Intent(Intent.ACTION_EDIT);
                        intent.setData(Uri.parse("bazaar://details?id=" + "com.matarata.englishquiz"));
                        intent.setPackage("com.farsitel.bazaar");
                        startActivity(intent);
                        break;
                    case R.id.nav_item_contactus:
                        Intent in2 =new Intent(ActivityMain.this,ActivityContactus.class);
                        startActivity(in2);
                        break;
                    case R.id.nav_item_aboutus:
                        Intent in3 =new Intent(ActivityMain.this,DialogAboutus.class);
                        startActivity(in3);
                        break;
                }
                return false;
            }

        });

    }

    private void initiate(){
        db = new DatabaseHandler(this);
        db.databasecreate();
        db.open();
        mainColor = db.QuerySetting(1,1);
        db.close();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setBackgroundColor(Color.parseColor(mainColor));
        Typeface myfont = Typeface.createFromAsset(getAssets(), "BFARNAZ.TTF");
        TextView tv_ins = (TextView) findViewById(R.id.toolbar_title);
        tv_ins.setText("همراه سازه");
        tv_ins.setGravity(Gravity.CENTER);
        tv_ins.setTextSize(25);
        tv_ins.setTypeface(myfont);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.shitstuff);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name, R.string.app_name);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView, new FragmentTab()).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(Gravity.RIGHT)) {
            mDrawerLayout.closeDrawer(Gravity.RIGHT);
        }else{
            Intent exitintent = new Intent(getApplicationContext(),DialogExit.class);
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
}