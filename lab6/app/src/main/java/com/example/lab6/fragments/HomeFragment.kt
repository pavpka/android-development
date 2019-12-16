package com.example.lab6.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.lab6.R


class HomeFragment : Fragment() {
    companion object {
        fun newInstance(): HomeFragment {
            val homeFragment = HomeFragment()
            val bundle = Bundle()
            homeFragment.arguments = bundle

            return homeFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_home, container, false
        )
        val textView = view.findViewById<TextView>(R.id.home_text)
        textView.setText("Home")
//        (activity as AppCompatActivity).supportActionBar!!.setTitle("Home")
        return view
    }
}