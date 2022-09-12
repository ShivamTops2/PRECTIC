package com.example.project2


    import android.annotation.SuppressLint
    import android.content.Context
    import android.content.Intent

    import androidx.recyclerview.widget.RecyclerView

    import android.view.LayoutInflater
    import android.view.View

    import android.view.ViewGroup
    import android.widget.ImageView
    import android.widget.TextView

    import com.example.project2.R
    import com.example.project2.project2.CategoryActivity
    import com.squareup.picasso.Picasso


class MyAdapter(context: Context, dataList: List<Dashboard_Model>) :
    RecyclerView.Adapter<MyAdapter.Myview>() {
    var context: Context
    var dataList: List<Dashboard_Model>
    var api: Apiinterface? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myview
    {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.desigb_dashboard, parent, false)
        return Myview(view)
    }

    override fun onBindViewHolder(holder: Myview, @SuppressLint("RecyclerView") position: Int) {
        holder.t2.setText(dataList[position].name)
        Picasso.get().load(dataList[position].image).into(holder.img)
        holder.img.setOnClickListener()
        {
            var i = Intent(context, CategoryActivity::class.java)
            i.putExtra("MyPos",position)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }


    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class Myview(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img: ImageView
        var t2: TextView


        init {
            img = itemView.findViewById(R.id.img)
            t2 = itemView.findViewById(R.id.txt)

        }
    }

    init {
        this.context = context
        this.dataList = dataList
    }
}