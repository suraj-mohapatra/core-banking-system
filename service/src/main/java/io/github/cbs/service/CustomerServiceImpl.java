package io.github.cbs.service;

import io.github.cbs.domain.entity.Customer;
import io.github.cbs.domain.repository.CustomerRepository;
import io.github.cbs.service.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.cbs.dto.req.CustomerReq;
import io.github.cbs.dto.res.CustomerRes;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService {

    final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    /**
     * @param req
     * @return
     */
    @Override
    public CustomerRes createCustomer(CustomerReq req) {

        try {
            Customer entity = customerMapper.toEntity(req);

            Customer saved = customerRepository.save(entity);

            return customerMapper.toResponse(saved);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
     * @param customerId
     * @return
     */
    @Override
    public CustomerRes getCustomerById(Long customerId) {
        return null;
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