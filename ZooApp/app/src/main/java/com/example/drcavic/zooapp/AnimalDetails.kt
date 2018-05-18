package com.example.drcavic.zooapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_animal_details.*

class AnimalDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_details)

        val bundle:Bundle = intent.extras
        val name = bundle.getString("name")
        val des = bundle.getString("des")
        val img = bundle.getInt("image")

        tvDescription.text = des
        tvAnimalName.text = name
        ivAnimal.setImageResource(img)
    }
}
