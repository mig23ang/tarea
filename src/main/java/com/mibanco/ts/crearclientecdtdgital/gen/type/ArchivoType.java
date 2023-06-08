package com.mibanco.ts.crearclientecdtdgital.gen.type;

import java.util.ArrayList;
import java.util.List;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("ArchivoType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-06-08T15:11:50.656023300-05:00[America/Bogota]")
public class ArchivoType   {
  private @Valid String archivoId;
  private @Valid List<Integer> base64;
  private @Valid String extensionArchivo;
  private @Valid String nombreArchivo;
  private @Valid String url;
  private @Valid Boolean urlPublica;

  /**
   **/
  public ArchivoType archivoId(String archivoId) {
    this.archivoId = archivoId;
    return this;
  }

  
  @JsonProperty("archivoId")
  public String getArchivoId() {
    return archivoId;
  }

  @JsonProperty("archivoId")
  public void setArchivoId(String archivoId) {
    this.archivoId = archivoId;
  }

  /**
   **/
  public ArchivoType base64(List<Integer> base64) {
    this.base64 = base64;
    return this;
  }

  
  @JsonProperty("base64")
  public List<Integer> getBase64() {
    return base64;
  }

  @JsonProperty("base64")
  public void setBase64(List<Integer> base64) {
    this.base64 = base64;
  }

  public ArchivoType addBase64Item(Integer base64Item) {
    if (this.base64 == null) {
      this.base64 = new ArrayList<>();
    }

    this.base64.add(base64Item);
    return this;
  }

  public ArchivoType removeBase64Item(Integer base64Item) {
    if (base64Item != null && this.base64 != null) {
      this.base64.remove(base64Item);
    }

    return this;
  }
  /**
   **/
  public ArchivoType extensionArchivo(String extensionArchivo) {
    this.extensionArchivo = extensionArchivo;
    return this;
  }

  
  @JsonProperty("extensionArchivo")
  public String getExtensionArchivo() {
    return extensionArchivo;
  }

  @JsonProperty("extensionArchivo")
  public void setExtensionArchivo(String extensionArchivo) {
    this.extensionArchivo = extensionArchivo;
  }

  /**
   **/
  public ArchivoType nombreArchivo(String nombreArchivo) {
    this.nombreArchivo = nombreArchivo;
    return this;
  }

  
  @JsonProperty("nombreArchivo")
  public String getNombreArchivo() {
    return nombreArchivo;
  }

  @JsonProperty("nombreArchivo")
  public void setNombreArchivo(String nombreArchivo) {
    this.nombreArchivo = nombreArchivo;
  }

  /**
   **/
  public ArchivoType url(String url) {
    this.url = url;
    return this;
  }

  
  @JsonProperty("url")
  public String getUrl() {
    return url;
  }

  @JsonProperty("url")
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   **/
  public ArchivoType urlPublica(Boolean urlPublica) {
    this.urlPublica = urlPublica;
    return this;
  }

  
  @JsonProperty("urlPublica")
  public Boolean getUrlPublica() {
    return urlPublica;
  }

  @JsonProperty("urlPublica")
  public void setUrlPublica(Boolean urlPublica) {
    this.urlPublica = urlPublica;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ArchivoType archivoType = (ArchivoType) o;
    return Objects.equals(this.archivoId, archivoType.archivoId) &&
        Objects.equals(this.base64, archivoType.base64) &&
        Objects.equals(this.extensionArchivo, archivoType.extensionArchivo) &&
        Objects.equals(this.nombreArchivo, archivoType.nombreArchivo) &&
        Objects.equals(this.url, archivoType.url) &&
        Objects.equals(this.urlPublica, archivoType.urlPublica);
  }

  @Override
  public int hashCode() {
    return Objects.hash(archivoId, base64, extensionArchivo, nombreArchivo, url, urlPublica);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ArchivoType {\n");
    
    sb.append("    archivoId: ").append(toIndentedString(archivoId)).append("\n");
    sb.append("    base64: ").append(toIndentedString(base64)).append("\n");
    sb.append("    extensionArchivo: ").append(toIndentedString(extensionArchivo)).append("\n");
    sb.append("    nombreArchivo: ").append(toIndentedString(nombreArchivo)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    urlPublica: ").append(toIndentedString(urlPublica)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


}

