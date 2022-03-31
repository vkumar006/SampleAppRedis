package com.philips.redis.controller;
import com.philips.redis.entity.Product;
import com.philips.redis.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/product")
@EnableCaching
public class ProductController {
    @Autowired
    private ProductRepo repo;

    @PostMapping
    public String save(@RequestBody Product product){
        String message;
        Product pro=repo.findProductById(product.getId());
        if(ObjectUtils.isEmpty(pro)){
            repo.save(product);
            message="Product added successfully with id: "+product.getId()+" ||";
        }else{
            message="Product already exist with id: "+product.getId()+" ||";
        }
        return message;
    }
    @GetMapping
    public List<Product> getAllProduct(){
        return repo.findAll();
    }
    @GetMapping("/{id}")
    @Cacheable(key = "#id", value = "Product")//, unless = "#result.price > 1000"
    public String findProduct(@PathVariable int id){
        Product pro=repo.findProductById(id);
        if(!ObjectUtils.isEmpty(pro)){
           return pro.toString();
        }else{
            return "No record available for id: "+id;
        }

    }
    @DeleteMapping("/{id}")
    @CacheEvict(key = "#id", value = "Product")
    public String removeProduct(@PathVariable int id){
        Product pro=repo.findProductById(id);
        if(!ObjectUtils.isEmpty(pro)){
            return repo.deleteById(id);
        }else{
            return "No record available for id: "+id;
        }
    }

}
