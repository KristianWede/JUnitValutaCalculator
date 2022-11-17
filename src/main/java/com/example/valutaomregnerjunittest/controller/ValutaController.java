package com.example.valutaomregnerjunittest.controller;

import com.example.valutaomregnerjunittest.repository.ValutaOmregner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class ValutaController {

    ValutaOmregner valutaOmregner = new ValutaOmregner();

    @GetMapping("")
    public String index(HttpSession session){
        session.getAttribute("result");
        return "index";
    }

    @GetMapping("/convertedValuta")
    public String convertValues(HttpSession session, @RequestParam String valuta1, @RequestParam String valuta2, @RequestParam int value){

        double result = valutaOmregner.exchange(valuta1,valuta2,value);
        session.setAttribute("result", result);


        return "redirect:/index";
    }

}
