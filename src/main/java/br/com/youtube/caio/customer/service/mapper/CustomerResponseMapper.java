package br.com.youtube.caio.customer.service.mapper;

import br.com.youtube.caio.customer.model.response.CustomerResponse;
import br.com.youtube.caio.customer.persistence.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerResponseMapper implements Mapper<Customer, CustomerResponse> {
    @Override
    public CustomerResponse map(Customer input) {
        if(input == null) {
            return null;
        }

        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setId(input.getId());
        customerResponse.setName(input.getName());
        customerResponse.setDocument(input.getDocument());

        return customerResponse;
    }
}
