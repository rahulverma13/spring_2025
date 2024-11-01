package com.nighthawk.spring_portfolio.mvc.assignments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentsJPA extends JpaRepository<Assignments, Long> {
    Assignments findByName(String name);
    // jpa
    // yes it is incomplete right now
}
