package com.example.course_work.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.course_work.R
import com.example.course_work.data.ContactList

class RVAdapterContacts(
    val contactCards: List<ContactList>,
    var clickListener: ((ContactList) -> Unit)? = null
) :
    RecyclerView.Adapter<RVAdapterContacts.CardViewHolder>() {

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.contact_image_list)
        val contactName: TextView = itemView.findViewById(R.id.contact_name)
        val contactDescription: TextView = itemView.findViewById(R.id.contact_description)

        init {
            itemView.setOnClickListener {
                clickListener?.invoke(contactCards[adapterPosition])
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_contacts, parent, false)
        return CardViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.image.setImageResource(contactCards.get(position).srcIcon)
        holder.contactName.setText(contactCards.get(position).name)
        holder.contactDescription.setText(contactCards.get(position).description)

    }

    override fun getItemCount(): Int {
        return contactCards.size
    }
}