package com.example.scanqrcode.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreference;

import com.example.scanqrcode.R;

import java.util.Locale;

public class Fragment_Setting extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    //@Override
//    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
//
//    }
//        static Locale language;
//        SwitchPreference sw_ligth, sw_sound, sw_vibrate, sw_copy;
//        Preference vlaunguae, introcduct;
//        SharedPreferences sharedPreferences,preference_language;
//        @Override
//        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
//            setPreferencesFromResource(R.xml.root_preference, rootKey);
//            inutUI();
//            //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);sáng
//            Ligth();
//            //Languageitem();
//        }
//        void inutUI() {
//            sw_ligth = findPreference("v");
//            sw_sound = findPreference("sound");
//            sw_copy = findPreference("copy");
//            sw_vibrate = findPreference("vi");
//            vlaunguae = findPreference("language");
//            introcduct = findPreference("introduc");
//        }
//        void Ligth() {
//            sharedPreferences = getActivity().getSharedPreferences("nigth",0);
//            boolean booleancheck = sharedPreferences.getBoolean("nigth",true);
////            if(booleancheck==false){
////                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
////            }else{
////                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
////            }
//            sw_ligth.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
//                @Override
//                public boolean onPreferenceChange(Preference preference, Object newValue) {
//                    if (sw_ligth.isChecked()){
//                       // AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//                        SharedPreferences.Editor editor = sharedPreferences.edit();
//                        sw_ligth.setChecked(false);
//                        editor.putBoolean("nigth",false);
//                        editor.commit();
//                    } else {
//                       // AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//                        sw_ligth.setChecked(true);
//                        SharedPreferences.Editor editor = sharedPreferences.edit();
//                        editor.putBoolean("nigth",true);
//                        editor.commit();
//                    }
//                    return false;
//                }
//            });
//        }
//        public void Languageitem(){
//            preference_language = getActivity().getSharedPreferences("language1",0);
//            int check  = preference_language.getInt("language1",1);
////            if(check==0){
////                language = new Locale("en","US");
////            }
////            else if(check==1){
////                language = new Locale("vi","VN");
////            }
//            vlaunguae.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
//                @Override
//                public boolean onPreferenceClick(Preference preference) {
//                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//                    builder.setTitle("Language");
//                    final String [] listlanguage={"English","VietNam"};
////                    final Set<String> selec = new HashSet<String>();
////                    selec.add(listlanguage[0]);
//                    builder.setSingleChoiceItems(listlanguage, check, new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            if(i==0)
//                            {
//                                language = new Locale("en","US");
//                                SharedPreferences.Editor editor = preference_language.edit();
//                                editor.putInt("language1",0);
//                                editor.commit();
//                            }
//                            else{
//                                language = new Locale("vi","VN");
//                                SharedPreferences.Editor editor = preference_language.edit();
//                                editor.putInt("language1",1);
//                                editor.commit();
//                            }
//                            ChangeLanguage(language);
//                        }
//                    });
//
//                    AlertDialog alert = builder.create();
//                    builder.show();
//                    return false;
//                }
//            });
//
//        }
//
//
//        public void ChangeLanguage(Locale locale) {
//            Resources resources = getResources();
//            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
//            Configuration configuration = new Configuration();
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
//                configuration.setLocale(locale);
//            else
//                configuration.setLocale(locale);
//
//            resources.updateConfiguration(configuration, displayMetrics);
//            Intent refresh = new Intent(getActivity(), getActivity().getClass());
//            startActivity(refresh);
//
//        }

    }



