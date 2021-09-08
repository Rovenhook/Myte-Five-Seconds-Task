package com.rovenhook.mytefivesecondstask

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.rovenhook.mytefivesecondstask.databinding.NumberItemBinding

class NumberAdapter(val numberListenter: NumberListenter) : ListAdapter<String, NumberViewHolder>(itemComparator) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = NumberItemBinding.inflate(layoutInflater)
        return NumberViewHolder(numberListenter, binding)
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private companion object {

        private val itemComparator = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

 //           override fun getChangePayload(oldItem: Int, newItem: Int) = Any()
        }
    }
}