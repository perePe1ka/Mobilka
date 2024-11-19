package com.example.firstlab

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CharacterAdapter(private val characters: List<Character>) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nameTextView: TextView = view.findViewById(R.id.nameTextView)
        private val cultureTextView: TextView = view.findViewById(R.id.cultureTextView)
        private val bornTextView: TextView = view.findViewById(R.id.bornTextView)
        private val titlesTextView: TextView = view.findViewById(R.id.titlesTextView)
        private val aliasesTextView: TextView = view.findViewById(R.id.aliasesTextView)
        private val playedByTextView: TextView = view.findViewById(R.id.playedByTextView)

        fun bind(character: Character) {
            nameTextView.text = "Name: ${character.name}"
            cultureTextView.text = "Culture: ${character.culture}"
            bornTextView.text = "Born: ${character.born}"
            titlesTextView.text = "Titles: ${character.titles.joinToString(", ")}"
            aliasesTextView.text = "Aliases: ${character.aliases.joinToString(", ")}"
            playedByTextView.text = "Played by: ${character.playedBy.joinToString(", ")}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characters[position])
    }

    override fun getItemCount(): Int = characters.size
}


