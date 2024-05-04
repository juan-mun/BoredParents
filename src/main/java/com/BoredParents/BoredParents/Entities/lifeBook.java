package com.BoredParents.BoredParents.Entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;

@Entity
public class lifeBook {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLifeBook;

    private String title;

    @Lob
    private String description;

    @Lob
    @Column(nullable = true)
    private byte[] content;

    @Column(length = 100)
    private String contentType;

    private LocalDate eventDate;

    @OneToOne
    @JoinColumn(name = "nino_id", referencedColumnName = "id_nino")
    private Nino nino;

    // Getters y setters
    public Long getIdLifeBook() {
        return idLifeBook;
    }

    public void setIdLifeBook(Long idLifeBook) {
        this.idLifeBook = idLifeBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public Nino getNino() {
        return nino;
    }

    public void setNino(Nino nino) {
        this.nino = nino;
    }


}
