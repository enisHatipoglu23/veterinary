package management.system.veterinary.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import management.system.veterinary.business.abstracts.DoctorService;
import management.system.veterinary.core.config.modelMapper.ModelMapperService;
import management.system.veterinary.core.result.Result;
import management.system.veterinary.core.result.ResultData;
import management.system.veterinary.core.utils.ResultHelper;
import management.system.veterinary.dto.requests.animal.AnimalSaveRequest;
import management.system.veterinary.dto.requests.animal.AnimalUpdateRequest;
import management.system.veterinary.dto.requests.doctor.DoctorSaveRequest;
import management.system.veterinary.dto.requests.doctor.DoctorUpdateRequest;
import management.system.veterinary.dto.responses.animal.AnimalResponse;
import management.system.veterinary.dto.responses.customer.CustomerResponse;
import management.system.veterinary.dto.responses.doctor.DoctorResponse;
import management.system.veterinary.entities.Animal;
import management.system.veterinary.entities.Customer;
import management.system.veterinary.entities.Doctor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/doctors")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;
    private final ModelMapperService modelMapper;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<DoctorResponse> save (@Valid @RequestBody DoctorSaveRequest doctorSaveRequest){
        Doctor saveDoctor = this.modelMapper.forRequest().map(doctorSaveRequest, Doctor.class);
        this.doctorService.save(saveDoctor);
        DoctorResponse doctorResponse = this.modelMapper.forResponse().map(saveDoctor, DoctorResponse.class);
        return ResultHelper.created(doctorResponse);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<DoctorResponse> getByName(@PathVariable("name") String name){
        Doctor doctor = this.doctorService.getByName(name);
        DoctorResponse doctorResponse = this.modelMapper
                .forResponse()
                .map(doctor,DoctorResponse.class);
        return ResultHelper.success(doctorResponse);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<DoctorResponse> update(@Valid @RequestBody DoctorUpdateRequest doctorUpdateRequest){
        Doctor updateDoctor = this.modelMapper.forRequest().map(doctorUpdateRequest, Doctor.class);
        this.doctorService.save(updateDoctor);
        DoctorResponse doctorResponse = this.modelMapper.forResponse().map(updateDoctor, DoctorResponse.class);
        return ResultHelper.created(doctorResponse);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") long id){
        this.doctorService.delete(id);
        return ResultHelper.deletionSuccess();
    }

}
