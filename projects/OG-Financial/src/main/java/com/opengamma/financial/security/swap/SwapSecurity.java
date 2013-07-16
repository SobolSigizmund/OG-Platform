/**
 * Copyright (C) 2009 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.financial.security.swap;

import java.util.Map;

import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;
import org.threeten.bp.ZonedDateTime;

import com.opengamma.financial.security.FinancialSecurity;
import com.opengamma.financial.security.FinancialSecurityVisitor;

/**
 * A security for a swap.
 */
@BeanDefinition
public class SwapSecurity extends FinancialSecurity {

  /** Serialization version. */
  private static final long serialVersionUID = 1L;

  /**
   * The security type.
   */
  public static final String SECURITY_TYPE = "SWAP";

  /**
   * The trade date.
   */
  @PropertyDefinition(validate = "notNull")
  private ZonedDateTime _tradeDate;
  /**
   * The effective date.
   */
  @PropertyDefinition(validate = "notNull")
  private ZonedDateTime _effectiveDate;
  /**
   * The maturity.
   */
  @PropertyDefinition(validate = "notNull")
  private ZonedDateTime _maturityDate;
  /**
   * The counterparty.
   */
  @PropertyDefinition(validate = "notNull")
  private String _counterparty;
  /**
   * The pay leg.
   */
  @PropertyDefinition(validate = "notNull")
  private SwapLeg _payLeg;
  /**
   * The receive leg.
   */
  @PropertyDefinition(validate = "notNull")
  private SwapLeg _receiveLeg;

  SwapSecurity() { //For builder
    super(SECURITY_TYPE);
  }

  /**
   * @param tradeDate The trade date, not null
   * @param effectiveDate The effective date, not null
   * @param maturityDate The maturity date, not null
   * @param counterparty The counterparty, not null
   * @param payLeg The pay leg, not null
   * @param receiveLeg The receive leg, not null
   */
  public SwapSecurity(final ZonedDateTime tradeDate, final ZonedDateTime effectiveDate, final ZonedDateTime maturityDate, final String counterparty, final SwapLeg payLeg, final SwapLeg receiveLeg) {
    super(SECURITY_TYPE);
    setTradeDate(tradeDate);
    setEffectiveDate(effectiveDate);
    setMaturityDate(maturityDate);
    setCounterparty(counterparty);
    setPayLeg(payLeg);
    setReceiveLeg(receiveLeg);
  }

  /**
   * For the builder - used by subclasses to set the correct security type.
   * @param securityType The security type, not null
   */
  /* package */SwapSecurity(final String securityType) {
    super(securityType);
  }
  /**
   * Used by subclasses to set the correct security type.
   * @param securityType The security type, not null
   * @param tradeDate The trade date, not null
   * @param effectiveDate The effective date, not null
   * @param maturityDate The maturity date, not null
   * @param counterparty The counterparty, not null
   * @param payLeg The pay leg, not null
   * @param receiveLeg The receive leg, not null
   */
  protected SwapSecurity(final String securityType, final ZonedDateTime tradeDate, final ZonedDateTime effectiveDate, final ZonedDateTime maturityDate, final String counterparty,
      final SwapLeg payLeg, final SwapLeg receiveLeg) {
    super(securityType);
    setTradeDate(tradeDate);
    setEffectiveDate(effectiveDate);
    setMaturityDate(maturityDate);
    setCounterparty(counterparty);
    setPayLeg(payLeg);
    setReceiveLeg(receiveLeg);
  }

  //-------------------------------------------------------------------------
  @Override
  public <T> T accept(final FinancialSecurityVisitor<T> visitor) {
    return visitor.visitSwapSecurity(this);
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code SwapSecurity}.
   * @return the meta-bean, not null
   */
  public static SwapSecurity.Meta meta() {
    return SwapSecurity.Meta.INSTANCE;
  }
  static {
    JodaBeanUtils.registerMetaBean(SwapSecurity.Meta.INSTANCE);
  }

  @Override
  public SwapSecurity.Meta metaBean() {
    return SwapSecurity.Meta.INSTANCE;
  }

  @Override
  protected Object propertyGet(String propertyName, boolean quiet) {
    switch (propertyName.hashCode()) {
      case 752419634:  // tradeDate
        return getTradeDate();
      case -930389515:  // effectiveDate
        return getEffectiveDate();
      case -414641441:  // maturityDate
        return getMaturityDate();
      case -1651301782:  // counterparty
        return getCounterparty();
      case -995239866:  // payLeg
        return getPayLeg();
      case 209233963:  // receiveLeg
        return getReceiveLeg();
    }
    return super.propertyGet(propertyName, quiet);
  }

