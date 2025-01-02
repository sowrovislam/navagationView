package com.example.nav_25_2

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
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
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setSupportActionBar(binding.toolbar)


        val navController = findNavController(R.id.Fragment_container_view)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.blankFragment,
                R.id.blankFragment2,
                R.id.blankFragment3
            ), binding.drawerlayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navagationView.setupWithNavController(navController)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {


     menuInflater.inflate(R.menu.main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> {
                Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT).show()
                return true
            }
            // Add other cases for other menu items if needed
            else -> return super.onOptionsItemSelected(item)
        }
    }



    override fun onSupportNavigateUp(): Boolean {

        val navController=findNavController(R.id.Fragment_container_view)

        return navController.navigateUp(appBarConfiguration)||super.onSupportNavigateUp()
    }
}