package com.prueba.mscomprabootcoin.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * .
 * <b>Enum</b>: EnumPayMode <br/>
 *
 * <u>Service Provider</u>: PruebaTest <br/>
 * <u>Developed by</u>: Diego Condezo <br/>
 * <u>Changes:</u><br/>
 * <ul>
 *   <li>
 *     Febrero 12, 2024 Creación de Clase.
 *   </li>
 * </ul>
 */
@Getter
@RequiredArgsConstructor
public enum EnumPayMode {
    TRANSFERENCIA("TRANSFERENCIA", 1),
    YANKI("YANKI", 2);

    private final String nombre;
    private final int code;

    /**
     * a.
     *
     * @param code a.
     * @return getByCode
     */
    public static EnumPayMode getByCode(int code) {
        return Arrays.stream(EnumPayMode.values())
                .filter(enumOperationType -> enumOperationType.getCode() == code)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "No EnumPayMode found with code: " + code));
    }

    /**
     * a.
     *
     * @param nombre a.
     * @return getByNombre
     */
    public static EnumPayMode getByNombre(String nombre) {
        return Arrays.stream(EnumPayMode.values())
                .filter(enumOperationType -> enumOperationType.getNombre().equals(nombre))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "No EnumPayMode found with code: " + nombre));
    }
}
