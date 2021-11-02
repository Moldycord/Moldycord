package com.danieer.newsapp.views

import android.view.View
import com.danieer.newsapp.R
import com.danieer.newsapp.databinding.FeedItemViewBinding
import com.xwray.groupie.viewbinding.BindableItem

class FeedItemView(private val title: String) : BindableItem<FeedItemViewBinding>() {

    override fun bind(viewBinding: FeedItemViewBinding, position: Int) {
        viewBinding.apply {
            textViewTitle.text = title
        }
    }

    override fun getLayout(): Int = R.layout.feed_item_view

    override fun initializeViewBinding(view: View): FeedItemViewBinding {
        return FeedItemViewBinding.bind(view)
    }

}