package com.example.ameghana.eventplanner;


import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.FragmentStatePagerAdapter;

import it.neokree.materialtabs.MaterialTab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;


import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;


import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {


    TabLayout tabHost;
    ViewPager viewPager;
    ViewPagerAdapter androidAdapter;
    Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //android toolbar
        toolBar = (android.support.v7.widget.Toolbar) this.findViewById(R.id.toolBar);
        this.setSupportActionBar(toolBar);

        //tab host
        tabHost = (TabLayout) this.findViewById(R.id.tabHost);
        viewPager = (ViewPager) this.findViewById(R.id.viewPager);

        //adapter view
        tabHost.addTab(tabHost.newTab().setText("LogIn"));
        tabHost.addTab(tabHost.newTab().setText("SignUp"));
        tabHost.setTabGravity(tabHost.GRAVITY_FILL);
        androidAdapter = new ViewPagerAdapter(getSupportFragmentManager(), tabHost.getTabCount());
        viewPager.setAdapter(androidAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabHost));
        tabHost.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    //When login button is clicked
    public void login(View view){
        EditText a = (EditText)findViewById(R.id.textInputEditTextEmail);
        String str = a.getText().toString();
        Intent intent = new Intent(MainActivity.this,NavigationDrawer.class);
        intent.putExtra("Username",str);
        startActivity(intent);
    }

    //When SignUp button is clicked
    public void signup(View view) {
        Intent intent = new Intent(this, NavigationDrawer.class);
        startActivity(intent);
    }
}

// view pager adapter
class ViewPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public ViewPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                SigninFragment tab1 = new SigninFragment();
                return tab1;
            case 1:
                Signup tab2 = new Signup();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}


