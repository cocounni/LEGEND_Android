package com.example.show_recipes

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recipe_dt.MainActivity
import com.example.recipe_dt.RecipeActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class RecipesListAdapter (val context: Context, var recipes_list: ArrayList<menu>): RecyclerView.Adapter<RecipesListAdapter.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesListAdapter.Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_recipes_add_menu, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return recipes_list.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(recipes_list[position], context)

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, MainActivity::class.java)
            val id = holder.itemView.findViewById<TextView>(R.id.menu_id).text.toString()
            intent.putExtra("recipeId", id)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }

    fun setData(newitemList:ArrayList<menu>){
        recipes_list = newitemList
    }

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        private val recipes_photo = itemView?.findViewById<ImageView>(R.id.menu_image)
        private val recipes_name = itemView?.findViewById<TextView>(R.id.menu_name)
        private val recipes_country = itemView?.findViewById<TextView>(R.id.menu_country)
        private val recipes_level = itemView?.findViewById<TextView>(R.id.menu_level)
        private val recipes_time = itemView?.findViewById<TextView>(R.id.menu_time)
        private val btn_selector = itemView?.findViewById<ImageButton>(R.id.btn_selector)
        private val recipes_id = itemView?.findViewById<TextView>(R.id.menu_id)
        var const = 0 //북마크가 이미 되어있는지 체크하는 변수

        private val DATE_RED = itemView?.findViewById<ImageView>(R.id.date_red)
        private val DATE_YELLOW = itemView?.findViewById<ImageView>(R.id.date_yellow)
        private val DATE_GREEN = itemView?.findViewById<ImageView>(R.id.date_green)

        val db_firestore = FirebaseFirestore.getInstance()

        fun bind(menu: menu, context: Context) {

            if (recipes_photo != null) {
                Glide.with(itemView)
                    .load(menu.menu_image)
                    .override(300, 300)
                    .into(recipes_photo)
            }

            /* 나머지 TextView와 String 데이터를 연결한다. */
            recipes_name?.text = menu.menu_name
            recipes_country?.text = menu.menu_country
            recipes_level?.text = menu.menu_level
            recipes_time?.text = menu.menu_time
            recipes_id?.text = menu.menu_id

            //유통기한 UI
            if (DATE_RED != null) {
                DATE_RED.visibility = if (menu.hurry_cnt != 0) {
                    View.VISIBLE
                } else {
                    View.INVISIBLE
                }
            }
            if (DATE_YELLOW != null) {
                DATE_YELLOW.visibility = if (menu.good_cnt != 0) {
                    View.VISIBLE
                } else {
                    View.INVISIBLE
                }
            }
            if (DATE_GREEN != null) {
                DATE_GREEN.visibility = if (menu.enough_cnt != 0) {
                    View.VISIBLE
                } else {
                    View.INVISIBLE
                }
            }
            //



            //북마크 UI
            val user = FirebaseAuth.getInstance().currentUser
            val uid = user?.uid
            db_firestore.collection(uid + "UserBookmark")
                .get()
                .addOnSuccessListener { bookmark_selected ->
                    for (document_id in bookmark_selected) {

                        if (btn_selector != null) {
                            if (document_id.data["RECIPE_ID"] == menu.menu_id) {
                                println("if")
                                println(menu.menu_id)
                                btn_selector.setSelected(true)

                            } else {
                                println("else")
                                println(menu.menu_id)

                                continue
                            }
                        }

                    }
                }
                .addOnFailureListener {
                    Toast.makeText(context, "북마크 데이터를 불러오는데 실패했습니다.", Toast.LENGTH_SHORT).show()
                }


        }

        val user = FirebaseAuth.getInstance().currentUser
        val uid = user?.uid
        init {
            //북마크 기능(별 클릭시 별 UI가 바뀌면서 파이어스토어로 RECIPE_ID가 올라감)
            if (btn_selector?.isSelected == true) { //북마크가 되어있는 경우(클릭 시 : 북마크에서 삭제, 한 번 더 :북마크에 추가 )
                btn_selector!!.setOnClickListener {
                    val recipes_id_star = recipes_id?.text.toString()//파이어스토어에 올릴 값
                    val star_menu_id = hashMapOf("RECIPE_ID" to recipes_id_star) //파이어스토어에 올리기

                    btn_selector?.isSelected = btn_selector?.isSelected != true //북마크 별 클릭시 모양 변환

                    if (btn_selector?.isSelected == true) {

                        db_firestore.collection(uid + "UserBookmark")
                            .get()
                            .addOnSuccessListener { bookmark_id ->
                                for (document_id in bookmark_id) {
                                    if (document_id.data["RECIPE_ID"] == recipes_id_star) {
                                        var edit_bookmark = document_id.id //파이어스토어 문서 ID명
                                        db_firestore.collection(uid + "UserBookmark").document(edit_bookmark)
                                            .delete()
                                    }
                                }
                                Toast.makeText(context, "북마크에서 해제되었습니다:)", Toast.LENGTH_SHORT).show()
                            }
                            .addOnFailureListener {
                                Toast.makeText(context, ":(", Toast.LENGTH_SHORT).show()
                            }


                    } else {//북마크 해제 시 파이어스토어 "UserBookmark" 컬렉션에 레시피 id 삭제함
                        db_firestore.collection(uid + "UserBookmark")
                            .get()
                            .addOnSuccessListener { bookmark_selected ->
                                for (document_id in bookmark_selected) {
                                    if (document_id.data["RECIPE_ID"] == recipes_id_star) {
                                        Toast.makeText(context, "이미 북마크에 있습니다.", Toast.LENGTH_SHORT)
                                            .show()
                                        const = 1
                                    }
                                }
                                if (const == 0) {
                                    db_firestore.collection(uid + "UserBookmark")
                                        .add(star_menu_id)
                                        .addOnSuccessListener {
                                            Toast.makeText(
                                                context,
                                                "북마크에 추가되었습니다:)",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }
                                        .addOnFailureListener {
                                            Toast.makeText(
                                                context,
                                                ":(",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }
                                }
                            }

                    }

                }
            }else{//북마크가 안 되어있는 경우(클릭 시 : 북마크에 추가, 한 번 더 : 북마크에서 삭제)
                btn_selector!!.setOnClickListener {
                    val recipes_id_star = recipes_id?.text.toString()//파이어스토어에 올릴 값
                    val star_menu_id = hashMapOf("RECIPE_ID" to recipes_id_star) //파이어스토어에 올리기

                    btn_selector?.isSelected = btn_selector?.isSelected != true //북마크 별 클릭시 모양 변환

                    if (btn_selector?.isSelected == true) {
                        //북마크 클릭 시 파이어스토어 "UserBookmark" 컬렉션에 레시피 id 올라감
                        val user = FirebaseAuth.getInstance().currentUser
                        val uid = user?.uid
                        db_firestore.collection(uid + "UserBookmark")
                            .get()
                            .addOnSuccessListener { bookmark_selected ->
                                for (document_id in bookmark_selected) {
                                    if (document_id.data["RECIPE_ID"] == recipes_id_star) {
                                        Toast.makeText(context, "이미 북마크에 있습니다.", Toast.LENGTH_SHORT)
                                            .show()
                                        const = 1
                                    }
                                }
                                if (const == 0) {
                                    db_firestore.collection(uid + "UserBookmark")
                                        .add(star_menu_id)
                                        .addOnSuccessListener {
                                            Toast.makeText(
                                                context,
                                                "북마크에 추가되었습니다:)",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }
                                        .addOnFailureListener {
                                            Toast.makeText(
                                                context,
                                                ":(",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }
                                }
                            }
                    } else {//북마크 해제 시 파이어스토어 "UserBookmark" 컬렉션에 레시피 id 삭제함

                        db_firestore.collection(uid + "UserBookmark")
                            .get()
                            .addOnSuccessListener { bookmark_id ->
                                for (document_id in bookmark_id) {
                                    if (document_id.data["RECIPE_ID"] == recipes_id_star) {
                                        var edit_bookmark = document_id.id //파이어스토어 문서 ID명
                                        db_firestore.collection(uid + "UserBookmark").document(edit_bookmark)
                                            .delete()
                                    }
                                }
                                Toast.makeText(context, "북마크에서 해제되었습니다:)", Toast.LENGTH_SHORT).show()
                            }
                            .addOnFailureListener {
                                Toast.makeText(context, ":(", Toast.LENGTH_SHORT).show()
                            }
                    }

                }

            }


        }
    }




}

