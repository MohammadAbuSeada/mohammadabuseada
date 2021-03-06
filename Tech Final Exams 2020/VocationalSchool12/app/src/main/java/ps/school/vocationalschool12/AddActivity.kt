package ps.school.vocationalschool12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        back_btn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        add_btn.setOnClickListener {


                schools?.add(SchoolModel(0,
                    name=shcoolname_edt.text.toString(),
                    address=shcooladdress_edt.text.toString(),
                    phone=phone_edt.text.toString().toInt(),
                    number=number_edt.text.toString().toInt()))


                schoolHelper?.addSchool(SchoolModel(1,
                    name=shcoolname_edt.text.toString(),
                    address=shcooladdress_edt.text.toString(),
                    phone=phone_edt.text.toString().toInt(),
                    number=number_edt.text.toString().toInt()))

            shcoolname_edt.setText("")
            shcooladdress_edt.setText("")
            phone_edt.setText("")
            number_edt.setText("")

        }
    }
}