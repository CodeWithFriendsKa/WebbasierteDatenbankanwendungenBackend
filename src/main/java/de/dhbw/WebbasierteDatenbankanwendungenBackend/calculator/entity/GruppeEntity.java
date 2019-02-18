package de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.entity;

import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.entity.SpielerEntity;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.entity.TrainerEntity;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class GruppeEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String platz;
    private String zeit;
    @OneToMany(fetch = FetchType.EAGER)
    private List<SpielerEntity> spielerListe;
    @ManyToOne
    private TrainerEntity trainer;

    public GruppeEntity() {}

    public GruppeEntity(String platz, String zeit, List<SpielerEntity> spielerListe, TrainerEntity trainer) {
        this.platz = platz;
        this.zeit = zeit;
        this.spielerListe = spielerListe;
        this.trainer = trainer;
    }

    public Long getId() {
        return id;
    }

    public String getPlatz() {
        return platz;
    }

    public String getZeit() {
        return zeit;
    }

    public List<SpielerEntity> getSpielerListe() {
        return spielerListe;
    }

    public TrainerEntity getTrainer() {
        return trainer;
    }

    @Override
    public String toString() {
        return "GruppeEntity{" +
                "id=" + id +
                ", platz='" + platz + '\'' +
                ", zeit='" + zeit + '\'' +
                ", spielerListe=" + spielerListe +
                ", trainer=" + trainer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GruppeEntity that = (GruppeEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(platz, that.platz) &&
                Objects.equals(zeit, that.zeit) &&
                Objects.equals(spielerListe, that.spielerListe) &&
                Objects.equals(trainer, that.trainer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, platz, zeit, spielerListe, trainer);
    }
}
