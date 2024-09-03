package org.example.repository;

import org.example.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CardRepository extends JpaRepository<Card,Long> {
    Card findCardByStudentId(Long studentId);

    @Transactional
    void deleteCardByStudentId(Long studentId);
}
