package com.example.scanqrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {
    RatingBar ratingBar;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        ratingBar = findViewById(R.id.rating);
        editText = findViewById(R.id.ed_feedback);
        button = findViewById(R.id.btn_feedback);
        submitFeedback();
    }
    public void submitFeedback(){
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String feedback ;
                    feedback = editText.getText().toString();
                    String finalFeedback = editText.getText().toString();

                    if(finalFeedback.equals(""))
                    {
                        Toast.makeText(Feedback.this,"Sent your feedback. Thanhyou!!",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else
                    {
                        Intent intent =new Intent(Intent.ACTION_SEND);
                        intent.setType("message/html");
                        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"hothianhduong16112002@gmail.com"});
                        intent.putExtra(Intent.EXTRA_SUBJECT,"Feedback's customer");
                        intent.putExtra(Intent.EXTRA_TEXT,"Dear ScanCode 2022, \nI think "+ feedback);

                        try {
                            startActivity(Intent.createChooser(intent, "Send feedback..."));
                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(getApplicationContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                        }

                        finish();

                    }
                }
            });
        }
}