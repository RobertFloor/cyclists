package com.ilionx.cyclists.persistence;

import com.ilionx.cyclists.model.Cyclist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CyclistRepository extends JpaRepository<Cyclist, Long> {
    List<Cyclist> findByName(String name);
    List<Cyclist> findByTeam(String team);
    List<Cyclist> findByRanking(int ranking);
    public List<Cyclist> findByRankingGreaterThan(int upperLimit);
}
