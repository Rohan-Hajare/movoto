package com.movoto.movoto.Sell.Repository;

import com.movoto.movoto.Sell.Entity.Sell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellRepository extends JpaRepository<Sell,Long> {
}
