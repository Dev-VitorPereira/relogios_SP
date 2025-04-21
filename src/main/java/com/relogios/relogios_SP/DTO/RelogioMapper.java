package com.relogios.relogios_SP.DTO;

import com.relogios.relogios_SP.DTO.RelogioDTO;
import com.relogios.relogios_SP.model.Relogio;

public class RelogioMapper {

    public static RelogioDTO toDTO(Relogio relogio) {
        return new RelogioDTO(
                relogio.getId(),
                relogio.getNumberRelogio(),
                relogio.getAddressRelogio(),
                relogio.getLatitude(),
                relogio.getLongitude()
        );
    }

    public static Relogio toEntity(RelogioDTO dto) {
        return new Relogio(
                dto.id(),
                dto.numberRelogio(),
                dto.addressRelogio(),
                dto.longitude(),
                dto.latitude()
        );
    }
}
