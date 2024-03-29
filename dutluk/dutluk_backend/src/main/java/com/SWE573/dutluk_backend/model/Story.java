package com.SWE573.dutluk_backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name="stories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Story extends BaseEntity{


    @NotBlank
    @Lob
    private String text;

    @NotBlank
    private String title;

    @ElementCollection
    @Column
    private List<String> labels = new ArrayList<>();



    @JsonIncludeProperties(value = {"id" , "username"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "story")
    private List<Comment> comments;

    @Column(name = "likes")
    private Set<Long> likes = new HashSet<>();

    @OneToMany(mappedBy = "story", cascade = CascadeType.ALL)
    private List<Location> locations = new ArrayList<>();

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "start_time_stamp")
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate startTimeStamp;

    @Column(name = "end_time_stamp")
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate endTimeStamp;


    private String season;

    private String decade;



}
