package com.crypto.cryptocrunch.base.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BaseListAdapter<T : BaseItem>(
    private val variableId: Int,
    diffCallback: DiffUtil.ItemCallback<T> = BaseDiffItemCallback()
) : ListAdapter<T, BaseViewHolder<T>>(diffCallback) {

    abstract fun getItemViewTypeByItem(item: T): Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, viewType, parent, false)
        return BaseViewHolder(binding, variableId)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        return holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return getItemViewTypeByItem(getItem(position))
    }
}