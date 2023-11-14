/*
 * Created by Nethaji V on 01/02/22, 10:23 AM
 * Copyright (c) reserved here at Joel
 * Last modified by Nethaji V on 01/02/22, 10:23 AM
 */

package com.thalappakatti.captain.ui.connexion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thalappakatti.captain.R

class StoreAdapter() : RecyclerView.Adapter<StoreAdapter.PreferredLocationHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreferredLocationHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_stores, parent, false)
        return PreferredLocationHolder(itemView)
    }

    override fun onBindViewHolder(holder: PreferredLocationHolder, position: Int) {
        holder.bindUI(position)
    }

    override fun getItemCount() = 0

    inner class PreferredLocationHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindUI(position: Int) {
            itemView.setOnClickListener { v: View? ->

            }
        }
    }

}