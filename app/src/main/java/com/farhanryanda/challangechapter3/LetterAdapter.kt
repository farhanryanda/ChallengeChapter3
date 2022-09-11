package com.farhanryanda.challangechapter3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class LetterAdapter(private val letterList: ArrayList<Letter>): RecyclerView.Adapter<LetterAdapter.ViewHolder>() {


    class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        var btnLetter = view.findViewById<Button>(R.id.btn_word)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.cv_word,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = letterList.get(position).letter
        holder.btnLetter.text = item

        holder.btnLetter.setOnClickListener {
            val wordFragment = WordFragment()
            val bundle = Bundle()
            bundle.putSerializable("letter",Letter(item))
            wordFragment.arguments = bundle
            var activity : AppCompatActivity = holder.view.context as AppCompatActivity
            activity.supportFragmentManager.beginTransaction().replace(R.id.fc_main,wordFragment)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun getItemCount(): Int {
        return letterList.size
    }
}