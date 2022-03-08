package com.example.activitylifecyclehomework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int mCount = 0;
    private TextView showCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showCount = (TextView) findViewById(R.id.counter);

        // Restore the saved state.
        // See onSaveInstanceState() for what gets saved.
        if (savedInstanceState != null) {
            boolean isNonZero = savedInstanceState.getBoolean("non_zero");
            if (isNonZero) {
                showCount.setText(savedInstanceState.getString("non_zero_num"));
            }
        }

    }

    public void countUp(View view){
        mCount++;
        if (showCount != null)
            showCount.setText(Integer.toString(mCount));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (mCount >= 0){
            outState.putBoolean("non_zero", true);
            outState.putString("non_zero_num", showCount.getText().toString());
        }
    }

}