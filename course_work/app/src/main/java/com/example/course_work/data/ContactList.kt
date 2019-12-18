package com.example.course_work.data

import com.example.course_work.R

data class ContactList(val srcIcon: Int, val name: String, val description: String) {

    companion object {
        fun initContactCards(): List<ContactList> {
            val cards = arrayListOf<ContactList>()
            cards.add(
                ContactList(
                    R.drawable.mail,
                    "Почта",
                    "pitsikj@gmail.com"
                )
            )
            cards.add(
                ContactList(
                    R.drawable.telegram,
                    "Telegram",
                    "@juliaapav"
                )
            )
            cards.add(
                ContactList(
                    R.drawable.github,
                    "GitHub",
                    "@pavpka"
                )
            )
            cards.add(
                ContactList(
                    R.drawable.instagram,
                    "Instagram",
                    "@juiaapav"
                )
            )
            return cards
        }
    }
}