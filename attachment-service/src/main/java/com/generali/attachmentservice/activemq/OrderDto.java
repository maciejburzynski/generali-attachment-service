package com.generali.attachmentservice.activemq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {


    private Long monitorId;
    private Long laptopId;
    private Long customerId;

}
