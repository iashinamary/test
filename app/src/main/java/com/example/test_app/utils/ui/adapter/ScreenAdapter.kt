package com.example.test_app.utils.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.test_app.databinding.ItemLayoutBinding
import com.example.test_app.utils.models.Data
import com.example.test_app.utils.ui.utils.DataDiffCallback

class ScreenAdapter: RecyclerView.Adapter<ScreenViewHolder>() {

    private var list = listOf<Data>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScreenViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ScreenViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ScreenViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.idRecord.text = item.id_record.toString()
        holder.binding.nomZak.text = item.nom_zak
        holder.binding.idPos.text = item.id_pos.toString()
        holder.binding.nomRoute.text = item.nom_route
        holder.binding.idHdRoute.text = item.id_hd_route.toString()
        holder.binding.nomNakl.text = item.nom_nakl
    }

    override fun getItemCount(): Int = list.size

    private fun getItem(position: Int) = list[position]

    fun setList(newList: List<Data>){
        val result = DiffUtil.calculateDiff(DataDiffCallback(list, newList))
        result.dispatchUpdatesTo(this)
        list = newList

    }
}