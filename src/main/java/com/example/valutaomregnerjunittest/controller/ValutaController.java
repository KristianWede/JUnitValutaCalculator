package com.example.valutaomregnerjunittest.controller;

import com.example.valutaomregnerjunittest.repository.ValutaOmregnerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Parameter;

@Controller
public class ValutaController {

    ValutaOmregnerRepository valutaOmregner = new ValutaOmregnerRepository();

    @GetMapping("")
    public String index(){
        System.out.println("back to start");
        return "index";
    }

    @PostMapping("/convertedValuta")
    public String convertValues(HttpSession session, @RequestParam String valuta1, @RequestParam String valuta2, @RequestParam int value){
        double result = valutaOmregner.exchange(valuta1,valuta2,value);
        session.setAttribute("result",result);
        session.setAttribute("firstValuta", valuta1);
        session.setAttribute("secondValuta", valuta2);
        session.setAttribute("convert", value);
        System.out.println(result);

        return "index";
    }

}
