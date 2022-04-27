package com.example.scanqrcode.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreference;

import com.example.scanqrcode.Feedback;
import com.example.scanqrcode.Main_introduction;
import com.example.scanqrcode.R;

import java.util.Locale;

public class Settings extends PreferenceFragmentCompat {
    static Locale locale_language;
    SwitchPreference sw_ligth, sw_sound, sw_vibrate, sw_copy;
    Preference pre_language, pre_introduction,pre_feedback;
    SharedPreferences share_ligth, share_copy,share_language, share_beep, share_vibrate;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preference, rootKey);
        inutUI();
        chooseDarktheme();
        chooseLanguage();
        chooseSound();
        chooseVibrate();
        chooseIntroduction();
        chooseCopy();
        chooseFeedback();
    }

    void inutUI() {
        sw_ligth = findPreference("v");
        sw_sound = findPreference("sound");
        sw_copy = findPreference("copy");
        sw_vibrate = findPreference("vi");
        pre_language = findPreference("language");
        pre_introduction = findPreference("introduc");
        pre_feedback = findPreference("feedback");
    }

    //Settings Introduction
    private void chooseIntroduction() {
        pre_introduction.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(@NonNull Preference preference) {
                Intent intent = new Intent(getContext(), Main_introduction.class);
                startActivity(intent);
                return false;
            }
        });
    }

    //Settings Copy into Clipboard
    public void chooseCopy(){

        share_copy = getActivity().getSharedPreferences("copyintoclipboard",0);

        sw_copy.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(@NonNull Preference preference, Object newValue) {
               if(sw_copy.isChecked())
               {
                   SharedPreferences.Editor editor = share_copy.edit();
                   editor.putBoolean("copyintoclipboard",false);
                   editor.commit();
               }
               else
               {
                   SharedPreferences.Editor editor = share_copy.edit();
                   editor.putBoolean("copyintoclipboard",true);
                   editor.commit();
               }
                return true;
            }
        });

    }

    //Setting Sound : Beep
    public  void chooseSound(){

        share_beep = getActivity().getSharedPreferences("beep",0);

        sw_sound.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
           @Override
           public boolean onPreferenceChange(@NonNull Preference preference, Object newValue) {
               if (sw_sound.isChecked())
               {
                   SharedPreferences.Editor editor = share_beep.edit();
                   editor.putBoolean("beep",false);
                   editor.commit();
               }
               else
               {
                   SharedPreferences.Editor editor = share_beep.edit();
                   editor.putBoolean("beep",true);
                   editor.commit();
               }
               return true;
           }
       });
    }

    //Settings Vibrate
    public void chooseVibrate(){
        share_vibrate = getActivity().getSharedPreferences("vibrate",0);

        sw_vibrate.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(@NonNull Preference preference, Object newValue) {
                if(sw_vibrate.isChecked())
                {
                    SharedPreferences.Editor editor = share_vibrate.edit();
                    editor.putBoolean("vibrate",false);
                    editor.commit();
                }
                else
                {
                    SharedPreferences.Editor editor = share_vibrate.edit();
                    editor.putBoolean("vibrate",true);
                    editor.commit();
                }
                return true;
            }
        });
    }

    //Settings Dark Theme
    void chooseDarktheme() {
        share_ligth = getActivity().getSharedPreferences("nigth",0);

        sw_ligth.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                if (sw_ligth.isChecked())
                {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    SharedPreferences.Editor editor = share_ligth.edit();
                    editor.putBoolean("nigth",false);
                    editor.commit();
                }
                else
                {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    SharedPreferences.Editor editor = share_ligth.edit();
                    editor.putBoolean("nigth",true);
                    editor.commit();
                }
                return true;
            }
        });
    }

    //Settings Language
    public void chooseLanguage(){
        share_language = getActivity().getSharedPreferences("language1",0);

        pre_language.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Language");
                final String [] listlanguage={"English","VietNam"};
                int check  = share_language.getInt("language1",1);

                builder.setSingleChoiceItems(listlanguage, check, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(i==1)
                        {
                            locale_language = new Locale("vi","VN");
                            SharedPreferences.Editor editor = share_language.edit();
                            editor.putInt("language1",1);
                            editor.commit();
                        }
                        else
                        {
                            locale_language = new Locale("en","US");
                            SharedPreferences.Editor editor = share_language.edit();
                            editor.putInt("language1",0);
                            editor.commit();
                        }

                       ChangeLanguage(locale_language);

                    }
                });

                AlertDialog alert = builder.create();
                builder.show();
                return true;
            }
        });

    }
    //Set change language
    public void ChangeLanguage(Locale locale) {
        Resources resources = getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = new Configuration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
            configuration.setLocale(locale);
        else
            configuration.setLocale(locale);

        resources.updateConfiguration(configuration, displayMetrics);
        Intent intent = new Intent(getContext(),getContext().getClass());
        startActivity(intent);
        getActivity().finish();

    }
    //Settings: Feedback
    public void chooseFeedback(){

            pre_feedback.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(@NonNull Preference preference) {
                    Intent intent = new Intent(getContext(), Feedback.class);
                    startActivity(intent);
                    return false;
                }
            });
    }

}
