package br.edu.ifsp.scl.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import br.edu.ifsp.scl.R
import br.edu.ifsp.scl.model.Configuracao
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
        return true
    }

    object  Constantes{
        val CONFIGURACAO_REQUEST_CODE = 0
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var retorno = false
        when(item.itemId){
            R.id.sairMenuItem ->{
                retorno = true
                finish()
            }
            R.id.configuracoesMenuItem ->{
                retorno = true
                val configuracaoIntent = Intent(this,ConfiguracaoActivity::class.java)
                startActivityForResult(configuracaoIntent,Constantes.CONFIGURACAO_REQUEST_CODE)
            }
        }
        return retorno
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == Constantes.CONFIGURACAO_REQUEST_CODE && resultCode == AppCompatActivity.RESULT_OK){
            val configuracao = data?.getParcelableExtra<Configuracao>(ConfiguracaoActivity.Constantes.CONFIGURACAO)
            if(configuracao!!.leiauteAvancado){
                supportFragmentManager.beginTransaction().replace(R.id.calculadoraFl, CalculadoraAvancadaFragment()).commit()
            }
        }
    }

}
