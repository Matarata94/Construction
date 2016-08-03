package ir.matarata.construction;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.dd.morphingbutton.MorphingButton;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.software.shell.fab.ActionButton;

/**
 * Created by Matarata on 5/24/2016.
 */
public class SectionDetailsFragment extends Fragment implements View.OnClickListener,View.OnTouchListener,View.OnFocusChangeListener{

    private View view;
    public Button arrowbtn,ayinnamebtn,maghtabtn;
    private RelativeLayout toprl,botrl,wholerl;
    public static LinearLayout fabselectedll;
    private ScrollView botscroll;
    private ImageView toprlimg;
    private MorphingButton ayinnameiranbtn,ayinnameusabtn,maghtamostatily,maghtatirchebolok,maghtalshekl,maghtatshekl;
    private TextView tv1,tv2,tv3,tv4,tv5,tv6,tv1data,tv2data,tv3data,tv4data,tv5data,tv6data,tvh,tvb,tvfc,tvfy;
    public static MaterialEditText meth,metb,spdownarm,spdownarmnumber,spdownarmcover,spuparm,spuparmnumber,spuparmcover,spties,sptiesnumber,sptiescover,metfc,metfy;
    private Typeface PersianFont,EnglishFont;
    private int arrow=0;
    public static KeyboardFragment keyboard_fragment;
    public static ActionButton fab,subfab1,subfab2,subfab3,subfab4,subfab5,subfab6,subfab7;
    private Intent in;
    private database db;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.sectiondetails_fragment,container,false);
        Initiate();
        db = new database(getActivity());
        db.open();
        maghtabtn.setText(db.QueryInformation(1,1));
        db.close();

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.secdet_arrowbtn:
                if(arrow == 0){
                    if(ayinnameiranbtn.isShown()){
                        hideAyinname();
                    }
                    if(maghtamostatily.isShown()){
                        hideMaghta();
                    }
                    hideToprl();
                }else if(arrow == 1){
                    showToprl();
                }
                break;
            case R.id.secdet_ayinnamebtn:
                if(!toprl.isShown()){
                    showToprl();
                }
                if(maghtamostatily.isShown()){
                    hideMaghta();
                }
                if(ayinnameiranbtn.isShown()){
                    hideAyinname();
                }else{
                    showAyinname();
                }
                break;
            case R.id.secdet_ayinnameiran:
                hideAyinname();
                ayinnamebtn.setText("آیین نامه بتن ایران");
                break;
            case R.id.secdet_ayinnameusa:
                hideAyinname();
                ayinnamebtn.setText("آیین نامه بتن آمریکا");
                break;
            case R.id.secdet_maghtabtn:
                if(!toprl.isShown()){
                    showToprl();
                }
                if(ayinnameiranbtn.isShown()){
                    hideAyinname();
                }
                if(maghtamostatily.isShown()){
                    hideMaghta();
                }else{
                    showMaghta();
                }
                break;
            case R.id.secdet_maghtamostatily:
                AlertDialog("مقطع مستطیلی");
                break;
            case R.id.secdet_maghtatirchebolok:
                AlertDialog("تیرچه بلوک");
                break;
            case R.id.secdet_maghtalshekl:
                AlertDialog("مقطع L شکل");
                break;
            case R.id.secdet_maghtatshekl:
                AlertDialog("مقطع T شکل");
                break;
            case R.id.secdet_fab:
                if(subfab1.isShown()){
                    hideFab(R.drawable.n_mm);
                }else{
                    showFab();
                }
                break;
            case R.id.secdet_subfab1:
                hideFab(R.drawable.nm);
                break;
            case R.id.secdet_subfab2:
                hideFab(R.drawable.n_mm);
                break;
            case R.id.secdet_subfab3:
                hideFab(R.drawable.knm);
                break;
            case R.id.secdet_subfab4:
                hideFab(R.drawable.kgf_mm);
                break;
            case R.id.secdet_subfab5:
                hideFab(R.drawable.kgf_cm);
                break;
            case R.id.secdet_subfab6:
                hideFab(R.drawable.kgf_m);
                break;
            case R.id.secdet_subfab7:
                hideFab(R.drawable.tonf_m);
                break;

            /*case R.id.secdet_meth:
                if(keyboard_fragment==null)
                {
                    keyboard_fragment=KeyboardFragment.newInstance(meth.getText().toString());
                    getActivity().getSupportFragmentManager().beginTransaction().add(R.id.Keyboard_container, keyboard_fragment).commit();
                }
                break;
            case R.id.secdet_metb:
                if(keyboard_fragment==null)
                {
                    keyboard_fragment=KeyboardFragment.newInstance(metb.getText().toString());
                    getActivity().getSupportFragmentManager().beginTransaction().add(R.id.Keyboard_container, keyboard_fragment).commit();
                }
                break;
            case R.id.secdet_spdownarm:
                if(keyboard_fragment==null)
                {
                    keyboard_fragment=KeyboardFragment.newInstance(spdownarm.getText().toString());
                    getActivity().getSupportFragmentManager().beginTransaction().add(R.id.Keyboard_container, keyboard_fragment).commit();
                }
                break;
            case R.id.secdet_spdownarmnumber:
                if(keyboard_fragment==null)
                {
                    keyboard_fragment=KeyboardFragment.newInstance(spdownarmnumber.getText().toString());
                    getActivity().getSupportFragmentManager().beginTransaction().add(R.id.Keyboard_container, keyboard_fragment).commit();
                }
                break;
            case R.id.secdet_spdownarmcover:
                if(keyboard_fragment==null)
                {
                    keyboard_fragment=KeyboardFragment.newInstance(spdownarmcover.getText().toString());
                    getActivity().getSupportFragmentManager().beginTransaction().add(R.id.Keyboard_container, keyboard_fragment).commit();
                }
                break;
            case R.id.secdet_spuparm:
                if(keyboard_fragment==null)
                {
                    keyboard_fragment=KeyboardFragment.newInstance(spuparm.getText().toString());
                    getActivity().getSupportFragmentManager().beginTransaction().add(R.id.Keyboard_container, keyboard_fragment).commit();
                }
                break;
            case R.id.secdet_spuparmnumber:
                if(keyboard_fragment==null)
                {
                    keyboard_fragment=KeyboardFragment.newInstance(spuparmnumber.getText().toString());
                    getActivity().getSupportFragmentManager().beginTransaction().add(R.id.Keyboard_container, keyboard_fragment).commit();
                }
                break;
            case R.id.secdet_spuparmcover:
                if(keyboard_fragment==null)
                {
                    keyboard_fragment=KeyboardFragment.newInstance(spuparmcover.getText().toString());
                    getActivity().getSupportFragmentManager().beginTransaction().add(R.id.Keyboard_container, keyboard_fragment).commit();
                }
                break;
            case R.id.secdet_spties:
                if(keyboard_fragment==null)
                {
                    keyboard_fragment=KeyboardFragment.newInstance(spties.getText().toString());
                    getActivity().getSupportFragmentManager().beginTransaction().add(R.id.Keyboard_container, keyboard_fragment).commit();
                }
                break;
            case R.id.secdet_sptiesnumber:
                if(keyboard_fragment==null)
                {
                    keyboard_fragment=KeyboardFragment.newInstance(sptiesnumber.getText().toString());
                    getActivity().getSupportFragmentManager().beginTransaction().add(R.id.Keyboard_container, keyboard_fragment).commit();
                }
                break;
            case R.id.secdet_sptiescover:
                if(keyboard_fragment==null)
                {
                    keyboard_fragment=KeyboardFragment.newInstance(sptiescover.getText().toString());
                    getActivity().getSupportFragmentManager().beginTransaction().add(R.id.Keyboard_container, keyboard_fragment).commit();
                }
                break;
            case R.id.secdet_metfc:
                if(keyboard_fragment==null)
                {
                    keyboard_fragment=KeyboardFragment.newInstance(metfc.getText().toString());
                    getActivity().getSupportFragmentManager().beginTransaction().add(R.id.Keyboard_container, keyboard_fragment).commit();
                }
                break;
            case R.id.secdet_metfy:
                if(keyboard_fragment==null)
                {
                    keyboard_fragment=KeyboardFragment.newInstance(metfy.getText().toString());
                    getActivity().getSupportFragmentManager().beginTransaction().add(R.id.Keyboard_container, keyboard_fragment).commit();
                }
                break;*/
        }
    }

    @Override
    public void onFocusChange(View v, boolean b) {
        /*if(meth.hasFocus()){
            if(keyboard_fragment==null)
            {
                keyboard_fragment=new KeyboardFragment();
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.Keyboard_container, keyboard_fragment).commit();
            }
            KeyboardFragment.sb = new StringBuilder();
            KeyboardFragment.sb.insert(0,meth.getText());
        }else if(metb.hasFocus()){
            if(keyboard_fragment==null)
            {
                keyboard_fragment=new KeyboardFragment();
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.Keyboard_container, keyboard_fragment).commit();
            }
            KeyboardFragment.sb = new StringBuilder();
            KeyboardFragment.sb.insert(0,metb.getText());
        }else if(spdownarm.hasFocus()){
            if(keyboard_fragment==null)
            {
                keyboard_fragment=KeyboardFragment.newInstance(spdownarm.getText().toString());
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.Keyboard_container, keyboard_fragment).commit();
            }
            KeyboardFragment.sb = new StringBuilder();
            KeyboardFragment.sb.append(spdownarm.getText());
        }else if(spdownarmnumber.hasFocus()){
            if(keyboard_fragment==null)
            {
                keyboard_fragment=KeyboardFragment.newInstance(spdownarmnumber.getText().toString());
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.Keyboard_container, keyboard_fragment).commit();
            }
            KeyboardFragment.sb = new StringBuilder();
            KeyboardFragment.sb.append(spdownarmnumber.getText());
        }else if(spdownarmcover.hasFocus()){
            if(keyboard_fragment==null)
            {
                keyboard_fragment=KeyboardFragment.newInstance(spdownarmcover.getText().toString());
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.Keyboard_container, keyboard_fragment).commit();
            }
            KeyboardFragment.sb = new StringBuilder();
            KeyboardFragment.sb.append(spdownarmcover.getText());
        }else if(spuparm.hasFocus()){
            if(keyboard_fragment==null)
            {
                keyboard_fragment=KeyboardFragment.newInstance(spuparm.getText().toString());
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.Keyboard_container, keyboard_fragment).commit();
            }
            KeyboardFragment.sb = new StringBuilder();
            KeyboardFragment.sb.append(spuparm.getText());
        }else if(spuparmnumber.hasFocus()){
            if(keyboard_fragment==null)
            {
                keyboard_fragment=KeyboardFragment.newInstance(spuparmnumber.getText().toString());
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.Keyboard_container, keyboard_fragment).commit();
            }
            KeyboardFragment.sb = new StringBuilder();
            KeyboardFragment.sb.append(spuparmnumber.getText());
        }else if(spuparmcover.hasFocus()){
            if(keyboard_fragment==null)
            {
                keyboard_fragment=KeyboardFragment.newInstance(spuparmcover.getText().toString());
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.Keyboard_container, keyboard_fragment).commit();
            }
            KeyboardFragment.sb = new StringBuilder();
            KeyboardFragment.sb.append(spuparmcover.getText());
        }else if(spties.hasFocus()){
            if(keyboard_fragment==null)
            {
                keyboard_fragment=KeyboardFragment.newInstance(spties.getText().toString());
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.Keyboard_container, keyboard_fragment).commit();
            }
            KeyboardFragment.sb = new StringBuilder();
            KeyboardFragment.sb.append(spties.getText());
        }else if(sptiesnumber.hasFocus()){
            if(keyboard_fragment==null)
            {
                keyboard_fragment=KeyboardFragment.newInstance(sptiesnumber.getText().toString());
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.Keyboard_container, keyboard_fragment).commit();
            }
            KeyboardFragment.sb = new StringBuilder();
            KeyboardFragment.sb.append(sptiesnumber.getText());
        }else if(sptiescover.hasFocus()){
            if(keyboard_fragment==null)
            {
                keyboard_fragment=KeyboardFragment.newInstance(sptiescover.getText().toString());
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.Keyboard_container, keyboard_fragment).commit();
            }
            KeyboardFragment.sb = new StringBuilder();
            KeyboardFragment.sb.append(sptiescover.getText());
        }else if(metfc.hasFocus()){
            if(keyboard_fragment==null)
            {
                keyboard_fragment=KeyboardFragment.newInstance(metfc.getText().toString());
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.Keyboard_container, keyboard_fragment).commit();
            }
            KeyboardFragment.sb = new StringBuilder();
            KeyboardFragment.sb.append(metfc.getText());
        }else if(metfy.hasFocus()){
            if(keyboard_fragment==null)
            {
                keyboard_fragment=KeyboardFragment.newInstance(metfy.getText().toString());
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.Keyboard_container, keyboard_fragment).commit();
            }
            KeyboardFragment.sb = new StringBuilder();
            KeyboardFragment.sb.append(metfy.getText());
        }*/
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        v.onTouchEvent(event);
        //Disable default device keyboard
        /*InputMethodManager imm = (InputMethodManager)v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }*/
        return true;
    }

    private int dpToPx(int value){
        Resources r = getContext().getResources();
        int px = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                value,
                r.getDisplayMetrics()
        );
        return px;
    }

    public void hideFab(int imageName){
        fab.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fab_anim));
        fab.setType(ActionButton.Type.DEFAULT);
        fab.setImageResource(imageName);
        fab.setImageSize(60.0f);
        fabselectedll.setVisibility(View.GONE);
        arrowbtn.setEnabled(true);
        ayinnamebtn.setEnabled(true);
        maghtabtn.setEnabled(true);
        subfab1.setHideAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.subfab1_fadeout));
        subfab2.setHideAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.subfab2_fadeout));
        subfab3.setHideAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.subfab3_fadeout));
        subfab4.setHideAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.subfab4_fadeout));
        subfab5.setHideAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.subfab5_fadeout));
        subfab6.setHideAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.subfab6_fadeout));
        subfab7.setHideAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.subfab7_fadeout));
        subfab1.hide();
        subfab2.hide();
        subfab3.hide();
        subfab4.hide();
        subfab5.hide();
        subfab6.hide();
        subfab7.hide();
    }

    public void showFab(){
        fab.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fab_anim));
        fab.setType(ActionButton.Type.MINI);
        fab.setImageResource(R.drawable.closeicon);
        fab.setImageSize(15.0f);
        fabselectedll.setVisibility(View.VISIBLE);
        arrowbtn.setEnabled(false);
        ayinnamebtn.setEnabled(false);
        maghtabtn.setEnabled(false);
        subfab1.setShowAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.subfab1_fadein));
        subfab2.setShowAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.subfab2_fadein));
        subfab3.setShowAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.subfab3_fadein));
        subfab4.setShowAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.subfab4_fadein));
        subfab5.setShowAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.subfab5_fadein));
        subfab6.setShowAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.subfab6_fadein));
        subfab7.setShowAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.subfab7_fadein));
        subfab1.show();
        subfab2.show();
        subfab3.show();
        subfab4.show();
        subfab5.show();
        subfab6.show();
        subfab7.show();
    }

    private void hideAyinname(){
        ayinnameiranbtn.setVisibility(View.GONE);
        ayinnameiranbtn.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.ayinnameiran_fadeout));
        ayinnameusabtn.setVisibility(View.GONE);
        ayinnameusabtn.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.ayinnameusa_fadeout));
        toprl.animate().translationY((float) dpToPx(0)).setDuration(400).setStartDelay(200).start();
    }

    private void showAyinname(){
        toprl.animate().translationY((float) dpToPx(300)).setDuration(400).start();
        ayinnameiranbtn.setVisibility(View.VISIBLE);
        ayinnameiranbtn.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.ayinnameiran_fadein));
        ayinnameusabtn.setVisibility(View.VISIBLE);
        ayinnameusabtn.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.ayinnameusa_fadein));
        Toast.makeText(getContext(),"آیین نامه مورد نظر را انتخاب کنید",Toast.LENGTH_LONG).show();
    }

    public void hideMaghta(){
        maghtamostatily.setVisibility(View.GONE);
        maghtamostatily.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.ayinnameiran_fadeout));
        maghtatirchebolok.setVisibility(View.GONE);
        maghtatirchebolok.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.ayinnameiran_fadeout));
        maghtalshekl.setVisibility(View.GONE);
        maghtalshekl.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.ayinnameusa_fadeout));
        maghtatshekl.setVisibility(View.GONE);
        maghtatshekl.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.ayinnameusa_fadeout));
        toprl.animate().translationY((float) dpToPx(0)).setDuration(400).setStartDelay(200).start();
    }

    private void showMaghta(){
        toprl.animate().translationY((float) dpToPx(300)).setDuration(400).start();
        maghtamostatily.setVisibility(View.VISIBLE);
        maghtamostatily.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.ayinnameiran_fadein));
        maghtatirchebolok.setVisibility(View.VISIBLE);
        maghtatirchebolok.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.ayinnameiran_fadein));
        maghtalshekl.setVisibility(View.VISIBLE);
        maghtalshekl.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.ayinnameusa_fadein));
        maghtatshekl.setVisibility(View.VISIBLE);
        maghtatshekl.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.ayinnameusa_fadein));
        Toast.makeText(getContext(),"مقطع مورد نظر را انتخاب کنید",Toast.LENGTH_LONG).show();
    }

    private void hideToprl(){
        toprl.setVisibility(View.GONE);
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) arrowbtn.getLayoutParams();
        params.rightMargin = dpToPx(7);
        params.topMargin = dpToPx(3);
        arrowbtn.setLayoutParams(params);
        arrowbtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.botarrow));
        ayinnamebtn.animate().translationY((float) dpToPx(-80)).translationX((float) dpToPx(80)).rotation(0).setDuration(350).start();
        maghtabtn.animate().translationY((float) dpToPx(-80)).translationX((float) dpToPx(-80)).rotation(0).setDuration(350).start();
        arrow = 1;
    }

    private void showToprl(){
        toprl.setVisibility(View.VISIBLE);
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) arrowbtn.getLayoutParams();
        params.rightMargin = dpToPx(7);
        params.topMargin = dpToPx(160);
        arrowbtn.setLayoutParams(params);
        arrowbtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.toparrow));
        ayinnamebtn.animate().translationY((float) dpToPx(0)).translationX((float) dpToPx(0)).rotation(90).setDuration(350).start();
        maghtabtn.animate().translationY((float) dpToPx(0)).translationX((float) dpToPx(0)).rotation(-90).setDuration(350).start();
        arrow = 0;
    }

    private void AlertDialog(final String maghtaType){
        new MaterialDialog.Builder(getActivity())
                .content(R.string.sectionDetails_resetMaghta_dialog_content)
                .positiveText("تایید")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        FragmentTransaction xfragmentTransaction = MainActivity.mFragmentManager.beginTransaction();
                        xfragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();
                        MainActivity.currentTab = 1;
                        db.open();
                        db.UpdateInformation(maghtaType,1,"maghta_type");
                        db.close();
                    }
                })
                .negativeText("انصراف")
                .show();
    }

    public void Initiate(){
        //initiate elements
        wholerl = (RelativeLayout) view.findViewById(R.id.secdet_wholerl);
        arrowbtn = (Button) view.findViewById(R.id.secdet_arrowbtn);
        toprl = (RelativeLayout) view.findViewById(R.id.secdet_toprl);
        toprlimg = (ImageView) view.findViewById(R.id.secdet_imgtoprl);
        botrl = (RelativeLayout) view.findViewById(R.id.secdet_botrl);
        botscroll = (ScrollView) view.findViewById(R.id.secdet_botscroll);
        fabselectedll = (LinearLayout) view.findViewById(R.id.secdet_fabselectedrl);
        tv1 = (TextView) view.findViewById(R.id.secdet_toprltv1);
        tv2 = (TextView) view.findViewById(R.id.secdet_toprltv2);
        tv3 = (TextView) view.findViewById(R.id.secdet_toprltv3);
        tv4 = (TextView) view.findViewById(R.id.secdet_toprltv4);
        tv5 = (TextView) view.findViewById(R.id.secdet_toprltv5);
        tv6 = (TextView) view.findViewById(R.id.secdet_toprltv6);
        tv1data = (TextView) view.findViewById(R.id.secdet_toprltv1data);
        tv2data = (TextView) view.findViewById(R.id.secdet_toprltv2data);
        tv3data = (TextView) view.findViewById(R.id.secdet_toprltv3data);
        tv4data = (TextView) view.findViewById(R.id.secdet_toprltv4data);
        tv5data = (TextView) view.findViewById(R.id.secdet_toprltv5data);
        tv6data = (TextView) view.findViewById(R.id.secdet_toprltv6data);
        tvh = (TextView) view.findViewById(R.id.secdet_tvh);
        tvb = (TextView) view.findViewById(R.id.secdet_tvb);
        tvfc = (TextView) view.findViewById(R.id.secdet_tvfc);
        tvfy = (TextView) view.findViewById(R.id.secdet_tvfy);
        meth = (MaterialEditText) view.findViewById(R.id.secdet_meth);
        metb = (MaterialEditText) view.findViewById(R.id.secdet_metb);
        spdownarm = (MaterialEditText) view.findViewById(R.id.secdet_spdownarm);
        spdownarmnumber = (MaterialEditText) view.findViewById(R.id.secdet_spdownarmnumber);
        spdownarmcover = (MaterialEditText) view.findViewById(R.id.secdet_spdownarmcover);
        spuparm = (MaterialEditText) view.findViewById(R.id.secdet_spuparm);
        spuparmnumber = (MaterialEditText) view.findViewById(R.id.secdet_spuparmnumber);
        spuparmcover = (MaterialEditText) view.findViewById(R.id.secdet_spuparmcover);
        spties = (MaterialEditText) view.findViewById(R.id.secdet_spties);
        sptiesnumber = (MaterialEditText) view.findViewById(R.id.secdet_sptiesnumber);
        sptiescover = (MaterialEditText) view.findViewById(R.id.secdet_sptiescover);
        metfc = (MaterialEditText) view.findViewById(R.id.secdet_metfc);
        metfy = (MaterialEditText) view.findViewById(R.id.secdet_metfy);
        ayinnamebtn = (Button) view.findViewById(R.id.secdet_ayinnamebtn);
        maghtabtn = (Button) view.findViewById(R.id.secdet_maghtabtn);
        ayinnameiranbtn = (MorphingButton) view.findViewById(R.id.secdet_ayinnameiran);
        ayinnameusabtn = (MorphingButton) view.findViewById(R.id.secdet_ayinnameusa);
        maghtamostatily = (MorphingButton) view.findViewById(R.id.secdet_maghtamostatily);
        maghtatirchebolok = (MorphingButton) view.findViewById(R.id.secdet_maghtatirchebolok);
        maghtalshekl = (MorphingButton) view.findViewById(R.id.secdet_maghtalshekl);
        maghtatshekl = (MorphingButton) view.findViewById(R.id.secdet_maghtatshekl);
        fab = new ActionButton(getContext());
        subfab1 = new ActionButton(getContext());
        subfab2 = new ActionButton(getContext());
        subfab3 = new ActionButton(getContext());
        subfab4 = new ActionButton(getContext());
        subfab5 = new ActionButton(getContext());
        subfab6 = new ActionButton(getContext());
        subfab7 = new ActionButton(getContext());
        fab = (ActionButton) view.findViewById(R.id.secdet_fab);
        subfab1 =(ActionButton) view.findViewById(R.id.secdet_subfab1);
        subfab2 =(ActionButton) view.findViewById(R.id.secdet_subfab2);
        subfab3 =(ActionButton) view.findViewById(R.id.secdet_subfab3);
        subfab4 =(ActionButton) view.findViewById(R.id.secdet_subfab4);
        subfab5 =(ActionButton) view.findViewById(R.id.secdet_subfab5);
        subfab6 =(ActionButton) view.findViewById(R.id.secdet_subfab6);
        subfab7 =(ActionButton) view.findViewById(R.id.secdet_subfab7);
        subfab1.hide();
        subfab2.hide();
        subfab3.hide();
        subfab4.hide();
        subfab5.hide();
        subfab6.hide();
        subfab7.hide();
        //set font
        EnglishFont = Typeface.createFromAsset(getContext().getAssets(), "caviardreams.ttf");
        tv1.setTypeface(EnglishFont);
        tv2.setTypeface(EnglishFont);
        tv3.setTypeface(EnglishFont);
        tv4.setTypeface(EnglishFont);
        tv5.setTypeface(EnglishFont);
        tv6.setTypeface(EnglishFont);
        tv1data.setTypeface(EnglishFont);
        tv2data.setTypeface(EnglishFont);
        tv3data.setTypeface(EnglishFont);
        tv4data.setTypeface(EnglishFont);
        tv5data.setTypeface(EnglishFont);
        tv5data.setTypeface(EnglishFont);
        tv6data.setTypeface(EnglishFont);
        tvh.setTypeface(EnglishFont);
        tvb.setTypeface(EnglishFont);
        tvfc.setTypeface(EnglishFont);
        tvfy.setTypeface(EnglishFont);
        meth.setTypeface(EnglishFont);
        metb.setTypeface(EnglishFont);
        spdownarm.setTypeface(EnglishFont);
        spdownarmnumber.setTypeface(EnglishFont);
        spdownarmcover.setTypeface(EnglishFont);
        spuparm.setTypeface(EnglishFont);
        spuparmnumber.setTypeface(EnglishFont);
        spuparmcover.setTypeface(EnglishFont);
        spties.setTypeface(EnglishFont);
        sptiesnumber.setTypeface(EnglishFont);
        sptiescover.setTypeface(EnglishFont);
        metfc.setTypeface(EnglishFont);
        metfy.setTypeface(EnglishFont);
        //set onclick & ontouch & onfocuschange listener
        arrowbtn.setOnClickListener(this);
        meth.setOnClickListener(this);
        metb.setOnClickListener(this);
        spdownarm.setOnClickListener(this);
        spdownarmnumber.setOnClickListener(this);
        spdownarmcover.setOnClickListener(this);
        spuparm.setOnClickListener(this);
        spuparmnumber.setOnClickListener(this);
        spuparmcover.setOnClickListener(this);
        spties.setOnClickListener(this);
        sptiesnumber.setOnClickListener(this);
        sptiescover.setOnClickListener(this);
        metfc.setOnClickListener(this);
        metfy.setOnClickListener(this);
        fab.setOnClickListener(this);
        ayinnamebtn.setOnClickListener(this);
        maghtabtn.setOnClickListener(this);
        subfab1.setOnClickListener(this);
        subfab2.setOnClickListener(this);
        subfab3.setOnClickListener(this);
        subfab4.setOnClickListener(this);
        subfab5.setOnClickListener(this);
        subfab6.setOnClickListener(this);
        subfab7.setOnClickListener(this);
        ayinnameiranbtn.setOnClickListener(this);
        ayinnameusabtn.setOnClickListener(this);
        maghtamostatily.setOnClickListener(this);
        maghtatirchebolok.setOnClickListener(this);
        maghtalshekl.setOnClickListener(this);
        maghtatshekl.setOnClickListener(this);
        meth.setOnFocusChangeListener(this);
        metb.setOnFocusChangeListener(this);
        spdownarm.setOnFocusChangeListener(this);
        spdownarmnumber.setOnFocusChangeListener(this);
        spdownarmcover.setOnFocusChangeListener(this);
        spuparm.setOnFocusChangeListener(this);
        spuparmnumber.setOnFocusChangeListener(this);
        spuparmcover.setOnFocusChangeListener(this);
        spties.setOnFocusChangeListener(this);
        sptiesnumber.setOnFocusChangeListener(this);
        sptiescover.setOnFocusChangeListener(this);
        metfc.setOnFocusChangeListener(this);
        metfy.setOnFocusChangeListener(this);
        toprl.setOnTouchListener(this);
        meth.setOnTouchListener(this);
        metb.setOnTouchListener(this);
        spdownarm.setOnTouchListener(this);
        spdownarmnumber.setOnTouchListener(this);
        spdownarmcover.setOnTouchListener(this);
        spuparm.setOnTouchListener(this);
        spuparmnumber.setOnTouchListener(this);
        spuparmcover.setOnTouchListener(this);
        spties.setOnTouchListener(this);
        sptiesnumber.setOnTouchListener(this);
        sptiescover.setOnTouchListener(this);
        metfc.setOnTouchListener(this);
        metfy.setOnTouchListener(this);
    }



}