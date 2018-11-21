package demo.com.dashboard.impl.presentation.adapter.renderer

import demo.com.dashboard.R
import demo.com.dashboard.impl.domain.model.DashboardEntryModel
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