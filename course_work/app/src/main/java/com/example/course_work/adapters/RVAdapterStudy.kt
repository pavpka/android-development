package com.example.course_work.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.course_work.R
import com.example.course_work.pojo.StudyList

class RVAdapterStudy(val studyCards: List<StudyList>) :
    RecyclerView.Adapter<RVAdapterStudy.CardViewHolder>() {
    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.study_imageList)
        val studyName: TextView = itemView.findViewById(R.id.studyName)
        val studyDescription: TextView = itemView.findViewById(R.id.studyDescription)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_study, parent, false)
        return CardViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.image.setImageResource(studyCards.get(position).srcIcon)
        holder.studyName.setText(studyCards.get(position).name)
        holder.studyDescription.setText(studyCards.get(position).description)
    }

    override fun getItemCount(): Int {
        return studyCards.size
    }
}