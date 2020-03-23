package com.example.wtest009_intents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnImplicitIntentGoogleClick(View view) {
        Uri uri = Uri.parse("http://google.com");
        Intent it = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(it);
    }

    public void btnImplicitIntentGoogleClick2(View view) {
        Uri uri = Uri.parse("http://google.com");
        Intent it = new Intent(Intent.ACTION_VIEW);
        it.setData(uri);
        startActivity(it);
    }


    public void btnImplicitIntentDialClick(View view) {
        Uri uri = Uri.parse("tel:+298 292578");
        Intent it = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(it);
    }

    public void btnImplicitIntentExtraClick(View view) {
        Intent it = new Intent(Intent.ACTION_WEB_SEARCH);
        String query = "KT-verkfrøði";
        it.putExtra(SearchManager.QUERY,query);
        if (it.resolveActivity(getPackageManager())!=null) {
            startActivity(it);
        }
    }

    public void btnSendImplicitIntentClick(View view) {
        Intent it = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        it.setType("application/pdf"); // Set MIME type
        it.addCategory(Intent.CATEGORY_OPENABLE);
        (Toast.makeText(this,"btnSendImplicitIntentClick: Button pressed.",Toast.LENGTH_SHORT)).show();
        if (it.resolveActivity(getPackageManager())!=null) {
            (Toast.makeText(this,"btnSendImplicitIntentClick: getPackageManager:True",Toast.LENGTH_SHORT)).show();
            int customRequestCode = 42;
            startActivityForResult(it,customRequestCode);
        }
        else {(Toast.makeText(this,"btnSendImplicitIntentClick: getPackageManager:False",Toast.LENGTH_SHORT)).show();}
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        (Toast.makeText(this,String.format("onActivityResult::\nRequestCode:%d\nResult: %d\nData:%s",requestCode,resultCode,data),Toast.LENGTH_LONG)).show();
    }

    public void sendMessage(View view) {
        // Do something in response to button click
    }
}
