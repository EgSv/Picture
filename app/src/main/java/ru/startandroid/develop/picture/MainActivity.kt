package ru.startandroid.develop.picture

import android.content.Context
import android.graphics.*
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(DrawView(this))
    }

    /*internal inner class DrawView(context: Context) : View(context) {
        private var p: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
        private var path: Path = Path()
        private var picture: Picture = Picture()

        init {
            val canvas = picture.beginRecording(300, 300)
            p.color = Color.GREEN
            canvas.drawCircle(150f, 100f, 80f, p)
            p.color = Color.BLUE
            canvas.drawRect(20f, 70f, 150f, 200f, p)
            p.color = Color.RED

            path.moveTo(170f, 80f)
            path.lineTo(240f, 210f)
            path.lineTo(100f, 210f)
            path.close()
            canvas.drawPath(path, p)
            picture.endRecording()
        }

        override fun onDraw(canvas: Canvas) {
            canvas.drawARGB(80, 102, 204, 255)
            canvas.drawPicture(picture)
        }
    }*/

    internal class DrawView(context: Context?) : View(context) {
        private var p: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
        private var path: Path
        private var picture: Picture = Picture()
        private var rect: Rect = Rect(0, 0, 100, 100)
        private var rect1: Rect = Rect(0, 0, 500, 200)

        init {
            val canvas = picture.beginRecording(300, 300)
            p.color = Color.GREEN
            canvas.drawCircle(150f, 100f, 80f, p)
            p.color = Color.BLUE
            canvas.drawRect(20f, 70f, 150f, 200f, p)
            p.color = Color.RED
            path = Path()
            path.moveTo(170f, 80f)
            path.lineTo(240f, 210f)
            path.lineTo(100f, 210f)
            path.close()
            canvas.drawPath(path, p)
            picture.endRecording()
        }

        override fun onDraw(canvas: Canvas) {
            canvas.drawARGB(80, 102, 204, 255)
            canvas.drawPicture(picture)
            canvas.translate(300f, 0f)
            canvas.drawPicture(picture, rect)
            canvas.translate(0f, 300f)
            canvas.drawPicture(picture, rect1)
        }
    }
}