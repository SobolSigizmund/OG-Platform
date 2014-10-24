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
import org.joda.beans.BeanBuilder;
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
import org.threeten.bp.LocalDate;
import org.threeten.bp.ZonedDateTime;

import com.opengamma.util.time.LocalDateRange;

/**
 * Represents the time at which a piece of market data is valid.
 * TODO I'm not keen on the design of this, revisit. particularly the time series
 */
@BeanDefinition(builderScope = "private")
public final class MarketDataTime implements ImmutableBean {

  static final MarketDataTime VALUATION_TIME = new MarketDataTime(null, null, null, Type.VALUATION_TIME);

  /** Indicates the type of the time. */
  public enum Type {
    /** The data is valid for the valuation time. */
    VALUATION_TIME,
    /** The data is valid for a whole day. */
    DATE,
    /** The data is valid for a single instant. */
    TIME,
    /** The data is valid for a series of dates. */
    TIME_SERIES
  }

  /** The time for which the data is valid, null unless the type is {@link Type#TIME}. */
  @PropertyDefinition
  private final ZonedDateTime _time;

  /** The date for which the data is valid, null unless the type is {@link Type#DATE}. */
  @PropertyDefinition
  private final LocalDate _date;

  /** The date range for which the data is valid, null unless the type is {@link Type#TIME_SERIES}. */
  @PropertyDefinition
  private final LocalDateRange _dateRange;

  /** Type of the market data time - indicates which of the time fields is populated. */
  @PropertyDefinition(validate = "notNull")
  private final Type _type;

  @ImmutableConstructor
  private MarketDataTime(ZonedDateTime time,
                         LocalDate date,
                         LocalDateRange dateRange,
                         Type type) {
    _time = time;
    _date = date;
    _dateRange = dateRange;
    _type = type;
  }

  /**
   * Creates an instance for data valid at a specific time.
   *
   * @param time the time at which the data is valid
   * @return the market data time for the time
   */
  static MarketDataTime of(ZonedDateTime time) {
    return new MarketDataTime(time, null, null, Type.TIME);
  }

  /**
   * Creates an instance for data valid on a specific date.
   *
   * @param date the date on which the data is valid
   * @return the market data time for the date
   */
  static MarketDataTime of(LocalDate date) {
    return new MarketDataTime(null, date, null, Type.DATE);
  }

