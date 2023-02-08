package com.example.test_app.ui.adapter

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.test_app.R
import com.example.test_app.base.AdapterBasePicker
import com.example.test_app.databinding.ItemLayoutBinding

import com.example.test_app.models.DataEntity
import com.example.test_app.ui.utils.DataDiffCallback
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext


class ScreenAdapter: RecyclerView.Adapter<ScreenViewHolder>() {

    private var actions : AdapterBasePicker<DataEntity>? = null
    private var list = listOf<DataEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScreenViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ScreenViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ScreenViewHolder, position: Int) {
        val item = getItem(position)
        if (!item.isChecked) {
//            holder.binding.item.setCardBackgroundColor(Color.parseColor("#5DA18A"))
            holder.binding.item.setCardBackgroundColor(
                holder.itemView.context.getColor(R.color.dark_green)
            )
        } else{
            holder.binding.item.setCardBackgroundColor(Color.parseColor("#3B6758"))
        }
        holder.binding.idRecord.text = item.id_record.toString()
        holder.binding.nomZak.text = item.nom_zak
        holder.binding.idPos.text = item.id_pos.toString()
        holder.binding.nomRoute.text = item.nom_route
        holder.binding.idHdRoute.text = item.id_hd_route.toString()
        holder.binding.nomNakl.text = item.nom_nakl
        holder.binding.selectedCheckbox.isChecked = item.isChecked


        holder.binding.item.setOnClickListener{
            actions?.onClick(item)
            Toast.makeText(holder.itemView.context, "Item's selected", Toast.LENGTH_SHORT).show()
        }

        holder.binding.item.setOnLongClickListener {
            actions?.onLongClick(item, holder.itemView)
            true
        }
    }

    override fun getItemCount(): Int = list.size

    private fun getItem(position: Int) = list[position]

    fun bindOnClick(actions: AdapterBasePicker<DataEntity>){
        this.actions = actions
    }

    fun setList(newList: List<DataEntity>){
        val result = DiffUtil.calculateDiff(DataDiffCallback(list, newList))
        result.dispatchUpdatesTo(this)
        list = newList

    }
}