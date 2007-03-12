/*
 * Copyright (c) 2000-2006 JetBrains s.r.o. All Rights Reserved.
 */

package com.intellij.facet;

import com.intellij.openapi.module.Module;
import com.intellij.util.messages.Topic;
import org.jetbrains.annotations.Nullable;

/**
 * @author nik
 */
public abstract class FacetManager implements FacetModel {
  public static final Topic<FacetManagerListener> FACETS_TOPIC = Topic.create("facet changes", FacetManagerListener.class);

  public static FacetManager getInstance(Module module) {
    return module.getComponent(FacetManager.class);
  }

  public abstract ModifiableFacetModel createModifiableModel();

  public abstract void createAndCommitFacets(final FacetInfo[] facetInfos);

  @Nullable
  public abstract <F extends Facet> F findFacet(FacetTypeId<F> type, String name);  
}
