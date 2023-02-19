package com.example.recipe_dt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class  RecipeAdapter(val context: Context, val explainlist: ArrayList<Recipe>):
    RecyclerView.Adapter<RecipeAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.explain_recipe, parent, false)
        return Holder(view)
    }
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(explainlist[position], context)
    }

    override fun getItemCount(): Int {
        return explainlist.size
    }
    inner class Holder(itemView: View?): RecyclerView.ViewHolder(itemView!!){
        val recipePhoto = itemView?.findViewById<ImageView>(R.id.courseImg)
        val courseExp = itemView?.findViewById<TextView>(R.id.courseExp)

        fun bind(recipe: Recipe, context: Context) {
            /* 나머지 TextView와 String 데이터를 연결한다. */
            courseExp?.text = recipe.explain

            try {
                Glide.with(itemView).load(recipe.photo).into(recipePhoto!!)
            } catch (e: NullPointerException) {
                recipePhoto?.setImageResource(R.mipmap.ic_launcher)
            }
        }
    }
}