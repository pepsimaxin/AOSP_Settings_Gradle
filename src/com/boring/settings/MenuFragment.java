package com.boring.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.android.settings.R;
import com.android.settings.homepage.SettingsHomepageActivity;

public class MenuFragment extends Fragment {
    private View selectedMenuItem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.boring_settings_split_menu, container, false);
        View mMenuWifi = view.findViewById(R.id.menu_wifi);
        View mMenuDisplay = view.findViewById(R.id.menu_display);
        View mMenuAbout = view.findViewById(R.id.menu_about);
        View mMenuNotifications = view.findViewById(R.id.menu_notification);

        mMenuWifi.setOnClickListener(v -> {
            onMenuItemClicked(v, R.id.menu_wifi);
        });

        mMenuDisplay.setOnClickListener(v -> {
            onMenuItemClicked(v, R.id.menu_display);
        });

        mMenuAbout.setOnClickListener(v -> {
            onMenuItemClicked(v, R.id.menu_about);

        });

        mMenuNotifications.setOnClickListener(v -> {
            onMenuItemClicked(v, R.id.menu_notification);
        });

        onMenuItemClicked(mMenuDisplay, R.id.menu_display);

        return view;
    }

    private void onMenuItemClicked(View view, int menuId) {
        if (selectedMenuItem != null) {
            selectedMenuItem.setSelected(false);
        }

        view.setSelected(true);
        selectedMenuItem = view;

        ((SettingsHomepageActivity) requireActivity()).onMenuItemSelected(menuId);
    }
}
