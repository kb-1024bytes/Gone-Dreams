package org.tensorflow.lite.examples.posenet

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.os.Bundle

import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import org.tensorflow.lite.examples.posenet.lib.Posenet as Posenet

class TestActivity : AppCompatActivity() {
  private fun drawableToBitmap(drawable: Drawable): Bitmap {
    val bitmap = Bitmap.createBitmap(257, 353, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)

    drawable.setBounds(0, 0, canvas.width, canvas.height)

    drawable.draw(canvas)
    return bitmap
  }
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.tfe_pn_activity_test)
    val sampleImageView = findViewById<ImageView>(R.id.image)
    val drawedImage = ResourcesCompat.getDrawable(resources, R.drawable.image, null)
    val imageBitmap = drawableToBitmap(drawedImage!!)
    sampleImageView.setImageBitmap(imageBitmap)
    val posenet = Posenet(this.applicationContext)
    val person = posenet.estimateSinglePose(imageBitmap)
    val paint = Paint()
    paint.color = Color.RED
    val size = 2.0f

    val mutableBitmap = imageBitmap.copy(Bitmap.Config.ARGB_8888, true)
    val canvas = Canvas(mutableBitmap)
    for (keypoint in person.keyPoints) {
      canvas.drawCircle(
        keypoint.position.x.toFloat(),
        keypoint.position.y.toFloat(), size, paint
      )
    }
    sampleImageView.adjustViewBounds = true
    sampleImageView.setImageBitmap(mutableBitmap)
  }
}