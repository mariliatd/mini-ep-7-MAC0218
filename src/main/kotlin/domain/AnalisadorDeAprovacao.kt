package domain

import domain.criterios.CriterioDeAprovacao
import domain.criterios.Basico

class AnalisadorDeAprovacao {
    private var criterioAtual : CriterioDeAprovacao = Basico()

    fun defineCriterio(criterio : CriterioDeAprovacao) {
        criterioAtual = criterio
    }

    fun fechaBoletim (boletim: Boletim) : BoletimFechado {
        return BoletimFechado(boletim.mediaEPs,
                                boletim.mediaMiniEPs,
                                criterioAtual.mediaFinal(boletim),
                                criterioAtual.estaAprovado(boletim))
    }

}