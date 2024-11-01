package com.nighthawk.spring_portfolio.mvc.assignments;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Assignments {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({"id", "name", "type", "description", "dueDate", "timestamp", "submissions"})
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=false)
    private String name;
    private String type;
    private String description;
    private String dueDate;
    private String timestamp;

    @OneToMany(mappedBy = "assignment")
    @JsonIgnore
    private List<Submission> submissions = new ArrayList<>();  // init list

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Assignments(String name, String type, String description, String dueDate) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.dueDate = dueDate; 
        this.timestamp = LocalDateTime.now().format(formatter); // fixed formatting ahhh
        this.submissions = new ArrayList<>(); 
    }

    public static List<Assignments> createInitialData() {
        List<Assignments> assignments = new ArrayList<>();
        // initial assignemnt cause why not??!?
        assignments.add(new Assignments("Assignment 1", "Class Homework", "Unit 1 Homework", "10/25/2024"));
        return assignments;
    }

    public static List<Assignments> init() {
        return createInitialData();
    }
}