package com.example.course_work.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.course_work.R
import com.example.course_work.adapters.RVAdapterStudy
import com.example.course_work.data.StudyList

class MyStudyFragment : Fragment() {
    companion object {
        fun newInstance(): MyStudyFragment {
            val myStudyFragment = MyStudyFragment()
            val bundle = Bundle()
            myStudyFragment.arguments = bundle

            return myStudyFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.study_fragment, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.study_recyclerView)
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(activity, 1)
        recyclerView.layoutManager = layoutManager
        val adapter = RVAdapterStudy(StudyList.initStudyCards())
        recyclerView.adapter = adapter
        (activity as AppCompatActivity).supportActionBar!!.setTitle("Моя учеба/работа")

        return view
    }
}