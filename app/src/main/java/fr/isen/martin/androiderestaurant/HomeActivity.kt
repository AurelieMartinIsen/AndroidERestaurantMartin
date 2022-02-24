package fr.isen.martin.androiderestaurant


import android.content.Intent
import android.os.Bundle
import fr.isen.martin.androiderestaurant.databinding.ActivityHomeBinding


class HomeActivity : BaseActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.entree.setOnClickListener {
            changeActivity(getString(R.string.home_starter))
        }


        binding.plat.setOnClickListener {
            changeActivity(getString(R.string.home_dish))
        }


        binding.desserts.setOnClickListener {
            changeActivity(getString(R.string.home_dessert))
        }

    }

    private fun changeActivity(category: String) {
        val intent = Intent( this, CategoriesActivity::class.java)
        intent.putExtra("category_type", category)
        startActivity(intent)
    }

}