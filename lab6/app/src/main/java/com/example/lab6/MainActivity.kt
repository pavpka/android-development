package com.example.lab6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.lab6.fragments.*
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

class MainActivity : AppCompatActivity() {
    private lateinit var drawer: Drawer
    private val home = PrimaryDrawerItem().withName("Home")
    private val firstPlaylist = PrimaryDrawerItem().withName("Playlist #1")
    private val secondPlaylist = PrimaryDrawerItem().withName("Playlist #2")
    private val thirdPlaylist = PrimaryDrawerItem().withName("Playlist #3")
    private val about = PrimaryDrawerItem().withName("About")

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
                        3 -> fragment = FirstPlaylist.newInstance()
                        4 -> fragment = SecondPlaylist.newInstance()
                        5 -> fragment = ThirdPlaylist.newInstance()
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
        selectItem()

    }

    private fun selectItem() {
        when (supportFragmentManager.findFragmentById(R.id.activity_main_frame)) {
            is HomeFragment -> drawer.setSelection(home)
            is FirstPlaylist -> drawer.setSelection(firstPlaylist)
            is SecondPlaylist -> drawer.setSelection(secondPlaylist)
            is ThirdPlaylist -> drawer.setSelection(thirdPlaylist)
            is AboutFragment -> drawer.setSelection(about)
            else -> drawer.setSelection(home)
        }
    }


}
