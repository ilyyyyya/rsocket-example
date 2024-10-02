package org.example.apprsocket.controller;

import org.example.apprsocket.model.Cat;
import org.example.apprsocket.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class MainSocketController {


    private final CatRepository catRepository;

    @Autowired
    public MainSocketController(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @MessageMapping("getCat")
    public Mono<Cat> getCat(Long id){
        return Mono.justOrEmpty(catRepository.findCatById(id));
    }

    @MessageMapping("addCat")
    public Mono<Cat> addCat(Cat cat){
        return Mono.justOrEmpty(catRepository.save(cat));
    }

    @MessageMapping("getCats")
    public Flux<Cat> getCats(){
        return Flux.fromIterable(catRepository.findAll());
    }

    @MessageMapping("deleteCat")
    public Mono<Void> deleteCat(Long id){
        Cat cat = catRepository.findCatById(id);
        catRepository.delete(cat);
        return Mono.empty();
    }

    @MessageMapping("catChannel")
    public Flux<Cat> catChannel(Flux<Cat> cats){
        return cats.flatMap(cat -> Mono.fromCallable(() ->
                        catRepository.save(cat)))
                .collectList()
                .flatMapMany(Flux::fromIterable);
    }

}
