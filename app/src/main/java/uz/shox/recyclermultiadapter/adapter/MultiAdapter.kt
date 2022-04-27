package uz.shox.recyclergridkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.shox.recyclermultiadapter.R
import uz.shox.recyclermultiadapter.model.User


class MultiAdapter(private val context:Context, private val users: ArrayList<User>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_AVAILABLE_YES = 0
    private val TYPE_AVAILABLE_NO = 1


    override fun getItemViewType(position: Int): Int {
        return if (users[position].available){
            TYPE_AVAILABLE_YES
        } else{
            TYPE_AVAILABLE_NO
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType==TYPE_AVAILABLE_YES){
            val view = LayoutInflater.from(context).inflate(R.layout.item_view_yes,parent,false)
            return UserViewYesHolder(view)
        }
        val view = LayoutInflater.from(context).inflate(R.layout.item_view_no,parent,false)
        return UserViewNoHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = users[position]

        if (holder is UserViewYesHolder){
            holder.lastName.text = user.lastName
            holder.name.text = user.name
        }
        if (holder is UserViewNoHolder){
            holder.lastName.text = user.lastName
            holder.name.text = user.name
        }

    }

    override fun getItemCount(): Int {
        return users.size
    }

    class UserViewYesHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val lastName = itemView.findViewById<TextView>(R.id.lastName)!!
        val name = itemView.findViewById<TextView>(R.id.name)!!
    }
    class UserViewNoHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val lastName = itemView.findViewById<TextView>(R.id.lastNames)!!
        val name = itemView.findViewById<TextView>(R.id.names)!!
    }

}