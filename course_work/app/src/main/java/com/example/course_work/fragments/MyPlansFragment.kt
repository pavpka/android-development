package com.example.course_work.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.course_work.R

class MyPlansFragment : Fragment() {
    companion object {
        fun newInstance(): MyPlansFragment {
            val myPlansFragment = MyPlansFragment()
            val bundle = Bundle()
            myPlansFragment.arguments = bundle

            return myPlansFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.plans_fragment, container, false
        )
        val textView = view.findViewById<TextView>(R.id.plans_text)
        textView.setText("хаю хай!!!")
        (activity as AppCompatActivity).supportActionBar!!.setTitle("Мои планы")
        return view
    }
}