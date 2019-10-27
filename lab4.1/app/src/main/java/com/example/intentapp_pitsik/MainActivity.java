package com.example.intentapp_pitsik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListeners();
    }


    private void setListeners() {
        final Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 123456789"));
        final Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=59.939961, 30.314681 (Hermitage Museum)"));
        final Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/"));
        final Intent mailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"))
                .putExtra(Intent.EXTRA_EMAIL, new String[]{"pitsikj@gmail.com"})
                .putExtra(Intent.EXTRA_SUBJECT, "Test lab")
                .putExtra(Intent.EXTRA_TEXT, "Lab is working!");

        Button callButton = findViewById(R.id.button_call);
        Button mapButton = findViewById(R.id.button_map);
        Button webButton = findViewById(R.id.button_web);
        Button mailButton = findViewById(R.id.button_mail);

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isIntentSafe(callIntent)) {
                    startActivity(callIntent);
                } else {
                    Toast.makeText(getApplicationContext(), "Your phone have no app can dial", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isIntentSafe(mapIntent)) {
                    startActivity(mapIntent);
                } else {
                    Toast.makeText(getApplicationContext(), "Your phone have no app can open map", Toast.LENGTH_SHORT).show();
                }
            }
        });

        webButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isIntentSafe(webIntent)) {
                    startActivity(webIntent);
                } else {
                    Toast.makeText(getApplicationContext(), "Your phone have no app can show web page", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isIntentSafe(mailIntent)) {
                    startActivity(mailIntent);
                } else {
                    Toast.makeText(getApplicationContext(), "Your phone have no app can send email", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean isIntentSafe(Intent intent) {
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
        return activities.size() > 0;
    }
}
