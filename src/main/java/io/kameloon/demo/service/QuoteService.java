package io.kameloon.demo.service;

import io.kameloon.demo.dto.QuoteCreateRequest;
import io.kameloon.demo.entity.Quote;
import io.kameloon.demo.repo.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteService {

    @Autowired
    private QuoteRepository quoteRepository;

    public void CreateQuote(QuoteCreateRequest quoteCreateRequest){
        quoteRepository.save(new Quote(
                quoteCreateRequest.getAuthor(),
                quoteCreateRequest.getTitle(),
                quoteCreateRequest.getText()
        ));
    }

    public List<Quote> GetAll(){
        return quoteRepository.getAll();
    }

    public void DeleteQuote(Long id){
        quoteRepository.deleteById(id);
    }

}
