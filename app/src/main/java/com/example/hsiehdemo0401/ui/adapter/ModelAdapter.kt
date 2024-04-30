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
import com.example.hsiehdemo0401.ui.model.Item
import com.example.hsiehdemo0401.ui.model.Model

class ModelAdapter : RecyclerView.Adapter<ModelAdapter.ModelViewHolder>() {


    /* collection of adapter */
    var list = listOf<Item>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    inner class ModelViewHolder(val binding: CellModelBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {
            Glide.with(binding.ivAvatar)
                .load(item.user.imageUrl)
                //.circleCrop()
                //.centerCrop()
                .transform(CenterCrop(), CircleCrop())
                .into(binding.ivAvatar)

            binding.tvName.text = item.user.nickName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        return ModelViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.cell_model, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size


}