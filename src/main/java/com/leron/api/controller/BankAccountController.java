package com.leron.api.controller;

import com.leron.api.model.DTO.bank.BankDTO;
import com.leron.api.model.DTO.bank.BankRequest;
import com.leron.api.model.DTO.bank.BankResponse;
import com.leron.api.model.DTO.bankAccount.BankAccountRequest;
import com.leron.api.model.DTO.bankAccount.BankAccountResponse;
import com.leron.api.responses.ApplicationBusinessException;
import com.leron.api.responses.DataListResponse;
import com.leron.api.responses.DataRequest;
import com.leron.api.responses.DataResponse;
import com.leron.api.service.bankAccount.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/bank-account")
public class BankAccountController {

    @Autowired
    BankAccountService bankAccountService;

    @GetMapping("")
    public DataListResponse<BankAccountResponse> list(){
        DataListResponse<BankAccountResponse> list = bankAccountService.list();
        return list;
    }

    @PostMapping(
            value = "",
            consumes = "application/json",
            produces = "application/json"
    )
    public DataResponse<BankAccountResponse> create(
            @RequestBody BankAccountRequest requestCreation,
            @RequestHeader(name = "locale", required = true) String locale,
            @RequestHeader(name = "Authorization", required = true) String authorization
    ) {

        DataRequest<BankAccountRequest> request = new DataRequest<>(requestCreation, locale, authorization);
        DataResponse<BankAccountResponse> response = new DataResponse<>();

        try {
            response = bankAccountService.create(request);
            return response;

        } catch (ApplicationBusinessException error){
            response.setResponse(error);
        }
        return response;
    }
}