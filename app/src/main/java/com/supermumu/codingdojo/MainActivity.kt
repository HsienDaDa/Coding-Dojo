package com.supermumu.codingdojo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var list: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list = findViewById(R.id.list)

        val adapter = GameListAdapter().also {
            val list = ArrayList<String>()
            list.add("Potter")
            it.submitList(list)
        }

        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this)
    }
}

private class GameListAdapter: RecyclerView.Adapter<GameListAdapter.ItemViewHolder>() {
    private var list: List<String> = emptyList()

    override fun onCreateViewHolder(container: ViewGroup, position: Int): ItemViewHolder {
        val view = LayoutInflater.from(container.context).inflate(R.layout.game_item, container, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.title.text = list.getOrNull(position)
    }

    fun submitList(newList: List<String>) {
        list = newList
        notifyDataSetChanged()
    }

    private inner class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val title: TextView = itemView.findViewById(R.id.title)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            when (adapterPosition) {
                0 -> {
                    val intent = Intent(itemView.context, PotterActivity::class.java)
                    itemView.context.startActivity(intent)
                }
                else -> Toast.makeText(itemView.context, "請功能請加上實做啊！", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
