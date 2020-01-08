package ru.sergey.mythemes;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import java.util.Objects;

public class SettingsActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);

            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_container, new SettingsFragment())
                    .commit();
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


}