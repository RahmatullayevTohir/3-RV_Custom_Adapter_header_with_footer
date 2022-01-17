package com.example.a3_rvcustomadapter_header_with_footer

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a3_rvcustomadapter_header_with_footer.adapter.CustomAdapter
import com.example.a3_rvcustomadapter_header_with_footer.model.User
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

   private lateinit var recyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

        val users = prepareMemberList()
        refreshAdapter(users)
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
       recyclerView.layoutManager = GridLayoutManager(this,1)
    }

    private fun refreshAdapter(users: List<User>) {
        val adapter = CustomAdapter(users)
        recyclerView.adapter = adapter
    }

    private fun prepareMemberList(): List<User> {
        val users: MutableList<User> = ArrayList<User>()
        users.add(User("","",false)) // for Header
        for (i in 0..19) {
            if (i == 0 || i == 5 || i == 10 || i == 12) {
                users.add(User("Rahmatullayev$i", "Tohir$i", false))
            } else {
                users.add(User("Rahmatullayev$i", "Tohir$i", true))
            }
        }
        users.add(User("","",false)) // for Footer
        return users
    }
}