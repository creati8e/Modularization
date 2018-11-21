package com.demo.dashboard.presentation.adapter.renderer

import com.demo.dashboard.R
import com.demo.dashboard.domain.model.DashboardEntryModel
import kotlinx.android.synthetic.main.list_item_dashboard_entry.*
import serg.chuprin.adapter.Click
import serg.chuprin.adapter.ContainerHolder
import serg.chuprin.adapter.ContainerRenderer
import serg.chuprin.adapter.LongClick

/**
 * @author Sergey Chuprin
 */
class DashboardEntryRenderer : ContainerRenderer<DashboardEntryModel>() {

    override val type: Int = R.layout.list_item_dashboard_entry

    override fun bindView(holder: ContainerHolder, model: DashboardEntryModel) {
        holder.textView.text = model.name
    }

    override fun onVhCreated(
        holder: ContainerHolder,
        clickListener: Click?,
        longClickListener: LongClick?
    ) {
        holder.itemView.setOnClickListener { clickListener?.onClick(it, holder.adapterPosition) }
    }

}