package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.databinding.HeroesRowLayoutBinding
import com.example.myapplication.model.Characters

class HeroesAdapter : RecyclerView.Adapter<HeroesAdapter.MyViewHolder>() {

    private lateinit var binding : HeroesRowLayoutBinding

    private val diffCallback = object : DiffUtil.ItemCallback<Characters>(){
        override fun areItemsTheSame(oldItem: Characters, newItem: Characters): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Characters, newItem: Characters): Boolean {
                return  oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, diffCallback)




    inner class MyViewHolder(itemView : View)  : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.heroes_row_layout,
                parent,
                false)
        )

    }

    override fun getItemCount(): Int {
        return differ.currentList.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val heroe = differ.currentList[position]

        holder.itemView.apply {
            Glide.with(this).load(heroe.thumbnail).into((R.id.img_heroe) as ImageView)
            binding.tvName.text = heroe.name
            setOnItemClickListener {
                onItemClickListener?.let { it(heroe) }
                }
            }

        }

    }

    private var onItemClickListener: ((Characters)->Unit)? = null

    fun setOnItemClickListener(listener: (Characters) -> Unit){
        onItemClickListener= listener

    }






