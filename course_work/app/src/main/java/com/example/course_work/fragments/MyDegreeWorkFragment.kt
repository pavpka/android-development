package com.example.course_work.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.course_work.R

class MyDegreeWorkFragment : Fragment() {
    companion object {
        fun newInstance(): MyDegreeWorkFragment {
            val myDegreeFragment = MyDegreeWorkFragment()
            val bundle = Bundle()
            myDegreeFragment.arguments = bundle

            return myDegreeFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.degree_fragment, container, false
        )
        val textView = view.findViewById<TextView>(R.id.degree_text)
        textView.setText("хаю хай!!!")
        (activity as AppCompatActivity).supportActionBar!!.setTitle("Моя дипломная работа")
        return view
    }
}