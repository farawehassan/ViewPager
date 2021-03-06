package com.example.hassan.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final List<Product> products = DataProvider.productList;
    private final int numPages = products.size();

    private ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPager = findViewById(R.id.pager);
        PagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);
    }

    private class ViewPagerAdapter extends FragmentStatePagerAdapter{

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ItemFragment.newInstance(products.get(position));
        }

        @Override
        public int getCount() {
            return numPages;
        }
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            super.onBackPressed();
        }else {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }
}
