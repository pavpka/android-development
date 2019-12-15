package com.example.course_work

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.course_work.fragments.AboutMeFragment
import com.mikepenz.google_material_typeface_library.GoogleMaterial
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
                ProfileDrawerItem().withName("Пицик Юлия").withEmail("pitsikj@gmail.com")
            )
            .build()
        val aboutMe = PrimaryDrawerItem().withName("Обо мне").withIcon(GoogleMaterial.Icon.gmd_person_pin)
        val myStudy = PrimaryDrawerItem().withName("Моя учеба/работа").withIcon(GoogleMaterial.Icon.gmd_business_center)
        val myDegreeWork = PrimaryDrawerItem().withName("Моя дипломная работа").withIcon(GoogleMaterial.Icon.gmd_description)
        val myPlans = PrimaryDrawerItem().withName("Мои планы").withIcon(GoogleMaterial.Icon.gmd_watch_later)
        val contacts = PrimaryDrawerItem().withName("Контакты").withIcon(GoogleMaterial.Icon.gmd_mail)
        lateinit var drawer: Drawer


        drawer = DrawerBuilder()
            .withActivity(this)
            .withToolbar(toolbar)
            .withActionBarDrawerToggle(true)
            .withActionBarDrawerToggleAnimated(true)
            .withAccountHeader(accountHeader)
            .addDrawerItems(
                aboutMe,
                DividerDrawerItem(),
                myStudy,
                myDegreeWork,
                myPlans,
                DividerDrawerItem(),
                contacts
            )
            .withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
                override fun onItemClick(
                    view: View?,
                    position: Int,
                    drawerItem: IDrawerItem<*>
                ): Boolean {
                    val fragment: Fragment = when (position) {
                        /*
                        3, 4, 5 -> FirstPlaylist.newInstance()
                        7 -> AboutFragment.newInstance()

                         */
                        else -> AboutMeFragment.newInstance()
                    }

                    val fragmentManager = supportFragmentManager
                    fragmentManager.beginTransaction().replace(R.id.activity_main_frame, fragment)
                        .commit()

                    drawer.closeDrawer()
                    return true
                }
            })
            .build()

        val homeFragment = AboutMeFragment.newInstance()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.activity_main_frame, homeFragment)
            .commit()
    }
}
