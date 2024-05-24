package management.system.veterinary.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import management.system.veterinary.business.abstracts.AvailableDateService;
import management.system.veterinary.core.config.modelMapper.ModelMapperService;
import management.system.veterinary.core.result.Result;
import management.system.veterinary.core.result.ResultData;
import management.system.veterinary.core.utils.ResultHelper;
import management.system.veterinary.dto.requests.availableDate.AvailableDateSaveRequest;
import management.system.veterinary.dto.requests.availableDate.AvailableDateUpdateRequest;
import management.system.veterinary.dto.responses.availableDate.AvailableDateResponse;
import management.system.veterinary.entities.AvailableDate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/available_date")
@RequiredArgsConstructor
public class AvailableDateController {

    private final AvailableDateService availableDateService;
    private final ModelMapperService modelMapper;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AvailableDateResponse> save (@Valid @RequestBody AvailableDateSaveRequest availableDateSaveRequest){
        AvailableDate saveAvailableDate = this.modelMapper.forRequest().map(availableDateSaveRequest, AvailableDate.class);
        this.availableDateService.save(saveAvailableDate);
        AvailableDateResponse availableDateResponse = this.modelMapper.forResponse().map(saveAvailableDate, AvailableDateResponse.class);
        return ResultHelper.created(availableDateResponse);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AvailableDateResponse> update(@Valid @RequestBody AvailableDateUpdateRequest availableDateUpdateRequest){
        AvailableDate updateAvailableDate = this.modelMapper.forRequest().map(availableDateUpdateRequest, AvailableDate.class);
        this.availableDateService.save(updateAvailableDate);
        AvailableDateResponse availableDateResponse = this.modelMapper.forResponse().map(updateAvailableDate, AvailableDateResponse.class);
        return ResultHelper.created(availableDateResponse);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") long id){
        this.availableDateService.delete(id);
        return ResultHelper.deletionSuccess();
    }


}
