package br.com.caelum.financas.modelo;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQuery(name = "mediaDaContaPeloTipoMovimentacao", query = "select avg(m.valor) from Movimentacao m where m.conta = :pConta and m.tipoMovimentacao = :pTipo)")
@Entity
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal valor;
    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipoMovimentacao;

    public void setTipoMovimentacao(final TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    @Temporal(TemporalType.DATE)
    private Calendar data;

    private String descricao;

    @ManyToOne
    private Conta conta;

    public Integer getId() {
        return this.id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public void setValor(final BigDecimal valor) {
        this.valor = valor;
    }

    public Calendar getData() {
        return this.data;
    }

    public void setData(final Calendar data) {
        this.data = data;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }

    public Conta getConta() {
        return this.conta;
    }

    public void setConta(final Conta conta) {
        this.conta = conta;
    }

}
