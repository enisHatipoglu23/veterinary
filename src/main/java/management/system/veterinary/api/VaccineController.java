package management.system.veterinary.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import management.system.veterinary.business.abstracts.VaccineService;
import management.system.veterinary.core.config.modelMapper.ModelMapperService;
import management.system.veterinary.core.result.Result;
import management.system.veterinary.core.result.ResultData;
import management.system.veterinary.core.utils.ResultHelper;
import management.system.veterinary.dto.requests.vaccine.VaccineSaveRequest;
import management.system.veterinary.dto.requests.vaccine.VaccineUpdateRequest;
import management.system.veterinary.dto.responses.animal.AnimalResponse;
import management.system.veterinary.dto.responses.appointment.AppointmentResponse;
import management.system.veterinary.dto.responses.vaccine.VaccineResponse;
import management.system.veterinary.entities.Animal;
import management.system.veterinary.entities.Appointment;
import management.system.veterinary.entities.Vaccine;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/vaccines")
@RequiredArgsConstructor
public class VaccineController {
    private final VaccineService vaccineService;
    private final ModelMapperService modelMapper;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<VaccineResponse> save(@Valid @RequestBody VaccineSaveRequest vaccineSaveRequest){
        Vaccine saveVaccine = this.modelMapper.forRequest().map(vaccineSaveRequest, Vaccine.class);
        this.vaccineService.save(saveVaccine);
        VaccineResponse vaccineResponse = this.modelMapper.forResponse().map(saveVaccine, VaccineResponse.class);
        return ResultHelper.created(vaccineResponse);
    }

    @GetMapping("/vaccine_id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<VaccineResponse> getById(@PathVariable long id){
        Vaccine vaccine = this.vaccineService.getById(id);
        VaccineResponse vaccineResponse = this.modelMapper.forResponse().map(vaccine,VaccineResponse.class);
        return ResultHelper.success(vaccineResponse);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<VaccineResponse> update(@Valid @RequestBody VaccineUpdateRequest vaccineUpdateRequest){
        Vaccine updateVaccine = this.modelMapper.forRequest().map(vaccineUpdateRequest, Vaccine.class);
        this.vaccineService.save(updateVaccine);
        VaccineResponse vaccineResponse = this.modelMapper.forResponse().map(updateVaccine, VaccineResponse.class);
        return ResultHelper.created(vaccineResponse);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") long id){
        this.vaccineService.delete(id);
        return ResultHelper.deletionSuccess();
    }

    @GetMapping("/filter")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<VaccineResponse>> getByName(@RequestParam("animalName") String animalName){
        List<Vaccine> vaccineList = this.vaccineService.getAllByAnimalName(animalName);
        List<VaccineResponse> vaccineResponseList = vaccineList
                .stream()
                .map(vaccine -> modelMapper.forResponse().map(vaccine, VaccineResponse.class))
                .toList();
        return ResultHelper.success(vaccineResponseList);
    }

    @GetMapping("/filter/date")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<VaccineResponse>> filterByAnimalName(
            @RequestParam("startDate") LocalDate startDate,
            @RequestParam("endDate") LocalDate endDate){
        List<Vaccine> vaccineList = this.vaccineService.getVaccinesExpiringBetween(startDate, endDate);
        List<VaccineResponse> vaccineResponseList = vaccineList.stream()
                .map(vaccine -> modelMapper.forResponse().map(vaccine, VaccineResponse.class)).toList();
        return ResultHelper.success(vaccineResponseList);
    }

}
