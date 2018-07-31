package com.gmail.muskankataria2408.financialcalculator;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.Map;

public class CategoryAdapter extends FragmentPagerAdapter {


    private Context mContext;
    private Map<Integer,String> mFragmentTags;
    private FragmentManager mFragmentManager;
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
        mFragmentTags = new HashMap<Integer,String>();


    }
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new InputFragment();
        } else if (position == 1) {
            return new RateFragment();
        } else{
            return new SIPVsFDFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_input);
        } else if (position == 1) {
            return mContext.getString(R.string.category_rate);
        }  else {
            return mContext.getString(R.string.category_fd);
        }
    }
    @Override
    public int getCount() {
        return 3;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object obj = super.instantiateItem(container, position);
        if (obj instanceof Fragment) {
            // record the fragment tag here.
            Fragment f = (Fragment) obj;
            String tag = f.getTag();
            mFragmentTags.put(position, tag);
        }
        return obj;
    }
    public Fragment getFragment(int position) {
        String tag = mFragmentTags.get(position);
        if (tag == null)
            return null;
        return mFragmentManager.findFragmentByTag(tag);
    }

}
