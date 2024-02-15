package com.prueba.mscomprabootcoin.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "bootCoin")
@Builder
public class BootCoin {
    private static final long serialVersionUID = 1L;

    @JsonSerialize(using = ToStringSerializer.class)
    @Id
    private ObjectId id;

    @Valid
    private String transactionNumber;

    @Valid
    private String documentNumber;

    @Valid
    private String cellphone;

    @Valid
    private String email;

    @Valid
    private BigDecimal amount;

    @Valid
    private String payMode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Valid
    private String accountNumber;


}
