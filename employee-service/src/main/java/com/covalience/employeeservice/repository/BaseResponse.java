package com.covalience.employeeservice.repository;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * BaseResponse - base response for api responses
 */
@Data
public class BaseResponse<T> {
  private boolean success;
  private int code;
  private String message;
  private T data;

  /**
   * BaseResponse - BaseResponse Constructor function
   *
   * @param success - boolean
   * @param code - status code
   * @param message - Message
   * @param data - Actual response data
   */
  @JsonCreator
  public BaseResponse(
        @JsonProperty("success") boolean success,
        @JsonProperty("code") int code,
        @JsonProperty("message") String message,
        @JsonProperty("data") T data) {
    this.success = success;
    this.code = code;
    this.message = message;
    this.data = data;
  }
}
