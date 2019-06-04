package com.example.dsm_camp

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.dsm_camp.model.Fish
import kotlinx.android.synthetic.main.activity_game.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import java.util.*

class GameActivity : AppCompatActivity() {

    var hp = 0
    var level = 1
    var damage = 0
    var haveExp = 0
    var want = 500
    val random = Random()
    var monster = Fish()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        game_name_tv.text = intent.getStringExtra("username")
        val randomNumber = random.nextInt(10) + 1

        monster = Fish()
        hp = monster.hp
        damage = monster.hp / (11 - level)


        game_fish_imv.onClick {
            hp -= damage
            update()
            if (hp <= 0) {
                haveExp += monster.exp
                hp += monster.hp
                update()
            }
            if (haveExp >= want) {
                levelUp()
            }
            if (level < 9) {

                update()
            }
            else {

            }

        }


//        if (hp <= 0) {
//            hp += 500
//            exp += 500
//            update()
//        }

//        if (exp >= 500) {
//            show()
//        }
    }

    fun levelUp() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("레벨업!")
        Toast.makeText(this, "레벨업!", Toast.LENGTH_SHORT).show()
        level++
        want+=500
        update()
        builder.show()
    }

    fun update() {
        game_level_tv.text = level.toString()
        game_hp_tv.text = hp.toString()
        game_exp_tv.text = haveExp.toString()
    }
}
