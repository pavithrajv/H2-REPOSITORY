package com.example.H2.controller;

import com.example.H2.model.Items;
import com.example.H2.repository.ItemRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public class ItemController {
    @Autowired
    ItemRepository itemRepo;



    @RequestMapping("/getAllItems")
    @ResponseBody
    public List<Items> getAllItems(){
        return itemRepo.getAllItems();
    }

    @RequestMapping("/getItem")
    @ResponseBody
    public Items getItem(@RequestParam("itemId") int itemId){
        return itemRepo.getItem(itemId);
    }

    @RequestMapping("/addItem")
    @ResponseBody
    public String addItem(@RequestParam("id") int id,@RequestParam("name") String name,
                          @RequestParam("category") String category){
        if(itemRepo.addItem(id,name,category) >= 1){
            return "Item Added Successfully";
        }else{
            return "Something went wrong !";
        }
    }
    @RequestMapping("/deteteItem")
    @ResponseBody
    public String deteteItem(@RequestParam("itemId") int itemId){
        if(itemRepo.deleteItem(itemId) >= 1){
            return "Item Deleted Successfully";
        }else{
            return "Something went wrong !";
        }
    }

}
