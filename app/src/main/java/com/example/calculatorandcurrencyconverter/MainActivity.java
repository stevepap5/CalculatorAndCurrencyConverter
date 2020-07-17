package com.example.calculatorandcurrencyconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ArrayList<Fragment> fragmentArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpMethod();
    }

    private void setUpMethod() {


        viewPager = (ViewPager) findViewById(R.id.pager);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        fragmentArrayList = new ArrayList<>();
        Fragment converterFragment = new ConverterFragment();
        fragmentArrayList.add(converterFragment);
        Fragment calculatorFragment = new CalculatorFragment();
        fragmentArrayList.add(calculatorFragment);


        FragmentAdapter pagerAdapter = new FragmentAdapter(getSupportFragmentManager(),
                getApplicationContext(), fragmentArrayList);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("Converter");
        tabLayout.getTabAt(1).setText("Calculator");
    }
}
