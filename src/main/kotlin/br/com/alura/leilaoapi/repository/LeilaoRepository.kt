package br.com.alura.leilaoapi.repository

import br.com.alura.leilaoapi.model.Leilao
import org.springframework.data.repository.PagingAndSortingRepository

interface LeilaoRepository : PagingAndSortingRepository<Leilao, Long>