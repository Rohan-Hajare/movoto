package com.movoto.movoto.Sell.Controller;

import com.movoto.movoto.Sell.Entity.Sell;
import com.movoto.movoto.Sell.Service.SellServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sell")
public class SellController {

    @Autowired
    private SellServiceImpl sellService;

    @PostMapping("/add")
    public ResponseEntity<String> addPropertyForSell(@RequestBody Sell sell)
    {
        sellService.addproperty(sell);

      return new ResponseEntity<>("property addes successfully", HttpStatus.OK);
    }
}
