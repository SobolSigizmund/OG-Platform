/**
 * Copyright (C) 2009 - 2010 by OpenGamma Inc.
 *
 * Please see distribution for license.
 */
package com.opengamma.financial;

import com.opengamma.engine.world.Region;
import com.opengamma.engine.world.RegionSource;
import com.opengamma.id.Identifier;
import com.opengamma.id.IdentifierBundle;
import com.opengamma.id.UniqueIdentifier;

/**
 * Default implementation of RegionSource that uses a RegionMaster as the underlying data source.
 */
public class DefaultRegionSource implements RegionSource {
  private RegionMaster _regionMaster;
  
  public DefaultRegionSource(RegionMaster regionMaster) {
    _regionMaster = regionMaster;
  }
  @Override
  public Region getHighestLevelRegion(Identifier regionId) {
    RegionSearchRequest searchReq = new RegionSearchRequest(RegionMaster.POLITICAL_HIERARCHY_NAME, regionId);
    searchReq.setGraphIncluded(true);
    return _regionMaster.searchRegions(searchReq).getBestResult();
  }
  @Override
  public Region getHighestLevelRegion(IdentifierBundle regionIdentifiers) {
    RegionSearchRequest searchReq = new RegionSearchRequest(RegionMaster.POLITICAL_HIERARCHY_NAME, regionIdentifiers);
    searchReq.setGraphIncluded(true);
    return _regionMaster.searchRegions(searchReq).getBestResult();
  }
  @Override
  public Region getRegion(UniqueIdentifier regionUniqueId) {
    return _regionMaster.getRegion(regionUniqueId);
  }

}
