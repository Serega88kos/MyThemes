package ru.sergey.mythemes;

import android.app.Activity;

import java.util.Objects;

public abstract class ThemeWrapper {
    public enum Theme {
        MINT,
        LILAC
    }

    public static void applyTheme(Activity ctx) {
        int theme;
        switch (Theme.values()[getThemeIndex()]) {
            case MINT:
                theme = R.style.Theme_App_Mint;
                break;
            case LILAC:
                theme = R.style.Theme_App_Lilac;
                break;
            default:
                theme = R.style.Theme_App_Mint;
                break;
        }
        ctx.setTheme(theme);
    }

    private static int getThemeIndex() {
        return Integer.parseInt(Objects.requireNonNull(App.getInstance().getPreferences().getString("ui.theme", String.valueOf(Theme.MINT.ordinal()))));
    }
}