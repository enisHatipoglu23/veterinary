package management.system.veterinary.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import management.system.veterinary.business.abstracts.AnimalService;
import management.system.veterinary.business.abstracts.AppointmentService;
import management.system.veterinary.core.config.modelMapper.ModelMapperService;
import management.system.veterinary.core.result.Result;
import management.system.veterinary.core.result.ResultData;
import management.system.veterinary.core.utils.ResultHelper;
import management.system.veterinary.dto.requests.animal.AnimalSaveRequest;
import management.system.veterinary.dto.requests.animal.AnimalUpdateRequest;
import management.system.veterinary.dto.requests.appointment.AppointmentSaveRequest;
import management.system.veterinary.dto.requests.appointment.AppointmentUpdateRequest;
import management.system.veterinary.dto.responses.animal.AnimalResponse;
import management.system.veterinary.dto.responses.appointment.AppointmentResponse;
import management.system.veterinary.dto.responses.customer.CustomerResponse;
import management.system.veterinary.entities.Animal;
import management.system.veterinary.entities.Appointment;
import management.system.veterinary.entities.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;
    private final ModelMapperService modelMapper;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AppointmentResponse> save (@Valid @RequestBody AppointmentSaveRequest appointmentSaveRequest){
        Appointment saveAppointment = this.modelMapper.forRequest().map(appointmentSaveRequest, Appointment.class);
        this.appointmentService.save(saveAppointment);
        AppointmentResponse appointmentResponse = this.modelMapper.forResponse().map(saveAppointment, AppointmentResponse.class);
        return ResultHelper.created(appointmentResponse);
    }

    @GetMapping("/filter")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<AppointmentResponse>> filterByAnimalName(
            @RequestParam("startDate") LocalDate startDate,
            @RequestParam("endDate") LocalDate endDate,
            @RequestParam("animalName") String animalName){
        List<Appointment> appointmentList = this.appointmentService.getByDateBetweenAndAnimalName(startDate, endDate, animalName);
        List<AppointmentResponse> appointmentResponseList = appointmentList.stream()
                .map(appointment -> modelMapper.forResponse().map(appointment, AppointmentResponse.class)).toList();
        return ResultHelper.success(appointmentResponseList);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AppointmentResponse> update(@Valid @RequestBody AppointmentUpdateRequest appointmentUpdateRequest){
        Appointment updateAppointment = this.modelMapper.forRequest().map(appointmentUpdateRequest, Appointment.class);
        this.appointmentService.save(updateAppointment);
        AppointmentResponse appointmentResponse = this.modelMapper.forResponse().map(updateAppointment, AppointmentResponse.class);
        return ResultHelper.created(appointmentResponse);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") long id){
        this.appointmentService.delete(id);
        return ResultHelper.deletionSuccess();
    }
}
