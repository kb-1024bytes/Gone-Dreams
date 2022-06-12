package org.tensorflow.lite.examples.posenet
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CameraActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.tfe_pn_activity_camera)
    var res = intent.getStringExtra("key")
    if (res == null) {
      res = "no"
    }
    savedInstanceState ?: supportFragmentManager.beginTransaction()
      .replace(R.id.container, PosenetActivity())
      .commit()

  }
  override fun onStart() {
    super.onStart()
    val str = intent.getStringExtra("res")
    //Toast.makeText(applicationContext, "Stopping!!!!!! in camera", Toast.LENGTH_LONG).show();
 //   if (str != null) {
      if (str.equals("ok", ignoreCase = true)) {
        Toast.makeText(applicationContext, "You completed the task", Toast.LENGTH_LONG).show()
        println("Damn\n")
//        val i = Intent(applicationContext, StopActivity::class.java)
        intent.putExtra("key", "ok")
        Thread.sleep(3000);
        finish();
      }
   // }
    //Toast.makeText(applicationContext, "Str = $str", Toast.LENGTH_SHORT).show()
  }

//  override fun onResume() {
//    super.onResume()
//    val str = intent.getStringExtra("res")
//    if (str != null) {
//      if (str.equals("ok", ignoreCase = true)) {
//        val i = Intent(applicationContext, StopActivity::class.java)
//        i.putExtra("key", "ok")
//        startActivity(i)
//      }
//    }
//  }

//  override fun onRestart() {
//    super.onRestart()
//    val str = intent.getStringExtra("res")
//    if (str != null) {
//      if (str.equals("ok", ignoreCase = true)) {
//        val i = Intent(applicationContext, StopActivity::class.java)
//        i.putExtra("key", "ok")
//        startActivity(i)
//      }
//    }
//  }
}