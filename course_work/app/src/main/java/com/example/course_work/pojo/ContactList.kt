package com.example.course_work.pojo

import com.example.course_work.R

data class ContactList(val srcIcon: Int, val name: String, val description: String) {

    companion object {
        fun initContactCards(): List<ContactList> {
            val cards = arrayListOf<ContactList>()
            cards.add(
                ContactList(
                    R.drawable.phone,
                    "Номер телефона",
                    "123456789"
                )
            )
            cards.add(
                ContactList(
                    R.drawable.telegram,
                    "Телеграм",
                    "@juliaapav"
                )
            )
            cards.add(
                ContactList(
                    R.drawable.vk,
                    "Вконтакте",
                    "@juliaapav"
                )
            )
            cards.add(
                ContactList(
                    R.drawable.instagram,
                    "Инстаграм",
                    "@juiaapav"
                )
            )
            return cards
        }
    }
}