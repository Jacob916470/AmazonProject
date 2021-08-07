package com.jacob.amazonproject.presentation.products.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jacob.amazonproject.R
import com.jacob.amazonproject.data.network.models.Result
import com.jacob.amazonproject.data.utils.Configurations
import com.jacob.amazonproject.presentation.core.callBack.OnItemClickListener
import com.jacob.amazonproject.presentation.products.model.DataProducts

class ProductsAdapter(
    private val productsList: List<Result>,
    private val onItemClickListener: OnItemClickListener<Result>
) : RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {


    /** Creamos la vista del item que mostraremos en el reclycerView */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_products,parent,false)
        return ProductsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val product = productsList[position]
        Glide
            .with(holder.view.context)
            .load(Configurations.IMAGE_BASE_URL.plus(product.posterPath))
            .into(holder.image)
        holder.nameProducts.text = product.title
        //product.ratingB?.toFloat()?.let { holder.ratingBar?.rating = it }
        holder.ratingBar?.rating = product.voteAverage?.toFloat()?:0f
        holder.priceProducts.text = product.releaseDate
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