package co.edu.uan.leagueoflegends

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detail.*
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

/**
 * Detailed view for a card
 */
class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_detail)
        loadCampeones()
    }

    fun clickaction(view: View){
        val text = intent.getStringExtra("imgname")
        Toast.makeText(getApplicationContext(),text, Toast.LENGTH_SHORT).show()
        if(text.equals("")){
            Toast.makeText(getApplicationContext(),"Toast por defecto", Toast.LENGTH_SHORT).show()
            txtjinx.text=editText.text.toString()+"/100"
        }
    }

    fun loadCampeones() {
        val image = intent.getStringExtra("imgname")
        val text = intent.getStringExtra("imgname")
        var imageId = resources.getIdentifier(image,"drawable", packageName)
        cardImage.setImageResource(imageId)

        YoYo.with(Techniques.Tada)
            .duration(1700)
            .withListener(object: Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator?) {
                }
                override fun onAnimationEnd(animation: Animator?) {
                    textimage.text = text
                }
                override fun onAnimationCancel(animation: Animator?) {
                }
                override fun onAnimationStart(animation: Animator?) {
                }
            })
            .playOn(cardImage)
    }
}
