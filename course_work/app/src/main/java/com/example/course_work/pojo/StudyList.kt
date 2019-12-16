package com.example.course_work.pojo

import com.example.course_work.R

data class StudyList(val srcIcon: Int, val name: String, val description: String) {

    companion object {
        fun initStudyCards(): List<StudyList> {
            val cards = arrayListOf<StudyList>()
            cards.add(
                StudyList(
                    R.drawable.school,
                    "Школа №7 г. Ноябрьск",
                    "..."
                )
            )
            cards.add(
                StudyList(
                    R.drawable.music_school,
                    "Музыкальная школа №2 г. Ноябрьск",
                    "..."
                )
            )
            cards.add(
                StudyList(
                    R.drawable.itmo_1,
                    "Университет ИТМО г. Санкт-Петербург",
                    "..."
                )
            )

            return cards
        }
    }
}