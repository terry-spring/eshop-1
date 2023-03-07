package main.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import main.model.Customer;

@SuppressWarnings("deprecation")
@Repository
public interface CustomerRepository  extends JpaRepository<Customer,Long>{

    
	@Query("from User u where u.userId = :userId")
	List<Customer> getByUserId(@Param("userId")long userId);
	
	
	
	
}
