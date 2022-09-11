package com.farhanryanda.challangechapter3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.farhanryanda.challangechapter3.databinding.FragmentLetterBinding


class LetterFragment : Fragment() {

    private var _binding: FragmentLetterBinding? = null
    private val binding get() = _binding!!

    private lateinit var letterList : ArrayList<Letter>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLetterBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        letterList = arrayListOf(
            Letter("A"),
            Letter("B"),
            Letter("C"),
            Letter("D"),
            Letter("E"),
            Letter("F"),
            Letter("G"),
            Letter("H"),
            Letter("I"),
            Letter("J"),
            )
        binding.rvWords.setHasFixedSize(true)
        var lm = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        binding.rvWords.layoutManager = lm
        binding.rvWords.adapter = LetterAdapter(letterList)
    }

}