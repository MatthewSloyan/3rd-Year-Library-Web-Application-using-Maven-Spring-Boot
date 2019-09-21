package com.sales.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sales.models.Customer;

/**
* Customer repository which implements methods used to get, save, update and delete data from the MySQL database
*
* @author Matthew Sloyan G00348036
*/
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{

}
