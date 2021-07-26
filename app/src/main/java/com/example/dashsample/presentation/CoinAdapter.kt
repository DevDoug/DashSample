package com.example.dashsample.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.dashsample.R
import com.example.dashsample.data.CoinInfoEntity
import com.example.dashsample.presentation.entity.CoinDisplayEntity


class CoinAdapter(var infoSet: ArrayList<CoinDisplayEntity>) :
RecyclerView.Adapter<CoinAdapter.ViewHolder>()  {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val coinName: TextView = view.findViewById(R.id.coin_name)
        val price: TextView = view.findViewById(R.id.coinPrice)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.coin_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.coinName.text = infoSet[position].name
        viewHolder.price.text = infoSet[position].rate.toString()
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = infoSet.size
}