/**
 * Copyright (C) 2014 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.sesame.marketdata;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.ImmutableValidator;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;
import org.threeten.bp.ZonedDateTime;

import com.opengamma.sesame.marketdata.builders.MarketDataBuilder;
import com.opengamma.util.time.LocalDateRange;

/**
 * A requirement for a time series of market data.
 */
@BeanDefinition
public final class TimeSeriesRequirement extends MarketDataRequirement implements ImmutableBean {

  /** The ID of the market data in the time series. */
  @PropertyDefinition(validate = "notNull")
  private final MarketDataId _marketDataId;

  /** Time of the market data. This always has a type of {@code MARKET_DATA} and contains a {@code LocalDateRange}. */
  @PropertyDefinition(validate = "notNull")
  private final MarketDataTime _marketDataTime;

  /**
   * Creates a requirement for a time series of market data.
   *
   * @param marketDataId ID of the market data in the time series
   * @param dateRange date range of the time series
   * @return a requirement for a time series of market data
   */
  public static TimeSeriesRequirement of(MarketDataId<?> marketDataId, LocalDateRange dateRange) {
    return new TimeSeriesRequirement(marketDataId, MarketDataTime.of(dateRange));
  }

  @ImmutableValidator
  private void validate() {
    if (_marketDataTime.getType() != MarketDataTime.Type.TIME_SERIES) {
      throw new IllegalArgumentException("TimeSeriesRequirement.time must have a type of TIME_SERIES");
    }
  }

  @Override
  public Set<MarketDataRequirement> getRequirements(MarketDataBuilder builder,
                                                    ZonedDateTime valuationTime,
                                                    MarketDataEnvironment suppliedData) {
    return builder.getTimeSeriesRequirements(this, suppliedData.getTimeSeries().keySet());
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code TimeSeriesRequirement}.
   * @return the meta-bean, not null
   */
  public static TimeSeriesRequirement.Meta meta() {
    return TimeSeriesRequirement.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(TimeSeriesRequirement.Meta.INSTANCE);
  }

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static TimeSeriesRequirement.Builder builder() {
    return new TimeSeriesRequirement.Builder();
  }

  private TimeSeriesRequirement(
      MarketDataId marketDataId,
      MarketDataTime marketDataTime) {
    JodaBeanUtils.notNull(marketDataId, "marketDataId");
    JodaBeanUtils.notNull(marketDataTime, "marketDataTime");
    this._marketDataId = marketDataId;
    this._marketDataTime = marketDataTime;
    validate();
  }

  @Override
  public TimeSeriesRequirement.Meta metaBean() {
    return TimeSeriesRequirement.Meta.INSTANCE;
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
   * Gets the ID of the market data in the time series.
   * @return the value of the property, not null
   */
  public MarketDataId getMarketDataId() {
    return _marketDataId;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets time of the market data. This always has a type of {@code MARKET_DATA} and contains a {@code LocalDateRange}.
   * @return the value of the property, not null
   */
  public MarketDataTime getMarketDataTime() {
    return _marketDataTime;
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
      TimeSeriesRequirement other = (TimeSeriesRequirement) obj;
      return JodaBeanUtils.equal(getMarketDataId(), other.getMarketDataId()) &&
          JodaBeanUtils.equal(getMarketDataTime(), other.getMarketDataTime());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(getMarketDataId());
    hash = hash * 31 + JodaBeanUtils.hashCode(getMarketDataTime());
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(96);
    buf.append("TimeSeriesRequirement{");
    buf.append("marketDataId").append('=').append(getMarketDataId()).append(',').append(' ');
    buf.append("marketDataTime").append('=').append(JodaBeanUtils.toString(getMarketDataTime()));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code TimeSeriesRequirement}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code marketDataId} property.
     */
    private final MetaProperty<MarketDataId> _marketDataId = DirectMetaProperty.ofImmutable(
        this, "marketDataId", TimeSeriesRequirement.class, MarketDataId.class);
    /**
     * The meta-property for the {@code marketDataTime} property.
     */
    private final MetaProperty<MarketDataTime> _marketDataTime = DirectMetaProperty.ofImmutable(
        this, "marketDataTime", TimeSeriesRequirement.class, MarketDataTime.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "marketDataId",
        "marketDataTime");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case -530966079:  // marketDataId
          return _marketDataId;
        case 843042291:  // marketDataTime
          return _marketDataTime;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public TimeSeriesRequirement.Builder builder() {
      return new TimeSeriesRequirement.Builder();
    }

    @Override
    public Class<? extends TimeSeriesRequirement> beanType() {
      return TimeSeriesRequirement.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code marketDataId} property.
     * @return the meta-property, not null
     */
    public MetaProperty<MarketDataId> marketDataId() {
      return _marketDataId;
    }

    /**
     * The meta-property for the {@code marketDataTime} property.
     * @return the meta-property, not null
     */
    public MetaProperty<MarketDataTime> marketDataTime() {
      return _marketDataTime;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case -530966079:  // marketDataId
          return ((TimeSeriesRequirement) bean).getMarketDataId();
        case 843042291:  // marketDataTime
          return ((TimeSeriesRequirement) bean).getMarketDataTime();
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
   * The bean-builder for {@code TimeSeriesRequirement}.
   */
  public static final class Builder extends DirectFieldsBeanBuilder<TimeSeriesRequirement> {

    private MarketDataId _marketDataId;
    private MarketDataTime _marketDataTime;

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    private Builder(TimeSeriesRequirement beanToCopy) {
      this._marketDataId = beanToCopy.getMarketDataId();
      this._marketDataTime = beanToCopy.getMarketDataTime();
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case -530966079:  // marketDataId
          return _marketDataId;
        case 843042291:  // marketDataTime
          return _marketDataTime;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case -530966079:  // marketDataId
          this._marketDataId = (MarketDataId) newValue;
          break;
        case 843042291:  // marketDataTime
          this._marketDataTime = (MarketDataTime) newValue;
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
    public TimeSeriesRequirement build() {
      return new TimeSeriesRequirement(
          _marketDataId,
          _marketDataTime);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the {@code marketDataId} property in the builder.
     * @param marketDataId  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder marketDataId(MarketDataId marketDataId) {
      JodaBeanUtils.notNull(marketDataId, "marketDataId");
      this._marketDataId = marketDataId;
      return this;
    }

    /**
     * Sets the {@code marketDataTime} property in the builder.
     * @param marketDataTime  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder marketDataTime(MarketDataTime marketDataTime) {
      JodaBeanUtils.notNull(marketDataTime, "marketDataTime");
      this._marketDataTime = marketDataTime;
      return this;
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(96);
      buf.append("TimeSeriesRequirement.Builder{");
      buf.append("marketDataId").append('=').append(JodaBeanUtils.toString(_marketDataId)).append(',').append(' ');
      buf.append("marketDataTime").append('=').append(JodaBeanUtils.toString(_marketDataTime));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