  /**
   * Creates an instance for data valid over a range of dates.
   *
   * @param dateRange the date range over which the data is valid
   * @return the market data time for the date range
   */
  static MarketDataTime of(LocalDateRange dateRange) {
    return new MarketDataTime(null, null, dateRange, Type.TIME_SERIES);
  }
  
  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code MarketDataTime}.
   * @return the meta-bean, not null
   */
  public static MarketDataTime.Meta meta() {
    return MarketDataTime.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(MarketDataTime.Meta.INSTANCE);
  }

  @Override
  public MarketDataTime.Meta metaBean() {
    return MarketDataTime.Meta.INSTANCE;
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
   * Gets the time for which the data is valid, null unless the type is {@link Type#TIME}.
   * @return the value of the property
   */
  public ZonedDateTime getTime() {
    return _time;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the date for which the data is valid, null unless the type is {@link Type#DATE}.
   * @return the value of the property
   */
  public LocalDate getDate() {
    return _date;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the date range for which the data is valid, null unless the type is {@link Type#TIME_SERIES}.
   * @return the value of the property
   */
  public LocalDateRange getDateRange() {
    return _dateRange;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets type of the market data time - indicates which of the time fields is populated.
   * @return the value of the property, not null
   */
  public Type getType() {
    return _type;
  }

  //-----------------------------------------------------------------------
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      MarketDataTime other = (MarketDataTime) obj;
      return JodaBeanUtils.equal(getTime(), other.getTime()) &&
          JodaBeanUtils.equal(getDate(), other.getDate()) &&
          JodaBeanUtils.equal(getDateRange(), other.getDateRange()) &&
          JodaBeanUtils.equal(getType(), other.getType());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash += hash * 31 + JodaBeanUtils.hashCode(getTime());
    hash += hash * 31 + JodaBeanUtils.hashCode(getDate());
    hash += hash * 31 + JodaBeanUtils.hashCode(getDateRange());
    hash += hash * 31 + JodaBeanUtils.hashCode(getType());
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(160);
    buf.append("MarketDataTime{");
    buf.append("time").append('=').append(getTime()).append(',').append(' ');
    buf.append("date").append('=').append(getDate()).append(',').append(' ');
    buf.append("dateRange").append('=').append(getDateRange()).append(',').append(' ');
    buf.append("type").append('=').append(JodaBeanUtils.toString(getType()));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code MarketDataTime}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code time} property.
     */
    private final MetaProperty<ZonedDateTime> _time = DirectMetaProperty.ofImmutable(
        this, "time", MarketDataTime.class, ZonedDateTime.class);
    /**
     * The meta-property for the {@code date} property.
     */
    private final MetaProperty<LocalDate> _date = DirectMetaProperty.ofImmutable(
        this, "date", MarketDataTime.class, LocalDate.class);
    /**
     * The meta-property for the {@code dateRange} property.
     */
    private final MetaProperty<LocalDateRange> _dateRange = DirectMetaProperty.ofImmutable(
        this, "dateRange", MarketDataTime.class, LocalDateRange.class);
    /**
     * The meta-property for the {@code type} property.
     */
    private final MetaProperty<Type> _type = DirectMetaProperty.ofImmutable(
        this, "type", MarketDataTime.class, Type.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "time",
        "date",
        "dateRange",
        "type");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 3560141:  // time
          return _time;
        case 3076014:  // date
          return _date;
        case -261425617:  // dateRange
          return _dateRange;
        case 3575610:  // type
          return _type;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends MarketDataTime> builder() {
      return new MarketDataTime.Builder();
    }

    @Override
    public Class<? extends MarketDataTime> beanType() {
      return MarketDataTime.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code time} property.
     * @return the meta-property, not null
     */
    public MetaProperty<ZonedDateTime> time() {
      return _time;
    }

    /**
     * The meta-property for the {@code date} property.
     * @return the meta-property, not null
     */
    public MetaProperty<LocalDate> date() {
      return _date;
    }

    /**
     * The meta-property for the {@code dateRange} property.
     * @return the meta-property, not null
     */
    public MetaProperty<LocalDateRange> dateRange() {
      return _dateRange;
    }

    /**
     * The meta-property for the {@code type} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Type> type() {
      return _type;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 3560141:  // time
          return ((MarketDataTime) bean).getTime();
        case 3076014:  // date
          return ((MarketDataTime) bean).getDate();
        case -261425617:  // dateRange
          return ((MarketDataTime) bean).getDateRange();
        case 3575610:  // type
          return ((MarketDataTime) bean).getType();
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
   * The bean-builder for {@code MarketDataTime}.
   */
  private static final class Builder extends DirectFieldsBeanBuilder<MarketDataTime> {

    private ZonedDateTime _time;
    private LocalDate _date;
    private LocalDateRange _dateRange;
    private Type _type;

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case 3560141:  // time
          return _time;
        case 3076014:  // date
          return _date;
        case -261425617:  // dateRange
          return _dateRange;
        case 3575610:  // type
          return _type;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case 3560141:  // time
          this._time = (ZonedDateTime) newValue;
          break;
        case 3076014:  // date
          this._date = (LocalDate) newValue;
          break;
        case -261425617:  // dateRange
          this._dateRange = (LocalDateRange) newValue;
          break;
        case 3575610:  // type
          this._type = (Type) newValue;
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
    public MarketDataTime build() {
      return new MarketDataTime(
          _time,
          _date,
          _dateRange,
          _type);
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(160);
      buf.append("MarketDataTime.Builder{");
      buf.append("time").append('=').append(JodaBeanUtils.toString(_time)).append(',').append(' ');
      buf.append("date").append('=').append(JodaBeanUtils.toString(_date)).append(',').append(' ');
      buf.append("dateRange").append('=').append(JodaBeanUtils.toString(_dateRange)).append(',').append(' ');
      buf.append("type").append('=').append(JodaBeanUtils.toString(_type));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
