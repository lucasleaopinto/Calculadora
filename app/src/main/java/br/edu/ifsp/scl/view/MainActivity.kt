package br.edu.ifsp.scl.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        var retorno = false
        when(item.itemId){
            R.id.sairMenuItem ->{
                retorno = true
                finish()
            }
            R.id.configuracoesMenuItem ->{
                retorno = true
                val configuracaoIntent = Intent(this,ConfiguracaoActivity::class.java)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
