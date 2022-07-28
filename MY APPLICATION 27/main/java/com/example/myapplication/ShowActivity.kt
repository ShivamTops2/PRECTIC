package com.example.myapplication

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AlertDialog
import com.example.sqliteex.DbHelper
import com.example.sqliteex.Model

class ShowActivity : AppCompatActivity()
{
    lateinit var listView: ListView
    var list: List<Model?>? = null
    lateinit var dbHelper: DbHelper
    var arrlist = ArrayList<HashMap<String, String?>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)


        listView=findViewById(R.id.list)
        list=ArrayList()
        dbHelper= DbHelper(this)

        list=dbHelper.viewdata()

        for (user in list!!)
        {
            val hm = HashMap<String, String?>()
            hm["name"] = user!!.name
            hm["number"] = user.num
            arrlist.add(hm)
        }

        var from = arrayOf("name", "number")
        var to = intArrayOf(R.id.txt1,R.id.txt2)

        var adapter=SimpleAdapter(this,arrlist,R.layout.desing,from,to)
        listView.adapter=adapter
        registerForContextMenu(listView)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        super.onCreateContextMenu(menu, v, menuInfo)

        var m1:MenuItem= menu!!.add(0,1,0,"UPDATE")
        var m2:MenuItem=menu!!.add(0,2,0,"DELETE")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {
        val acm:AdapterView.AdapterContextMenuInfo= item.menuInfo as AdapterView.AdapterContextMenuInfo
        var id:Int=acm.position
        val user = list!![id]

        when(item.itemId) {
            1 ->
            {
                var i=Intent(this,UpdateActivity::class.java)
                i.putExtra("id",user!!.id)
                i.putExtra("name",user!!.name)
                i.putExtra("number",user!!.num)
                startActivity(i)
            }
            2 ->
            {
                var alertDialog=AlertDialog.Builder(this)
                alertDialog.setTitle("Are you sure you want to delete?")
                alertDialog.setPositiveButton("YES",{
                        dialogInterface: DialogInterface, i: Int ->
                    dbHelper.deletedata(user!!.id)
                    var i=Intent(this,ShowActivity::class.java)
                    startActivity(i)
                })
                alertDialog.setNegativeButton("NO",{
                        dialogInterface: DialogInterface, i: Int ->

                    dialogInterface.cancel()

                })
                alertDialog.show()
            }


        }

        return super.onContextItemSelected(item)
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}