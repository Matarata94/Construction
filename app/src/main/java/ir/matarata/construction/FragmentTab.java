package ir.matarata.construction;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Matarata on 5/24/2016.
 */
public class FragmentTab extends Fragment {

    public static TabLayout tabLayout;
    public static CustomViewPager viewPager;
    public static int int_items = 4;
    public int position,pos;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /**
         *Inflate tab_layout and setup Views.
         */
        View x =  inflater.inflate(R.layout.tab_layout,null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        viewPager = (CustomViewPager) x.findViewById(R.id.viewpager);
        database db = new database(getContext());
        db.open();
        tabLayout.setBackgroundColor(Color.parseColor(db.QuerySetting(1,1)));
        //tabLayout.setVisibility(View.GONE);
        //viewPager.setPagingEnabled(false);

        db.close();

        /**
         *Set an Apater for the View Pager
         */
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        /**
         * Now , this is a workaround ,
         * The setupWithViewPager dose't works without the runnable .
         * Maybe a Support Library Bug .
         */

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
                tabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager) {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        position = tab.getPosition();
                        if(position == 0){
                            tabLayout.setVisibility(View.GONE);
                            selectPage(0);
                            viewPager.setPagingEnabled(false);
                        }else if(position == 1){
                            tabLayout.setVisibility(View.VISIBLE);
                            selectPage(1);
                            viewPager.setPagingEnabled(true);
                        }else if(position == 2){
                            tabLayout.setVisibility(View.VISIBLE);
                            selectPage(2);
                            viewPager.setPagingEnabled(true);
                        }else if(position == 3){
                            tabLayout.setVisibility(View.VISIBLE);
                            selectPage(3);
                            viewPager.setPagingEnabled(true);
                        }
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {

                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {

                    }
                });
            }
        });

        return x;

    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */

        @Override
        public Fragment getItem(int position)
        {
            switch (position){
                case 0 : return new FragmentAction();
                case 1 : return new FragmentSectionDetails();
                case 2 : return new FragmentSummaryCalc();
                case 3 : return new FragmentTinyCalc();
            }
            return null;
        }

        @Override
        public int getCount() {
            return int_items;
        }

        /**
         * This method returns the title of the tab according to the position.
         */

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0 :
                    return "عملکرد";
                case 1 :
                    return "مشخصات مقطع";
                case 2 :
                    return "خلاصه محاسبات";
                case 3 :
                    return "ریز محاسبات";
            }
            return null;
        }
    }

    public void selectPage(int pageIndex){
        tabLayout.setScrollPosition(pageIndex,0f,true);
        viewPager.setCurrentItem(pageIndex);
    }


}
