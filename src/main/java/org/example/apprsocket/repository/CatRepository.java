package org.example.apprsocket.repository;

import org.example.apprsocket.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {
    Cat findCatById(Long id);
}
