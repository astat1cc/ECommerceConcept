package com.github.astat1cc.sergeybalakintesttask.viewpager

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.github.astat1cc.sergeybalakintesttask.databinding.ItemHotSaleBinding

class HotSalesViewPagerAdapter(
    private val hotSales: List<HotSalesViewPagerItem>
) : RecyclerView.Adapter<HotSalesViewPagerAdapter.HotSaleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotSaleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHotSaleBinding.inflate(inflater, parent, false)
        return HotSaleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HotSaleViewHolder, position: Int) {
        val item = hotSales[position]
        with(holder.binding) {
            Glide.with(hotSaleImageView).load(item.picture).into(hotSaleImageView)
            titleHotSaleTextView.text = item.title
            subtitleTextView.text = item.subtitle
            newTagContainer.visibility = if (item.is_new) View.VISIBLE else View.INVISIBLE
        }
    }

    override fun getItemCount(): Int = hotSales.size

    inner class HotSaleViewHolder(val binding: ItemHotSaleBinding) :
        RecyclerView.ViewHolder(binding.root)
}