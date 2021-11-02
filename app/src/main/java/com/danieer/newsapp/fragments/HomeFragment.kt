package com.danieer.newsapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.danieer.newsapp.databinding.FragmentHomeSectionBinding
import com.danieer.newsapp.views.FeedItemView
import com.xwray.groupie.GroupieAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeSectionBinding? = null
    private val binding get() = _binding!!

    private val groupieAdapter: GroupieAdapter by lazy { GroupieAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeSectionBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
    }

    private fun setupRecycler() {
        binding.newsRecyclerView.apply {
            adapter = groupieAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
        addItems()
    }

    private fun addItems(){
        groupieAdapter.addAll(listOf(FeedItemView("Noticia generica")))
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment()
    }
}