package com.example.shoppinglistchallange;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    public static final int TEXT_REQUEST = 1;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            for (int index = 1; index <=10; index++) {
                String textViewName = "item_list" + index;
                int id =getResources().getIdentifier(textViewName,"id",getPackageName());
                TextView textView = (TextView) findViewById(id);
                    textView.setText(savedInstanceState.getString("list_value" + index));
            }
        }
    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String itemName =  data.getStringExtra(SecondActivity.EXTRA_REPLY);
                for (int index = 1; index <=10; index++) {
                    String textViewName = "item_list" + index;
                    int id =getResources().getIdentifier(textViewName,"id",getPackageName());
                    TextView textView = (TextView) findViewById(id);
                    if (textView.getText() == "") {
                        textView.setText(textView.getText() + itemName.toUpperCase(Locale.ROOT));
                        break;
                    }
                }
            }
        }
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        for (int index = 1; index <=10; index++) {
            String textViewName = "item_list" + index;
            int id =getResources().getIdentifier(textViewName,"id",getPackageName());
            TextView textView = (TextView) findViewById(id);
                outState.putString("list_value" + index, textView.getText().toString());
        }
    }
}
