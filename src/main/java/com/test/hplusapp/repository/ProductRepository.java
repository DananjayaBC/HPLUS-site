package com.test.hplusapp.repository;

import com.test.hplusapp.beans.product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<product ,Integer>{

   @Query("select p from product p where p.name like %:name%")
    public List<product> searchByName(@Param("name") String name);
}
