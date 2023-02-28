package com.leron.api.validator.salary;

import com.leron.api.model.DTO.salary.SalaryRequest;
import com.leron.api.responses.ApplicationBusinessException;
import com.leron.api.responses.DataRequest;
import org.springframework.stereotype.Component;

@Component
public class SalaryValidator {
    public static void validatorSalary(DataRequest<SalaryRequest> salaryRequest) throws ApplicationBusinessException {
        if(salaryRequest.getData().getUserId() == null){
            throw new ApplicationBusinessException("Lascou", "user");
        }
        if(salaryRequest.getData().getName().isEmpty()){
            throw new ApplicationBusinessException("Lascou", "name");
        }
        if(salaryRequest.getData().getPrice() == null){
            throw new ApplicationBusinessException("Lascou", "price");
        }

    }
}