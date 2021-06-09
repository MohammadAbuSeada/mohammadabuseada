package ps.school.alqudsmosque999

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.custom_view.view.*

class CustomAdapter(context: Context, mosque:ArrayList<Mosque>):
    ArrayAdapter<Mosque>(context,0,mosque){
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val listItemView=
            LayoutInflater.from(context).inflate(R.layout.custom_view,parent,false)
        val mosque: Mosque? =getItem(position)
        listItemView.textView.text=mosque!!.name
        listItemView.imageView.setImageResource(mosque.image)
        return listItemView
    }

}
