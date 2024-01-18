package com.leron.api.controller;

import com.leron.api.model.DTO.entrance.EntranceRequest;
import com.leron.api.model.DTO.entrance.EntranceResponse;
import com.leron.api.model.DTO.graphic.GraphicResponse;
import com.leron.api.responses.ApplicationBusinessException;
import com.leron.api.responses.DataListResponse;
import com.leron.api.responses.DataResponse;

import com.leron.api.service.entrance.EntranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/entrance")
public class EntranceController {
    @Autowired
    private EntranceService service;

    @PostMapping
    public DataResponse<EntranceResponse> create(@RequestBody List<EntranceRequest> requestDTO,
                                                     @RequestHeader(name = "locale", required = false) String locale,
                                                     @RequestHeader(name = "Authorization", required = false) String authorization) throws ApplicationBusinessException {

        DataResponse<EntranceResponse> response = new DataResponse<>();
        try {
            response = service.create(requestDTO, locale, authorization);
        } catch (ApplicationBusinessException error) {
            response.setResponse(error);
        }
        return response;

    }

    @GetMapping("data/{userAuthId}/{month}/{year}/{owners}")
    public DataResponse<GraphicResponse> getProgramsData(@PathVariable(value = "userAuthId", required = true) Long userAuthId,
                                                         @PathVariable(value = "month", required = true) int month,
                                                         @PathVariable(value = "year", required = true) int year,
                                                         @PathVariable(value = "owners", required = true) List<Long> owners) {
        return service.getData(userAuthId, month, year, owners);
    }

    @GetMapping("/{userAuthId}/{month}/{year}/{owners}")
    public DataListResponse<EntranceResponse> list(@PathVariable(value = "userAuthId", required = true) Long userAuthId,
                                                   @PathVariable(value = "month", required = true) int month,
                                                   @PathVariable(value = "year", required = true) int year,
                                                   @PathVariable(value = "owners", required = true) List<Long> owners) {
        return service.list(userAuthId, month, year, owners);
    }

    @GetMapping("/{userAuthId}")
    public DataListResponse<EntranceResponse> listWithFilters(@PathVariable(value = "userAuthId", required = true) Long userAuthId) {
        return service.list(userAuthId);
    }

    @DeleteMapping("/{id}")
    public DataResponse<EntranceResponse> delete(@PathVariable Long id)  {
        return service.delete(id);
    }
}
