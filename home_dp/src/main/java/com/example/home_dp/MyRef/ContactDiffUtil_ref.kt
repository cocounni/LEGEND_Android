package com.example.home_dp.MyRef

import androidx.recyclerview.widget.DiffUtil

class ContactDiffUtil_ref(private val oldList: ArrayList<Item>, private val currentList: ArrayList<Item>) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = currentList.size

    //이전 어댑터와 바뀌는 어댑터의 아이템이 동일한 지 확인을 합니다.
    // 각 아이템의 고유 ID값을 활용하여 비교
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == currentList[newItemPosition].id
    }

    //이전 어댑터와 바뀌는 어댑터의 아이템 내 내용을 비교
    //areItemsTheSame 에서 true가 나올 경우 추가적으로 비교하기 위해서 사용하는 함수
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == currentList[newItemPosition]
    }
}