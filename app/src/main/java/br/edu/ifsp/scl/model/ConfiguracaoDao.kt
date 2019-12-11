package br.edu.ifsp.scl.model

interface ConfiguracaoDao {

    // CRUD, exceto Delete no nosso exemplo
    fun createOrUpdateConfiguracao(configuracao: Configuracao)
    fun readConfiguracao(): Configuracao

}