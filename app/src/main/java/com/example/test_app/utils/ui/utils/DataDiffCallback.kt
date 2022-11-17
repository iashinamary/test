package com.example.test_app.utils.ui.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.test_app.utils.models.Data

class DataDiffCallback(
    val oldList: List<Data>,
    val newList: List<Data>
): DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldElement = oldList[oldItemPosition]
        val newElement = newList[newItemPosition]
        return oldElement.nom_zak == newElement.nom_zak
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldElement = oldList[oldItemPosition]
        val newElement = newList[newItemPosition]
        return oldElement == newElement
    }
}