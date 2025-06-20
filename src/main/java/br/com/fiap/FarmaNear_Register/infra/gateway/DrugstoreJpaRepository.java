package br.com.fiap.FarmaNear_Register.infra.gateway;

import br.com.fiap.FarmaNear_Register.controller.dto.AddressDto;
import br.com.fiap.FarmaNear_Register.controller.dto.DrugstoreDto;
import br.com.fiap.FarmaNear_Register.controller.dto.ProductDto;
import br.com.fiap.FarmaNear_Register.entities.address.Address;
import br.com.fiap.FarmaNear_Register.entities.drugstore.Drugstore;
import br.com.fiap.FarmaNear_Register.infra.repository.address.AddressEntity;
import br.com.fiap.FarmaNear_Register.infra.repository.drugstore.DrugstoreEntity;
import br.com.fiap.FarmaNear_Register.infra.repository.drugstore.DrugstoreRepository;
import br.com.fiap.FarmaNear_Register.interfaces.IDrugstoreJpaGateway;
import org.springframework.stereotype.Service;

@Service
public class DrugstoreJpaRepository implements IDrugstoreJpaGateway {

    private final DrugstoreRepository repository;

    public DrugstoreJpaRepository(DrugstoreRepository repository) {
        this.repository = repository;
    }

    public DrugstoreDto createDrugstore(DrugstoreDto drugstoreDto) {
        AddressDto addressDto = drugstoreDto.address();
        Address address = new Address(addressDto.street(), addressDto.number(), addressDto.complement(),
                addressDto.city(), addressDto.state(), addressDto.zipCode());

        Drugstore drugstore = new Drugstore(drugstoreDto.cnpj(), drugstoreDto.name(), drugstoreDto.email(),
                drugstoreDto.phone(), address);

        DrugstoreEntity drugstoreEntity = repository.save(drugstore.createDrugstore());

        AddressEntity addressEntity = drugstoreEntity.getAddress();
        AddressDto drugstoreAddress = new AddressDto(addressEntity.getStreet(), addressEntity.getNumber(),
                addressEntity.getComplement(), addressEntity.getCity(), addressEntity.getState(), addressEntity.getZipCode());

        return new DrugstoreDto(drugstoreEntity.getId(), drugstoreEntity.getCnpj(), drugstoreEntity.getName(),
                drugstoreEntity.getEmail(), drugstoreEntity.getPhone(), drugstoreAddress);
    }
}
