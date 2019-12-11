package br.edu.ifsp.scl.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.get
import androidx.fragment.app.Fragment
import br.edu.ifsp.scl.R
import br.edu.ifsp.scl.uteis.Calculadora
import br.edu.ifsp.scl.uteis.Operador
import kotlinx.android.synthetic.main.fragment_calculadora_avancada.*
import kotlinx.android.synthetic.main.fragment_calculadora_basica.*
import kotlinx.android.synthetic.main.fragment_calculadora_basica.adicaoBt
import kotlinx.android.synthetic.main.fragment_calculadora_basica.cincoBt
import kotlinx.android.synthetic.main.fragment_calculadora_basica.divisaoBt
import kotlinx.android.synthetic.main.fragment_calculadora_basica.doisBt
import kotlinx.android.synthetic.main.fragment_calculadora_basica.lcdTv
import kotlinx.android.synthetic.main.fragment_calculadora_basica.multiplicacaoBt
import kotlinx.android.synthetic.main.fragment_calculadora_basica.noveBt
import kotlinx.android.synthetic.main.fragment_calculadora_basica.oitoBt
import kotlinx.android.synthetic.main.fragment_calculadora_basica.pontoBt
import kotlinx.android.synthetic.main.fragment_calculadora_basica.quatroBt
import kotlinx.android.synthetic.main.fragment_calculadora_basica.resultadoBt
import kotlinx.android.synthetic.main.fragment_calculadora_basica.seisBt
import kotlinx.android.synthetic.main.fragment_calculadora_basica.seteBt
import kotlinx.android.synthetic.main.fragment_calculadora_basica.subtracaoBt
import kotlinx.android.synthetic.main.fragment_calculadora_basica.tresBt
import kotlinx.android.synthetic.main.fragment_calculadora_basica.umBt
import kotlinx.android.synthetic.main.fragment_calculadora_basica.zeroBt

class CalculadoraAvancadaFragment: Fragment() {
    var concatenaLcd: Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_calculadora_avancada, container, false)
    }

    fun onClick(p: View?) {
        when (p) {
            // Números
            umBt, doisBt, tresBt, quatroBt, cincoBt,
            seisBt, seteBt, oitoBt, noveBt, zeroBt -> {
                // Limpa LCD se último clicado foi um operador
                if (!concatenaLcd) {
                    lcdTv.text = ""
                }
                lcdTv.append((p as Button).text.toString())
                concatenaLcd = true
            }
            // Ponto
            pontoBt -> {
                if (!lcdTv.text.toString().contains(".")) {
                    if (!concatenaLcd) {
                        lcdTv.text = "0"
                    }
                    lcdTv.append(".")
                    concatenaLcd = true
                }
            }
            // Operadores
            adicaoBt -> cliqueOperador(Operador.ADICAO)
            subtracaoBt -> cliqueOperador(Operador.SUBTRACAO)
            multiplicacaoBt -> cliqueOperador(Operador.MULTIPLICACAO)
            divisaoBt -> cliqueOperador(Operador.DIVISAO)
            ceBt -> cliqueOperador(Operador.CE)
            cBt -> cliqueOperador(Operador.C)
            porcentageBt -> cliqueOperador(Operador.PORCENTAGEM)
            resultadoBt -> cliqueOperador(Operador.RESULTADO)
            raizBt -> cliqueOperador(Operador.RAIZ)
        }
    }

    fun cliqueOperador(operador: Operador) {
        lcdTv.text = Calculadora.calcula(
            lcdTv.text.toString().toFloat(), operador
        ).toString()
        concatenaLcd = false
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        for (i in 0..(view as ViewGroup).childCount -1){
            val  v = view.get(i)
            if(v is Button){
                v.setOnClickListener(::onClick)
            }
        }
    }
}