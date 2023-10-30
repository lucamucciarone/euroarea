package com.example.areaeuro.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Rilevamento {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long Id;
    private float importo;

    private LocalDateTime dataRilevamento;

    @ManyToOne
    private Organizzazione organizzazione;

    public void setImporto(float importo) {
        this.importo = importo;
    }

    public Organizzazione getNazione() {
        return organizzazione;
    }

    public void setNazione(Organizzazione organizzazione) {
        this.organizzazione = organizzazione;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Float getImporto() {
        return importo;
    }

    public void setImporto(Float importo) {
        this.importo = importo;
    }

    public LocalDateTime getDataRilevamento() {
        return dataRilevamento;
    }

    public void setDataRilevamento(LocalDateTime dataRilevamento) {
        this.dataRilevamento = dataRilevamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rilevamento that = (Rilevamento) o;
        return Objects.equals(Id, that.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
