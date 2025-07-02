package br.com.fiap.FarmaNear_Register.usecases;

import br.com.fiap.FarmaNear_Register.controller.dto.DrugstoreDto;
import br.com.fiap.FarmaNear_Register.controller.dto.GetDrugstoreByProductDto;
import br.com.fiap.FarmaNear_Register.interfaces.IProductJpaGateway;

import java.util.ArrayList;
import java.util.List;

public class GetDrugstoreByProductsUseCase {

    private final IProductJpaGateway productJpaGateway;

    public GetDrugstoreByProductsUseCase(IProductJpaGateway productJpaGateway) {
        this.productJpaGateway = productJpaGateway;
    }

    public GetDrugstoreByProductDto getProduct(String productName) {
        validatesName(productName);
        List<DrugstoreDto> drugstoreDtoList = new ArrayList<>();

        var drugstores = productJpaGateway.getDrugstoreByProduct(productName);
        drugstores.forEach(drugstoreEntity -> {
            DrugstoreDto drugstoreDto = new DrugstoreDto(drugstoreEntity.getId(), drugstoreEntity.getCnpj(),
                    drugstoreEntity.getName(), drugstoreEntity.getEmail(), drugstoreEntity.getPhone());
            drugstoreDtoList.add(drugstoreDto);
        });
        return new GetDrugstoreByProductDto(productName, drugstoreDtoList);
    }

    private void validatesName(String productName) {
        if (productName == null) {
            throw new IllegalArgumentException("Product name cannot be null");
        }
    }
}
