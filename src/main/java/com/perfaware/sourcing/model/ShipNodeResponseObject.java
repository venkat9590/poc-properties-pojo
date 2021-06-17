package com.perfaware.sourcing.model;

import java.util.List;

import com.perfaware.sourcing.persistence.table.ShipNodeTable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ShipNodeResponseObject {
	
	ShipNodeTable shipNodeList;

}
