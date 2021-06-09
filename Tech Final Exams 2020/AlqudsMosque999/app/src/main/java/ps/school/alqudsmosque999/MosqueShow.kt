package ps.school.alqudsmosque999

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_mosque_show.*

class MosqueShow : AppCompatActivity() {

    var mosque_array=ArrayList<Mosque>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mosque_show)


        mosque_array.add(Mosque("جامع عمر بن الخطاب",R.drawable.omar))
        mosque_array.add(Mosque("مسجد الشيخ ريحان",R.drawable.ryhan))
        mosque_array.add(Mosque("مسجد الشيخ لولو",R.drawable.lolo))
        mosque_array.add(Mosque("مسجد ومقام الشيخ شكي مكي",R.drawable.shky))
        mosque_array.add(Mosque("مسجد عثمان بن عفان",R.drawable.othman))
        mosque_array.add(Mosque("مسجد اليعقوبي",R.drawable.yakoby))
        mosque_array.add(Mosque("مسجد القرمي",R.drawable.qrmi))
        mosque_array.add(Mosque("مسجد العمري",R.drawable.omary))
        mosque_array.add(Mosque("مسجد الحريري",R.drawable.harere))
        mosque_array.add(Mosque("مسجد العمري الكبير",R.drawable.omarykaber))
        mosque_array.add(Mosque("مسجد ولي الله محارب",R.drawable.waly))
        mosque_array.add(Mosque("مسجد سويقة علون",R.drawable.sowaqa))
        mosque_array.add(Mosque(" مسجدر درغث",R.drawable.arghth))
        mosque_array.add(Mosque("مسجد أبو بكر الصديق",R.drawable.abubaker))
        mosque_array.add(Mosque("مسجد الست قمرة",R.drawable.setqumra))
        mosque_array.add(Mosque("مسجد حيات",R.drawable.hayat))
        mosque_array.add(Mosque("مسجد قلاوون (المنصوري)",R.drawable.qlawon))
        mosque_array.add(Mosque("مسجد ومقام السيوفي",R.drawable.alsouofe))
        mosque_array.add(Mosque("مسجد المئذنة الحمراء",R.drawable.almeazana))
        mosque_array.add(Mosque("جامع الشيخ غباين",R.drawable.ghbayn))

        val myadapter = CustomAdapter(this, mosque_array)
        gridview1.adapter = myadapter
    }
}