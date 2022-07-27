package com.aizoon.rendicontazione.model.entity;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity @Table(name = "Announcements")
public class Announcement {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id @Column(name = "announcement_id", nullable = false)
    private Long announcementID;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @OneToOne
    @MapsId
    @JoinColumn(name = "request_id")
    private Request request;
}
