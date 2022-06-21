package com.ilionx.cyclists.persistence;

import com.ilionx.cyclists.model.Cyclist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CyclistRepository extends JpaRepository<Cyclist, Long> {
    public List<Cyclist> findByName(String name);
    public List<Cyclist> findByTeam(String team);
    public List<Cyclist> findByRanking(int ranking);
}
