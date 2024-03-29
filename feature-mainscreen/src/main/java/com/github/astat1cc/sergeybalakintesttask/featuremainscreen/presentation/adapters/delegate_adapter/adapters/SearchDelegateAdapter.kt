package com.github.astat1cc.sergeybalakintesttask.featuremainscreen.presentation.adapters.delegate_adapter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.databinding.DelegateItemSearchBinding
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.presentation.adapters.delegate_adapter.DelegateAdapter
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.presentation.adapters.delegate_adapter.items.SearchDelegateItem

class SearchDelegateAdapter:
    DelegateAdapter<SearchDelegateItem, SearchDelegateAdapter.SearchViewHolder>(SearchDelegateItem::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DelegateItemSearchBinding.inflate(inflater, parent, false)
        return SearchViewHolder(binding)
    }

    override fun bindViewHolder(model: SearchDelegateItem, viewHolder: SearchViewHolder) {}

    inner class SearchViewHolder(
        val binding: DelegateItemSearchBinding
    ) : RecyclerView.ViewHolder(binding.root)
}

