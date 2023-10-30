package com.example.areaeuro.domain;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Organizzazione {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long Id;

    private String nomeNazione;

    @OneToMany (mappedBy = "nazione")
    private Set<Rilevamento> rilevamenti=new HashSet<>();

    public Set<Rilevamento> getRilevamenti() {
        return rilevamenti;
    }

    public void setRilevamenti(Set<Rilevamento> rilevamenti) {
        this.rilevamenti = rilevamenti;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNomeNazione() {
        return nomeNazione;
    }

    public void setNomeNazione(String nomeNazione) {
        this.nomeNazione = nomeNazione;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organizzazione organizzazione = (Organizzazione) o;
        return Objects.equals(Id, organizzazione.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
