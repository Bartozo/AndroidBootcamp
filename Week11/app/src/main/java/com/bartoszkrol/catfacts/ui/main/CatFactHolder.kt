package com.bartoszkrol.catfacts.ui.main

import android.animation.ValueAnimator
import android.view.View
import android.view.animation.AlphaAnimation
import androidx.recyclerview.widget.RecyclerView
import com.bartoszkrol.catfacts.R
import com.bartoszkrol.catfacts.model.CatFact
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.catfact_list_item.view.*


class CatFactHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindData(catFact: CatFact) {
        itemView.catFactTextView.text = catFact.text
        itemView.userTextView.text = itemView.resources.getString(
            R.string.user_textView_text,
            catFact.user?.name?.first,
            catFact.user?.name?.last)
        Glide.with(itemView.context)
            .load("https://raw.githubusercontent.com/Ashwinvalento/cartoon-avatar/master/lib/images/female/10.png")
            .into(itemView.userImageView)
        showFadeAnimation(itemView)
        showAnimationForUpVotes(catFact.upvotes)
    }

    private fun showFadeAnimation(view: View) {
        val animator = AlphaAnimation(0.0f, 1.0f)
        animator.duration = 350
        view.startAnimation(animator)
    }

    private fun showAnimationForUpVotes(upVotes: Int) {
        if (upVotes == 0) return

        val animator = ValueAnimator.ofInt(0, upVotes)
        animator.duration = 1000
        animator.addUpdateListener { animation ->
            itemView.votesTextView.text = animation.animatedValue.toString()
        }

        animator.start()
    }

}