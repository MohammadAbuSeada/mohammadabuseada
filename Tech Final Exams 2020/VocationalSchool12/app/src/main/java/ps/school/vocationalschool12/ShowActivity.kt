package ps.school.vocationalschool12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_show.*


var schools: ArrayList<SchoolModel>? = null
var schoolHelper:DatabaseHandler? = null
var schoolAdapter: SchoolAdapter? = null

class ShowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
    }

    override fun onResume() {

        schoolHelper = DatabaseHandler(this)
        schools = schoolHelper!!.viewSchool()
        schoolAdapter = SchoolAdapter(this, schools!!)
        listview.adapter = schoolAdapter
        super.onResume()
    }
}