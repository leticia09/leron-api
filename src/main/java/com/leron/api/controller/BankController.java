package com.leron.api.controller;

import com.leron.api.model.DTO.bank.BankRequest;
import com.leron.api.model.DTO.bank.BankResponse;
import com.leron.api.responses.ApplicationBusinessException;
import com.leron.api.responses.DataListResponse;
import com.leron.api.responses.DataRequest;
import com.leron.api.responses.DataResponse;
import com.leron.api.service.bank.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/bank")
public class BankController {

    @Autowired
    BankService bankService;

    @GetMapping("/{userAuthId}")
    public DataListResponse<BankResponse> list(@PathVariable(value = "userAuthId", required = true) Long userAuthId){
        DataListResponse<BankResponse> list = bankService.list(userAuthId);
        return list;
    }

    @PostMapping(
            value = "",
            consumes = "application/json",
            produces = "application/json"
    )
    public DataResponse<BankResponse> create(
            @RequestBody BankRequest requestCreation,
            @RequestHeader(name = "locale", required = true) String locale,
            @RequestHeader(name = "Authorization", required = true) String authorization
    ) {

        DataRequest<BankRequest> request = new DataRequest<>(requestCreation, locale, authorization);
        DataResponse<BankResponse> response = new DataResponse<>();

        try {
            response = bankService.create(request);
            return response;

        } catch (ApplicationBusinessException error){
            response.setResponse(error);
        }
        return response;
    }
}
