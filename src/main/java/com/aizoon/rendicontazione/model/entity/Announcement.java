package com.aizoon.rendicontazione.model.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "RE_Announcements")
public class Announcement {

    @Id
    @Column(name = "announcement_id", nullable = false)
    private Long announcementId;

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

    @OneToMany
    private List<AnnouncementApplication> announcementApplications;
}
