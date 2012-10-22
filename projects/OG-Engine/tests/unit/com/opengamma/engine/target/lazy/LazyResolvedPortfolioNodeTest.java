/**
 * Copyright (C) 2012 - present by OpenGamma Inc. and the OpenGamma group of companies
 * 
 * Please see distribution for license.
 */
package com.opengamma.engine.target.lazy;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.testng.annotations.Test;

import com.opengamma.core.position.PortfolioNode;
import com.opengamma.core.position.impl.SimplePortfolioNode;
import com.opengamma.engine.DefaultCachingComputationTargetResolver;
import com.opengamma.engine.target.MockComputationTargetResolver;
import com.opengamma.engine.target.TargetResolverPortfolioNode;
import com.opengamma.id.UniqueId;
import com.opengamma.id.VersionCorrection;
import com.opengamma.util.ehcache.EHCacheUtils;

/**
 * Tests the {@link LazyResolvedPortfolioNode} class
 */
@Test
public class LazyResolvedPortfolioNodeTest {

  public void testBasicMethods() {
    final MockComputationTargetResolver resolver = MockComputationTargetResolver.resolved();
    final PortfolioNode underlying = resolver.getPositionSource().getPortfolioNode(UniqueId.of("Node", "0"), VersionCorrection.LATEST);
    final PortfolioNode node = new LazyResolvedPortfolioNode(new LazyResolveContext(resolver.getSecuritySource(), null).atVersionCorrection(VersionCorrection.LATEST), underlying);
    assertEquals(node.getName(), underlying.getName());
    assertEquals(node.getParentNodeId(), underlying.getParentNodeId());
    assertEquals(node.getUniqueId(), underlying.getUniqueId());
    assertEquals(node.getChildNodes().size(), underlying.getChildNodes().size());
    assertEquals(node.getPositions().size(), underlying.getPositions().size());
  }

  public void testSerialization_full() throws Exception {
    final MockComputationTargetResolver resolver = MockComputationTargetResolver.resolved();
    final PortfolioNode underlying = resolver.getPositionSource().getPortfolioNode(UniqueId.of("Node", "0"), VersionCorrection.LATEST);
    PortfolioNode node = new LazyResolvedPortfolioNode(new LazyResolveContext(resolver.getSecuritySource(), null).atVersionCorrection(VersionCorrection.LATEST), underlying);
    final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    new ObjectOutputStream(baos).writeObject(node);
    final Object resultObject = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray())).readObject();
    assertTrue(resultObject instanceof SimplePortfolioNode);
    node = (PortfolioNode) resultObject;
    assertEquals(node.getName(), underlying.getName());
    assertEquals(node.getChildNodes().size(), underlying.getChildNodes().size());
    assertEquals(node.getPositions().size(), underlying.getPositions().size());
  }

  public void testSerialization_targetResolver() throws Exception {
    final MockComputationTargetResolver resolver = MockComputationTargetResolver.resolved();
    final PortfolioNode underlying = resolver.getPositionSource().getPortfolioNode(UniqueId.of("Node", "0"), VersionCorrection.LATEST);
    PortfolioNode node = new LazyResolvedPortfolioNode(new LazyResolveContext(resolver.getSecuritySource(), new DefaultCachingComputationTargetResolver(resolver,
        EHCacheUtils.createCacheManager())).atVersionCorrection(VersionCorrection.LATEST), underlying);
    final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    new ObjectOutputStream(baos).writeObject(node);
    final Object resultObject = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray())).readObject();
    assertTrue(resultObject instanceof TargetResolverPortfolioNode);
    node = (PortfolioNode) resultObject;
    assertEquals(node.getName(), underlying.getName());
    assertEquals(node.getChildNodes().size(), underlying.getChildNodes().size());
    assertEquals(node.getPositions().size(), underlying.getPositions().size());
  }

}
