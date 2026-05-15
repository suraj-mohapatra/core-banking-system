package io.github.cbs.service;

import io.github.cbs.domain.entity.Customer;
import io.github.cbs.domain.repository.CustomerRepository;
import io.github.cbs.service.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.cbs.dto.req.CustomerReq;
import io.github.cbs.dto.res.CustomerRes;


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

}