package com.example.lab6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.lab6.fragments.AboutFragment
import com.example.lab6.fragments.FirstPlaylist
import com.example.lab6.fragments.HomeFragment
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val accountHeader = AccountHeaderBuilder().withActivity(this)
            .addProfiles(
                ProfileDrawerItem().withName("Pitsik Julia").withEmail("pitsikj@gmail.com")
            )
            .build()
        val home = PrimaryDrawerItem().withName("Home")
        val firstPlaylist = PrimaryDrawerItem().withName("Playlist #1")
        val secondPlaylist = PrimaryDrawerItem().withName("Playlist #2")
        val thirdPlaylist = PrimaryDrawerItem().withName("Playlist #3")
        val about = PrimaryDrawerItem().withName("About")
        lateinit var drawer: Drawer


        drawer = DrawerBuilder()
            .withActivity(this)
            .withToolbar(toolbar)
            .withActionBarDrawerToggle(true)
            .withActionBarDrawerToggleAnimated(true)
            .withAccountHeader(accountHeader)
            .addDrawerItems(
                home,
                DividerDrawerItem(),
                firstPlaylist,
                secondPlaylist,
                thirdPlaylist,
                DividerDrawerItem(),
                about
            )
            .withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
                override fun onItemClick(
                    view: View?,
                    position: Int,
                    drawerItem: IDrawerItem<*>
                ): Boolean {
                    val fragment: Fragment
                    when (position) {
                        3, 4, 5 -> fragment = FirstPlaylist.newInstance()
                        7 -> fragment = AboutFragment.newInstance()
                        else -> fragment = HomeFragment.newInstance()
                    }

                    val fragmentManager = supportFragmentManager
                    fragmentManager.beginTransaction().replace(R.id.activity_main_frame, fragment)
                        .commit()

                    drawer.closeDrawer()
                    return true
                }
            })
            .build()

        val homeFragment = HomeFragment.newInstance()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.activity_main_frame, homeFragment)
            .commit()
    }
}
