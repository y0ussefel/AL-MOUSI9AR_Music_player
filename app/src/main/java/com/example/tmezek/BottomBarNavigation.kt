package com.example.tmezek

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding
import com.example.tmezek.databinding.BottomBarNavigationBinding


class BottomBarNavigation@JvmOverloads constructor(
    context : Context,
    attributeSet : AttributeSet? = null,
    defStyleAttr: Int = 1
) : FrameLayout(context,attributeSet,defStyleAttr){
    private  val binding = BottomBarNavigationBinding.inflate(LayoutInflater.from(context),this,true)

    private var selectedIndex =0
    var onItemSelected: ((Int) -> Unit)? = null

    private  val items by lazy{
        listOf(binding.item1,binding.item2,binding.item3,binding.item4,binding.item5)
    }

    init {
        initClickListeners()
        updateUi()
    }
    private fun initClickListeners() = with(binding){
        items.forEachIndexed { index, item ->
            item.setOnClickListener{
                onItemClick(index)
                onItemSelected?.invoke(index)
            }
        }
    }

    private fun onItemClick(index:Int){
        this.selectedIndex = index
        updateUi()
    }

    private fun Int.upTo():Int {
        val scale = resources.displayMetrics.density
        return( this * scale).toInt()
    }

    private fun updateUi(){
        items.forEachIndexed { index, imageView ->
            if (index == selectedIndex){
                imageView.setColorFilter(ContextCompat.getColor(context,R.color.textColor))
                imageView.setPadding(12.upTo())
            }else{
                imageView.setColorFilter(ContextCompat.getColor(context,R.color.primaryColor))
                imageView.setPadding(15.upTo())
            }
        }
    }
}