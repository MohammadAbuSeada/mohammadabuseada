package ps.school.temperatureconverte12

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.content.ContentProviderCompat.requireContext
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragment_aboutfh,AboutFragment())
//            .commit()

        about_btn.setOnClickListener {

            notify(myid++, "title","message", R.drawable.ic_launcher_foreground, this)
            Toast.makeText(this,"Mohammad", Toast.LENGTH_LONG).show()


            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_aboutfh,AboutFragment())
                .commit()
        }

        conversion_btn.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_aboutfh,ConvertFragment())
                .commit()
        }

    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun notify(id:Int, title: String, text: String, icon:Int, context: Context){
    if (Build.VERSION.SDK_INT >= 26){
        val importance = NotificationManager.IMPORTANCE_HIGH
        val mChannel = NotificationChannel("channel_01", "My app", importance)

        var notification = NotificationCompat.Builder(context, "channel_01")
            .setSmallIcon(icon)
            .setContentTitle(title)
            .setContentText(text)
            .build()
        val mNotificationManager= context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        mNotificationManager.createNotificationChannel(mChannel)
        mNotificationManager.notify(id, notification)
    }
    else{
        val notification = NotificationCompat.Builder(context)
            .setSmallIcon(icon)
            .setContentTitle(title)
            .setContentText(text)
            .build()

        val mNotificationManager= context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        mNotificationManager.notify(id, notification)
    }
}

// هاي زي الي فوقها بس مع اذا كنت بدي لما يظهر الاشعار يروح لواجهة تانية بكتب اسمها في الaction
//fun notify(id:Int, title: String, text: String, icon:Int, context: Context, actionActivity: Context)