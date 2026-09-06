package io.github.cbs.service;

import io.github.cbs.domain.entity.Customer;
import io.github.cbs.domain.repository.CustomerRepository;
import io.github.cbs.dto.req.CustomerReq;
import io.github.cbs.dto.res.CustomerRes;
import io.github.cbs.exception.BusinessException;
import io.github.cbs.exception.CustomerAlreadyExistsException;
import io.github.cbs.service.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    /**
     * @param req Customer creation request
     * @return Created customer response
     */
    @Override
    public CustomerRes createCustomer(CustomerReq req) {
        if (customerRepository.existsByEmail(req.getEmail())) {
            throw new CustomerAlreadyExistsException(
                    "Customer with email '" + req.getEmail() + "' already exists");
        }

        if (customerRepository.existsByPhoneNumber(req.getPhoneNumber())) {
            throw new CustomerAlreadyExistsException(
                    "Customer with phone number '" + req.getPhoneNumber() + "' already exists");
        }

        Customer entity = customerMapper.toEntity(req);
        Customer saved = customerRepository.save(entity);

        return customerMapper.toResponse(saved);
    }

    /**
     * @param customerId
     * @param request
     * @return
     */
    @Override
    public CustomerRes updateCustomer(Long customerId, CustomerReq request) {
        return null;
    }

    /**
     * @param customerId Customer ID
     * @return Customer response
     */
    @Override
    @Transactional(readOnly = true)
    public CustomerRes getCustomerById(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new BusinessException("Customer with ID " + customerId + " not found"));
        return customerMapper.toResponse(customer);
    }

    /**
     * @param request
     * @return
     */
    @Override
    public List<CustomerRes> searchCustomers(CustomerReq request) {
        return List.of();
    }

    /**
     * @param customerId
     */
    @Override
    public void deactivateCustomer(Long customerId) {

    }

}
