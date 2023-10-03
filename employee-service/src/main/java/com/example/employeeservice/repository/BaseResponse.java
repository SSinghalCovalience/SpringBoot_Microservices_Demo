package com.example.employeeservice.repository;

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
  public BaseResponse(boolean success, int code, String message, T data) {
    this.success = success;
    this.code = code;
    this.message = message;
    this.data = data;
  }
}
