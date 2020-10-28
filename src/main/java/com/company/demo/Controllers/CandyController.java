package com.company.demo.Controllers;

import com.company.demo.Models.Candy;
import com.company.demo.Models.repositories.CandyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class CandyController {
    @Autowired
    private CandyRepository candyRepository;


    @RequestMapping(value = "/api/v1/candies", method = RequestMethod.GET)
    public ArrayList<Candy> getAllCandies(){
        var candies = candyRepository.findAll();
        return (ArrayList<Candy>) candies;
    }
    @RequestMapping(value = "/api/v1/candies/categories",method = RequestMethod.GET)
    public String getAllCategoriesCandies(){
     var allCandies = candyRepository.findAll();

     var licoriceCandies = new ArrayList<Candy>();
     var chewingGumCandies = new ArrayList<Candy>();
     var bubbleGumCandies = new ArrayList<Candy>();
     var chocolateCandies = new ArrayList<Candy>();
     var otherCandies = new ArrayList<Candy>();

        for (var candy:allCandies) {
            if (candy.getType().equalsIgnoreCase("Licorice")){
                licoriceCandies.add(candy);
            }
            if (candy.getType().equalsIgnoreCase("Chewing Gum")){
                chewingGumCandies.add(candy);
            }
            if (candy.getType().equalsIgnoreCase("Bubble Gum")){
                bubbleGumCandies.add(candy);
            }
            if (candy.getType().equalsIgnoreCase("Chocolate")){
                chocolateCandies.add(candy);
            }
            if (candy.getType().isEmpty()){
                otherCandies.add(candy);

            }
        }

        return "Licorice: " + licoriceCandies.size()+ ", Chewing Gum: "+ chewingGumCandies.size()+ ", Bubble Gum: " + bubbleGumCandies.size() + ", Chocolate: " +chocolateCandies.size() + ", Other: " + otherCandies.size();

    }

    @RequestMapping(value = "/api/v1/candies", method = RequestMethod.POST)
    public ResponseEntity <Candy> createCandy(@RequestBody Candy candy){
        candy = candyRepository.save(candy);
        return new ResponseEntity<>(candy, HttpStatus.CREATED);

    }
    @RequestMapping(value = "/api/v1/candies/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Candy> updateCandy(@RequestBody Candy candy){
        var candyToUpdate = candyRepository.findById(candy.getId()).get();
        candyToUpdate.setId(candy.getId());
        candyToUpdate.setName(candy.getName());
        candyToUpdate.setType(candy.getType());
        candyToUpdate.setWeightPerUnit(candy.getWeightPerUnit());
        candyToUpdate.setCostPerUnit(candy.getCostPerUnit());

        candyRepository.save(candyToUpdate);

        return new ResponseEntity<>(candyToUpdate, HttpStatus.OK);
    }

    @RequestMapping (value = "/api/v1/candies/{id}")
    public String deleteCandy(@PathVariable String id){
        candyRepository.deleteById(Integer.parseInt(id));
        return "Candy with id " + id + " was deleted";
    }
}
