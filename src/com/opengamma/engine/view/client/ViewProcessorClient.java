/**
 * Copyright (C) 2009 - 2010 by OpenGamma Inc.
 *
 * Please see distribution for license.
 */
package com.opengamma.engine.view.client;

import java.util.Set;

import com.opengamma.engine.view.ViewDefinition;

/**
 * 
 *
 * @author kirk
 */
public interface ViewProcessorClient {
  
  /**
   * True iff this view processor is capable of supporting live computation of views.
   * 
   * @return
   */
  boolean isLiveComputationSupported();
  
  /**
   * True iff this view processor allows one-off view computation jobs to be provided.
   * 
   * @return
   */
  boolean isOneOffComputationSupported();
  
  Set<String> getAvailableViewNames();
  
  Set<String> getLiveComputingViewNames();
  
  ViewClient getView(String viewName);
  
  void startLiveCalculation(String viewName);
  
  void stopLiveCalculation(String viewName);
  
  // REVIEW jim 26-Apr-2010 -- should really allow access to view definition repository.
  ViewDefinition getViewDefinition(String viewName);
}