  @Override
  protected void propertySet(String propertyName, Object newValue, boolean quiet) {
    switch (propertyName.hashCode()) {
      case 752419634:  // tradeDate
        setTradeDate((ZonedDateTime) newValue);
        return;
      case -930389515:  // effectiveDate
        setEffectiveDate((ZonedDateTime) newValue);
        return;
      case -414641441:  // maturityDate
        setMaturityDate((ZonedDateTime) newValue);
        return;
      case -1651301782:  // counterparty
        setCounterparty((String) newValue);
        return;
      case -995239866:  // payLeg
        setPayLeg((SwapLeg) newValue);
        return;
      case 209233963:  // receiveLeg
        setReceiveLeg((SwapLeg) newValue);
        return;
    }
    super.propertySet(propertyName, newValue, quiet);
  }

  @Override
  protected void validate() {
    JodaBeanUtils.notNull(_tradeDate, "tradeDate");
    JodaBeanUtils.notNull(_effectiveDate, "effectiveDate");
    JodaBeanUtils.notNull(_maturityDate, "maturityDate");
    JodaBeanUtils.notNull(_counterparty, "counterparty");
    JodaBeanUtils.notNull(_payLeg, "payLeg");
    JodaBeanUtils.notNull(_receiveLeg, "receiveLeg");
    super.validate();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      SwapSecurity other = (SwapSecurity) obj;
      return JodaBeanUtils.equal(getTradeDate(), other.getTradeDate()) &&
          JodaBeanUtils.equal(getEffectiveDate(), other.getEffectiveDate()) &&
          JodaBeanUtils.equal(getMaturityDate(), other.getMaturityDate()) &&
          JodaBeanUtils.equal(getCounterparty(), other.getCounterparty()) &&
          JodaBeanUtils.equal(getPayLeg(), other.getPayLeg()) &&
          JodaBeanUtils.equal(getReceiveLeg(), other.getReceiveLeg()) &&
          super.equals(obj);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash += hash * 31 + JodaBeanUtils.hashCode(getTradeDate());
    hash += hash * 31 + JodaBeanUtils.hashCode(getEffectiveDate());
    hash += hash * 31 + JodaBeanUtils.hashCode(getMaturityDate());
    hash += hash * 31 + JodaBeanUtils.hashCode(getCounterparty());
    hash += hash * 31 + JodaBeanUtils.hashCode(getPayLeg());
    hash += hash * 31 + JodaBeanUtils.hashCode(getReceiveLeg());
    return hash ^ super.hashCode();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the trade date.
   * @return the value of the property, not null
   */
  public ZonedDateTime getTradeDate() {
    return _tradeDate;
  }

  /**
   * Sets the trade date.
   * @param tradeDate  the new value of the property, not null
   */
  public void setTradeDate(ZonedDateTime tradeDate) {
    JodaBeanUtils.notNull(tradeDate, "tradeDate");
    this._tradeDate = tradeDate;
  }

  /**
   * Gets the the {@code tradeDate} property.
   * @return the property, not null
   */
  public final Property<ZonedDateTime> tradeDate() {
    return metaBean().tradeDate().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the effective date.
   * @return the value of the property, not null
   */
  public ZonedDateTime getEffectiveDate() {
    return _effectiveDate;
  }

  /**
   * Sets the effective date.
   * @param effectiveDate  the new value of the property, not null
   */
  public void setEffectiveDate(ZonedDateTime effectiveDate) {
    JodaBeanUtils.notNull(effectiveDate, "effectiveDate");
    this._effectiveDate = effectiveDate;
  }

  /**
   * Gets the the {@code effectiveDate} property.
   * @return the property, not null
   */
  public final Property<ZonedDateTime> effectiveDate() {
    return metaBean().effectiveDate().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the maturity.
   * @return the value of the property, not null
   */
  public ZonedDateTime getMaturityDate() {
    return _maturityDate;
  }

  /**
   * Sets the maturity.
   * @param maturityDate  the new value of the property, not null
   */
  public void setMaturityDate(ZonedDateTime maturityDate) {
    JodaBeanUtils.notNull(maturityDate, "maturityDate");
    this._maturityDate = maturityDate;
  }

  /**
   * Gets the the {@code maturityDate} property.
   * @return the property, not null
   */
  public final Property<ZonedDateTime> maturityDate() {
    return metaBean().maturityDate().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the counterparty.
   * @return the value of the property, not null
   */
  public String getCounterparty() {
    return _counterparty;
  }

  /**
   * Sets the counterparty.
   * @param counterparty  the new value of the property, not null
   */
  public void setCounterparty(String counterparty) {
    JodaBeanUtils.notNull(counterparty, "counterparty");
    this._counterparty = counterparty;
  }

  /**
   * Gets the the {@code counterparty} property.
   * @return the property, not null
   */
  public final Property<String> counterparty() {
    return metaBean().counterparty().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the pay leg.
   * @return the value of the property, not null
   */
  public SwapLeg getPayLeg() {
    return _payLeg;
  }

  /**
   * Sets the pay leg.
   * @param payLeg  the new value of the property, not null
   */
  public void setPayLeg(SwapLeg payLeg) {
    JodaBeanUtils.notNull(payLeg, "payLeg");
    this._payLeg = payLeg;
  }

  /**
   * Gets the the {@code payLeg} property.
   * @return the property, not null
   */
  public final Property<SwapLeg> payLeg() {
    return metaBean().payLeg().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the receive leg.
   * @return the value of the property, not null
   */
  public SwapLeg getReceiveLeg() {
    return _receiveLeg;
  }

  /**
   * Sets the receive leg.
   * @param receiveLeg  the new value of the property, not null
   */
  public void setReceiveLeg(SwapLeg receiveLeg) {
    JodaBeanUtils.notNull(receiveLeg, "receiveLeg");
    this._receiveLeg = receiveLeg;
  }

  /**
   * Gets the the {@code receiveLeg} property.
   * @return the property, not null
   */
  public final Property<SwapLeg> receiveLeg() {
    return metaBean().receiveLeg().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code SwapSecurity}.
   */
  public static class Meta extends FinancialSecurity.Meta {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code tradeDate} property.
     */
    private final MetaProperty<ZonedDateTime> _tradeDate = DirectMetaProperty.ofReadWrite(
        this, "tradeDate", SwapSecurity.class, ZonedDateTime.class);
    /**
     * The meta-property for the {@code effectiveDate} property.
     */
    private final MetaProperty<ZonedDateTime> _effectiveDate = DirectMetaProperty.ofReadWrite(
        this, "effectiveDate", SwapSecurity.class, ZonedDateTime.class);
    /**
     * The meta-property for the {@code maturityDate} property.
     */
    private final MetaProperty<ZonedDateTime> _maturityDate = DirectMetaProperty.ofReadWrite(
        this, "maturityDate", SwapSecurity.class, ZonedDateTime.class);
    /**
     * The meta-property for the {@code counterparty} property.
     */
    private final MetaProperty<String> _counterparty = DirectMetaProperty.ofReadWrite(
        this, "counterparty", SwapSecurity.class, String.class);
    /**
     * The meta-property for the {@code payLeg} property.
     */
    private final MetaProperty<SwapLeg> _payLeg = DirectMetaProperty.ofReadWrite(
        this, "payLeg", SwapSecurity.class, SwapLeg.class);
    /**
     * The meta-property for the {@code receiveLeg} property.
     */
    private final MetaProperty<SwapLeg> _receiveLeg = DirectMetaProperty.ofReadWrite(
        this, "receiveLeg", SwapSecurity.class, SwapLeg.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, (DirectMetaPropertyMap) super.metaPropertyMap(),
        "tradeDate",
        "effectiveDate",
        "maturityDate",
        "counterparty",
        "payLeg",
        "receiveLeg");

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 752419634:  // tradeDate
          return _tradeDate;
        case -930389515:  // effectiveDate
          return _effectiveDate;
        case -414641441:  // maturityDate
          return _maturityDate;
        case -1651301782:  // counterparty
          return _counterparty;
        case -995239866:  // payLeg
          return _payLeg;
        case 209233963:  // receiveLeg
          return _receiveLeg;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends SwapSecurity> builder() {
      return new DirectBeanBuilder<SwapSecurity>(new SwapSecurity());
    }

    @Override
    public Class<? extends SwapSecurity> beanType() {
      return SwapSecurity.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code tradeDate} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<ZonedDateTime> tradeDate() {
      return _tradeDate;
    }

    /**
     * The meta-property for the {@code effectiveDate} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<ZonedDateTime> effectiveDate() {
      return _effectiveDate;
    }

    /**
     * The meta-property for the {@code maturityDate} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<ZonedDateTime> maturityDate() {
      return _maturityDate;
    }

    /**
     * The meta-property for the {@code counterparty} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<String> counterparty() {
      return _counterparty;
    }

    /**
     * The meta-property for the {@code payLeg} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<SwapLeg> payLeg() {
      return _payLeg;
    }

    /**
     * The meta-property for the {@code receiveLeg} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<SwapLeg> receiveLeg() {
      return _receiveLeg;
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
