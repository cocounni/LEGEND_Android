package com.example.home_dp.MyRef

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.home_dp.R

class RefAdapter(val context: Context, var itemList: ArrayList<Item>):
    RecyclerView.Adapter<RefAdapter.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_main, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(itemList[position], context)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    fun setData(newitemList:ArrayList<Item>){
        itemList = newitemList
    }

    fun setContact_ref() {
        val diffResult = DiffUtil.calculateDiff(ContactDiffUtil_ref(this.itemList, itemList), false)
        diffResult.dispatchUpdatesTo(this)
        this.itemList = itemList
    }

    inner class Holder(itemView: View?): RecyclerView.ViewHolder(itemView!!){
        val menuPhoto = itemView?.findViewById<ImageView>(R.id.menuPhotoImg)
        val menuName = itemView?.findViewById<TextView>(R.id.menuText)
        val itemDate = itemView?.findViewById<TextView>(R.id.dateText)
        val itemleftdate = itemView?.findViewById<ImageView>(R.id.leftdatesign)

        @Suppress("DEPRECATION")
        @SuppressLint("SetTextI18n")
        fun bind(item: Item, context: Context){
            itemView.setOnClickListener {
                EditDate().editDate(itemList[position].id, context, item.menuname)
            }

            if (item.photo != "") {
                val resourceId = context.resources.getIdentifier(item.photo, "drawable", context.packageName)
                menuPhoto?.setImageResource(resourceId)
            } else {
                menuPhoto?.setImageResource(R.mipmap.ic_launcher)
            }
            /* 나머지 TextView와 String 데이터를 연결한다. */
            menuName?.text = item.menuname
            itemDate?.text = "${item.year}년\n${item.month}월 ${item.day}일 까지"

            // 유통기한에 따라 색 바꾸기
            if(item.date == "여유"){
                itemleftdate?.setImageResource(R.drawable.date_green)
            }
            else if(item.date == "보통"){
                itemleftdate?.setImageResource(R.drawable.date_yellow)
            }
            else if(item.date == "급함"){
                itemleftdate?.setImageResource(R.drawable.date_red)
            }
            else if (item.year != "-"){
                itemDate?.setTextColor(Color.parseColor("#ffff0000"))
            }
        }
    }
}