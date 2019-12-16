package com.example.course_work

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.course_work.fragments.*
import com.example.course_work.pojo.ContactList
import com.mikepenz.google_material_typeface_library.GoogleMaterial
import com.mikepenz.iconics.typeface.library.fontawesome.FontAwesome
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
                ProfileDrawerItem().withName("Пицик Юлия").withEmail("pitsikj@gmail.com").withIcon(R.drawable.duck)
            )
            .build()

        val aboutMe = PrimaryDrawerItem().withName("Обо мне").withIcon(FontAwesome.Icon.faw_user_circle1)
        val myStudy = PrimaryDrawerItem().withName("Моя учеба/работа").withIcon(FontAwesome.Icon.faw_graduation_cap)
        val myDegreeWork = PrimaryDrawerItem().withName("Моя дипломная работа").withIcon(FontAwesome.Icon.faw_book)
        val myPlans = PrimaryDrawerItem().withName("Мои планы").withIcon(FontAwesome.Icon.faw_chart_line)
        val contacts = PrimaryDrawerItem().withName("Контакты").withIcon(FontAwesome.Icon.faw_paper_plane1)
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
                        3 -> MyStudyFragment.newInstance()
                        4 -> MyDegreeWorkFragment.newInstance()
                        5 -> MyPlansFragment.newInstance()
                        7 -> ContactsFragment.newInstance()
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
