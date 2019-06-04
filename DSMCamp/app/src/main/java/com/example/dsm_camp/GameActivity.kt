package com.example.dsm_camp

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.dsm_camp.model.Fish
import kotlinx.android.synthetic.main.activity_game.*
import okhttp3.MediaType
import okhttp3.RequestBody
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
        abilityUpdate()

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
        want += 500
        haveExp = 0
        abilityUpdate()
        update()
        builder.show()
    }

    fun abilityUpdate() {
        monster = Fish()
        hp = monster.hp
        damage = monster.hp / (11 - level)
    }

    fun update() {
        game_level_tv.text = level.toString()
        game_hp_tv.text = hp.toString()
        game_exp_tv.text = haveExp.toString()
    }

    fun getData(st: String): RequestBody {
        return RequestBody.create(MediaType.parse("text/plane"), st)
    }

    override fun onDestroy() {
        Toast.makeText(this, "저장되었습니다.", Toast.LENGTH_SHORT).show()
        super.onDestroy()
    }
}
