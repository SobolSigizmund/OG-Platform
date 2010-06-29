/**
 * Copyright (C) 2009 - 2010 by OpenGamma Inc.
 *
 * Please see distribution for license.
 */
package com.opengamma.financial.view.memory;

import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;

import org.apache.commons.lang.Validate;

import com.opengamma.DataNotFoundException;
import com.opengamma.engine.view.ViewDefinition;
import com.opengamma.financial.view.AddViewDefinitionRequest;
import com.opengamma.financial.view.ManagableViewDefinitionRepository;
import com.opengamma.financial.view.UpdateViewDefinitionRequest;

/**
 * A simple, in-memory implementation of {@link ManagableViewDefinitionRepository}.
 */
public class InMemoryViewDefinitionRepository implements ManagableViewDefinitionRepository {

  private final ConcurrentMap<String, ViewDefinition> _definitionsByName = new ConcurrentSkipListMap<String, ViewDefinition>();
  
  //-------------------------------------------------------------------------
  // ViewDefinitionRepository implementation
  @Override
  public ViewDefinition getDefinition(String definitionName) {
    return _definitionsByName.get(definitionName);
  }

  @Override
  public Set<String> getDefinitionNames() {
    return new TreeSet<String>(_definitionsByName.keySet());
  }
  
  //-------------------------------------------------------------------------
  // ManagableViewDefinitionRepository implementation
  @Override
  public boolean isModificationSupported() {
    return true;
  }
  
  @Override
  public void addViewDefinition(AddViewDefinitionRequest request) {
    Validate.notNull(request, "AddViewDefinitionRequest must not be null");
    request.checkValid();
    
    final ViewDefinition viewDefinition = request.getViewDefinition();
    _definitionsByName.put(viewDefinition.getName(), viewDefinition);
  }
  
  @Override
  public void updateViewDefinition(UpdateViewDefinitionRequest request) {
    Validate.notNull(request, "UpdateViewDefinitionRequest must not be null");
    request.checkValid();
    
    final String originalName = request.getName();
    if (originalName.equals(request.getViewDefinition().getName())) {
      // Same name - just replace
      if (_definitionsByName.replace(originalName, request.getViewDefinition()) == null) {
        throw new DataNotFoundException("View definition not found: " + originalName); 
      }
    } else {
      // Changing name - remove old, add new
      removeViewDefinition(originalName);
      addViewDefinition(new AddViewDefinitionRequest(request.getViewDefinition()));
    }
  }

  @Override
  public void removeViewDefinition(String name) {
    if (_definitionsByName.remove(name) == null) {
      throw new DataNotFoundException("View definition not found: " + name);
    }
  }

}
