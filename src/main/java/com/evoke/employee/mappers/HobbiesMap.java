package com.evoke.employee.mappers;

import com.evoke.employee.dto.HobbiesDto;
import com.evoke.employee.model.Hobbies;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class HobbiesMap {

   public HobbiesDto toDto(Hobbies hobbies){
       HobbiesDto hobbiesDto=new HobbiesDto();

       hobbiesDto.setId(hobbies.getId());
       hobbiesDto.setHobby(hobbies.getHobby());
       return  hobbiesDto;
    }
}
