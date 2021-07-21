package com.jacob.amazonproject.presentation.core.callBack

interface OnItemClickListener<T> {

    fun onItemClick(item: T, type: String? = null)
}