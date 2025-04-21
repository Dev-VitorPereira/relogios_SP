package com.relogios.relogios_SP.repository;

import com.relogios.relogios_SP.model.Relogio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelogioRepository extends JpaRepository<Relogio, Long> {
}
