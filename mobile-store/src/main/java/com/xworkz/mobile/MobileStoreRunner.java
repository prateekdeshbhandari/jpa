package com.xworkz.mobile;

import com.xworkz.mobile.dto.MobileStoreDTO;
import com.xworkz.mobile.service.MobileStoreService;
import com.xworkz.mobile.service.impl.MobileStoreServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class MobileStoreRunner {
    public static void main(String[] args) {
        MobileStoreDTO dto = new MobileStoreDTO(1, "iPhone 15", "Apple", 79999.00, "Black");

        MobileStoreService service = new MobileStoreServiceImpl();

        service.validateAndSave(dto);

        System.out.println("Data: " + dto);


        List<MobileStoreDTO> mobileStoreDTOs = new ArrayList<>();

        mobileStoreDTOs.add(new MobileStoreDTO(1, "iPhone 15", "Apple", 79999.00, "Black"));
        mobileStoreDTOs.add(new MobileStoreDTO(2, "Galaxy S24", "Samsung", 74999.00, "Gray"));
        mobileStoreDTOs.add(new MobileStoreDTO(3, "OnePlus 12", "OnePlus", 64999.00, "Green"));
        mobileStoreDTOs.add(new MobileStoreDTO(4, "Redmi Note 13", "Xiaomi", 19999.00, "Blue"));
        mobileStoreDTOs.add(new MobileStoreDTO(5, "Pixel 8", "Google", 69999.00, "White"));

        service.validateAndSaves(mobileStoreDTOs);


        MobileStoreDTO readById = service.findReadSaveId(1);

        System.out.println("Read by ID: " + readById);

        List<MobileStoreDTO> allMobiles = service.readAllMobileStores();
        System.out.println("All Mobile Stores:");
        allMobiles.forEach(a-> System.out.println(a));

        MobileStoreDTO mobileByBrand = service.findReadSaveByBrand("Apple");
        System.out.println("Mobile By Brand: " + mobileByBrand);


        MobileStoreDTO mobileByIdAndName = service.findReadSaveTwoParameter(1, "iPhone 15");
        System.out.println("Mobile By ID and Name: " + mobileByIdAndName);

        List<MobileStoreDTO> mobilesByIdAndColor = service.findAllMobileStoreTwoParameter(1, "Black");
        mobilesByIdAndColor.forEach(a -> System.out.println(a));

        List<MobileStoreDTO> mobilesByPriceAndBrand = service.findAllMobileStoreTwoParameters(74999.00, "Samsung");
        mobilesByPriceAndBrand.forEach(a -> System.out.println(a));
    }
}
