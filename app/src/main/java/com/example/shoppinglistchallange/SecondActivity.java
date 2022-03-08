package com.example.shoppinglistchallange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    private static final String LOG_TAG = SecondActivity.class.getSimpleName();
    public static final String EXTRA_REPLY =
            "com.example.shoppinglistchallange.extra.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
    public void addItem(View view){
        String itemName = ((Button)view).getText().toString();
        Intent intent = new Intent();
        intent.putExtra(EXTRA_REPLY, itemName);
        setResult(RESULT_OK, intent);
        Log.d(LOG_TAG, "End SecondActivity");
        finish();
    }
}