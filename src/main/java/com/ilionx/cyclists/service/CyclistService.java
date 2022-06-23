package com.ilionx.cyclists.service;

import com.ilionx.cyclists.model.Cyclist;
import com.ilionx.cyclists.persistence.CyclistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional // deze gehele Service is Transactional. Kan prima. Maar kan ook per method worden gezet. findByTeam bijvoorbeeld moet dat @Transactional zijn?
public class CyclistService {

    @Autowired
    private CyclistRepository cyclistRepository;

    public List<Cyclist> findByTeam(String team) {
        return this.cyclistRepository.findByTeam(team);
    }

    public List<Cyclist> findByName(String name) {
        return this.cyclistRepository.findByName(name);
    }

    public List<Cyclist> findByRanking(int ranking) {
        return this.cyclistRepository.findByRanking(ranking);
    }

    public Cyclist save (Cyclist cyclist) {
        Cyclist newCyclist = this.cyclistRepository.save(cyclist);
        int b = 0;
//       int a = 3 /0;
        return newCyclist;
    }
    public List<Cyclist> findByRankingGreaterThan(int upperLimit) {
        return this.cyclistRepository.findByRankingGreaterThan(upperLimit);
    }
    public List<Cyclist> findAll() {
        return this.cyclistRepository.findAll();
    }

    public Optional<Cyclist> findById(Long id) {
        return this.cyclistRepository.findById(id);
    }

    public void deleteById(Long id) {
        this.cyclistRepository.deleteById(id);
    }
}
