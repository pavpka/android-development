package com.example.course_work.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.course_work.R
import com.example.course_work.adapters.RVAdapterContacts
import com.example.course_work.pojo.ContactList

class ContactsFragment : Fragment() {
    companion object {
        fun newInstance(): ContactsFragment {
            val contactsFragment = ContactsFragment()
            val bundle = Bundle()
            contactsFragment.arguments = bundle
            return contactsFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.contact_fragment, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.contact_recyclerView)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager
        val adapter = RVAdapterContacts(ContactList.initContactCards())
        recyclerView.adapter = adapter
        adapter.clickListener = { contactList ->
            when (contactList.name) {
                "Номер телефона" -> openApp(
                    Intent(
                        Intent.ACTION_DIAL,
                        Uri.parse("tel: ${contactList.description}")
                    )
                )
                "Телеграм" -> {
                    val telegram = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://telegram.me/juliaapav")
                    )
                    telegram.setPackage("com.telegram.android")
                    openApp(telegram)
                }

                "Инстаграм" -> {
                    val instagram = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://instagram.com/juliaapav")
                    )
                    instagram.setPackage("com.instagram.android")
                    openApp(instagram)
                }
                "Вконтакте" -> openApp(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://vk.com/juliaapav")
                    )
                )

            }
        }
        (activity as AppCompatActivity).supportActionBar!!.setTitle("Мои контакты")

        return view
    }

    private fun openApp(intent: Intent) {
        if (isIntentSafe(intent)) {
            startActivity(intent)
        } else {
            Toast.makeText(
                activity?.applicationContext,
                "Your phone have no app",
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    private fun isIntentSafe(intent: Intent): Boolean {
        val packageManager = activity!!.packageManager
        val activities = packageManager!!.queryIntentActivities(intent, 0)
        return activities.size > 0
    }
}