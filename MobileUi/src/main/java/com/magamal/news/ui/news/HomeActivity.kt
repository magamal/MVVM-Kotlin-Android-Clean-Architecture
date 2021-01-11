package com.magamal.news.ui.news

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.magamal.news.R

/**
 * @author Mahmoud Gamal on 1/8/21.
 */
class HomeActivity : AppCompatActivity() {


    private val fragment by lazy { NewsListFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        addFragment(fragment)
    }

    private fun addFragment(fragment: NewsListFragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}