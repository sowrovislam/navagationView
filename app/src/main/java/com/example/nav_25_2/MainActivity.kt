package com.example.nav_25_2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.nav_25_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setSupportActionBar(binding.toolbar)


  val navController=findNavController(R.id.Fragment_container_view)

        appBarConfiguration= AppBarConfiguration(
                   setOf( R.id.blankFragment,
                          R.id.blankFragment2,
                          R.id.blankFragment3
                        ),binding.drawerlayout
        )

        setupActionBarWithNavController(navController,appBarConfiguration)
        binding.navagationView.setupWithNavController(navController)



    }

    override fun onSupportNavigateUp(): Boolean {

        val navController=findNavController(R.id.Fragment_container_view)

        return navController.navigateUp(appBarConfiguration)||super.onSupportNavigateUp()
    }
}