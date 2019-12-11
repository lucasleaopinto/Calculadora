package br.edu.ifsp.scl.view

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.R
import br.edu.ifsp.scl.controler.ConfiguracaoController
import br.edu.ifsp.scl.model.Configuracao
import br.edu.ifsp.scl.model.Separador
import kotlinx.android.synthetic.main.activity_configuracao.*
import kotlinx.android.synthetic.main.toolbar.*

class ConfiguracaoActivity : AppCompatActivity() {
    object Constantes {
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

        //chama controler e atualiza a view
        configuracaoController = ConfiguracaoController(this)
        configuracaoController.buscaConfiguracao()
    }


    //Função Chamada pelo controller depois de acesso o model
    fun atualizaView(configuracao: Configuracao) {
        //ajusta o laouyt com a configuracao
        leiauteSpn.setSelection(if (configuracao.leiauteAvancado) 1 else 0)
        separadorRg.check(
            if (configuracao.separador == Separador.PONTO)
                R.id.pontoRb
            else R.id.virgulaRb
        )
        //Seta Resultado Para Main Activity
        setResult(AppCompatActivity.RESULT_OK, Intent().putExtra(Constantes.CONFIGURACAO,configuracao))
    }

    fun onClickSalvaConfiguracao(v: View){
        //Pega os dados da tela
        val leiauteAvancado = leiauteSpn.selectedItemPosition == 1
        val separador = if (pontoRb.isChecked) Separador.PONTO else Separador.VIRGULA

        // Criar um objeto Configuracao
        val novaConfiguracao: Configuracao = Configuracao(leiauteAvancado, separador)
        configuracaoController.salvaConfiguracao(novaConfiguracao)

        //Chamar a controller para salvar
      //  Toast.makeText(this,"Configuração Salva",Toast).show()
    }

}