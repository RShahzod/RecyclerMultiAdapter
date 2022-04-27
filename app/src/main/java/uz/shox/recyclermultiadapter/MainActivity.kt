package uz.shox.recyclermultiadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.shox.recyclergridkotlin.adapter.MultiAdapter
import uz.shox.recyclermultiadapter.model.User

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = GridLayoutManager(this,1)

        val users:ArrayList<User> = ArrayList()
        users.add(User("Shohjahon","Ortiqov",true))
        users.add(User("Shahzod","Ro'zimboyev",false))
        users.add(User("Otabek","Isnadinov",true))
        users.add(User("Og'abek","Normetov",true))
        users.add(User("Ismoil","Yo'ldoshev",false))
        users.add(User("Sanjar","Seitmuratov",true))

        val multiAdapter = MultiAdapter(this,users)
        recyclerView.adapter = multiAdapter



    }
}