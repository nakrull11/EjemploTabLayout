package com.example.ejemplotablayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ClienteFragment.OnFragmentInteractionListener {

    private ViewPager viewPager;
    private AppBarLayout appBarLayout;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        appBarLayout = findViewById(R.id.appbar);

        tabLayout = new TabLayout(this);

        appBarLayout.addView(tabLayout);

        ViewPageAdapter vpa = new ViewPageAdapter(getSupportFragmentManager());
        vpa.addFragment(new ClienteFragment(),"Cliente1");
        vpa.addFragment(new ClienteFragment(),"Cliente2");

        viewPager.setAdapter(vpa);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public class ViewPageAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragmentList = new ArrayList<>();
        private List<String> titulosFragments = new ArrayList<>();

        public ViewPageAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titulosFragments.get(position);
        }

        public void addFragment(Fragment fragment, String titulo){
            fragmentList.add(fragment);
            titulosFragments.add(titulo);
        }
    }
}
