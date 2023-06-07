package com.mibanco.ts.crearclientecdtdgital.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets TipoActividadCIIUEnum
 */
public enum TipoActividadCIIUEnum {
  
  _10("10"),
  
  _81("81"),
  
  _82("82"),
  
  _90("90"),
  
  _111("111"),
  
  _112("112"),
  
  _113("113"),
  
  _114("114"),
  
  _115("115"),
  
  _119("119"),
  
  _121("121");

  private String value;

  TipoActividadCIIUEnum(String value) {
    this.value = value;
  }

    /**
     * Convert a String into String, as specified in the
     * <a href="https://download.oracle.com/otndocs/jcp/jaxrs-2_0-fr-eval-spec/index.html">See JAX RS 2.0 Specification, section 3.2, p. 12</a>
     */
	public static TipoActividadCIIUEnum fromString(String s) {
      for (TipoActividadCIIUEnum b : TipoActividadCIIUEnum.values()) {
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
  public static TipoActividadCIIUEnum fromValue(String value) {
    for (TipoActividadCIIUEnum b : TipoActividadCIIUEnum.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}


