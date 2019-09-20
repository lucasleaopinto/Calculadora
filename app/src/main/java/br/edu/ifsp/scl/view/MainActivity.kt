package br.edu.ifsp.scl.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.ifsp.scl.R
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Toolbar
        toolbar.title = getString(R.string.app_name)
        setSupportActionBar(toolbar)

        //Fragment
        supportFragmentManager.beginTransaction().replace(R.id.calculadoraFl, CalculadoraBasicaFragment()).commit()



    }



}
