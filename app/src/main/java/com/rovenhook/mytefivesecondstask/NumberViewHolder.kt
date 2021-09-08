package com.rovenhook.mytefivesecondstask

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.rovenhook.mytefivesecondstask.databinding.NumberItemBinding

class NumberViewHolder(
    private val numberListenter: NumberListenter,
    private val binding: NumberItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(num: String) {
        binding.textView.text = num

        binding.button.setOnClickListener {
            numberListenter.delete(num)
        }
    }
}