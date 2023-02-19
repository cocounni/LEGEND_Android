package com.example.home_dp.MyRef

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.home_dp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_ref_tab.*

class RefTab : Fragment() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언
    private val MenuList = arrayListOf<Item>()

    private val user = FirebaseAuth.getInstance().currentUser
    private val uid = user?.uid

    private lateinit var recyclerViewref: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        showData()

        val mAdapter = context?.let { RefAdapter(it, MenuList) }

        val rootView = inflater.inflate(R.layout.fragment_ref_tab, container, false)
        recyclerViewref = rootView.findViewById(R.id.recyclerView_ref) as RecyclerView
        recyclerViewref.layoutManager = GridLayoutManager(context, 3)
        recyclerViewref.adapter = mAdapter

        val swiperef = rootView.findViewById<SwipeRefreshLayout>(R.id.swiperef)
        swiperef.setOnRefreshListener {
            showData()

            swiperef.isRefreshing = false
        } // 스와이프해서 새로고침

        return rootView
    }


    private fun showData(){
        var ing_date : String
        db.collection(uid + "UserSelect")
            .get()
            .addOnSuccessListener { result ->
                //성공할 경우
                MenuList.clear()
                for (document in result) {
                    if ("display" in document && document.data["display"] as String == "1"){
                        val display_data = document.data["display"] as String
                        val id_data = document.data["id"] as String
                        val photo_data = document.data["photo"] as String
                        val menuname_data = document.data["menuname"] as String
                        for (document_sub in result){
                            if("year" in document_sub && "month" in document_sub
                                && "day" in document_sub && document_sub.data["id"] == document.data["id"]){
                                val year_data = document_sub.data["year"] as String
                                val month_data = document_sub.data["month"] as String
                                val day_data = document_sub.data["day"] as String

                                ing_date = LeftDate().Cal_Date_len1(document_sub.data["year"].toString()) +
                                        LeftDate().Cal_Date_len1(document_sub.data["month"].toString()) +
                                        LeftDate().Cal_Date_len1(document_sub.data["day"].toString())

                                if (ing_date != "nullnullnull") {
                                    ing_date = LeftDate().Cat_ing_editdate(LeftDate().Cal_Date(ing_date)) //유통기한 계산 함수, 카테고리화
                                }

                                val itemtmp = Item(display_data, id_data, photo_data,
                                    menuname_data, year_data, month_data, day_data, ing_date)
                                MenuList.add(itemtmp)
                            }
                        }
                    }
                }
                updateRecyclerData()
                if (MenuList.size == 0){
                    RefEmpty.text = "냉장고가 비어있습니다."
                }
                else{
                    RefEmpty.text = ""
                }
            }
            .addOnFailureListener { exception ->
                // 실패할 경우
                Log.w("Why", "Error getting documents: $exception")
            }
    }

    fun updateRecyclerData(){
        val mAdapter = context?.let { RefAdapter(it, MenuList) }
        recyclerViewref.adapter = mAdapter
        mAdapter?.setData(MenuList)
        mAdapter?.setContact_ref()
    }
}
