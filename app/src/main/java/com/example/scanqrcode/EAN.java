package com.example.scanqrcode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class   EAN extends AppCompatActivity {
    TextView view;
    Button button;

    ClipboardManager clipboardManager;
    TextClock txtClock;
    ListView listView;
    Context context;
    ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("EAN");
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.primay_icon)));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Log.e("LOG", "q");
//        listView = findViewById(R.id.listView);
//        arrayList = new ArrayList<String>();
//        Log.e("LOG", "q1");
//        arrayList.add("Android");
//        arrayList.add("Android");
//        arrayList.add("Android");
//        arrayList.add("Android");
//        arrayList.add("Android");
//        Log.e("LOG", "q2");
//        ArrayAdapter<String> adapter = new ArrayAdapter(EAN.this, android.R.layout.simple_list_item_1, arrayList);
//        Log.e("LOG", "q3");
//        listView.setAdapter(adapter);
//        Log.e("LOG", "q4");

        setContentView(R.layout.activity_ean_scan);
        view = findViewById(R.id.txtResult);
        button = findViewById(R.id.button);
        txtClock = findViewById(R.id.txtClock);
        String formatdate = "dd/MM/yyyy HH:mm";
        txtClock.setFormat24Hour(formatdate);

        Intent intent = getIntent();
        String noidung = intent.getStringExtra("linksp");
        view.setText(noidung);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(noidung));
                startActivity(intent);
            }
        });
        Copy();
    }
    public  void doCopy(){
        this.clipboardManager= (ClipboardManager) this.getSystemService(Context.CLIPBOARD_SERVICE);
        Intent intent = getIntent();
        String copy = intent.getStringExtra("linksp");
        ClipData clipData = ClipData.newPlainText("copy",copy);
        clipboardManager.setPrimaryClip(clipData);
        Toast.makeText(this,"COPY INTO CLIPBOARD"+copy,Toast.LENGTH_SHORT).show();
    }
    public void Copy(){
        SharedPreferences sharedPreferences = getSharedPreferences("copyintoclipboard",0);
        boolean check = sharedPreferences.getBoolean("copyintoclipboard",false);
        if(check==true){
            doCopy();
        }

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
}