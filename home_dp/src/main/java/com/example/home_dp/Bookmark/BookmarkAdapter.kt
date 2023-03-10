package com.example.home_dp.Bookmark

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.home_dp.R
import com.example.recipe_dt.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class BookmarkAdapter(val context: Context, var foodList: ArrayList<BookmarkFood>):
    RecyclerView.Adapter<BookmarkAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.food_main_bookmark, parent, false)
        return Holder(view)
    }
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(foodList[position], context)

        holder.clicklayout?.setOnClickListener {
            val recipeId = holder.itemView.findViewById<TextView>(R.id.foodId).text.toString()
            val intent = Intent(holder.itemView.context, MainActivity::class.java)
            intent.putExtra("recipeId", recipeId)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    fun setData(newitemList:ArrayList<BookmarkFood>){
        foodList = newitemList
    }

    fun setContact_bookmark(contacts: ArrayList<BookmarkFood>){
        val diffResult = DiffUtil.calculateDiff(ContactDiffUtil_bookmark(this.foodList, foodList), false)
        diffResult.dispatchUpdatesTo(this)
        this.foodList = foodList
    }


    inner class Holder(itemView: View?): RecyclerView.ViewHolder(itemView!!){
        val foodPhoto = itemView?.findViewById<ImageView>(R.id.foodPhotoImg)
        val foodName = itemView?.findViewById<TextView>(R.id.foodName)
        val foodTime = itemView?.findViewById<TextView>(R.id.foodTime)
        val starButton = itemView?.findViewById<ImageButton>(R.id.starbutton)
        val db_firestore = FirebaseFirestore.getInstance()
        val foodId = itemView?.findViewById<TextView>(R.id.foodId)
        val clicklayout = itemView?.findViewById<LinearLayout>(R.id.ClickLayout)

        fun bind(food: BookmarkFood, context: Context){
            /* ????????? TextView??? String ???????????? ????????????. */
            foodName?.text = food.name
            foodTime?.text = food.time
            foodId?.text = food.id

            try {
                Glide.with(itemView).load(food.photo).into(foodPhoto!!)
            } catch (e: NullPointerException) {
                foodPhoto?.setImageResource(R.mipmap.ic_launcher)
            }
        }

//        ????????????
        init{
            //????????? ??????(??? ????????? ??? UI??? ???????????? ????????????????????? RECIPE_ID??? ?????????)
            starButton!!.setOnClickListener{
                starButton.isSelected = starButton.isSelected != true //????????? ??? ????????? ?????? ??????

                val user = FirebaseAuth.getInstance().currentUser
                val uid = user?.uid

                if (starButton.isSelected == false){
                    //????????? ?????? ??? ?????????????????? "UserBookmark" ???????????? ????????? id ?????????
                    val recipes_id_star = foodId?.text.toString()//????????????????????? ?????? ???
                    val star_menu_id = hashMapOf("RECIPE_ID" to recipes_id_star) //????????????????????? ?????????

                    db_firestore.collection(uid + "UserBookmark")
                        .add(star_menu_id)
                        .addOnSuccessListener { Toast.makeText(context, "???????????? ?????????????????????:)", Toast.LENGTH_SHORT).show() }
                        .addOnFailureListener { Toast.makeText(context, ":(", Toast.LENGTH_SHORT).show() }
                }
                else{//????????? ?????? ??? ?????????????????? "UserBookmark" ???????????? ????????? id ?????????
                    val recipes_id_star = foodId?.text.toString()
                    db_firestore.collection(uid + "UserBookmark")
                        .get()
                        .addOnSuccessListener { bookmark_id ->
                            for (document_id in bookmark_id){
                                if(document_id.data["RECIPE_ID"] == recipes_id_star){
                                    val edit_bookmark = document_id.id //?????????????????? ?????? ID???
                                    db_firestore.collection(uid + "UserBookmark").document(edit_bookmark).delete()
                                }
                            }
                            Toast.makeText(context, "??????????????? ?????????????????????:)", Toast.LENGTH_SHORT).show()
                        }
                        .addOnFailureListener { Toast.makeText(context, ":(", Toast.LENGTH_SHORT).show()}
                }
            }
        }
    }
}