package management.system.veterinary.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import management.system.veterinary.business.abstracts.AnimalService;
import management.system.veterinary.core.config.modelMapper.ModelMapperService;
import management.system.veterinary.core.result.Result;
import management.system.veterinary.core.result.ResultData;
import management.system.veterinary.core.utils.ResultHelper;
import management.system.veterinary.dto.requests.animal.AnimalSaveRequest;
import management.system.veterinary.dto.requests.animal.AnimalUpdateRequest;
import management.system.veterinary.dto.responses.animal.AnimalResponse;
import management.system.veterinary.entities.Animal;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/animals")
@RequiredArgsConstructor
public class AnimalController {
    private final AnimalService animalService;
    private final ModelMapperService modelMapper;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AnimalResponse> save (@Valid @RequestBody AnimalSaveRequest animalSaveRequest){
        Animal saveAnimal = this.modelMapper.forRequest().map(animalSaveRequest, Animal.class);
        this.animalService.save(saveAnimal);
        AnimalResponse animalResponse = this.modelMapper.forResponse().map(saveAnimal, AnimalResponse.class);
        return ResultHelper.created(animalResponse);
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AnimalResponse> getById(@PathVariable("id") long id){
        Animal animal = this.animalService.get(id);
        AnimalResponse animalResponse = this.modelMapper
                .forResponse()
                .map(animal,AnimalResponse.class);
        return ResultHelper.success(animalResponse);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AnimalResponse> getByName(@PathVariable("name") String name){
        Animal animal = this.animalService.getByName(name);
        AnimalResponse animalResponse = this.modelMapper
                .forResponse()
                .map(animal,AnimalResponse.class);
        return ResultHelper.success(animalResponse);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AnimalResponse> update(@Valid @RequestBody AnimalUpdateRequest animalUpdateRequest){
        Animal updateAnimal = this.modelMapper.forRequest().map(animalUpdateRequest, Animal.class);
        this.animalService.save(updateAnimal);
        AnimalResponse animalResponse = this.modelMapper.forResponse().map(updateAnimal, AnimalResponse.class);
        return ResultHelper.created(animalResponse);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") long id){
        this.animalService.delete(id);
        return ResultHelper.deletionSuccess();
    }
}
