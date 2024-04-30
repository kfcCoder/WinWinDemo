package com.example.hsiehdemo0401.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.hsiehdemo0401.R
import com.example.hsiehdemo0401.databinding.CellModelBinding
import com.example.hsiehdemo0401.databinding.CellTagBinding
import com.example.hsiehdemo0401.ui.model.Item
import com.example.hsiehdemo0401.ui.model.Model

class TagAdapter : RecyclerView.Adapter<TagAdapter.ModelViewHolder>() {


    /* collection of adapter */
    var list = listOf<String>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    inner class ModelViewHolder(val binding: CellTagBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(str: String) {
            binding.tvTag.text = str
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        return ModelViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.cell_tag, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size


}