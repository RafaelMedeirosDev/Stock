package com.estudos.stock.services.reports;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.stock.domains.Movement;
import com.estudos.stock.respositories.MovementRepository;
import com.estudos.stock.shared.dtos.ProductExitReportDto;
import com.estudos.stock.shared.enums.MovementTypeEnum;

@Service
public class ProductsWithMoreOutputsService {

    @Autowired
    private MovementRepository movementRepository;

    public List<ProductExitReportDto> execute() {
        List<Movement> allMovements = movementRepository.findAll();

        List<Movement> exitMovements = allMovements.stream()
                .filter(movement -> movement.getMovementType() == MovementTypeEnum.EXIT)
                .toList();
            
        Map<String, Integer> productExitTotals = new HashMap<>();

        for (Movement movement : exitMovements) {

            String productName = movement.getProductId().getName();
            int quantity = movement.getAmount();

            productExitTotals.put(productName, productExitTotals.getOrDefault(productName, 0) + quantity);
        }

        List<ProductExitReportDto> result = productExitTotals.entrySet().stream()
                .map(entry -> new ProductExitReportDto(entry.getKey(), entry.getValue()))
                .sorted(Comparator.comparingInt(ProductExitReportDto::getTotalExits).reversed())
                .toList();

                return result;
    }
}
