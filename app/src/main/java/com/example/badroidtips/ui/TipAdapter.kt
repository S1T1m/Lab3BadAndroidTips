package com.example.badroidtips.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.badroidtips.R
import com.example.badroidtips.data.Tip
import com.google.android.material.card.MaterialCardView

class TipAdapter(
    private val items: List<Tip>,
    private val onClick: (Tip) -> Unit
) : RecyclerView.Adapter<TipAdapter.TipViewHolder>() {

    class TipViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rootCard: MaterialCardView = itemView.findViewById(R.id.tipCard)
        val img: ImageView = itemView.findViewById(R.id.tipImage)
        val day: TextView = itemView.findViewById(R.id.tipDay)
        val title: TextView = itemView.findViewById(R.id.tipTitle)
        val short: TextView = itemView.findViewById(R.id.tipShort)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_tip, parent, false)
        return TipViewHolder(v)
    }

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        val tip = items[position]
        val context = holder.itemView.context

        holder.img.setImageResource(tip.imageRes)
        holder.day.text = context.getString(R.string.day_format, tip.day)
        holder.title.text = context.getString(tip.titleRes)
        holder.short.text = context.getString(tip.shortTextRes)

        holder.rootCard.setOnClickListener { onClick(tip) }
    }

    override fun getItemCount(): Int = items.size
}