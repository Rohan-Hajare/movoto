package com.movoto.movoto.Sell.Service;

import com.movoto.movoto.Sell.Entity.Sell;
import com.movoto.movoto.Sell.Repository.SellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellServiceImpl implements SellService{

    @Autowired
   private SellRepository sellRepo;

    @Override
    public void addproperty(Sell sell) {
        sellRepo.save(sell);
    }
}
