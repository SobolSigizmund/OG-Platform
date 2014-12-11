/**
 * Copyright (C) 2014 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.sesame;


import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.ImmutableConstructor;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.analytics.financial.provider.curve.CurveBuildingBlockBundle;
import com.opengamma.analytics.financial.provider.description.interestrate.MulticurveProviderDiscount;
import com.opengamma.util.ArgumentChecker;

/**
 * Simple wrapper class holding the results of a multicurve calibration.
 */
@BeanDefinition
public final class MulticurveBundle implements ImmutableBean {

  /**
   * The calibrated multicurves.
   */
  @PropertyDefinition(validate = "notNull")
  private final MulticurveProviderDiscount _multicurveProvider;

  /**
   * The curve building blocks used to calibrate the curves.
   */
  @PropertyDefinition(validate = "notNull")
  private final CurveBuildingBlockBundle _curveBuildingBlockBundle;

  @ImmutableConstructor
  public MulticurveBundle(MulticurveProviderDiscount multicurveProvider,
                          CurveBuildingBlockBundle curveBuildingBlockBundle) {
    _multicurveProvider = ArgumentChecker.notNull(multicurveProvider, "multicurveProvider");
    _curveBuildingBlockBundle = ArgumentChecker.notNull(curveBuildingBlockBundle, "curveBuildingBlockBundle");
  }
  
  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code MulticurveBundle}.
   * @return the meta-bean, not null
   */
  public static MulticurveBundle.Meta meta() {
    return MulticurveBundle.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(MulticurveBundle.Meta.INSTANCE);
  }

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static MulticurveBundle.Builder builder() {
    return new MulticurveBundle.Builder();
  }

  @Override
  public MulticurveBundle.Meta metaBean() {
    return MulticurveBundle.Meta.INSTANCE;
  }

  @Override
  public <R> Property<R> property(String propertyName) {
    return metaBean().<R>metaProperty(propertyName).createProperty(this);
  }

  @Override
  public Set<String> propertyNames() {
    return metaBean().metaPropertyMap().keySet();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the calibrated multicurves.
   * @return the value of the property, not null
   */
  public MulticurveProviderDiscount getMulticurveProvider() {
    return _multicurveProvider;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the curve building blocks used to calibrate the curves.
   * @return the value of the property, not null
   */
  public CurveBuildingBlockBundle getCurveBuildingBlockBundle() {
    return _curveBuildingBlockBundle;
  }

  //-----------------------------------------------------------------------
  /**
   * Returns a builder that allows this bean to be mutated.
   * @return the mutable builder, not null
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      MulticurveBundle other = (MulticurveBundle) obj;
      return JodaBeanUtils.equal(getMulticurveProvider(), other.getMulticurveProvider()) &&
          JodaBeanUtils.equal(getCurveBuildingBlockBundle(), other.getCurveBuildingBlockBundle());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(getMulticurveProvider());
    hash = hash * 31 + JodaBeanUtils.hashCode(getCurveBuildingBlockBundle());
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(96);
    buf.append("MulticurveBundle{");
    buf.append("multicurveProvider").append('=').append(getMulticurveProvider()).append(',').append(' ');
    buf.append("curveBuildingBlockBundle").append('=').append(JodaBeanUtils.toString(getCurveBuildingBlockBundle()));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code MulticurveBundle}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code multicurveProvider} property.
     */
    private final MetaProperty<MulticurveProviderDiscount> _multicurveProvider = DirectMetaProperty.ofImmutable(
        this, "multicurveProvider", MulticurveBundle.class, MulticurveProviderDiscount.class);
    /**
     * The meta-property for the {@code curveBuildingBlockBundle} property.
     */
    private final MetaProperty<CurveBuildingBlockBundle> _curveBuildingBlockBundle = DirectMetaProperty.ofImmutable(
        this, "curveBuildingBlockBundle", MulticurveBundle.class, CurveBuildingBlockBundle.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "multicurveProvider",
        "curveBuildingBlockBundle");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 87636839:  // multicurveProvider
          return _multicurveProvider;
        case 1604389548:  // curveBuildingBlockBundle
          return _curveBuildingBlockBundle;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public MulticurveBundle.Builder builder() {
      return new MulticurveBundle.Builder();
    }

    @Override
    public Class<? extends MulticurveBundle> beanType() {
      return MulticurveBundle.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code multicurveProvider} property.
     * @return the meta-property, not null
     */
    public MetaProperty<MulticurveProviderDiscount> multicurveProvider() {
      return _multicurveProvider;
    }

    /**
     * The meta-property for the {@code curveBuildingBlockBundle} property.
     * @return the meta-property, not null
     */
    public MetaProperty<CurveBuildingBlockBundle> curveBuildingBlockBundle() {
      return _curveBuildingBlockBundle;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 87636839:  // multicurveProvider
          return ((MulticurveBundle) bean).getMulticurveProvider();
        case 1604389548:  // curveBuildingBlockBundle
          return ((MulticurveBundle) bean).getCurveBuildingBlockBundle();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      metaProperty(propertyName);
      if (quiet) {
        return;
      }
      throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
    }

  }

  //-----------------------------------------------------------------------
  /**
   * The bean-builder for {@code MulticurveBundle}.
   */
  public static final class Builder extends DirectFieldsBeanBuilder<MulticurveBundle> {

    private MulticurveProviderDiscount _multicurveProvider;
    private CurveBuildingBlockBundle _curveBuildingBlockBundle;

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    private Builder(MulticurveBundle beanToCopy) {
      this._multicurveProvider = beanToCopy.getMulticurveProvider();
      this._curveBuildingBlockBundle = beanToCopy.getCurveBuildingBlockBundle();
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case 87636839:  // multicurveProvider
          return _multicurveProvider;
        case 1604389548:  // curveBuildingBlockBundle
          return _curveBuildingBlockBundle;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case 87636839:  // multicurveProvider
          this._multicurveProvider = (MulticurveProviderDiscount) newValue;
          break;
        case 1604389548:  // curveBuildingBlockBundle
          this._curveBuildingBlockBundle = (CurveBuildingBlockBundle) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public Builder set(MetaProperty<?> property, Object value) {
      super.set(property, value);
      return this;
    }

    @Override
    public Builder setString(String propertyName, String value) {
      setString(meta().metaProperty(propertyName), value);
      return this;
    }

    @Override
    public Builder setString(MetaProperty<?> property, String value) {
      super.setString(property, value);
      return this;
    }

    @Override
    public Builder setAll(Map<String, ? extends Object> propertyValueMap) {
      super.setAll(propertyValueMap);
      return this;
    }

    @Override
    public MulticurveBundle build() {
      return new MulticurveBundle(
          _multicurveProvider,
          _curveBuildingBlockBundle);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the {@code multicurveProvider} property in the builder.
     * @param multicurveProvider  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder multicurveProvider(MulticurveProviderDiscount multicurveProvider) {
      JodaBeanUtils.notNull(multicurveProvider, "multicurveProvider");
      this._multicurveProvider = multicurveProvider;
      return this;
    }

    /**
     * Sets the {@code curveBuildingBlockBundle} property in the builder.
     * @param curveBuildingBlockBundle  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder curveBuildingBlockBundle(CurveBuildingBlockBundle curveBuildingBlockBundle) {
      JodaBeanUtils.notNull(curveBuildingBlockBundle, "curveBuildingBlockBundle");
      this._curveBuildingBlockBundle = curveBuildingBlockBundle;
      return this;
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(96);
      buf.append("MulticurveBundle.Builder{");
      buf.append("multicurveProvider").append('=').append(JodaBeanUtils.toString(_multicurveProvider)).append(',').append(' ');
      buf.append("curveBuildingBlockBundle").append('=').append(JodaBeanUtils.toString(_curveBuildingBlockBundle));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
