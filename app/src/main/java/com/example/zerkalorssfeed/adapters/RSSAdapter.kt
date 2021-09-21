package com.example.zerkalorssfeed.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zerkalorssfeed.R
import com.example.zerkalorssfeed.databinding.ItemRssBinding
import com.example.zerkalorssfeed.pojos.Item
import com.example.zerkalorssfeed.utils.*
import com.squareup.picasso.Picasso

class RSSAdapter(private val itemList: List<Item>) :
    RecyclerView.Adapter<RSSAdapter.RSSViewHolder>() {

    var clickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onClick(item: Item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RSSViewHolder {
        val binding = ItemRssBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RSSViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RSSViewHolder, position: Int) {
        val item = itemList[position]
        with(holder.binding) {
            textViewDescription.text = item.description
            textViewAuthor.text = AuthorNameConverter().authorNamesToString(item.authorList)
            textViewCategory.text = item.category
            textViewDate.text = item.timeStamp?.timeStampToDate()
            Picasso.get().load(item.descriptionWithImage?.getSmallPhotoUrl())
                .placeholder(R.drawable.logo_250x112)
                .error(R.drawable.error_place_holder)
                .fit()
                .into(imageView)
        }
        holder.binding.root.setOnClickListener {
            clickListener?.onClick(item)
        }

    }

    override fun getItemCount() = itemList.size

    inner class RSSViewHolder(val binding: ItemRssBinding) : RecyclerView.ViewHolder(binding.root)
}