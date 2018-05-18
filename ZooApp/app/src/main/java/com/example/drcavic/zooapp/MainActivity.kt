package com.example.drcavic.zooapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_animal_details.view.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_ticket.view.*


class MainActivity : AppCompatActivity() {

    var listOfAnimals = ArrayList<Animal>()
    var adapter : AnimalsAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listOfAnimals.add(Animal("Baboon", "Baboon live in big place with tree", R.drawable.baboon, false))
        listOfAnimals.add(Animal("Bulldog", "Bulldog live in big place with tree", R.drawable.bulldog, true))
        listOfAnimals.add(Animal("Panda", "Panda live in big place with tree", R.drawable.panda, true))
        listOfAnimals.add(Animal("Swallow bird", "Swallow bird live in big place with tree", R.drawable.swallow_bird, false))
        listOfAnimals.add(Animal("White tiger", "White tiger live in big place with tree", R.drawable.white_tiger, true))
        listOfAnimals.add(Animal("Zebra", "Zebra live in big place with tree", R.drawable.zebra, false))

        adapter = AnimalsAdapter(this, listOfAnimals)
        tvListAnimal.adapter = adapter
    }
    fun delete(index:Int){
        listOfAnimals.removeAt(index)
        adapter!!.notifyDataSetChanged()
    }
    fun duplicate(index: Int){
        listOfAnimals.add(index+1, listOfAnimals[index])
        adapter!!.notifyDataSetChanged()
    }

    inner class AnimalsAdapter : BaseAdapter{
        var listOfAnimals = ArrayList<Animal>()
        var context:Context? = null
        constructor(context:Context, listOfAnimals: ArrayList<Animal>):super() {
            this.listOfAnimals = listOfAnimals
            this.context = context
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val animal = listOfAnimals[position]
            if (animal.isKiller == true){
                var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myView = inflater.inflate(R.layout.animal_killer_ticket, null)
                myView.tvName.text = animal.name!!
                myView.ivName.setImageResource(animal.image!!)
                myView.tvDes.text = animal.des!!
                myView.ivName.setOnClickListener {
                    val intent = Intent(context, AnimalDetails::class.java)
                    intent.putExtra("name", animal.name!!)
                    intent.putExtra("des", animal.des!!)
                    intent.putExtra("image", animal.image!!)
                    context!!.startActivity(intent)
                }
                return myView
            }
            else {
                var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myView = inflater.inflate(R.layout.animal_ticket, null)
                myView.tvName.text = animal.name!!
                myView.ivName.setImageResource(animal.image!!)
                myView.tvDes.text = animal.des!!
                myView.ivName.setOnClickListener {
                    val intent = Intent(context, AnimalDetails::class.java)
                    intent.putExtra("name", animal.name!!)
                    intent.putExtra("des", animal.des!!)
                    intent.putExtra("image", animal.image!!)
                    context!!.startActivity(intent)
                }
                return myView
            }
        }

        override fun getItem(position: Int): Any {
            return listOfAnimals[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listOfAnimals.size
        }

    }
}
