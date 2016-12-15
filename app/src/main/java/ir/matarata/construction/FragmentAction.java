package ir.matarata.construction;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Matarata on 5/24/2016.
 */
public class FragmentAction extends Fragment{

    private View view,view2;
    private Toolbar toolbar;
    TextView firstrl_tv,firstrl_tv2,secondrl_tv,secondrl_tv2,thirdrl_tv,thirdrl_tv2;
    RelativeLayout firstrl,secondrl,thirdrl;
    View firstrl_view,secondrl_view,thirdrl_view;
    private int view1Change=0,view2Change=0,view3Change=0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.action_fragment,container,false);
        if(FragmentSectionDetails.maghtaChanged != 0){
            FragmentTab tf = new FragmentTab();
            tf.selectPage(1);
            FragmentSectionDetails.maghtaChanged = 0;
        }
        defines();


        firstrl_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(view1Change == 0){
                    ViewGroup.LayoutParams params = firstrl_view.getLayoutParams();
                    params.height = 160;
                    firstrl_view.requestLayout();
                    firstrl_view.setBackgroundColor(Color.parseColor("#70757575"));
                    firstrl_tv2.setVisibility(View.VISIBLE);
                    view1Change = 1;
                }else if(view1Change == 1){
                    ViewGroup.LayoutParams params = firstrl_view.getLayoutParams();
                    params.height = 80;
                    firstrl_view.requestLayout();
                    firstrl_view.setBackgroundColor(Color.parseColor("#709e9e9e"));
                    firstrl_tv2.setVisibility(View.GONE);
                    view1Change = 0;
                }
            }
        });
        firstrl_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(view1Change == 0){
                    ViewGroup.LayoutParams params = firstrl_view.getLayoutParams();
                    params.height = 160;
                    firstrl_view.requestLayout();
                    firstrl_view.setBackgroundColor(Color.parseColor("#70757575"));
                    firstrl_tv2.setVisibility(View.VISIBLE);
                    view1Change = 1;
                }else if(view1Change == 1){
                    ViewGroup.LayoutParams params = firstrl_view.getLayoutParams();
                    params.height = 80;
                    firstrl_view.requestLayout();
                    firstrl_view.setBackgroundColor(Color.parseColor("#709e9e9e"));
                    firstrl_tv2.setVisibility(View.GONE);
                    view1Change = 0;
                }
            }
        });
        secondrl_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(view2Change == 0){
                    ViewGroup.LayoutParams params = secondrl_view.getLayoutParams();
                    params.height = 160;
                    secondrl_view.requestLayout();
                    secondrl_view.setBackgroundColor(Color.parseColor("#70757575"));
                    secondrl_tv2.setVisibility(View.VISIBLE);
                    view2Change = 1;
                }else if(view2Change == 1){
                    ViewGroup.LayoutParams params = secondrl_view.getLayoutParams();
                    params.height = 80;
                    secondrl_view.requestLayout();
                    secondrl_view.setBackgroundColor(Color.parseColor("#709e9e9e"));
                    secondrl_tv2.setVisibility(View.GONE);
                    view2Change = 0;
                }
            }
        });
        secondrl_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(view2Change == 0){
                    ViewGroup.LayoutParams params = secondrl_view.getLayoutParams();
                    params.height = 160;
                    secondrl_view.requestLayout();
                    secondrl_view.setBackgroundColor(Color.parseColor("#70757575"));
                    secondrl_tv2.setVisibility(View.VISIBLE);
                    view2Change = 1;
                }else if(view2Change == 1){
                    ViewGroup.LayoutParams params = secondrl_view.getLayoutParams();
                    params.height = 80;
                    secondrl_view.requestLayout();
                    secondrl_view.setBackgroundColor(Color.parseColor("#709e9e9e"));
                    secondrl_tv2.setVisibility(View.GONE);
                    view2Change = 0;
                }
            }
        });
        thirdrl_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(view3Change == 0){
                    ViewGroup.LayoutParams params = thirdrl_view.getLayoutParams();
                    params.height = 160;
                    thirdrl_view.requestLayout();
                    thirdrl_view.setBackgroundColor(Color.parseColor("#70757575"));
                    thirdrl_tv2.setVisibility(View.VISIBLE);
                    view3Change = 1;
                }else if(view3Change == 1){
                    ViewGroup.LayoutParams params = thirdrl_view.getLayoutParams();
                    params.height = 80;
                    thirdrl_view.requestLayout();
                    thirdrl_view.setBackgroundColor(Color.parseColor("#709e9e9e"));
                    thirdrl_tv2.setVisibility(View.GONE);
                    view3Change = 0;
                }
            }
        });
        thirdrl_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(view3Change == 0){
                    ViewGroup.LayoutParams params = thirdrl_view.getLayoutParams();
                    params.height = 160;
                    thirdrl_view.requestLayout();
                    thirdrl_view.setBackgroundColor(Color.parseColor("#70757575"));
                    thirdrl_tv2.setVisibility(View.VISIBLE);
                    view3Change = 1;
                }else if(view3Change == 1){
                    ViewGroup.LayoutParams params = thirdrl_view.getLayoutParams();
                    params.height = 80;
                    thirdrl_view.requestLayout();
                    thirdrl_view.setBackgroundColor(Color.parseColor("#709e9e9e"));
                    thirdrl_tv2.setVisibility(View.GONE);
                    view3Change = 0;
                }
            }
        });
        firstrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction mFragmentTransaction = ActivityMain.mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.containerView, new FragmentTab()).commit();
            }
        });

        return view;
    }

    private void defines(){
        firstrl_tv = (TextView) view.findViewById(R.id.am_firstrl_tv);
        firstrl_tv2 = (TextView) view.findViewById(R.id.am_firstrl_tv2);
        secondrl_tv = (TextView) view.findViewById(R.id.am_secondrl_tv);
        secondrl_tv2 = (TextView) view.findViewById(R.id.am_secondrl_tv2);
        thirdrl_tv = (TextView) view.findViewById(R.id.am_thirdrl_tv);
        thirdrl_tv2 = (TextView) view.findViewById(R.id.am_thirdrl_tv2);
        firstrl_view = view.findViewById(R.id.am_firstrl_view);
        secondrl_view = view.findViewById(R.id.am_secondrl_view);
        thirdrl_view = view.findViewById(R.id.am_thirdrl_view);
        firstrl = (RelativeLayout) view.findViewById(R.id.am_rl_first);
        secondrl = (RelativeLayout) view.findViewById(R.id.am_rl_second);
        thirdrl = (RelativeLayout) view.findViewById(R.id.am_rl_third);
        Typeface type = Typeface.createFromAsset(getContext().getAssets(), "BFARNAZ.TTF");
        firstrl_tv.setTypeface(type);
        firstrl_tv2.setTypeface(type);
        secondrl_tv.setTypeface(type);
        secondrl_tv2.setTypeface(type);
        thirdrl_tv.setTypeface(type);
        thirdrl_tv2.setTypeface(type);
    }

}