package com.myshop.address;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import com.myshop.common.entity.Country;
import com.myshop.common.entity.ShippingRate;
import com.myshop.shipping.ShippingRateRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ShippingRateRepositoryTests {

    @Autowired
    private ShippingRateRepository repo;

   @Test
    public void testFindByCountryAndState(){
       Country country = new Country(234);
       String state = "New York";
       ShippingRate shippingRate = repo.findByCountryAndState(country, state);
       assertThat(shippingRate).isNotNull();
       System.out.println(shippingRate);
   }
}
