package com.example.course_work.data

import com.example.course_work.R

data class StudyList(val srcIcon: Int, val name: String, val description: Int) {

    companion object {
        fun initStudyCards(): List<StudyList> {
            val cards = arrayListOf<StudyList>()
            cards.add(
                StudyList(
                    R.drawable.school,
                    "Школа №7 г. Ноябрьск",
                    R.string.school
                )
            )
            cards.add(
                StudyList(
                    R.drawable.music_school,
                    "Музыкальная школа №2 г. Ноябрьск",
                    R.string.music_school
                )
            )
            cards.add(
                StudyList(
                    R.drawable.itmo_1,
                    "Университет ИТМО г. Санкт-Петербург",
                    R.string.itmo
                )
            )
            return cards
        }
    }
}