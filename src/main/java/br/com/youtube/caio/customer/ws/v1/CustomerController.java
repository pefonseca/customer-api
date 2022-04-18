package br.com.youtube.caio.customer.ws.v1;

import br.com.youtube.caio.customer.model.request.CustomerRequest;
import br.com.youtube.caio.customer.model.response.CustomerResponse;
import br.com.youtube.caio.customer.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponse> create(@RequestBody CustomerRequest customerRequest) {
        LOGGER.info("Requisição recebida");
        return ResponseEntity.ok(customerService.create(customerRequest));
    }

    @GetMapping
    public ResponseEntity<Page<CustomerResponse>> getAll(Pageable pageable) {
        LOGGER.info("Buscando os registros");
        Page<CustomerResponse> customerResponses = customerService.getAll(pageable);
        return ResponseEntity.ok(customerResponses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> update(@PathVariable("id") Long id, @RequestBody CustomerRequest customerRequest) {
        LOGGER.info("Iniciando a atualização");

        Optional<CustomerResponse> update = customerService.update(id, customerRequest);
        if(update.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(update.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> get(@PathVariable("id") Long id) {
        LOGGER.info("Iniciando a busca pelo registro");
        Optional<CustomerResponse> customerResponse = customerService.get(id);
        if(customerResponse.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(customerResponse.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        LOGGER.info("Iniciando a remoção do registro");
        if(customerService.delete(id)) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }
}
