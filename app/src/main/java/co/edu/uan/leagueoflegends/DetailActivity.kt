package co.edu.uan.leagueoflegends

import android.animation.Animator
import android.content.Intent
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
        //if(text.equals("jinx")){
            iniciarActividad(editText.text.toString()+"/100",text)
        //}

    }

    fun iniciarActividad(cali: String,name: String){
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("nota",cali)
        intent.putExtra("nombre",name)
        startActivity(intent)
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
