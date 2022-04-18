package br.com.youtube.caio.customer.service;

import br.com.youtube.caio.customer.model.request.CustomerRequest;
import br.com.youtube.caio.customer.model.response.CustomerResponse;
import br.com.youtube.caio.customer.persistence.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CustomerService {

    CustomerResponse create(CustomerRequest customerRequest);

    Page<CustomerResponse> getAll(Pageable pageable);

    Optional<CustomerResponse> update(Long id, CustomerRequest customerRequest);

    Optional<CustomerResponse> get(Long id);

    boolean delete(Long id);
}
