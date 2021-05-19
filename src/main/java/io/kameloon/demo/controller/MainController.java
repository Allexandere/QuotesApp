package io.kameloon.demo.controller;

import io.kameloon.demo.dto.QuoteCreateRequest;
import io.kameloon.demo.service.QuoteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
public class MainController {

    @Autowired
    private QuoteService quoteService;

    @GetMapping("/")
    public String start(Model model)
    {
        model.addAttribute("quoteCreateRequest", new QuoteCreateRequest());
        model.addAttribute("quotes", quoteService.GetAll());
        return "main_page";
    }

    @PostMapping("/")
    public String postQuote(@ModelAttribute QuoteCreateRequest quoteCreateRequest, Model model)
    {
        log.info("[POST] got {}",quoteCreateRequest.toString());

        quoteService.CreateQuote(quoteCreateRequest);

        model.addAttribute("quoteCreateRequest", new QuoteCreateRequest());
        model.addAttribute("quotes", quoteService.GetAll());

        return "main_page";
    }

    @RequestMapping(value = "/delete/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public String postQuote(@PathVariable(value = "id") Long id, Model model){
        log.info("[DELETE] got {}", id);

        try {
            quoteService.DeleteQuote(id);
        }
        catch (Exception e){
            log.error(e.getMessage());
        }

        model.addAttribute("quoteCreateRequest", new QuoteCreateRequest());
        model.addAttribute("quotes", quoteService.GetAll());

        return "main_page";
    }
}
