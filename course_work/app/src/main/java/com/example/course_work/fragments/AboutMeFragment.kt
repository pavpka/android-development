package com.example.course_work.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.course_work.R

class AboutMeFragment : Fragment() {
    companion object {
        fun newInstance(): AboutMeFragment {
            val aboutMeFragment = AboutMeFragment()
            val bundle = Bundle()
            aboutMeFragment.arguments = bundle

            return aboutMeFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.about_me_fragment, container, false
        )
        val textView = view.findViewById<TextView>(R.id.about_text)
        textView.setText("хаю хай!!!")
        (activity as AppCompatActivity).supportActionBar!!.setTitle("Обо мне")
        return view
    }
}