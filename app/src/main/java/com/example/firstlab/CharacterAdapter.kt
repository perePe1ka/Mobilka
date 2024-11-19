package com.example.firstlab

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstlab.databinding.ItemCharacterBinding

class CharacterAdapter(private val characters: List<Character>) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(character: Character) {
            with(binding) {
                nameTextView.text = "Name: ${character.name}"
                cultureTextView.text = "Culture: ${character.culture}"
                bornTextView.text = "Born: ${character.born}"
                titlesTextView.text = "Titles: ${character.titles.joinToString(", ")}"
                aliasesTextView.text = "Aliases: ${character.aliases.joinToString(", ")}"
                playedByTextView.text = "Played by: ${character.playedBy.joinToString(", ")}"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemCharacterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characters[position])
    }

    override fun getItemCount(): Int = characters.size
}
