package org.example;

import org.example.dto.TvsMotorsDto;
import org.example.service.TvsService;
import org.example.service.impl.TvsServiceImpl;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class TvsRunner {
    public static void main(String[] args) {
        TvsMotorsDto dto=new TvsMotorsDto(1,"Apache RTR 160", "TVS", "Bike", 125000.00 );

        TvsService service=new TvsServiceImpl();
        service.validateAndSave(dto);
        System.out.println("data"+dto);


        List<TvsMotorsDto>tvsMotorsDtos=new ArrayList<>();
        tvsMotorsDtos.add(new TvsMotorsDto(1, "Apache RTR 160", "TVS", "Bike", 125000.00));
        tvsMotorsDtos.add(new TvsMotorsDto(2, "Apache RTR 200", "TVS", "Bike", 150000.00));
        tvsMotorsDtos.add(new TvsMotorsDto(3, "Apache RTR 310", "TVS", "Bike", 240000.00));
        tvsMotorsDtos.add(new TvsMotorsDto(4, "Raider 125", "TVS", "Bike", 95000.00));

        TvsService services = new TvsServiceImpl();

        service.validateAndSaves(tvsMotorsDtos);

TvsMotorsDto readById = service.findReadSaveId(1);
System.out.println("Read by ID: " + readById);

        List<TvsMotorsDto> allTvs = service.readAllTvs();

        System.out.println("All TVS Motors:");

        allTvs.forEach(aa->System.out.println(aa));
    }
}
