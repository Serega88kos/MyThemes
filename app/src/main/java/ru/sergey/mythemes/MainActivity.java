package ru.sergey.mythemes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

 //       RadioGroup radioGroup;
        SharedPreferences pref = getSharedPreferences("theme", MODE_PRIVATE);
        String theme = pref.getString("theme", "");
      //  final String mint = pref.getString("theme", "mint");
      //  final String lilac = pref.getString("theme", "lilac");
        RadioButton rb1 = findViewById(R.id.RBmint);
        RadioButton rb2 = findViewById(R.id.RBlilac);

        super.onCreate(savedInstanceState);

        if (theme.equals("mint")) {
            setTheme(R.style.Theme_App_Mint);
//           rb1.setChecked(true);
            Log.d(TAG, "Mint");
        } else if (theme.equals("lilac")) {
            setTheme(R.style.Theme_App_Lilac);
 //           rb2.setChecked(true);
            Log.d(TAG, "Lilac");
        } else  {
            setTheme(R.style.Theme_App_Mint);
            Log.d(TAG, "Default");
        }

        setContentView(R.layout.activity_main);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
//        final RadioButton RBmint = findViewById(R.id.RBmint);
//        final RadioButton RBlilac = findViewById(R.id.RBlilac);

//        int id = radioGroup.getCheckedRadioButtonId();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId ) {
                RadioButton radioButton = group.findViewById(checkedId);
                boolean isChecked = radioButton.isChecked();


                switch (checkedId){

                    case R.id.RBmint:
                        if (isChecked)
                        setTheme(R.style.Theme_App_Mint);
                        saveMint();
                        Log.d(TAG, "Mint");
                        break;
                    case R.id.RBlilac:
                        if (isChecked)
                        setTheme(R.style.Theme_App_Lilac);
                        saveLilac();
                        Log.d(TAG, "Lilac");
                        break;
                    default:
                        break;

}
            }
            void saveMint(){
                SharedPreferences pref = getSharedPreferences("theme",MODE_PRIVATE);
                SharedPreferences.Editor ed = pref.edit();
                ed.putString("theme", "mint");
                ed.apply();
                Log.d(TAG, "Mint save");
            }
            void saveLilac(){
                SharedPreferences pref = getSharedPreferences("theme",MODE_PRIVATE);
                SharedPreferences.Editor ed = pref.edit();
                ed.putString("theme", "lilac");
                ed.apply();
                Log.d(TAG, "Lilac save");
            }
        });
    }/*
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case -1:
                Log.d(TAG, "Choices cleared!");
                break;
            case R.id.RBmint:
                if (checked)
                    Log.d(TAG, "Mint checked");
                break;
            case R.id.RBlilac:
                if (checked)
                    Log.d(TAG, "Lilac checked");
                break;
                default:
                    Log.d(TAG, "Default");
                    break;
        }
    }*/
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        Log.d(TAG, "onCreateOptionsMenu");
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            Log.d(TAG, "onOptionsItemSelected");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/


}