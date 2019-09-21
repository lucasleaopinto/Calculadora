package br.edu.ifsp.scl.controler

import br.edu.ifsp.scl.model.Configuracao
import br.edu.ifsp.scl.model.ConfiguracaoService
import br.edu.ifsp.scl.view.ConfiguracaoActivity

class ConfiguracaoController(val view: ConfiguracaoActivity) {

    val model: ConfiguracaoService
    init {
        model = ConfiguracaoService(view.applicationContext)
    }

    fun salvaConfiguracao(configuracao: Configuracao){
        model.setConfiguracao(configuracao)
        view.atualizaView(configuracao)
    }

    fun buscaConfiguracao(){
        val configuracao = model.getConfiguracao()
        view.atualizaView(configuracao)
    }
}