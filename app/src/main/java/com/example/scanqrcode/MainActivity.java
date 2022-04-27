package com.example.scanqrcode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.SwitchPreference;
import androidx.viewpager2.widget.ViewPager2;


import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;

import com.example.scanqrcode.fragment.ScanViewAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView navigation;
    ViewPager2 viewPager;
    SwitchPreference vlaunguae;
    SharedPreferences preference_language;
    ScanViewAdapter scanViewAdapter;
    static Locale language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        getWindow()

       // getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide(); //hide the title bar
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        setContentView(R.layout.activity_main);//
        AnhXa();
        SetupViewPager2();
        EventButtonNavigation();

        Item_language();
        Item_dark();

    }

    private void SetupViewPager2() {
        scanViewAdapter = new ScanViewAdapter(this);
        viewPager.setAdapter(scanViewAdapter);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 1:
                        navigation.getMenu().findItem(R.id.navigation_create).setChecked(true);
                        break;
                    case 2:
                        navigation.getMenu().findItem(R.id.navigation_memory).setChecked(true);
                        break;
                    case 3:
                        navigation.getMenu().findItem(R.id.navigation_setting).setChecked(true);
                        break;
                    default:
                        navigation.getMenu().findItem(R.id.navigation_scan).setChecked(true);
                        break;
                }
            }
        });
    }

    private void EventButtonNavigation() {
        navigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_create:
                    viewPager.setCurrentItem(1);
                    break;

                case R.id.navigation_scan:
                    viewPager.setCurrentItem(0);
                    break;

                case R.id.navigation_memory:
                    viewPager.setCurrentItem(2);
                    break;

                case R.id.navigation_setting:
                    viewPager.setCurrentItem(3);
                    break;
            }
            return true;
        });
    }

    public  void Item_dark(){
        SharedPreferences sharedPreferences;
        sharedPreferences = getSharedPreferences("nigth",0);
        boolean booleancheck = sharedPreferences.getBoolean("nigth",false);
        if(booleancheck==true){
            //setTheme(R.style.darkTheme);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            //Item_language();
            //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else{
            //setTheme(R.style.AppTheme);
            //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
           // Item_language();
        }
    }
    private void AnhXa() {
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        viewPager = findViewById(R.id.viewPager);
    }

    public void Item_language(){
        SharedPreferences sharedPreferences;
        sharedPreferences = getSharedPreferences("language1",0);
        int check = sharedPreferences.getInt("language1",1);
        if(check==1){
            language = new Locale("vi","VN");//ChangeLanguage(language);
        }
        else {
            language = new Locale("en","US");
        }
        ChangeLanguage(language);
    }
    public void ChangeLanguage(Locale locale) {
        Resources resources = this.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = new Configuration(resources.getConfiguration());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
            configuration.setLocale(locale);
        else
            configuration.setLocale(locale);

        resources.updateConfiguration(configuration, displayMetrics);

    }
}