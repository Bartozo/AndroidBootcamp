package com.bartoszkrol.catfacts.ui.main


import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bartoszkrol.catfacts.R
import com.bartoszkrol.catfacts.model.CatFact
import kotlinx.android.synthetic.main.catfact_list_item.view.*

class CatFactHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindData(catFact: CatFact) {
        itemView.catFactTextView.text = catFact.text
        itemView.userTextView.text = itemView.resources.getString(
            R.string.user_textView_text,
            catFact.user.name.first,
            catFact.user.name.last)
        itemView.votesTextView.text = catFact.upvotes.toString()
//        itemView.userImageView
    }

}