package com.crypto.cryptocrunch.base.recyclerview

import androidx.recyclerview.widget.DiffUtil

class BaseDiffItemCallback<T : BaseItem> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.itemId == newItem.itemId
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.toString() == newItem.toString()
    }
}
