package com.mibanco.ts.crearclientecdtdgital.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets SectorEconomicoEnum
 */
public enum SectorEconomicoEnum {
  
  _1("1"),
  
  _2("2"),
  
  _3("3"),
  
  _4("4"),
  
  _5("5"),
  
  _6("6");

  private String value;

  SectorEconomicoEnum(String value) {
    this.value = value;
  }

    /**
     * Convert a String into String, as specified in the
     * <a href="https://download.oracle.com/otndocs/jcp/jaxrs-2_0-fr-eval-spec/index.html">See JAX RS 2.0 Specification, section 3.2, p. 12</a>
     */
	public static SectorEconomicoEnum fromString(String s) {
      for (SectorEconomicoEnum b : SectorEconomicoEnum.values()) {
        // using Objects.toString() to be safe if value type non-object type
        // because types like 'int' etc. will be auto-boxed
        if (java.util.Objects.toString(b.value).equals(s)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected string value '" + s + "'");
	}
	
  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static SectorEconomicoEnum fromValue(String value) {
    for (SectorEconomicoEnum b : SectorEconomicoEnum.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}


