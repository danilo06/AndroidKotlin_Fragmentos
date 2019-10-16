package co.edu.uan.leagueoflegends

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList
import android.widget.Toast
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



/**
 * Main Activity
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        //drawCards()
    }

    private fun drawCards() {
        val cardList = readCardsFile()
        for(card in cardList) {
            addCard(card)
        }
    }

    fun btnJinxAction(view: View){
        Toast.makeText(applicationContext,"Toast por defecto", Toast.LENGTH_SHORT).show()
        //iniciarActividad("jinx")
    }
    fun btnKaisaAction(view: View){
        iniciarActividad("kaisa")
    }
    fun btnLeeAction(view: View){
        iniciarActividad("leesin")
    }
    fun btnKaybAction(view: View){
        iniciarActividad("kayn")
    }

    fun iniciarActividad(imgName: String){
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("imgname",imgName)
        startActivity(intent)
    }
    private fun addCard(card: String) {
        val ib = ImageButton(this)
        var imageId = resources.getIdentifier(getCardCropImage(card),"drawable", packageName)
        if(imageId==0) {
            imageId = resources.getIdentifier("innervate_crop","drawable", packageName)
        }
        ib.setImageResource(imageId)
        ib.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("cardImage",getCardImage(card))
            intent.putExtra("cardText",getCardText(card))
            startActivity(intent)
        }
        cardsLayout.addView(ib)
        val tv = TextView(this)
        tv.text = getCardName(card)
        cardsLayout.addView(tv)
    }



    private fun readCardsFile() : ArrayList<String> {
        // Open the cards file as a raw resource
        val inputStream = resources.openRawResource(R.raw.base_cards)
        val scanner = Scanner(inputStream)
        // Read all the lines of the file
        val cardsList = ArrayList<String>()
        scanner.nextLine()
        while(scanner.hasNextLine()) {
            val line = scanner.nextLine()
            cardsList.add(line)
        }
        scanner.close()
        return cardsList
    }

    private fun getCardName(card: String) : String {
        val cols = card.split(",")
        return cols[1]
    }

    private fun getCardCropImage(card: String) : String {
        val cols = card.split(",")
        return cols[2]
    }

    private fun getCardImage(card: String) : String {
        val cols = card.split(",")
        return cols[3]
    }

    private fun getCardText(card: String) : String {
        val cols = card.split(",")
        return cols[5]
    }
}
