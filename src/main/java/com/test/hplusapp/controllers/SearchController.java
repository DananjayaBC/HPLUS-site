package com.test.hplusapp.controllers;

import com.test.hplusapp.beans.product;
import com.test.hplusapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    public ProductRepository productRepository;

    @GetMapping("/search")
    public String search(@RequestParam("search")String search, Model model){
        System.out.println("in search controller");
        System.out.println("search criteria "+search);

        List<product> products = new ArrayList<>();
        products = productRepository.searchByName(search);
        model.addAttribute("products",products);
        return "search";
    }
}
