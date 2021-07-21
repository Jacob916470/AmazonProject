package com.jacob.amazonproject.presentation.products.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.jacob.amazonproject.R
import com.jacob.amazonproject.presentation.core.callBack.OnItemClickListener
import com.jacob.amazonproject.presentation.products.model.DataProducts

class ProductsAdapter(
    private val productsList: List<DataProducts>,
    private val onItemClickListener: OnItemClickListener<DataProducts>
) : RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {


    /** Creamos la vista del item que mostraremos en el reclycerView */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_products,parent,false)
        return ProductsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val product = productsList[position]
        product.img?.let { holder.image?.setImageResource(it) }
        holder.nameProducts.text = product.name
        //product.ratingB?.toFloat()?.let { holder.ratingBar?.rating = it }
        holder.ratingBar?.rating = product.ratingB?.toFloat()?:0f
        holder.priceProducts.text = product.price
        holder.container.setOnClickListener {
            onItemClickListener.onItemClick(product)
        }
    }

    override fun getItemCount() = productsList.size

    class ProductsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<AppCompatImageView>(R.id.productosImageView)
        val nameProducts = view.findViewById<TextView>(R.id.txtName)
        val ratingBar = view.findViewById<RatingBar>(R.id.rbProducts)
        val priceProducts = view.findViewById<TextView>(R.id.txtPrice)
        val container = view.findViewById<ConstraintLayout>(R.id.container)
    }
}