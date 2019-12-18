package com.example.lab6.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.lab6.R


class AboutFragment : Fragment() {
    companion object {
        fun newInstance(): AboutFragment {
            val aboutFragment = AboutFragment()
            val bundle = Bundle()
            aboutFragment.arguments = bundle

            return aboutFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_about, container, false
        )
        val textView = view.findViewById<TextView>(R.id.about_text)
        textView.setText("About")
        (activity as AppCompatActivity).supportActionBar!!.setTitle("About")
        return view
    }
}