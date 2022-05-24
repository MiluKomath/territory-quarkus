package com.territory.territory;

import org.mapstruct.Mapper;

import java.util.List;

import com.territory.territory.util.QuarkusMappingConfig;

@Mapper(config = QuarkusMappingConfig.class)
public interface TerritoryTransformer {
	Territory toResource(TerritoryEntity territoryEntity);

	List<Territory> map(List<TerritoryEntity> territoryEntityList);

	TerritoryEntity toEntity(Territory territory);

}
