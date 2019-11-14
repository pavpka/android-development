package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


import android.os.Bundle;

import android.view.View;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;

import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;

import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private Drawer drawer = null;
    private static String LAST_FRAGMENT_TAG;
    LinkedList<String> backStack = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        PrimaryDrawerItem home = new PrimaryDrawerItem().withName("Home");
        PrimaryDrawerItem profile = new PrimaryDrawerItem().withName("Profile");
        PrimaryDrawerItem contacts = new PrimaryDrawerItem().withName("Contacts");
        PrimaryDrawerItem gallery = new PrimaryDrawerItem().withName("Gallery");
        PrimaryDrawerItem messages = new PrimaryDrawerItem().withName("Messages");
        PrimaryDrawerItem setting = new PrimaryDrawerItem().withName("Setting");

        drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withActionBarDrawerToggle(true)
                .withActionBarDrawerToggleAnimated(true)
                .addDrawerItems(
                        home,
                        new DividerDrawerItem(),
                        profile,
                        contacts,
                        gallery,
                        messages,
                        new DividerDrawerItem(),
                        setting
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        Fragment fragment;

                        switch (position) {
                            case 2:
                                fragment = ProfileFragment.newInstance();
                                LAST_FRAGMENT_TAG = "profile";
                                break;
                            case 3:
                                fragment = ContactsFragment.newInstance();
                                LAST_FRAGMENT_TAG = "contacts";
                                break;
                            case 4:
                                fragment = GalleryFragment.newInstance();
                                LAST_FRAGMENT_TAG = "gallery";
                                break;
                            case 5:
                                fragment = MessagesFragment.newInstance("Messages");
                                LAST_FRAGMENT_TAG = "messages";
                                break;
                            case 7:
                                fragment = SettingFragment.newInstance("Setting");
                                LAST_FRAGMENT_TAG = "setting";
                                break;
                            default:
                                fragment = HomeFragment.newInstance("Home");
                                LAST_FRAGMENT_TAG = "home";
                                break;
                        }

                        FragmentManager fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().addToBackStack(LAST_FRAGMENT_TAG).replace(R.id.activity_main_frame, fragment, LAST_FRAGMENT_TAG).commit();
                        backStack.push(LAST_FRAGMENT_TAG);

                        drawer.closeDrawer();
                        return true;
                    }
                })
                .build();

        HomeFragment homeFragment = HomeFragment.newInstance("Home");
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.activity_main_frame, homeFragment, "home")
                .commit();
        backStack.push("home");
    }

    @Override
    public void onBackPressed() {
        backStack.pop();
        if (drawer.isDrawerOpen()) {
            drawer.closeDrawer();
        } else if (backStack.size() > 0) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            Fragment fragment = fragmentManager.findFragmentByTag(backStack.pop());
            if (fragment instanceof HomeFragment) {
                drawer.setSelectionAtPosition(0);
            } else if (fragment instanceof ProfileFragment) {
                drawer.setSelectionAtPosition(2);
            } else if (fragment instanceof ContactsFragment) {
                drawer.setSelectionAtPosition(3);
            } else if (fragment instanceof GalleryFragment) {
                drawer.setSelectionAtPosition(4);
            } else if (fragment instanceof MessagesFragment) {
                drawer.setSelectionAtPosition(5);
            } else if (fragment instanceof SettingFragment) {
                drawer.setSelectionAtPosition(7);
            }
        } else {
            this.finish();
        }
    }
}
