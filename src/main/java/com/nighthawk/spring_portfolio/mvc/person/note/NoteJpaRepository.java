package com.nighthawk.spring_portfolio.mvc.person.note;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nighthawk.spring_portfolio.mvc.person.Person;

import jakarta.transaction.Transactional;

public interface NoteJpaRepository extends JpaRepository<Note, Long> {
    List<Person> findByPersonId(Long id);

    @Transactional
    void deleteByPersonId(long id);
}

