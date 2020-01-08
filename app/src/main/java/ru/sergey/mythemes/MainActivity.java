package ru.sergey.mythemes;

import androidx.appcompat.app.AppCompatActivity;
import ru.sergey.mythemes.ThemeWrapper;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    //Theme
    private final BroadcastReceiver mThemeReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (SettingsActivity.class.equals(MainActivity.this.getClass())){
                finish();
                startActivity(getIntent());
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            } else recreate();
        }
    };

//    SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
//    String themeName = pref.getString("pref" , "Theme");

    @Override
    protected void onCreate(Bundle savedInstanceState) {


     /*   if (themeName.equals("Mint")){
            setTheme(R.style.Theme_App_Mint);
        }
        else if (themeName.equals("Lilac")){
            setTheme(R.style.Theme_App_Lilac);
        }*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_settings) {
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}