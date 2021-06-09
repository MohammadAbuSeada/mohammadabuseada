package ps.school.temperatureconverte12

import android.app.AlertDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.custom_dialog.*
import kotlinx.android.synthetic.main.custom_dialog.view.*
import kotlinx.android.synthetic.main.custom_dialog.view.input_edt
import kotlinx.android.synthetic.main.fragment_convert.view.*


var title_ar = "معلومة"
var text_ar = "هذة درجة تجمد الماء في النظام الفهرنهايت..!!"
var title_en = "Information"
var text_en = "This is the freezing point of water in the Fahrenheit system."

var myid = 1234
// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ConvertFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@Suppress("NAME_SHADOWING")
class ConvertFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_convert, container, false)

        view.covert_btn.setOnClickListener {
            val inflater = LayoutInflater.from(context)
            val view = inflater.inflate(R.layout.custom_dialog, null)

            val builder = AlertDialog.Builder(context)
            builder.setView(view)


            val dialog = builder.create()
         //   dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            dialog.show()

            view.cancel_btn.setOnClickListener {
                dialog.cancel()
            }
            view.run_btn.setOnClickListener {

                view.result_tv.text =  ((view.input_edt.text.toString().toDouble() * 9/5) + 32).toString()
                if (view.result_tv.text.toString() == "32.0"){
                    
                    notify(myid++, title_ar, text_ar, R.drawable.bulb, requireContext())
                  //  Toast.makeText(context,"Mohammad", Toast.LENGTH_LONG).show()
                }
            }

        }


        return view
    }


companion object {
            /**
             * Use this factory method to create a new instance of
             * this fragment using the provided parameters.
             *
             * @param param1 Parameter 1.
             * @param param2 Parameter 2.
             * @return A new instance of fragment ConvertFragment.
             */
            // TODO: Rename and change types and number of parameters
            @JvmStatic
            fun newInstance(param1: String, param2: String) =
                ConvertFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
        }

    }
