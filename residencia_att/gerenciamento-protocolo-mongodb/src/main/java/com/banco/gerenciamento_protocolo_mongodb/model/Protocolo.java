package com.banco.gerenciamento_protocolo_mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "protocolos")
public class Protocolo {

    @Id
    private String id;
    private String numeroProtocolo;      // Gerado pelo sistema, único
    private String tipoProtocolo;        // Reclamação, Elogio, Informação, etc.
    private String descricao;            // Campo para relatar o acontecimento
    private Cliente cliente;             // Cliente pode ser nulo para anônimos
    private LocalDate dataAbertura;      // Data de abertura gerada automaticamente
    private LocalDate dataPrazo;         // Calculada automaticamente com base no tipo de protocolo
    private String canal;                // Canal onde foi aberto (Fale Conosco, Agência, etc.)

    // Novos campos adicionados de acordo com os requisitos
    private LocalDate dataUltimaAcao;     // Data da última ação realizada no protocolo
    private LocalDate dataRecebimento;    // Data em que o funcionário começou a atender o protocolo
    private String departamentoResponsavel; // Departamento que está atuando no protocolo
    private boolean propensaoBacen;       // Se pode gerar um apontamento BACEN
    private boolean agilizar;             // Se precisa ser agilizado
    private boolean devido;               // Se a reclamação tem motivo plausível
    private boolean procedente;           // Se a questão é procedente ou há justificativa
    private String statusProtocolo;       // Novo, Em análise, Redirecionado, etc.
    private List<String> historicoSituacoes;  // Histórico de situações do protocolo
    private String respostaProtocolo;     // Resposta final ao requerente

    // Getters e Setters para todos os campos

    public String getNumeroProtocolo() {
        return numeroProtocolo;
    }

    public void setNumeroProtocolo(String numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }

    public String getTipoProtocolo() {
        return tipoProtocolo;
    }

    public void setTipoProtocolo(String tipoProtocolo) {
        this.tipoProtocolo = tipoProtocolo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDate getDataPrazo() {
        return dataPrazo;
    }

    public void setDataPrazo(LocalDate dataPrazo) {
        this.dataPrazo = dataPrazo;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public LocalDate getDataUltimaAcao() {
        return dataUltimaAcao;
    }

    public void setDataUltimaAcao(LocalDate dataUltimaAcao) {
        this.dataUltimaAcao = dataUltimaAcao;
    }

    public LocalDate getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(LocalDate dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public String getDepartamentoResponsavel() {
        return departamentoResponsavel;
    }

    public void setDepartamentoResponsavel(String departamentoResponsavel) {
        this.departamentoResponsavel = departamentoResponsavel;
    }

    public boolean isPropensaoBacen() {
        return propensaoBacen;
    }

    public void setPropensaoBacen(boolean propensaoBacen) {
        this.propensaoBacen = propensaoBacen;
    }

    public boolean isAgilizar() {
        return agilizar;
    }

    public void setAgilizar(boolean agilizar) {
        this.agilizar = agilizar;
    }

    public boolean isDevido() {
        return devido;
    }

    public void setDevido(boolean devido) {
        this.devido = devido;
    }

    public boolean isProcedente() {
        return procedente;
    }

    public void setProcedente(boolean procedente) {
        this.procedente = procedente;
    }

    public String getStatusProtocolo() {
        return statusProtocolo;
    }

    public void setStatusProtocolo(String statusProtocolo) {
        this.statusProtocolo = statusProtocolo;
    }

    public List<String> getHistoricoSituacoes() {
        return historicoSituacoes;
    }

    public void setHistoricoSituacoes(List<String> historicoSituacoes) {
        this.historicoSituacoes = historicoSituacoes;
    }

    public String getRespostaProtocolo() {
        return respostaProtocolo;
    }

    public void setRespostaProtocolo(String respostaProtocolo) {
        this.respostaProtocolo = respostaProtocolo;
    }
}
