/**
 * Copyright (C) 2014 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */

package com.opengamma.financial.analytics.model.fixedincome;

import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.PropertyDefinition;

import com.google.common.collect.ImmutableMap;
import com.opengamma.financial.analytics.DoubleLabelledMatrix1D;
import com.opengamma.util.money.Currency;
import com.opengamma.util.tuple.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.joda.beans.Bean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

/**
 * The sensitivities of an instrument to a set of curves.
 */
@BeanDefinition
public class BucketedCurveSensitivities implements ImmutableBean {

  @PropertyDefinition(validate = "notNull")
  private final Map<Pair<String, Currency>, DoubleLabelledMatrix1D> _sensitivities;

  public static BucketedCurveSensitivities of(Map<Pair<String, Currency>, DoubleLabelledMatrix1D> sensitivities) {
    return builder().sensitivities(sensitivities).build();
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code YieldCurveNodeSensitivities}.
   * @return the meta-bean, not null
   */
  public static BucketedCurveSensitivities.Meta meta() {
    return BucketedCurveSensitivities.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(BucketedCurveSensitivities.Meta.INSTANCE);
  }

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static BucketedCurveSensitivities.Builder builder() {
    return new BucketedCurveSensitivities.Builder();
  }

  /**
   * Restricted constructor.
   * @param builder  the builder to copy from, not null
   */
  protected BucketedCurveSensitivities(BucketedCurveSensitivities.Builder builder) {
    JodaBeanUtils.notNull(builder._sensitivities, "sensitivities");
    this._sensitivities = ImmutableMap.copyOf(builder._sensitivities);
  }

  @Override
  public BucketedCurveSensitivities.Meta metaBean() {
    return BucketedCurveSensitivities.Meta.INSTANCE;
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
   * Gets the sensitivities.
   * @return the value of the property, not null
   */
  public Map<Pair<String, Currency>, DoubleLabelledMatrix1D> getSensitivities() {
    return _sensitivities;
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
  public BucketedCurveSensitivities clone() {
    return this;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      BucketedCurveSensitivities other = (BucketedCurveSensitivities) obj;
      return JodaBeanUtils.equal(getSensitivities(), other.getSensitivities());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash += hash * 31 + JodaBeanUtils.hashCode(getSensitivities());
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(64);
    buf.append("YieldCurveNodeSensitivities{");
    int len = buf.length();
    toString(buf);
    if (buf.length() > len) {
      buf.setLength(buf.length() - 2);
    }
    buf.append('}');
    return buf.toString();
  }

  protected void toString(StringBuilder buf) {
    buf.append("sensitivities").append('=').append(JodaBeanUtils.toString(getSensitivities())).append(',').append(' ');
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code YieldCurveNodeSensitivities}.
   */
  public static class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code sensitivities} property.
     */
    @SuppressWarnings({"unchecked", "rawtypes" })
    private final MetaProperty<Map<Pair<String, Currency>, DoubleLabelledMatrix1D>> _sensitivities = DirectMetaProperty.ofImmutable(
        this, "sensitivities", BucketedCurveSensitivities.class, (Class) Map.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "sensitivities");

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 1226228605:  // sensitivities
          return _sensitivities;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BucketedCurveSensitivities.Builder builder() {
      return new BucketedCurveSensitivities.Builder();
    }

    @Override
    public Class<? extends BucketedCurveSensitivities> beanType() {
      return BucketedCurveSensitivities.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code sensitivities} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<Map<Pair<String, Currency>, DoubleLabelledMatrix1D>> sensitivities() {
      return _sensitivities;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 1226228605:  // sensitivities
          return ((BucketedCurveSensitivities) bean).getSensitivities();
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
   * The bean-builder for {@code YieldCurveNodeSensitivities}.
   */
  public static class Builder extends DirectFieldsBeanBuilder<BucketedCurveSensitivities> {

    private Map<Pair<String, Currency>, DoubleLabelledMatrix1D> _sensitivities = new HashMap<Pair<String, Currency>, DoubleLabelledMatrix1D>();

    /**
     * Restricted constructor.
     */
    protected Builder() {
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    protected Builder(BucketedCurveSensitivities beanToCopy) {
      this._sensitivities = new HashMap<Pair<String, Currency>, DoubleLabelledMatrix1D>(beanToCopy.getSensitivities());
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case 1226228605:  // sensitivities
          return _sensitivities;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case 1226228605:  // sensitivities
          this._sensitivities = (Map<Pair<String, Currency>, DoubleLabelledMatrix1D>) newValue;
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
      super.set(property, value);
      return this;
    }

    @Override
    public Builder setAll(Map<String, ? extends Object> propertyValueMap) {
      super.setAll(propertyValueMap);
      return this;
    }

    @Override
    public BucketedCurveSensitivities build() {
      return new BucketedCurveSensitivities(this);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the {@code sensitivities} property in the builder.
     * @param sensitivities  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder sensitivities(Map<Pair<String, Currency>, DoubleLabelledMatrix1D> sensitivities) {
      JodaBeanUtils.notNull(sensitivities, "sensitivities");
      this._sensitivities = sensitivities;
      return this;
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(64);
      buf.append("YieldCurveNodeSensitivities.Builder{");
      int len = buf.length();
      toString(buf);
      if (buf.length() > len) {
        buf.setLength(buf.length() - 2);
      }
      buf.append('}');
      return buf.toString();
    }

    protected void toString(StringBuilder buf) {
      buf.append("sensitivities").append('=').append(JodaBeanUtils.toString(_sensitivities)).append(',').append(' ');
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
