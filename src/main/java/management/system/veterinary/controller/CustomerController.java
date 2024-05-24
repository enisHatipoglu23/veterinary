package management.system.veterinary.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import management.system.veterinary.business.abstracts.CustomerService;
import management.system.veterinary.core.config.modelMapper.ModelMapperService;
import management.system.veterinary.core.result.Result;
import management.system.veterinary.core.result.ResultData;
import management.system.veterinary.core.utils.ResultHelper;
import management.system.veterinary.dto.requests.customer.CustomerSaveRequest;
import management.system.veterinary.dto.requests.customer.CustomerUpdateRequest;
import management.system.veterinary.dto.responses.customer.CustomerResponse;
import management.system.veterinary.entities.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final ModelMapperService modelMapper;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<CustomerResponse> save (@Valid @RequestBody CustomerSaveRequest customerSaveRequest){
        Customer saveCustomer = this.modelMapper.forRequest().map(customerSaveRequest, Customer.class);
        this.customerService.save(saveCustomer);
        CustomerResponse customerResponse = this.modelMapper.forResponse().map(saveCustomer, CustomerResponse.class);
        return ResultHelper.created(customerResponse);
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CustomerResponse> getById(@PathVariable("id") long id){
        Customer customer = this.customerService.get(id);
        CustomerResponse customerResponse = this.modelMapper
                .forResponse()
                .map(customer,CustomerResponse.class);
        return ResultHelper.success(customerResponse);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CustomerResponse> getByName(@PathVariable("name") String name){
        Customer customer = this.customerService.getByName(name);
        CustomerResponse customerResponse = this.modelMapper
                .forResponse()
                .map(customer,CustomerResponse.class);
        return ResultHelper.success(customerResponse);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<CustomerResponse> update(@Valid @RequestBody CustomerUpdateRequest customerUpdateRequest){
        Customer updateCustomer = this.modelMapper.forRequest().map(customerUpdateRequest, Customer.class);
        this.customerService.update(updateCustomer);
        CustomerResponse customerResponse = this.modelMapper.forResponse().map(updateCustomer, CustomerResponse.class);
        return ResultHelper.created(customerResponse);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") long id){
        this.customerService.delete(id);
        return ResultHelper.deletionSuccess();
    }
}
