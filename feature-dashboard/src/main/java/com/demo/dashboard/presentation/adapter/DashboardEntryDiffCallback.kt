package com.demo.dashboard.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.demo.dashboard.domain.model.DashboardEntryModel

/**
 * @author Sergey Chuprin
 */
class DashboardEntryDiffCallback : DiffUtil.ItemCallback<DashboardEntryModel>() {

    override fun areContentsTheSame(
        oldItem: DashboardEntryModel,
        newItem: DashboardEntryModel
    ): Boolean {
        return true
    }

    override fun areItemsTheSame(
        oldItem: DashboardEntryModel,
        newItem: DashboardEntryModel
    ): Boolean {
        return oldItem.name == newItem.name
    }

}