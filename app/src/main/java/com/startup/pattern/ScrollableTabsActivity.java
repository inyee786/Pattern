package com.startup.pattern;

/**
 * Created by Eftakhar on 29-09-2016.
 */

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import com.startup.pattern.R;
import com.startup.pattern.EightFragment;
import com.startup.pattern.FiveFragment;
import com.startup.pattern.FourFragment;
import com.startup.pattern.NineFragment;
import com.startup.pattern.OneFragment;
import com.startup.pattern.SevenFragment;
import com.startup.pattern.SixFragment;
import com.startup.pattern.TenFragment;
import com.startup.pattern.ThreeFragment;
import com.startup.pattern.TwoFragment;

public class ScrollableTabsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollable_tabs);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new OneFragment(), "PATTERN1");
        adapter.addFrag(new TwoFragment(), "PATTERN2");
        adapter.addFrag(new ThreeFragment(), "PATTERN3");
        adapter.addFrag(new FourFragment(), "PATTERN4");
        adapter.addFrag(new FiveFragment(), "PATTERN5");
        adapter.addFrag(new SixFragment(), "PATTERN6");
        adapter.addFrag(new SevenFragment(), "PATTERN7");
        adapter.addFrag(new EightFragment(), "PATTERN8");
        adapter.addFrag(new NineFragment(), "PATTERN9");
        adapter.addFrag(new TenFragment(), "PATTERN10");

        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
