package br.edu.ifsp.scl.view

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.R
import kotlinx.android.synthetic.main.toolbar.*

class ConfiguracaoActivity: AppCompatActivity() {
    object  Constantes{
        //Chave de retorno para a MainActivity
        val CONFIGURACAO = "CONFIGURACAO"
    }

    //Referência para Controller
    lateinit var configuracaoController: ConfiguracaoController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracao)

        //Toolbar
        toolbar.title = "Configuração"
        setSupportActionBar(toolbar)
    }
}