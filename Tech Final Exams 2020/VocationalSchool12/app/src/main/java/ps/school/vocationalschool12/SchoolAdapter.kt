package ps.school.vocationalschool12

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.custom_view_item.view.*

class SchoolAdapter(context: Context,
                    private val schools: ArrayList<SchoolModel>)
    : ArrayAdapter<SchoolModel>(context, R.layout.custom_view_item, schools) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val rowView = inflater.inflate(R.layout.custom_view_item, parent, false)

        rowView.details_btn.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java).apply {
                putExtra("id",position)
            }
            context.startActivity(intent)
        }


        rowView.delete_btn.setOnClickListener {

            val databaseHandler = DatabaseHandler(getContext())

            databaseHandler.deleteSchool(SchoolModel(schools[position].id,"","",0,0))
            schools.removeAt(position)
            schoolAdapter?.notifyDataSetChanged()
            Toast.makeText(getContext(),"record deleted", Toast.LENGTH_LONG).show()
        }

        rowView.tv_customview.text = schools[position].name

        return rowView
    }
}